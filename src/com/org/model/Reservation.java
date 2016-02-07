package com.org.model;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
	
	private int id;
	private String name;
	private String email;
	private int telephone;
	private String Message;
	private int noOfAttendees;
	private Date date;
	private Time time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getNoOfAttendees() {
		return noOfAttendees;
	}
	public void setNoOfAttendees(int noOfAttendees) {
		this.noOfAttendees = noOfAttendees;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

	
	
}
