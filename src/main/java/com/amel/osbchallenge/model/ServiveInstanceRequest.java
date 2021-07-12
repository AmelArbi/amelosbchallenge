package com.amel.osbchallenge.model;

import java.util.Map;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ServiveInstanceRequest {

    @NotEmpty
    private String serviceId;

    @NotEmpty
    private String planId;

    private String context;

    @NotEmpty
    private String organizationGuid;

    @NotEmpty
    private String spaceGuid;

    private Map<String, Object> parameters;

    private MaintenanceInfo maintenanceInfo;
}
