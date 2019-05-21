package com.bookpurple.catalog.model;

import com.bookpurple.catalog.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEventGridModel {

    @JsonProperty("events")
    private List<EventDto> eventDtos;
}
