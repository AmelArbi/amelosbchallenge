package com.amel.osbchallenge.controller;

import java.util.List;
import javax.validation.Valid;
import com.amel.osbchallenge.model.ServiceInstance;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.model.ServiveInstanceResponse;
import com.amel.osbchallenge.service.ServiceInstanceService;
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
    private final ServiceInstanceService serviceInstanceService;

    @GetMapping("/catalog")
    public ResponseEntity<List<ServiceOffering>> getCatalog() {
        List<ServiceOffering> services = serviceInstanceService.getServiceOfferings();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PutMapping("/service_instances/{instance_id}")
    public ResponseEntity<ServiveInstanceResponse> createServiceInstance(
            @PathVariable("instance_id") String instanceId,
            @RequestParam(value = "accepts_incomplete", required = false) Boolean acceptsIncomplete,
            @Valid @RequestBody ServiceInstance request
    ) {
        ServiceInstance serviceInstance = serviceInstanceService.getInstance(instanceId);
        if (serviceInstance == null) {
            logger.info("Service instance with id {} not found. Service instance will be created", instanceId);
            serviceInstance = serviceInstanceService.createServiceInstance(instanceId, request);
            return new ResponseEntity<>(serviceInstanceService.createServiceInstanceResponse(serviceInstance),
                    HttpStatus.CREATED);
        } else {
            if (serviceInstance.equals(request)) {
                ServiveInstanceResponse response = serviceInstanceService.getServiceInstanceResponse(instanceId);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        //@TODO implement return 202 Accepted and 422 Unprocessable Entity
    }

}
