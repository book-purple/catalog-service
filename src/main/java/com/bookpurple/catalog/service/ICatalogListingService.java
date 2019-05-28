package com.bookpurple.catalog.service;

import com.bookpurple.catalog.bo.VendorBo;
import com.bookpurple.catalog.dto.VendorDto;

import java.util.List;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
public interface ICatalogListingService {

    String catalogListType();

    List<VendorDto> getVendorListing(String requestId);
}
