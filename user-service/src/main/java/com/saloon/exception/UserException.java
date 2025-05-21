package com.saloon.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserException {
    private String message;

    public UserException(String message) {
        this.message = message;
    }
}
