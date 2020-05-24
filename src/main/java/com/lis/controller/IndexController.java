package com.lis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lis.service.LoginService;


@Controller
public class IndexController {

	@Autowired
	private LoginService LoginService;
	
	@RequestMapping("/")
	public String login() {
		// TODO Auto-generated method stub
		System.out.println("访问登录页！");
		return "login";
	}

}
