package com.bookpurple.catalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.Header;
import org.springframework.http.HttpStatus;

/*
 * Written by Gaurav Sharma on 29 May 2019
 */
@Data
@NoArgsConstructor
public class HttpPostResponse {

    private String response;
    private HttpStatus status;
    private Header[] headers;
}
