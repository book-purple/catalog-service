package com.bookpurple.catalog.bo;

import com.bookpurple.catalog.model.AbstractVendorMappingRequestModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
 * Written by Gaurav Sharma on 05 Jun 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class VendorMappingRequestBo extends AbstractVendorMappingRequestModel {

    @Builder
    public VendorMappingRequestBo(String eventId,
                                  String serviceId,
                                  String vendorId) {
        super(eventId, serviceId, vendorId);
    }
}
