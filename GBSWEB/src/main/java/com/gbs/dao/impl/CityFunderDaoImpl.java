package com.gbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.CityFunderDao;
import com.gbs.entity.GU_CITY_FUNDER_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;

public class CityFunderDaoImpl extends HibernateDaoSupport implements CityFunderDao {

	public void addCityFunder(GU_CITY_FUNDER_INFO cityFunder) {
		getHibernateTemplate().save(cityFunder);
	}

	public List<GU_PRODUCT_INFO> getProductByCity(String cityId) {
		if(cityId == null){
			return null;
		}
		return (List<GU_PRODUCT_INFO>)getHibernateTemplate().find("select distinct cf.funder.productSet from GU_CITY_FUNDER_INFO cf "
				+ " where cf.city.gu_city_info_oid=?",Long.valueOf(cityId));
	}

	public GU_PRODUCT_INFO getProductByProductcode(String productId) {
		if(productId == null){
			return null;
		}
		List<GU_PRODUCT_INFO> list = (List<GU_PRODUCT_INFO>)getHibernateTemplate().find(" from GU_PRODUCT_INFO where gu_product_info_oid=? ",Long.valueOf(productId));
		GU_PRODUCT_INFO gu_product_info = null;
		if(list != null && list.size()>0){
			gu_product_info = list.get(0);
		}
		
		return gu_product_info;
	}

	public List<GU_PRODUCT_INFO> getAllProduct() {
		return (List<GU_PRODUCT_INFO>)getHibernateTemplate().find("select distinct cf.funder.productSet from GU_CITY_FUNDER_INFO cf ");
	}

}
