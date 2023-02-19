package com.tunidesign.utilisateurservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class InvalidPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidPasswordException(String message) {
        super(message);
        log.error(this.getClass().getName() + ": " + message);
    }
}