package com.hotel.venator.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.venator.models.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
	
	List<Room> findRoomsByLocation(String location);
	
	List<Room> findRoomsByServicePackage(String servicePackage);
	
	List<Room> findRoomsByLocationAndServicePackage(String location, String servicePackage);

}