package com.bookpurple.catalog.model.grid;

import com.bookpurple.catalog.dto.ServiceDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * Created by Gaurav Sharma on 21 May 2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractServiceGridModel {

    @JsonProperty("serviceTiles")
    private List<ServiceDto> serviceDtos;
}
