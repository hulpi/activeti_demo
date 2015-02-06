package com.gbs.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbs.dao.FunderDao;
import com.gbs.dto.FUNDER_INFO_DTO;
import com.gbs.dto.FUNDER_INFO_DTO;
import com.gbs.entity.GU_CITY_INFO;
import com.gbs.entity.GU_FUNDER_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
import com.gbs.service.FunderService;
/**
 * 合作方服务层实现类
 * @author wb00002
 *
 */
@Service
public class FunderServiceImpl implements FunderService {

	@Autowired
	private FunderDao funderDao; 
	
	
	public void addFunder(GU_FUNDER_INFO funder) {
		funderDao.addFunder(funder);
	}

	public List<GU_FUNDER_INFO> queryFunder() {
		return funderDao.queryFunder();
	}

	public List<FUNDER_INFO_DTO> getFunder() {
		List<FUNDER_INFO_DTO> resList = new ArrayList<FUNDER_INFO_DTO>();
		List<GU_FUNDER_INFO> list = funderDao.queryFunder();
		if(list != null && list.size()>0){
			for(GU_FUNDER_INFO funder : list){
				FUNDER_INFO_DTO funderDto = new FUNDER_INFO_DTO();
				funderDto.setGu_funder_info_oid(funder.getGu_funder_info_oid());
				funderDto.setFunder_code(funder.getFunder_code());
				funderDto.setFunder_desc(funder.getFunder_desc());
				resList.add(funderDto);
			}
		}
		return resList;
	}

	public void updateFunder(GU_FUNDER_INFO funder) {
		funderDao.updateFunder(funder);
	}

	public void updateFunder(List<GU_FUNDER_INFO> funderList) throws Exception{
		funderDao.updateFunder(funderList);
	}

	public void deleteFunder(GU_FUNDER_INFO funder) {
		funderDao.deleteFunder(funder);
	}

	public void initData() {
		GU_FUNDER_INFO funder = new GU_FUNDER_INFO();
		funder.setFunder_code("01");
		funder.setFunder_desc("搜易贷");
		
		Set<GU_PRODUCT_INFO> productSet = new HashSet<GU_PRODUCT_INFO>();
		GU_PRODUCT_INFO product = new GU_PRODUCT_INFO();
		product.setProduct_code("0101");
		product.setProduct_desc("担保贷");
		product.setProduct_type("EN");
		productSet.add(product);
		
		GU_PRODUCT_INFO product2 = new GU_PRODUCT_INFO();
		product2.setProduct_code("0102");
		product2.setProduct_desc("生意贷");
		product2.setProduct_type("PE");
		productSet.add(product2);
		funder.setProductSet(productSet);
		
		addFunder(funder);
		
	}


}
