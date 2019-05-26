package com.bookpurple.catalog.entity;

import com.bookpurple.catalog.model.AbstractEventModel;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@Document(collection = "events")
public class EventEntity extends AbstractEventModel {
}
