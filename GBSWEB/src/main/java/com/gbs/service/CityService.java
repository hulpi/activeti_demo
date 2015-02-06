package com.gbs.service;

import java.util.List;





import com.gbs.dto.CITY_INFO_DTO;
import com.gbs.entity.GU_CITY_INFO;

/**
 * 城市公司服务层
 * @author wb00002
 *
 */
public interface CityService {

	/**
	 * 新增城市公司
	 * @param city
	 */
	public void addCity(GU_CITY_INFO city);
	public List<CITY_INFO_DTO> getCity();
	/**
	 * 查询城市公司
	 * @return
	 */
	public List<GU_CITY_INFO> queryCity();
	
	/**
	 * 更新城市公司 
	 * @param city
	 */
	public void updateCity(GU_CITY_INFO city)throws Exception;
	
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
	public GU_CITY_INFO queryCityByCode(String cityCode);
	
	public GU_CITY_INFO queryCityByOid(Long cityOid);
	
	/**
	 * 数据初始化，只运行一次
	 */
	public void initData();
}
