package com.example.agencemicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AgenceIntrouvableException extends RuntimeException {
    public AgenceIntrouvableException(String s) {
        super(s);
    }
}
