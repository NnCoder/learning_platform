package com.edu.rest.service;

import com.edu.common.pojo.HttpResult;

public interface StudentService {
	
	public HttpResult updateCourseScore(String stuAccount, Integer courseId, Integer score);
}
