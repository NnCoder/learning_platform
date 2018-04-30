package com.edu.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.ChapterDataMapper;
import com.edu.common.mapper.ChapterMapper;
import com.edu.common.mapper.KnowledgePointMapper;
import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.ChapterDataExample;
import com.edu.common.pojo.ChapterExample;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.common.pojo.KnowledgePointExample;
/*import com.edu.common.utils.JsonUtils;
import com.edu.rest.component.JedisClient;*/
import com.edu.rest.pojo.ChapterWithKp;
import com.edu.rest.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService{
	
	@Autowired
	private ChapterMapper chapterMapper;
	@Autowired
	private KnowledgePointMapper knowledgePointMapper;
	@Autowired
	private ChapterDataMapper chapterDataMapper;
	
	/*@Autowired
	private JedisClient jedisClient;*/
	@Value("${COURSE_REDIS_KEY}")
	private String COURSE_REDIS_KEY;
	@Value("${COURSE_CHAPTER_INFO_KEY}")
	private String COURSE_CHAPTER_INFO_KEY;
	
	@Override
	public HttpResult getChaptersByCourseId(int courseId) {
		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		
		List<Chapter> chapters = chapterMapper.selectByExample(example);
		return HttpResult.ok(chapters);
	}

	@Override
	public HttpResult getChaptersWithKpByCourseId(int courseId) {
/*		try {
			String jsonData = jedisClient.get(COURSE_REDIS_KEY+":"+courseId+":"+COURSE_CHAPTER_INFO_KEY);
			
			if(StringUtils.isNoneBlank(jsonData)) {
				List<ChapterWithKp> list = JsonUtils.jsonToList(jsonData, ChapterWithKp.class);
				return HttpResult.ok(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
*/		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		
		List<Chapter> chapters = chapterMapper.selectByExample(example);
		List<ChapterWithKp> chapterWithKps = new ArrayList<>();
		ChapterWithKp chapterWithKp = null;
		for (Chapter chapter : chapters) {
			chapterWithKp = new ChapterWithKp();
			chapterWithKp.setChapterId(chapter.getChapterId());
			chapterWithKp.setChapterName(chapter.getChapterName());
			
			KnowledgePointExample example2 = new KnowledgePointExample();
			KnowledgePointExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andChapterIdEqualTo(chapter.getChapterId());
			criteria2.andStateEqualTo((byte)1);
			List<KnowledgePoint> kps = knowledgePointMapper.selectByExample(example2);
			chapterWithKp.setKnowledgePoints(kps);
			
			chapterWithKps.add(chapterWithKp);
		}
		/*try {
			String jsonData = JsonUtils.objectToJson(chapterWithKps);
			jedisClient.set(COURSE_REDIS_KEY+":"+courseId+":"+COURSE_CHAPTER_INFO_KEY, jsonData);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return HttpResult.ok(chapterWithKps);
	}

	@Override
	public List<ChapterData> getChapterDatasByChapterId(int chapterId) {
		ChapterDataExample example = new ChapterDataExample();
		ChapterDataExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		List<ChapterData> list = chapterDataMapper.selectByExample(example);
		return list;
	}
	
	
}
