package com.hotel.venator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.User;
import com.hotel.venator.services.RegisterService;

@RestController
public class RegisterRest {

	private RegisterService registerService;

	@Autowired
	public RegisterRest(final RegisterService registerService) {
		this.registerService = registerService;
	}

	@PostMapping("/register_user")
	public User registerUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "username") String username, @RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "address") String address,
			@RequestParam(name = "gender") String gender, @RequestParam(name = "password") String password,
			@RequestParam(name = "dateOfBirthString") String dateOfBirthString) {
		return registerService.registerUser(email, username, firstName, lastName, address, gender, password, dateOfBirthString);
	}
}