package com.gbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.UserDao;
import com.gbs.entity.UserInfo;



public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public UserInfo findByUserId(String userId) {
        String hql = "from UserInfo a inner join fetch a.groups where a.userId = ?";
		
		List<UserInfo> resultList = (List<UserInfo>)getHibernateTemplate().find(hql, userId);
	
		if(resultList != null && resultList.size()>0) {
			return resultList.get(0);
		}
		
		return null;
	}

}
