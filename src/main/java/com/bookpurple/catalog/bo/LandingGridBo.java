package com.bookpurple.catalog.bo;

import com.bookpurple.catalog.model.AbstractEventGridModel;
import com.bookpurple.catalog.model.AbstractLandingGridModel;
import com.bookpurple.catalog.model.AbstractServiceGridModel;
import lombok.Builder;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public class LandingGridBo extends AbstractLandingGridModel {

    @Builder
    public LandingGridBo(AbstractEventGridModel abstractEventGridModel, AbstractServiceGridModel abstractServiceGridModel) {
        super(abstractEventGridModel, abstractServiceGridModel);
    }
}
