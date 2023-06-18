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
import com.priya.moviebooking.controller.MovieController;
import com.priya.moviebooking.model.Movie;
import com.priya.moviebooking.model.User;
import com.priya.moviebooking.service.MovieService;

@SpringBootTest
public class MovieControllerTest {
	@Autowired
	MovieController movieController;
	@Mock
MovieService movieService;

	@Test
	public void contextLoads() throws Exception{
		Assertions.assertNotNull(movieController);
	}
	
	@Test 
	public void testAddMovie() throws Exception{
		List<Movie> movieList = new ArrayList<>();
		Movie movie = new Movie();
		movie.setId("20");
		movie.setMovieName("Movie1");
		movie.setTheatreName("theatre1");
		movie.setNoOfSeats(75);
		movieList.add(movie);
		Mockito.when(movieService.addMovie(movie)).thenReturn("Success");
		movieController.addMovie(movie);
		
		
	}
	
	@Test 
	public void testAllMovie() throws Exception{
		List<Movie> movieList = new ArrayList<>();
		Movie movie = new Movie();
		movie.setId("20");
		movie.setMovieName("Movie1");
		movie.setTheatreName("theatre1");
		movie.setNoOfSeats(75);
		movieList.add(movie);
		Movie movie1 = new Movie();
		movie1.setId("21");
		movie1.setMovieName("Movie2");
		movie1.setTheatreName("theatre2");
		movie1.setNoOfSeats(75);
		movieList.add(movie1);
		Mockito.when(movieService.getAllMovies()).thenReturn(movieList);
		movieController.getAllMovies();
		
		
	}
	
	@Test 
	public void testDeleteUser() throws Exception{
		List<Movie> movieList = new ArrayList<>();
		Movie movie = new Movie();
		movie.setId("20");
		movie.setMovieName("Movie1");
		movie.setTheatreName("theatre1");
		movie.setNoOfSeats(75);
		
	movieList.add(movie);
		Mockito.when(movieService.deleteMovie("30")).thenReturn("user deleted successfully");
		movieController.deleteMovie("30");
}
}
