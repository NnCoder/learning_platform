package com.edu.rest.controller;

import com.edu.common.pojo.HttpResult;
import com.edu.rest.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/students/course", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult updateStuCourseScore(String stuAccount, Integer courseId, Integer score) {
		HttpResult result = studentService.updateCourseScore(stuAccount, courseId, score);
		return result;
	}
}
