package com.edu.rest.service;

import java.util.List;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;

public interface NoticeService {
	
	public List<Notice> getNotices(Integer limit);
	
	public HttpResult getNotice(Integer noticeId);
}
