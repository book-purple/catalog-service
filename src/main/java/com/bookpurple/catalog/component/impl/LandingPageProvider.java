package com.bookpurple.catalog.component.impl;

import com.bookpurple.catalog.bo.LandingPageResponseBo;
import com.bookpurple.catalog.bo.LandingRequestBo;
import com.bookpurple.catalog.component.ILandingPageProvider;
import com.bookpurple.catalog.dto.LandingGridDto;
import com.bookpurple.catalog.dto.LandingPageResponseDto;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.service.IGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Component
public class LandingPageProvider implements ILandingPageProvider {

    @Autowired
    private IGridService gridService;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public LandingPageResponseDto getLandingPageData(LandingRequestBo landingRequestBo) {
        // TODO: user landing request bo for location specific service
        LandingGridDto landingGridDto = getLandingGrid();
        LandingPageResponseBo landingPageResponseBo = LandingPageResponseBo.builder()
                .landingGridDto(landingGridDto)
                .build();
        return catalogMapper.convertLandingPageResponseBoToDto(landingPageResponseBo);
    }

    private LandingGridDto getLandingGrid() {
        return catalogMapper.convertLandingGridBoToDto(gridService.createLandingGrid());
    }
}
