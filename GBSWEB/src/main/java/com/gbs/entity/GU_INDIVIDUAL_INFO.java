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
@Table(name="GU_INDIVIDUAL_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_INDIVIDUAL_INFO{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_INDIVIDUAL_INFO_SEQ")
    private Long GU_INDIVIDUAL_INFO_OID;
    
	@OneToMany(targetEntity=GU_INDIVIDUAL_COMPANY.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="individual_company")
	private Set<GU_INDIVIDUAL_COMPANY> individual_company;
    
	@Column(length = 18,nullable=false)	
    private String CERT_NO;
	
	@Column(length = 2)
    private String CERT_TYPE;
	
	@Column(length = 10)
    private String CUST_NAME;
	 
	@Temporal(TemporalType.DATE)
    private Date BIRTHDAY;
    
    @Column(length = 1)
    private String SEX;
    
    @Column(length = 10)
    private String EDUCATION_LEVEL;
    
    @Column(length = 16)
    private String NATIVE_PLACE;
    
    @Column(length = 50)
    private String HUKOU_ADD;
    
    @Column(length = 50)
    private String ID_CARD_ADDRESS_DETAIL;
    
    @Temporal(TemporalType.DATE)
    private Date ID_CARD_VALIDITY_FROM;
    
    @Temporal(TemporalType.DATE)
    private Date ID_CARD_VALIDITY_TO;
      
    private Integer ID_CARD_VALIDITY_PERIOD;
 
    @Column(length = 50)
    private String ADDRESS_DETAIL;
    
    @Column(length = 20)
    private String OPER_ID;
    
    @Temporal(TemporalType.TIME)
    private Date OPER_DATE;
    
    @Column(length = 20)
    private String MODIFY_ID;
    
    @Temporal(TemporalType.TIME)
    private Date MODIFY_DATE;
    
	@OneToMany(targetEntity=GU_INDIVIDUAL_HOUSE.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="individual")
    private Set<GU_INDIVIDUAL_HOUSE> individualHouseSet;

    @OneToMany(targetEntity=GU_INDIVIDUAL_COMPANY.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="individual")
    private Set<GU_INDIVIDUAL_COMPANY> individualCompanySet;
    
    @OneToMany(targetEntity=GU_INDIVIDUAL_LINKMAN.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  	@JoinColumn(name="individual")
    private Set<GU_INDIVIDUAL_LINKMAN> individualLinkmanSet;

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

	public Set<GU_INDIVIDUAL_COMPANY> getIndividual_company() {
		return individual_company;
	}

	public void setIndividual_company(Set<GU_INDIVIDUAL_COMPANY> individual_company) {
		this.individual_company = individual_company;
	}

	public Set<GU_INDIVIDUAL_HOUSE> getIndividualHouseSet() {
		return individualHouseSet;
	}

	public void setIndividualHouseSet(Set<GU_INDIVIDUAL_HOUSE> individualHouseSet) {
		this.individualHouseSet = individualHouseSet;
	}

	public Set<GU_INDIVIDUAL_COMPANY> getIndividualCompanySet() {
		return individualCompanySet;
	}

	public void setIndividualCompanySet(
			Set<GU_INDIVIDUAL_COMPANY> individualCompanySet) {
		this.individualCompanySet = individualCompanySet;
	}

	public Set<GU_INDIVIDUAL_LINKMAN> getIndividualLinkmanSet() {
		return individualLinkmanSet;
	}

	public void setIndividualLinkmanSet(
			Set<GU_INDIVIDUAL_LINKMAN> individualLinkmanSet) {
		this.individualLinkmanSet = individualLinkmanSet;
	}

	
    
}
