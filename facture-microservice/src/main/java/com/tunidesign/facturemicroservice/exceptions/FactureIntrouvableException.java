package com.tunidesign.facturemicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FactureIntrouvableException extends RuntimeException {
    public FactureIntrouvableException(String s) {
        super(s);
    }
}
