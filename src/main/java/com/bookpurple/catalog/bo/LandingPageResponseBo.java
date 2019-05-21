package com.bookpurple.catalog.bo;

import com.bookpurple.catalog.dto.EventGridDto;
import com.bookpurple.catalog.model.AbstractLandingPageResponseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LandingPageResponseBo extends AbstractLandingPageResponseModel {

    @Builder
    public LandingPageResponseBo(EventGridDto eventGrid) {
        super(eventGrid);
    }
}
