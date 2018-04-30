package com.edu.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edu.common.pojo.ChapterData;
import com.edu.protal.service.ChapterService;

@Controller
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@GetMapping("/chapters/{chapterId}/datas")
	public String getChapterDatas(@PathVariable Integer chapterId, Model model) {
		List<ChapterData> datas = chapterService.getDatas(chapterId);
		model.addAttribute("datas", datas);
		return "chapter/chapter-data-list";
	}
}
