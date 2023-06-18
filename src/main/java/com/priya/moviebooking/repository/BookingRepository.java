package com.priya.moviebooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.moviebooking.model.Booking;
import com.priya.moviebooking.model.Tickets;
import com.priya.moviebooking.model.User;

@Repository
public interface BookingRepository  extends MongoRepository<Booking, Integer> {
	@Query("{'transactionId':?0}")
	public Booking findById(String transactionId);
	@Query("{'transactionId':?0}")
	public List<Booking> findBytransId(String transactionId);
	@Query("{'movieId':?0}")
	public List<Booking> getAllByMovieId(String movieId);
//	@Query("{'movieName':?0}")
//	public List<Tickets> findByMovieName(String movieName);
}
