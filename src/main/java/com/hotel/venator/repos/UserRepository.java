package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.venator.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmailAndPassword(final String email, final String password);

	User findByEmail(final String email);
	
	User findByUsernameAndPassword(final String username, final String password);

}