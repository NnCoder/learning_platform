package com.edu.rest.service;

import java.util.List;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.rest.pojo.CommentVo;

public interface CommentService {
	
	/**
	 * 根据知识点获取评论列表
	 * @param kpId
	 * @return
	 */
	List<CommentVo> getCommentsByKpId(int kpId, int page, int rows);
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	HttpResult insertComment(Comment comment);
}
