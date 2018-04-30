package com.edu.manager.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.Data;
import com.edu.common.pojo.Student;
import com.edu.common.pojo.Teacher;
import com.edu.common.pojo.Video;
import com.edu.manager.service.ChapterService;
import com.edu.manager.service.CourseService;
import com.edu.manager.service.DataService;
import com.edu.manager.service.LoginService;
import com.edu.manager.service.StudentService;
import com.edu.manager.service.TeacherService;
import com.edu.manager.service.VideoService;

@Controller
public class PageController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private DataService dataService;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		Teacher teacher = loginService.getUserByToken(request, response);
		List<Course> courseList = courseService.getCourseListByTch(teacher);
		model.addAttribute("teacher", teacher);
		model.addAttribute("courseList", courseList);
		model.addAttribute("date", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		return "manager/index";
	}
	
	@RequestMapping("/")
	public String loginPage() {
		return "page-login";
	}
	
	@RequestMapping("/page/{page}")
	public String turn(@PathVariable String page, @RequestParam Map<String, String> params, Model model) {
		
		model.addAllAttributes(params);
		return page;
	}

	@RequestMapping("/page/kp-add/{chapterId}")
	public String turnToKpAdd(@PathVariable Integer chapterId, Model model) {
		model.addAttribute("chapterId", chapterId);
		return "kp-add";
	}

	@RequestMapping("/page/video-edit/{kpId}")
	public String turnToVideoEdit(@PathVariable Integer kpId, Model model) {
		// 跳转到视频编辑页面
		List<Video> videos = videoService.getVideoListByKpId(kpId);
		model.addAttribute("kpId", kpId);
		model.addAttribute("videos", videos);
		return "video/video-edit";
	}

	@RequestMapping("/page/data-edit/{kpId}/{dataType}")
	public String turnToDataEdit(@PathVariable Integer kpId, @PathVariable Integer dataType, Model model) {
		// 跳转到资料编辑页面
		List<Data> datas = dataService.getDataListByKpId(kpId, dataType);
		model.addAttribute("kpId", kpId);
		model.addAttribute("dataType", dataType);
		model.addAttribute("datas", datas);
		return "data/data-edit";
	}

	@RequestMapping("/page/course-edit/{courseId}")
	public String turnToCourseEdit(@PathVariable Integer courseId, Model model) {
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("course", course);
		return "course/course-edit";
	}

	@RequestMapping("/page/student-edit/{stuAccount}")
	public String turnToStudentEdit(@PathVariable String stuAccount, Model model) {
		Student student = studentService.getStudentByAccount(stuAccount);
		model.addAttribute(student);
		return "student/student-edit";
	}

	@RequestMapping("/page/teacher-edit/{tchAccount}")
	public String turnToTeacherEdit(@PathVariable String tchAccount, Model model) {
		try {
			tchAccount = new String(tchAccount.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Teacher teacher = teacherService.getTeacherByAccount(tchAccount);
		model.addAttribute(teacher);
		return "teacher/teacher-edit";
	}
	
	@RequestMapping("/page/course-desc-edit/{courseId}")
	public String courseDesc(@PathVariable Integer courseId, Model model) {
		CourseDesc courseDesc = courseService.getCourseDescByCourseId(courseId);
		model.addAttribute("desc", courseDesc);
		return "course/course-desc-edit";
	}
	
	@RequestMapping("/page/chapter-edit/{chapterId}")
	public String chapterEdit(@PathVariable Integer chapterId, Model model) {
		List<ChapterData> chapterDatas = chapterService.getChapterDatas(chapterId);
		model.addAttribute("chapterId", chapterId);
		model.addAttribute("chapterDatas", chapterDatas);
		return "chapter/chapter-edit";
	}
	
	/**
	 * 转到编辑老师所负责学生关系页面
	 * @param tchAccount
	 * @param model
	 * @return
	 */
	@RequestMapping("/page/teacher-student/{tchAccount}")
	public String tchStuEdit(@PathVariable String tchAccount, Model model) {
		try {
			//中文转码
			tchAccount = new String(tchAccount.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("tchAccount",tchAccount);
		return "teacher/teacher-student";
	}
	
	@RequestMapping("/page/course-stus/{courseId}")
	public String courseStusEdit(@PathVariable String courseId, Model model) {
		model.addAttribute("courseId", courseId);
		return "course/course-stus";
	}
	/*@RequestMapping("/page/modifyPerson/{userAccount}")
	public String turnToPersonEdit(@PathVariable String userAccount, Model model) {
		try {
			userAccount = new String(userAccount.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Teacher teacher = teacherService.getTeacherByAccount(userAccount);
		model.addAttribute(teacher);
		return "modifyPerson";
	}*/
}
