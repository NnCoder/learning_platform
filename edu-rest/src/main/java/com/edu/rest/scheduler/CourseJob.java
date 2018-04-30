package com.edu.rest.scheduler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.edu.common.mapper.CourseMapper;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseExample;
import com.edu.rest.component.JedisClient;


/**
 * 课程点击量日常工作
 * @Description TODO
 * @ClassName CourseJob
 * @author Tao
 * @date 2018年3月6日
 */
public class CourseJob {
	private static Logger logger = Logger.getLogger(CourseJob.class);
	
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${COURSE_VT_REDIS_KEY}")
	private String COURSE_VT_REDIS_KEY;
	@Value("${COURSE_REDIS_KEY}")
	private String COURSE_REDIS_KEY;
	/**
	 * 将课程点击量从redis缓存中持久化到数据库中
	 */
	public void execute(){
		logger.info("持久化redis课程点击量到数据库");
		CourseExample example = new CourseExample();
		List<Course> list = courseMapper.selectByExample(example);
		String redisKey = null;
		for (Course course : list) {
			//redis课程点击量key
			redisKey = COURSE_REDIS_KEY + ":" + course.getCourseId() + ":" + COURSE_VT_REDIS_KEY;
			String string = jedisClient.get(redisKey);
			if (StringUtils.isNotBlank(string)) {
				int count = Integer.parseInt(string);
				course.setVisitTime(course.getVisitTime() + count);
				courseMapper.updateByPrimaryKey(course);
				//将课程点击量的redis缓存置为0
				jedisClient.set(redisKey, "0");
			}
		}
		
	}
}
