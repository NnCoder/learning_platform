package com.edu.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.StuVideoMapper;
import com.edu.common.mapper.VideoMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.StuVideoExample;
import com.edu.common.pojo.Video;
import com.edu.common.pojo.VideoExample;
import com.edu.common.utils.HttpClientUtil;
import com.edu.manager.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private StuVideoMapper stuVideoMapper;
	
	@Override
	public HttpResult createVideo(Video video) {
		Date date = new Date();
		video.setCreateTime(date);
		video.setUpdateTime(date);
		video.setVedioGrade((byte)2);
		videoMapper.insertSelective(video);
		return HttpResult.ok(video.getVedioId());
	}

	@Override
	public List<Video> getVideoListByKpId(Integer kpId) {
		//通过知识点id获取视频
		VideoExample example = new VideoExample();
		VideoExample.Criteria criteria = example.createCriteria();
		criteria.andKpIdEqualTo(kpId);
		criteria.andStateEqualTo((byte)1);
		
		List<Video> videos = videoMapper.selectByExample(example);
		return videos;
	}

	@Override
	public HttpResult updateVideo(Video video) {
		video.setUpdateTime(new Date());
		videoMapper.updateByPrimaryKeySelective(video);
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteVideo(Integer id) {
		Video video = new Video();
		video.setVedioId(id);
		video.setState((byte)0);
		videoMapper.updateByPrimaryKeySelective(video);
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteVideoEx(Integer id) {
		Video video = videoMapper.selectByPrimaryKey(id);
		StuVideoExample example = new StuVideoExample();
		StuVideoExample.Criteria criteria = example.createCriteria();
		criteria.andVideoIdEqualTo(id);
		//先删除子元素
		stuVideoMapper.deleteByExample(example);
		//删除父元素
		videoMapper.deleteByPrimaryKey(id);
		//删除文件库
		HttpClientUtil.doGet(video.getVedioSrc()+"/delete");
		return HttpResult.ok();
	}
}
