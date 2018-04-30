package com.edu.rest.service;


import com.edu.common.pojo.HttpResult;
import com.edu.rest.pojo.PageResult;

public interface CourseService {
	public PageResult list(int page, int rows);
	public HttpResult getCourseDetailById(int courseId);
	public HttpResult getCourseDescById(int courseId);
	
	public PageResult getStuCoursesByCourseId(
			int courseId, 
			String tchAccount, 
			String searchKey,
			int page, 
			int rows);
}
