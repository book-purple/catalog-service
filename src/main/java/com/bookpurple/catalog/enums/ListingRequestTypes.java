package com.bookpurple.catalog.enums;

/*
 * Written by Gaurav Sharma on 27 May 2019
 */
public enum ListingRequestTypes {

    EVENT_LISTING(1, "event_listing"),
    SERVICE_LISTING(2, "service_listing");

    private int id;
    private String name;

    ListingRequestTypes(int i, String requestType) {
        this.id = i;
        this.name = requestType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
