package com.amel.osbchallenge.model;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

public class Schemas {

    @NestedConfigurationProperty
    private ServiceInstanceSchema serviceInstance;

    @NestedConfigurationProperty
    private ServiceBindingSchema serviceBinding;

}
