package com.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.rest.service.KpService;

@Controller
public class KpController {
	
	@Autowired
	private KpService kpService;
	
	@RequestMapping("/kp/{id}")
	@ResponseBody
	public HttpResult getKpDetail(@PathVariable Integer id) {
		HttpResult result = kpService.getKpDetailById(id);
		return result;
	}
}
