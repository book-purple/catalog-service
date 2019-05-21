package com.bookpurple.catalog.service;

import com.bookpurple.catalog.bo.EventBo;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public interface IEventService {

    EventBo createEvent(EventBo eventBo);

    EventBo updateEvent(EventBo eventBo);

    List<EventBo> findAllEvent();

    EventBo findEventByName(String name);

    EventBo findEventById(String id);

    void addDummyEvents(List<EventBo> eventBos);
}
