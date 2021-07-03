package com.hotel.venator.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	public String id;
	private String commenterName;
	private String commenterEmail;
	private String commenterComment;
	
	public Comment() {
		
	}
	
	public Comment(String commenterName, String commenterEmail, String commenterComment) {

		this.commenterName = commenterName;
		this.commenterEmail = commenterEmail;
		this.commenterComment = commenterComment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public String getCommenterEmail() {
		return commenterEmail;
	}

	public void setCommenterEmail(String commenterEmail) {
		this.commenterEmail = commenterEmail;
	}

	public String getCommenterComment() {
		return commenterComment;
	}

	public void setCommenterComment(String commenterComment) {
		this.commenterComment = commenterComment;
	}
	
	
}