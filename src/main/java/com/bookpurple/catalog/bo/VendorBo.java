package com.bookpurple.catalog.bo;

import com.bookpurple.catalog.model.AbstractVendorModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class VendorBo extends AbstractVendorModel {

    @Builder
    public VendorBo(String id, String name, String image, double rating, String desc, int viewType) {
        super(id, name, image, rating, desc, 1);
    }
}
