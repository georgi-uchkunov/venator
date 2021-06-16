package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.venator.models.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {


}