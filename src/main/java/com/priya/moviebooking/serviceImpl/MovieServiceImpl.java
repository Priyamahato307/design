package com.priya.moviebooking.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.moviebooking.model.Movie;
import com.priya.moviebooking.repository.MovieRepository;
import com.priya.moviebooking.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepo;
	@Override
	public String addMovie(Movie movie) {
		movieRepo.save(movie);
		// TODO Auto-generated method stub
		return "Movie added successfully";
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		
		return movieRepo.findAll();
	}

	@Override
	public String deleteMovie(String movieId) {
		// TODO Auto-generated method stub
		 movieRepo.deleteById(movieId);
		 return "movie deleted successfully";
		
	}

}
