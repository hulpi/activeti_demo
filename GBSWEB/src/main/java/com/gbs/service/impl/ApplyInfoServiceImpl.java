package com.gbs.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbs.constant.ApplyStatus;
import com.gbs.dao.ApplyInfoDao;
import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.INDIVIDUAL_INFO_DTO;
import com.gbs.dto.UserInfoDto;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.entity.GU_CITY_INFO;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_FUNDER_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
import com.gbs.service.ApplyInfoService;
import com.gbs.service.ApprovalService;
import com.gbs.service.CityFunderService;
import com.gbs.service.CityService;
import com.gbs.service.IndividualInfoService;
/**
 * 申请单操作 服务层实现类
 * @author wb00002
 *
 */
@Service
public class ApplyInfoServiceImpl implements ApplyInfoService {

	@Autowired
	private ApplyInfoDao applyInfoDao;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CityFunderService cityFunderService;
	@Autowired
	private ApprovalService approvalService;
	
	@Autowired
	private IndividualInfoService individualInfoService;
	
	@Transactional(rollbackFor=Exception.class)
	public void addIndividualApplyInfo(APPLY_INFO_DTO dto,GU_INDIVIDUAL_INFO individual,UserInfoDto userDto)throws Exception{
		// 检查个人或企业 是否已经申请过担保，不能重复申请
		GU_APPLY_INFO applyInfoDb = null;
		applyInfoDb = applyInfoDao.queryApplyInfoForIndividual(dto.getIn_id());

		if (applyInfoDb != null) {
			throw new Exception("还有未完成的担保，不能申请新的担保!");
		}
		
		addApplyInfo(dto, individual, null,userDto);
	}
	@Transactional(rollbackFor=Exception.class)
	public void addEnterpriseApplyInfo(APPLY_INFO_DTO dto,	GU_ENTERPRISE_INFO enterprise,UserInfoDto userDto)throws Exception {
		
		// 检查个人或企业 是否已经申请过担保，不能重复申请
		GU_APPLY_INFO applyInfoDb = applyInfoDao.queryApplyInfoForEnterprise(dto.getEn_id());

		if (applyInfoDb != null) {
			throw new Exception("还有未完成的担保，不能申请新的担保!");
		}

		addApplyInfo(dto, null, enterprise,userDto);
		
	}
	
	public void addApplyInfo(APPLY_INFO_DTO dto,GU_INDIVIDUAL_INFO individual,GU_ENTERPRISE_INFO enterprise,UserInfoDto userDto ) throws Exception {
		GU_APPLY_INFO applyInfo = new GU_APPLY_INFO();
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		//城市 + 担保类型 + 日期 + 序列号
		StringBuilder guarant_id = new StringBuilder();
		GU_CITY_INFO city = cityService.queryCityByOid(Long.valueOf(dto.getCity_id()));
		if(city != null){
			guarant_id.append(city.getCity_code());
		}
		guarant_id.append(dto.getProduct_type());
		guarant_id.append(df.format(now));
		guarant_id.append(applyInfoDao.getGuGuarantIdSeq());
		
		applyInfo.setGuarant_id(guarant_id.toString());
		applyInfo.setIndividual(individual);
		applyInfo.setEnterprise(enterprise);
		if(!StringUtils.isEmpty(dto.getGuarant_amt())){
			BigDecimal guarantAmt = new BigDecimal(dto.getGuarant_amt());
			applyInfo.setGuarant_amt(guarantAmt);	
		}
		
		if(!StringUtils.isEmpty(dto.getCity_id() )){
			applyInfo.setCity(city);
		}
		// 贷款产品
		if(!StringUtils.isEmpty(dto.getProductSel())){
			GU_PRODUCT_INFO product = new GU_PRODUCT_INFO();
			product.setGu_product_info_oid(Long.valueOf(dto.getProductSel()));
			applyInfo.setProduct(product);
		}
		if(!StringUtils.isEmpty(dto.getFunder_id())){
			GU_FUNDER_INFO funder = new GU_FUNDER_INFO();
			funder.setGu_funder_info_oid(Long.valueOf(dto.getFunder_id()));
			applyInfo.setFunder(funder);
		}
		applyInfo.setGuarant_type(dto.getProduct_type());
		if(!StringUtils.isEmpty(dto.getGuarant_time_limit())){
			Long gl = Long.valueOf(dto.getGuarant_time_limit());
			applyInfo.setGuarant_time_limit(gl);
		}
		applyInfo.setLoan_purpose(dto.getLoan_purpose());
		applyInfo.setApply_status(ApplyStatus.APPLICATIONS);
		
		
		String userId = userDto.getUserid();
		
		applyInfo.setApplicant(userId);
		applyInfo.setApply_date(now);
		applyInfo.setCreate_date(now);
		applyInfo.setCreate_user(userId);
		
		//工作流引擎
		String process_instance_id = callWorkFlow(userId, applyInfo.getGuarant_id());
		applyInfo.setProcess_instance_id(process_instance_id); 
		
		applyInfoDao.addApplyInfo(applyInfo);
	}
	
	public String callWorkFlow(String userId,String businessKey) throws Exception{
		return approvalService.startApprovalProcess(userId, businessKey);
	}
	



	@Override
	public List<GU_APPLY_INFO> queryApplyInfoByUser(String username) {
		
		return applyInfoDao.queryApplyInfoByUser(username);
	}

	@Override
	public INDIVIDUAL_INFO_DTO getIndival(String guarant_id) {
		GU_APPLY_INFO queryApplyInfo = applyInfoDao.queryApplyInfo(guarant_id);
		GU_INDIVIDUAL_INFO individual = queryApplyInfo.getIndividual();
		if(individual.getCERT_NO()!=null){
		    INDIVIDUAL_INFO_DTO individualInfo = individualInfoService.getIndividualInfo(individual.getCERT_NO());
	        return individualInfo;
	  }
		return null;
	}

	@Override
	public APPLY_INFO_DTO getApplyInfoByGuarantId(String guarantId) {
		GU_APPLY_INFO applyInfo = applyInfoDao.getApplyInfoByGuarantId(guarantId);
		APPLY_INFO_DTO applyInfoDto = new APPLY_INFO_DTO();
		if(applyInfo != null){
			applyInfoDto.setGuarant_id(applyInfo.getGuarant_id());
			applyInfoDto.setGuarant_amt(String.valueOf(applyInfo.getGuarant_amt()));
			if(applyInfo.getCity() != null){
				applyInfoDto.setCity_id(String.valueOf(applyInfo.getCity().getGu_city_info_oid()));
			}
			
			if(applyInfo.getFunder()!=null){
				applyInfoDto.setFunder_id(String.valueOf(applyInfo.getFunder().getGu_funder_info_oid()));
			}
			
			if(applyInfo.getProduct()!=null){
				applyInfoDto.setProductSel(String.valueOf(applyInfo.getProduct().getGu_product_info_oid()));
			}
			applyInfoDto.setProduct_type(applyInfo.getGuarant_type());
			
			applyInfoDto.setGuarant_time_limit(String.valueOf(applyInfo.getGuarant_time_limit()));
			applyInfoDto.setLoan_purpose(applyInfo.getLoan_purpose());
			
			if(applyInfo.getIndividual()!=null){
				applyInfoDto.setIn_id(applyInfo.getIndividual().getCERT_NO());
			}
			
			if(applyInfo.getEnterprise()!=null){
				applyInfoDto.setEn_id(applyInfo.getEnterprise().getREGISER_NO());
			}
			
		}
		return applyInfoDto;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void updateApplyInfo(APPLY_INFO_DTO applyInfoDto){
		GU_APPLY_INFO applyInfo = applyInfoDao.getApplyInfoByGuarantId(applyInfoDto.getGuarant_id());
		Date now = new Date();
		
		if(applyInfoDto.getCity_id() != null){
			GU_CITY_INFO city = new GU_CITY_INFO();
			city.setGu_city_info_oid(Long.valueOf(applyInfoDto.getCity_id()));
			applyInfo.setCity(city);
		}
		
		if(applyInfoDto.getFunder_id() != null){
			GU_FUNDER_INFO funder = new GU_FUNDER_INFO();
			funder.setGu_funder_info_oid(Long.valueOf(applyInfoDto.getFunder_id()));
			applyInfo.setFunder(funder);
		}
		
		applyInfo.setLoan_purpose(applyInfoDto.getLoan_purpose());
		if(applyInfoDto.getGuarant_amt()!=null){
			applyInfo.setGuarant_amt(new BigDecimal(applyInfoDto.getGuarant_amt()));
		}
		if(applyInfoDto.getGuarant_time_limit() != null){
			applyInfo.setGuarant_time_limit(Long.valueOf(applyInfoDto.getGuarant_time_limit()));
		}
		
		if(applyInfoDto.getProductSel() != null){
			GU_PRODUCT_INFO product = new GU_PRODUCT_INFO();
			product.setGu_product_info_oid(Long.valueOf(applyInfoDto.getProductSel()));
			applyInfo.setProduct(product);
		}
		applyInfo.setGuarant_type(applyInfoDto.getProduct_type());
		
		applyInfo.setUpdate_date(now);
		applyInfo.setUpdate_user(applyInfoDto.getUserId());
		
		applyInfoDao.updateApplyInfo(applyInfo);
		
	}
}
