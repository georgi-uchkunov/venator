package com.hotel.venator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.Booking;
import com.hotel.venator.services.BookingService;

@RequestMapping("v1/booking")
@RestController
public class BookingRest {

	private BookingService bookingService;

	@Autowired
	public BookingRest(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping(value = "/create_booking")
	public ResponseEntity<Booking> createBooking(@RequestParam(name = "checkInDateReceived") String checkInDateReceived,
			@RequestParam(name = "checkOutDateReceived") String checkOutDateReceived,
			@RequestParam(name = "adults") byte adults, @RequestParam(name = "children") byte children,
			@RequestParam(name = "rooms") short rooms, @RequestParam(name = "servicePackage") String servicePackage,
			@RequestParam(name = "customerFirstName") String customerFirstName,
			@RequestParam(name = "customerLastName") String customerLastName,
			@RequestParam(name = "customerEmail") String customerEmail,
			@RequestParam(name = "customerPhoneNumber") String customerPhoneNumber,
			@RequestParam(name = "location") String location, @RequestParam(name = "nameCard") String nameCard,
			@RequestParam(name = "numberCard") String numberCard) {
		return bookingService.createBooking(checkInDateReceived, checkOutDateReceived, adults, children, rooms,
				servicePackage, customerFirstName, customerLastName, customerEmail, customerPhoneNumber, location,
				nameCard, numberCard);
	}

	@GetMapping(value = "/get_all_bookings")
	public ResponseEntity<List<Booking>> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping(value = "/get_selected_booking_by_id")
	public ResponseEntity<Booking> getSelectedBookingById(@RequestParam(name = "id") String id) {
		return bookingService.getSelectedBookingById(id);
	}

	@PostMapping(value = "/see_reason_for_denied_booking")
	public ResponseEntity<String> seeReasonForDeniedBooking(@RequestParam(name = "location") String location) {
		return bookingService.seeReasonForDeniedBooking(location);

	}
}