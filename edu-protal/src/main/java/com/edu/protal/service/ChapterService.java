package com.edu.protal.service;

import java.util.List;

import com.edu.common.pojo.ChapterData;

public interface ChapterService {
	
	public List<ChapterData> getDatas(int chapterId);
}
