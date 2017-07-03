package com.synchrony.framework.exception;

public class ApplicationBusinessException extends Exception {

	public ApplicationBusinessException(String message) {
		super(message);
	}

	public ApplicationBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
