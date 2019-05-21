package com.bookpurple.catalog.model;

import com.bookpurple.catalog.dto.ServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractServiceGridModel {

    @JsonProperty("services")
    private List<ServiceDto> serviceDtos;
}
