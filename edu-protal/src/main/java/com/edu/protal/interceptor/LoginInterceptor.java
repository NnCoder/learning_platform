package com.edu.protal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.edu.common.pojo.Student;
import com.edu.protal.pojo.User;

public class LoginInterceptor implements HandlerInterceptor {
	@Value("${USER_SESSION_KEY}")
	private String USER_SESSION_KEY;
	@Value("${LOGIN_URL}")
	private String LOGIN_URL;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//查看用户是否登录
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			//request.getSession().setMaxInactiveInterval(7200);
			return true;
		}
		response.sendRedirect(LOGIN_URL);
		return false;
	}
	
}
