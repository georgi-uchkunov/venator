package com.hotel.venator.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.venator.models.Role;
import com.hotel.venator.models.User;
import com.hotel.venator.repos.RoleRepository;
import com.hotel.venator.repos.UserRepository;

@Service
public class RegisterService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public RegisterService(final UserRepository userRepository, final RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	
	public User registerUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "username") String username, @RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "address") String address,
			@RequestParam(name = "gender") String gender, @RequestParam(name = "password") String password,
			@RequestParam(name = "dateOfBirthString") String dateOfBirthString) {
		LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
		final User newUser = new User(email, username, password, firstName, lastName, dateOfBirth);
		Role userRole = roleRepository.findByCode("USER");
		newUser.addRole(roleRepository.save(userRole));
		return userRepository.save(newUser);

	}
	
	public User loadExampleAdmin() {
		User admin = new User("admin@admin.com", "JohnS", "admin", "John", "Smith" , LocalDate.of(1981, 07, 21));
		admin.addRole(makeAdminRole());
		return userRepository.save(admin);
	}
	
	public Role makeAdminRole() {
		Role adminRole = new Role();
		adminRole.setCode("ADMIN");
		return roleRepository.save(adminRole);
	}
}
