package com.gbs.dao;

import java.util.List;

import com.gbs.entity.GU_CITY_INFO;
/**
 * 城市公司操作DAO
 * @author wb00002
 *
 */
public interface CityDao {
	
	/**
	 * 新增城市公司
	 * @param city
	 */
	public void addCity(GU_CITY_INFO city);
	
	/**
	 * 查询城市公司
	 * @return
	 */
	public List<GU_CITY_INFO> queryCity();
	
	/**
	 * 更新城市公司 
	 * @param city
	 */
	public void updateCity(GU_CITY_INFO city);
	
	/**
	 * 批量更新城市公司
	 * @param cityList
	 */
	public void updateCity(List<GU_CITY_INFO> cityList);
	
	/**
	 * 删除城市公司 
	 * @param city
	 */
	public void deleteCity(GU_CITY_INFO city);
	
	/**
	 * 查询城市 
	 * @param cityCode
	 * @return
	 */
	public GU_CITY_INFO queryCity(String cityCode);
	
	public GU_CITY_INFO queryCity(Long cityOid);
	

}
