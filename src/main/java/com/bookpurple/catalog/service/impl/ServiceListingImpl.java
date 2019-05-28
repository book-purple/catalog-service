package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.VendorBo;
import com.bookpurple.catalog.dto.VendorDto;
import com.bookpurple.catalog.enums.ListingRequestTypes;
import com.bookpurple.catalog.proxy.IVendorServiceProxy;
import com.bookpurple.catalog.service.ICatalogListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
@Service
public class ServiceListingImpl implements ICatalogListingService {

    @Autowired
    private IVendorServiceProxy vendorServiceProxy;

    @Override
    public String catalogListType() {
        return ListingRequestTypes.SERVICE_LISTING.getName();
    }

    @Override
    public List<VendorDto> getVendorListing(String serviceId) {
        return vendorServiceProxy.getAllVendors(serviceId);
    }
}
