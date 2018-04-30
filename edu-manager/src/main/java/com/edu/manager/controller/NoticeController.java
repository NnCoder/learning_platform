package com.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Notice;
import com.edu.manager.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("/admin/notice/list")
	@ResponseBody
	public EasyUIDataGridResult getNoticeList(@RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="20")int rows) {
		EasyUIDataGridResult result = noticeService.getNoticeList(page, rows);
		return result;
	}
	
	
	@RequestMapping("/admin/notice/{id}")
	public String getNotice(@PathVariable Integer id, Model model) {
		Notice notice = noticeService.getNoticeById(id);
		model.addAttribute("notice", notice);
		return "admin/notice-edit";
	}
	
	@RequestMapping("/admin/notice/content/{noticeId}")
	public String getNoticeContent(@PathVariable Integer noticeId, Model model) {
		Notice notice = noticeService.getNoticeById(noticeId);
		model.addAttribute("notice", notice);
		return "admin/notice-content";
	}
	
	@RequestMapping(value="/admin/notice", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertNotice(Notice notice) {
		HttpResult result = noticeService.insertNotice(notice);
		return result;
	}
	
	@RequestMapping(value="/admin/notice", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteNotice(String ids) {
		HttpResult result = noticeService.deleteNotices(ids);
		return result;
	}
	
	@RequestMapping(value="/admin/notice", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateNotice(Notice notice) {
		HttpResult result = noticeService.updateNotice(notice);
		return result;
	}
}
