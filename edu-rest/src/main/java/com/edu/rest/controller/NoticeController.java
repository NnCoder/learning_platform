package com.edu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;
import com.edu.rest.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notices")
	@ResponseBody
	public List<Notice> getNotices(@RequestParam(defaultValue="10")Integer limit) { 
		List<Notice> list = noticeService.getNotices(limit);
		return list;
	}
	
	
	@RequestMapping("/notices/{id}")
	@ResponseBody
	public HttpResult getNotice(@PathVariable Integer id){
		HttpResult result = noticeService.getNotice(id);
		return result;
	}
	
}
