package com.amel.osbchallenge.model;

import lombok.Data;

@Data
public class ServiveInstanceResponse {

    private String dashboardUrl;

    private String operation;

    private ServiceInstanceMetadata metadata;

}
