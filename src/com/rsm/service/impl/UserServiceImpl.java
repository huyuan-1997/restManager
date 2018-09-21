package com.rsm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsm.bean.User;
import com.rsm.mapper.UserMapper;
import com.rsm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(String username, String password) {
		
		return userMapper.findUser(username, password);
	}

	@Override
	public int addUser(User user) {
		
		return userMapper.addUser(user);
	}

}
