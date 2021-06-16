package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.venator.models.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

}