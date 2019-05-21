package com.bookpurple.catalog.controller;

import com.bookpurple.catalog.constant.Constants;
import com.bookpurple.catalog.dto.LandingRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Created by Gaurav Sharma on 19 May 2019
 */
@RestController
@RequestMapping("/catalog/v1")
public class CatalogControllerV1 {

    @GetMapping(value = "/health", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Up and Kicking", HttpStatus.OK);
    }

    @PostMapping(value = Constants.UriConstants.LANDING_API,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLandingPage(@RequestBody LandingRequestDto landingRequestDto) {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
