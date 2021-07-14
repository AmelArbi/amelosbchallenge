package com.amel.osbchallenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.amel.osbchallenge.model.ServiceInstance;
import com.amel.osbchallenge.model.ServiceOffering;
import com.amel.osbchallenge.model.ServicePlan;
import com.amel.osbchallenge.model.ServiveInstanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceInstanceServiceImpl implements ServiceInstanceService {

    private static final Logger logger = LoggerFactory.getLogger(ServiceInstanceServiceImpl.class);
    public static final String DASHBORD_BASE_URL = "http://example-dashboard.example.com/";

    private static List<ServiceOffering> serviceOfferings = new ArrayList<>();
    private static Map<String, ServiceInstance> serviceInstances = new HashMap<>();
    private static Map<String, ServiveInstanceResponse> serviceInstanceResponses = new HashMap<>();
    private static Map<String, String> dashboardPaths = new HashMap<>();

    public ServiceInstanceServiceImpl() {
        initServiceInstance();
    }

    @Override
    public List<ServiceOffering> getServiceOfferings() {
        return serviceOfferings;
    }

    @Override
    public ServiceInstance getInstance(String instanceId) {
        return serviceInstances.get(instanceId);
    }

    @Override
    public ServiceInstance createServiceInstance(String instanceId, ServiceInstance request) {
        ServiceInstance serviceInstance = request;
        serviceInstance.setInstanceId(instanceId);
        serviceInstances.put(instanceId, serviceInstance);
        logger.info("Service Instance with id {} created.", instanceId);
        return serviceInstance;
    }

    @Override
    public ServiveInstanceResponse getServiceInstanceResponse(String instanceId) {
        return serviceInstanceResponses.get(instanceId);
    }

    @Override
    public ServiveInstanceResponse createServiceInstanceResponse(ServiceInstance serviceInstance) {
        ServiveInstanceResponse response = new ServiveInstanceResponse();
        response.setDashboardUrl(DASHBORD_BASE_URL + getDashboardPath(serviceInstance.getInstanceId()));
        response.setOperation("task_10");
        serviceInstanceResponses.put(serviceInstance.getInstanceId(), response);
        return response;
    }

    private String getDashboardPath(String instanceId) {
        String dashboardPath = dashboardPaths.get(instanceId);
        if (dashboardPath == null) {
            dashboardPath = UUID.randomUUID().toString();
        }
        return dashboardPath;
    }

    private void initServiceInstance() {
        ServicePlan mysqlPlan1 = new ServicePlan();
        mysqlPlan1.setId(UUID.randomUUID().toString());
        mysqlPlan1.setName("MysqlPlan1");

        ServiceOffering serviceOffering1 = new ServiceOffering();
        serviceOffering1.setId("mysql_database");
        serviceOffering1.setName("Mysql");
        serviceOffering1.setDescription("Mysql Datenbank");
        serviceOffering1.setPlans(Arrays.asList(mysqlPlan1));

        ServicePlan sqsPlan1 = new ServicePlan();
        sqsPlan1.setId(UUID.randomUUID().toString());
        sqsPlan1.setName("SQSPlan1");

        ServiceOffering serviceOffering2 = new ServiceOffering();
        serviceOffering2.setId("sqs_service");
        serviceOffering2.setName("SQS");
        serviceOffering2.setDescription("Amazon Simple Queue Service");
        serviceOffering2.setPlans(Arrays.asList(sqsPlan1));

        serviceOfferings.add(serviceOffering1);
        serviceOfferings.add(serviceOffering2);
    }
}
