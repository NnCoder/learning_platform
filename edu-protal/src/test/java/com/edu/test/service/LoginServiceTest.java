package com.edu.test.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.HttpClientUtil;
import com.edu.protal.service.LoginService;

public class LoginServiceTest {
	
	private static LoginService loginService;
	
	@BeforeClass
	public static void before() {
		ApplicationContext atx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		loginService = atx.getBean(LoginService.class);
	}
	
	@Test
	public void testLogin() {
		//HttpResult httpResult = loginService.login("04151307", "123456", 1);
		//System.out.println(httpResult.getMsg());

	}
}	
