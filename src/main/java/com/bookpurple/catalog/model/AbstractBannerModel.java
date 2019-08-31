package com.bookpurple.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/*
 * Written by Gaurav Sharma on 30 Aug 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractBannerModel {


    @Id
    private String id;
    private String name;
    private String url;
}
