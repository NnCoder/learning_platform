package com.edu.rest.service;

import com.edu.common.pojo.HttpResult;

public interface VideoService {	
	
	public HttpResult getVideosByKpId(Integer kpId);
}
