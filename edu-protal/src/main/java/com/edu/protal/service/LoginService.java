package com.edu.protal.service;

import com.edu.common.pojo.HttpResult;

public interface LoginService {
	
	public HttpResult login(String username, String password, Integer type);
	
	public void logout(String token);
}
