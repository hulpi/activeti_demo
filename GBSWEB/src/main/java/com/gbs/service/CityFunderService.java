package com.gbs.service;


import java.util.List;

import com.gbs.dto.PRODUCT_INFO_DTO;
import com.gbs.entity.GU_CITY_FUNDER_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
/**
 * 分行与产品服务层
 * @author wb00002
 *
 */
public interface CityFunderService {
	public void addCityFunder(GU_CITY_FUNDER_INFO cityFunder);
	
	public List<PRODUCT_INFO_DTO> getProductByCity(String cityId);
	
	
	public GU_PRODUCT_INFO getProductByProductcode(String productId);
	
	public List<PRODUCT_INFO_DTO> getAllProduct();
}
