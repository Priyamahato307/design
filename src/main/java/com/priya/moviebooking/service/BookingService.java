package com.priya.moviebooking.service;

import java.time.LocalDate;
import java.util.List;

import com.priya.moviebooking.exception.BookingNotFoundException;
import com.priya.moviebooking.model.Booking;

public interface BookingService {
	//public Booking addBooking(Booking booking, Integer customerId,Integer showId) throws BookingNotFoundException;

	public List<Booking> viewBookingList() throws BookingNotFoundException;

	public Booking updateBooking(Booking booking) throws BookingNotFoundException;

	public String cancelBooking(String bookingid) throws BookingNotFoundException;

	public List<Booking> showAllBookings(String movieid) throws BookingNotFoundException;
	public Booking viewBooking(String bookingid) throws BookingNotFoundException;
	
	public double calculateTotalCost(String bookingid);

	Booking addBooking(Booking booking) throws BookingNotFoundException;
}
