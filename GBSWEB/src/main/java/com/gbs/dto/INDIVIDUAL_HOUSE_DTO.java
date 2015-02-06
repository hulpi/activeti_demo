package com.gbs.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 房产信息
 * @author wb00002
 *
 */
public class INDIVIDUAL_HOUSE_DTO {
	private Long GU_INDIVIDUAL_HOUSE_OID;

	private Long GU_INDIVIDUAL_INFO_OID;

	private String CITY_CODE;

	private String HS_ADDRESS_DETAIL;

	private String BUY_PARTERN;

	private String ESTATE_CERTIFICATE_NO;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date BUY_TIME;

	private String IS_SEARCHED;

	private Double BUY_PRICE;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date SEARCH_DATE;

	private String BUILT_YEAR;

	private Double FLOOR_AREA;

	private Double SEARCH_UNIT_PRICE;

	private String MORTGAGE_BANK;

	private Integer LOAN_LIMIT_YEAR;

	private Long SEARCH_TOTAL_PRICE;

	private Double LOAN_TOTAL_AMOUNT;

	private Double BALANCE_DUE;

	private Integer MONTHLY_CONTRIBUTION;

	private String ESTATE_PURPOSES;

	private String PROPERTY_TYPE;

	private String HOUSE_PROPERTY_TYPE;

	private String OPER_ID;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date OPER_DATE;

	private String MODIFY_ID;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date MODIFY_DATE;

	public Long getGU_INDIVIDUAL_HOUSE_OID() {
		return GU_INDIVIDUAL_HOUSE_OID;
	}

	public void setGU_INDIVIDUAL_HOUSE_OID(Long gU_INDIVIDUAL_HOUSE_OID) {
		GU_INDIVIDUAL_HOUSE_OID = gU_INDIVIDUAL_HOUSE_OID;
	}

	public Long getGU_INDIVIDUAL_INFO_OID() {
		return GU_INDIVIDUAL_INFO_OID;
	}

	public void setGU_INDIVIDUAL_INFO_OID(Long gU_INDIVIDUAL_INFO_OID) {
		GU_INDIVIDUAL_INFO_OID = gU_INDIVIDUAL_INFO_OID;
	}

	public String getCITY_CODE() {
		return CITY_CODE;
	}

	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}


	public String getHS_ADDRESS_DETAIL() {
		return HS_ADDRESS_DETAIL;
	}

	public void setHS_ADDRESS_DETAIL(String hS_ADDRESS_DETAIL) {
		HS_ADDRESS_DETAIL = hS_ADDRESS_DETAIL;
	}

	public String getBUY_PARTERN() {
		return BUY_PARTERN;
	}

	public void setBUY_PARTERN(String bUY_PARTERN) {
		BUY_PARTERN = bUY_PARTERN;
	}

	public String getESTATE_CERTIFICATE_NO() {
		return ESTATE_CERTIFICATE_NO;
	}

	public void setESTATE_CERTIFICATE_NO(String eSTATE_CERTIFICATE_NO) {
		ESTATE_CERTIFICATE_NO = eSTATE_CERTIFICATE_NO;
	}

	public Date getBUY_TIME() {
		return BUY_TIME;
	}

	public void setBUY_TIME(Date bUY_TIME) {
		BUY_TIME = bUY_TIME;
	}

	public String getIS_SEARCHED() {
		return IS_SEARCHED;
	}

	public void setIS_SEARCHED(String iS_SEARCHED) {
		IS_SEARCHED = iS_SEARCHED;
	}

	public Double getBUY_PRICE() {
		return BUY_PRICE;
	}

	public void setBUY_PRICE(Double bUY_PRICE) {
		BUY_PRICE = bUY_PRICE;
	}

	public Date getSEARCH_DATE() {
		return SEARCH_DATE;
	}

	public void setSEARCH_DATE(Date sEARCH_DATE) {
		SEARCH_DATE = sEARCH_DATE;
	}

	public String getBUILT_YEAR() {
		return BUILT_YEAR;
	}

	public void setBUILT_YEAR(String bUILT_YEAR) {
		BUILT_YEAR = bUILT_YEAR;
	}

	public Double getFLOOR_AREA() {
		return FLOOR_AREA;
	}

	public void setFLOOR_AREA(Double fLOOR_AREA) {
		FLOOR_AREA = fLOOR_AREA;
	}

	public Double getSEARCH_UNIT_PRICE() {
		return SEARCH_UNIT_PRICE;
	}

	public void setSEARCH_UNIT_PRICE(Double sEARCH_UNIT_PRICE) {
		SEARCH_UNIT_PRICE = sEARCH_UNIT_PRICE;
	}

	public String getMORTGAGE_BANK() {
		return MORTGAGE_BANK;
	}

	public void setMORTGAGE_BANK(String mORTGAGE_BANK) {
		MORTGAGE_BANK = mORTGAGE_BANK;
	}

	public Integer getLOAN_LIMIT_YEAR() {
		return LOAN_LIMIT_YEAR;
	}

	public void setLOAN_LIMIT_YEAR(Integer lOAN_LIMIT_YEAR) {
		LOAN_LIMIT_YEAR = lOAN_LIMIT_YEAR;
	}

	public Long getSEARCH_TOTAL_PRICE() {
		return SEARCH_TOTAL_PRICE;
	}

	public void setSEARCH_TOTAL_PRICE(Long sEARCH_TOTAL_PRICE) {
		SEARCH_TOTAL_PRICE = sEARCH_TOTAL_PRICE;
	}

	public Double getLOAN_TOTAL_AMOUNT() {
		return LOAN_TOTAL_AMOUNT;
	}

	public void setLOAN_TOTAL_AMOUNT(Double lOAN_TOTAL_AMOUNT) {
		LOAN_TOTAL_AMOUNT = lOAN_TOTAL_AMOUNT;
	}

	public Double getBALANCE_DUE() {
		return BALANCE_DUE;
	}

	public void setBALANCE_DUE(Double bALANCE_DUE) {
		BALANCE_DUE = bALANCE_DUE;
	}

	public Integer getMONTHLY_CONTRIBUTION() {
		return MONTHLY_CONTRIBUTION;
	}

	public void setMONTHLY_CONTRIBUTION(Integer mONTHLY_CONTRIBUTION) {
		MONTHLY_CONTRIBUTION = mONTHLY_CONTRIBUTION;
	}

	public String getESTATE_PURPOSES() {
		return ESTATE_PURPOSES;
	}

	public void setESTATE_PURPOSES(String eSTATE_PURPOSES) {
		ESTATE_PURPOSES = eSTATE_PURPOSES;
	}

	public String getPROPERTY_TYPE() {
		return PROPERTY_TYPE;
	}

	public void setPROPERTY_TYPE(String pROPERTY_TYPE) {
		PROPERTY_TYPE = pROPERTY_TYPE;
	}

	public String getHOUSE_PROPERTY_TYPE() {
		return HOUSE_PROPERTY_TYPE;
	}

	public void setHOUSE_PROPERTY_TYPE(String hOUSE_PROPERTY_TYPE) {
		HOUSE_PROPERTY_TYPE = hOUSE_PROPERTY_TYPE;
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
	
	
}
