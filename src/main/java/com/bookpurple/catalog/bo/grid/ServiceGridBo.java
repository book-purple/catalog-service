package com.bookpurple.catalog.bo.grid;

import com.bookpurple.catalog.dto.ServiceDto;
import com.bookpurple.catalog.model.grid.AbstractServiceGridModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ServiceGridBo extends AbstractServiceGridModel {

    @Builder
    public ServiceGridBo(List<ServiceDto> serviceDtos) {
        super(serviceDtos);
    }
}
