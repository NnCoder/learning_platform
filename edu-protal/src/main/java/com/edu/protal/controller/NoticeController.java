package com.edu.protal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edu.common.pojo.Notice;
import com.edu.protal.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@GetMapping("/notices/{id}")
	public String getNotice(@PathVariable Integer id, Model model) {
		Notice notice = noticeService.getNotice(id);
		model.addAttribute("notice", notice);
		return "notice/notification";
	}
}
