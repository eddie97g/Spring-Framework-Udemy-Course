package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class CustomerControllerAdvice {

	@ExceptionHandler
	 public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
		 CustomerErrorResponse error = new CustomerErrorResponse();
		 
		 error.setMessage(exc.getMessage());
		 error.setStatus(HttpStatus.BAD_REQUEST.value());
		 error.setTimeStamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	 }
	
	@ExceptionHandler
	 public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		 CustomerErrorResponse error = new CustomerErrorResponse();
		 
		 error.setMessage(exc.getMessage());
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setTimeStamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
}
