package com.gbs.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="GU_ENTERPRISE_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_ENTERPRISE_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_ENTERPRISE_INFO_SEQ")
    private Long GU_ENTERPRISE_INFO_OID;
    
	@Column(length = 50)
	private String ENTERPRISE_NAME;
	
	@Column(length = 20)
	private String LEGAL_PERSON;
	
	@Column(length = 30,nullable=false)
	private String REGISER_NO;//企业登记注册号
	
	@Column(length = 50)
	private String ENTERPRISE_ADDRESS;
	
	@Column(length = 15)
	private String TEL_PHONE;
	
	@Column(length = 5)
	private String ENTERPRISE_TYPE;
	
	private int  EMPLOYEE_NUMBER;
	private int  TECHNICAL_NUMBER;

	@Column(length = 20)
	private String RELATIONSHIP;
	
	@Column(length = 3)
	private String BANK_CREDIT_LEVEL;
	
	@Column(length = 1)
	private String IS_TECH_CENTER;
	
	private double TOTAL_ASSETS;
	
	private double FIXED_ASSETS;
	
	private double NET_FIXED_ASSETS;
	
	private double ASSETS_LIAB_RATIO;
	
	private double ENTERPRISE_LOAN_AMT;
	
	private double MEDIUM_LOAN_AMT;
	
	private double SHORT_LOAN_AMT;
	@Column(length=100)
	private String ENTERPRISE_DESC;
	
	@Column(length = 15)	
	private String OPER_ID;
	
	@Temporal(TemporalType.TIME)
	private Date OPER_DATE;
	
	@Column(length = 15)	
	private String MODIFY_ID;
	
	@Temporal(TemporalType.TIME)
	private Date MODIFY_TIME;
	@OneToMany(targetEntity = GU_ENTERPRISE_BUSINESS.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "enterprise")
	private Set<GU_ENTERPRISE_BUSINESS> enterpriseSet;

	public Long getGU_ENTERPRISE_INFO_OID() {
		return GU_ENTERPRISE_INFO_OID;
	}

	public void setGU_ENTERPRISE_INFO_OID(Long gU_ENTERPRISE_INFO_OID) {
		GU_ENTERPRISE_INFO_OID = gU_ENTERPRISE_INFO_OID;
	}

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

	public String getREGISER_NO() {
		return REGISER_NO;
	}

	public void setREGISER_NO(String rEGISER_NO) {
		REGISER_NO = rEGISER_NO;
	}

	public Set<GU_ENTERPRISE_BUSINESS> getEnterpriseSet() {
		return enterpriseSet;
	}

	public void setEnterpriseSet(Set<GU_ENTERPRISE_BUSINESS> enterpriseSet) {
		this.enterpriseSet = enterpriseSet;
	}



   
	

}
