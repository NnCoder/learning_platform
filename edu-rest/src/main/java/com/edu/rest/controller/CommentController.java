package com.edu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.rest.pojo.CommentVo;
import com.edu.rest.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/kp/{kpId}/comments")
	@ResponseBody
	public List<CommentVo> getCommentsByKpId(
			@PathVariable Integer kpId, 
			@RequestParam(defaultValue="1") int page, 
			@RequestParam(defaultValue="10") int rows){
		List<CommentVo> list = commentService.getCommentsByKpId(kpId,page,rows);
		return list;
	}
	
	@RequestMapping(value="/comments", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertComment(Comment comment) {
		HttpResult result = commentService.insertComment(comment);
		return result;
	}
}
