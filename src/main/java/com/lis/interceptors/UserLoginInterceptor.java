package com.lis.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lis.common.RedisService;

/**
 * 实现购物车拦截器功能
 * 判断所有请求中是否携带了session的数据
 * userId
 * 有则放行
 * 无重定向到登录页面
 * @author Administrator
 *
 */

@Service
public class UserLoginInterceptor implements HandlerInterceptor{
	
	/*
	 * 完成判断登录的过程
	 */
	
	@Autowired
	private RedisService redis;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取cookie的值
		Cookie[] cookies = request.getCookies();
		if (cookies != null  && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName() != null 
						&& cookie.getValue() != null 
						&& cookie.getValue().equals(redis.get(cookie.getName()))) {
					return true;
				}
			}
		}
		//不满足if的条件,说明没登录,转向登录页面,不放行
		response.sendRedirect("/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
















