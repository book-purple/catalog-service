package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.VendorBo;
import com.bookpurple.catalog.bo.VendorMappingRequestBo;
import com.bookpurple.catalog.dto.CatalogVendorMappingResponseDto;
import com.bookpurple.catalog.dto.VendorDto;
import com.bookpurple.catalog.dto.VendorMappingRequestDto;
import com.bookpurple.catalog.enums.ListingRequestTypes;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.proxy.IVendorServiceProxy;
import com.bookpurple.catalog.service.ICatalogListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
@Service
public class EventListingImpl implements ICatalogListingService {

    @Autowired
    private IVendorServiceProxy vendorServiceProxy;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public String catalogListType() {
        return ListingRequestTypes.EVENT_LISTING.getName();
    }

    @Override
    public List<VendorDto> getVendorListing(String eventId) {
        VendorMappingRequestBo vendorMappingRequestBo = VendorMappingRequestBo.builder()
                .eventId(eventId)
                .build();
        return getVendorList(vendorServiceProxy.getAllVendors(vendorMappingRequestBo));
    }

    /**
     * Function to get vendor list from vendor mapping response
     *
     * @param catalogVendorMappingResponseDto catalogVendorMappingResponseDto
     * @return {@link List<VendorDto>}
     */
    private List<VendorDto> getVendorList(CatalogVendorMappingResponseDto catalogVendorMappingResponseDto) {
        List<CatalogVendorMappingResponseDto.VendorEntity> vendorEntities =
                catalogVendorMappingResponseDto.getEventVendorMappingBo().getVendorEntities();
        List<VendorDto> vendorDtos = new ArrayList<>();
        for(CatalogVendorMappingResponseDto.VendorEntity vendorEntity: vendorEntities){
            VendorBo vendorBo = VendorBo.builder()
                    .name(vendorEntity.getName())
                    .id(vendorEntity.getId())
                    .image(vendorEntity.getImage())
                    .rating(vendorEntity.getRating())
                    .build();
            vendorDtos.add(catalogMapper.convertVendorBo(vendorBo));
        }
        return vendorDtos;
    }
}
