package com.gbs.dao;

import java.util.List;
import java.util.Set;

import com.gbs.dto.EnterPraiseDTO;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;
/**
 * 
 * @author fa00016
 *
 */
public interface IndividualInfoDao {
	
	/**
	 * 保存个人申请资料
	 * @param individual
	 */
    public void saveIndividualInfo(GU_INDIVIDUAL_INFO individual);
    
    
    /**
	 * 修改 个人申请资料
	 * @param individual
	 */
    public void updateIndividualInfo(GU_INDIVIDUAL_INFO individual);
    
    
	/**
	 * 保存企业申请资料
	 * @param enterprise
	 */
    public void saveEnterpriseInfo(GU_ENTERPRISE_INFO enterprise);
    
    
    /**
	 * 修改 企业申请资料
	 * @param enterprise
	 */
    public void updateEnterpriseInfo(GU_ENTERPRISE_INFO enterprise);
    
    /**
     * 查询个人资料信息
     * @param individual
     * @return
     */
    public GU_INDIVIDUAL_INFO getIndividualInfo(String CERT_NO);
    
    /**
     * 得到基本信息
     * @param CERT_NO
     * @return
     */
    public GU_INDIVIDUAL_INFO getBaseIndividualInfo(String CERT_NO);
    
    
    /**
     * 查询企业资料
     * @param enterprise
     * @return
     */
    public List<GU_ENTERPRISE_INFO> getEnterpriseInfo(GU_ENTERPRISE_INFO enterprise);
    
    /**
     * 查询企业 
     * @param REGISER_NO
     * @return
     */
    public GU_ENTERPRISE_INFO getEnterprise(String REGISER_NO);
    
    
    
    
}
