package com.kashif.springdemo.exceptions;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException(String message) {
		super(message);
	}

}
