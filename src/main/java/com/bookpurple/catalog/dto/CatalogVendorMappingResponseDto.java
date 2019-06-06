package com.bookpurple.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/*
 * Class to handle Vendor Mapping response from vendor service
 *
 * Written by Gaurav Sharma on 06 Jun 2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogVendorMappingResponseDto {

    @JsonProperty("event_vendor_mapping")
    private EventVendorMappingDto eventVendorMappingBo;

    @JsonProperty("service_vendor_mapping")
    private ServiceVendorMappingDto serviceVendorMappingBo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EventVendorMappingDto {

        @JsonProperty("id")
        private String id;

        @JsonProperty("eventId")
        private String eventId;

        @JsonProperty("vendor")
        private List<VendorEntity> vendorEntities;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ServiceVendorMappingDto {

        @JsonProperty("id")
        private String id;

        @JsonProperty("serviceId")
        private String serviceId;

        @JsonProperty("vendor")
        private List<VendorEntity> vendorEntities;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VendorEntity {

        @JsonProperty("id")
        private String id;

        @NotNull
        @NotBlank
        @NotEmpty
        @JsonProperty("name")
        private String name;

        @NotNull
        @NotBlank
        @NotEmpty
        @JsonProperty("uid")
        private String uid;

        @JsonProperty("email")
        private String email;

        @JsonProperty("mobile")
        private String mobile;

        @JsonProperty("createdAt")
        private Date createdAt;

        @JsonProperty("image")
        private String image;

        @JsonProperty("rating")
        private double rating;
    }
}
