package com.edu.protal.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.HttpClientUtil;
import com.edu.protal.pojo.User;
import com.edu.protal.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Value("${BASE_REST_URL}")
	private String BASE_REST_URL;
	@Value("${REST_LOGIN_URL}")
	private String LOGIN_URL;
	
	@Override
	public HttpResult login(String username, String password, Integer type) {
		Map<String, String> param = new HashMap<>();
		param.put("username", username);
		param.put("password", password);
		param.put("type", String.valueOf(type));
		String url = BASE_REST_URL + LOGIN_URL;
		String jsonData = HttpClientUtil.doPost(url,param);
		return HttpResult.formatToPojo(jsonData, User.class);
	}

	@Override
	public void logout(String token) {
		HttpClientUtil.doGet(BASE_REST_URL+ "user/logout");
	}
	
}
