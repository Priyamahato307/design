package com.priya.moviebooking.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.moviebooking.exception.SeatNotFoundException;
import com.priya.moviebooking.exception.TicketNotFoundException;
import com.priya.moviebooking.model.Booking;
import com.priya.moviebooking.model.Seat;
import com.priya.moviebooking.model.Tickets;
import com.priya.moviebooking.repository.BookingRepository;
import com.priya.moviebooking.repository.SeatRepo;
//import com.priya.moviebooking.repository.SeatRepository;
import com.priya.moviebooking.repository.TicketRepository;
import com.priya.moviebooking.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;
	List<Tickets> ti = new ArrayList<>();

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Autowired
	private SeatRepo seatRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Tickets addTicket(Tickets ticket,String transactionId) throws TicketNotFoundException {
		List<Booking> booking=new ArrayList<>();
		if(transactionId!=null) {
			booking=bookingRepository.findBytransId(transactionId);
			for(Booking b:booking) {
				b.setTransactionStatus("Completed");
				ticket.setBooking(b);
			}
//			booking.setTransactionStatus("Completed");
//			ticket.setBooking(booking);
			
		}
		
		ticketRepository.save(ticket);
		/*
		 * for(Seat s:ticket.getSeats()) { s.setTickett(ticket);
		 * seatRepository.saveAndFlush(s); }
		 */
		return ticket;
	}
	

	@Override
	public List<Tickets> viewTicketList() throws TicketNotFoundException {
	ti= ticketRepository.findAll();
		if (ti.size() == 0)
			throw new TicketNotFoundException("No tickets are avaliable");
		return ti;
	}

	@Override
	public Optional<Tickets> findTicket(String ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId);
	}



}


