package com.edu.manager.service;

import java.util.List;

import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.HttpResult;

public interface ChapterService {
	
	Chapter createChapter(String chapterName, Integer courseId);
	
	HttpResult updateChapter(Integer chapterId, String name);
	
	HttpResult deleteChapterById(Integer id);
	
	/**
	 * 删除数据库与文件库中与该章节关联的所有文件
	 * @param id
	 * @return
	 */
	HttpResult deleteChapterByIdEx(Integer id);
	
	List<ChapterData> getChapterDatas(Integer chapterId);
	
	HttpResult createChapterData(ChapterData chapterData);
	
	HttpResult updateChapterData(ChapterData chapterData);
	
	HttpResult deleteChapterDataById(Integer id);
	
	void cleanCache(Integer id);
}
