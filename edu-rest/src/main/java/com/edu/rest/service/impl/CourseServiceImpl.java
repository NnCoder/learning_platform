package com.edu.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.CourseDescMapper;
import com.edu.common.mapper.CourseMapper;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.CourseExample;
import com.edu.common.pojo.CourseWithBLOBs;
import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.JsonUtils;
import com.edu.rest.component.JedisClient;
import com.edu.rest.mapper.IStuCourseMapper;
import com.edu.rest.pojo.PageResult;
import com.edu.rest.pojo.StuCourseVo;
import com.edu.rest.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CourseDescMapper courseDescMapper;
	@Autowired
	private IStuCourseMapper stuCourseMapper;
	
	@Autowired
	private JedisClient jedisClient;
	@Value("${COURSE_VT_REDIS_KEY}")
	private String COURSE_VT_REDIS_KEY;
	@Value("${COURSE_REDIS_KEY}")
	private String COURSE_REDIS_KEY;
	@Value("${COURSE_BASE_INFO_KEY}")
	private String COURSE_BASE_INFO_KEY;
	@Value("${COURSE_DESC_KEY}")
	private String COURSE_DESC_KEY;
	@Value("${COURSE_EXPIRE_SECOND}")
	private Integer COURSE_EXPIRE_SECOND;
	
	
	@Override
	public PageResult list(int page, int rows) {
		PageHelper.startPage(page, rows);
		CourseExample example = new CourseExample();
		CourseExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo((byte)1);
		List<Course> list = courseMapper.selectByExample(example);
		PageInfo<Course> pageInfo = new PageInfo<>(list);
		PageResult result = new PageResult();
		result.setTotal(pageInfo.getTotal());
		result.setPages(pageInfo.getPageNum());
		result.setList(list);
		return result;
	}

	@Override
	public HttpResult getCourseDetailById(int courseId) {
		long visitTime = 1l;
		String redisKey = COURSE_REDIS_KEY + ":" + courseId;

		// 缓存访问量
		try {
			String string = jedisClient.get(redisKey + ":" + COURSE_VT_REDIS_KEY);
			if (StringUtils.isNotBlank(string)) {
				visitTime = jedisClient.incr(redisKey + ":" + COURSE_VT_REDIS_KEY);
			} else {
				jedisClient.set(redisKey + ":" + COURSE_VT_REDIS_KEY, "1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 查询缓存中的课程
		try {
			String jsonData = jedisClient.get(redisKey + ":" + COURSE_BASE_INFO_KEY);
			if (StringUtils.isNotBlank(jsonData)) {
				Course course = JsonUtils.jsonToPojo(jsonData, CourseWithBLOBs.class);
				course.setVisitTime((int) (course.getVisitTime() + visitTime));
				return HttpResult.ok(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//从数据库中查询
		Course course = courseMapper.selectByPrimaryKey(courseId);
		course.setVisitTime((int) (course.getVisitTime() + visitTime));
		//缓存至redis中
		try {
			jedisClient.set(redisKey + ":" + COURSE_BASE_INFO_KEY, JsonUtils.objectToJson(course));
			jedisClient.expire(redisKey + ":" + COURSE_BASE_INFO_KEY, COURSE_EXPIRE_SECOND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpResult.ok(course);
	}

	@Override
	public HttpResult getCourseDescById(int courseId) {
		String redisKey = COURSE_REDIS_KEY + ":" + courseId;
		//从redis缓存中读取
		try {
			String jsonData = jedisClient.get(redisKey + ":" + COURSE_DESC_KEY);
			if (StringUtils.isNotBlank(jsonData)) {
				CourseDesc courseDesc = JsonUtils.jsonToPojo(jsonData, CourseDesc.class);
				return HttpResult.ok(courseDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CourseDesc courseDesc = courseDescMapper.selectByPrimaryKey(courseId);
		try {
			String jsonData = JsonUtils.objectToJson(courseDesc);
			jedisClient.set(redisKey + ":" +COURSE_DESC_KEY, jsonData);
			jedisClient.expire(redisKey + ":" + COURSE_DESC_KEY, COURSE_EXPIRE_SECOND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpResult.ok(courseDesc);
	}

	@Override
	public PageResult getStuCoursesByCourseId(int courseId, String tchAccount,String searchKey, int page, int rows) {
		//PageHelper分页插件
		PageHelper.startPage(page, rows);
		//获取学生学习情况统计排行榜
		//初始化分页时首位序号
		int initOrder = (page-1)*rows;
		List<StuCourseVo> list = stuCourseMapper.getStuCourseVoByCourseId(courseId,initOrder,tchAccount,searchKey);
		PageInfo<StuCourseVo> pageInfo = new PageInfo<>(list);
		PageResult result = new PageResult();
		result.setList(list);
		result.setPages(pageInfo.getPages());
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
