package com.edu.test.service;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.protal.pojo.CommentVo;
import com.edu.protal.pojo.PageResult;
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
		PageResult pageResult = commentService.getCommentsByKpId(20);
		System.out.println(pageResult.getPages());
		LinkedHashMap map = (LinkedHashMap) pageResult.getList().get(0);
		Set set = map.keySet();
		for(Object object : set) {
			System.out.println(object + "：" + map.get(object));
		}
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
