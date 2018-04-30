package com.edu.manager.service.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.mapper.ChapterMapper;
import com.edu.common.mapper.CourseDescMapper;
import com.edu.common.mapper.CourseMapper;
import com.edu.common.mapper.StuCourseMapper;
import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.ChapterExample;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.CourseExample;
import com.edu.common.pojo.CourseWithBLOBs;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.StuCourse;
import com.edu.common.pojo.StuCourseExample;
import com.edu.common.pojo.StuCourseKey;
import com.edu.common.pojo.Teacher;
import com.edu.manager.annotation.CleanCourseCache;
import com.edu.manager.component.ExcelUtil;
import com.edu.manager.component.JedisClient;
import com.edu.manager.pojo.CourseDetail;
import com.edu.manager.service.ChapterService;
import com.edu.manager.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class CourseServiceImpl implements CourseService{
	private static final Logger logger = Logger.getLogger(CourseService.class);
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${COURSE_REDIS_KEY}")
	private String COURSE_REDIS_KEY; //课程redis缓存 key值
	@Value("${COURSE_BASE_INFO_KEY}")
	private String COURSE_BASE_INFO_KEY;
	@Value("${COURSE_DESC_KEY}")
	private String COURSE_DESC_KEY;
	
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ChapterMapper chapterMapper;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private CourseDescMapper courseDescMapper;
	@Autowired
	private StuCourseMapper stuCourseMapper; //学生参与课程Mapper
	
	@Autowired
	private ExcelUtil excelUtil; //excel读取工具类
	
	@Override
	public Course createCourse(CourseWithBLOBs course, Teacher teacher) {
		//设置创建者
		course.setTchAccount(teacher.getTchAccount());
		//时间
		Date date = new Date();
		course.setCreateTime(date);
		course.setUpdateTime(date);
		course.setVisitTime(0);
		course.setState((byte)1);
		courseMapper.insert(course);
		
		CourseDesc courseDesc = new CourseDesc();
		courseDesc.setCourseId(course.getCourseId());
		courseDesc.setCourseDesc("");
		courseDescMapper.insert(courseDesc);
		//返回时清空不必要的数据
		course.setCourseIntro(null);
		course.setCourseProcess(null);
		return course;
	}

	@Override
	public List<Course> getCourseListByTch(Teacher teacher) {
		//通过teacher获取课程
		CourseExample example = new CourseExample();
		CourseExample.Criteria criteria = example.createCriteria();
		if(!teacher.getRole().equals("admin")) {
			criteria.andTchAccountEqualTo(teacher.getTchAccount());
		}
		criteria.andStateEqualTo((byte)1);
		List<Course> courses = courseMapper.selectByExample(example);
		
		//空值处理
		if (courses == null) {
			courses = new ArrayList<>();
		}
		return courses;
	}

	@Override
	public CourseDetail getCourseDetail(Integer courseId) {
		Course course = courseMapper.selectByPrimaryKey(courseId);
		//获取课程章节
		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		criteria.andStateEqualTo((byte)1);
		List<Chapter> chapters = chapterMapper.selectByExample(example);
		//空值处理
		if (chapters == null) {
			chapters = new ArrayList<>();
		}
		CourseDetail courseDetail = new CourseDetail();
		courseDetail.setCourse(course);
		courseDetail.setChapters(chapters);
		return courseDetail;
	}

	@Override
	public HttpResult updateCourse(CourseWithBLOBs course) {
		logger.info("update set course: "+course.getCourseId()+": " + course.getTchAccount());
		courseMapper.updateByPrimaryKeySelective(course);
		cleanCache(course.getCourseId());
		return HttpResult.ok(course.getCourseName());
	}

	@Override
	public HttpResult deleteCourse(Integer id) {
		CourseWithBLOBs course = new CourseWithBLOBs();
		course.setCourseId(id);
		course.setState((byte)0);
		courseMapper.updateByPrimaryKeySelective(course);
		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(id);
		criteria.andStateEqualTo((byte)1);
		List<Chapter> chapters = chapterMapper.selectByExample(example);
		
		for(Chapter chapter:chapters) {
			chapterService.deleteChapterById(chapter.getChapterId());
		}
		return HttpResult.ok();
	}

	@Override
	public Course getCourseById(Integer courseId) {
		Course course = courseMapper.selectByPrimaryKey(courseId);
		return course;
	}

	@Override
	@CleanCourseCache
	public HttpResult deleteCourseEx(Integer id) {
		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(id);
		List<Chapter> chapters = chapterMapper.selectByExample(example);
		
		//删除课程下所有章节
		for(Chapter chapter:chapters) {
			chapterService.deleteChapterByIdEx(chapter.getChapterId());
		}
		//删除课程
		courseMapper.deleteByPrimaryKey(id);
		return HttpResult.ok();
	}

	@Override
	public CourseDesc getCourseDescByCourseId(int courseId) {
		CourseDesc courseDesc = courseDescMapper.selectByPrimaryKey(courseId);
		return courseDesc;
	}

	@Override
	public HttpResult updateCourseDesc(CourseDesc courseDesc) {
		courseDescMapper.updateByPrimaryKeyWithBLOBs(courseDesc);
		cleanCache(courseDesc.getCourseId());
		return HttpResult.ok();
	}

	@Override
	public PageInfo<Course> getCourseList(int page, int rows) {
		PageHelper.startPage(page, rows);
		CourseExample example = new CourseExample();
		List<Course> courses = courseMapper.selectByExample(example);
		PageInfo<Course> pageInfo = new PageInfo<>(courses);
		
		return pageInfo;
	}

	@Override
	public HttpResult insertStuCoursesByExcel(Integer courseId, MultipartFile file) throws IOException {
		ArrayList<ArrayList<String>> result = excelUtil.readExcel(file);
		if(result == null) {
			return HttpResult.build(400, "文件格式不正确!只接受.xls .xlsx文件");
		}
		//弱引用,提高gc回收效率
		StuCourse stuCourse = null;
		StringBuffer errorStack = new StringBuffer();
		for(ArrayList<String> list : result) {
			String stuAccount = list.get(0);
			stuCourse = new StuCourse();
			stuCourse.setCourseId(courseId);
			stuCourse.setStuAccount(stuAccount);
			//try-catch筛选出插入不成功的学号
			try {
				stuCourseMapper.insertSelective(stuCourse);
			} catch (Exception e) {
				errorStack.append(stuAccount+"<br/>");
			}
		}
		if(StringUtils.isBlank(errorStack)) {
			return HttpResult.ok();
		}else {
			return HttpResult.build(500, errorStack.toString());
		}
	}

	@Override
	public HttpResult deleteStuCourse(Integer courseId, String stuAccounts) {
		if(StringUtils.isNotBlank(stuAccounts)) {
			String[] strs = stuAccounts.split(",");
			StuCourseKey key = null;
			for(String stuAccount : strs) {
				key = new StuCourseKey();
				key.setStuAccount(stuAccount);
				key.setCourseId(courseId);
				stuCourseMapper.deleteByPrimaryKey(key);
			}
		}
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteAllStuCourse(Integer courseId) {
		StuCourseExample example = new StuCourseExample();
		StuCourseExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		stuCourseMapper.deleteByExample(example);
		return HttpResult.ok();
	}

	@Override
	public EasyUIDataGridResult selectStuCoursesByCourseId(Integer courseId,int page, int rows) {
		//Mybatis PageHelper分页插件
		PageHelper.startPage(page, rows);
		StuCourseExample example = new StuCourseExample();
		StuCourseExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		//获取分页查询结果
		List<StuCourse> list = stuCourseMapper.selectByExample(example);
		//提取分页信息
		PageInfo<StuCourse> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public void cleanCache(Integer id) {
		String redisKey = COURSE_REDIS_KEY + ":" + id;
		try {
			jedisClient.del(redisKey + ":" + COURSE_BASE_INFO_KEY);
			jedisClient.del(redisKey + ":" + COURSE_DESC_KEY);
		} catch (Exception e) {
			logger.error("删除缓存错误!");
		}
		
	}
	
}
