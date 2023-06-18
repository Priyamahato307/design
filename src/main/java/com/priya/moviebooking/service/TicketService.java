package com.priya.moviebooking.service;

import java.util.List;
import java.util.Optional;

import com.priya.moviebooking.exception.TicketNotFoundException;
import com.priya.moviebooking.model.Tickets;
public interface TicketService {
	public Tickets addTicket(Tickets ticket,String bookingId) throws TicketNotFoundException;

	public Optional<Tickets> findTicket(String ticketId);

	List<Tickets> viewTicketList() throws TicketNotFoundException;

}
