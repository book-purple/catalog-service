package com.bookpurple.catalog.service;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.bo.ServiceBo;

import java.util.List;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
public interface IServicesService {

    ServiceBo createService(ServiceBo serviceBo);

    ServiceBo updateService(ServiceBo serviceBo);

    List<ServiceBo> findAllServices();

    ServiceBo findServiceByName(String name);

    ServiceBo findServiceById(String id);

    void addDummyServices(List<ServiceBo> serviceBos);
}
