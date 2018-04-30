package com.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Video;
import com.edu.manager.service.VideoService;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	@RequestMapping(value="/manager/video",method=RequestMethod.POST)
	@ResponseBody
	public HttpResult createVideo(Video video) {
		HttpResult result = videoService.createVideo(video);
		return result;
	}
	
	
	@RequestMapping(value="/manager/video", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateVideo(Video video) {
		HttpResult result = videoService.updateVideo(video);
		return result;
	}
	
	@RequestMapping(value="/manager/video", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteVideo(Integer id) {
		HttpResult result = videoService.deleteVideoEx(id);
		return result;
	}
}
