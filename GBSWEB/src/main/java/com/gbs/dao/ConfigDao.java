package com.gbs.dao;

import java.util.List;

import com.gbs.entity.GU_CONFIG_INFO;

/**
 * 贷款用途 DAO
 * @author wb00002
 *
 */
public interface ConfigDao {

	
	public List<GU_CONFIG_INFO> getConfigInfo(String infoKey);
	
	
}
