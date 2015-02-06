package com.gbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.dao.CityFunderDao;
import com.gbs.dto.PRODUCT_INFO_DTO;
import com.gbs.entity.GU_CITY_FUNDER_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
import com.gbs.service.CityFunderService;
@Service
public class CityFunderServiceImpl implements CityFunderService {
	@Autowired
	private CityFunderDao cityFunderDao;
	public void addCityFunder(GU_CITY_FUNDER_INFO cityFunder) {
		cityFunderDao.addCityFunder(cityFunder);
	}

	public List<PRODUCT_INFO_DTO> getProductByCity(String cityId) {
		List<PRODUCT_INFO_DTO> resList = new ArrayList<PRODUCT_INFO_DTO>();
		List<GU_PRODUCT_INFO> list = cityFunderDao.getProductByCity(cityId);
		if(list != null && list.size()>0){
			for(GU_PRODUCT_INFO product : list){
				PRODUCT_INFO_DTO productDto = new PRODUCT_INFO_DTO();
				productDto.setGu_product_info_oid(product.getGu_product_info_oid());
				productDto.setProduct_code(product.getProduct_code());
				productDto.setProduct_desc(product.getProduct_desc());
				productDto.setProduct_type(product.getProduct_type());
				resList.add(productDto);
			}
		}
		return resList;
	}
	public List<PRODUCT_INFO_DTO> getAllProduct(){
		List<PRODUCT_INFO_DTO> resList = new ArrayList<PRODUCT_INFO_DTO>();
		List<GU_PRODUCT_INFO> list = cityFunderDao.getAllProduct();
		if(list != null && list.size()>0){
			for(GU_PRODUCT_INFO product : list){
				PRODUCT_INFO_DTO productDto = new PRODUCT_INFO_DTO();
				productDto.setGu_product_info_oid(product.getGu_product_info_oid());
				productDto.setProduct_code(product.getProduct_code());
				productDto.setProduct_desc(product.getProduct_desc());
				productDto.setProduct_type(product.getProduct_type());
				resList.add(productDto);
			}
		}
		return resList;
	}
	

	public GU_PRODUCT_INFO getProductByProductcode(String productId) {
		return cityFunderDao.getProductByProductcode(productId);
	}

}
