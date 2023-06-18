package com.priya.moviebooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.moviebooking.exception.UserRegistrationException;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.repository.UserRepo;
import com.priya.moviebooking.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	@Override
	public String registerUser(User user)  {
		// TODO Auto-generated method stub
		userRepo.save(user);
		return "User added successfully";
	}
	@Override
	public List<User> getRegisterUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@Override
	public String deleteUser(String userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
		return "user deleted successfully";
	}
//	@Override
//	public User forgotPassword(String email, User userdata) {
//		User user=userRepo.findByEmail(email);
//		if(user.getEmail().equals(email)) {
//			user.setPassword(userdata.getPassword());
//			user.setConfirmPassword(userdata.getConfirmPassword());
//			userRepo.save(user);
//		}
//		return user;
//	}


}
