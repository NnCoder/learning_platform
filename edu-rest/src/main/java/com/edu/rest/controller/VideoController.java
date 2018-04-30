package com.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.rest.service.VideoService;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	@RequestMapping("/kp/{kpId}/videos")
	@ResponseBody
	public HttpResult getVideosByKpId(@PathVariable Integer kpId) {
		HttpResult result = videoService.getVideosByKpId(kpId);
		return result;
	}
	
	
}
