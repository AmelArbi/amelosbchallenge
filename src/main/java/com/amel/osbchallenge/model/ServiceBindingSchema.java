package com.amel.osbchallenge.model;

import org.springframework.boot.context.properties.NestedConfigurationProperty;
import lombok.Data;

@Data
public class ServiceBindingSchema {

    @NestedConfigurationProperty
    private InputParametersSchema create;

}
