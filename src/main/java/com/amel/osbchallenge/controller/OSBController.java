package com.amel.osbchallenge.controller;

import java.util.List;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.model.ServiveInstanceRequest;
import com.amel.osbchallenge.model.ServiveInstanceResponse;
import com.amel.osbchallenge.service.ServiceOfferingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/servicebroker/v2")
@AllArgsConstructor
public class OSBController {

    private static final Logger logger = LoggerFactory.getLogger(OSBController.class);
    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/catalog")
    public ResponseEntity<List<ServiceOffering>> getCatalog() {
        List<ServiceOffering> services = serviceOfferingService.getServiceOfferings();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PutMapping("/service_instances/{instance_id}")
    public ResponseEntity<ServiveInstanceResponse> createServiceInstance(
            @PathVariable("instance_id") String serviceInstanceId,
            @RequestParam(value = "accepts_incomplete", required = false) Boolean acceptsIncomplete,
            @RequestBody ServiveInstanceRequest request
    ) {
        //@TODO instance_id prüfen ob die bekannt ist und ggf speichern

        //getService Offering or throw EntityNotFoundException
        ServiceOffering serviceOffering = serviceOfferingService.getServiceOfferingById(request.getServiceId());
        ServiveInstanceResponse response = serviceOfferingService.createServiceInstance(serviceOffering, request);
        logger.info("Service Instance with id {} created ", serviceOffering.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
