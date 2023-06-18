package com.priya.moviebooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.moviebooking.model.Login;
import com.priya.moviebooking.model.User;

@Repository
public interface LoginRepo extends MongoRepository<Login, String> {

	@Query("{email:'?0'}")
	public Login findByEmail(String email);
}
