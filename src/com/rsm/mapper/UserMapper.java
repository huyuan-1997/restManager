package com.rsm.mapper;

import org.apache.ibatis.annotations.Param;

import com.rsm.bean.User;

public interface UserMapper {
	//登录时根据用户名和密码查询相关用户
	public User findUser(@Param("username")String username,@Param("password")String password);
	
	//添加用户
	public int addUser(User user);
}
