package com.gbs.dao;

import java.util.List;

import com.gbs.entity.GU_CITY_FUNDER_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
/**
 * 分行 与 产品映射关联 操作DAO
 * @author wb00002
 *
 */
public interface CityFunderDao {
	public void addCityFunder(GU_CITY_FUNDER_INFO cityFunder);

	public List<GU_PRODUCT_INFO> getProductByCity(String cityId);

	public GU_PRODUCT_INFO getProductByProductcode(String productId);
	
	public List<GU_PRODUCT_INFO> getAllProduct();
}
