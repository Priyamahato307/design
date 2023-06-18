package com.priya.moviebooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Seat {
	@Id
	private String seatId;
	private String seatNumber;
	private String type;
	private double price;
	
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@DBRef
	private Tickets ticket;
	
	public Seat() {
	}
	public Seat(String seatNumber, String type, double price, Tickets ticket) {
		super();
		this.seatNumber = seatNumber;
		this.type = type;
		this.price = price;
		this.ticket = ticket;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Tickets getTicket() {
		return ticket;
	}
	public void setTicket(Tickets ticket) {
		this.ticket = ticket;
	}

}