package com.gbs.service;

import java.util.List;

import com.gbs.entity.GU_CONFIG_INFO;

/**
 * 贷款用途 服务类
 * @author wb00002
 *
 */
public interface ConfigService {
	
	
	public List<GU_CONFIG_INFO> getLoanPurpose();
	
	public List<GU_CONFIG_INFO> getProductType();

}
