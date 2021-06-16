package com.hotel.venator.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	public LocalDate checkInDate;
	public LocalDate checkOutDate;
	public byte adults;
	public byte children;
	public short rooms;
	public String servicePackage;

	public String customerFirstName;
	public String customerLastName;
	public String customerEmail;
	public String customerPhoneNumber;
	public String location;
	public String nameCard;
	public String numberCard;

	public Booking() {

	}

	public Booking(LocalDate checkInDate, LocalDate checkOutDate, byte adults, byte children, short rooms,
			String servicePackage, String customerFirstName, String customerLastName, String customerEmail,
			String customerPhoneNumber, String location, String nameCard, String numberCard) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.adults = adults;
		this.children = children;
		this.rooms = rooms;
		this.servicePackage = servicePackage;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.location = location;
		this.nameCard = nameCard;
		this.numberCard = numberCard;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public byte getAdults() {
		return adults;
	}

	public void setAdults(byte adults) {
		this.adults = adults;
	}

	public byte getChildren() {
		return children;
	}

	public void setChildren(byte children) {
		this.children = children;
	}

	public short getRooms() {
		return rooms;
	}

	public void setRooms(short rooms) {
		this.rooms = rooms;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNameCard() {
		return nameCard;
	}

	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

}