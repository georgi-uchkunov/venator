package com.hotel.venator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.venator.models.Role;
import com.hotel.venator.models.User;
import com.hotel.venator.repos.RoleRepository;
import com.hotel.venator.repos.UserRepository;

@Component
public class DataGenerator {
	private RoleRepository roleRepository;
	private UserRepository userRepository;

	@Autowired
	public DataGenerator(RoleRepository roleRepository, UserRepository userRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
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

}