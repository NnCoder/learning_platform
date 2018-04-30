package com.edu.manager.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Student;

public interface StudentService {
	EasyUIDataGridResult getStudents(int page, int rows);
	
	/**
	 * 显示某老师所负责的学生
	 * @param tchAccount
	 * @return
	 */
	EasyUIDataGridResult selectStusByTeacher(String tchAccount,int page, int rows);
	
	Student getStudentByAccount(String stuAccount);
	
	
	
	HttpResult insertStudent(Student student);
	
	HttpResult insertStudentsByExcel(MultipartFile file) throws IOException;
	
	HttpResult deleteStus(String stuAccounts);
	
	HttpResult deleteStuByAccount(String stuAccount);
	
	HttpResult updateStu(Student student);
	
	HttpResult updateStusState(String stuAccounts, int state);
}
