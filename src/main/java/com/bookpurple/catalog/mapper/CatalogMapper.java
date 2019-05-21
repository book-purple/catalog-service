package com.bookpurple.catalog.mapper;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.bo.LandingRequestBo;
import com.bookpurple.catalog.bo.ServiceBo;
import com.bookpurple.catalog.dto.EventDto;
import com.bookpurple.catalog.dto.LandingRequestDto;
import com.bookpurple.catalog.dto.ServiceDto;
import com.bookpurple.catalog.entity.EventEntity;
import com.bookpurple.catalog.entity.ServiceEntity;
import org.mapstruct.Mapper;

import java.util.List;

/*
 * Created by Gaurav Sharma on 19 May 2019
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
}
