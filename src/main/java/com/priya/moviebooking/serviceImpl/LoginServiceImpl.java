package com.priya.moviebooking.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.moviebooking.model.Login;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.repository.LoginRepo;
import com.priya.moviebooking.repository.UserRepo;

@Service
public class LoginServiceImpl{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private LoginRepo loginRepo;
	private Login logData= new Login();
	
	public String loginUser(String email, String password) {
		User user= userRepo.findByEmail(email);
		if(!user.getPassword().equals(password)) 
			{
			logData.setLoginStatus(false);
			loginRepo.save(logData);
			return "Invalid UserName or password";
	
			}
		else {
			if(user.getEmail().equals(email)) {
			logData.setLoginStatus(true);
			logData.setEmail(email);
			logData.setPassword(password);
			loginRepo.save(logData);
		     return "User Login successfully";
			}else {
				
				return "user has already an active session";
			}
		}
	}
	
	public Login logOutUser(String email){
		//User user= userRepo.findByEmail(email);
		User user=userRepo.findByEmail(email);
		
		if(user.getEmail().equals(email)) {
		
			logData.setLoginStatus(false);
			loginRepo.delete(logData);
		}
		else {
			logData.setLoginStatus(true);
		  }
		
		return logData;
	}
	

	public boolean LoginStatus() {
		// TODO Auto-generated method stub
		return logData.getLoginStatus()	;
		}
	public List<Login> getAllLoggedInUsers() {
		return loginRepo.findAll();
	}
	public String forgotPassword(String email, User userdata) {
		User user=userRepo.findByEmail(email);
		if(user.getEmail().equals(email)) {
			user.setPassword(userdata.getPassword());
			user.setConfirmPassword(userdata.getConfirmPassword());
			userRepo.save(user);
		}
		return "Password changed successfully";
	}
	
	public String resetPassword(String email, User userdata) {
		User user=userRepo.findByEmail(email);
		if(user.getEmail().equals(email)) {
			user.setPassword(userdata.getPassword());
			user.setConfirmPassword(userdata.getConfirmPassword());
			userRepo.save(user);
			
		}
		return "Password reset successfully";
	}
	
	
}
