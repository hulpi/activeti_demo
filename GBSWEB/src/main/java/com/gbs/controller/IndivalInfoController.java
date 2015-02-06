package com.gbs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.CompanyInfoModel;
import com.gbs.dto.EnterPraiseDTO;
import com.gbs.dto.EnterpraiseBusinessModel;
import com.gbs.dto.HostInfoModel;
import com.gbs.dto.INDIVIDUAL_INFO_DTO;
import com.gbs.dto.LinkManInfoModel;
import com.gbs.dto.UserInfoDto;
import com.gbs.service.IndividualInfoService;
import com.gbs.util.UserUtil;

@Controller
public class IndivalInfoController {

	Logger log = Logger.getLogger(IndivalInfoController.class);

	@Resource
	private IndividualInfoService individualInfoService;

	@RequestMapping(value = "/saveIndividual", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String saveIndividual(INDIVIDUAL_INFO_DTO individual,
			HostInfoModel hostInfoModel,
			LinkManInfoModel linkManInfoModel,
			CompanyInfoModel companyInfoModel,
			APPLY_INFO_DTO applyInfo,
			HttpServletRequest request) throws Exception {
		
		log.debug("保存个人信息开始");
		UserInfoDto userDto = UserUtil.getUserFromSession(request.getSession());
		individualInfoService.saveIndividualInfo(individual,hostInfoModel,companyInfoModel,linkManInfoModel,applyInfo,userDto);
		log.debug("保存个人信息结束");
		return null;
	}

	@RequestMapping(value = "/saveEnterpraise", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String saveEnterpraise(EnterPraiseDTO enterPraiseDTO,EnterpraiseBusinessModel enterpraiseBusinessModel,APPLY_INFO_DTO applyInfo,HttpServletRequest request) throws Exception {
		log.debug("保存企业信息开始");
		UserInfoDto userDto = UserUtil.getUserFromSession(request.getSession());
		individualInfoService.saveEnterprise(enterPraiseDTO,enterpraiseBusinessModel,applyInfo,userDto);
		log.debug("保存企业信息结束");
		return null;
	}
	
	@RequestMapping(value = "/updateEnterpraise", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String updateEnterpraise(EnterPraiseDTO enterPraiseDTO,EnterpraiseBusinessModel enterpraiseBusinessModel,HttpServletRequest request) throws Exception {
		log.debug("修改企业资料开始");
		UserInfoDto userDto = UserUtil.getUserFromSession(request.getSession());
		individualInfoService.updateEnterprise(enterPraiseDTO,enterpraiseBusinessModel,userDto);
		log.debug("修改企业资料结束");
		return null;
	}
	@RequestMapping(value = "/updateIndividual", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String updateIndividual(INDIVIDUAL_INFO_DTO individual,
			HostInfoModel hostInfoModel,
			LinkManInfoModel linkManInfoModel,
			CompanyInfoModel companyInfoModel,
			APPLY_INFO_DTO applyInfo,
			HttpServletRequest request) throws Exception {
		
		log.debug("修改个人信息开始");
		UserInfoDto userDto = UserUtil.getUserFromSession(request.getSession());
   	    individualInfoService.updateIndividualInfo(individual,hostInfoModel,companyInfoModel,linkManInfoModel,userDto);
		log.debug("修改个人信息结束");
		return null;
	}

}
