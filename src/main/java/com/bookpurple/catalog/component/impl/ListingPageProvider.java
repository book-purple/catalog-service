package com.bookpurple.catalog.component.impl;

import com.bookpurple.catalog.bo.ListingPageRequestBo;
import com.bookpurple.catalog.bo.ListingPageResponseBo;
import com.bookpurple.catalog.component.IListingPageProvider;
import com.bookpurple.catalog.dto.VendorDto;
import com.bookpurple.catalog.model.AbstractListingPageResponseModel.Error;
import com.bookpurple.catalog.service.ICatalogListingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 * Written by Gaurav Sharma on 27 May 2019
 */
public class ListingPageProvider implements IListingPageProvider {

    @Autowired
    private List<ICatalogListingService> catalogListingServices;

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
        ListingPageResponseBo listingPageResponseBo = new ListingPageResponseBo();
        List<VendorDto> vendorDtos = null;
        Error error = null;
        // 1. Make catalog List (event/services)
        for(ICatalogListingService catalogListingService: catalogListingServices) {
            if (catalogListingService.catalogListType().equalsIgnoreCase(requestType)) {
                vendorDtos = catalogListingService.getVendorListing(requestId);
                if (null != vendorDtos) {
                    if (vendorDtos.isEmpty()) {
                        error = new Error();
                        error.setError("No vendors found!");
                    }
                } else {
                    error = new Error();
                    error.setError("No vendors found!");
                }
                listingPageResponseBo.setError(error);
            }
        }

        // TODO: implement Sorting
        return listingPageResponseBo;
    }
}
