package com.gbs.dto;

public class EnterPraiseDTO {
   
	private String ENTERPRISE_NAME;//企业名字
	
	private String LEGAL_PERSON;//法人
	
	private String REGISER_NO;//企业登记注册号
	
	private String ENTERPRISE_ADDRESS;//企业地址
	
	public String getREGISER_NO() {
		return REGISER_NO;
	}

	public void setREGISER_NO(String rEGISER_NO) {
		REGISER_NO = rEGISER_NO;
	}

	private String TEL_PHONE;//企业电话
	
	private String ENTERPRISE_TYPE;//企业登记注册类型
	
	private int  EMPLOYEE_NUMBER;//职工人数
	private int  TECHNICAL_NUMBER;//技术人员

	private String RELATIONSHIP;//隶属关系
	
	private String BANK_CREDIT_LEVEL;//银行信用等级	
	private String IS_TECH_CENTER;//有无国家认定的技术中心
	
	private double TOTAL_ASSETS;//企业总资产
	
	private double FIXED_ASSETS;//固定资产原值
	
	private double NET_FIXED_ASSETS;//固定资产净值
	
	private double ASSETS_LIAB_RATIO;//资产负债率
	
	private double ENTERPRISE_LOAN_AMT;//企业贷款余额
	
	private double MEDIUM_LOAN_AMT;//中长期贷款余额
	
	private double SHORT_LOAN_AMT;//短期贷款余额
	
	private String ENTERPRISE_DESC;//企业描述
	
	private EnterpraiseBusinessModel enterpraiseBusinessModel;

	public String getENTERPRISE_NAME() {
		return ENTERPRISE_NAME;
	}

	public void setENTERPRISE_NAME(String eNTERPRISE_NAME) {
		ENTERPRISE_NAME = eNTERPRISE_NAME;
	}

	public String getLEGAL_PERSON() {
		return LEGAL_PERSON;
	}

	public void setLEGAL_PERSON(String lEGAL_PERSON) {
		LEGAL_PERSON = lEGAL_PERSON;
	}

	public String getENTERPRISE_ADDRESS() {
		return ENTERPRISE_ADDRESS;
	}

	public void setENTERPRISE_ADDRESS(String eNTERPRISE_ADDRESS) {
		ENTERPRISE_ADDRESS = eNTERPRISE_ADDRESS;
	}

	public String getTEL_PHONE() {
		return TEL_PHONE;
	}

	public void setTEL_PHONE(String tEL_PHONE) {
		TEL_PHONE = tEL_PHONE;
	}

	public String getENTERPRISE_TYPE() {
		return ENTERPRISE_TYPE;
	}

	public void setENTERPRISE_TYPE(String eNTERPRISE_TYPE) {
		ENTERPRISE_TYPE = eNTERPRISE_TYPE;
	}

	public int getEMPLOYEE_NUMBER() {
		return EMPLOYEE_NUMBER;
	}

	public void setEMPLOYEE_NUMBER(int eMPLOYEE_NUMBER) {
		EMPLOYEE_NUMBER = eMPLOYEE_NUMBER;
	}

	public int getTECHNICAL_NUMBER() {
		return TECHNICAL_NUMBER;
	}

	public void setTECHNICAL_NUMBER(int tECHNICAL_NUMBER) {
		TECHNICAL_NUMBER = tECHNICAL_NUMBER;
	}

	public String getRELATIONSHIP() {
		return RELATIONSHIP;
	}

	public void setRELATIONSHIP(String rELATIONSHIP) {
		RELATIONSHIP = rELATIONSHIP;
	}

	public String getBANK_CREDIT_LEVEL() {
		return BANK_CREDIT_LEVEL;
	}

	public void setBANK_CREDIT_LEVEL(String bANK_CREDIT_LEVEL) {
		BANK_CREDIT_LEVEL = bANK_CREDIT_LEVEL;
	}

	public String getIS_TECH_CENTER() {
		return IS_TECH_CENTER;
	}

	public void setIS_TECH_CENTER(String iS_TECH_CENTER) {
		IS_TECH_CENTER = iS_TECH_CENTER;
	}

	public double getTOTAL_ASSETS() {
		return TOTAL_ASSETS;
	}

	public void setTOTAL_ASSETS(double tOTAL_ASSETS) {
		TOTAL_ASSETS = tOTAL_ASSETS;
	}

	public double getFIXED_ASSETS() {
		return FIXED_ASSETS;
	}

	public void setFIXED_ASSETS(double fIXED_ASSETS) {
		FIXED_ASSETS = fIXED_ASSETS;
	}

	public double getNET_FIXED_ASSETS() {
		return NET_FIXED_ASSETS;
	}

	public void setNET_FIXED_ASSETS(double nET_FIXED_ASSETS) {
		NET_FIXED_ASSETS = nET_FIXED_ASSETS;
	}

	public double getASSETS_LIAB_RATIO() {
		return ASSETS_LIAB_RATIO;
	}

	public void setASSETS_LIAB_RATIO(double aSSETS_LIAB_RATIO) {
		ASSETS_LIAB_RATIO = aSSETS_LIAB_RATIO;
	}

	public double getENTERPRISE_LOAN_AMT() {
		return ENTERPRISE_LOAN_AMT;
	}

	public void setENTERPRISE_LOAN_AMT(double eNTERPRISE_LOAN_AMT) {
		ENTERPRISE_LOAN_AMT = eNTERPRISE_LOAN_AMT;
	}

	public double getMEDIUM_LOAN_AMT() {
		return MEDIUM_LOAN_AMT;
	}

	public void setMEDIUM_LOAN_AMT(double mEDIUM_LOAN_AMT) {
		MEDIUM_LOAN_AMT = mEDIUM_LOAN_AMT;
	}

	public double getSHORT_LOAN_AMT() {
		return SHORT_LOAN_AMT;
	}

	public void setSHORT_LOAN_AMT(double sHORT_LOAN_AMT) {
		SHORT_LOAN_AMT = sHORT_LOAN_AMT;
	}

	public String getENTERPRISE_DESC() {
		return ENTERPRISE_DESC;
	}

	public void setENTERPRISE_DESC(String eNTERPRISE_DESC) {
		ENTERPRISE_DESC = eNTERPRISE_DESC;
	}

	public EnterpraiseBusinessModel getEnterpraiseBusinessModel() {
		return enterpraiseBusinessModel;
	}

	public void setEnterpraiseBusinessModel(
			EnterpraiseBusinessModel enterpraiseBusinessModel) {
		this.enterpraiseBusinessModel = enterpraiseBusinessModel;
	}
	
}