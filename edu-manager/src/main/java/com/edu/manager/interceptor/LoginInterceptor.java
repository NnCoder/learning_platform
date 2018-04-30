package com.edu.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.edu.common.pojo.Teacher;
import com.edu.manager.service.LoginService;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private LoginService loginService;
	@Value("${LOGIN_URL}")
	private String LOGIN_URL;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		Teacher teacher = null;
		try {
			teacher = loginService.getUserByToken(request, response);
		} catch (Exception e) {
			//redis超时！转为session验证
			teacher = loginService.getUserBySession(request, response);
		}
		
		if (teacher == null) {
			response.sendRedirect(LOGIN_URL);
			return false;
		}
		//将用户信息放入request中
		request.setAttribute("user", teacher);
		//放行
		return true;
	}
	
}
