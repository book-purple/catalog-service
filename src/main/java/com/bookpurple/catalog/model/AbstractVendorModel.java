package com.bookpurple.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractVendorModel {

    @JsonProperty("vendor_id")
    private String id;

    @JsonProperty("vendor_name")
    private String name;

    @JsonProperty("vendor_image")
    private String image;

    @JsonProperty("vendor_rating")
    private double rating;

    @JsonProperty("vendor_desc")
    private String desc;

    @JsonProperty("viewType")
    private int viewType = 1;
}
