package com.tunidesign.ordremicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderIntrouvableException extends RuntimeException {
    public OrderIntrouvableException(String s) {
        super(s);
    }
}
