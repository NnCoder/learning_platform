package com.edu.rest.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.CommentMapper;
import com.edu.common.pojo.Comment;
import com.edu.common.pojo.CommentExample;
import com.edu.common.pojo.CommentExample.Criteria;
import com.edu.common.pojo.HttpResult;
import com.edu.rest.pojo.CommentVo;
import com.edu.rest.pojo.PageResult;
import com.edu.rest.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<CommentVo> getCommentsByKpId(int kpId, int page, int rows) {
		PageHelper.startPage(page, rows);
		//初始化返回结果集
		List<CommentVo> resultList = new ArrayList<>();
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andKpIdEqualTo(kpId);
		criteria.andParentIdIsNull();
		example.setOrderByClause("comment_time desc");
		List<Comment> list = commentMapper.selectByExampleWithBLOBs(example);
		//定义弱引用
		CommentVo vo = null;
		Comment childVo = null;
		List<Comment> childs = null;
		List<Comment> responses = null;
		//遍历
		for (Comment comment :list) {
			//获取评论基本信息
			vo = new CommentVo();
			vo.setCommentContent(comment.getCommentContent());
			vo.setCommentId(comment.getCommentId());
			vo.setCommentTime(comment.getCommentTime());
			vo.setUserName(comment.getUserName());
			//获取回复信息
			example = new CommentExample();
			criteria = example.createCriteria();
			criteria.andParentIdEqualTo(comment.getCommentId());
			childs = commentMapper.selectByExampleWithBLOBs(example);
			responses = new ArrayList<>();
			for (Comment child : childs) {
				childVo = new Comment();
				childVo.setCommentContent(child.getCommentContent());
				childVo.setUserName(child.getUserName());
				childVo.setCommentTime(child.getCommentTime());
				responses.add(childVo);
			}
			vo.setResponses(responses);
			resultList.add(vo);
		}
		return resultList;
	}

	@Override
	public HttpResult insertComment(Comment comment) {
		comment.setCommentTime(new Date());
		commentMapper.insertSelective(comment);
		return HttpResult.ok();
	}

	@Override
	public PageResult getCommentsByKpIdForPage(int kpId, int page, int rows) {
		PageHelper.startPage(page, rows);
		//初始化返回结果集
		List<CommentVo> resultList = new ArrayList<>();
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andKpIdEqualTo(kpId);
		criteria.andParentIdIsNull();
		example.setOrderByClause("comment_time desc");
		List<Comment> list = commentMapper.selectByExampleWithBLOBs(example);
		//分页
		PageInfo<Comment> pageInfo = new PageInfo<>(list);
		PageResult result = new PageResult();
		result.setTotal(pageInfo.getTotal());
		result.setPages(pageInfo.getPages());
		//定义弱引用
		CommentVo vo = null;
		Comment childVo = null;
		List<Comment> childs = null;
		List<Comment> responses = null;
		//遍历
		for (Comment comment :list) {
			//获取评论基本信息
			vo = new CommentVo();
			vo.setCommentContent(comment.getCommentContent());
			vo.setCommentId(comment.getCommentId());
			vo.setCommentTime(comment.getCommentTime());
			vo.setUserName(comment.getUserName());
			//获取回复信息
			example = new CommentExample();
			criteria = example.createCriteria();
			criteria.andParentIdEqualTo(comment.getCommentId());
			childs = commentMapper.selectByExampleWithBLOBs(example);
			responses = new ArrayList<>();
			for (Comment child : childs) {
				childVo = new Comment();
				childVo.setCommentContent(child.getCommentContent());
				childVo.setUserName(child.getUserName());
				childVo.setCommentTime(child.getCommentTime());
				responses.add(childVo);
			}
			vo.setResponses(responses);
			resultList.add(vo);
		}
		result.setList(resultList);
		return result;
	}
	
}
