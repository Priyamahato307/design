package com.priya.moviebooking.exception;

public class MovieNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(String msg) {
		super(msg);
	}
}