package com.hotel.venator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.venator.repos.UserRepository;
import com.hotel.venator.services.BookingService;
import com.hotel.venator.services.CommentService;
import com.hotel.venator.services.RegisterService;
import com.hotel.venator.services.RoomService;

@Component
public class DataGenerator {

	private CommentService commentService;
	private RoomService roomService;
	private BookingService bookingService;
	private RegisterService registerService;
	private UserRepository userRepository;

	@Autowired
	public DataGenerator(CommentService commentService, RoomService roomService, BookingService bookingService, RegisterService registerService, UserRepository userRepository) {
		super();
		this.commentService = commentService;
		this.roomService = roomService;
		this.bookingService = bookingService;
		this.registerService = registerService;
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void loadData() {
		if (userRepository.count() == 0) {
			registerService.loadExampleAdmin();
			roomService.loadAllRooms();
			bookingService.loadExampleBooking();
			commentService.loadExampleComment();
		}
	}

}