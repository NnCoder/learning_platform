package com.edu.protal.service;

import java.util.List;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.protal.pojo.CommentVo;

public interface CommentService {
	List<CommentVo> getCommentsByKpId(int kpId);
	
	HttpResult insertComment(Comment comment);
}
