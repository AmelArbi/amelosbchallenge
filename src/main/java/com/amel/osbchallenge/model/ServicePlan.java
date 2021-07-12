package com.amel.osbchallenge.model;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ServicePlan {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private Object metadata;

    private Boolean free;

    private Boolean bindable;

    private Boolean planUpdatable;

    private Schemas schemas;

    private Integer maximumPollingDuration;

    private MaintenanceInfo maintenanceInfo;

}
