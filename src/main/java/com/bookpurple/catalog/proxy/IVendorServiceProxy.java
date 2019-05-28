package com.bookpurple.catalog.proxy;

import com.bookpurple.catalog.dto.VendorDto;

import java.util.List;

/*
 * Written by Gaurav Sharma on 26 May 2019
 */
public interface IVendorServiceProxy {

    List<VendorDto> getAllVendors(String requestId);
}
