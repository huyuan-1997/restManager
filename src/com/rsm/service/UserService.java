package com.rsm.service;


import com.rsm.bean.User;

public interface UserService {
	//登录时根据用户名和密码查询相关用户
	public User findUser(String username,String password);
	//添加用户
	public int addUser(User user);
}
