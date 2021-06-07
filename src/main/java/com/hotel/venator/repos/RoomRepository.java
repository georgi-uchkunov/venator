package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.venator.models.Room;

public interface RoomRepository extends MongoRepository<Room, String> {

}