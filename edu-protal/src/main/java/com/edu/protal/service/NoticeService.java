package com.edu.protal.service;

import java.util.List;

import com.edu.common.pojo.Notice;

public interface NoticeService {
	List<Notice> listNotices(int limit);
	
	Notice getNotice(int id);
}
