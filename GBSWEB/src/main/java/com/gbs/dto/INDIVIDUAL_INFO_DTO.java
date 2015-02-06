package com.gbs.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 个人信息DTO
 * 
 * @author wb00002
 * 
 */
public class INDIVIDUAL_INFO_DTO {
	private APPLY_INFO_DTO applyInfo;

	private Long GU_INDIVIDUAL_INFO_OID;

	private String CERT_NO;

	private String CERT_TYPE;

	private String CUST_NAME;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date BIRTHDAY;

	private String SEX;

	private String EDUCATION_LEVEL;

	private String NATIVE_PLACE;

	private String HUKOU_ADD;

	private String ID_CARD_ADDRESS_DETAIL;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ID_CARD_VALIDITY_FROM;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ID_CARD_VALIDITY_TO;

	private Integer ID_CARD_VALIDITY_PERIOD;

	private String ADDRESS_DETAIL;

	private String OPER_ID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date OPER_DATE;

	private String MODIFY_ID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date MODIFY_DATE;

	private HostInfoModel hostInfoModel;
	
	private LinkManInfoModel linkManInfoModel;
	
	private CompanyInfoModel companyInfoModel;

	public APPLY_INFO_DTO getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(APPLY_INFO_DTO applyInfo) {
		this.applyInfo = applyInfo;
	}

	public Long getGU_INDIVIDUAL_INFO_OID() {
		return GU_INDIVIDUAL_INFO_OID;
	}

	public void setGU_INDIVIDUAL_INFO_OID(Long gU_INDIVIDUAL_INFO_OID) {
		GU_INDIVIDUAL_INFO_OID = gU_INDIVIDUAL_INFO_OID;
	}

	public String getCERT_NO() {
		return CERT_NO;
	}

	public void setCERT_NO(String cERT_NO) {
		CERT_NO = cERT_NO;
	}

	public String getCERT_TYPE() {
		return CERT_TYPE;
	}

	public void setCERT_TYPE(String cERT_TYPE) {
		CERT_TYPE = cERT_TYPE;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME = cUST_NAME;
	}

	public Date getBIRTHDAY() {
		return BIRTHDAY;
	}

	public void setBIRTHDAY(Date bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getEDUCATION_LEVEL() {
		return EDUCATION_LEVEL;
	}

	public void setEDUCATION_LEVEL(String eDUCATION_LEVEL) {
		EDUCATION_LEVEL = eDUCATION_LEVEL;
	}

	public String getNATIVE_PLACE() {
		return NATIVE_PLACE;
	}

	public void setNATIVE_PLACE(String nATIVE_PLACE) {
		NATIVE_PLACE = nATIVE_PLACE;
	}

	public String getHUKOU_ADD() {
		return HUKOU_ADD;
	}

	public void setHUKOU_ADD(String hUKOU_ADD) {
		HUKOU_ADD = hUKOU_ADD;
	}

	public String getID_CARD_ADDRESS_DETAIL() {
		return ID_CARD_ADDRESS_DETAIL;
	}

	public void setID_CARD_ADDRESS_DETAIL(String iD_CARD_ADDRESS_DETAIL) {
		ID_CARD_ADDRESS_DETAIL = iD_CARD_ADDRESS_DETAIL;
	}

	public Date getID_CARD_VALIDITY_FROM() {
		return ID_CARD_VALIDITY_FROM;
	}

	public void setID_CARD_VALIDITY_FROM(Date iD_CARD_VALIDITY_FROM) {
		ID_CARD_VALIDITY_FROM = iD_CARD_VALIDITY_FROM;
	}

	public Date getID_CARD_VALIDITY_TO() {
		return ID_CARD_VALIDITY_TO;
	}

	public void setID_CARD_VALIDITY_TO(Date iD_CARD_VALIDITY_TO) {
		ID_CARD_VALIDITY_TO = iD_CARD_VALIDITY_TO;
	}

	public Integer getID_CARD_VALIDITY_PERIOD() {
		return ID_CARD_VALIDITY_PERIOD;
	}

	public void setID_CARD_VALIDITY_PERIOD(Integer iD_CARD_VALIDITY_PERIOD) {
		ID_CARD_VALIDITY_PERIOD = iD_CARD_VALIDITY_PERIOD;
	}

	public String getADDRESS_DETAIL() {
		return ADDRESS_DETAIL;
	}

	public void setADDRESS_DETAIL(String aDDRESS_DETAIL) {
		ADDRESS_DETAIL = aDDRESS_DETAIL;
	}

	public String getOPER_ID() {
		return OPER_ID;
	}

	public void setOPER_ID(String oPER_ID) {
		OPER_ID = oPER_ID;
	}

	public Date getOPER_DATE() {
		return OPER_DATE;
	}

	public void setOPER_DATE(Date oPER_DATE) {
		OPER_DATE = oPER_DATE;
	}

	public String getMODIFY_ID() {
		return MODIFY_ID;
	}

	public void setMODIFY_ID(String mODIFY_ID) {
		MODIFY_ID = mODIFY_ID;
	}

	public Date getMODIFY_DATE() {
		return MODIFY_DATE;
	}

	public void setMODIFY_DATE(Date mODIFY_DATE) {
		MODIFY_DATE = mODIFY_DATE;
	}

	public HostInfoModel getHostInfoModel() {
		return hostInfoModel;
	}

	public void setHostInfoModel(HostInfoModel hostInfoModel) {
		this.hostInfoModel = hostInfoModel;
	}

	public LinkManInfoModel getLinkManInfoModel() {
		return linkManInfoModel;
	}

	public void setLinkManInfoModel(LinkManInfoModel linkManInfoModel) {
		this.linkManInfoModel = linkManInfoModel;
	}

	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}

	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}

}
