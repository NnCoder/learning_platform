package com.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.rest.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/user/login", method=RequestMethod.POST)
	@ResponseBody
	public HttpResult login(String username, String password, int type) {
		HttpResult result = loginService.login(username, password, type);
		return result;
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	@ResponseBody
	public HttpResult logout(String token) {
		HttpResult result = loginService.logout(token);
		return result;
	}
}
