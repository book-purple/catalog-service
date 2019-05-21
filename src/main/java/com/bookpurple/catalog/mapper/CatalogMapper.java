package com.bookpurple.catalog.mapper;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.bo.LandingRequestBo;
import com.bookpurple.catalog.bo.ServiceBo;
import com.bookpurple.catalog.dto.LandingRequestDto;
import com.bookpurple.catalog.entity.EventEntity;
import com.bookpurple.catalog.entity.ServiceEntity;
import org.mapstruct.Mapper;

/*
 * Created by Gaurav Sharma on 19 May 2019
 */
@Mapper(componentModel = "spring")
public interface CatalogMapper {

    /*Landing Page Mappings*/
    LandingRequestBo convertLandingRequestDtoToBo(LandingRequestDto landingRequestDto);

    EventEntity convertEventBoToEntity(EventBo eventBo);

    EventBo convertEventEntityToBo(EventEntity eventEntity);

    ServiceEntity convertServiceEntityToBo(ServiceBo serviceBo);

    ServiceBo convertServiceEntityToBo(ServiceEntity serviceEntity);
}
