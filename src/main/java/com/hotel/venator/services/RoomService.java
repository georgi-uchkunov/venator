package com.hotel.venator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.venator.models.Room;
import com.hotel.venator.repos.RoomRepository;

@Service
public class RoomService {
	
	private RoomRepository roomRepository;
	
	@Autowired
	public RoomService (RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public void loadAllRooms(){
		loadAllNewYorkRooms();
		loadAllTokyoRooms();
		loadAllParisRooms();
		loadAllLondonRooms();
		loadAllRomeRooms();
	}

	public void loadAllRomeRooms() {
		for(int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "Rome", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "Rome", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "Rome", false);
			roomRepository.save(newRoom);
		}
		
	}

	public void loadAllLondonRooms() {
		for(int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "London", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "London", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "London", false);
			roomRepository.save(newRoom);
		}
		
	}

	public void loadAllParisRooms() {
		for(int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "Paris", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "Paris", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "Paris", false);
			roomRepository.save(newRoom);
		}
		
	}

	public void loadAllTokyoRooms() {
		for(int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "Tokyo", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "Tokyo", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "Tokyo", false);
			roomRepository.save(newRoom);
		}
		
	}

	public void loadAllNewYorkRooms() {
		for(int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "New York", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "New York", false);
			roomRepository.save(newRoom);
		}
		for(int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "New York", false);
			roomRepository.save(newRoom);
		}
		
	}

}
