package com.gbs.service;

import java.util.List;

import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.CompanyInfoModel;
import com.gbs.dto.EnterPraiseDTO;
import com.gbs.dto.EnterpraiseBusinessModel;
import com.gbs.dto.HostInfoModel;
import com.gbs.dto.INDIVIDUAL_INFO_DTO;
import com.gbs.dto.LinkManInfoModel;
import com.gbs.dto.UserInfoDto;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;

public interface IndividualInfoService {
		/**
		 * 保存个人申请资料
		 * @param individual
		 */
	    public void saveIndividualInfo(INDIVIDUAL_INFO_DTO individualDto,HostInfoModel hostInfoModel,CompanyInfoModel companyInfoModel,LinkManInfoModel linkManInfoModel,APPLY_INFO_DTO applyInfo,UserInfoDto userDto) throws Exception ;
	    
	    
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
	    public INDIVIDUAL_INFO_DTO getIndividualInfo(String CERT_NO);
	    
	    /**
	     * 查询企业
	     * @param REGISER_NO
	     * @return
	     */
	    public EnterPraiseDTO getEnterprise(String REGISER_NO);
	    
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
	    
	    public void saveEnterprise(EnterPraiseDTO enterPraiseDTO,EnterpraiseBusinessModel enterpraiseBusinessModel,APPLY_INFO_DTO applyInfo,UserInfoDto userDto)throws Exception;

        /**
         * 修改个人资料
         * @param individualDto
         * @param hostInfoModel
         * @param companyInfoModel
         * @param linkManInfoModel
         * @param userDto
         */
	    public void updateIndividualInfo(INDIVIDUAL_INFO_DTO individualDto,HostInfoModel hostInfoModel, CompanyInfoModel companyInfoModel,LinkManInfoModel linkManInfoModel,UserInfoDto userDto);

        /**
         * 修改企业资料
         * @param enterPraiseDTO
         * @param enterpraiseBusinessModel
         * @param userDto
         */
		public void updateEnterprise(EnterPraiseDTO enterPraiseDTO,EnterpraiseBusinessModel enterpraiseBusinessModel,UserInfoDto userDto);
	
	
}
