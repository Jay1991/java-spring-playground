package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		var response = new StudentErrorResponse();
		response.setMessage("Something went wrong!");
		response.setStatus(400);
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
