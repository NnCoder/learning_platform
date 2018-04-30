package com.edu.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edu.common.pojo.Data;
import com.edu.common.pojo.Notice;
import com.edu.protal.pojo.PageResult;
import com.edu.protal.service.CourseService;
import com.edu.protal.service.DataService;
import com.edu.protal.service.NoticeService;

@Controller
public class IndexController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private DataService dataService;
	
	@GetMapping("/index")
	public String index(Model model) {
		PageResult pageResult = courseService.listCourses(1, 8);
		List<Notice> notices = noticeService.listNotices(4);
		List<Data> datas = dataService.getDataRecent(8);
		model.addAttribute("courses", pageResult);
		model.addAttribute("notices", notices);
		model.addAttribute("datas", datas);
		return "homePage";
	}
}
