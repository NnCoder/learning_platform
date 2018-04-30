package com.edu.rest.service;

import java.util.List;

import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.HttpResult;

public interface ChapterService {
	public HttpResult getChaptersByCourseId(int courseId);
	
	public HttpResult getChaptersWithKpByCourseId(int courseId);
	
	public List<ChapterData> getChapterDatasByChapterId(int chapterId);
}
