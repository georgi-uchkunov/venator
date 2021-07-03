package com.hotel.venator.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.Comment;
import com.hotel.venator.repos.CommentRepository;

@RestController
public class CommentRest{
	
	private CommentRepository commentRepository;
	
	@Autowired
	public CommentRest(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@PostMapping(value = "/comment")
	public Comment comment(@RequestParam(name = "commenterName") String commenterName,
			@RequestParam(name = "commenterEmail") String commenterEmail,
			@RequestParam(name = "commenterComment") String commenterComment) {
		final Comment newComment = new Comment(commenterName, commenterEmail, commenterComment);
			return commentRepository.save(newComment);
	}
	
	@GetMapping("/getAllComments")
    public Page<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }
	
	@PostMapping("/deleteComment")
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