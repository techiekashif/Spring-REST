package com.kashif.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kashif.springdemo.exceptions.StudentNotFoundException;

@ControllerAdvice
public class StudentRestGlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);

	}
}
