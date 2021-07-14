package com.amel.osbchallenge.service;

import java.util.List;
import com.amel.osbchallenge.model.ServiceInstance;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.model.ServiveInstanceResponse;

public interface ServiceInstanceService {

    List<ServiceOffering> getServiceOfferings();

    ServiceInstance getInstance(String instanceId);

    ServiceInstance createServiceInstance(String instanceId, ServiceInstance request);

    ServiveInstanceResponse getServiceInstanceResponse(String instanceId);

    ServiveInstanceResponse createServiceInstanceResponse(ServiceInstance serviceInstance);
}
