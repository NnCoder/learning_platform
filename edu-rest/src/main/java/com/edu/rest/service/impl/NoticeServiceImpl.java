package com.edu.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.NoticeMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;
import com.edu.common.pojo.NoticeExample;
import com.edu.rest.service.NoticeService;
import com.github.pagehelper.PageHelper;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> getNotices(Integer limit) {
		PageHelper.startPage(1, limit);
		List<Notice> notices = noticeMapper.selectByExample(new NoticeExample());
		return notices;
	}

	@Override
	public HttpResult getNotice(Integer noticeId) {
		Notice notice = noticeMapper.selectByPrimaryKey(noticeId);
		return HttpResult.ok(notice);
	}
	
}
