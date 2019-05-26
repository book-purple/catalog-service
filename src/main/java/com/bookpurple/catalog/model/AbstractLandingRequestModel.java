package com.bookpurple.catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Written by Gaurav Sharma on 19 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractLandingRequestModel {

    @JsonProperty(value = "lat")
    private Long lat;

    @JsonProperty(value = "lang")
    private Long lang;
}
