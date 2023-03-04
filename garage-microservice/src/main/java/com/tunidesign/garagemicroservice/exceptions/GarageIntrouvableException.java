package com.tunidesign.garagemicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GarageIntrouvableException extends Exception{
    public GarageIntrouvableException(String s) {
        super(s);
    }
}
