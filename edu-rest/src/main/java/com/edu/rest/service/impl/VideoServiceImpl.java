package com.edu.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.VideoMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Video;
import com.edu.common.pojo.VideoExample;
import com.edu.rest.service.VideoService;


@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public HttpResult getVideosByKpId(Integer kpId) {
		//通过知识点id查询该知识点下所有视频
		VideoExample example = new VideoExample();
		VideoExample.Criteria criteria = example.createCriteria();
		criteria.andKpIdEqualTo(kpId);
		criteria.andStateEqualTo((byte)1);
		List<Video> videos = videoMapper.selectByExample(example);
		return HttpResult.ok(videos);
	}
	
	

}
