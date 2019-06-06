package com.bookpurple.catalog.proxy.impl;

import com.bookpurple.catalog.bo.VendorMappingRequestBo;
import com.bookpurple.catalog.dto.CatalogVendorMappingResponseDto;
import com.bookpurple.catalog.dto.VendorDto;
import com.bookpurple.catalog.dto.VendorMappingRequestDto;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.model.HttpPostResponse;
import com.bookpurple.catalog.proxy.IVendorServiceProxy;
import com.bookpurple.catalog.util.HttpClientCaller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Written by Gaurav Sharma on 26 May 2019
 */
@Service
public class VendorServiceProxy implements IVendorServiceProxy {

    @Autowired
    private CatalogMapper catalogMapper;

    @Autowired
    private HttpClientCaller clientCaller;

    @Value("${vendor.service.hostname}")
    private String vendorHost;

    @Value("${vendor.vendor.mapping}")
    private String vendorMappingUrl;

    private static Logger logger = Logger.getLogger(VendorServiceProxy.class);

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public CatalogVendorMappingResponseDto getAllVendors(VendorMappingRequestBo vendorMappingRequestBo) {
        VendorMappingRequestDto vendorMappingRequestDto = catalogMapper.convertVendorMappingRequestBoToDto(vendorMappingRequestBo);
        try {
            HttpPostResponse httpPostResponse = clientCaller.httpPostInternalApiCall(vendorHost,
                    vendorMappingUrl,
                    null,
                    mapper.writeValueAsString(vendorMappingRequestDto),
                    null,
                    false);
            if (null == httpPostResponse) {
                logger.error("Vendor Service is down!");
                return null;
            }
            if (null != httpPostResponse.getResponse()) {
                String response = httpPostResponse.getResponse();
                CatalogVendorMappingResponseDto catalogVendorMappingResponseDto
                        = mapper.readValue(response, CatalogVendorMappingResponseDto.class);
                return catalogVendorMappingResponseDto;
            }
        } catch (Exception e) {
            logger.error("Error while calling vendor service, error: ", e);
        }
        return null;
    }
}
