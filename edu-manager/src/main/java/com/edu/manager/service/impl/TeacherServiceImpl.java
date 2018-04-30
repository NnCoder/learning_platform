package com.edu.manager.service.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edu.common.mapper.CourseMapper;
import com.edu.common.mapper.TchStuMapper;
import com.edu.common.mapper.TeacherMapper;
import com.edu.common.pojo.EasyUIComboboxData;
import com.edu.common.pojo.EasyUIDataGridResult;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.TchStuExample;
import com.edu.common.pojo.TchStuKey;
import com.edu.common.pojo.Teacher;
import com.edu.common.pojo.TeacherExample;
import com.edu.common.utils.PasswordUtil;
import com.edu.manager.component.ExcelUtil;
import com.edu.manager.service.CourseService;
import com.edu.manager.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherMapper teacherMapper;
	/*@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CourseService courseService;*/
	@Autowired
	private ExcelUtil excelUtil;
	@Autowired
	private TchStuMapper tchStuMapper;
	
	@Override
	public EasyUIDataGridResult getTeachers(int page, int rows) {
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		//分页
		PageHelper.startPage(page, rows);
		TeacherExample example = new TeacherExample();
		List<Teacher> list = teacherMapper.selectByExample(example);
		//分页信息
		PageInfo<Teacher> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}
	
	
	@Override
	public HttpResult insertTeachersByExcel(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		ArrayList<ArrayList<String>> result = null;
		Teacher teacher = null;
		//根据文件后缀判断excel文件为2007 or 2003
		if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
			result = fileName.endsWith(".xlsx")?excelUtil.readExcel2007(file.getInputStream()):excelUtil.readExcel2003(file.getInputStream());
			//错误栈
			StringBuffer errorStack = new StringBuffer();
			for (ArrayList<String> list : result) {
				try {
					String account = list.get(0);
					String name = list.get(1);
					teacher = new Teacher();
					teacher.setTchAccount(account);
					String password = PasswordUtil.encodeUseMD5(account + "123456");
					teacher.setTchPassword(password);
					teacher.setTchName(name);
					teacherMapper.insertSelective(teacher);
				} catch (Exception e) {
					String error = "";
					for (String str : list) {
						error += str + " ";
					}
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
	
	/**
	 * 删除多个教师
	 */
	@Override
	public HttpResult deleteTchs(String tchAccounts) {
		if (StringUtils.isBlank(tchAccounts)) {
			return HttpResult.build(400, "请求参数有误!");
		}
		String strs[] = tchAccounts.split(",");
		for (String tchAccount : strs) {
			deleteTchByAccount(tchAccount);
		}
		return HttpResult.ok();
	}
	
	/**
	 * 更新教师角色
	 */
	@Override
	public HttpResult updateTchsRole(String tchAccounts, String role) {
		if (StringUtils.isBlank(tchAccounts) || StringUtils.isBlank(role)) {
			return HttpResult.build(400, "请求参数有误!");
		}
		String strs[] = tchAccounts.split(",");
		for (String tchAccount : strs) {
			updateTchRoleByAccount(tchAccount, role);
		}
		return HttpResult.ok();
	}

	@Override
	public HttpResult deleteTchByAccount(String tchAccount) {
		/*//先删除与该教师相关的所有课程
		CourseExample example = new CourseExample();
		CourseExample.Criteria criteria = example.createCriteria();
		criteria.andTchAccountEqualTo(tchAccount);
		List<Course> list = courseMapper.selectByExample(example);
		for (Course course : list) {
			courseService.deleteCourseEx(course.getCourseId());
		}*/
		//删除老师
		teacherMapper.deleteByPrimaryKey(tchAccount);
		return HttpResult.ok();
	}

	@Override
	public HttpResult updateTchRoleByAccount(String tchAccount, String role) {
		Teacher teacher = new Teacher();
		teacher.setTchAccount(tchAccount);
		teacher.setRole(role);
		updateTch(teacher);
		return HttpResult.ok();
	}

	@Override
	public HttpResult updateTch(Teacher teacher) {
		teacherMapper.updateByPrimaryKeySelective(teacher);
		return HttpResult.ok();
	}

	@Override
	public Teacher getTeacherByAccount(String tchAccount) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(tchAccount);
		teacher.setTchPassword(null);
		return teacher;
	}

	@Override
	public HttpResult insertTeacher(Teacher teacher) {
		TeacherExample example = new TeacherExample();
		TeacherExample.Criteria criteria = example.createCriteria();
		criteria.andTchAccountEqualTo(teacher.getTchAccount());
		List<Teacher> list = teacherMapper.selectByExample(example);
		//账号不存在
		if (list == null || list.isEmpty()) {
			String account = teacher.getTchAccount();
			String password = PasswordUtil.encodeUseMD5(account+"123456");
			teacher.setTchPassword(password);
			teacherMapper.insertSelective(teacher);
			return HttpResult.ok();
		}
		//账号存在
		return HttpResult.build(400, "账号已存在!");
	}

	@Override
	public HttpResult updateTchPsw(String tchAccount, String psw, String newpsw) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(tchAccount);
		psw = PasswordUtil.encodeUseMD5(tchAccount + psw);
		if (!teacher.getTchPassword().equals(psw)) {
			return HttpResult.build(400, "用户原密码错误!");
		}
		newpsw = PasswordUtil.encodeUseMD5(tchAccount + newpsw);
		teacher.setTchPassword(newpsw);
		teacherMapper.updateByPrimaryKey(teacher);
		return HttpResult.ok();
	}


	@Override
	public List<Teacher> getTeachers() {
		List<Teacher> list = teacherMapper.selectAccountAndName();
		return list;
	}


	@Override
	public List<EasyUIComboboxData> getTeachersForCombobox() {
		List<Teacher> list = teacherMapper.selectAccountAndName();
		EasyUIComboboxData data = null;
		List<EasyUIComboboxData> datas = new ArrayList<>();
		for(Teacher teacher: list) {
			data = new EasyUIComboboxData();
			data.setId(teacher.getTchAccount());
			data.setText(teacher.getTchName());
			datas.add(data);
		}
		return datas;
	}


	
	@Override
	public HttpResult insertTeacherStuByExcel(String tchAccount, MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		//excel读取后返回的结果集
		ArrayList<ArrayList<String>> result = null;
		//根据文件后缀判断excel文件为2007 or 2003
		if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
			result = fileName.endsWith(".xlsx")?excelUtil.readExcel2007(file.getInputStream()):excelUtil.readExcel2003(file.getInputStream());
			//错误栈
			StringBuffer errorStack = new StringBuffer();
			TchStuKey tchStuKey = null;
			//从excel导入老师与学生的联系
			for (ArrayList<String> list : result) {
				try {
					String stuAccount = list.get(0);
					tchStuKey = new TchStuKey();
					tchStuKey.setTchAccount(tchAccount);
					tchStuKey.setStuAccount(stuAccount);
					tchStuMapper.insert(tchStuKey);
				} catch (Exception e) {
					String error = list.get(0);
					errorStack.append(error + "<br/>");
				}
				
			}
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
	public HttpResult deleteTeacherStus(String tchAccount, String stuAccounts) {
		if(StringUtils.isNotBlank(stuAccounts)) {
			String strs[] = stuAccounts.split(",");
			//定义为一次性引用,方便gc回收
			TchStuKey key = null;
			for(String stuAccount : strs) {
				key = new TchStuKey();
				key.setStuAccount(stuAccount);
				key.setTchAccount(tchAccount);
				tchStuMapper.deleteByPrimaryKey(key);
			}
		}
		return HttpResult.ok();
	}


	@Override
	public HttpResult deleteAllTeacherStu(String tchAccount) {
		TchStuExample example = new TchStuExample();
		TchStuExample.Criteria criteria = example.createCriteria();
		criteria.andTchAccountEqualTo(tchAccount);
		tchStuMapper.deleteByExample(example);
		return HttpResult.ok();
	}


	
}
