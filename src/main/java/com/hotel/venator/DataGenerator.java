package com.hotel.venator;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.venator.models.Booking;
import com.hotel.venator.models.Role;
import com.hotel.venator.models.User;
import com.hotel.venator.repos.BookingRepository;
import com.hotel.venator.repos.RoleRepository;
import com.hotel.venator.repos.UserRepository;

@Component
public class DataGenerator {
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private BookingRepository bookingRepository;

	@Autowired
	public DataGenerator(RoleRepository roleRepository, UserRepository userRepository, BookingRepository bookingRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.bookingRepository = bookingRepository;
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
		if(bookingRepository.count() == 0) {
			Booking exampleBooking = new Booking();
			exampleBooking.setAdults((byte) 3);
			exampleBooking.setCheckInDate(LocalDate.now());
			exampleBooking.setCheckOutDate(LocalDate.now().plusWeeks(1));
			exampleBooking.setChildren((byte) 3);
			exampleBooking.setCustomerEmail("adamjohnson@test.com");
			exampleBooking.setCustomerFirstName("Adam");
			exampleBooking.setCustomerLastName("Johnson");
			exampleBooking.setCustomerPhoneNumber(885555555);
			exampleBooking.setPrice((short) 500);
			exampleBooking.setServicePackage("Advanced");
			bookingRepository.save(exampleBooking);
		}
	}

}