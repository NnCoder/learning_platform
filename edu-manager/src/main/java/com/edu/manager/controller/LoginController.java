package com.edu.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.common.pojo.Teacher;
import com.edu.manager.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/token")
	public String tokenLogin(HttpServletRequest request, HttpServletResponse response, String token, String redirectUrl) {
		//token验证是否通过
		boolean isPass = loginService.tokenLogin(request, response, token);
		if(isPass) {
			return "redirect:"+redirectUrl;
		}else {
			return "error/index";
		}
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult ajaxLogin(String username, String password, 
			HttpServletRequest request, HttpServletResponse response) {
		//用户登录
		HttpResult result = loginService.login(username, password, request, response);
		return result;
	}
	
	@RequestMapping(value="/user/token", method=RequestMethod.POST)
	@ResponseBody
	public Teacher getUserByToken(HttpServletRequest request, HttpServletResponse response) {
		//通过token获取用户信息
		Teacher teacher = loginService.getUserByToken(request, response);
		return teacher;
	}
	
	@RequestMapping(value="/user/safeLogout")
	public String safeLogout(HttpServletRequest request, HttpServletResponse response) {
		loginService.safeLogout(request, response);
		return "redirect:/";
	}
}
