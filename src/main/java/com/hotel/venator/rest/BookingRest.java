package com.hotel.venator.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.Booking;
import com.hotel.venator.repos.BookingRepository;

@RestController
public class BookingRest {

	private BookingRepository bookingRepository;

	@Autowired
	public BookingRest(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@PostMapping(value = "/createBooking")
	public Booking createBooking(@RequestParam(name = "checkInDateReceived") String checkInDateReceived,
			@RequestParam(name = "checkOutDateReceived") String checkOutDateReceived, @RequestParam(name = "adults") byte adults,
			@RequestParam(name = "children") byte children, @RequestParam(name = "rooms") short rooms,
			@RequestParam(name = "servicePackage") String servicePackage,
			@RequestParam(name = "customerFirstName") String customerFirstName,
			@RequestParam(name = "customerLastName") String customerLastName,
			@RequestParam(name = "customerEmail") String customerEmail,
			@RequestParam(name = "customerPhoneNumber") String customerPhoneNumber,
			@RequestParam(name = "location") String location, @RequestParam(name = "nameCard") String nameCard,
			@RequestParam(name = "numberCard") String numberCard) {
		LocalDate checkInDate = LocalDate.parse(checkInDateReceived);
		LocalDate checkOutDate = LocalDate.parse(checkOutDateReceived);
		final Booking newBooking = new Booking(checkInDate, checkOutDate, adults, children, rooms, servicePackage,
				customerFirstName, customerLastName, customerEmail, customerPhoneNumber, location, nameCard,
				numberCard);
		return bookingRepository.save(newBooking);
	}
}