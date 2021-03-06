package com.bookpurple.catalog.repo.master;

import com.bookpurple.catalog.entity.ServiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@Repository
public interface ServiceMasterRepo extends MongoRepository<ServiceEntity, String> {
}
