package com.edu.manager.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.mapper.TeacherMapper;
import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;
import com.edu.common.pojo.TeacherExample;
import com.edu.common.utils.CookieUtils;
import com.edu.common.utils.JsonUtils;
import com.edu.common.utils.PasswordUtil;
import com.edu.manager.component.JedisClient;
import com.edu.manager.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;  //用于token存储
	@Value("${REDIS_SESSION_EXPIRE}")
	private Integer REDIS_SESSION_EXPIRE; //session过期时间
	
	@Override
	public HttpResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		
		TeacherExample example = new TeacherExample();
		TeacherExample.Criteria criteria = example.createCriteria();
		criteria.andTchAccountEqualTo(username);
		List<Teacher> list = teacherMapper.selectByExample(example);
		//判断用户是否存在
		if (list == null || list.isEmpty()) {
			return HttpResult.build(400, "用户名或密码错误");
		}
		Teacher teacher = list.get(0);
		//判断密码是否正确
		password = PasswordUtil.encodeUseMD5(username + password);
		if (!password.equals(teacher.getTchPassword())) {
			return HttpResult.build(400, "用户名或密码错误");
		}
		//用户名密码正确,生成token
		String token = UUID.randomUUID().toString();
		//把用户信息写入redis中
		teacher.setTchPassword(null);
		String uRedisKey = REDIS_SESSION_KEY + ":" +token;
		jedisClient.set(uRedisKey, JsonUtils.objectToJson(teacher));
		//将用户信息写入session中，保证redis不可用时依旧可以校验
		request.getSession().setAttribute(uRedisKey, teacher);
		//设置过期时间
		jedisClient.expire(uRedisKey, REDIS_SESSION_EXPIRE);
		//将token放到Cookie中
		CookieUtils.setCookie(request, response, "EDU_TOKEN", token);
		return HttpResult.ok();
	}

	@Override
	public Teacher getUserByToken(HttpServletRequest request, HttpServletResponse response) {
		//从cookie中获取token
		String token = CookieUtils.getCookieValue(request, "EDU_TOKEN");
		String uRedisKey = REDIS_SESSION_KEY + ":" +token;
		String json = jedisClient.get(uRedisKey);
		//查看用户session是否过期
		if (StringUtils.isBlank(json)) {
			return null;
		}
		Teacher teacher = JsonUtils.jsonToPojo(json, Teacher.class);
		//更新用户session
		jedisClient.expire(uRedisKey, REDIS_SESSION_EXPIRE);
		return teacher;
	}

	@Override
	public HttpResult safeLogout(HttpServletRequest request, HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, "EDU_TOKEN");
		if(StringUtils.isNotBlank(token)) {
			String uRedisKey = REDIS_SESSION_KEY + ":" +token;
			request.getSession().removeAttribute(uRedisKey);
			jedisClient.del(uRedisKey);
		}
		return HttpResult.ok();
	}

	@Override
	public boolean tokenLogin(HttpServletRequest request, HttpServletResponse response, String token) {
		try {
			String uRedisKey = REDIS_SESSION_KEY + ":" +token;
			String jsonData = jedisClient.get(uRedisKey);
			if(StringUtils.isBlank(jsonData)) {
				return false;
			}
			//设置过期时间
			jedisClient.expire(uRedisKey, REDIS_SESSION_EXPIRE);
			//将用户信息写入session中，保证redis不可用时依旧可以校验
			Teacher teacher = JsonUtils.jsonToPojo(jsonData, Teacher.class);
			request.getSession().setAttribute(uRedisKey, teacher);
			//将token放到Cookie中
			CookieUtils.setCookie(request, response, "EDU_TOKEN", token);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return false;
		}
		return true;
	}

	@Override
	public Teacher getUserBySession(HttpServletRequest request, HttpServletResponse response) {
		//从cookie中获取token
		String token = CookieUtils.getCookieValue(request, "EDU_TOKEN");
		String uKey = REDIS_SESSION_KEY + ":" +token;
		Teacher teacher = (Teacher) request.getSession().getAttribute(uKey);
		return teacher;
	}

	
	
}
