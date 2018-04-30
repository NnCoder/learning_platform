package com.edu.manager.pojo;

import java.util.List;

import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.Course;

public class CourseDetail{
	public CourseDetail() {}
	private Course course;
	private List<Chapter> chapters;

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
