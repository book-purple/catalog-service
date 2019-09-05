package com.bookpurple.catalog.bo.banner;

import com.bookpurple.catalog.model.AbstractBannerModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class BannerBo extends AbstractBannerModel {

    @Builder
    public BannerBo(String id, String name, String url) {
        super(id, name, url);
    }
}
