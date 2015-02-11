package com.gbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.IndividualInfoDao;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;

public class IndividualInfoDaoImpl extends HibernateDaoSupport  implements IndividualInfoDao {

	
	public void saveIndividualInfo(GU_INDIVIDUAL_INFO individual) {
		getHibernateTemplate().saveOrUpdate(individual);
	}

	public void updateIndividualInfo(GU_INDIVIDUAL_INFO individual) {
		getHibernateTemplate().update(individual);
	}

	public void saveEnterpriseInfo(GU_ENTERPRISE_INFO enterprise) {
		getHibernateTemplate().save(enterprise);
	}

	public void updateEnterpriseInfo(GU_ENTERPRISE_INFO enterprise) {
		getHibernateTemplate().update(enterprise);
	}

	public GU_INDIVIDUAL_INFO getIndividualInfo(String CERT_NO){
		GU_INDIVIDUAL_INFO gu_individual_info = null;
		List<GU_INDIVIDUAL_INFO> list = (List<GU_INDIVIDUAL_INFO>)getHibernateTemplate().find("from GU_INDIVIDUAL_INFO i "
				+ " left join fetch i.individualHouseSet "
				+ " left join fetch i.individualCompanySet"
				+ " left join fetch i.individualLinkmanSet  "
				+ "WHERE i.CERT_NO=?",CERT_NO);
		if(list != null && list.size()>0){
			gu_individual_info = list.get(0);
		}
		return gu_individual_info;
	}

	public List<GU_ENTERPRISE_INFO> getEnterpriseInfo(GU_ENTERPRISE_INFO enterprise) {
		
		   return null;
	}

	@Override
	public GU_INDIVIDUAL_INFO getBaseIndividualInfo(String CERT_NO) {
		GU_INDIVIDUAL_INFO gu_individual_info = null;
		List<GU_INDIVIDUAL_INFO> list = (List<GU_INDIVIDUAL_INFO>) getHibernateTemplate().find(" from GU_INDIVIDUAL_INFO i where i.CERT_NO=?",CERT_NO);
		if(list != null && list.size()>0){
			gu_individual_info = list.get(0);
		}
		return gu_individual_info;
	}

	@Override
	public GU_ENTERPRISE_INFO getEnterprise(String REGISER_NO) {
		GU_ENTERPRISE_INFO gu_enterprise_info = null;
		List<GU_ENTERPRISE_INFO> list = (List<GU_ENTERPRISE_INFO>) getHibernateTemplate().find(" from GU_ENTERPRISE_INFO i left join fetch i.enterpriseSet where i.REGISER_NO=?",REGISER_NO);
		if(list != null && list.size()>0){
			gu_enterprise_info = list.get(0);
		}
		return gu_enterprise_info;
	}

}
