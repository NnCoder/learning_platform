package com.edu.protal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.protal.pojo.User;
import com.edu.protal.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comments")
	@ResponseBody
	public HttpResult insertComment(Comment comment, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String username = "匿名";
		if(user != null) {
			if(user.getRole().equals("student")) {
				username = user.getUserAccount()+" "+user.getUserName();
			}else {
				username = user.getUserName();
			}
			comment.setUserName(username);
			HttpResult result = commentService.insertComment(comment);
			return result;
		}
		
		return HttpResult.build(403, "无权提问");
	}
	
	@RequestMapping("/comments")
	@ResponseBody
	public String ok() {
		return "ok";
	}
}
