package com.edu.protal.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.pojo.HttpResult;
import com.edu.protal.pojo.User;
import com.edu.protal.service.LoginService;
import com.edu.protal.util.Base64Utils;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Value("${USER_SESSION_KEY}")
	private String USER_SESSION_KEY;
	
	@Value("${INDEX_URL}")
	private String INDEX_URL;
	
	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("indexUrl", INDEX_URL);
		return "page-login";
	}
	
	@PostMapping("/user/login")
	@ResponseBody
	public HttpResult ajaxLogin(String username, String password, Integer type, HttpServletRequest request) {
		password = Base64Utils.decodeBase64(password);
		HttpResult result = loginService.login(username, password, type);
		if (result.getStatus() == 200) {
			request.getSession().setAttribute("user", result.getData());
		}
		return result;
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			loginService.logout(user.getToken());
			request.getSession().removeAttribute("user");
		}
		
		return "redirect:/login.html";
	}
}
