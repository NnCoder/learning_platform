package com.edu.protal.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.protal.pojo.ChapterWithKp;
import com.edu.protal.pojo.PageResult;

public interface CourseService {
	
	public PageResult listCourses(int page, int rows);
	
	public Course getCourseDetailById(int courseId, HttpServletRequest request);
	
	public List<Chapter> getCourseChapters(int courseId);
	
	/**
	 * 获取课程章节+知识点
	 * @param courseId
	 * @return
	 */
	public List<ChapterWithKp> getCourseChaptersById(int courseId);
	
	public CourseDesc getCourseDescById(int courseId);
	
	public PageResult getStuCourseVoByCourseId(int courseId, String key, int page, int rows);
	
	public PageResult getStuCourseVoByCourseId(int courseId, int page, int rows);
}

