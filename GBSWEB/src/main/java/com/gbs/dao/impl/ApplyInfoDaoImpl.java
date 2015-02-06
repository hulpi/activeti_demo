package com.gbs.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.ApplyInfoDao;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;

/**
 * 申请单操作 DAO 实现类
 * @author wb00002
 * @param <T>
 *
 */
public class ApplyInfoDaoImpl<T> extends HibernateDaoSupport  implements ApplyInfoDao {

	public void addApplyInfo(GU_APPLY_INFO applyInfo) {
		getHibernateTemplate().save(applyInfo);
	}

	public GU_APPLY_INFO queryApplyInfo(String guarant_id) {
		List<GU_APPLY_INFO> list = (List<GU_APPLY_INFO>)getHibernateTemplate().find(" from GU_APPLY_INFO a where a.guarant_id=?",guarant_id);
		GU_APPLY_INFO applyInfo = null;
		if(list!= null && list.size()>0){
			applyInfo = list.get(0);
		}
		return applyInfo;
	}

	public void updateApplyInfo(GU_APPLY_INFO applyInfo) {
		getHibernateTemplate().update(applyInfo);
	}

	@Override
	public GU_APPLY_INFO queryApplyInfoForIndividual(String cert_no) {
		return null;
	}

	@Override
	public GU_APPLY_INFO queryApplyInfoForEnterprise(String enterprise) {
		return null;
	}
	
	public String getGuGuarantIdSeq(){
		String seq = null;
		BigDecimal bigSeq = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<BigDecimal>() {

			@Override
			public BigDecimal doInHibernate(Session session)throws HibernateException, SQLException {
				SQLQuery sql = session.createSQLQuery("select GU_GUARANT_ID_SEQ.Nextval from dual");
				List list = sql.list();
				BigDecimal num = null;
				if(list != null && list.size()>0){
					num = (BigDecimal)list.get(0);
				}
				return num;
			}
		});
		
		if(bigSeq != null ){
			String num = String.valueOf(bigSeq.longValue());
			seq = StringUtils.leftPad(num, 2, '0');
		}
		
		return seq;
	}
	
	public List<GU_APPLY_INFO> queryApplyInfoByProcessInstanceIds(List<String> processInstanceIds) {
		String hql = "from GU_APPLY_INFO a inner join fetch a.individual where a.process_instance_id in (:ids)";
		
		List<GU_APPLY_INFO> resultList = (List<GU_APPLY_INFO>)getHibernateTemplate().findByNamedParam(hql,"ids", processInstanceIds);
	
		return resultList;
	}
	
	public List<GU_APPLY_INFO> queryApplyInfoByUser(String username) {
		List<GU_APPLY_INFO> list = (List<GU_APPLY_INFO>)getHibernateTemplate().find(" from GU_APPLY_INFO a where a.create_user=?",username);
		return list;
	}

	public GU_APPLY_INFO getApplyInfoByGuarantId(String guarantId) {
		GU_APPLY_INFO gu_apply_info = null;
		List<GU_APPLY_INFO> list = (List<GU_APPLY_INFO>)getHibernateTemplate().find("from GU_APPLY_INFO a "
				+ " left join fetch a.city"
				+ " left join fetch a.product "
				+ " left join fetch a.funder"
				+ " left join fetch a.individual"
				+ " left join fetch a.enterprise "
				+ " where a.guarant_id=?",guarantId);
		if(list != null && list.size()>0){
			gu_apply_info = list.get(0);
		}
		return gu_apply_info;
	}

}
