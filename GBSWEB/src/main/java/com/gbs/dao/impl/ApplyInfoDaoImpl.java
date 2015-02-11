package com.gbs.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.dao.ApplyInfoDao;
import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.util.Page;

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
		List<GU_APPLY_INFO> list = (List<GU_APPLY_INFO>)getHibernateTemplate().find(" from GU_APPLY_INFO a where a.create_user=? and a.apply_status='0' order by a.gu_apply_info_oid desc",username);
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
	
	
	public void updateStatus(final String guaranId, final String status) {

		getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session paramSession)
					throws HibernateException, SQLException {
				String hql = "update GU_APPLY_INFO a set a.apply_status = ? where a.guarant_id=?";
				Query query = paramSession.createQuery(hql);
				query.setParameter(0, status);
				query.setParameter(1, guaranId);
				
				query.executeUpdate();
				
				return null;
			}
			
		});
	}
	
	
	public int getApplyInfoCount(APPLY_INFO_DTO dto){
		StringBuilder hql = new StringBuilder(GET_APPLY_INFO_HQL);
		List<Object> params = prepareHqlParams(dto, hql,null);
		List<GU_APPLY_INFO> list  = (List<GU_APPLY_INFO>)getHibernateTemplate().find(hql.toString(),params.toArray());
		return list==null?0:list.size();
	}
	private final String GET_APPLY_INFO_HQL = "from GU_APPLY_INFO a "
				+ " left join fetch a.city c "
				+ " left join fetch a.product p "
				+ " left join fetch a.funder f "
				+ " left join fetch a.individual i "
				+ " left join fetch a.enterprise e where 1=1 ";
	
	public List<GU_APPLY_INFO> getApplyInfoList(final APPLY_INFO_DTO dto,final Page page){
		final StringBuilder hql = new StringBuilder(GET_APPLY_INFO_HQL);
		List applyInfoList = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<GU_APPLY_INFO>>() {
			@Override
			public List<GU_APPLY_INFO> doInHibernate(Session session) throws HibernateException, SQLException {
				prepareHqlParams(dto, hql,null);
				Query query = session.createQuery(hql.toString());
				prepareHqlParams(dto, null,query);
				query.setFirstResult(page.getStart());
				query.setMaxResults(page.getRows());
				
				return query.list();
			}
			
		});
		return applyInfoList;
		
	}

	private List<Object> prepareHqlParams(APPLY_INFO_DTO dto, StringBuilder hql,Query query) {
		List<Object> params = new ArrayList<Object>();
		int index = 0;
		//城市
		if(!StringUtils.isEmpty(dto.getCity_id())){
			if(hql != null && hql.length()>0){
				hql.append("  and c.gu_city_info_oid=? ");
				params.add(Long.valueOf(dto.getCity_id()));
			}else if(query != null){
				query.setLong(index++, Long.valueOf(dto.getCity_id()));
			}
		}
		//贷款产品
		if(!StringUtils.isEmpty(dto.getProductSel())){
			if(hql != null && hql.length()>0){
				hql.append("  and p.gu_product_info_oid=? ");
				params.add(Long.valueOf(dto.getProductSel()));
			}else if(query != null){
				query.setLong(index++, Long.valueOf(dto.getProductSel()));
			}
		}
		//担保编号
		if(!StringUtils.isEmpty(dto.getGuarant_id())){
			if(hql != null && hql.length()>0){
				hql.append("  and a.guarant_id=? ");
				params.add(dto.getGuarant_id());
			}else if(query != null){
				query.setString(index++, dto.getGuarant_id());
			}
		}
		//客户
		if(!StringUtils.isEmpty(dto.getIn_id())){
			if(hql != null && hql.length()>0){
				hql.append("  and i.CERT_NO=? ");
				params.add(dto.getIn_id());
			}else if(query != null){
				query.setString(index++, dto.getIn_id());
			}
		}
		//企业
		if(!StringUtils.isEmpty(dto.getEn_id())){
			if(hql != null && hql.length()>0){
				hql.append("  and e.REGISER_NO=? ");
				params.add(dto.getEn_id());
			}else if(query != null){
				query.setString(index++, dto.getEn_id());
			}
		}
		//申请日期
		if(dto.getFrom_apply_date()!=null){
			if(hql != null && hql.length()>0){
				hql.append("  and a.apply_date>=? ");
				params.add(dto.getFrom_apply_date());
			}else if(query != null){
				query.setDate(index++, dto.getFrom_apply_date());
			}
		}
		if(dto.getTo_apply_date()!=null){
			if(hql != null && hql.length()>0){
				hql.append("  and a.apply_date<=? ");
				params.add(dto.getTo_apply_date());
			}else if(query != null){
				query.setDate(index++, dto.getTo_apply_date());
			}
		}
		//申请人
		if(!StringUtils.isEmpty(dto.getUserId())){
			if(hql != null && hql.length()>0){
				hql.append("  and a.applicant=? ");
				params.add(dto.getUserId());
			}else if(query != null){
				query.setString(index++, dto.getUserId());
			}
		}
		return params;
	}

}
