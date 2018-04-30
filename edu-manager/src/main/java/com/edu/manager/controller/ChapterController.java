package com.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.HttpResult;
import com.edu.manager.service.ChapterService;

@Controller
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping(value="/manager/chapter", method=RequestMethod.POST)
	@ResponseBody
	public Chapter createChapter(String chapterName, Integer courseId) {
		Chapter chapter = chapterService.createChapter(chapterName, courseId);
		return chapter;
	}
	
	@RequestMapping(value="/manager/chapter", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateChapter(Integer id, String name) {
		HttpResult result = chapterService.updateChapter(id, name);
		return result;
	}
	
	@RequestMapping(value="/manager/chapter", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteChapter(Integer id) {
		HttpResult result = chapterService.deleteChapterById(id);
		return result;
	}
	
	
	@RequestMapping(value="/manager/chapter/data", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateChapterData(ChapterData chapterData) {
		HttpResult result = chapterService.updateChapterData(chapterData);
		return result;
	}
	
	@RequestMapping(value="/manager/chapter/data", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteChapterData(Integer id) {
		HttpResult result = chapterService.deleteChapterDataById(id);
		return result;
	}
	
	@RequestMapping(value="/manager/chapter/data", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult createChapterData(ChapterData chapterData) {
		HttpResult result = chapterService.createChapterData(chapterData);
		return result;
	}
}
