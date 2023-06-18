package com.priya.moviebooking.service;

import java.util.List;

import com.priya.moviebooking.exception.SeatNotFoundException;
import com.priya.moviebooking.model.Seat;

public interface SeatService {

	public Seat addSeat(Seat seat) throws SeatNotFoundException;

	public List<Seat> viewSeatList() throws SeatNotFoundException;

	public Seat updateSeat(Seat seat);

	public Seat bookSeat(Seat seat);

	public Seat cancelSeatBooking(Seat seat);
}
