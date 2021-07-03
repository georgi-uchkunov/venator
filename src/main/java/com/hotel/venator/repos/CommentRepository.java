package com.hotel.venator.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.venator.models.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {


}