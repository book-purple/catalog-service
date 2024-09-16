package com.bookpurple.catalog.controller;

import com.bookpurple.catalog.bo.EventBo;
import com.bookpurple.catalog.bo.LandingRequestBo;
import com.bookpurple.catalog.bo.ServiceBo;
import com.bookpurple.catalog.bo.banner.BannerBo;
import com.bookpurple.catalog.bo.banner.BannerRequestBo;
import com.bookpurple.catalog.bo.banner.BannerResponseBo;
import com.bookpurple.catalog.component.ILandingPageProvider;
import com.bookpurple.catalog.constant.Constants;
import com.bookpurple.catalog.dto.*;
import com.bookpurple.catalog.mapper.CatalogMapper;
import com.bookpurple.catalog.service.IBannerService;
import com.bookpurple.catalog.service.IEventService;
import com.bookpurple.catalog.service.IServicesService;
import com.bookpurple.catalog.util.DummyCatalogProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Written by Gaurav Sharma on 19 May 2019
 */
@RestController
@RequestMapping("/catalog/v1")
public class CatalogControllerV1 {

    @Autowired
    private ILandingPageProvider landingPageProvider;

    @Autowired
    private DummyCatalogProvider dummyCatalogProvider;

    @Autowired
    private IEventService eventService;

    @Autowired
    private IServicesService servicesService;

    @Autowired
    private CatalogMapper catalogMapper;

    @Autowired
    private IBannerService bannerService;

    @GetMapping(value = "/health", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Up and Kicking", HttpStatus.OK);
    }

    /**
     * Landing API to fetch Landing page related data.
     * @param landingRequestDto landingRequestDto
     * @return LandingResponseDto landingResponseDto
     */
    @PostMapping(value = Constants.UriConstants.LANDING_API,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LandingPageResponseDto> getLandingPage(@RequestBody LandingRequestDto landingRequestDto) {
        LandingRequestBo landingRequestBo = catalogMapper.convertLandingRequestDtoToBo(landingRequestDto);
        LandingPageResponseDto landingPageResponseDto = landingPageProvider.getLandingPageData(landingRequestBo);
        return new ResponseEntity<>(landingPageResponseDto, HttpStatus.OK);
    }

    @PostMapping(value = Constants.UriConstants.EVENT_LISTING_API,
    consumes = APPLICATION_JSON_VALUE,
    produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEventListing() {
        return new ResponseEntity("success", HttpStatus.OK);
    }

    /**
     * API to get all events.
     * @return EventDto
     */
    @GetMapping(value = Constants.UriConstants.GET_ALL_EVENT,
    produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventDto>> getAllEvent() {
        List<EventDto> eventDtos = catalogMapper.convertEventBoListToDtoList(eventService.findAllEvent());
        return new ResponseEntity(eventDtos, HttpStatus.OK);
    }

    /**
     * API to add new event.
     * @param eventDto eventDto
     * @return success as string
     */
    @PostMapping(value = Constants.UriConstants.ADD_EVENT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEvent(@RequestBody EventDto eventDto) {
        EventBo eventBo = catalogMapper.convertEventDtoToBo(eventDto);
        eventService.createEvent(eventBo);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    /**
     * API to add dummy data for events.
     * @return success as string
     */
    @GetMapping(value = Constants.UriConstants.ADD_DUMMY_EVENT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDummyEvents() {
        eventService.addDummyEvents(dummyCatalogProvider.getDummyEventProvider());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    /**
     * API to get all services.
     * @return EventDto
     */
    @GetMapping(value = Constants.UriConstants.GET_ALL_SERVICES,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        List<ServiceDto> serviceDtos = catalogMapper.convertServiceBoListToDtoList(servicesService.findAllServices());
        return new ResponseEntity(serviceDtos, HttpStatus.OK);
    }

    /**
     * API to add new service.
     * @param serviceDto serviceDto
     * @return success as string
     */
    @PostMapping(value = Constants.UriConstants.ADD_SERVICE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addService(@RequestBody ServiceDto serviceDto) {
        ServiceBo serviceBo = catalogMapper.convertServiceDtoToBo(serviceDto);
        servicesService.createService(serviceBo);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    /**
     * API to add dummy data for services.
     * @return success as string
     */
    @GetMapping(value = Constants.UriConstants.ADD_DUMMY_SERVICES, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDummyServices() {
        servicesService.addDummyServices(dummyCatalogProvider.getDummyServiceProvider());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping(value = Constants.UriConstants.ADD_BANNER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addBanner(@RequestBody BannerRequestDto bannerRequestDto){
        BannerRequestBo bannerRequestBo = catalogMapper.convertBannerRequestDtoToBo(bannerRequestDto);
        bannerService.createBanner(bannerRequestBo);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping(value = Constants.UriConstants.GET_ALL_BANNERS,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BannerResponseDto> getAllBanners(){
        List<BannerBo> bannerBos = bannerService.findAllBanners();
        BannerResponseBo bannerResponseBo = BannerResponseBo.builder()
                .banners(bannerBos)
                .build();
        BannerResponseDto bannerResponseDto = catalogMapper.convertBannerResponseBoToDto(bannerResponseBo);
        return new ResponseEntity<>(bannerResponseDto, HttpStatus.OK);
    }
}
