package com.edu.test.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.protal.pojo.CommentVo;
import com.edu.protal.service.CommentService;

public class CommentServiceTest {
	
	private static CommentService commentService;
	
	@BeforeClass
	public static void beforeClass() {
		ApplicationContext atx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		commentService = atx.getBean(CommentService.class);
	}
	
	@Test
	public void testGetCommentsByKpId() {
		List<CommentVo> commentsByKpId = commentService.getCommentsByKpId(12);
		int size = commentsByKpId.size();
		for(CommentVo commentVo : commentsByKpId) {
			System.out.println(commentVo.getUserName() + ":" + commentVo.getCommentContent());
		}
		System.out.println(size);
	}
	
	@Test
	public void testInsert() throws UnsupportedEncodingException {
		Comment comment = new Comment();
		comment.setCommentContent("hello world");
		comment.setKpId(12);
		comment.setUserName("04151307 陈晓涛");
		HttpResult result = commentService.insertComment(comment);
		System.out.println(result.getMsg());
	}
}
