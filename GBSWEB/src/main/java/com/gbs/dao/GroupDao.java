/**
 * 
 */
package com.gbs.dao;

//import org.springframework.data.repository.CrudRepository;

import com.gbs.entity.GroupInfo;

/**
 * @author wb00003
 *
 */
public interface GroupDao {
	
	public GroupInfo findByName(String name);
	
}
