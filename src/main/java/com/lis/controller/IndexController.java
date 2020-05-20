package com.lis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		// TODO Auto-generated method stub
		System.out.println("访问首页！");
		return "index";
	}
}
