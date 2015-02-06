package com.gbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gbs.dao.UserDao;
import com.gbs.entity.GU_USER_INFO;
import com.gbs.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserDao userDao;

	@Override
	public GU_USER_INFO login(String username, String password) {
		return null;
		 
	}
 
}
