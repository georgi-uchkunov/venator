package com.hotel.venator.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.venator.models.Comment;
import com.hotel.venator.repos.CommentRepository;

@Service
public class CommentService {
	
private CommentRepository commentRepository;
	
	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Comment comment(@RequestParam(name = "commenterName") String commenterName,
			@RequestParam(name = "commenterEmail") String commenterEmail,
			@RequestParam(name = "commenterComment") String commenterComment) {
		final Comment newComment = new Comment(commenterName, commenterEmail, commenterComment);
			return commentRepository.save(newComment);
	}
	
	public Page<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }
	
	public ResponseEntity<String> deleteComment(@RequestParam(name = "id") String id, HttpSession session) {
		List<com.hotel.venator.models.Comment> comments = commentRepository.findAll();
		Comment commentForDelete = comments.stream().filter(comment -> id == comment.getId()).findFirst()
				.orElse(null);
		if (null != commentForDelete) {
			comments.remove(commentForDelete);
			commentRepository.deleteById(commentForDelete.getId());
		}
		return ResponseEntity.ok().body("Comment with id: " + id + " has been deleted");
	}
}