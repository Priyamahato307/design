package com.priya.moviebooking.service;

import java.util.List;

import com.priya.moviebooking.model.User;

public interface UserService {

String registerUser(User user) ;

List<User> getRegisterUser();

String deleteUser(String userId);
//User forgotPassword(String email, User userdata);

}
