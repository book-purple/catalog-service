package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.ServiceBo;
import com.bookpurple.catalog.entity.ServiceEntity;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.repo.master.ServiceMasterRepo;
import com.bookpurple.catalog.repo.slave.ServiceSlaveRepo;
import com.bookpurple.catalog.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Service
public class ServicesServiceImpl implements IServicesService {

    @Autowired
    private ServiceMasterRepo masterRepo;

    @Autowired
    private ServiceSlaveRepo slaveRepo;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public ServiceBo createService(ServiceBo serviceBo) {
        serviceBo.setIsLocationSpecific((byte) 1);
        serviceBo.setIsActive((byte) 1);
        serviceBo.setCreatedAt(new Date());
        return catalogMapper.convertServiceEntityToBo(
                masterRepo.save(
                        catalogMapper.convertServiceEntityToBo(serviceBo)));
    }

    @Override
    public ServiceBo updateService(ServiceBo serviceBo) {
        return null;
    }

    @Override
    public List<ServiceBo> findAllServices() {
        return catalogMapper.convertServiceEntityListToBoList(slaveRepo.findAll());
    }

    @Override
    public ServiceBo findServiceByName(String name) {
        return null;
    }

    @Override
    public ServiceBo findServiceById(String id) {
        return null;
    }

    @Override
    public void addDummyServices(List<ServiceBo> serviceBos) {
        List<ServiceEntity> serviceEntities = catalogMapper.convertServiceBoListToEntityList(serviceBos);
        for(ServiceEntity serviceEntity: serviceEntities) {
            masterRepo.save(serviceEntity);
        }
    }
}
