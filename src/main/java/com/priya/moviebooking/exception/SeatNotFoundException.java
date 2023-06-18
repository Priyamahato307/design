package com.priya.moviebooking.exception;

public class SeatNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public SeatNotFoundException(String msg) {
		super(msg);
	}
}
