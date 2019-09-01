package com.bookpurple.catalog.service;

import com.bookpurple.catalog.bo.banner.BannerBo;

import java.util.List;

public interface IBannerService {

    List<BannerBo> findAllBanners();
    BannerBo createBanner(BannerBo bannerBo);
}
