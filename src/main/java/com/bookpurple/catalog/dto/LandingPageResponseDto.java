package com.bookpurple.catalog.dto;

import com.bookpurple.catalog.model.AbstractLandingPageResponseModel;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LandingPageResponseDto extends AbstractLandingPageResponseModel {

}
