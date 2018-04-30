package com.edu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.HttpResult;
import com.edu.rest.service.ChapterService;

@Controller
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping("/courses/{courseId}/chapters")
	@ResponseBody
	public HttpResult getChaptersByCourseId(@PathVariable Integer courseId) {
		HttpResult result = chapterService.getChaptersByCourseId(courseId);
		return result;
	}
	
	@RequestMapping("/courses/{courseId}/chaptersWithKp")
	@ResponseBody
	public HttpResult getChaptersWithKpByCourseId(@PathVariable Integer courseId) {
		HttpResult result = chapterService.getChaptersWithKpByCourseId(courseId);
		return result;
	}
	
	@RequestMapping("/chapters/{chapterId}/datas")
	@ResponseBody
	public List<ChapterData> getChapterDatasByChapterId(@PathVariable Integer chapterId){
		List<ChapterData> list = chapterService.getChapterDatasByChapterId(chapterId);
		return list;
	}
}
