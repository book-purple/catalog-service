package com.bookpurple.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Written by Gaurav Sharma on 27 May 2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractListingPageRequestModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("requestType")
    private String requestType;
}
