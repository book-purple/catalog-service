package com.bookpurple.catalog.component.impl;

import com.bookpurple.catalog.bo.ListingPageRequestBo;
import com.bookpurple.catalog.bo.ListingPageResponseBo;
import com.bookpurple.catalog.component.IListingPageProvider;
import com.bookpurple.catalog.enums.ListingRequestTypes;

/*
 * Written by Gaurav Sharma on 27 May 2019
 */
public class ListingPageProvider implements IListingPageProvider {

    /**
     * Function to provide listing data
     *
     * @param listingPageRequestBo listingPageRequestBo
     * @return ListingPageResponseDto
     */
    @Override
    public ListingPageResponseBo provideListingPage(ListingPageRequestBo listingPageRequestBo) {
        String requestType = listingPageRequestBo.getRequestType();
        String requestId = listingPageRequestBo.getId();

        // 1. Make catalog List (event/services)
        if (ListingRequestTypes.EVENT_LISTING.getName().equalsIgnoreCase(requestType)) {
            // find vendors based on events
        } else if (ListingRequestTypes.SERVICE_LISTING.getName().equalsIgnoreCase(requestType)) {
            // find vendors based on services
        }
        return null;
    }
}
