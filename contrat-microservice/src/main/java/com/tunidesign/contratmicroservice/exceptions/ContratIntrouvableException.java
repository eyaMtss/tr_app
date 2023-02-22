package com.tunidesign.contratmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContratIntrouvableException extends RuntimeException {
    public ContratIntrouvableException(String s) {
        super(s);
    }
}
