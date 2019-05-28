package com.bookpurple.catalog.component;

import com.bookpurple.catalog.bo.ListingPageRequestBo;
import com.bookpurple.catalog.bo.ListingPageResponseBo;

/*
 * Written by Gaurav Sharma on 27 May 2019
 */
public interface IListingPageProvider {

    public ListingPageResponseBo provideListingPage(ListingPageRequestBo listingPageRequestBo);
}
