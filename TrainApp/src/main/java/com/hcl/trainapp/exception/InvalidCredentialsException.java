package com.hcl.trainapp.exception;

public class InvalidCredentialsException extends RuntimeException{
	String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public InvalidCredentialsException(String str) {
		super();
		this.str = str;
	}
	

	
}
