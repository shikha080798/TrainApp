package com.hcl.trainapp.exception;

public class ErrorDetails {
	
	private String message;

	private int statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public ErrorDetails() {
		super();
		
	}
	

}
