package com.edu.manager.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;

public interface LoginService {
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @param request 用于cookie存储
	 * @param response 用于cookie存储
	 * @return
	 */
	HttpResult login(String username, String password, 
			HttpServletRequest request, HttpServletResponse response);
	
	boolean tokenLogin(HttpServletRequest request, HttpServletResponse response, String token);
	/**
	 * 根据用户token获取用户信息返回
	 * @param token
	 * @return
	 */
	Teacher getUserByToken(HttpServletRequest request, HttpServletResponse response);
	
	Teacher getUserBySession(HttpServletRequest request, HttpServletResponse response);
	
	HttpResult safeLogout(HttpServletRequest request, HttpServletResponse response);
}	
