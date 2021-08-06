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
	private RoomService roomService;

	@Autowired
	public BookingService(BookingRepository bookingRepository, RoomService roomService) {
		this.bookingRepository = bookingRepository;
		this.roomService = roomService;
	}

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
		LocalDate checkInDate = LocalDate.parse(checkInDateReceived);
		LocalDate checkOutDate = LocalDate.parse(checkOutDateReceived);
		boolean isRequestedRoomAvailable = roomService.isRequestedRoomAvailable(location, servicePackage, checkInDate);
		if(isRequestedRoomAvailable != false) {
			final Booking newBooking = new Booking(checkInDate, checkOutDate, adults, children, rooms, servicePackage,
					customerFirstName, customerLastName, customerEmail, customerPhoneNumber, location, nameCard,
					numberCard);
			roomService.bookRequestedRoom(location, servicePackage, checkInDate, checkOutDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(bookingRepository.save(newBooking));
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	public ResponseEntity<String> seeReasonForDeniedBooking(@RequestParam(name = "location") String location){
		String locationUnavailable = "We apologise, but the hotel you have chosen is fully booked.";
		String servicePackageUnavailable = "We apologise, but there are no free rooms of your desired service level during this period.";
		boolean isRequestedLocationUnavailable = roomService.seeIfLocationIsUnavailable(location);
		if(isRequestedLocationUnavailable != false) {
			return ResponseEntity.status(HttpStatus.CREATED).body(locationUnavailable);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(servicePackageUnavailable);
		
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

	public Booking loadExampleBooking() {
		Booking exampleBooking = new Booking(LocalDate.now(), LocalDate.now().plusWeeks(1), (byte) 3, (byte) 3,
				(short) 3, "Advanced", "Adam", "Johnson", "adamjohnson@test.com", "359881234567", "Tokyo",
				"Adam J Johnson", "3700 0000 0000 002");
		return bookingRepository.save(exampleBooking);
	}
}