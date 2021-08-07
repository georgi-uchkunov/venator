package com.hotel.venator.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.venator.models.Comment;
import com.hotel.venator.services.CommentService;

@RequestMapping("v1/comment")
@RestController
public class CommentRest{
	
	private CommentService commentService;
	
	@Autowired
	public CommentRest(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping(value = "/post_comment")
	public Comment comment(@RequestParam(name = "commenterName") String commenterName,
			@RequestParam(name = "commenterEmail") String commenterEmail,
			@RequestParam(name = "commenterComment") String commenterComment) {
		return commentService.comment(commenterName, commenterEmail, commenterComment);
	}
	
	@GetMapping("/get_all_comments")
    public ResponseEntity<List<Comment>> getAllComments() {
		return commentService.getAllComments();
    }
	
	@PostMapping("/delete_comment")
	public ResponseEntity<String> deleteComment(@RequestParam(name = "id") String id, HttpSession session) {
		return commentService.deleteComment(id, session);
	}
}