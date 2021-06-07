package com.hotel.venator.models;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	public byte roomFloor;
	public byte roomNumber;
	public String serviceLevel;
	public boolean isBooked;

	public Room() {

	}

	public Room(byte roomNumber, byte roomFloor, String serviceLevel, boolean isBooked) {
		super();
		this.roomNumber = roomNumber;
		this.roomFloor = roomFloor;
		this.serviceLevel = serviceLevel;
		this.isBooked = isBooked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(byte roomFloor) {
		this.roomFloor = roomFloor;
	}

	public byte getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(byte roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

}