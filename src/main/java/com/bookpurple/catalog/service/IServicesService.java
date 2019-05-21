package com.bookpurple.catalog.service;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.bo.ServiceBo;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public interface IServicesService {

    ServiceBo createEvent(ServiceBo serviceBo);

    ServiceBo updateEvent(ServiceBo serviceBo);

    List<ServiceBo> findAllEvent();

    ServiceBo findEventByName(String name);

    ServiceBo findEventById(String id);
}
