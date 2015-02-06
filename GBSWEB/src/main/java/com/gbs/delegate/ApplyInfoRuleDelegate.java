package com.gbs.delegate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.constant.RuleItemStatus;
import com.gbs.dao.ApplyInfoDao;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.entity.GU_CITY_INFO;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
import com.gbs.service.ApplyInfoService;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCDecisionService;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCDecisionService_Service;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCRequest;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCResponse;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCSoapFault;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuAPPLYINFO;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuCITYINFO;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuENTERPRISEINFO;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuINDIVIDUALINFO;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuPRODUCTINFO;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.ResponseInfo;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.param.Param;

@Service
public class ApplyInfoRuleDelegate {

	@Autowired
	private GBSDCDecisionService_Service gbsDCDecisionService_Service;

	@Resource
	private ApplyInfoService applyInfoService;
	
	@Autowired
	private ApplyInfoDao applyInfoDao;

	Logger log = Logger.getLogger(getClass());

	public void test() throws GBSDCSoapFault {
		// TODO 初审
		GuAPPLYINFO guapplyinfo = new GuAPPLYINFO();
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setCode("01");

		guapplyinfo.setResponseInfo(responseInfo);
		guapplyinfo.setApplicant("001");
		guapplyinfo.setGuarantAmt(new BigDecimal("200"));
		applyCheck(guapplyinfo);

		GuAPPLYINFO guapplyinfo2 = new GuAPPLYINFO();
		ResponseInfo responseInfo2 = new ResponseInfo();
		responseInfo2.setCode("03");

		guapplyinfo2.setResponseInfo(responseInfo2);
		guapplyinfo2.setApplicant("001");
		guapplyinfo2.setGuarantAmt(new BigDecimal("400"));
		applyCheck(guapplyinfo2);
	}

	private ResponseInfo applyCheck(GuAPPLYINFO guapplyinfo) throws GBSDCSoapFault {
		log.info("--------------执行规则检查 开始--------------");
		GBSDCRequest gbsDCRequest = new GBSDCRequest();
		Param param = new Param();
		param.setParam(guapplyinfo);
		gbsDCRequest.setParam(param);
		GBSDCDecisionService gbsDCDecisionService = gbsDCDecisionService_Service.getGBSRULEGBSDCPort();
		GBSDCResponse response = gbsDCDecisionService.gbsDC(gbsDCRequest);
		String result = response.getParam().getParam().getResponseInfo().getResultDescription();
		log.info(result);
		log.info("--------------执行规则检查 结束--------------");
		return response.getParam().getParam().getResponseInfo();
	}

	public ResponseInfo firstCheck(String guarantId) throws GBSDCSoapFault{
		GU_APPLY_INFO applyInfo = applyInfoDao.getApplyInfoByGuarantId(guarantId);
		GuAPPLYINFO guapplyinfo = buildApplyInfoDto(applyInfo);
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setCode("02");
		guapplyinfo.setResponseInfo(responseInfo);
		
		return applyCheck(guapplyinfo);
	}
	

	private GuAPPLYINFO buildApplyInfoDto(GU_APPLY_INFO applyInfo) {
		GuAPPLYINFO guapplyinfo = new GuAPPLYINFO();

		guapplyinfo.setApplicant(applyInfo.getApplicant());
		guapplyinfo.setApplyDate(converToGregorianCal(applyInfo.getApply_date()));
		guapplyinfo.setApplyStatus(applyInfo.getApply_status());
		guapplyinfo.setApproveAmt(applyInfo.getApprove_amt());
		guapplyinfo.setEcmBarcode(applyInfo.getEcm_barcode());
		guapplyinfo.setGuApplyInfoOid(applyInfo.getGu_apply_info_oid());
		guapplyinfo.setGuarantAmt(applyInfo.getGuarant_amt());
		guapplyinfo.setGuarantId(applyInfo.getGuarant_id());
		guapplyinfo.setGuarantTimeLimit(applyInfo.getGuarant_time_limit());
		guapplyinfo.setGuarantType(applyInfo.getGuarant_type());
		guapplyinfo.setLoanPurpose(applyInfo.getLoan_purpose());
		guapplyinfo.setProcessInstanceId(applyInfo.getProcess_instance_id());
		
		if(applyInfo.getProduct()!=null){
			GU_PRODUCT_INFO product = applyInfo.getProduct();
			GuPRODUCTINFO rProduct = new GuPRODUCTINFO();
			rProduct.setProductCode(product.getProduct_code());
			rProduct.setProductDesc(product.getProduct_desc());
			rProduct.setProductType(product.getProduct_type());
			rProduct.setGuProductInfoOid(product.getGu_product_info_oid());
			guapplyinfo.setProduct(rProduct);
		}
		
		if(applyInfo.getIndividual()!=null){
			GuINDIVIDUALINFO rIndividual = new GuINDIVIDUALINFO();
			GU_INDIVIDUAL_INFO individual = applyInfo.getIndividual();
			rIndividual.setADDRESSDETAIL(individual.getADDRESS_DETAIL());
			rIndividual.setBIRTHDAY(converToGregorianCal(individual.getBIRTHDAY()));
			rIndividual.setCERTNO(individual.getCERT_NO());
			rIndividual.setCERTTYPE(individual.getCERT_TYPE());
			rIndividual.setCUSTNAME(individual.getCUST_NAME());
			rIndividual.setEDUCATIONLEVEL(individual.getEDUCATION_LEVEL());
			rIndividual.setGUINDIVIDUALINFOOID(individual.getGU_INDIVIDUAL_INFO_OID());
			rIndividual.setHUKOUADD(individual.getHUKOU_ADD());
			rIndividual.setIDCARDADDRESSDETAIL(individual.getID_CARD_ADDRESS_DETAIL());
			rIndividual.setIDCARDVALIDITYFROM(converToGregorianCal(individual.getID_CARD_VALIDITY_FROM()));
			rIndividual.setIDCARDVALIDITYPERIOD(individual.getID_CARD_VALIDITY_PERIOD());
			rIndividual.setIDCARDVALIDITYTO(converToGregorianCal(individual.getID_CARD_VALIDITY_TO()));
			rIndividual.setMODIFYDATE(converToGregorianCal(individual.getMODIFY_DATE()));
			rIndividual.setMODIFYID(individual.getMODIFY_ID());
			rIndividual.setNATIVEPLACE(individual.getNATIVE_PLACE());
			rIndividual.setOPERDATE(converToGregorianCal(individual.getOPER_DATE()));
			rIndividual.setOPERID(individual.getOPER_ID());
			rIndividual.setSEX(individual.getSEX());
			guapplyinfo.setIndividual(rIndividual);
		}
		
		if(applyInfo.getEnterprise() != null){
			GU_ENTERPRISE_INFO enterprise = applyInfo.getEnterprise();
			GuENTERPRISEINFO rEnterprise = new GuENTERPRISEINFO();
			rEnterprise.setASSETSLIABRATIO(enterprise.getASSETS_LIAB_RATIO());
			rEnterprise.setBANKCREDITLEVEL(enterprise.getBANK_CREDIT_LEVEL());
			rEnterprise.setEMPLOYEENUMBER(enterprise.getEMPLOYEE_NUMBER());
			rEnterprise.setENTERPRISEADDRESS(enterprise.getENTERPRISE_ADDRESS());
			rEnterprise.setENTERPRISEDESC(enterprise.getENTERPRISE_DESC());
			rEnterprise.setENTERPRISELOANAMT(enterprise.getENTERPRISE_LOAN_AMT());
			rEnterprise.setENTERPRISENAME(enterprise.getENTERPRISE_NAME());
			rEnterprise.setENTERPRISETYPE(enterprise.getENTERPRISE_TYPE());
			guapplyinfo.setEnterprise(rEnterprise);
		}
		
		if(applyInfo.getCity() != null){
			GU_CITY_INFO city = applyInfo.getCity();
			GuCITYINFO rCity = new GuCITYINFO();
			rCity.setAddress(city.getAddress());
			rCity.setCityCode(city.getCity_code());
			rCity.setCityName(city.getCity_name());
			rCity.setFax(city.getFax());
			rCity.setTel(city.getTel());
			rCity.setGuCityInfoOid(city.getGu_city_info_oid());
			guapplyinfo.setCity(rCity);
		}
		
		return guapplyinfo;
	}

	private XMLGregorianCalendar converToGregorianCal(Date date) {
		DatatypeFactory df = null;
		try {
			df = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			log.error("error getting DatatypeFactory instance " + e.getMessage());
		}
		if (date == null) {
			return null;
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return df.newXMLGregorianCalendar(gc);
		}
	}
}
