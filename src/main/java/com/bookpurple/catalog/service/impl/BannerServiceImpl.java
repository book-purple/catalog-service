package com.bookpurple.catalog.service.impl;

import com.bookpurple.catalog.bo.banner.BannerBo;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.repo.master.BannerMasterRepo;
import com.bookpurple.catalog.repo.slave.BannerSlaveRepo;
import com.bookpurple.catalog.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BannerMasterRepo masterRepo;

    @Autowired
    private BannerSlaveRepo slaveRepo;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public List<BannerBo> findAllBanners() {
        return catalogMapper.convertBannerEntityListToBoList(slaveRepo.findAll());
    }

    @Override
    public BannerBo createBanner(BannerBo bannerBo) {
        return catalogMapper
                .convertBannerEntityToBo(masterRepo
                        .save(catalogMapper
                                .convertBannerBoToEntity(bannerBo)));
    }
}
