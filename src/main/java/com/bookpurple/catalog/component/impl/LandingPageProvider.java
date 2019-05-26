package com.bookpurple.catalog.component.impl;

import com.bookpurple.catalog.bo.LandingPageResponseBo;
import com.bookpurple.catalog.bo.LandingRequestBo;
import com.bookpurple.catalog.component.ILandingPageProvider;
import com.bookpurple.catalog.dto.grid.LandingGridDto;
import com.bookpurple.catalog.dto.LandingPageResponseDto;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.service.IGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@Component
public class LandingPageProvider implements ILandingPageProvider {

    @Autowired
    private IGridService gridService;

    @Autowired
    private CatalogMapper catalogMapper;

    public static Map<String, LandingPageResponseDto> landingPageResponseMap = new HashMap<>();
    private static final String KEY = "landing_page_response";

    @Override
    public LandingPageResponseDto getLandingPageData(LandingRequestBo landingRequestBo) {
        // TODO: user landing request bo for location specific service
        LandingPageResponseDto landingPageResponseDto = landingPageResponseMap.get(KEY);
        if (null == landingPageResponseDto) {
            LandingGridDto landingGridDto = getLandingGrid();
            LandingPageResponseBo landingPageResponseBo = LandingPageResponseBo.builder()
                    .landingGridDto(landingGridDto)
                    .build();
            landingPageResponseDto = catalogMapper.convertLandingPageResponseBoToDto(landingPageResponseBo);
            landingPageResponseMap.put(KEY, landingPageResponseDto);
        }
        return landingPageResponseDto;
    }

    private LandingGridDto getLandingGrid() {
        return catalogMapper.convertLandingGridBoToDto(gridService.createLandingGrid());
    }
}
