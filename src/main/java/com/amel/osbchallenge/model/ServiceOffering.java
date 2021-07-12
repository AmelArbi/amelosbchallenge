package com.amel.osbchallenge.model;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ServiceOffering {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private List<String> tags;

    private List<String> requires;

    private Boolean bindable;

    private Boolean instancesRetrievable;

    private Boolean bindingsRetrievable;

    private Boolean allowContextUpdates;


    private Object metadata;

    private DashboardClient dashboardClient;

    private Boolean planUpdateable;

    private List<ServicePlan> plans;

}
