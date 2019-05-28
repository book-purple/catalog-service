package com.bookpurple.catalog.util;

import com.bookpurple.catalog.constant.Constants;
import com.bookpurple.catalog.model.HttpPostResponse;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
@Component
public class HttpClientCaller {

    @Value(value = "${vendor.service.hostname}")
    private String hostname;

    @Value(value = "${access.token}")
    private String accesToken;

    private static int serviceMaxConnections = 1000;

    private static int maxDefaultPerRoute = 800;

    private static int defaultAliveDur = 3000;

    private static int defaultAliveDurExternalAPI = 15000;

    private static int defaultAliveDurExternalPostAPI = 30000;

    private static int defaultAliveDurInternalPostAPI = 5000;

    private static int retryInterval = 1000;

    private static int executionCountMax = 3;

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientCaller.class);

    private static final PoolingHttpClientConnectionManager cm =
            new PoolingHttpClientConnectionManager();
    private static CloseableHttpClient httpclient = null;
    private static CloseableHttpClient httpclientWithRetry = null;

    static {
        cm.setMaxTotal(serviceMaxConnections);
        cm.setDefaultMaxPerRoute(maxDefaultPerRoute);
        ConnectionKeepAliveStrategy keepAlive = new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                HeaderElementIterator it =
                        new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase("timeout")) {
                        return Long.parseLong(value) * 1000;
                    }
                }
                return defaultAliveDur;
            }
        };
        httpclient = HttpClients.custom().setConnectionManager(cm).setKeepAliveStrategy(keepAlive)
                .build();
        httpclientWithRetry = HttpClients.custom()
                .setServiceUnavailableRetryStrategy(new ServiceUnavailableRetryStrategy() {
                    public boolean retryRequest(final HttpResponse response, final int executionCount,
                                                final HttpContext context) {
                        int statusCode = response.getStatusLine().getStatusCode();
                        return !(statusCode >= 200 && statusCode <= 299) && !(statusCode >= 400
                                && statusCode <= 499) && executionCount < executionCountMax;
                    }

                    public long getRetryInterval() {
                        return retryInterval;
                    }
                }).setConnectionManager(cm).setKeepAliveStrategy(keepAlive).build();
    }

    /**
     * Http get api call string.
     *
     * @param serviceHostname the service hostname
     * @param requestUrl      the request url
     * @param userAccesToken  the user acces token
     * @param throw503        the throw 503
     * @return the string
     */
    public HttpPostResponse httpGetApiCallInternal(String serviceHostname, String requestUrl,
                                                   String userAccesToken, Boolean throw503) throws Exception {
        return httpGetApiCall(serviceHostname, requestUrl, userAccesToken, throw503, null,
                defaultAliveDur, true);
    }

    /**
     * Http get api call string.
     *
     * @param serviceHostname the service hostname
     * @param requestUrl      the request url
     * @param customHeaders   the custom headers
     * @param serviceTimeout  timeout value
     * @return the string
     */
    public HttpPostResponse httpGetApiCallExternal(String serviceHostname, String requestUrl,
                                                   Map<String, String> customHeaders, Integer serviceTimeout)
            throws Exception {
        if (null == serviceTimeout) {
            serviceTimeout = defaultAliveDurExternalAPI;
        }
        return httpGetApiCall(serviceHostname, requestUrl, null,
                true, customHeaders, serviceTimeout, false);
    }

    /**
     * Http get api call string.
     *
     * @param serviceHostname the service hostname
     * @param requestUrl      the request url
     * @param userAccesToken  the user acces token
     * @param throw503        the throw 503
     * @param customHeaders   the custom headers
     * @param timeout         timeout value
     * @param isInternal      internal flag
     * @return the string
     */
    public HttpPostResponse httpGetApiCall(String serviceHostname, String requestUrl,
                                           String userAccesToken, Boolean throw503, Map<String, String> customHeaders,
                                           Integer timeout, Boolean isInternal)
            throws IOException {
        HttpPostResponse getResponse = new HttpPostResponse();
        if (null == timeout) {
            timeout = defaultAliveDur;
        }
        if (null == serviceHostname) {
            serviceHostname = hostname;
        }
        HttpGet httpget = new HttpGet(serviceHostname + requestUrl);
        RequestConfig requestConfig =
                RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
        httpget.setConfig(requestConfig);
        if (isInternal) {
            if (userAccesToken == null) {
                userAccesToken = accesToken;
            }
            httpget.setHeader(Constants.SecurityConstants.X_GBP_AUTH, userAccesToken);
        }
        if (null != customHeaders && !customHeaders.isEmpty()) {
            for (String header : customHeaders.keySet()) {
                httpget.setHeader(header, customHeaders.get(header));
            }
        }
        LOGGER.info("Service : " + serviceHostname + requestUrl);
        LOGGER
                .info("******* Helpchat Auth Token : " + userAccesToken + " Access Token : " + accesToken);
        CloseableHttpResponse response = null;
        try {
            response = httpclientWithRetry.execute(httpget);
            LOGGER.info("Leased Connections:" + cm.getTotalStats().getLeased());
            LOGGER.info(serviceHostname + requestUrl + " service Response:"
                    + response.getStatusLine().getStatusCode());
            getResponse.setResponse(EntityUtils.toString(response.getEntity()));
            getResponse.setStatus(HttpStatus.valueOf(response.getStatusLine().getStatusCode()));
            if (response.getStatusLine().getStatusCode() != HttpStatus.OK.value() && throw503) {
                return null;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException ioe) {
                LOGGER.error("Error occured in get API call : ", ioe);
            }
        }
        return getResponse;
    }

    /**
     * Http put api call string.
     *
     * @param serviceHostname   the service hostname
     * @param requestUrl        the request url
     * @param requestParams     the request params
     * @param helpchatAuthToken the helpchat auth token
     * @param requestBody       the request body
     * @return the string
     */
    public HttpPostResponse httpPutApiCall(String serviceHostname, String requestUrl,
                                           Map<String, String> requestParams, String helpchatAuthToken, String requestBody)
            throws Exception {
        String output = null;
        HttpPostResponse httpPutResponse = new HttpPostResponse();
        URIBuilder uriBuilder = null;
        if (null == serviceHostname) {
            serviceHostname = hostname;
        }
        try {
            uriBuilder = new URIBuilder(serviceHostname + requestUrl);
            if (null != requestParams && requestParams.size() != 0) {
                for (String param : requestParams.keySet()) {
                    uriBuilder.addParameter(param, requestParams.get(param));
                }
            }
            HttpPut httpPut = new HttpPut(uriBuilder.build());
            if (null != helpchatAuthToken) {
                httpPut.setHeader(Constants.SecurityConstants.X_GBP_AUTH, helpchatAuthToken);
            } else {
                httpPut.setHeader(Constants.SecurityConstants.X_GBP_AUTH, accesToken);
            }
            StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            httpPut.setEntity(stringEntity);
            HttpResponse response;
            response = httpclient.execute(httpPut);
            if (null != response.getEntity()) {
                output = EntityUtils.toString(response.getEntity());
                httpPutResponse.setResponse(output);
            }
            LOGGER.info("Service : " + serviceHostname + requestUrl);
            LOGGER.info("Service Response:" + response.getStatusLine().getStatusCode() + ",requestBody:"
                    + requestBody);
            LOGGER.info(
                    "******* Helpchat Auth Token : " + helpchatAuthToken + " Access Token : " + accesToken);
            httpPutResponse.setStatus(HttpStatus.valueOf(response.getStatusLine().getStatusCode()));
            if (response.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
                LOGGER.error("Bad Response Code :" + requestUrl + " "
                        + response.getStatusLine().getStatusCode() + output);
            }
        } catch (Exception ex) {
            LOGGER.error("Error in call to Service:" + serviceHostname + requestUrl, ex);
            throw ex;
        }
        return httpPutResponse;
    }


    /**
     * Http post api method for internal calls.
     *
     * @param serviceHostname   the service hostname
     * @param requestUrl        the request url
     * @param helpchatAuthToken the helpchat auth token
     * @param requestBody       the request body
     * @param customHeaders     the request headers
     * @param withRetry         flag to determine retrial
     * @return the http post response
     */
    public HttpPostResponse httpPostInternalApiCall(String serviceHostname, String requestUrl,
                                                    String helpchatAuthToken, String requestBody, Map<String, String> customHeaders,
                                                    Boolean withRetry)
            throws Exception {
        return httpPostApiCall(serviceHostname,
                requestUrl,
                null,
                helpchatAuthToken,
                requestBody,
                customHeaders,
                defaultAliveDurInternalPostAPI,
                true, withRetry);
    }


    /**
     * Http post api method for external calls.
     *
     * @param serviceHostname the service hostname
     * @param requestUrl      the request url
     * @param requestBody     the request body
     * @param customHeaders   the request headers
     * @param serviceTimeout  timeout value
     * @param withRetry       flag to determine retrial
     * @return the http post response
     */
    public HttpPostResponse httpPostExternalApiCall(String serviceHostname, String requestUrl,
                                                    String requestBody, Map<String, String> customHeaders,
                                                    Integer serviceTimeout,
                                                    Boolean withRetry)
            throws Exception {
        if (null == serviceTimeout) {
            serviceTimeout = defaultAliveDurExternalPostAPI;
        }
        return httpPostApiCall(serviceHostname, requestUrl, null, null,
                requestBody, customHeaders, serviceTimeout, false, withRetry);
    }


    /**
     * Http post api method for external calls.
     *
     * @param serviceHostname   the service hostname
     * @param requestUrl        the request url
     * @param requestParams     the request params
     * @param helpchatAuthToken the auth token
     * @param requestBody       the request body
     * @param requestHeaders    the request headers
     * @param timeout           timeout value
     * @param isInternal        flag to determine internal or external
     * @param withRetry         flag to determine retrial
     * @return the http post response
     */
    public HttpPostResponse httpPostApiCall(String serviceHostname, String requestUrl,
                                            Map<String, String> requestParams, String helpchatAuthToken, String requestBody,
                                            Map<String, String> requestHeaders, Integer timeout,
                                            boolean isInternal, boolean withRetry)
            throws Exception {
        String output = null;
        HttpPostResponse httpPostResponse = new HttpPostResponse();
        URIBuilder uriBuilder = null;
        if (null == timeout) {
            timeout = defaultAliveDur;
        }
        try {
            if (null == serviceHostname) {
                serviceHostname = hostname;
            }
            uriBuilder = new URIBuilder(serviceHostname + requestUrl);
            if (null != requestParams && requestParams.size() != 0) {
                for (String param : requestParams.keySet()) {
                    uriBuilder.addParameter(param, requestParams.get(param));
                }
            }
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
            httpPost.setConfig(requestConfig);
            if (isInternal) {
                if (null != helpchatAuthToken) {
                    httpPost.setHeader(Constants.SecurityConstants.X_GBP_AUTH, helpchatAuthToken);
                } else {
                    httpPost.setHeader(Constants.SecurityConstants.X_GBP_AUTH, accesToken);
                }
            }
            if (null != requestHeaders) {
                String headerValue = null;
                for (String key : requestHeaders.keySet()) {
                    headerValue = requestHeaders.get(key);
                    LOGGER.info("Headers for request  : " + serviceHostname + requestUrl + ":::Key:::" + key
                            + ":::value:::" + headerValue);
                    httpPost.addHeader(key, requestHeaders.get(key));
                }
            }
            LOGGER.info("Service : " + serviceHostname + requestUrl + ",\n Body:" + requestBody);
            LOGGER.info(
                    "******* Helpchat Auth Token : " + helpchatAuthToken + " Access Token : " + accesToken);
            if (null != requestBody) {
                StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(stringEntity);
            }
            HttpResponse response = null;
            if (withRetry) {
                response = httpclientWithRetry.execute(httpPost);
            } else {
                response = httpclient.execute(httpPost);
            }
            LOGGER.info("Service Response: for service ::" + serviceHostname + requestUrl + ":::"
                    + response.getStatusLine().getStatusCode());
            httpPostResponse.setStatus(HttpStatus.valueOf(response.getStatusLine().getStatusCode()));
            if (null != response.getEntity()) {
                output = EntityUtils.toString(response.getEntity(), "UTF-8");
                if (!(response.getStatusLine().getStatusCode() == HttpStatus.OK.value()
                        || response.getStatusLine().getStatusCode() == HttpStatus.CREATED.value())) {
                    LOGGER.error("Bad Response Code :" + requestUrl + " "
                            + response.getStatusLine().getStatusCode() + output);
                }
                httpPostResponse.setResponse(output);
            }
        } catch (Exception ex) {
            LOGGER.error("Error in call to Service:" + serviceHostname + requestUrl, ex);
            throw ex;
        }
        return httpPostResponse;
    }

    public HttpClientCaller(String hostname) {
        super();
        this.hostname = hostname;
    }

    public HttpClientCaller() {
        super();
    }

    /**
     * Http post api call pool and get output stream byte array output stream.
     *
     * @param serviceHostname   the service hostname
     * @param requestUrl        the request url
     * @param requestParams     the request params
     * @param helpchatAuthToken the helpchat auth token
     * @param requestBody       the request body
     * @param timeout           the timeout
     * @return the byte array output stream
     */
    public ByteArrayOutputStream httpPostApiCallPoolAndGetOutputStream(String serviceHostname,
                                                                       String requestUrl,
                                                                       Map<String, String> requestParams, String helpchatAuthToken, String requestBody,
                                                                       int timeout) {
        URIBuilder uriBuilder = null;
        CloseableHttpResponse response = null;
        ByteArrayOutputStream baos = null;
        try {
            uriBuilder = new URIBuilder(serviceHostname + requestUrl);
            if (null != requestParams && requestParams.size() != 0) {
                for (String param : requestParams.keySet()) {
                    uriBuilder.addParameter(param, requestParams.get(param));
                }
            }
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader(Constants.SecurityConstants.X_GBP_AUTH, helpchatAuthToken);
            if (null != requestBody) {
                StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(stringEntity);
            }
            LOGGER.info("RequestBody:" + requestBody);
            response = httpclient.execute(httpPost);
            LOGGER.info("Service Response:" + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                baos = new ByteArrayOutputStream();
                response.getEntity().writeTo(baos);
            }
            return baos;
        } catch (Exception ex) {
            LOGGER.error("Error in call to Service:" + requestUrl, ex);
            throw new RuntimeException(ex);
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
            } catch (IOException ioEx) {
                LOGGER.error("Failed to close response : ", ioEx);
            }
        }
    }
}
