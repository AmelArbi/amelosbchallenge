package com.amel.osbchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ServiveInstanceResponse {

    @JsonProperty("dashboard_url")
    private String dashboardUrl;

    private String operation;

    private ServiceInstanceMetadata metadata;

}
