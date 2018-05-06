package com.edu.protal.service;

import java.util.List;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.protal.pojo.CommentVo;
import com.edu.protal.pojo.PageResult;

public interface CommentService {
	PageResult getCommentsByKpId(int kpId);
	
	HttpResult insertComment(Comment comment);
}
