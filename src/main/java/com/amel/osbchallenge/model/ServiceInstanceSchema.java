package com.amel.osbchallenge.model;

import org.springframework.boot.context.properties.NestedConfigurationProperty;
import lombok.Data;

@Data
public class ServiceInstanceSchema {

    @NestedConfigurationProperty
    private InputParametersSchema create;

    @NestedConfigurationProperty
    private InputParametersSchema update;

}
