package com.edu.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.StuCourseMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.StuCourse;
import com.edu.common.pojo.StuCourseKey;
import com.edu.rest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StuCourseMapper stuCourseMapper;
	
	@Override
	public HttpResult updateCourseScore(String stuAccount, Integer courseId, Integer score) {
		StuCourseKey key = new StuCourseKey();
		key.setStuAccount(stuAccount);
		key.setCourseId(courseId);
		StuCourse stuCourse = stuCourseMapper.selectByPrimaryKey(key);
		if(stuCourse == null) {
			return HttpResult.build(400, "该学生没有参与课程学习情况统计!");
		}
		
		stuCourse.setScore(stuCourse.getScore()+score);
		stuCourseMapper.updateByPrimaryKey(stuCourse);
		return HttpResult.ok();
	}
	
}
