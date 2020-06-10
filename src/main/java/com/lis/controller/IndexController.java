package com.lis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value={"/","index"})
	public String index() {
		// TODO Auto-generated method stub
		System.out.println("访问index页！");
			return "index";
	}

	@RequestMapping("/login")
	public String login() {
		// TODO Auto-generated method stub
		System.out.println("访问login页！");
			return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		// TODO Auto-generated method stub
		System.out.println("访问welcome页！");
		return "welcome";
	}
	


}
