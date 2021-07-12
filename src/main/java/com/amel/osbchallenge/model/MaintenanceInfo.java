package com.amel.osbchallenge.model;

import javax.validation.constraints.NotEmpty;

public class MaintenanceInfo {

    @NotEmpty
    private String version;

    private String description;

}
