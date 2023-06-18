package com.priya.moviebooking.repository;

import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.priya.moviebooking.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

	@Query("{id:'?0'}")
	public User findUserById(String userId);
	@Query("{email:'?0'}")
	public User findByEmail(String email);
	@Query
	public void deleteById(String userId);

}
