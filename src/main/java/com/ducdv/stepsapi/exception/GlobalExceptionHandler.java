package com.ducdv.stepsapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleCustomException(ApiException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }
}