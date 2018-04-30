package com.edu.manager.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.CourseWithBLOBs;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;
import com.edu.manager.pojo.CourseDetail;
import com.github.pagehelper.PageInfo;

public interface CourseService {
	/**
	 * 创建课程
	 * @param course
	 * @param teacher 创建者
	 * @return
	 */
	Course createCourse(CourseWithBLOBs course, Teacher teacher);
	
	EasyUIDataGridResult selectStuCoursesByCourseId(Integer courseId,int page, int rows);
	
	HttpResult insertStuCoursesByExcel(Integer courseId, MultipartFile file) throws IOException ;
	
	/**
	 * 批量删除 学生与课程关系
	 * @param courseId
	 * @param stuAccounts
	 * @return
	 */
	HttpResult deleteStuCourse(Integer courseId, String stuAccounts);
	
	/**
	 * 删除全部 学生与课程关系
	 * @param courseId
	 * @return
	 */
	HttpResult deleteAllStuCourse(Integer courseId);
	
	/**
	 * 根据用户主键获取所创建的课程
	 * @param teacher
	 * @return
	 */
	List<Course> getCourseListByTch(Teacher teacher);
	
	/**
	 * 分页获取课程
	 * @param page
	 * @param rows
	 * @return 包含分页信息的PageInfo类(From Mybatis分页插件)
	 */
	PageInfo<Course> getCourseList(int page, int rows);
	
	/**
	 * 通过课程id获取课程详细信息及章节
	 * @param courseId
	 * @return
	 */
	CourseDetail getCourseDetail(Integer courseId);
	
	Course getCourseById(Integer courseId);
	
	HttpResult updateCourse(CourseWithBLOBs course);
	
	HttpResult deleteCourse(Integer id);
	
	/**
	 * 删除课程与和该课程相关的所有文件
	 * @param id
	 * @return
	 */
	HttpResult deleteCourseEx(Integer id);
	
	CourseDesc getCourseDescByCourseId(int courseId);
	
	HttpResult updateCourseDesc(CourseDesc courseDesc);
	
	/**
	 * 清除课程的缓存
	 * @param id
	 */
	void cleanCache(Integer id);

}
