package com.bookpurple.catalog.repo.slave;

import com.bookpurple.catalog.entity.ServiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Repository
public interface ServiceSlaveRepo extends MongoRepository<ServiceEntity, String> {
}
