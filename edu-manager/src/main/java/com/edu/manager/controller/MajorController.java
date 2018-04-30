package com.edu.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.EasyUIComboboxData;
import com.edu.manager.service.MajorService;

@Controller
public class MajorController{
	
	@Autowired
	private MajorService majorService;
	
	@RequestMapping("/manager/majors/list")
	@ResponseBody
	public List<EasyUIComboboxData> getMajorList(){
		return majorService.getMajorList();
	}
}
