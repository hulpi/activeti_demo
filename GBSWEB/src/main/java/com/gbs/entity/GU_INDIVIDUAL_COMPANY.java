package com.gbs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "GU_INDIVIDUAL_COMPANY")
public class GU_INDIVIDUAL_COMPANY {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_INDIVIDUAL_COMPANY_SEQ")
    private Long GU_INDIVIDUAL_COMPANY_OID;
	
	@ManyToOne(targetEntity=GU_INDIVIDUAL_INFO.class,fetch=FetchType.LAZY)
	@JoinColumn(name="individual_info")
	private GU_INDIVIDUAL_INFO individual_info ;
	
	@Column(length = 8)
	private String CITY_CODE;
	
	@Column(length = 50)
	private String COMPANY_NAME;
	
	@Column(length = 180)
	private String COM_ADDRESS_DETAIL;
	
	@Column(length = 15)
	private String COM_TEL_NUMBER;
	
	@Column(length = 15)
	private String FAX_NUMBER;
	
	private Double SERVICE_YEARS;
	
	@Column(length = 2)
	private String UNIT_KIND;
	
	@Column(length = 3)
	private String INDUSTRY;
	
	@Column(length = 30)
	private String DEPARTMENT;
	
	@Column(length = 35)
	private String POSITION;
	
	@Column(length = 1)
	private String IS_OWNER;
	
	@Column(length = 1)
	private String IS_SELF_EMPLOYED;
	
	@Column(length = 20)
	private String BUSINESS_LICENCE_NO;
	
	@Column(length = 20)
	private String ORGANIZATION_CODE;
	
	@Temporal(TemporalType.DATE)
	private Date ESTABLISH_DATE;
	
	private Double YEARLY_PROFIT_OR_LOSS;
	
	private Integer EMPLOYEE_AMOUNT;
	
	@Column(length = 20)
	private String BUSINESS_PLACE;
	
	private Double CONT_OR_RENT_AMOUNT;
		
	private Double BASE_SALARY;
	
	private Double OTHER_INCOME;
	
	private Double MONTHLY_TOTAL_INCOME;
	
	@Column(length = 2)
	private String PAY_PATTERN;
	
	@Column(length = 18)
	private Integer PAY_TIME_ONE;
	
	 @Column(length = 20)
    private String OPER_ID;
    
	@Temporal(TemporalType.TIME)
    private Date OPER_DATE;
    
    @Column(length = 20)
    private String MODIFY_ID;
    
    @Temporal(TemporalType.TIME)
    private Date MODIFY_DATE;

    @ManyToOne(targetEntity=GU_INDIVIDUAL_INFO.class,fetch=FetchType.LAZY)
  	@JoinColumn(name="individual")
    private GU_INDIVIDUAL_INFO individual;

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

	public GU_INDIVIDUAL_INFO getIndividual_info() {
		return individual_info;
	}

	public void setIndividual_info(GU_INDIVIDUAL_INFO individual_info) {
		this.individual_info = individual_info;
	}

	public GU_INDIVIDUAL_INFO getIndividual() {
		return individual;
	}

	public void setIndividual(GU_INDIVIDUAL_INFO individual) {
		this.individual = individual;
	}
	
}
