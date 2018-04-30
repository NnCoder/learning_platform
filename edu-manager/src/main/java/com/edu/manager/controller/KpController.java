package com.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.KnowledgePointWithBLOBs;
import com.edu.manager.service.KpService;

@Controller
public class KpController {
	@Autowired
	private KpService kpService;
	
	@RequestMapping("/manager/kp/list")
	@ResponseBody
	public EasyUIDataGridResult getKpList(Integer chapterId,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="6") int rows) {
		if (chapterId == null) {
			return null;
		}
		EasyUIDataGridResult result = kpService.getKpList(chapterId, page, rows);
		return result;
	}
	
	@RequestMapping(value="/manager/kp", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult createKp(KnowledgePointWithBLOBs knowledgePoint) {
		HttpResult result = kpService.createKp(knowledgePoint);
		return result;
	}
	
	@RequestMapping(value="/manager/kp", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateKp(KnowledgePointWithBLOBs knowledgePoint) {
		HttpResult result = kpService.updateKp(knowledgePoint);
		return result;
	}
	
	@RequestMapping(value="/manager/kp", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult updateKp(String ids) {
		HttpResult result = kpService.deleteKps(ids);
		return result;
	}
}
