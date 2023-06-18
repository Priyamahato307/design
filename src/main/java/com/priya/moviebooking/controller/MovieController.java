package com.priya.moviebooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.moviebooking.model.Movie;
import com.priya.moviebooking.service.MovieService;

@RestController
@RequestMapping("/moviebooking/1.0")
public class MovieController {

	private static Logger logger= LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addMovie")
	public String addMovie(@RequestBody Movie movie) {

		logger.info("------------Movie added Successfully-------------------");
		return movieService.addMovie(movie);
	}
	
	@GetMapping("/AllMovies")
	public List<Movie> getAllMovies( ) {

		logger.info("-------------All movies fetched Successfully-------------------");
		return movieService.getAllMovies();
	}
	
	@DeleteMapping("/deleteMovie/{movieId}")
	public String deleteMovie(@PathVariable String movieId) {

		logger.info("-------------Movie deleted Successfully-------------------");
		return movieService.deleteMovie(movieId);
		 
	}
}
