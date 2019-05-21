package com.bookpurple.catalog.component;

import com.bookpurple.catalog.bo.LandingRequestBo;
import com.bookpurple.catalog.dto.LandingPageResponseDto;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
public interface ILandingPageProvider {

    LandingPageResponseDto getLandingPageData(LandingRequestBo landingRequestBo);
}
