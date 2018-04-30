package com.edu.protal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.ChapterData;
import com.edu.common.utils.HttpClientUtil;
import com.edu.common.utils.JsonUtils;
import com.edu.protal.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {
	
	@Value("${REST_CHAPTER_URL}")
	private String REST_CHAPTER_URL;
	
	@Override
	public List<ChapterData> getDatas(int chapterId) {
		String jsonData = HttpClientUtil.doGet(REST_CHAPTER_URL+"/"+chapterId+"/datas");
		List<ChapterData> datas = JsonUtils.jsonToList(jsonData, ChapterData.class);
		return datas;
	}
	
}
