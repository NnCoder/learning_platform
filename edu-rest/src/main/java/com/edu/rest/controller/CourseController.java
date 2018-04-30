package com.edu.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.rest.pojo.PageResult;
import com.edu.rest.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/courses")
	@ResponseBody
	public PageResult list(@RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="6")int rows) {
		PageResult result = courseService.list(page, rows);
		return result;
	}
	
	@RequestMapping("/courses/{id}")
	@ResponseBody
	public HttpResult getCourseDetailById(@PathVariable Integer id) {
		HttpResult result = courseService.getCourseDetailById(id);
		return result;
	}
	
	@RequestMapping("/courses/desc/{id}")
	@ResponseBody
	public HttpResult getCourseDescById(@PathVariable Integer id) {
		HttpResult result = courseService.getCourseDescById(id);
		return result;
	}
	
	@RequestMapping("/courses/{courseId}/students/score")
	@ResponseBody
	public PageResult getStuCourseVoByCourseId(
			@PathVariable Integer courseId,
			@RequestParam(required=false) String tchAccount,
			@RequestParam(required=false) String searchKey,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="10") int rows){
		//通过课程id + 老师账号(可为null,为null时获取参与该课程的所有学生)学生学习排名情况 
		PageResult result = courseService.getStuCoursesByCourseId(courseId,tchAccount,searchKey,page, rows);
		return result;
	}
}
