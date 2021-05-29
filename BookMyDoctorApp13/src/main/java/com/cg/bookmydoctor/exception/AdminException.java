package com.cg.bookmydoctor.exception;

public class AdminException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	String message;

	public AdminException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
