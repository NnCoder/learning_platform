package com.edu.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.CourseWithBLOBs;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;
import com.edu.manager.pojo.CourseDetail;
import com.edu.manager.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/manager/course", method=RequestMethod.POST)
	@ResponseBody
	public Course createCourse(CourseWithBLOBs course, HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getAttribute("user");
		Course result = courseService.createCourse(course, teacher);
		return result;
	}
	
	@RequestMapping(value="/manager/course/{courseId}/token")
	public String getCourseManager(@PathVariable Integer courseId, Model model) {
		//通过token验证进入课程教案界面
		CourseDetail courseDetail = courseService.getCourseDetail(courseId);
		model.addAttribute("courseDetail", courseDetail);
		return "course/course-manager";
	}
	
	@RequestMapping(value="/manager/course/{courseId}", method=RequestMethod.GET)
	public String getCourseDetail(@PathVariable Integer courseId, Model model) {
		CourseDetail courseDetail = courseService.getCourseDetail(courseId);
		model.addAttribute("courseDetail", courseDetail);
		return "course/course-chapter";
	}
	
	@RequestMapping(value="/manager/course", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateCourse(CourseWithBLOBs course) {
		HttpResult result = courseService.updateCourse(course);
		return result;
	}
	
	@RequestMapping(value="/manager/course/student/excel",method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertStuCoursesByExcel(Integer courseId, MultipartFile file) {
		HttpResult result;
		try {
			result = courseService.insertStuCoursesByExcel(courseId, file);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return HttpResult.build(500, e.getMessage());
		}
	
	}
	
	@RequestMapping(value="/manager/course/student",method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult selectStuCoursesByCourseId(Integer courseId, int page, int rows) {
		EasyUIDataGridResult result = courseService.selectStuCoursesByCourseId(courseId, page, rows);
		return result;
	}
	
	@RequestMapping(value="/manager/course/student",method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteStuCourses(Integer courseId, String stuAccounts) {
		//批量删除学生与该课程关系
		HttpResult result = courseService.deleteStuCourse(courseId, stuAccounts);
		return result;
	}
	@RequestMapping(value="/manager/course/student/deleteAll", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteAllStuCoursesByCourseId(Integer courseId) {
		//删除全部学生与该课程关系
		HttpResult result = courseService.deleteAllStuCourse(courseId);
		return result;
	}
	
	
	@RequestMapping(value="/manager/course", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteCourse(Integer id) {
		HttpResult result = courseService.deleteCourse(id);
		return result;
	}
	
	@RequestMapping(value="/manager/course/desc")
	@ResponseBody
	public HttpResult updateCourseDesc(CourseDesc courseDesc) {
		HttpResult result = courseService.updateCourseDesc(courseDesc);
		return result;
	}
}
