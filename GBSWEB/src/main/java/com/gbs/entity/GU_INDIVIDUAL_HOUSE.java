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
@Table(name = "GU_INDIVIDUAL_HOUSE")
public class GU_INDIVIDUAL_HOUSE {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_CUST_HOUSE_INFO_SEQ")
    private Long GU_INDIVIDUAL_HOUSE_OID;
	
	@Column(length = 8)
	private String CITY_CODE;
	
	@Column(length = 50)
	private String HS_ADDRESS_DETAIL;
	
	@Column(length = 1)
	private String BUY_PARTERN;
	
	@Column(length = 40)
	private String ESTATE_CERTIFICATE_NO;
	
	@Temporal(TemporalType.DATE)
	private Date BUY_TIME;
	
	@Column(length = 1)
	private String IS_SEARCHED;
	
	private Double BUY_PRICE;
	
	@Temporal(TemporalType.DATE)
	private Date SEARCH_DATE;
	
	@Column(length = 4)
	private String BUILT_YEAR;
	
	private Double FLOOR_AREA;
	
	private Double SEARCH_UNIT_PRICE;
	
	@Column(length = 35)
	private String MORTGAGE_BANK;
	
	private Integer LOAN_LIMIT_YEAR;
	
	
	private Long SEARCH_TOTAL_PRICE;
	
	private Double LOAN_TOTAL_AMOUNT;
	
	private Double BALANCE_DUE;
	
	
	private Integer MONTHLY_CONTRIBUTION;
	
	@Column(length = 2)
	private String ESTATE_PURPOSES;
	
	@Column(length = 2)
	private String PROPERTY_TYPE;
	
	@Column(length = 2)
	private String HOUSE_PROPERTY_TYPE;
	
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

	public Long getGU_INDIVIDUAL_HOUSE_OID() {
		return GU_INDIVIDUAL_HOUSE_OID;
	}

	public void setGU_INDIVIDUAL_HOUSE_OID(Long gU_INDIVIDUAL_HOUSE_OID) {
		GU_INDIVIDUAL_HOUSE_OID = gU_INDIVIDUAL_HOUSE_OID;
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

	public GU_INDIVIDUAL_INFO getIndividual() {
		return individual;
	}

	public void setIndividual(GU_INDIVIDUAL_INFO individual) {
		this.individual = individual;
	}
    
    
	
}
