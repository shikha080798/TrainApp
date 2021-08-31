package com.hcl.trainapp.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@RestControllerAdvice
public class GlobalExceptionHandler extends Exception
{
	private static final long serialVersionUID = 4313385015068096311L;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandling(Exception exception,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setStatusCode(500);
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserDefinedException.class)
	public ResponseEntity<ErrorDetails> exceptionHandling(UserDefinedException exception){
	ErrorDetails errorDetails = new ErrorDetails();
	errorDetails.setMessage(exception.getMessage());
	errorDetails.setStatusCode(com.hcl.trainapp.ApiStatusCode.USER_ID);
	return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.OK);
	}
	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionHandling(TrainNotFoundException exception){
	ErrorDetails errorDetails = new ErrorDetails();
	errorDetails.setMessage(exception.getMessage());
	errorDetails.setStatusCode(com.hcl.trainapp.ApiStatusCode.TRAIN_NOT_FOUND);
	return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.OK);
	}

}
