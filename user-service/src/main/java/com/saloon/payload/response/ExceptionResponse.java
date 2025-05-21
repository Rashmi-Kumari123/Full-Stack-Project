package com.saloon.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private  String message;
    private  String error;
    private LocalDateTime timestamp;
}
