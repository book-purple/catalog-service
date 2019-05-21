package com.bookpurple.catalog.model;

import com.bookpurple.catalog.dto.EventGridDto;
import com.bookpurple.catalog.dto.ServiceGridDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractLandingGridModel {

    @JsonProperty("eventGrid")
    private EventGridDto eventGridDto;

    @JsonProperty("serviceGrid")
    private ServiceGridDto serviceGridDto;
}
