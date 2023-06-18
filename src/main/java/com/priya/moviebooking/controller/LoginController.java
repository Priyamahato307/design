package com.priya.moviebooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.moviebooking.model.Login;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.serviceImpl.LoginServiceImpl;

@RestController
@RequestMapping("moviebooking/1.0")
public class LoginController {

	private static Logger logger= LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginServiceImpl loginservice;
	
	@GetMapping("/login/{email}/{password}")
	public String loginUser( @PathVariable String email, @PathVariable String password){
		logger.info("------------User loggedIn successfully----------");
		return loginservice.loginUser(email, password);
	}
	
	@PostMapping("/{email}/logout")
	public HttpStatus logOut(@PathVariable String email) throws Exception{
		logger.info("------------User log out successfully----------");
		if(loginservice.LoginStatus()) {
			loginservice.logOutUser(email);
			return HttpStatus.ACCEPTED;
			}
		else {
			throw new Exception("User not yet logged in");
		
		}
	}
	
	@PutMapping("/{email}/update")
	public String forgotPwd(@PathVariable String email, @RequestBody User user) {
	
		if(loginservice.LoginStatus()) {
			return loginservice.resetPassword(email, user);
		}
		else {
			return loginservice.forgotPassword(email, user);
		}
	
	}
	@GetMapping("/allLoginUser")
	public List<Login> getAllLoggedInUsers() {
		return loginservice.getAllLoggedInUsers();
	}
}
