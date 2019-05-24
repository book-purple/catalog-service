package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.grid.EventGridBo;
import com.bookpurple.catalog.bo.grid.LandingGridBo;
import com.bookpurple.catalog.bo.grid.ServiceGridBo;
import com.bookpurple.catalog.dto.EventDto;
import com.bookpurple.catalog.dto.grid.EventGridDto;
import com.bookpurple.catalog.dto.ServiceDto;
import com.bookpurple.catalog.dto.grid.ServiceGridDto;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.service.IEventService;
import com.bookpurple.catalog.service.IGridService;
import com.bookpurple.catalog.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Service
public class GridService implements IGridService {

    @Autowired
    private IEventService eventService;

    @Autowired
    private IServicesService servicesService;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public LandingGridBo createLandingGrid() {
        EventGridDto eventGridDto = getEventGrid();
        ServiceGridDto serviceGridDto = getServiceGrid();
        return LandingGridBo.builder()
                .eventGridDto(eventGridDto)
                .serviceGridDto(serviceGridDto)
                .build();
    }

    private EventGridDto getEventGrid() {
        return catalogMapper.convertEventGridBoToDto(createEventGrid());
    }

    private ServiceGridDto getServiceGrid() {
        return catalogMapper.convertServiceGridBoToDto(createServiceGrid());
    }

    private EventGridBo createEventGrid() {
        List<EventDto> eventDtos = catalogMapper.convertEventBoListToDtoList(eventService.findAllEvent());
        return EventGridBo.builder()
                .eventDtos(eventDtos)
                .build();
    }

    private ServiceGridBo createServiceGrid() {
        List<ServiceDto> serviceDtos = catalogMapper.convertServiceBoListToDtoList(servicesService.findAllServices());
        return ServiceGridBo.builder()
                .serviceDtos(serviceDtos)
                .build();
    }
}
