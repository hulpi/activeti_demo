package com.gbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.CityDao;
import com.gbs.entity.GU_CITY_INFO;
/**
 * 城市公司 DAO 实现类
 * @author wb00002
 *
 */
public class CityDaoImpl extends HibernateDaoSupport  implements CityDao {

	public void addCity(GU_CITY_INFO city) {
		getHibernateTemplate().save(city);
	}

	public List<GU_CITY_INFO> queryCity() {
		getHibernateTemplate().setCacheQueries(true);
		return (List<GU_CITY_INFO>)getHibernateTemplate().find("select distinct c from GU_CITY_INFO c");
	}
	public void updateCity(GU_CITY_INFO city) {
		getHibernateTemplate().update(city);
	}

	public void deleteCity(GU_CITY_INFO city) {
		getHibernateTemplate().delete(city);
		
	}

	public void updateCity(List<GU_CITY_INFO> cityList) {
		for(GU_CITY_INFO city : cityList){
			getHibernateTemplate().update(city);
		}
	}

	@Override
	public GU_CITY_INFO queryCity(String cityCode) {
		getHibernateTemplate().setCacheQueries(true);
		List<GU_CITY_INFO> list = (List<GU_CITY_INFO>)getHibernateTemplate().find("select distinct c from GU_CITY_INFO c where c.city_code=? ",cityCode);
		GU_CITY_INFO gu_city_info = null;
		if(list != null && list.size()>0){
			gu_city_info = list.get(0);
		}
		return gu_city_info;
	}

	public GU_CITY_INFO queryCity(Long cityOid) {
		getHibernateTemplate().setCacheQueries(true);
		List<GU_CITY_INFO> list = (List<GU_CITY_INFO>)getHibernateTemplate().find("select distinct c from GU_CITY_INFO c where c.gu_city_info_oid=? ",cityOid);
		GU_CITY_INFO gu_city_info = null;
		if(list != null && list.size()>0){
			gu_city_info = list.get(0);
		}
		return gu_city_info;
	}

}
