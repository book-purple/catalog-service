package com.bookpurple.catalog.entity;

import com.bookpurple.catalog.model.AbstractBannerModel;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@Document(collection = "banner")
public class BannerEntity extends AbstractBannerModel {

}
