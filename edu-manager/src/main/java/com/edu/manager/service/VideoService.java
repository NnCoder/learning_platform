package com.edu.manager.service;

import java.util.List;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Video;

public interface VideoService {
	HttpResult createVideo(Video video);
	HttpResult updateVideo(Video video);
	HttpResult deleteVideo(Integer id);
	
	/**
	 * 完全删除视频,包括数据库中与文件库中
	 * @param id
	 * @return
	 */
	HttpResult deleteVideoEx(Integer id);
	List<Video> getVideoListByKpId(Integer kpId);
}
