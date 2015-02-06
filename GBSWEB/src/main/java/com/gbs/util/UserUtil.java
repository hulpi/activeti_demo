package com.gbs.util;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.gbs.dto.UserInfoDto;

/**
 * 用户工具类
 *
 * @author HuangLiPing
 */
public class UserUtil {

    public static final String USER = "user";

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, UserInfoDto user) {
        session.setAttribute(USER, user);
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static UserInfoDto getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        if(attribute != null) {
        	 return (UserInfoDto) attribute;
        	 
        } else {
        	UserInfoDto userInfoDto = new UserInfoDto ();
        	
        	UserDetails userDetail = currentUserDetails();
        	if(userDetail != null) {
        	    userInfoDto.setUserid(userDetail.getUsername());
        	}
        	session.setAttribute(USER, userInfoDto);
        	
        	return userInfoDto;
        }
    }
    
    public static UserDetails currentUserDetails() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof UserDetails) {
            	return (UserDetails)principal;
            }
        }
        
        return null;
    }

}
