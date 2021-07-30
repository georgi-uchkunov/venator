package com.hotel.venator.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.services.LoginService;

@RestController
public class LoginRest {
	
	private LoginService loginService;

	@Autowired
	public LoginRest(final LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping(value = "/login")
	public String login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpSession session) {
		return loginService.login(username, password, session);
	}

	@PostMapping(value = "/logout")
	public String logout(HttpSession session) {
		return loginService.logout(session);
	}

	@GetMapping(value = "/access_control_user")
	public String preventUserAccess(HttpSession session) {
		return loginService.preventUserAccess(session);
	}

	@GetMapping(value = "/getCurrentUsername")
	public String getCurrentUsername(HttpSession session) {
		return loginService.getCurrentUsername(session);
	}
}
