package com.lis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
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
	public String passwordLogin(String name,String password) {
		String ticket="";
		User _user=new User();
		_user.setUserName(name);;
		_user.setUserTelephone(name);
		_user.setUserPassword(MD5Util.md5(password));//_user usernanme和
		System.out.println(MD5Util.md5(password));
		User user= LoginMapper.queryUser(_user);
		System.out.println(user);
		try{
			if(user==null){//登录失败
				ticket="";
				System.out.println("登录失败");
				return ticket;
			}else{//登录成功;生成ticket
				ticket=MD5Util.md5("JT_TICKET"
			+System.currentTimeMillis()+name);
				//将查询的user转化成json字符串,存储在redis中,供后续
				//验证访问
				JSONObject json = null;
				//以json存放，这里使用的是阿里的fastjson
				json = new JSONObject();
				json.put("flage", ticket);
				redis.set(user.getUserId(), json.toJSONString(), 60*5);
				System.out.println("登录成功!");
				System.out.println("json.toJSONString(): " + json.toJSONString());
				return ticket;
			}	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("登录报错");
			return "";
		}
	}
}



