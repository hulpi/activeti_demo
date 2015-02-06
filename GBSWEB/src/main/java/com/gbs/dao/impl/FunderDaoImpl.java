package com.gbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.FunderDao;
import com.gbs.entity.GU_FUNDER_INFO;

/**
 * 合作方 DAO 实现类
 * @author wb00002
 *
 */
public class FunderDaoImpl extends HibernateDaoSupport implements FunderDao {

	public void addFunder(GU_FUNDER_INFO funder) {
		getHibernateTemplate().save(funder);
	}

	public List<GU_FUNDER_INFO> queryFunder() {
		getHibernateTemplate().setCacheQueries(true);
		return (List<GU_FUNDER_INFO>)getHibernateTemplate().find(" select distinct f from GU_FUNDER_INFO f left join fetch f.productSet");
	}

	public void updateFunder(GU_FUNDER_INFO funder) {
		getHibernateTemplate().update(funder);
	}

	public void updateFunder(List<GU_FUNDER_INFO> funderList) {
	
		for(GU_FUNDER_INFO funder : funderList){
			getHibernateTemplate().update(funder);
		}
	}
	public void deleteFunder(GU_FUNDER_INFO funder) {
		getHibernateTemplate().delete(funder);
	}


}
