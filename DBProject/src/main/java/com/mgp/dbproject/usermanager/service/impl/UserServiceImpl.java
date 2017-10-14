package com.mgp.dbproject.usermanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgp.dbproject.usermanager.beans.User;
import com.mgp.dbproject.usermanager.dao.UserMapper;
import com.mgp.dbproject.usermanager.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void removeUser() {
		userMapper.deleteByPrimaryKey(1L);
	}

	@Override
	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public User getUserByLogin(String account, String password) {
		User user = new User();
		user.setUseraccount(account);
		user.setUserpassword(password);
		return userMapper.getUserByLogin(user);
	}

}
