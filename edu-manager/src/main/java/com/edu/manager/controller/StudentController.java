package com.edu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Student;
import com.edu.common.utils.ExceptionUtil;
import com.edu.manager.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value = "/manager/student/excel", method = RequestMethod.POST)
	@ResponseBody
	public HttpResult insertStudentsByExcel(MultipartFile file) {
		try {
			HttpResult result = studentService.insertStudentsByExcel(file);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/manager/student/list")
	@ResponseBody
	public EasyUIDataGridResult getStudents(@RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="20")int rows) {
		EasyUIDataGridResult result = studentService.getStudents(page, rows);
		return result;
	}
	
	@RequestMapping(value="/manager/student", method=RequestMethod.DELETE)
	@ResponseBody
	public HttpResult deleteStudents(String stuAccounts) {
		HttpResult result = studentService.deleteStus(stuAccounts);
		return result;
	}
	
	@RequestMapping(value="/manager/student/{state}", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateStudentsState(String stuAccounts, @PathVariable Integer state) {
		HttpResult result = studentService.updateStusState(stuAccounts, state);
		return result;
	}
	
	@RequestMapping(value="/manager/student", method=RequestMethod.PUT)
	@ResponseBody
	public HttpResult updateStudent(Student student) {
		HttpResult result = studentService.updateStu(student);
		return result;
	}
	
	@RequestMapping(value="/manager/student", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult insertStudent(Student student) {
		HttpResult result = studentService.insertStudent(student);
		return result;
	}
}
