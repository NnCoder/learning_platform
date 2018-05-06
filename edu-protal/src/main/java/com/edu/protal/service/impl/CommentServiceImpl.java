package com.edu.protal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.HttpClientUtil;
import com.edu.common.utils.JsonUtils;
import com.edu.protal.pojo.PageResult;
import com.edu.protal.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Value("${REST_KP_URL}")
	private String REST_KP_URL;
	@Value("${REST_COMMENT_URL}")
	private String REST_COMMENT_URL;
	
	@Override
	public PageResult getCommentsByKpId(int kpId) {
		String jsonData = HttpClientUtil.doGet(REST_KP_URL+"/"+kpId+"/comments");
		PageResult result = JsonUtils.jsonToPojo(jsonData, PageResult.class);
		return result;
	}

	@Override
	public HttpResult insertComment(Comment comment) {
		Map<String, String> params = new HashMap<>();
		params.put("kpId", String.valueOf(comment.getKpId()));
		params.put("userName", comment.getUserName());
		if(comment.getParentId() != null) {
			params.put("parentId", String.valueOf(comment.getParentId()));
		}
		params.put("commentContent", comment.getCommentContent());
		String string = HttpClientUtil.doPost(REST_COMMENT_URL, params);
		HttpResult result = HttpResult.format(string);
		return result;
	}
	
}
