package com.lis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lis.common.MD5Util;
import com.lis.common.RedisService;
import com.lis.mapper.LoginMapper;
import com.lis.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	private RedisService redis;
	@Autowired
	private LoginMapper LoginMapper;
	
	//账号密码登录
	public String passwordLogin(User user) {
		String ticket="";
		try{
			//对密码进行加密重新赋值
			user.setPassword(MD5Util.md5(user.getPassword()));
			User resUser=LoginMapper.queryUser(user);
			System.out.println("UserName:" + user.getUserName()+"  Password:" + user.getPassword());
			if(resUser!=null){
				ticket = String.valueOf((int)((Math.random()*9+1)*100000));
				//将登录信息存储在redis中,供后续 验证访问
				redis.set(resUser.getUserName(), MD5Util.md5(ticket), 60*30);
			}else{
				ticket = "登录失败，请检查用户名密码是否正确！";
			}	
		}catch(Exception e){
			e.printStackTrace();
			ticket ="登陆失败，请稍后重试！";
		}
		return ticket;
	}

}