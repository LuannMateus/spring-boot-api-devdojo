package com.luanmateus.springessentials.handler;

import com.luanmateus.springessentials.util.error.ResourceNotFoundDetails;
import com.luanmateus.springessentials.util.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ResourceNotFoundDetails resourceNotFoundDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource Not Found")
                .detail(resourceNotFoundException.getMessage())
                .developerMessage(resourceNotFoundException.getClass().getName())
                .build();

        return new ResponseEntity<>(resourceNotFoundDetails, HttpStatus.NOT_FOUND);
    }
}
