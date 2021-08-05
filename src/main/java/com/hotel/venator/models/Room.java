package com.hotel.venator.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;


public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	public String servicePackage;
	public LocalDate checkInDate;
	public LocalDate checkOutDate;
	public String location;
	public boolean isBooked;

	public Room() {

	}

	public Room(String servicePackage, String location, boolean isBooked, LocalDate checkInDate, LocalDate checkOutDate) {
		super();
		this.servicePackage = servicePackage;
		this.location = location;
		this.isBooked = isBooked;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	
	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

}