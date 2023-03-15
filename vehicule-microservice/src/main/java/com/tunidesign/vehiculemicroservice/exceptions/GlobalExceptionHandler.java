package com.tunidesign.vehiculemicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContractNotFoundException.class)
    public ResponseEntity<String> AttributeLengthException(ContractNotFoundException e) {
        return new ResponseEntity<String>("ERROR: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
