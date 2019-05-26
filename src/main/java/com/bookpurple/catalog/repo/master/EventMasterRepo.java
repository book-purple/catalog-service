package com.bookpurple.catalog.repo.master;

import com.bookpurple.catalog.entity.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@Repository
public interface EventMasterRepo extends MongoRepository<EventEntity, String> {
}
