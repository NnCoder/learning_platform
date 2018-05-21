package com.edu.protal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.CourseWithBLOBs;
import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.HttpClientUtil;
import com.edu.common.utils.JsonUtils;
import com.edu.protal.pojo.ChapterWithKp;
import com.edu.protal.pojo.PageResult;
import com.edu.protal.pojo.User;
import com.edu.protal.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private static final Logger logger = Logger.getLogger(CourseService.class);
	
	@Value("${REST_COURSE_URL}")
	private String REST_COURSE_URL;
	@Value("${REST_STUDENT_URL}")
	private String REST_STUDENT_URL;
	
	@Override
	public PageResult listCourses(int page, int rows) {
		Map<String, String> param = new HashMap<>();
		param.put("page", String.valueOf(page));
		param.put("rows", String.valueOf(rows));
		String jsonData = HttpClientUtil.doGet(REST_COURSE_URL, param);
		PageResult result = JsonUtils.jsonToPojo(jsonData, PageResult.class);
		return result;
	}

	@Override
	public Course getCourseDetailById(int courseId, HttpServletRequest request) {
		String jsonData = HttpClientUtil.doGet(REST_COURSE_URL+"/"+courseId);
		HttpResult result = HttpResult.formatToPojo(jsonData, CourseWithBLOBs.class);
		CourseWithBLOBs course = (CourseWithBLOBs) result.getData();
		return course;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChapterWithKp> getCourseChaptersById(int courseId) {
		String jsonData = HttpClientUtil.doGet(REST_COURSE_URL+"/"+courseId+"/chaptersWithKp");
		HttpResult result = HttpResult.formatToList(jsonData, ChapterWithKp.class);
		List<ChapterWithKp> list = (List<ChapterWithKp>) result.getData();
		return list;
	}

	@Override
	public CourseDesc getCourseDescById(int courseId) {
		String jsonData = HttpClientUtil.doGet(REST_COURSE_URL+"/desc/"+courseId);
		HttpResult result = HttpResult.formatToPojo(jsonData, CourseDesc.class);
		CourseDesc desc = (CourseDesc) result.getData();
		return desc;
	}

	@Override
	public PageResult getStuCourseVoByCourseId(int courseId,String key,int page, int rows) {
		Map<String, String> param = new HashMap<>();
		param.put("page", String.valueOf(page));
		param.put("rows", String.valueOf(rows));
		param.put("searchKey", key);
		String jsonData = HttpClientUtil.doGet(REST_COURSE_URL+"/"+courseId+"/students/score", param);
		PageResult result = JsonUtils.jsonToPojo(jsonData, PageResult.class);
		return result;
	}
	
	@Override
	public PageResult getStuCourseVoByCourseId(int courseId, int page, int rows) {
		return getStuCourseVoByCourseId(courseId, "", page, rows);
	}

	@Override
	public List<Chapter> getCourseChapters(int courseId) {
		String jsonData = HttpClientUtil.doGet(REST_COURSE_URL+"/"+courseId+"/chapters");
		HttpResult result = HttpResult.formatToList(jsonData, Chapter.class);
		List<Chapter> chapters = (List<Chapter>) result.getData();
		return chapters;
	}

	@Override
	public void improveStudentScore(User user, int courseId, int score) {
		try {
			if(user!=null && user.getRole().startsWith("s")) {
				Map<String, String> params = new HashMap<>();
				params.put("courseId", String.valueOf(courseId));
				params.put("stuAccount", user.getUserAccount());
				params.put("score", "1");
				HttpClientUtil.doPost(REST_STUDENT_URL+"/course",params);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
}
