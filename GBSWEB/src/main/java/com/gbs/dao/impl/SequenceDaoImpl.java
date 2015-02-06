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

import com.gbs.dao.SequenceDao;

/**
 * 序列号DAO 实现类
 * @author Chester
 * @param <T>
 *
 */
public class SequenceDaoImpl<T> extends HibernateDaoSupport  implements SequenceDao {

	@Override
	public Long getSeqNoByName(String seqName) {

		long seq = 0;
		final String seqSql = "select "+ seqName + ".Nextval from dual";
		BigDecimal bigSeq = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<BigDecimal>() {

			@Override
			public BigDecimal doInHibernate(Session session)throws HibernateException, SQLException {
				
				SQLQuery sql = session.createSQLQuery(seqSql);
				List list = sql.list();
				BigDecimal num = null;
				if(list != null && list.size()>0){
					num = (BigDecimal)list.get(0);
				}
				return num;
			}
		});
		
		
		if(bigSeq != null ){
			seq = bigSeq.longValue();
		}
		
		return seq;
	}

	@Override
	public String getSeqNoByName(String seqName, int length) {
		Long seq = getSeqNoByName(seqName);
		String num = String.valueOf(seq);
		String seqStr = StringUtils.leftPad(num, length, '0');
		return seqStr;
	} 
	
	
}
