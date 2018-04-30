package com.edu.rest.service;

import org.springframework.stereotype.Service;

import com.edu.common.pojo.HttpResult;

@Service
public interface LoginService {
	
	HttpResult login(String username, String password, int type);
	
	HttpResult stuLogin(String username, String password);
	
	HttpResult tchLogin(String username, String password);
	
	HttpResult logout(String token);
}
