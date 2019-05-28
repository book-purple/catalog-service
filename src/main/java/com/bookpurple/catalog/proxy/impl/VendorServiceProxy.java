package com.bookpurple.catalog.proxy.impl;

import com.bookpurple.catalog.dto.VendorDto;
import com.bookpurple.catalog.proxy.IVendorServiceProxy;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Written by Gaurav Sharma on 26 May 2019
 */
@Service
public class VendorServiceProxy implements IVendorServiceProxy {

    @Override
    public List<VendorDto> getAllVendors(String requestId) {
        // call vendor service to get all vendor for catalog request id
        return null;
    }
}
