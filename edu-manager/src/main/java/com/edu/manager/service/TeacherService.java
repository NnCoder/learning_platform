package com.edu.manager.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.edu.common.pojo.EasyUIComboboxData;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;

public interface TeacherService {
	EasyUIDataGridResult getTeachers(int page, int rows);
	List<Teacher> getTeachers();
	List<EasyUIComboboxData> getTeachersForCombobox();
	Teacher getTeacherByAccount(String tchAccount);
	HttpResult insertTeacher(Teacher teacher);
	HttpResult insertTeachersByExcel(MultipartFile file) throws IOException;
	/**
	 * 通过Excel文件导入老师与学生的联系
	 * @param file Excel文件
	 * @param tchAccount 老师账号
	 * @return 
	 * @throws IOException 
	 */
	HttpResult insertTeacherStuByExcel(String tchAccount, MultipartFile file) throws IOException;
	
	HttpResult deleteTeacherStus(String tchAccount, String stuAccounts);
	
	HttpResult deleteAllTeacherStu(String tchAccount);
	
	HttpResult deleteTchs(String tchAccounts);
	HttpResult updateTchsRole(String tchAccounts, String role);
	HttpResult deleteTchByAccount(String tchAccount);
	HttpResult updateTchRoleByAccount(String tchAccount, String role);
	HttpResult updateTch(Teacher teacher);
	HttpResult updateTchPsw(String tchAccount, String psw, String newpsw);
}
