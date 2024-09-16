package com.bookpurple.catalog.repo.master;

import com.bookpurple.catalog.entity.BannerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@Repository
public interface BannerMasterRepo extends MongoRepository<BannerEntity, String> {

}

