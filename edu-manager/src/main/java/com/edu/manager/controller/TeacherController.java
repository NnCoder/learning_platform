package com.edu.manager.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.pojo.EasyUIComboboxData;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;
import com.edu.common.utils.ExceptionUtil;
import com.edu.manager.service.StudentService;
import com.edu.manager.service.TeacherService;


@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/manager/teacher/list")
	@ResponseBody
	public EasyUIDataGridResult getTeachers(@RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="20")int rows) {
		EasyUIDataGridResult result = teacherService.getTeachers(page, rows);
		return result;
	}
	
	@RequestMapping("/manager/teacher/combobox")
	@ResponseBody
	public List<EasyUIComboboxData> getTeachers(){
		List<EasyUIComboboxData> list = teacherService.getTeachersForCombobox();
		return list;
	}
	
	@RequestMapping(value = "/manager/teacher/excel", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertTeacherByExcel(MultipartFile file) {
		try {
			HttpResult result = teacherService.insertTeachersByExcel(file);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return HttpResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	
	@RequestMapping(value = "/manager/teacher/student/excel", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertTeacherStuByExcel(String tchAccount, MultipartFile file) {
		try {
			HttpResult result = teacherService.insertTeacherStuByExcel(tchAccount, file);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return HttpResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value="/manager/teacher/student", method=RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGridResult selectStusByTeacher(String tchAccount, int page, int rows) {
		EasyUIDataGridResult result = studentService.selectStusByTeacher(tchAccount, page, rows);
		return result;
	}
	
	@RequestMapping(value="/manager/teacher/student", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteTchStus(String tchAccount, String stuAccounts) {
		HttpResult result = teacherService.deleteTeacherStus(tchAccount, stuAccounts);
		return result;
	}
	
	@RequestMapping(value="/manager/teacher/student/deleteAll", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteAllTchStusByTeacher(String tchAccount) {
		HttpResult result = teacherService.deleteAllTeacherStu(tchAccount);
		return result;
	}
	
	@RequestMapping(value="/manager/teacher", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteTeachers(String tchAccounts) {
		HttpResult result = teacherService.deleteTchs(tchAccounts);
		return result;
	}
	
	@RequestMapping(value = "/manager/teacher/{role}", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateTeachersRole(String tchAccounts, @PathVariable String role) {
		HttpResult result = teacherService.updateTchsRole(tchAccounts, role);
		return result;
	}
	
	@RequestMapping(value="/manager/teacher", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateTeacher(Teacher teacher) {
		HttpResult result = teacherService.updateTch(teacher);
		return result;
	}
	
	@RequestMapping(value="/manager/teacher", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertTeacher(Teacher teacher) {
		HttpResult result = teacherService.insertTeacher(teacher);
		return result;
	}
	
	@RequestMapping(value="/manager/teacher/psw", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updatePsw(String tchAccount, String psw, String newpsw) {
		HttpResult result = teacherService.updateTchPsw(tchAccount, psw, newpsw);
		return result;
	}
}
