package com.priya.moviebooking;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.priya.moviebooking.exception.TicketNotFoundException;
import com.priya.moviebooking.model.Booking;
import com.priya.moviebooking.model.Tickets;
import com.priya.moviebooking.repository.BookingRepository;
import com.priya.moviebooking.repository.TicketRepository;
import com.priya.moviebooking.service.TicketService;
import com.priya.moviebooking.serviceImpl.TicketServiceImpl;

@SpringBootTest
public class TicketServiceImplTest {

	@Autowired
	TicketService ticketService;
	
	@Autowired
	TicketServiceImpl ticketServiceImpl;
	
	@Mock
	BookingRepository bookingRepository;
	
	@Mock
	TicketRepository ticketRepository;
	
	@Test
	public void  contextLoads() throws Exception{
		Assertions.assertNotNull(ticketServiceImpl);
	}
	
	@Test
	public void testAddTicket() throws Exception{
		Booking booking=new Booking();
		Tickets ticket=new Tickets();
		ticket.setTicketId("12");
		ticket.setNoOfSeats(2);
		ticket.setTicketStatus(true);
		LocalDate date1 = LocalDate.of(2020, 1, 20);
		List<Booking> bookingList=new ArrayList<>();
		Booking booking1 = new Booking();
		booking1.setTransactionId("22");
		booking1.setTransactionStatus("Success");
		booking1.setBookingDate(date1);
		booking1.setTotalCost(850);
		ticket.setBooking(booking1);
		bookingList.add(booking1);
		String transactionId="22";
		when(bookingRepository.findBytransId(transactionId)).thenReturn(bookingList);
//		Mockito.when(ticketService.addTicket(ticket,"12" )).thenReturn(ticket);
     ticketServiceImpl.addTicket(ticket,"12");
 	
	}
	
	@Test
	public void testViewTicketList() throws Exception{
		List<Tickets> tickets= new ArrayList<>();
		Tickets ticket=new Tickets();
		ticket.setTicketId("12");
		ticket.setNoOfSeats(2);
		ticket.setTicketStatus(true);
		LocalDate date1 = LocalDate.of(2020, 1, 20);
		Booking booking1 = new Booking();
		booking1.setTransactionId("22");
		booking1.setTransactionStatus("Success");
		booking1.setBookingDate(date1);
		booking1.setTotalCost(850);
		ticket.setBooking(booking1);
		tickets.add(ticket);
		Tickets ticket1=new Tickets();
		ticket1.setTicketId("13");
		ticket1.setNoOfSeats(2);
		ticket1.setTicketStatus(true);
		LocalDate date2 = LocalDate.of(2020, 1, 20);
		Booking booking2 = new Booking();
		booking2.setTransactionId("22");
		booking2.setTransactionStatus("Success");
		booking2.setBookingDate(date1);
		booking2.setTotalCost(850);
		ticket1.setBooking(booking2);
		tickets.add(ticket1);
		//when(bookingRepository.findById(transactionId)).thenReturn(booking1);
		Mockito.when(ticketService.viewTicketList()).thenReturn(tickets);
     ticketServiceImpl.viewTicketList();
 }
	@Test
	public void testViewTicketListExceptioncase() throws Exception{
		List<Tickets> tickets= mock(List.class);
		System.out.println("size ---sss"+tickets.size());
		//ReflectionTestUtils.setField(ticketServiceImpl,"ti",tickets);
		List<Tickets> t=new ArrayList<>();
	//when(ticketRepository.findAll()).thenReturn(tickets);
	when(tickets.size()).thenReturn(0);

t=ticketService.viewTicketList();
assertThrows(TicketNotFoundException.class,()->ticketService.viewTicketList());
	
	}
}

