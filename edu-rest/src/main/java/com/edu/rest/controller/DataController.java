package com.edu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.Data;
import com.edu.rest.service.DataService;

@Controller
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping("/kp/{kpId}/datas")
	@ResponseBody
	public List<Data> getDataByKpIdAndType(@PathVariable Integer kpId, @RequestParam(defaultValue="1") int type) {
		List<Data> list = dataService.getDataByKpIdAndType(kpId, type);
		return list;
	}
	
	@RequestMapping("/datas/recent")
	@ResponseBody
	public List<Data> getDataRecent(@RequestParam(defaultValue="10") int limit){
		List<Data> list = dataService.getRecentDatas(limit);
		return list;
	}
}
