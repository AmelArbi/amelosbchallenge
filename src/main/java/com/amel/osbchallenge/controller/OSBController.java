package com.amel.osbchallenge.controller;

import java.util.List;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.service.ServiceOfferingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/servicebroker/v2")
@AllArgsConstructor
public class OSBController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/catalog")
    public ResponseEntity<List<ServiceOffering>> getCatalog() {
        List<ServiceOffering> services = serviceOfferingService.getServiceOfferings();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

}
