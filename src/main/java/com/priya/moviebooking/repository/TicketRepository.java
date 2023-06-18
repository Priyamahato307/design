package com.priya.moviebooking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.moviebooking.model.Tickets;

@Repository
public interface TicketRepository extends MongoRepository<Tickets, String> {

	@Query("{'ticketId':?0}")
	public Optional<Tickets> findById(String ticketId);
}
