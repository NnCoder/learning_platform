package com.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.Data;
import com.edu.common.pojo.HttpResult;
import com.edu.manager.service.DataService;

@Controller
public class DataController {
	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="/manager/data", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult createData(Data data) {
		HttpResult result = dataService.createData(data);
		return result;
	}
	
	@RequestMapping(value="/manager/data", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateData(Data data) {
		HttpResult result = dataService.updateDate(data);
		return result;
	}
	
	@RequestMapping(value="/manager/data", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteData(Integer id) {
		HttpResult result = dataService.deleteData(id);
		return result;
	}
	
}
