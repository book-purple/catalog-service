package com.bookpurple.catalog.bo.grid;

import com.bookpurple.catalog.dto.EventDto;
import com.bookpurple.catalog.model.grid.AbstractEventGridModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Written by Gaurav Sharma on 21 May 2019
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EventGridBo extends AbstractEventGridModel {

    @Builder
    public EventGridBo(List<EventDto> eventDtos) {
        super(eventDtos);
    }
}
