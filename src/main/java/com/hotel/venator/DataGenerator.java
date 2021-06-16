package com.hotel.venator;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.venator.models.Booking;
import com.hotel.venator.models.Customer;
import com.hotel.venator.models.Role;
import com.hotel.venator.models.Room;
import com.hotel.venator.models.User;
import com.hotel.venator.repos.BookingRepository;
import com.hotel.venator.repos.CustomerRepository;
import com.hotel.venator.repos.RoleRepository;
import com.hotel.venator.repos.RoomRepository;
import com.hotel.venator.repos.UserRepository;

@Component
public class DataGenerator {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private BookingRepository bookingRepository;
	private CustomerRepository customerRepository;
	private RoomRepository roomRepository;

	@Autowired
	public DataGenerator(RoleRepository roleRepository, UserRepository userRepository,
			BookingRepository bookingRepository, CustomerRepository customerRepository, RoomRepository roomRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.bookingRepository = bookingRepository;
		this.customerRepository = customerRepository;
		this.roomRepository = roomRepository;
	}

	@PostConstruct
	public void loadData() {
		if (userRepository.count() == 0) {
			User admin = new User();
			admin.setEmail("admin@admin.com");
			admin.setPassword("admin");
			admin.setUsername("admin");
			Role adminRole = new Role();
			adminRole.setCode("ADMIN");
			admin.addRole(roleRepository.save(adminRole));
			userRepository.save(admin);
		}
	}

	@PostConstruct
	public void loadExampleBooking() {
		if (bookingRepository.count() == 0) {
			Booking exampleBooking = new Booking();
			exampleBooking.setAdults((byte) 3);
			exampleBooking.setCheckInDate(LocalDate.now());
			exampleBooking.setCheckOutDate(LocalDate.now().plusWeeks(1));
			exampleBooking.setChildren((byte) 3);
			exampleBooking.setCustomerEmail("adamjohnson@test.com");
			exampleBooking.setCustomerFirstName("Adam");
			exampleBooking.setCustomerLastName("Johnson");
			exampleBooking.setCustomerPhoneNumber("21312414");
			exampleBooking.setServicePackage("Advanced");
			bookingRepository.save(exampleBooking);
		}
	}

	@PostConstruct
	public void loadExampleCustomers() {
		if (customerRepository.count() == 0) {
			customerRepository.save(new Customer("Alice", "Smith"));
			customerRepository.save(new Customer("Bob", "Smith"));
		}
	}

	@PostConstruct
	public void loadExampleRooms() {
		if (roomRepository.count() == 0) {
			roomRepository.save(new Room((byte) 10, (byte) 1, "Traditional", true));
			roomRepository.save(new Room((byte) 20, (byte) 2, "Luxurious", false));
			roomRepository.save(new Room((byte) 30, (byte) 3, "Imperial", true));
		}
	}

}