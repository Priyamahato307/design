package com.priya.moviebooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.moviebooking.exception.SeatNotFoundException;
import com.priya.moviebooking.model.Seat;
import com.priya.moviebooking.repository.SeatRepo;
import com.priya.moviebooking.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
	@Autowired
	private SeatRepo seatRepository;

	@Override
	public Seat addSeat(Seat seat) throws SeatNotFoundException {
		if (seat != null) {
			if (seatRepository.existsById(seat.getSeatId())) {
				throw new SeatNotFoundException("Seat with this id already exists");
			} else {
				seatRepository.save(seat);
			}
		}
		return seatRepository.findBySeatId(seat.getSeatId());
	}

	@Override
	public List<Seat> viewSeatList() throws SeatNotFoundException {
		List<Seat> li = seatRepository.findAll();
		/*
		 * if (li.size() == 0) throw new SeatNotFoundException("No seats found");
		 */
		return li;
	}

	@Override
	public Seat updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatRepository.save(seat);
	}

	@Override
	public Seat bookSeat(Seat seat) {
		seat.setStatus("BOOKED");
		return seatRepository.save(seat);
	}

	@Override
	public Seat cancelSeatBooking(Seat seat) {
		seat.setStatus("CANCELLED");
		return seatRepository.save(seat);
	}

//	@Override
//	public Seat blockSeat(Seat seat) {
//		seat.setStatus(SeatStatus.BLOCKED);
//		return seatRepository.save(seat);
//	}

}
