package com.lis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lis.service.LoginService;


@Controller
public class loginController {

	@Autowired
	private LoginService LoginService;

	// 账号密码登录
	@RequestMapping("user/passwordLogin")
	@ResponseBody
	public String doLogin(String userName,String userPassword) {
		System.out.println("接到密码登录请求！");
		// 所有的逻辑都交给service处理
		String ticket = LoginService.passwordLogin(userName, userPassword);
		System.out.println("ticket: " + ticket);
		ticket="e";
		return ticket;
	}

}
