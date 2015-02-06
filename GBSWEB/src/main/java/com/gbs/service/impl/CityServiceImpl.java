package com.gbs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbs.dao.CityDao;
import com.gbs.dto.CITY_INFO_DTO;
import com.gbs.dto.PRODUCT_INFO_DTO;
import com.gbs.entity.GU_BRANCH_INFO;
import com.gbs.entity.GU_CITY_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
import com.gbs.service.CityService;
/**
 * 城市公司服务层实现类
 * @author wb00002
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired      
	private CityDao cityDao;
	
	public void addCity(GU_CITY_INFO city) {
		cityDao.addCity(city);
	}

	public List<GU_CITY_INFO> queryCity() {
		return cityDao.queryCity();
	}
	
	public List<CITY_INFO_DTO> getCity(){
		List<CITY_INFO_DTO> resList = new ArrayList<CITY_INFO_DTO>();
		List<GU_CITY_INFO> list = cityDao.queryCity();
		if(list != null && list.size()>0){
			for(GU_CITY_INFO city : list){
				CITY_INFO_DTO cityDto = new CITY_INFO_DTO();
				cityDto.setGu_city_info_oid(city.getGu_city_info_oid());
				cityDto.setCity_code(city.getCity_code());
				cityDto.setCity_name(city.getCity_name());
				resList.add(cityDto);
			}
		}
		return resList;
	}
	
	
	@Transactional(rollbackFor=Exception.class)  
	public void updateCity(GU_CITY_INFO city) throws Exception {
		cityDao.updateCity(city);
		throw new Exception("修改城市 发生异常");
	}

	public void updateCity(List<GU_CITY_INFO> cityList) {
		cityDao.updateCity(cityList);
	}

	public void deleteCity(GU_CITY_INFO city) {
		cityDao.deleteCity(city);
	}
	

	public GU_CITY_INFO queryCityByCode(String cityCode){
		return cityDao.queryCity(cityCode);
	}
	public GU_CITY_INFO queryCityByOid(Long cityOid){
		return cityDao.queryCity(cityOid);
	}
	public void initData(){
		Date create_date = new Date();
		GU_CITY_INFO city = new GU_CITY_INFO();
		city.setAddress("广州市天河区天河北路689号201房");
		city.setCity_code("GZ");
		city.setCity_name("亚洲第一信息咨询（深圳）有限公司广州分公司");
		city.setCreate_date(create_date);
		city.setCreate_user("admin");
		city.setFax("024-31061789");
		city.setTel("024-31288213");
		GU_BRANCH_INFO branch = new GU_BRANCH_INFO();
		branch.setAddress("sz luhuo");
		branch.setBranch_code("SZ01");
		branch.setBranch_level("1");
		branch.setBranch_name("深圳新鸿基担保有限公司 罗湖分行");
		branch.setCreate_date(create_date);
		branch.setCreate_user("admin");
		branch.setFax("0755-56956666");
		branch.setTel("0755-22562582");
		
		GU_BRANCH_INFO branch2 = new GU_BRANCH_INFO();
		branch2.setAddress("sz");
		branch2.setBranch_code("SZ02");
		branch2.setBranch_level("2");
		branch2.setBranch_name("深圳新鸿基担保有限公司 南山分行 2");
		branch2.setCreate_date(create_date);
		branch2.setCreate_user("admin");
		branch2.setFax("0755-56956666");
		branch2.setTel("0755-22562582");
		Set<GU_BRANCH_INFO> branchSet = new HashSet<GU_BRANCH_INFO>();
		branchSet.add(branch);
		branchSet.add(branch2);
		
		city.setBranchSet(branchSet);
		cityDao.addCity(city);
	}

}
