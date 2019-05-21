package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.repo.master.EventMasterRepo;
import com.bookpurple.catalog.repo.slave.EventSlaveRepo;
import com.bookpurple.catalog.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public class EventServiceImpl implements IEventService {

    @Autowired
    private EventMasterRepo masterRepo;

    @Autowired
    private EventSlaveRepo slaveRepo;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public EventBo createEvent(EventBo eventBo) {
        return null;
    }

    @Override
    public EventBo updateEvent(EventBo eventBo) {
        return null;
    }

    @Override
    public List<EventBo> findAllEvent() {
        return null;
    }

    @Override
    public EventBo findEventByName(String name) {
        return null;
    }

    @Override
    public EventBo findEventById(String id) {
        return null;
    }
}
