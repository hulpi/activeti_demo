package com.gbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.constant.ConfigInfoKey;
import com.gbs.dao.ConfigDao;
import com.gbs.entity.GU_CONFIG_INFO;
import com.gbs.service.ConfigService;
/**
 * 配制数据字典 实现类
 * @author wb00002
 *
 */
@Service
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigDao configDao;
	
	/**
	 * 贷款用途
	 */
	public List<GU_CONFIG_INFO> getLoanPurpose() {
		return configDao.getConfigInfo(ConfigInfoKey.LOAN_PURPOSE);
	}

	/**
	 * 产品类型
	 * @return
	 */
	public List<GU_CONFIG_INFO> getProductType() {
		return configDao.getConfigInfo(ConfigInfoKey.PRODUCT_TYPE);
	}

}
