package com.hcl.trainapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserDefinedException extends RuntimeException {

	private static final long serialVersionUID = -3445379582808748497L;
	private String message;

	 public String getMessage() {
	return message;
	}

	 public void setMessage(String message) {
	this.message = message;
	}

	public UserDefinedException(String message) {
		super();
		this.message = message;
	}

	 
}
