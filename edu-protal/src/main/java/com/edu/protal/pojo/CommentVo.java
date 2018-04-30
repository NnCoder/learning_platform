package com.edu.protal.pojo;

import java.util.List;

import com.edu.common.pojo.Comment;

public class CommentVo extends Comment{
	
	private List<Comment> responses;

	public List<Comment> getResponses() {
		
		return responses;
	}

	public void setResponses(List<Comment> responses) {
		this.responses = responses;
	} 
}
