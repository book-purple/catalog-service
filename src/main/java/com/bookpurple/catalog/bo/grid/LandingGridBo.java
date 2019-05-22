package com.bookpurple.catalog.bo.grid;

import com.bookpurple.catalog.dto.grid.EventGridDto;
import com.bookpurple.catalog.dto.grid.ServiceGridDto;
import com.bookpurple.catalog.model.grid.AbstractLandingGridModel;
import lombok.Builder;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public class LandingGridBo extends AbstractLandingGridModel {

    @Builder
    public LandingGridBo(EventGridDto eventGridDto, ServiceGridDto serviceGridDto) {
        super(eventGridDto, serviceGridDto);
    }
}
