package com.tunidesign.utilisateurservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class CustomException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException (String message) {
		super(message);
	}
}
