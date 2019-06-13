package com.bookpurple.catalog.util;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.bo.ServiceBo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@Component
public class DummyCatalogProvider {

    public List<EventBo> getDummyEventProvider() {
        List<EventBo> eventBos = new ArrayList<>();
        eventBos.add(getDummyEvent("wedding", ""));
        eventBos.add(getDummyEvent("packers & movers", ""));
        eventBos.add(getDummyEvent("bridal shower", ""));
        eventBos.add(getDummyEvent("corporate events", ""));
        eventBos.add(getDummyEvent("bridal shower", ""));
        return eventBos;
    }

    private EventBo getDummyEvent(String name,
                                  String icon) {
        return EventBo.builder()
                .name(name)
                .icon(icon)
                .isLocationSpecific((byte) 1)
                .isActive((byte) 1)
                .createdAt(new Date())
                .build();
    }

    public List<ServiceBo> getDummyServiceProvider() {
        List<ServiceBo> serviceBos = new ArrayList<>();
        serviceBos.add(getDummyService("catering", ""));
        serviceBos.add(getDummyService("venue", ""));
        serviceBos.add(getDummyService("photography", ""));
        serviceBos.add(getDummyService("videography", ""));
        serviceBos.add(getDummyService("mehendi", ""));
        serviceBos.add(getDummyService("DJ", ""));
        serviceBos.add(getDummyService("decoration", ""));

        return serviceBos;
    }

    private ServiceBo getDummyService(String name,
                                      String icon) {
        return ServiceBo.builder()
                .name(name)
                .icon(icon)
                .isLocationSpecific((byte) 1)
                .isActive((byte) 1)
                .createdAt(new Date())
                .build();
    }
}
