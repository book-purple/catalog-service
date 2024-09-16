package com.bookpurple.catalog.model;

import com.bookpurple.catalog.bo.banner.BannerBo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractBannersResponseModel {


    @JsonProperty("banners")
    List<BannerBo> banners;

}
