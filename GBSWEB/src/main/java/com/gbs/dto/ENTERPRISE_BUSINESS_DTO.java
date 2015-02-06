package com.gbs.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ENTERPRISE_BUSINESS_DTO {
    private Long GU_ENTERPRISE_BUSINESS_OID;
	
	private int YEAR;
	
	private double SALES_INCOME;
	
	private double PROFIT;
	
	private double TAX_AMT;
	
	private String REMARK;
	
	private String OPER_ID;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date OPER_DATE;
	
	private String MODIFY_ID;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date MODIFY_TIME;

	public Long getGU_ENTERPRISE_BUSINESS_OID() {
		return GU_ENTERPRISE_BUSINESS_OID;
	}

	public void setGU_ENTERPRISE_BUSINESS_OID(Long gU_ENTERPRISE_BUSINESS_OID) {
		GU_ENTERPRISE_BUSINESS_OID = gU_ENTERPRISE_BUSINESS_OID;
	}

	public int getYEAR() {
		return YEAR;
	}

	public void setYEAR(int yEAR) {
		YEAR = yEAR;
	}

	public double getSALES_INCOME() {
		return SALES_INCOME;
	}

	public void setSALES_INCOME(double sALES_INCOME) {
		SALES_INCOME = sALES_INCOME;
	}

	public double getPROFIT() {
		return PROFIT;
	}

	public void setPROFIT(double pROFIT) {
		PROFIT = pROFIT;
	}

	public double getTAX_AMT() {
		return TAX_AMT;
	}

	public void setTAX_AMT(double tAX_AMT) {
		TAX_AMT = tAX_AMT;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
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
	
	

}
