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
	
	public String getProductTypeDes(String productType){
		String productTypeDes = "";
		List<GU_CONFIG_INFO> ptList = getProductType();
		if(ptList != null && ptList.size()>0){
			for(GU_CONFIG_INFO gu_config_info : ptList){
				if(productType.equals(gu_config_info.getInfo_code())){
					productTypeDes = gu_config_info.getInfo_name();
				}
			}
		}
		return productTypeDes;
	}
	
	public String getLoanPurposeDes(String loanPurpose){
		String loanPurposeDes = "";
		List<GU_CONFIG_INFO> lpList = getLoanPurpose();
		if(lpList != null && lpList.size()>0){
			for(GU_CONFIG_INFO gu_config_info : lpList){
				if(loanPurpose.equals(gu_config_info.getInfo_code())){
					loanPurposeDes = gu_config_info.getInfo_name();
				}
			}
		}
		return loanPurposeDes;
	}

}
