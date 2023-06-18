package com.priya.moviebooking.service;

import java.util.List;

import com.priya.moviebooking.model.Movie;

public interface MovieService {

	String addMovie(Movie movie);

	List<Movie> getAllMovies();

	String deleteMovie(String movieId);

}
