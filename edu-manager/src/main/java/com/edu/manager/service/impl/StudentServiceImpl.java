package com.edu.manager.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.mapper.StuVideoMapper;
import com.edu.common.mapper.StudentMapper;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.StuVideoExample;
import com.edu.common.pojo.Student;
import com.edu.common.pojo.StudentExample;
import com.edu.common.utils.IntegerUtil;
import com.edu.common.utils.PasswordUtil;
import com.edu.manager.component.ExcelUtil;
import com.edu.manager.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private StuVideoMapper stuVideoMapper;
	@Autowired
	private ExcelUtil excelUtil;
	
	@Override
	public EasyUIDataGridResult getStudents(int page, int rows) {
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		//分页查询
		PageHelper.startPage(page, rows);
		StudentExample example = new StudentExample();
		List<Student> list = studentMapper.selectByExample(example);
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public HttpResult insertStudentsByExcel(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		ArrayList<ArrayList<String>> result = null;
		Student stu = null;
		//根据文件后缀判断excel文件为2007 or 2003
		if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
			result = fileName.endsWith(".xlsx")?excelUtil.readExcel2007(file.getInputStream()):excelUtil.readExcel2003(file.getInputStream());
			//错误栈
			StringBuffer errorStack = new StringBuffer();
			for (ArrayList<String> list : result) {
				try {
					String account = list.get(0);
					String name = list.get(1);
					String majorName = list.get(2);
					String classIndex = list.get(3);
					stu = new Student();
					stu.setStuAccount(account);
					String password = PasswordUtil.encodeUseMD5(account + "123456");
					stu.setStuPassword(password);
					stu.setStuName(name);
					stu.setMajorName(majorName);
					stu.setClassIndex(IntegerUtil.parseInt(classIndex));
					studentMapper.insertSelective(stu);
				} catch (Exception e) {
					String error = list.get(0);
				
					//压入错误栈
					errorStack.append(error + "<br/>");
				}
			}
			//错误栈为空,导入成功
			if (StringUtils.isBlank(errorStack)) {
				return HttpResult.ok();
			}else {
				return HttpResult.build(500, errorStack.toString());
			}
		}else {
			return HttpResult.build(500, "文件类型不符合!");
		}
	}

	@Override
	public HttpResult deleteStus(String stuAccounts) {
		if (StringUtils.isBlank(stuAccounts)) {
			return HttpResult.build(400, "参数有误!");
		}
		String strs[] = stuAccounts.split(",");
		for (String stuAccount : strs) {
			deleteStuByAccount(stuAccount);
		}
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteStuByAccount(String stuAccount) {
		studentMapper.deleteByPrimaryKey(stuAccount);
		//删除该学生所有相关的记录
		StuVideoExample example = new StuVideoExample();
		example.createCriteria().andStuAccountEqualTo(stuAccount);
		stuVideoMapper.deleteByExample(example);
		return HttpResult.ok();
	}

	@Override
	public HttpResult updateStu(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
		return HttpResult.ok();
	}

	@Override
	public HttpResult updateStusState(String stuAccounts, int state) {
		if (StringUtils.isBlank(stuAccounts)) {
			return HttpResult.build(400, "参数有误!");
		}
		String strs[] = stuAccounts.split(",");
		Student student = null;
		for (String stuAccount : strs) {
			student = new Student();
			student.setStuAccount(stuAccount);
			student.setState((byte)state);
			updateStu(student);
		}
		return HttpResult.ok();
	}

	@Override
	public Student getStudentByAccount(String stuAccount) {
		Student student = studentMapper.selectByPrimaryKey(stuAccount);
		student.setStuPassword(null);
		return student;
	}

	@Override
	public HttpResult insertStudent(Student student) {
		//查询学号是否重复
		StudentExample example = new StudentExample();
		StudentExample.Criteria criteria = example.createCriteria();
		criteria.andStuAccountEqualTo(student.getStuAccount());
		List<Student> list = studentMapper.selectByExample(example);
		//学号不存在
		if (list == null || list.isEmpty()) {
			String account = student.getStuAccount();
			String password = PasswordUtil.encodeUseMD5(account + "123456");
			student.setStuPassword(password);
			studentMapper.insertSelective(student);
			return HttpResult.ok();
		}
		return HttpResult.build(400, "添加失败,该学号已存在");
	}

	@Override
	public EasyUIDataGridResult selectStusByTeacher(String tchAccount,int page, int rows) {
		//Mybatis分页插件
		PageHelper.startPage(page, rows);
		List<Student> list = studentMapper.selectByTchAccount(tchAccount);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		//分页信息
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
}
