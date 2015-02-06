package com.gbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbs.constant.ConfigInfoKey;
import com.gbs.dao.ConfigDao;
import com.gbs.entity.GU_CONFIG_INFO;


/**
 * 配置数据 DAO 实现类
 * @author wb00002
 *
 */
public class ConfigDaoImpl extends HibernateDaoSupport  implements ConfigDao {

	
	public List<GU_CONFIG_INFO> getConfigInfo(String infoKey) {
		getHibernateTemplate().setCacheQueries(true);
		return (List<GU_CONFIG_INFO>)getHibernateTemplate().find("from GU_CONFIG_INFO where info_key =?",infoKey);
	}

}
