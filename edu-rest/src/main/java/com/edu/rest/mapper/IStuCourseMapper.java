package com.edu.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.edu.rest.pojo.StuCourseVo;

public interface IStuCourseMapper {
	
	/**
	 * 
	 * @param courseId
	 * @param initOrder 分页初始排名
	 * @return
	 */
	public List<StuCourseVo> getStuCourseVoByCourseId(
			@Param("courseId") Integer courseId, 
			@Param("initOrder") Integer initOrder,
			@Param("tchAccount") String tchAccount,
			@Param("searchKey") String searchKey
	);
	
	
}
