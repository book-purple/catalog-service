package com.bookpurple.catalog.bo.banner;

import com.bookpurple.catalog.model.AbstractBannerResponseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BannerResponseBo extends AbstractBannerResponseModel {

    @Builder
    public BannerResponseBo(List<BannerBo> banners) {
        super(banners);
    }
}
