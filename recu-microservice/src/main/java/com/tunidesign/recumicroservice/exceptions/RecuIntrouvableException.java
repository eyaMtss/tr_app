package com.tunidesign.recumicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecuIntrouvableException extends RuntimeException {
    public RecuIntrouvableException(String s) {
        super(s);
    }
}
