package com.priya.moviebooking;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.priya.moviebooking.controller.UserController;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.service.UserService;

@SpringBootTest
public class UserControllerTest {
	@Autowired
	UserController userController;
	@Mock
	UserService userService;

	@Test
	public void contextLoads() throws Exception{
		Assertions.assertNotNull(userController);
	}
	
	@Test 
	public void testGetRegisterUser() throws Exception{
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setFirstName("testfirstname");
		user.setLastName("testlastname");
		user.setEmail("testemail@abc.com");
		user.setId("20");
		user.setContactno("1234567890");
		user.setRole("testrole");
		user.setUserloginId("20");
		user.setPassword("testpass");
		user.setConfirmPassword("testpass");
		userList.add(user);
		Mockito.when(userService.getRegisterUser()).thenReturn(userList);
		userController.getRegisterUser();
		
		
	}
	
	@Test 
	public void testRegisterUser() throws Exception{
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setFirstName("testfirstname1");
		user.setLastName("testlastname1");
		user.setEmail("testtemail@abc.com");
		user.setId("30");
		user.setContactno("1234567891");
		user.setRole("testtrole");
		user.setUserloginId("30");
		user.setPassword("testtpass");
		user.setConfirmPassword("testtpass");
		userList.add(user);
		Mockito.when(userService.registerUser(user)).thenReturn("Success");
		userController.registerUser(user);
		
		
		
	}
	
	@Test 
	public void testDeleteUser() throws Exception{
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setFirstName("testfirstname1");
		user.setLastName("testlastname1");
		user.setEmail("testtemail@abc.com");
		user.setId("30");
		user.setContactno("1234567891");
		user.setRole("testtrole");
		user.setUserloginId("30");
		user.setPassword("testtpass");
		user.setConfirmPassword("testtpass");
		userList.add(user);
		Mockito.when(userService.deleteUser("30")).thenReturn("user deleted successfully");
		userController.deleteUser("30");
}
}
