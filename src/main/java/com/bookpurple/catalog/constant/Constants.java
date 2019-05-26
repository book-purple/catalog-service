package com.bookpurple.catalog.constant;

/*
 * Written by Gaurav Sharma on 19 May 2019
 */
public class Constants {

    public static class SecurityConstants {
        public static final String X_GBP_AUTH = "X-GBP-AUTH";
        public static final String AUTHORIZATION = "Authorization";
    }

    public static class UriConstants {
        public static final String LANDING_API = "/landing";
        public static final String EVENT_LISTING_API = "/event/list";
        public static final String SERVICE_LISTING_API = "/service/list";

        /*Event related URL*/
        public static final String GET_ALL_EVENT = "/event/all";
        public static final String ADD_DUMMY_EVENT = "/dummy/event/add";
        public static final String ADD_EVENT = "/event/add";

        /*Service related URL*/
        public static final String GET_ALL_SERVICES = "/service/all";
        public static final String ADD_DUMMY_SERVICES= "/dummy/service/add";
        public static final String ADD_SERVICE = "/service/add";
    }
}
