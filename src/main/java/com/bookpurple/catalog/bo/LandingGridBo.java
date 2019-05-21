package com.bookpurple.catalog.bo;

import com.bookpurple.catalog.dto.EventGridDto;
import com.bookpurple.catalog.dto.ServiceGridDto;
import com.bookpurple.catalog.model.AbstractEventGridModel;
import com.bookpurple.catalog.model.AbstractLandingGridModel;
import com.bookpurple.catalog.model.AbstractServiceGridModel;
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
