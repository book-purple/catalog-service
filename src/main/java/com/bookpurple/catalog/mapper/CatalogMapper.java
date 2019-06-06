package com.bookpurple.catalog.mapper;

import com.bookpurple.catalog.bo.*;
import com.bookpurple.catalog.bo.grid.EventGridBo;
import com.bookpurple.catalog.bo.grid.LandingGridBo;
import com.bookpurple.catalog.bo.grid.ServiceGridBo;
import com.bookpurple.catalog.dto.*;
import com.bookpurple.catalog.dto.grid.EventGridDto;
import com.bookpurple.catalog.dto.grid.LandingGridDto;
import com.bookpurple.catalog.dto.grid.ServiceGridDto;
import com.bookpurple.catalog.entity.EventEntity;
import com.bookpurple.catalog.entity.ServiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

/*
 * Written by Gaurav Sharma on 19 May 2019
 */
@Mapper(componentModel = "spring")
public interface CatalogMapper {

    /*Landing Page Mappings*/
    LandingRequestBo convertLandingRequestDtoToBo(LandingRequestDto landingRequestDto);

    EventEntity convertEventBoToEntity(EventBo eventBo);
    EventBo convertEventEntityToBo(EventEntity eventEntity);
    EventBo convertEventDtoToBo(EventDto eventDto);
    List<EventEntity> convertEventBoListToEntityList(List<EventBo> eventBos);
    List<EventBo> convertEventEntityListToBoList(List<EventEntity> eventEntities);
    List<EventDto> convertEventBoListToDtoList(List<EventBo> eventBos);

    ServiceEntity convertServiceEntityToBo(ServiceBo serviceBo);
    ServiceBo convertServiceEntityToBo(ServiceEntity serviceEntity);
    ServiceBo convertServiceDtoToBo(ServiceDto ServiceDto);
    List<ServiceEntity> convertServiceBoListToEntityList(List<ServiceBo> ServiceBo);
    List<ServiceBo> convertServiceEntityListToBoList(List<ServiceEntity> ServiceEntity);
    List<ServiceDto> convertServiceBoListToDtoList(List<ServiceBo> ServiceBo);

    EventGridDto convertEventGridBoToDto(EventGridBo eventGridBo);
    ServiceGridDto convertServiceGridBoToDto(ServiceGridBo serviceGridBo);

    LandingGridDto convertLandingGridBoToDto(LandingGridBo landingGridBo);
    LandingPageResponseDto convertLandingPageResponseBoToDto(LandingPageResponseBo landingPageResponseBo);

    ListingPageRequestBo convertListingRequestDtoToBo(ListingPageRequestDto listingPageRequestDto);
    ListingPageResponseDto convertListingResponseBoToDto(ListingPageResponseBo listingPageResponseBo);

    VendorBo convertVendorDtoToBo(VendorDto vendorDto);
    VendorDto convertVendorBo(VendorBo vendorBo);

    VendorMappingRequestDto convertVendorMappingRequestBoToDto(VendorMappingRequestBo vendorMappingRequestBo);
}
