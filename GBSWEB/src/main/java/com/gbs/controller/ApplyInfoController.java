package com.gbs.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gbs.constant.RuleItemStatus;
import com.gbs.delegate.ApplyInfoRuleDelegate;
import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.EnterPraiseDTO;
import com.gbs.dto.INDIVIDUAL_INFO_DTO;
import com.gbs.dto.UserInfoDto;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.service.ApplyInfoService;
import com.gbs.service.CityService;
import com.gbs.service.FunderService;
import com.gbs.service.IndividualInfoService;
import com.gbs.util.UserUtil;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuAPPLYINFO;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.ResponseInfo;

@Controller
public class ApplyInfoController {

	@Resource
	private CityService cityService;
	@Resource
	private FunderService funderService;
	@Resource
	private IndividualInfoService individualInfoService;
	
	@Resource
	private ApplyInfoService applyInfoService;
	
	@Resource
	private ApplyInfoRuleDelegate ruleDelegate;
	
	@RequestMapping(value = "/guarantApply", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView guarantApply(APPLY_INFO_DTO applyInfo)throws Exception {
		ModelAndView model = null;
		if(applyInfo.getIn_id() != null){
			model = new ModelAndView("loanApply/individualApply");
			INDIVIDUAL_INFO_DTO  individual = individualInfoService.getIndividualInfo(applyInfo.getIn_id());
			model.addObject("a",applyInfo);
			if(individual != null){
			model.addObject("individual",individual);
			model.addObject("houstInfo",individual.getHostInfoModel().getHostInfo());
			model.addObject("companyInfo",individual.getCompanyInfoModel().getCompanyInfo());
			model.addObject("linkManInfo",individual.getLinkManInfoModel().getLinkManInfo());
			}
		}
		
		if(applyInfo.getEn_id()!=null){
			EnterPraiseDTO enterPraiseDTO = individualInfoService.getEnterprise(applyInfo.getEn_id());
			Map map = new HashMap(); 
			map.put("e", enterPraiseDTO);
			map.put("a", applyInfo);
			
			map.put("b", enterPraiseDTO.getEnterpraiseBusinessModel());
			model = new ModelAndView("loanApply/enterpraiseApply",map);
		}
		return model;
	}
	@RequestMapping(value = "/getApplyList", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView getApplyList()throws Exception {
		ModelAndView model = null;
		String username="Frank";
		List<GU_APPLY_INFO> list = applyInfoService.queryApplyInfoByUser(username);
		if(list!=null&&list.size()>0){
			Map map = new HashMap(); 
			map.put("p", list);
			model=new ModelAndView("loanApply/applyList",map);
		}
		return  model;
	
     }
	@RequestMapping(value = "/getRecord", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView getRecord(String guarant_id )throws Exception {
		ModelAndView model = null;
		INDIVIDUAL_INFO_DTO individual = applyInfoService.getIndival(guarant_id);
		Map map = new HashMap();
		map.put("i", individual);//基本资料
		map.put("p", individual.getHostInfoModel());//房产
		//map.put("pp", individual.getHostInfoModel().getHostInfo());//房产
		map.put("c", individual.getCompanyInfoModel());//公司
		map.put("l", individual.getLinkManInfoModel());//联系人
		model = new ModelAndView("loanApply/updateInfo",map);
		return model;
     }
	/**
	 * 查询申请单 
	 * @param guarantId
	 * @return
	 */
	@RequestMapping(value = "/getApplyInfoByGuarantId", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView getApplyInfoByGuarantId(@RequestParam(value="guarantId") String guarantId){
		ModelAndView model = new ModelAndView("loanApply/update_apply_info");
		APPLY_INFO_DTO apply_info_dto = applyInfoService.getApplyInfoByGuarantId(guarantId);
		model.addObject("applyInfo",apply_info_dto);
		return model;
	}
	
	/**
	 * 修改申请单 
	 * @param guarantId
	 * @return
	 */
	@RequestMapping(value = "/updateApplyInfo", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView updateApplyInfo(APPLY_INFO_DTO applyInfo,HttpServletRequest request){
		ModelAndView model = new ModelAndView("loanApply/update_apply_info");
		UserInfoDto user = UserUtil.getUserFromSession(request.getSession());
		applyInfo.setUserId(user.getUserid());
		applyInfoService.updateApplyInfo(applyInfo);
		return model;
	}
}
