package com.gbs.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
public class INDIVIDUAL_COMPANY_DTO {
    private Long GU_INDIVIDUAL_COMPANY_OID;
	
	private String CITY_CODE;
	
	private String COMPANY_NAME;
	
	private String COM_ADDRESS_DETAIL;
	
	private String COM_TEL_NUMBER;
	
	private String FAX_NUMBER;
	
	private Double SERVICE_YEARS;
	
	private String UNIT_KIND;
	
	private String INDUSTRY;
	
	private String DEPARTMENT;
	
	private String POSITION;
	
	private String IS_OWNER;
	
	private String IS_SELF_EMPLOYED;
	
	private String BUSINESS_LICENCE_NO;
	
	private String ORGANIZATION_CODE;
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date ESTABLISH_DATE;
	
	private Double YEARLY_PROFIT_OR_LOSS;
	
	
	private Integer EMPLOYEE_AMOUNT;
	
	private String BUSINESS_PLACE;
	
	private Double CONT_OR_RENT_AMOUNT;
		
	private Double BASE_SALARY;
	
	private Double OTHER_INCOME;
	
	private Double MONTHLY_TOTAL_INCOME;
	
	private String PAY_PATTERN;
	
	private Integer PAY_TIME_ONE;
	
    private String OPER_ID;
    @DateTimeFormat(pattern="yyyy-MM-dd")  
    private Date OPER_DATE;
    
    private String MODIFY_ID;
    @DateTimeFormat(pattern="yyyy-MM-dd")  
    private Date MODIFY_DATE;


	public Long getGU_INDIVIDUAL_COMPANY_OID() {
		return GU_INDIVIDUAL_COMPANY_OID;
	}

	public void setGU_INDIVIDUAL_COMPANY_OID(Long gU_INDIVIDUAL_COMPANY_OID) {
		GU_INDIVIDUAL_COMPANY_OID = gU_INDIVIDUAL_COMPANY_OID;
	}


	public String getCITY_CODE() {
		return CITY_CODE;
	}

	public void setCITY_CODE(String cITY_CODE) {
		CITY_CODE = cITY_CODE;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	

	public String getCOM_ADDRESS_DETAIL() {
		return COM_ADDRESS_DETAIL;
	}

	public void setCOM_ADDRESS_DETAIL(String cOM_ADDRESS_DETAIL) {
		COM_ADDRESS_DETAIL = cOM_ADDRESS_DETAIL;
	}

	

	public String getCOM_TEL_NUMBER() {
		return COM_TEL_NUMBER;
	}

	public void setCOM_TEL_NUMBER(String cOM_TEL_NUMBER) {
		COM_TEL_NUMBER = cOM_TEL_NUMBER;
	}

	public String getFAX_NUMBER() {
		return FAX_NUMBER;
	}

	public void setFAX_NUMBER(String fAX_NUMBER) {
		FAX_NUMBER = fAX_NUMBER;
	}

	public Double getSERVICE_YEARS() {
		return SERVICE_YEARS;
	}

	public void setSERVICE_YEARS(Double sERVICE_YEARS) {
		SERVICE_YEARS = sERVICE_YEARS;
	}

	public String getUNIT_KIND() {
		return UNIT_KIND;
	}

	public void setUNIT_KIND(String uNIT_KIND) {
		UNIT_KIND = uNIT_KIND;
	}

	public String getINDUSTRY() {
		return INDUSTRY;
	}

	public void setINDUSTRY(String iNDUSTRY) {
		INDUSTRY = iNDUSTRY;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getPOSITION() {
		return POSITION;
	}

	public void setPOSITION(String pOSITION) {
		POSITION = pOSITION;
	}

	public String getIS_OWNER() {
		return IS_OWNER;
	}

	public void setIS_OWNER(String iS_OWNER) {
		IS_OWNER = iS_OWNER;
	}

	public String getIS_SELF_EMPLOYED() {
		return IS_SELF_EMPLOYED;
	}

	public void setIS_SELF_EMPLOYED(String iS_SELF_EMPLOYED) {
		IS_SELF_EMPLOYED = iS_SELF_EMPLOYED;
	}

	public String getBUSINESS_LICENCE_NO() {
		return BUSINESS_LICENCE_NO;
	}

	public void setBUSINESS_LICENCE_NO(String bUSINESS_LICENCE_NO) {
		BUSINESS_LICENCE_NO = bUSINESS_LICENCE_NO;
	}

	public String getORGANIZATION_CODE() {
		return ORGANIZATION_CODE;
	}

	public void setORGANIZATION_CODE(String oRGANIZATION_CODE) {
		ORGANIZATION_CODE = oRGANIZATION_CODE;
	}

	public Date getESTABLISH_DATE() {
		return ESTABLISH_DATE;
	}

	public void setESTABLISH_DATE(Date eSTABLISH_DATE) {
		ESTABLISH_DATE = eSTABLISH_DATE;
	}

	public Double getYEARLY_PROFIT_OR_LOSS() {
		return YEARLY_PROFIT_OR_LOSS;
	}

	public void setYEARLY_PROFIT_OR_LOSS(Double yEARLY_PROFIT_OR_LOSS) {
		YEARLY_PROFIT_OR_LOSS = yEARLY_PROFIT_OR_LOSS;
	}

	public Integer getEMPLOYEE_AMOUNT() {
		return EMPLOYEE_AMOUNT;
	}

	public void setEMPLOYEE_AMOUNT(Integer eMPLOYEE_AMOUNT) {
		EMPLOYEE_AMOUNT = eMPLOYEE_AMOUNT;
	}

	public String getBUSINESS_PLACE() {
		return BUSINESS_PLACE;
	}

	public void setBUSINESS_PLACE(String bUSINESS_PLACE) {
		BUSINESS_PLACE = bUSINESS_PLACE;
	}

	public Double getCONT_OR_RENT_AMOUNT() {
		return CONT_OR_RENT_AMOUNT;
	}

	public void setCONT_OR_RENT_AMOUNT(Double cONT_OR_RENT_AMOUNT) {
		CONT_OR_RENT_AMOUNT = cONT_OR_RENT_AMOUNT;
	}

	public Double getBASE_SALARY() {
		return BASE_SALARY;
	}

	public void setBASE_SALARY(Double bASE_SALARY) {
		BASE_SALARY = bASE_SALARY;
	}

	public Double getOTHER_INCOME() {
		return OTHER_INCOME;
	}

	public void setOTHER_INCOME(Double oTHER_INCOME) {
		OTHER_INCOME = oTHER_INCOME;
	}

	public Double getMONTHLY_TOTAL_INCOME() {
		return MONTHLY_TOTAL_INCOME;
	}

	public void setMONTHLY_TOTAL_INCOME(Double mONTHLY_TOTAL_INCOME) {
		MONTHLY_TOTAL_INCOME = mONTHLY_TOTAL_INCOME;
	}

	public String getPAY_PATTERN() {
		return PAY_PATTERN;
	}

	public void setPAY_PATTERN(String pAY_PATTERN) {
		PAY_PATTERN = pAY_PATTERN;
	}

	public Integer getPAY_TIME_ONE() {
		return PAY_TIME_ONE;
	}

	public void setPAY_TIME_ONE(Integer pAY_TIME_ONE) {
		PAY_TIME_ONE = pAY_TIME_ONE;
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
