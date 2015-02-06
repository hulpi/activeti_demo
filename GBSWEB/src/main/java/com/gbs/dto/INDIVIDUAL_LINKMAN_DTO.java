package com.gbs.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 联系人信息
 * @author fa00016
 *
 */
public class INDIVIDUAL_LINKMAN_DTO {
	
    private Long GU_INDIVIDUAL_LINKMAN_OID;

	private String APPLY_CITY;
	
	private String LINKMAN_NAME;
			
	private Integer LINKMAN_AGE;
	
	private String LINKMAN_SEX;
	
	private String RELATION_TO_LOANER;
	
	private String DWELL_ADDRESS_DETAIL;
	
	private String DWELL_TEL_NUMBER;
	
	private String LINK_MAN_MOBILE_NUMBER;
	
	private String LINK_MAN_UNIT_NAME;
	
	private String LINK_MAN_POSITION;
	
	private String LINK_MAN_UINT_TEL_NUMBER;
	
	private String OPER_ID;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date OPER_DATE;
	
	private String MODIFY_ID;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date MODIFY_TIME;
	

   
	public Long getGU_INDIVIDUAL_LINKMAN_OID() {
		return GU_INDIVIDUAL_LINKMAN_OID;
	}


	public void setGU_INDIVIDUAL_LINKMAN_OID(Long gU_INDIVIDUAL_LINKMAN_OID) {
		GU_INDIVIDUAL_LINKMAN_OID = gU_INDIVIDUAL_LINKMAN_OID;
	}


	public String getAPPLY_CITY() {
		return APPLY_CITY;
	}


	public void setAPPLY_CITY(String aPPLY_CITY) {
		APPLY_CITY = aPPLY_CITY;
	}


	public String getLINKMAN_NAME() {
		return LINKMAN_NAME;
	}


	public void setLINKMAN_NAME(String lINKMAN_NAME) {
		LINKMAN_NAME = lINKMAN_NAME;
	}


	public Integer getLINKMAN_AGE() {
		return LINKMAN_AGE;
	}


	public void setLINKMAN_AGE(Integer lINKMAN_AGE) {
		LINKMAN_AGE = lINKMAN_AGE;
	}


	public String getLINKMAN_SEX() {
		return LINKMAN_SEX;
	}


	public void setLINKMAN_SEX(String lINKMAN_SEX) {
		LINKMAN_SEX = lINKMAN_SEX;
	}


	public String getRELATION_TO_LOANER() {
		return RELATION_TO_LOANER;
	}


	public void setRELATION_TO_LOANER(String rELATION_TO_LOANER) {
		RELATION_TO_LOANER = rELATION_TO_LOANER;
	}


	public String getDWELL_ADDRESS_DETAIL() {
		return DWELL_ADDRESS_DETAIL;
	}


	public void setDWELL_ADDRESS_DETAIL(String dWELL_ADDRESS_DETAIL) {
		DWELL_ADDRESS_DETAIL = dWELL_ADDRESS_DETAIL;
	}


	public String getDWELL_TEL_NUMBER() {
		return DWELL_TEL_NUMBER;
	}


	public void setDWELL_TEL_NUMBER(String dWELL_TEL_NUMBER) {
		DWELL_TEL_NUMBER = dWELL_TEL_NUMBER;
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


	public Date getMODIFY_TIME() {
		return MODIFY_TIME;
	}


	public void setMODIFY_TIME(Date mODIFY_TIME) {
		MODIFY_TIME = mODIFY_TIME;
	}


	public String getLINK_MAN_MOBILE_NUMBER() {
		return LINK_MAN_MOBILE_NUMBER;
	}


	public void setLINK_MAN_MOBILE_NUMBER(String lINK_MAN_MOBILE_NUMBER) {
		LINK_MAN_MOBILE_NUMBER = lINK_MAN_MOBILE_NUMBER;
	}


	public String getLINK_MAN_UNIT_NAME() {
		return LINK_MAN_UNIT_NAME;
	}


	public void setLINK_MAN_UNIT_NAME(String lINK_MAN_UNIT_NAME) {
		LINK_MAN_UNIT_NAME = lINK_MAN_UNIT_NAME;
	}


	public String getLINK_MAN_POSITION() {
		return LINK_MAN_POSITION;
	}


	public void setLINK_MAN_POSITION(String lINK_MAN_POSITION) {
		LINK_MAN_POSITION = lINK_MAN_POSITION;
	}


	public String getLINK_MAN_UINT_TEL_NUMBER() {
		return LINK_MAN_UINT_TEL_NUMBER;
	}


	public void setLINK_MAN_UINT_TEL_NUMBER(String lINK_MAN_UINT_TEL_NUMBER) {
		LINK_MAN_UINT_TEL_NUMBER = lINK_MAN_UINT_TEL_NUMBER;
	}
}
