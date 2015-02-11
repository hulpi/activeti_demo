package com.gbs.dto;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.ResponseInfo;



public class APPLY_INFO_DTO {
	
	private String guarant_amt;// 担保金额
	private String city_id;// 城市公司
	private String funder_id;//合作方
	private String product_type;//产品类型
	
	private String productSel;//贷款产品
	private String guarant_time_limit;// 担保期限
	private String loan_purpose;// 贷款用途
	
	private String in_id;//申请人身份证编号
	private String en_id;//企业注册号
	private String guarant_id;
	private String custName;
	private Map<String, Object> variables;
	
	private String ecm_barcode;//影像CODE
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date from_apply_date;//申请日期起始
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date to_apply_date;//申请日期终止 
	
	private String userId;
	
	private ResponseInfo ruleInfo;
	
	public String getGuarant_amt() {
		return guarant_amt;
	}
	public void setGuarant_amt(String guarant_amt) {
		this.guarant_amt = guarant_amt;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getFunder_id() {
		return funder_id;
	}
	public void setFunder_id(String funder_id) {
		this.funder_id = funder_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProductSel() {
		return productSel;
	}
	public void setProductSel(String productSel) {
		this.productSel = productSel;
	}
	public String getGuarant_time_limit() {
		return guarant_time_limit;
	}
	public void setGuarant_time_limit(String guarant_time_limit) {
		this.guarant_time_limit = guarant_time_limit;
	}
	public String getLoan_purpose() {
		return loan_purpose;
	}
	public void setLoan_purpose(String loan_purpose) {
		this.loan_purpose = loan_purpose;
	}
	public String getIn_id() {
		return in_id;
	}
	public void setIn_id(String in_id) {
		this.in_id = in_id;
	}
	public String getEn_id() {
		return en_id;
	}
	public void setEn_id(String en_id) {
		this.en_id = en_id;
	}
	public String getGuarant_id() {
		return guarant_id;
	}
	public void setGuarant_id(String guarant_id) {
		this.guarant_id = guarant_id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEcm_barcode() {
		return ecm_barcode;
	}
	public void setEcm_barcode(String ecm_barcode) {
		this.ecm_barcode = ecm_barcode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getFrom_apply_date() {
		return from_apply_date;
	}
	public void setFrom_apply_date(Date from_apply_date) {
		this.from_apply_date = from_apply_date;
	}
	public Date getTo_apply_date() {
		return to_apply_date;
	}
	public void setTo_apply_date(Date to_apply_date) {
		this.to_apply_date = to_apply_date;
	}
	public Map<String, Object> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
	public ResponseInfo getRuleInfo() {
		return ruleInfo;
	}
	public void setRuleInfo(ResponseInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

}
