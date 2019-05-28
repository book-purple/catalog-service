package com.bookpurple.catalog.model;

import com.bookpurple.catalog.dto.VendorDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Written by Gaurav Sharma on 27 May 2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractListingPageResponseModel {

    @JsonProperty("vendors")
    private List<VendorDto> vendors;

    @JsonProperty("error")
    private Error error;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Error {

        @JsonProperty("error_message")
        private String error;
    }
}
