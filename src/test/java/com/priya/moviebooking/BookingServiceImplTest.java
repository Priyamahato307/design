package com.priya.moviebooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priya.moviebooking.controller.BookingController;
import com.priya.moviebooking.model.Booking;
import com.priya.moviebooking.model.Movie;
import com.priya.moviebooking.model.Seat;
import com.priya.moviebooking.model.Tickets;
import com.priya.moviebooking.repository.BookingRepository;
import com.priya.moviebooking.repository.MovieRepository;
import com.priya.moviebooking.service.BookingService;
import com.priya.moviebooking.service.TicketService;
import com.priya.moviebooking.serviceImpl.BookingServiceImpl;
import com.priya.moviebooking.serviceImpl.TicketServiceImpl;

@SpringBootTest
public class BookingServiceImplTest {
	@Autowired
	BookingServiceImpl bookingServiceImpl;
	@Mock
	BookingService bookingService;
	@Mock 
	BookingRepository bookingRepo;

	@Mock 
	MovieRepository movierepo;
	@Test
	public void contextLoads() throws Exception{
		Assertions.assertNotNull(bookingServiceImpl);
	}
	
	@Test 
	public void testBookticket() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.addBooking(booking)).thenReturn(booking);
       bookingServiceImpl.addBooking(booking);
		
		
	}
	

	@Test 
	public void testViewBookings() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.viewBooking("20")).thenReturn(booking);
bookingServiceImpl.viewBooking("20");
		
		
	}
	
	@Test 
	public void testViewAllBookings() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Booking booking1 = new Booking();
		booking1.setTransactionId("22");
		booking1.setTransactionStatus("Success");
		booking1.setTotalCost(350);
		bookingList.add(booking1);
		Mockito.when(bookingService.viewBookingList()).thenReturn(bookingList);
bookingServiceImpl.viewBookingList();
		
		
	
	}
	
	@Test 
	public void testUpdateTicket() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.updateBooking(booking)).thenReturn(booking);
       bookingServiceImpl.updateBooking(booking);
		
		
	}
	@Test 
	public void testShowAllBookingsByMovieid() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Movie movie=new Movie();
		movie.setId("123");
		movie.setMovieName("MOvie1");
		movie.setTheatreName("theatre1");
		movie.setNoOfSeats(20);
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.showAllBookings(movie.getId())).thenReturn(bookingList);
       bookingServiceImpl.showAllBookings(movie.getId());
		
		
	}
	@Test 
	public void testCalculateTotaCost() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Set<Seat> seat=new HashSet<>();
		Movie movie=new Movie();
		movie.setId("123");
		movie.setMovieName("MOvie1");
		movie.setTheatreName("theatre1");
		movie.setNoOfSeats(20);
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750.00);
		bookingList.add(booking);
		Mockito.when(bookingService.calculateTotalCost(booking.getTransactionId())).thenReturn(booking.getTotalCost());
      // bookingServiceImpl.calculateTotalCost("730.00");
		
	}

//	
//	@Test 
//	public void testGetAllBookingsByMovieName() throws Exception{
//		List<Tickets> ticketList = new ArrayList<>();
//		Tickets ticket = new Tickets();
//		Movie movie=new Movie();
//		ticket.setBookingId("1231");
//		movie.setId("1");
//		movie.setMovieName("Movie1");
//		movie.setTheatreName("Theatre1");
//		movie.setNoOfSeats(100);
//		ticket.setMovie(movie);
//		ticket.setNoofSeats(2);
//	
//		ticketList.add(ticket);
//		Mockito.when(bookingService.getAllBookingByMovieName("Movie1")).thenReturn(ticketList);
//		Mockito.when(bookingRepo.findByMovieName(movie.getMovieName())).thenReturn(ticketList);
//		
//		bookingServiceImpl.getAllBookingByMovieName("Movie1");
//		
//		
//	}
	
	@Test 
	public void testCancelBooking() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.cancelBooking("20")).thenReturn("booking deleted");
bookingServiceImpl.cancelBooking(booking.getTransactionId());
		
		
}
}
