package com.priya.moviebooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.priya.moviebooking.model.Seat;

@Repository
public interface SeatRepo extends MongoRepository<Seat, String> {
	@Query("{'seatId':?0}")
	public Seat findBySeatId(String seatId);
	@Query("{'seatStatus':?0}")
	public Seat findBySeatStatus(String seatStatus);
}
