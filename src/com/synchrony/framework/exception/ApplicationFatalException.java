package com.synchrony.framework.exception;

/**
 * Class used for application handling.
 * 
 * @author Rishal_singh
 *
 */
public class ApplicationFatalException extends Exception {

	/**
	 * @param message
	 * @param errorCode
	 * @param cause
	 */
	public ApplicationFatalException(String message, String errorCode, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ApplicationFatalException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationFatalException(String message, Throwable cause) {
		super(message);
	}

	/**
	 * @param message
	 */
	public ApplicationFatalException(String message) {
		super(message);
	}
}
