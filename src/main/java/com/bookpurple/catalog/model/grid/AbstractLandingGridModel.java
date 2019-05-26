package com.bookpurple.catalog.model.grid;

import com.bookpurple.catalog.dto.grid.EventGridDto;
import com.bookpurple.catalog.dto.grid.ServiceGridDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Written by Gaurav Sharma on 21 May 2019
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
