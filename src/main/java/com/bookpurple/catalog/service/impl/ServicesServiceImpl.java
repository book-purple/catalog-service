package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.ServiceBo;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.repo.master.ServiceMasterRepo;
import com.bookpurple.catalog.repo.slave.ServiceSlaveRepo;
import com.bookpurple.catalog.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public class ServicesServiceImpl implements IServicesService {

    @Autowired
    private ServiceMasterRepo masterRepo;

    @Autowired
    private ServiceSlaveRepo serviceSlaveRepo;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public ServiceBo createEvent(ServiceBo serviceBo) {
        return null;
    }

    @Override
    public ServiceBo updateEvent(ServiceBo serviceBo) {
        return null;
    }

    @Override
    public List<ServiceBo> findAllEvent() {
        return null;
    }

    @Override
    public ServiceBo findEventByName(String name) {
        return null;
    }

    @Override
    public ServiceBo findEventById(String id) {
        return null;
    }
}
