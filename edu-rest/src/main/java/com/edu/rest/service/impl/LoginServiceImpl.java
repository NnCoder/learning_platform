package com.edu.rest.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.StudentMapper;
import com.edu.common.mapper.TeacherMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Student;
import com.edu.common.pojo.Teacher;
import com.edu.common.utils.JsonUtils;
import com.edu.common.utils.PasswordUtil;
import com.edu.rest.component.JedisClient;
import com.edu.rest.pojo.User;
import com.edu.rest.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	@Value("${REDIS_SESSION_EXPIRE}")
	private Integer REDIS_SESSION_EXPIRE;
	@Override
	public HttpResult login(String username, String password, int type) {
		password = PasswordUtil.encodeUseMD5(username+password);
		switch (type) {
		case 1:
			return stuLogin(username, password);
		case 2:
			return tchLogin(username, password);
		default:
			return HttpResult.build(400, "登录类型错误!");
		}
	}

	@Override
	public HttpResult stuLogin(String username, String password) {
		Student student = studentMapper.selectByPrimaryKey(username);
		if (null == student) {
			return HttpResult.build(400, "用户不存在!");
		}
		if (!student.getStuPassword().equals(password)) {
			return HttpResult.build(400, "用户密码错误!");
		}
		//登录成功,返回用户信息
		student.setStuPassword(null);
		User user = new User();
		user.setRole("student");
		user.setToken(UUID.randomUUID().toString());
		user.setUserAccount(student.getStuAccount());
		user.setUserName(student.getStuName());
		return HttpResult.ok(user);
	}

	@Override
	public HttpResult tchLogin(String username, String password) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(username);
		if (null == teacher) {
			return HttpResult.build(400, "用户不存在!");
		}
		if (!teacher.getTchPassword().equals(password)) {
			return HttpResult.build(400, "用户密码错误!");
		}
		//登录成功,返回用户信息
		teacher.setTchPassword(null);
		String jsonData = JsonUtils.objectToJson(teacher);
		String token = UUID.randomUUID().toString();
		try {
			String redisKey = REDIS_SESSION_KEY + ":" + token;
			jedisClient.set(redisKey, jsonData);
			jedisClient.expire(redisKey, REDIS_SESSION_EXPIRE);
		} catch (Exception e) {
			return HttpResult.build(500, e.getMessage());
		}
		User user = new User();
		user.setRole("teacher");
		user.setToken(token);
		user.setUserAccount(teacher.getTchAccount());
		user.setUserName(teacher.getTchName());
		return HttpResult.ok(user);
	}

	@Override
	public HttpResult logout(String token) {
		try {
			jedisClient.del(token);
		} catch (Exception e) {
			
		}
		
		return HttpResult.ok();
	}
	
}
