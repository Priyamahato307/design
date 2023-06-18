package com.priya.moviebooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.*;

import com.priya.moviebooking.exception.ResourceNotFoundException;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.repository.UserRepo;
import com.priya.moviebooking.service.MovieService;
import com.priya.moviebooking.serviceImpl.UserServiceImpl;

public class UserServiceTest {
	@Autowired
	MovieService movieService;
	
	 @Mock
	    private UserRepo userRepository;

	    @InjectMocks
	    private UserServiceImpl userService;

	    private User user;

	    @BeforeEach
	    public void setup(){
	        //userRepository = Mockito.mock(UserRepository.class);
	        //userService = new UserServiceImpl(userRepository);
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
		
	    }

	    // JUnit test for saveUser method
//	    @DisplayName("JUnit test for saveUser method")
//	    @Test
//	    public void givenUserObject_whenSaveUser_thenReturnUserObject(){
//	        // given - precondition or setup
//	       Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
//
//	        Mockito.when(userRepository.save(user)).thenReturn(user);
//
//	       
//	        // when -  action or the behaviour that we are going test
//	        String savedUser = userService.registerUser(user);
//
//	        System.out.println(savedUser);
//	        // then - verify the output
//	        Assertions.assertThat(savedUser).isNotNull();
//	    }
//
//	    // JUnit test for saveUser method
//	    @DisplayName("JUnit test for saveUser method which throws exception")
//	    @Test
//	    public void givenExistingEmail_whenSaveUser_thenThrowsException(){
//	        // given - precondition or setup
//	        given(userRepository.findByEmail(user.getEmail()))
//	                .willReturn(Optional.of(user));
//
//	        System.out.println(userRepository);
//	        System.out.println(userService);
//
//	        // when -  action or the behaviour that we are going test
//	        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
//	            userService.registerUser(user);
//	        });
//
//	        // then
//	        verify(userRepository, never()).save(any(User.class));
//	    }

	    // JUnit test for getAllUsers method
//	    @DisplayName("JUnit test for getAllUsers method")
//	    @Test
//	    public void givenUsersList_whenGetAllUsers_thenReturnUsersList(){
//	        // given - precondition or setup
//
//	    	User user = new User();
//			user.setFirstName("testfirstname");
//			user.setLastName("testlastname");
//			user.setEmail("testemail@abc.com");
//			user.setId("20");
//			user.setContactno("1234567890");
//			user.setRole("testrole");
//			user.setUserloginId("20");
//			user.setPassword("testpass");
//			user.setConfirmPassword("testpass");
//			userRepository.save(user);
//	        given(userRepository.findAll()).willReturn(List.of(user,user));
//
//	        // when -  action or the behaviour that we are going test
//	        List<User> userList = userService.getRegisterUser();
//
//	        // then - verify the output
//	        Assertions.assertThat(userList).isNotNull();
//	        Assertions.assertThat(userList.size()).isEqualTo(2);
//	    }

	    // JUnit test for getAllUsers method
//	    @DisplayName("JUnit test for getAllUsers method (negative scenario)")
//	    @Test
//	    public void givenEmptyUsersList_whenGetAllUsers_thenReturnEmptyUsersList(){
//	        // given - precondition or setup
//
//	    	User user = new User();
//			user.setFirstName("testfirstname");
//			user.setLastName("testlastname");
//			user.setEmail("testemail@abc.com");
//			user.setId("20");
//			user.setContactno("1234567890");
//			user.setRole("testrole");
//			user.setUserloginId("20");
//			user.setPassword("testpass");
//			user.setConfirmPassword("testpass");
//userRepository.save(user);
//	        given(userRepository.findAll()).willReturn(Collections.emptyList());
//
//	        // when -  action or the behaviour that we are going test
//	        List<User> userList = userService.getRegisterUser();
//
//	        // then - verify the output
//	        Assertions.assertThat(userList).isEmpty();
//	        Assertions.assertThat(userList.size()).isEqualTo(0);
//	    }

	    // JUnit test for getUserById method
//	    @DisplayName("JUnit test for getUserById method")
//	    @Test
//	    public void givenUserId_whenGetUserById_thenReturnUserObject(){
//	        // given
//	        given(userRepository.findUserById("1")).willReturn(Optional.of(user));
//
//	        // when
//	        User savedUser = userService.getUserById(user.getId()).get();
//
//	        // then
//	        assertThat(savedUser).isNotNull();
//
//	    }

//	    // JUnit test for updateUser method
//	    @DisplayName("JUnit test for updateUser method")
//	    @Test
//	    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser(){
//	        // given - precondition or setup
//	        given(userRepository.save(user)).willReturn(user);
//	        user.setEmail("ram@gmail.com");
//	        user.setFirstName("Ram");
//	        // when -  action or the behaviour that we are going test
//	        User updatedUser = userService.updateUser(user);
//
//	        // then - verify the output
//	        assertThat(updatedUser.getEmail()).isEqualTo("ram@gmail.com");
//	        assertThat(updatedUser.getFirstName()).isEqualTo("Ram");
//	    }

	    // JUnit test for deleteUser method
//	    @DisplayName("JUnit test for deleteUser method")
//	    @Test
//	    public void givenUserId_whenDeleteUser_thenNothing(){
//	        // given - precondition or setup
//	        long userId = 1L;
//
//	        willDoNothing().given(userRepository).deleteById(userId);
//
//	        // when -  action or the behaviour that we are going test
//	        userService.deleteUser(userId);
//
//	        // then - verify the output
//	        verify(userRepository, times(1)).deleteById(userId);
//	    }
//	}
	
	

}
