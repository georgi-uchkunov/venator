package com.hotel.venator.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.venator.models.Room;
import com.hotel.venator.repos.RoomRepository;

@Service
public class RoomService {

	private RoomRepository roomRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public ResponseEntity<List<Room>> getAllRooms() {
		List<Room> rooms = roomRepository.findAll();
		if (rooms.isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(rooms);
	}

	public ResponseEntity<List<Room>> getAllRoomsByLocationAndServicePackage(String location, String servicePackage) {
		List<Room> rooms = roomRepository.findRoomsByLocationAndServicePackage(location, servicePackage);
		if (rooms.isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(rooms);
	}

	public boolean isRequestedRoomAvailable(String location, String servicePackage, LocalDate checkInDate) {
		List<Room> requestedRooms = roomRepository.findRoomsByLocationAndServicePackage(location, servicePackage);
		for (int i = 0; i < requestedRooms.size(); i++) {
			Room currentRoom = requestedRooms.get(i);
			if (currentRoom.isBooked != true && currentRoom.getCheckOutDate().isBefore(checkInDate)) {
				return true;
			}
		}
		return false;
	}

	public Room bookRequestedRoom(String location, String servicePackage, LocalDate checkInDate,
			LocalDate checkOutDate) {
		List<Room> requestedRooms = roomRepository.findRoomsByLocationAndServicePackage(location, servicePackage);
		for (int i = 0; i < requestedRooms.size(); i++) {
			Room currentRoom = requestedRooms.get(i);
			if (currentRoom.isBooked != true && currentRoom.getCheckOutDate().isBefore(checkInDate)) {
				currentRoom.setCheckInDate(checkInDate);
				currentRoom.setCheckOutDate(checkOutDate);
				currentRoom.setBooked(true);
				return roomRepository.save(currentRoom);
			}
		}
		return null;
	}

	public boolean seeIfLocationIsUnavailable(String location) {
		List<Room> requestedRooms = roomRepository.findRoomsByLocation(location);
		for (int i = 0; i < requestedRooms.size(); i++) {
			Room currentRoom = requestedRooms.get(i);
			if (currentRoom.isBooked != true) {
				return false;
			}
		}
		return true;
	}

	public void loadAllRooms() {
		loadAllNewYorkRooms();
		loadAllTokyoRooms();
		loadAllParisRooms();
		loadAllLondonRooms();
		loadAllRomeRooms();
	}

	public void loadAllRomeRooms() {
		for (int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "Rome", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "Rome", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "Rome", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}

	}

	public void loadAllLondonRooms() {
		for (int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "London", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "London", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "London", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}

	}

	public void loadAllParisRooms() {
		for (int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "Paris", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "Paris", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "Paris", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}

	}

	public void loadAllTokyoRooms() {
		for (int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "Tokyo", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "Tokyo", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "Tokyo", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}

	}

	public void loadAllNewYorkRooms() {
		for (int i = 0; i < 30; i++) {
			Room newRoom = new Room("Traditional", "New York", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 20; i++) {
			Room newRoom = new Room("Advanced", "New York", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}
		for (int i = 0; i < 10; i++) {
			Room newRoom = new Room("Luxury", "New York", false, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5));
			roomRepository.save(newRoom);
		}

	}

}
