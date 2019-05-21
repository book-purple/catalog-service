package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.EventGridBo;
import com.bookpurple.catalog.dto.EventDto;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.service.IEventService;
import com.bookpurple.catalog.service.IGridService;
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
    private CatalogMapper catalogMapper;

    @Override
    public EventGridBo createEventGrid() {
        List<EventDto> eventDtos = catalogMapper.convertEventBoListToDtoList(eventService.findAllEvent());
        return EventGridBo.builder()
                .eventDtos(eventDtos)
                .build();
    }
}
