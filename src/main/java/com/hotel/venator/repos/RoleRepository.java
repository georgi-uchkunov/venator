package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hotel.venator.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

  

}