/**
 * 
 */
package com.gbs.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import com.gbs.dao.UserDao;
import com.gbs.entity.GroupInfo;
import com.gbs.entity.UserInfo;

/**
 * @author HuangLiPing
 *
 */
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		logger.debug("userName = " + userName);
		Assert.hasText(userName, "The userName must not be null, empty, or blank!");
		UserDetails user = null;
		
		UserInfo userInfo = userDao.findByUserId(userName);
		if(userInfo != null) {
			Set<GroupInfo> groups = userInfo.getGroups();
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			
			if(groups != null) {
				for(GroupInfo groupInfo : groups) {
					authList.addAll(getAuthorities(groupInfo.getName()));
				}
			}
			
			user = new User(userInfo.getUserId(), userInfo.getPwd().toLowerCase(), true, true, true, true, authList);
		}
		
		return user;
	}
	
	private Collection<GrantedAuthority> getAuthorities(String groupId) {
		logger.debug("groupId = "+groupId);
		
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();  
        authList.add(new SimpleGrantedAuthority("ROLE_"+groupId.toUpperCase()));  
        
        return authList;  
    }  

}
