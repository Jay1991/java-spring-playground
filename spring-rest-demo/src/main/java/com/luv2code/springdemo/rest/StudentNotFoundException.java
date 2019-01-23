package com.luv2code.springdemo.rest;

public class StudentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8209932589450585406L;

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
}
