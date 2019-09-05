package com.bookpurple.catalog.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/*
 * Written by Gaurav Sharma on 05 Sep 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractOrderModel {

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("vendor_id")
    private String vendorId;

    @JsonProperty("user_id")
    private String userId;
}
