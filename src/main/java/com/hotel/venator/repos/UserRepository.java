package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.venator.models.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmailAndPassword(final String email, final String password);

	User findByEmail(String email);

}