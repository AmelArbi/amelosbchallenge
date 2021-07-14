package com.amel.osbchallenge.model;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MaintenanceInfo {

    @NotEmpty
    private String version;

    private String description;

    @Override
    public boolean equals(Object other) {
        boolean result;
        if ((other == null) || (getClass() != other.getClass())) {
            result = false;
        } else {
            MaintenanceInfo maintenanceInfo = (MaintenanceInfo) other;
            result = version.equals(maintenanceInfo.getVersion());
        }
        return result;
    }

}
