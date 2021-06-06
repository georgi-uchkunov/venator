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
	public String servicePackage;
	public short price;
	
	public String customerFirstName;
	public String customerLastName;
	public String customerEmail;
	public int customerPhoneNumber;

	public Booking() {

	}

	public Booking(LocalDate checkInDate, LocalDate checkOutDate, byte adults, byte children, String servicePackage,
			short price, String customerFirstName, String customerLastName, String customerEmail, int customerPhoneNumber) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.adults = adults;
		this.children = children;
		this.servicePackage = servicePackage;
		this.price = price;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
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

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public short getPrice() {
		return price;
	}

	public void setPrice(short price) {
		this.price = price;
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

	public int getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	

}