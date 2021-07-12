package com.amel.osbchallenge.service;

import java.util.List;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.model.ServiveInstanceRequest;
import com.amel.osbchallenge.model.ServiveInstanceResponse;

public interface ServiceOfferingService {

    List<ServiceOffering> getServiceOfferings();

    ServiceOffering getServiceOfferingById(String id);

    ServiveInstanceResponse createServiceInstance(ServiceOffering serviceOffering,
            ServiveInstanceRequest request);
}
