package com.gbs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.service.ECMInfoService;

@Controller
public class ECMInfoController {

	private Logger log = Logger.getLogger(ECMInfoController.class);
	
	@Resource
	private ECMInfoService ecmInfoService;
	 
	 
	@RequestMapping(value = "/forwardECM", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView forwardECM(String guarant_id) throws Exception {
		
		String scanType = "";
		String barCode = "";
		
		GU_APPLY_INFO applyInfo = ecmInfoService.queryApplyInfoByGuarantId(guarant_id);
		if(applyInfo!=null){
			barCode = applyInfo.getEcm_barcode();
		}
		
		if(barCode!=null && barCode.length()>0){
			scanType = "1";
		}else{
			scanType = "0";
			barCode = ecmInfoService.generateBarCodeForECM();
		}
		
		ModelAndView model = null;
		Map map = new HashMap(); 
		map.put("scanType", scanType);
		map.put("barCode", barCode);
		map.put("guarantId", guarant_id);
		
		model = new ModelAndView("ECMoperate/scanManage",map);
		 
		return model;
	}
	
	@RequestMapping(value = "/saveECMscanInfo", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String saveECMscanInfo(String guarantId, String barCode) throws Exception {
		boolean rs = true;
		String error = "";
		try{
			ecmInfoService.saveECMscanInfo(guarantId, barCode);
		}catch(Exception e){
			rs = false;
			error = e.getMessage();
			log.error(e);
			//throw e;
		}
		JSONObject json = new JSONObject();
		json.put("rs", rs);
		json.put("error", error);
		return json.toString();
		 
	}

	
}
