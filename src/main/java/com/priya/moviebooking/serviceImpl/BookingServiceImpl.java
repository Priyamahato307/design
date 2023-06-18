package com.priya.moviebooking.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.moviebooking.model.Booking;
import com.priya.moviebooking.model.Seat;
import com.priya.moviebooking.model.Tickets;
//import com.priya.moviebooking.repoImpl.QueryClass;
import com.priya.moviebooking.exception.BookingNotFoundException;
import com.priya.moviebooking.repository.BookingRepository;
import com.priya.moviebooking.repository.MovieRepository;
import com.priya.moviebooking.repository.TicketRepository;
import com.priya.moviebooking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	MovieRepository moviesRepository;
	
	@Autowired
	TicketRepository ticketRepository;


	@Override
	public Booking addBooking(Booking booking) throws BookingNotFoundException {
//		Customer customer = new Customer();
//		Show show=new Show();
		/*
		 * if (bookingRepository.existsById(booking.getTransactionId())) { throw new
		 * BookingNotFoundException("Booking with this transcationId is already done");
		 * } else {}
		 */
		
			bookingRepository.save(booking);
		return bookingRepository.findById(booking.getTransactionId());
	}

	@Override
	public Booking updateBooking(Booking booking) throws BookingNotFoundException {
		bookingRepository.save(booking);
		return bookingRepository.findById(booking.getTransactionId());
	}

	@Override
	public String cancelBooking(String bookingid) throws BookingNotFoundException {
		Booking b = bookingRepository.findById(bookingid);
		bookingRepository.delete(b);
		return "booking deeted successfully";
	}

	@Override
	public List<Booking> showAllBookings(String movieid) throws BookingNotFoundException {
		List<Booking> bk = bookingRepository.getAllByMovieId(movieid);
		/*
		 * if (bk.size() == 0) throw new BookingNotFoundException("No bookings found");
		 */
		return bk;
	}



	@Override
	public double calculateTotalCost(String bookingid) {
		List<Tickets> tickets = ticketRepository.findAll();
		Set<Seat> Seats = new HashSet<>();
		for (Tickets ticket : tickets) {
			if (bookingid == ticket.getBooking().getTransactionId()) {
				Seats.addAll(ticket.getSeats());
			}
		}
		double amount = 0;
		for (Seat seat : Seats) {
			amount = amount + seat.getPrice();
		}
		Booking booking = bookingRepository.findById(bookingid);
		booking.setTotalCost(amount);
		bookingRepository.save(booking);
		return amount;
	}

	@Override
	public List<Booking> viewBookingList() throws BookingNotFoundException {
		List<Booking> bk = bookingRepository.findAll();
		/*
		 * if (bk.size() == 0) throw new BookingNotFoundException("No bookings found");
		 */
		return bk;
	}

	@Override
	public Booking viewBooking(String bookingid) throws BookingNotFoundException {
		return bookingRepository.findById(bookingid);
	}


}