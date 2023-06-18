package com.priya.moviebooking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.moviebooking.model.Movie;
import com.priya.moviebooking.model.Tickets;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	@Query("{movieName:'?0'}")
	public List<Tickets> findByMovieName(String movieName);
	@Query
	public void deleteById(String movieId);
}
