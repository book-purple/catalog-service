package com.bookpurple.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/*
 * Created by Gaurav Sharma on 19 May 2019
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
