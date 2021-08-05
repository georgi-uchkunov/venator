package com.hotel.venator.models;

import java.io.Serializable;
import org.springframework.data.annotation.Id;


public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	public String servicePackage;
	public String location;
	public boolean isBooked;

	public Room() {

	}

	public Room(String servicePackage, String location, boolean isBooked) {
		super();
		this.servicePackage = servicePackage;
		this.location = location;
		this.isBooked = isBooked;
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