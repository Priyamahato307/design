package com.priya.moviebooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priya.moviebooking.controller.BookingController;
import com.priya.moviebooking.model.Booking;
import com.priya.moviebooking.model.Movie;
import com.priya.moviebooking.model.Tickets;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.service.BookingService;
import com.priya.moviebooking.service.TicketService;

@SpringBootTest
public class BookingControllerTest {
	@Autowired
	BookingController bookingController;
	@Mock
	BookingService bookingService;

	@Test
	public void contextLoads() throws Exception{
		Assertions.assertNotNull(bookingController);
	}
	
	@Test 
	public void testAddTicketBooking() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.addBooking(booking)).thenReturn(booking);
bookingController.addTicketBooking(booking);
		
		
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
bookingController.viewBooking("20");
		
		
	}
	
	@Test 
	public void testUpdateTicketBooking() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		LocalDate date1 = LocalDate.of(2020, 1, 20);
		booking.setBookingDate(date1);
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.updateBooking(booking)).thenReturn(booking);
       bookingController.updateTicketBooking(booking);
		
		
	}
	@Test 
	public void testViewAllBookings() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		LocalDate date1 = LocalDate.of(2020, 1, 20);
		booking.setBookingDate(date1);
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
bookingController.viewAllBookings();
		
		
	}
	@Test 
	public void testshowbookingByMovieId() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Movie movie=new Movie();
		movie.setId("123");
		movie.setMovieName("MOvie1");
		movie.setTheatreName("theatre1");
		movie.setNoOfSeats(20);

		Booking booking = new Booking();
		LocalDate date1 = LocalDate.of(2020, 1, 20);
		booking.setBookingDate(date1);
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		
		bookingList.add(booking);
		Mockito.when(bookingService.showAllBookings(movie.getId())).thenReturn(bookingList);
       bookingController.viewMovieByMovieId(movie.getId());
		
		
	}
//	
	
	@Test 
	public void testDeleteTicketBookingById() throws Exception{
		List<Booking> bookingList = new ArrayList<>();
		Booking booking = new Booking();
		booking.setTransactionId("20");
		booking.setTransactionStatus("Success");
		booking.setTotalCost(750);
		bookingList.add(booking);
		Mockito.when(bookingService.cancelBooking("20")).thenReturn("booking deleted");
bookingController.deleteTicketBookingById(booking.getTransactionId());
		
		
}
}
