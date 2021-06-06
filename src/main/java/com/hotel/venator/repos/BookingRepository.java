package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.venator.models.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

}