package com.bookpurple.catalog.model;

import com.bookpurple.catalog.bo.banner.BannerBO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractBannerResponseModel {


    @JsonProperty("banners")
    List<BannerBO> banners;

}
