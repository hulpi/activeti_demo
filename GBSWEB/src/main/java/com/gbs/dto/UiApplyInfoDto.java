package com.gbs.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UiApplyInfoDto {
	private String guarant_id;// 担保编号
	private String apply_date;// 申请日期
	private String custName;// 客户名称
	private String productName;// 贷款产品
	private String cityName;// 城市公司
	private String apply_status;// 申请状态
	private String guarant_amt;// 担保金额
	private String approve_amt;// 审批金额
	private String guarant_type;// 担保类型
	private Long guarant_time_limit;// 担保期限
	private String loan_purpose;// 贷款用途
	private String applicant;// 申请人

	public String getGuarant_id() {
		return guarant_id;
	}

	public void setGuarant_id(String guarant_id) {
		this.guarant_id = guarant_id;
	}

	public String getApply_date() {
		return apply_date;
	}

	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getApply_status() {
		return apply_status;
	}

	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}

	public String getGuarant_amt() {
		return guarant_amt;
	}

	public void setGuarant_amt(String guarant_amt) {
		this.guarant_amt = guarant_amt;
	}

	public String getApprove_amt() {
		return approve_amt;
	}

	public void setApprove_amt(String approve_amt) {
		this.approve_amt = approve_amt;
	}

	public String getGuarant_type() {
		return guarant_type;
	}

	public void setGuarant_type(String guarant_type) {
		this.guarant_type = guarant_type;
	}

	public Long getGuarant_time_limit() {
		return guarant_time_limit;
	}

	public void setGuarant_time_limit(Long guarant_time_limit) {
		this.guarant_time_limit = guarant_time_limit;
	}

	public String getLoan_purpose() {
		return loan_purpose;
	}

	public void setLoan_purpose(String loan_purpose) {
		this.loan_purpose = loan_purpose;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

}
