package com.hotel.venator.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.venator.models.Role;
import com.hotel.venator.models.User;
import com.hotel.venator.repos.RoleRepository;
import com.hotel.venator.repos.UserRepository;

@Service
public class LoginService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public LoginService(final UserRepository userRepository, final RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	public String login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpSession session) {
		final User currentUser = userRepository.findByUsernameAndPassword(username, password);
		Role adminRole = roleRepository.findByCode("ADMIN");
		if (null != currentUser) {
			session.setAttribute("currentUser", currentUser);
			if (currentUser.getRoles().contains(adminRole)) {
				return "home_admin";
			} else {
				return "home";
			}
		}
		return "/";
	}

	public String logout(HttpSession session) {
		session.invalidate();
		return "/";
	}


	public String preventUserAccess(HttpSession session) {
		final User currentUser = (User) session.getAttribute("currentUser");
		Role adminRole = roleRepository.findByCode("ADMIN");

		if (currentUser != null && currentUser.getRoles().contains(adminRole)) {
			return "ACCEPTED";
		} else {
			session.invalidate();
			return "/";
		}
	}


	public String getCurrentUsername(HttpSession session) {
		final User currentUser = (User) session.getAttribute("currentUser");
		String username = currentUser.getUsername();
		return username;
	}
}
