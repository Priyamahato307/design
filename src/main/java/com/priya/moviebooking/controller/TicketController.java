package com.priya.moviebooking.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priya.moviebooking.exception.AccessForbiddenException;
import com.priya.moviebooking.exception.SeatNotFoundException;
import com.priya.moviebooking.exception.TicketNotFoundException;
import com.priya.moviebooking.model.Seat;
import com.priya.moviebooking.model.Tickets;
import com.priya.moviebooking.service.SeatService;
import com.priya.moviebooking.service.TicketService;


@RestController
@RequestMapping("/tickets")
public class TicketController {

	Logger logger = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	private TicketService ticketService;
	@Autowired
	private SeatService seatService;
	@Autowired
	LoginController loginController;

	/**
	 * 
	 * @param ticket
	 * @return added ticket
	 * @throws AccessForbiddenException
	 * @throws TicketNotFoundException
	 * @throws SeatNotFoundException 
	 */
	@PostMapping("/add")
	public ResponseEntity<Tickets> addATicket(@RequestBody Tickets ticket,@RequestParam(required = false) String bookingId)
			throws AccessForbiddenException, TicketNotFoundException, SeatNotFoundException {
		
		ticket = ticketService.addTicket(ticket,bookingId);
		 System.out.println(ticket.getSeats());
		
		logger.info("-------Ticket Created Successfully---------");
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return ticketList
	 * @throws AccessForbiddenException
	 * @throws TicketNotFoundException
	 */
	@GetMapping("/findall")
	public ResponseEntity<List<Tickets>> viewTicketList() throws AccessForbiddenException, TicketNotFoundException {
		
		logger.info("-------List of Tickets Found Successfully---------");
		return ResponseEntity.ok(ticketService.viewTicketList());
	}

	/**
	 * 
	 * @param ticketId
	 * @return ticket by ticketId
	 * @throws TicketNotFoundException
	 * @throws AccessForbiddenException
	 */
	@GetMapping("/{ticketId}")
	public Optional<Tickets> findATicket(@PathVariable String ticketId) throws TicketNotFoundException, AccessForbiddenException {	
		Optional<Tickets> t = null;
		try {
			t = ticketService.findTicket(ticketId);
			logger.info("-------Ticket with ticketId " + ticketId + " Foound Successfully---------");
		} catch (Exception e) {
			throw new TicketNotFoundException("Invalid Ticket ID");
		}
		return t;

	}

}
