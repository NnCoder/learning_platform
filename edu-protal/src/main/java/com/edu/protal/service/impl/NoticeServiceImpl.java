package com.edu.protal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;
import com.edu.common.utils.HttpClientUtil;
import com.edu.common.utils.JsonUtils;
import com.edu.protal.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Value("${REST_NOTICE_URL}")
	private String REST_NOTICE_URL;
	
	@Override
	public List<Notice> listNotices(int limit) {
		String jsonData = HttpClientUtil.doGet(REST_NOTICE_URL+"?limit="+limit);
		List<Notice> list = JsonUtils.jsonToList(jsonData, Notice.class);
		return list;
	}

	@Override
	public Notice getNotice(int id) {
		String jsonData = HttpClientUtil.doGet(REST_NOTICE_URL+"/"+id);
		HttpResult result = HttpResult.formatToPojo(jsonData, Notice.class);
		Notice notice = (Notice) result.getData();
		return notice;
	}
	
	
}
