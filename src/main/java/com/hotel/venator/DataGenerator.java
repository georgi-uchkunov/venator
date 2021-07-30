package com.hotel.venator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.venator.repos.UserRepository;
import com.hotel.venator.services.BookingService;
import com.hotel.venator.services.CommentService;
import com.hotel.venator.services.RegisterService;

@Component
public class DataGenerator {

	private CommentService commentService;
	private BookingService bookingService;
	private RegisterService registerService;
	private UserRepository userRepository;

	@Autowired
	public DataGenerator(CommentService commentService, BookingService bookingService, RegisterService registerService, UserRepository userRepository) {
		super();
		this.commentService = commentService;
		this.bookingService = bookingService;
		this.registerService = registerService;
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void loadData() {
		if (userRepository.count() == 0) {
			registerService.loadExampleAdmin();
			bookingService.loadExampleBooking();
			commentService.loadExampleComment();
		}
	}

}