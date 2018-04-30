package com.edu.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.ChapterDataMapper;
import com.edu.common.mapper.ChapterMapper;
import com.edu.common.pojo.Chapter;
import com.edu.common.pojo.ChapterData;
import com.edu.common.pojo.ChapterDataExample;
import com.edu.common.pojo.ChapterExample;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePoint;
import com.edu.manager.component.JedisClient;
import com.edu.manager.service.ChapterService;
import com.edu.manager.service.KpService;

@Service
public class ChapterServiceImpl implements ChapterService{
	@Autowired
	private ChapterMapper chapterMapper;
	@Autowired
	private KpService kpService;
	@Autowired
	private ChapterDataMapper chapterDataMapper;
	
	@Autowired
	private JedisClient jedisClient;
	@Value("${COURSE_REDIS_KEY}")
	private String COURSE_REDIS_KEY;
	@Value("${COURSE_CHAPTER_INFO_KEY}")
	private String COURSE_CHAPTER_INFO_KEY;
	
	
	@Override
	public Chapter createChapter(String chapterName, Integer courseId) {
		Chapter chapter = new Chapter();
		chapter.setChapterName(chapterName);
		chapter.setCourseId(courseId);
		//设置时间
		Date date = new Date();
		chapter.setCreateTime(date);
		chapter.setUpdateTime(date);
		chapter.setState((byte)1);
		chapterMapper.insert(chapter);
		return chapter;
	}

	@Override
	public HttpResult updateChapter(Integer chapterId, String name) {
		//重命名
		Chapter chapter = new Chapter();
		chapter.setChapterName(name);
		
		//更新
		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		chapterMapper.updateByExampleSelective(chapter, example);
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteChapterById(Integer id) {
		//删除
		ChapterExample example = new ChapterExample();
		ChapterExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(id);
		Chapter chapter = new Chapter();
		chapter.setState((byte)0);
		chapterMapper.updateByExampleSelective(chapter, example);
		List<KnowledgePoint> kps = kpService.getKpList(id);
		
		//兼容kpService的接口
		for(KnowledgePoint kp:kps) {
			kpService.deleteKp(kp.getKpId());
		}
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteChapterByIdEx(Integer id) {
		List<KnowledgePoint> kps = kpService.getKpList(id);
		//兼容kpService的接口
		for(KnowledgePoint kp:kps) {
			kpService.deleteKpEx(kp.getKpId());
		}
		return HttpResult.ok();
	}

	@Override
	public HttpResult createChapterData(ChapterData chapterData) {
		chapterDataMapper.insertSelective(chapterData);
		return HttpResult.ok(chapterData.getId());
	}

	@Override
	public HttpResult updateChapterData(ChapterData chapterData) {
		chapterDataMapper.updateByPrimaryKeySelective(chapterData);
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteChapterDataById(Integer id) {
		chapterDataMapper.deleteByPrimaryKey(id);
		return HttpResult.ok();
	}

	@Override
	public List<ChapterData> getChapterDatas(Integer chapterId) {
		ChapterDataExample example = new ChapterDataExample();
		ChapterDataExample.Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		List<ChapterData> list = chapterDataMapper.selectByExample(example);
		return list;
	}

	@Override
	public void cleanCache(Integer id) { //id为课程id
		try {
			jedisClient.del(COURSE_REDIS_KEY+":"+id+":"+COURSE_CHAPTER_INFO_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
