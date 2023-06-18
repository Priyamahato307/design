package com.priya.moviebooking.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Movie")
public class Movie {
	@Id
	private String id;
	private String movieName;
	private String theatreName;
	private int noOfSeats;
	
	
	public Movie() {
		super();
	}
//	public Movie(String id, String movieName, String theatreName, int noOfSeats) {
//		super();
//		this.id = id;
//		this.movieName = movieName;
//		this.theatreName = theatreName;
//		this.noOfSeats = noOfSeats;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

}
