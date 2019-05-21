package com.bookpurple.catalog.util;

import com.bookpurple.catalog.bo.EventBo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Component
public class DummyCatalogProvider {

    public List<EventBo> getDummyEventProvider() {
        List<EventBo> eventBos = new ArrayList<>();
        return eventBos;
    }
}
