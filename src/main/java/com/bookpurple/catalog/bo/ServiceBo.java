package com.bookpurple.catalog.bo;

import com.bookpurple.catalog.model.grid.AbstractServiceModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ServiceBo extends AbstractServiceModel {

    @Builder
    public ServiceBo(String id,
                     String name,
                     String icon,
                     byte isLocationSpecific,
                     byte isActive,
                     Date createdAt) {
        super(id, name, icon, isLocationSpecific, isActive, createdAt);
    }
}
