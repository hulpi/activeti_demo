package com.gbs.dao;


//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;

import com.gbs.entity.UserInfo;



public interface UserDao {
	
	//@EntityGraph(value = "UserInfo.groups", type = EntityGraphType.FETCH)
	public UserInfo findByUserId(String userId);
}
