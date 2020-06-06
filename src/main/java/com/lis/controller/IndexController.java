package com.lis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lis.common.PubFun;

@Controller
public class IndexController {

	@Autowired
	private PubFun pubFun;
	
	@RequestMapping("/")
	public String login() {
		System.out.println("访问登录页！");
		return "login";
	}
	
	@RequestMapping("/index")
	public String index(String username,HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("访问首页！");
			return "index";
	}

}
