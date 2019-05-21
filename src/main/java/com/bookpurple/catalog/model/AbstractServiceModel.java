package com.bookpurple.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractServiceModel {

    @Id
    private String id;

    private String name;
    private String icon;
    private byte isLocationSpecific;
    private byte isActive;
    private Date createdAt;
}
