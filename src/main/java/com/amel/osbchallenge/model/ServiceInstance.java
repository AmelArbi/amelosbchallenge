package com.amel.osbchallenge.model;

import java.util.Map;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ServiceInstance {

    private String instanceId;

    @NotEmpty
    @JsonProperty("service_id")
    private String serviceId;

    @NotEmpty
    @JsonProperty("plan_id")
    private String planId;

    private Object context;

    @NotEmpty
    @JsonProperty("organization_guid")
    private String organizationGuid;

    @NotEmpty
    @JsonProperty("space_guid")
    private String spaceGuid;

    private Map<String, Object> parameters;

    @JsonProperty("maintenance_info")
    private MaintenanceInfo maintenanceInfo;

    @Override
    public boolean equals(Object other) {
        boolean result;
        if ((other == null) || (getClass() != other.getClass())) {
            result = false;
        } else {
            ServiceInstance otherServiceInstance = (ServiceInstance) other;
            result = serviceId.equals(otherServiceInstance.serviceId)
                    && planId.equals(otherServiceInstance.planId)
                    && spaceGuid.equals(otherServiceInstance.spaceGuid);
        }
        return result;
    }

}
