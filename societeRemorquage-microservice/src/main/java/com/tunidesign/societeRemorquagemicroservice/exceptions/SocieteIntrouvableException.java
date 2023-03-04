package com.tunidesign.societeRemorquagemicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SocieteIntrouvableException extends Exception{
    public SocieteIntrouvableException(String s) {
        super(s);
    }
}
