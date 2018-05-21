package com.edu.protal.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.Course;
import com.edu.common.pojo.CourseDesc;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.protal.pojo.ChapterWithKp;
import com.edu.protal.pojo.KpDetail;
import com.edu.protal.pojo.PageResult;
import com.edu.protal.pojo.StuCourseVo;
import com.edu.protal.service.CourseService;
import com.edu.protal.service.KpService;


@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private KpService KpService;
	
	@GetMapping("/courses-{courseId}")
	public String getCourse(@PathVariable Integer courseId, HttpServletRequest request,Model model) {
		Course course = courseService.getCourseDetailById(courseId,request);
		@SuppressWarnings("unchecked")
		List<StuCourseVo> list = (List<StuCourseVo>) courseService.getStuCourseVoByCourseId(courseId, 1, 10).getList();
		
		model.addAttribute("course", course);
		model.addAttribute("stuCourseList", list);
		return "course/course";
	}
	
	@GetMapping("/courses")
	public String getCourses(
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="8")int rows,
			Model model) {
		PageResult listCourses = courseService.listCourses(page, rows);
		model.addAttribute("courses", listCourses);
		return "course/courses";
	}
	
	@GetMapping("/course-kp")
	public String courseDetailPage(int courseId, int kpId, Model model) {
		List<ChapterWithKp> list = courseService.getCourseChaptersById(courseId);
		KpDetail detail = KpService.getKpDetailById(kpId);
		
		model.addAttribute("kpDetail", detail);
		model.addAttribute("chapters", list);
		model.addAttribute("kpId", kpId);
		model.addAttribute("courseId", courseId);
		return "kp/learning_point";
	}
	
	@GetMapping("/courses-{courseId}-chaptersWithKp")
	public String getCourseChaptersById(@PathVariable Integer courseId, Model model) {
		List<ChapterWithKp> list = courseService.getCourseChaptersById(courseId);
		if (!list.isEmpty()) {
			List<KnowledgePoint> kps = list.get(0).getKnowledgePoints();
			if(!kps.isEmpty()) {
				KpDetail detail = KpService.getKpDetailById(kps.get(0).getKpId());
				model.addAttribute("kpDetail", detail);
			}
		}
		model.addAttribute("chapters", list);
		model.addAttribute("courseId", courseId);
		return "kp/learning_point";
	}
	
	@GetMapping("/courses/{courseId}/chapters")
	public String getCourseChaptersOnlyById(@PathVariable Integer courseId, Model model) {
		List<Chapter> chapters = courseService.getCourseChapters(courseId);
		model.addAttribute("chapters", chapters);
		return "chapter/chapter-list";
	}
	
	@GetMapping("/courses/desc/{courseId}")
	public String getCourseDescById(@PathVariable Integer courseId, Model model) {
		CourseDesc desc = courseService.getCourseDescById(courseId);
		model.addAttribute("desc", desc);
		return "course/desc";
	}
	
	@GetMapping("/courses/{courseId}/students/score")
	public String getStuCourseVoByCourseId(
			@PathVariable Integer courseId,
			@RequestParam(defaultValue="") String key,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="20") int rows,
			Model model) {
		try {
			key = new String(key.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageResult result = courseService.getStuCourseVoByCourseId(courseId,key,page,rows);
		model.addAttribute("result", result);
		model.addAttribute("courseId", courseId);
		model.addAttribute("key", key);
		return "course/rank";
		
	}
	@GetMapping("/courses/{courseId}/students/score/ul")
	public String getStuCourseVoByCourseIdForUl(
			@PathVariable Integer courseId,
			@RequestParam(defaultValue="") String key,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="20") int rows,
			Model model
			) {
		try {
			key = new String(key.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageResult result = courseService.getStuCourseVoByCourseId(courseId,key,page,rows);
		model.addAttribute("result", result);
		return "course/rank-ul";
	}
	
	
}
