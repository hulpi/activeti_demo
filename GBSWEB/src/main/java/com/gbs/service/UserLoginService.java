package com.gbs.service;

import com.gbs.entity.GU_USER_INFO;
 
public interface UserLoginService {
	
	public GU_USER_INFO login(String username, String password);

}
