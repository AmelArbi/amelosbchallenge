package com.amel.osbchallenge.exception;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
