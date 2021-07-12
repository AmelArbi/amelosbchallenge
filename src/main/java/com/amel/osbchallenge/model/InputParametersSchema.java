package com.amel.osbchallenge.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class InputParametersSchema {

    private final Map<String, Object> parameters = new HashMap<>();

}
