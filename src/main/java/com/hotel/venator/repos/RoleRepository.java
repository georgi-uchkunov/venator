package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.venator.models.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

  

}