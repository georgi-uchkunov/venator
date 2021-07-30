package com.hotel.venator.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.venator.models.Booking;
import com.hotel.venator.repos.BookingRepository;

@Service
public class BookingService {

	private BookingRepository bookingRepository;

	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public Booking createBooking(@RequestParam(name = "checkInDateReceived") String checkInDateReceived,
			@RequestParam(name = "checkOutDateReceived") String checkOutDateReceived,
			@RequestParam(name = "adults") byte adults, @RequestParam(name = "children") byte children,
			@RequestParam(name = "rooms") short rooms, @RequestParam(name = "servicePackage") String servicePackage,
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
	
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		if (bookings.isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(bookings);
	}
	
	public ResponseEntity<Booking> getSelectedBookingById(@RequestParam(name = "id") String id) {
		List<Booking> bookings = bookingRepository.findAll();
		for (int i = 0; i < bookings.size(); i++) {
			Booking currentBooking = bookings.get(i);
			String reservationNumber = currentBooking.getId().substring(18);
			if (reservationNumber.equals(id)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(currentBooking);
			}

		}
		return null;
	}
}