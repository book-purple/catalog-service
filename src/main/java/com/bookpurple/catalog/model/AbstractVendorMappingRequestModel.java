package com.bookpurple.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

/*
 * Written by Gaurav Sharma on 05 Jun 2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractVendorMappingRequestModel {

    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("serviceId")
    private String serviceId;

    @JsonProperty("vendorId")
    private String vendorId;
}
