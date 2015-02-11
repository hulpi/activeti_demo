package com.gbs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbs.dao.IndividualInfoDao;
import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.CompanyInfoModel;
import com.gbs.dto.ENTERPRISE_BUSINESS_DTO;
import com.gbs.dto.EnterPraiseDTO;
import com.gbs.dto.EnterpraiseBusinessModel;
import com.gbs.dto.HostInfoModel;
import com.gbs.dto.INDIVIDUAL_COMPANY_DTO;
import com.gbs.dto.INDIVIDUAL_HOUSE_DTO;
import com.gbs.dto.INDIVIDUAL_INFO_DTO;
import com.gbs.dto.INDIVIDUAL_LINKMAN_DTO;
import com.gbs.dto.LinkManInfoModel;
import com.gbs.dto.UserInfoDto;
import com.gbs.entity.GU_ENTERPRISE_BUSINESS;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_INDIVIDUAL_COMPANY;
import com.gbs.entity.GU_INDIVIDUAL_HOUSE;
import com.gbs.entity.GU_INDIVIDUAL_INFO;
import com.gbs.entity.GU_INDIVIDUAL_LINKMAN;
import com.gbs.service.ApplyInfoService;
import com.gbs.service.IndividualInfoService;
@Service
public class IndividualInfoServiceImpl implements IndividualInfoService {
	
	@Autowired
    private IndividualInfoDao individualInfoDao;
	
	@Autowired
	private ApplyInfoService applyInfoService;
	
	@Transactional(rollbackFor=Exception.class)
	public void saveIndividualInfo(INDIVIDUAL_INFO_DTO individualDto,HostInfoModel hostInfoModel,
			CompanyInfoModel companyInfoModel,
			LinkManInfoModel linkManInfoModel,APPLY_INFO_DTO applyInfo,UserInfoDto userDto )  throws Exception {
		
		//检查是否已经存在相同的记录
		Date now = new Date();
		String userId = null;
		if(userDto != null){
			userId = userDto.getUserid();
		}
		GU_INDIVIDUAL_INFO individual_info_db = individualInfoDao.getIndividualInfo(individualDto.getCERT_NO());
		GU_INDIVIDUAL_INFO individual = null;
		if(individual_info_db !=null){
			individual = individual_info_db;
		}else{
			individual = new GU_INDIVIDUAL_INFO();
			BeanUtils.copyProperties(individualDto, individual);
			individual.setOPER_DATE(now);
			individual.setOPER_ID(userId);
		}
		
		
		if(individual_info_db == null){
			//房产
			if(hostInfoModel != null && hostInfoModel.getHostInfo()!= null && hostInfoModel.getHostInfo().size()>0){
				Set<GU_INDIVIDUAL_HOUSE> individualHouseSet = new HashSet<GU_INDIVIDUAL_HOUSE>();
				
				individual.setIndividualHouseSet(individualHouseSet);
				
				List<INDIVIDUAL_HOUSE_DTO> hostInfo = hostInfoModel.getHostInfo();
				for(INDIVIDUAL_HOUSE_DTO houseDto : hostInfo){
					GU_INDIVIDUAL_HOUSE house = new GU_INDIVIDUAL_HOUSE();
					BeanUtils.copyProperties(houseDto, house);
					house.setIndividual(individual);
					house.setOPER_DATE(now);
					house.setOPER_ID(userId);
					individualHouseSet.add(house);
				}
			}
			//公司
			if(companyInfoModel != null && companyInfoModel.getCompanyInfo() != null && companyInfoModel.getCompanyInfo().size()>0){
				
				Set<GU_INDIVIDUAL_COMPANY> individualCompanySet = new HashSet<GU_INDIVIDUAL_COMPANY>();
				
				individual.setIndividualCompanySet(individualCompanySet);
				List<INDIVIDUAL_COMPANY_DTO> companyInfo = companyInfoModel.getCompanyInfo();
				for(INDIVIDUAL_COMPANY_DTO companyDto : companyInfo){
					GU_INDIVIDUAL_COMPANY company = new GU_INDIVIDUAL_COMPANY();
					BeanUtils.copyProperties(companyDto, company);
					company.setIndividual(individual);
					company.setOPER_DATE(now);
					company.setOPER_ID(userId);
					individualCompanySet.add(company);
				}
			}
			//联系人
			if(linkManInfoModel != null && linkManInfoModel.getLinkManInfo()!=null && linkManInfoModel.getLinkManInfo().size()>0){
				
				Set<GU_INDIVIDUAL_LINKMAN> individualLinkmanSet = new HashSet<GU_INDIVIDUAL_LINKMAN>();
				
				individual.setIndividualLinkmanSet(individualLinkmanSet);
				List<INDIVIDUAL_LINKMAN_DTO> linkManInfo = linkManInfoModel.getLinkManInfo();
				for(INDIVIDUAL_LINKMAN_DTO linkManDto : linkManInfo){
					GU_INDIVIDUAL_LINKMAN linkMan = new GU_INDIVIDUAL_LINKMAN();
					BeanUtils.copyProperties(linkManDto, linkMan);
					linkMan.setIndividual(individual);
					linkMan.setOPER_DATE(now);
					linkMan.setOPER_ID(userId);
					individualLinkmanSet.add(linkMan);
				}
				
			}
		}
		
		
		GU_INDIVIDUAL_INFO apply_gu_individual_info = null;
		if (individual_info_db == null) {
			individualInfoDao.saveIndividualInfo(individual);
			apply_gu_individual_info = individual;
		}else{
			apply_gu_individual_info = individual_info_db;
		}
		if(applyInfo.getGuarant_id()!=null){
		//申请担保生成
		applyInfoService.addIndividualApplyInfo(applyInfo,apply_gu_individual_info,userDto);
		}
	}
	
	
	public void saveEnterprise(EnterPraiseDTO enterPraiseDTO,EnterpraiseBusinessModel enterpraiseBusinessModel,APPLY_INFO_DTO applyInfo,UserInfoDto userDto )throws Exception{
		GU_ENTERPRISE_INFO gu_enterprise_info = null;
		GU_ENTERPRISE_INFO gu_enterprise_info_db = individualInfoDao.getEnterprise(enterPraiseDTO.getREGISER_NO());
		Date now = new Date();
		String userId = null;
		if(userDto != null){
			userId = userDto.getUserid();
		}
		if(gu_enterprise_info != null){
			gu_enterprise_info = gu_enterprise_info_db;
		}else{
			gu_enterprise_info = new GU_ENTERPRISE_INFO();
			BeanUtils.copyProperties(enterPraiseDTO, gu_enterprise_info);
			gu_enterprise_info.setOPER_ID(userId);
			gu_enterprise_info.setOPER_DATE(now);
		}
		
		if(gu_enterprise_info_db == null){
			List<ENTERPRISE_BUSINESS_DTO> list = enterpraiseBusinessModel.getEnterpraiseBusinessInfo();
			if(list != null && list.size()>0){
				Set<GU_ENTERPRISE_BUSINESS> enterpriseSet = new HashSet<GU_ENTERPRISE_BUSINESS>();
				gu_enterprise_info.setEnterpriseSet(enterpriseSet);
				for(ENTERPRISE_BUSINESS_DTO dto : list){
					GU_ENTERPRISE_BUSINESS gu_enterprise_business = new GU_ENTERPRISE_BUSINESS();
					BeanUtils.copyProperties(dto, gu_enterprise_business);
					gu_enterprise_business.setOPER_DATE(now);
					gu_enterprise_business.setOPER_ID(userId);
					enterpriseSet.add(gu_enterprise_business);
				}
			}
		}
		GU_ENTERPRISE_INFO apply_gu_enterprise_info = null;
		if(gu_enterprise_info_db == null){
			individualInfoDao.saveEnterpriseInfo(gu_enterprise_info);
			apply_gu_enterprise_info = gu_enterprise_info;
		}else{
			apply_gu_enterprise_info = gu_enterprise_info_db;
		}
		if(applyInfo.getGuarant_id()!=null){
		 applyInfoService.addEnterpriseApplyInfo(applyInfo, apply_gu_enterprise_info,userDto);
		}
	}

	public void updateIndividualInfo(GU_INDIVIDUAL_INFO individual) {
		individualInfoDao.updateIndividualInfo(individual);
		
	}

	public void saveEnterpriseInfo(GU_ENTERPRISE_INFO enterprise) {
		
		
		
		individualInfoDao.saveEnterpriseInfo(enterprise);
	}

	public void updateEnterpriseInfo(GU_ENTERPRISE_INFO enterprise) {
		individualInfoDao.updateEnterpriseInfo(enterprise);
	}

	
	 public INDIVIDUAL_INFO_DTO getIndividualInfo(String CERT_NO){
		 INDIVIDUAL_INFO_DTO individual_info_dto = new INDIVIDUAL_INFO_DTO();
		 GU_INDIVIDUAL_INFO gu_individual_info = individualInfoDao.getIndividualInfo(CERT_NO);
		 if(gu_individual_info == null){
			 return null;
		 }
		 HostInfoModel hostInfoModel = new HostInfoModel();
		 List<INDIVIDUAL_HOUSE_DTO> hostInfo = new ArrayList<INDIVIDUAL_HOUSE_DTO>();
		 hostInfoModel.setHostInfo(hostInfo);
		 
		 CompanyInfoModel companyInfoModel = new CompanyInfoModel();
		 List<INDIVIDUAL_COMPANY_DTO> companyInfo = new ArrayList<INDIVIDUAL_COMPANY_DTO>();
		 companyInfoModel.setCompanyInfo(companyInfo);
		 
		 LinkManInfoModel linkManInfoModel = new LinkManInfoModel();
		 List<INDIVIDUAL_LINKMAN_DTO> linkManInfo = new ArrayList<INDIVIDUAL_LINKMAN_DTO>();
		 linkManInfoModel.setLinkManInfo(linkManInfo);
		 
		 if(gu_individual_info != null){
			 BeanUtils.copyProperties(gu_individual_info, individual_info_dto);
			 //house
			 Set<GU_INDIVIDUAL_HOUSE> individualHouseSet =  gu_individual_info.getIndividualHouseSet();
			 if(individualHouseSet != null && individualHouseSet.size()>0){
				 for(GU_INDIVIDUAL_HOUSE house : individualHouseSet){
					 INDIVIDUAL_HOUSE_DTO houseDto = new INDIVIDUAL_HOUSE_DTO();
					 BeanUtils.copyProperties(house, houseDto);
					 hostInfo.add(houseDto);
				 }
			 }
			 //company
			 Set<GU_INDIVIDUAL_COMPANY> individualCompanySet = gu_individual_info.getIndividualCompanySet();
			 if(individualCompanySet != null && individualCompanySet.size()>0){
				 for(GU_INDIVIDUAL_COMPANY compay : individualCompanySet){
					 INDIVIDUAL_COMPANY_DTO companyDto = new INDIVIDUAL_COMPANY_DTO();
					 BeanUtils.copyProperties(compay, companyDto);
					 companyInfo.add(companyDto);
				 }
			 }
			 //link man 
			 Set<GU_INDIVIDUAL_LINKMAN> individualLinkmanSet = gu_individual_info.getIndividualLinkmanSet();
			 if(individualLinkmanSet != null && individualLinkmanSet.size()>0){
				 for(GU_INDIVIDUAL_LINKMAN linkMan : individualLinkmanSet){
					 INDIVIDUAL_LINKMAN_DTO linkManDto = new INDIVIDUAL_LINKMAN_DTO();
					 BeanUtils.copyProperties(linkMan, linkManDto);
					 linkManInfo.add(linkManDto);
				 }
			 }
		 }
		 
		 individual_info_dto.setHostInfoModel(hostInfoModel);
		 individual_info_dto.setCompanyInfoModel(companyInfoModel);
		 individual_info_dto.setLinkManInfoModel(linkManInfoModel);
		 
		 return individual_info_dto;
	 }
 
	public List<GU_ENTERPRISE_INFO> getEnterpriseInfo(
			GU_ENTERPRISE_INFO enterprise) {
		return null;
	}

	@Override
	public GU_INDIVIDUAL_INFO getBaseIndividualInfo(String CERT_NO) {
		return individualInfoDao.getBaseIndividualInfo(CERT_NO);
	}

	@Override
	public EnterPraiseDTO getEnterprise(String REGISER_NO) {
		EnterPraiseDTO enterPraiseDTO = new EnterPraiseDTO();
		GU_ENTERPRISE_INFO gu_enterprise_info = individualInfoDao.getEnterprise(REGISER_NO);
		
		EnterpraiseBusinessModel enterpraiseBusinessModel = new EnterpraiseBusinessModel();
		List<ENTERPRISE_BUSINESS_DTO> enterpraiseBusinessInfo = new ArrayList<ENTERPRISE_BUSINESS_DTO>();
		enterpraiseBusinessModel.setEnterpraiseBusinessInfo(enterpraiseBusinessInfo);
		enterPraiseDTO.setEnterpraiseBusinessModel(enterpraiseBusinessModel);
		
		if(gu_enterprise_info != null){
			
			BeanUtils.copyProperties(gu_enterprise_info, enterPraiseDTO);
			Set<GU_ENTERPRISE_BUSINESS> enterpriseSet= gu_enterprise_info.getEnterpriseSet();
			if(enterpriseSet != null && enterpriseSet.size()>0){
				for(GU_ENTERPRISE_BUSINESS gu_enterprise_business : enterpriseSet){
					ENTERPRISE_BUSINESS_DTO enterprise_business_dto = new ENTERPRISE_BUSINESS_DTO();
					BeanUtils.copyProperties(gu_enterprise_business, enterprise_business_dto);
					enterpraiseBusinessInfo.add(enterprise_business_dto);
				}
			}
		}
		
		return enterPraiseDTO;
	}

	public void updateIndividualInfo(INDIVIDUAL_INFO_DTO individualDto, HostInfoModel hostInfoModel,
			CompanyInfoModel companyInfoModel, LinkManInfoModel linkManInfoModel, UserInfoDto userDto) {

		Date now = new Date();
		String userId = null;
		if (userDto != null) {
			userId = userDto.getUserid();
		}

		GU_INDIVIDUAL_INFO individual = new GU_INDIVIDUAL_INFO();
		individualDto.setMODIFY_ID(userId);
		individualDto.setMODIFY_DATE(now);
		BeanUtils.copyProperties(individualDto, individual);

		// 房产
		if (hostInfoModel != null && hostInfoModel.getHostInfo() != null && hostInfoModel.getHostInfo().size() > 0) {
			Set<GU_INDIVIDUAL_HOUSE> individualHouseSet = new HashSet<GU_INDIVIDUAL_HOUSE>();

			individual.setIndividualHouseSet(individualHouseSet);

			List<INDIVIDUAL_HOUSE_DTO> hostInfo = hostInfoModel.getHostInfo();
			for (INDIVIDUAL_HOUSE_DTO houseDto : hostInfo) {
				GU_INDIVIDUAL_HOUSE house = new GU_INDIVIDUAL_HOUSE();
				BeanUtils.copyProperties(houseDto, house);
				houseDto.setMODIFY_ID(userId);
				houseDto.setMODIFY_DATE(now);
				house.setIndividual(individual);
				individualHouseSet.add(house);
			}
		}
		// 公司
		if (companyInfoModel != null && companyInfoModel.getCompanyInfo() != null
				&& companyInfoModel.getCompanyInfo().size() > 0) {

			Set<GU_INDIVIDUAL_COMPANY> individualCompanySet = new HashSet<GU_INDIVIDUAL_COMPANY>();

			individual.setIndividualCompanySet(individualCompanySet);
			List<INDIVIDUAL_COMPANY_DTO> companyInfo = companyInfoModel.getCompanyInfo();
			for (INDIVIDUAL_COMPANY_DTO companyDto : companyInfo) {
				GU_INDIVIDUAL_COMPANY company = new GU_INDIVIDUAL_COMPANY();
				BeanUtils.copyProperties(companyDto, company);
				companyDto.setMODIFY_DATE(now);
				companyDto.setMODIFY_ID(userId);
				company.setIndividual(individual);
				individualCompanySet.add(company);
			}
		}
		// 联系人
		if (linkManInfoModel != null && linkManInfoModel.getLinkManInfo() != null
				&& linkManInfoModel.getLinkManInfo().size() > 0) {

			Set<GU_INDIVIDUAL_LINKMAN> individualLinkmanSet = new HashSet<GU_INDIVIDUAL_LINKMAN>();

			individual.setIndividualLinkmanSet(individualLinkmanSet);
			List<INDIVIDUAL_LINKMAN_DTO> linkManInfo = linkManInfoModel.getLinkManInfo();
			for (INDIVIDUAL_LINKMAN_DTO linkManDto : linkManInfo) {
				GU_INDIVIDUAL_LINKMAN linkMan = new GU_INDIVIDUAL_LINKMAN();
				BeanUtils.copyProperties(linkManDto, linkMan);
				linkManDto.setMODIFY_ID(userId);
				linkManDto.setMODIFY_TIME(now);
				linkMan.setIndividual(individual);
				individualLinkmanSet.add(linkMan);
			}

		}
		// 修改个人资料
		individualInfoDao.updateIndividualInfo(individual);
	}

	@Override
	public void updateEnterprise(EnterPraiseDTO enterPraiseDTO, EnterpraiseBusinessModel enterpraiseBusinessModel,
			UserInfoDto userDto) {
		GU_ENTERPRISE_INFO gu_enterprise_info = new GU_ENTERPRISE_INFO();
		Date now = new Date();
		String userId = null;
		if (userDto != null) {
			userId = userDto.getUserid();
		}
		BeanUtils.copyProperties(enterPraiseDTO, gu_enterprise_info);
		gu_enterprise_info.setMODIFY_ID(userId);
		gu_enterprise_info.setMODIFY_TIME(now);

		List<ENTERPRISE_BUSINESS_DTO> list = enterpraiseBusinessModel.getEnterpraiseBusinessInfo();
		if (list != null && list.size() > 0) {
			Set<GU_ENTERPRISE_BUSINESS> enterpriseSet = new HashSet<GU_ENTERPRISE_BUSINESS>();
			gu_enterprise_info.setEnterpriseSet(enterpriseSet);
			for (ENTERPRISE_BUSINESS_DTO dto : list) {
				GU_ENTERPRISE_BUSINESS gu_enterprise_business = new GU_ENTERPRISE_BUSINESS();
				BeanUtils.copyProperties(dto, gu_enterprise_business);
				gu_enterprise_business.setMODIFY_ID(userId);
				gu_enterprise_business.setMODIFY_TIME(now);
				enterpriseSet.add(gu_enterprise_business);
			}
		}
		// 修改企业资料
		individualInfoDao.updateEnterpriseInfo(gu_enterprise_info);

	}
}
