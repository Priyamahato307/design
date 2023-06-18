package com.priya.moviebooking.exception;

public class AccessForbiddenException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccessForbiddenException(String msg) {
		super(msg);
	}
}