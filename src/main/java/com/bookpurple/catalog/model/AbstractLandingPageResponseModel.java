package com.bookpurple.catalog.model;

import com.bookpurple.catalog.dto.EventDto;
import com.bookpurple.catalog.dto.EventGridDto;
import com.bookpurple.catalog.dto.LandingPageResponseDto;
import com.bookpurple.catalog.dto.ServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractLandingPageResponseModel {

    @JsonProperty("eventGrid")
    private EventGridDto eventGridDto;

    /*@JsonProperty("serviceGrid")
    private ServiceGr serviceGridDto;*/

}
