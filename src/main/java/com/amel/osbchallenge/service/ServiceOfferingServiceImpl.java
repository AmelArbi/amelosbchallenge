package com.amel.osbchallenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import com.amel.osbchallenge.exception.EntityNotFoundException;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.model.ServicePlan;
import com.amel.osbchallenge.model.ServiveInstanceRequest;
import com.amel.osbchallenge.model.ServiveInstanceResponse;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    public static final String DASHBORD_BASE_URL = "http://example-dashboard.example.com/";
    private static List<ServiceOffering> serviceOfferings;

    @Override
    public List<ServiceOffering> getServiceOfferings() {
        initServiceOffering();
        return serviceOfferings;
    }

    @Override
    public ServiceOffering getServiceOfferingById(String id) throws EntityNotFoundException {
        return serviceOfferings.stream()
                .filter(so -> so.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("service with id: %s not found ", id)));
    }

    @Override
    public ServiveInstanceResponse createServiceInstance(ServiceOffering serviceOffering,
            ServiveInstanceRequest request) {

        //@TODO create service instance
        ServiveInstanceResponse response = new ServiveInstanceResponse();
        response.setDashboardUrl(DASHBORD_BASE_URL + UUID.randomUUID());
        response.setOperation("task_10");
        return response;
    }

    private void initServiceOffering() {
        if (serviceOfferings == null) {
            ServicePlan servicePlan1 = new ServicePlan();
            servicePlan1.setId(UUID.randomUUID().toString());
            servicePlan1.setName("plan1");

            ServiceOffering serviceOffering1 = new ServiceOffering();
            serviceOffering1.setId(UUID.randomUUID().toString());
            serviceOffering1.setName("service1");
            serviceOffering1.setDescription("service1");
            serviceOffering1.setPlans(Arrays.asList(servicePlan1));

            ServicePlan servicePlan2 = new ServicePlan();
            servicePlan2.setId(UUID.randomUUID().toString());
            servicePlan2.setName("plan2");

            ServiceOffering serviceOffering2 = new ServiceOffering();
            serviceOffering2.setId(UUID.randomUUID().toString());
            serviceOffering2.setName("service2");
            serviceOffering2.setDescription("service2");
            serviceOffering2.setPlans(Arrays.asList(servicePlan2));

            serviceOfferings = new ArrayList<>();
            serviceOfferings.add(serviceOffering1);
            serviceOfferings.add(serviceOffering2);
        }
    }
}
