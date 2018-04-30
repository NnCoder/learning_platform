package com.edu.manager.service;


import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;


public interface NoticeService {
	
	EasyUIDataGridResult getNoticeList(int page, int rows);
	
	HttpResult insertNotice(Notice notice);
	HttpResult deleteNotices(String ids);
	HttpResult updateNotice(Notice notice);
	Notice getNoticeById(Integer id);
	HttpResult deleteNoticeById(Integer id);
}
