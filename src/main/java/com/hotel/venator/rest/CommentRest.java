package com.hotel.venator.rest;

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
import com.hotel.venator.services.CommentService;

@RestController
public class CommentRest{
	
	private CommentService commentService;
	
	@Autowired
	public CommentRest(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping(value = "/comment")
	public Comment comment(@RequestParam(name = "commenterName") String commenterName,
			@RequestParam(name = "commenterEmail") String commenterEmail,
			@RequestParam(name = "commenterComment") String commenterComment) {
		return commentService.comment(commenterName, commenterEmail, commenterComment);
	}
	
	@GetMapping("/getAllComments")
    public Page<Comment> getAllComments(Pageable pageable) {
		return commentService.getAllComments(pageable);
    }
	
	@PostMapping("/deleteComment")
	public ResponseEntity<String> deleteComment(@RequestParam(name = "id") String id, HttpSession session) {
		return commentService.deleteComment(id, session);
	}
}