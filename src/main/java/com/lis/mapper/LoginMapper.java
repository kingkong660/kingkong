package com.lis.mapper;

import com.lis.pojo.User;

public interface LoginMapper {
	
	User queryUser(User user);
	
	User queryUserTelephone(String telephone);
}
