package com.priya.moviebooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.moviebooking.exception.UserRegistrationException;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.service.UserService;

@RestController
@RequestMapping("/moviebooking/1.0")
public class UserController {

	private static Logger logger= LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public String registerUser(@RequestBody User user)  {

		logger.info("-------------User Registered Successfully-------------------");
		return userService.registerUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getRegisterUser( ) {

		logger.info("-------------User details fetched Successfully-------------------");
		return userService.getRegisterUser();
	}
	
//	@PutMapping("/{email}/update")
//	public User forgotPwd(@PathVariable String email, @RequestBody User user) {
//		return userService.forgotPassword(email, user);
//	}
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") String userId) {
		logger.info("------------User deleted Successfully-------------------");
		userService.deleteUser(userId);
		return "user deleted successfully";
	}
	
}