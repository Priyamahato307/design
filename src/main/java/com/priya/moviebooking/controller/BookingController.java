package com.priya.moviebooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.priya.moviebooking.model.Booking;
//import com.priya.moviebooking.model.Screen;
import com.priya.moviebooking.exception.AccessForbiddenException;
import com.priya.moviebooking.exception.BookingNotFoundException;
import com.priya.moviebooking.service.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {

	Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingService bookingService;
	@Autowired
	LoginController loginController;

	/**
	 * 
	 * @param t
	 * @param customerId
	 * @return booking details
	 * @throws AccessForbiddenException
	 * @throws BookingNotFoundException
	 */
	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Booking> addTicketBooking(@RequestBody Booking t)
			throws AccessForbiddenException, BookingNotFoundException {
		/*
		 * if (!loginController.loginStatus()) throw new
		 * AccessForbiddenException("Not Logged In/Invalid Login");
		 */
		//logger.info("-------Booking For Customer " + customerId + "Added---------");
		return ResponseEntity.ok(bookingService.addBooking(t));
	}

	/**
	 * 
	 * @return bookingList
	 * @throws AccessForbiddenException
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/findall")
	public ResponseEntity<List<Booking>> viewAllBookings() throws AccessForbiddenException, BookingNotFoundException {
		/*
		 * if (!loginController.loginStatus()) throw new
		 * AccessForbiddenException("Not Logged In/Invalid Login");
		 */
		logger.info("-------List Of Bookings Fetched Successfully---------");
		return ResponseEntity.ok(bookingService.viewBookingList());
	}

	/**
	 * 
	 * @param t
	 * @return updated booking details
	 * @throws BookingNotFoundException
	 * @throws AccessForbiddenException
	 */
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Booking updateTicketBooking(@RequestBody Booking t)
			throws BookingNotFoundException, AccessForbiddenException {
		/*
		 * if (!loginController.loginStatus()) throw new
		 * AccessForbiddenException("Not Logged In/Invalid Loggin");
		 */
		logger.info("-------Booking Updated Successfully---------");
		return bookingService.updateBooking(t);
	}

	/**
	 * 
	 * @param bookingId
	 * @return deleted booking details
	 * @throws BookingNotFoundException
	 * @throws AccessForbiddenException
	 */
	@DeleteMapping("ticketbooking/{bookingId}")
	public String deleteTicketBookingById(@PathVariable String bookingId)
			throws BookingNotFoundException, AccessForbiddenException {
		/*
		 * if (!loginController.loginStatus()) throw new
		 * AccessForbiddenException("Not Logged In/Invalid Loggin");
		 */
		logger.info("-------Booking With Booking Id " + bookingId + " Deleted Successfully---------");
         return bookingService.cancelBooking(bookingId);
         
	}
	
	@GetMapping("/viewbooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable String bookingId)
			throws BookingNotFoundException {
		ResponseEntity<Booking> response = null;
		try {
			Booking booking = bookingService.viewBooking(bookingId);
			response = new ResponseEntity<>(booking, HttpStatus.OK);
			logger.info("-------Screen Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new BookingNotFoundException("Booking dosen't exist");
		}
		return response;
	}
	
	/**
	 * 
	 * @param movieId
	 * @return bookingList by movie id
	 * @throws AccessForbiddenException
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/byMovie/{movieId}")
	public ResponseEntity<List<Booking>> viewMovieByMovieId(@PathVariable String movieId)
			throws AccessForbiddenException, BookingNotFoundException {
		/*
		 * if (!loginController.loginStatus()) throw new
		 * AccessForbiddenException("Not Logged In/Invalid Loggin");
		 */
		logger.info("-------Bookings With MovieId " + movieId + " Fetched Successfully---------");
		return ResponseEntity.ok(bookingService.showAllBookings(movieId));
	}

	
	/**
	 * 
	 * @param bookingId
	 * @return total cost of booking
	 * @throws AccessForbiddenException
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/cost/{bookingId}")
	public double TotalBookingost(@PathVariable String bookingId)
			throws AccessForbiddenException, BookingNotFoundException {
		/*
		 * if (!loginController.loginStatus()) throw new
		 * AccessForbiddenException("Not Logged In/Invalid Loggin");
		 */
		logger.info("-------Total Cost Of Booking displayed Successfully---------");
		return bookingService.calculateTotalCost(bookingId);
	}
}
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.priya.moviebooking.model.Movie;
//import com.priya.moviebooking.model.Tickets;
//import com.priya.moviebooking.service.TicketService;
//
//@RestController
//@RequestMapping("/moviebooking/1.0")
//public class BookingController {
//
//	private static Logger logger= LoggerFactory.getLogger(BookingController.class);
//	@Autowired
//	private TicketService ticketService;
//	
//	@PostMapping("/bookTickets")
//	public String bookTickets(@RequestBody Tickets tickets) {
//		logger.info("-------------Ticket Booked Successfuly-------------------");
//				return ticketService.bookTickets(tickets);
//	}
//	
//	@GetMapping("/Allbooking")
//	public List<Tickets> getAllBookings( ) {
//		return ticketService.getAllbooking();
//	}
//	@GetMapping("/Allbooking/{movieName}")
//	public List<Tickets> getAllMoviesByMovieName(@PathVariable String movieName ) {
//		return ticketService.getAllBookingByMovieName(movieName);
//	}
//	
//	@DeleteMapping("/deleteBooking/{bookingId}")
//	public String deleteBooking(@PathVariable String bookingId) {
//
//		logger.info("-------------Booking cancelled Successfully-------------------");
//		return ticketService.deleteBooking(bookingId);
//		 
//	}
//}
