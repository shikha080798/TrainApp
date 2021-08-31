package com.hcl.trainapp.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class TrainNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public TrainNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	private String message;

	 public String getMessage() {
	return message;
	}

	 public void setMessage(String message) {
	this.message = message;
	}

}

