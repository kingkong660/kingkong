package com.lis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lis.common.CookieUtils;
import com.lis.common.MD5Util;
import com.lis.common.SysResult;
import com.lis.common.Regular;
import com.lis.pojo.User;
import com.lis.service.LoginService;


@Controller
public class loginController {

	@Autowired
	private LoginService LoginService;

	//登录流程
	@RequestMapping("user/login_password")
	@ResponseBody
	public SysResult doLogin(User user,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		SysResult result=new SysResult();
		//所有的逻辑都交给service处理
		String ticket = LoginService.passwordLogin(user);
		
		//判断,登录成功时ticket为随机数字，失败时为错误信息
		if(Regular.isNumber(ticket)){
			//说明登录成功了
			//响应中添加cookie,将ticket放到一个"JT_TICKET"
			CookieUtils.setCookie(request, response, 
					"lis_ticket", MD5Util.md5(ticket));
			result.setStatus(200);
			result.setData("http://localhost/index");;
			return result;
		}else{//失败
			result.setStatus(201);
			result.setMessage(ticket);
			return result;
		}
	}
	
}
