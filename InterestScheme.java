/*
 * InterestScheme.java
 *
 * Created on Nov 12, 2009, 10:34:23 AM
 *
 * Copyright (c) 2009 Tai Fook Securities Group Limited.
 * All rights reserved.
 *
 * This file contains the valuable properties of Tai Fook Securities
 * Group Limited, embodying substantial creative efforts and confidential
 * information, ideas and expressions. No part of this file may be
 * reproduced or distributed in any form or by any means, or stored
 * in a data base or a retrieval system, without the prior written
 * permission of Tai Fook Securities Group Limited.
 */
package com.taifook.mtss.mss.interest.model.master;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.taifook.mtss.framework.app.model.TopVersionedModel;
import com.taifook.mtss.mss.common.model.ModelConstants;

/**
 * @author Sean Chan
 *
 */
@Entity
@Table(name="MC_INTSCH",
       uniqueConstraints={
            @UniqueConstraint(columnNames={"INTSCH_CDE"})
       }
)
@GenericGenerator(
    name="seqInterestScheme",
    strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters={
        @Parameter(name="sequence_name", value="intsch_seq"),
        @Parameter (name="increment_size", value=ModelConstants.SEQUENCE_INCREMENT_SIZE )
    }
)
public class InterestScheme extends TopVersionedModel<InterestScheme, Long, InterestSchemeVersion, Long> {
 
	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2259885172739010808L;

    /**
	 * id
	 */
    @Id
    @GeneratedValue(generator="seqInterestScheme", strategy=GenerationType.SEQUENCE)
    @Column(name="INTSCH_ID")
    private Long id;
	 
	/**
	 * companyCode
	 */
    @Column(name="CMPNY_CDE")
    private String companyCode;
	 
	/**
	 * interestSchemeCode
	 */
    @Column(name="INTSCH_CDE")
    private String interestSchemeCode;
	 
	/**
	 * interestSchemeType
	 */
    @Column(name="INTSCH_TYP_CDE")
    @Enumerated(value = EnumType.STRING)
    private InterestSchemeType interestSchemeType;
	 
	/**
	 * interestSchemeDescription
	 */
    @Column(name="INTSCH_DESCR")
    private String interestSchemeDescription;
	 
	/**
	 * minimumCreditInterestRate
	 */
    @Column(name="MIN_CR_INT_RATE")
    private BigDecimal minimumCreditInterestRate;
	 
	/**
	 * normalSlidingType
	 */
    @Column(name="NRML_INTSCH_RULE_STYP_CDE")
    @Enumerated(value = EnumType.STRING)
    private InterestSlidingType normalSlidingType;
	 
	/**
	 * minimumDebitCcyCode
	 */
    @Column(name="MIN_DR_CCY_CDE")
    private String minimumDebitCcyCode;
	 
	/**
	 * minimumDebitAmount
	 */
    @Column(name="MIN_DR_INT_AMT")
    private BigDecimal minimumDebitAmount;
	 
	/**
	 * cat1SlidingType
	 */
    @Column(name="CAT1_INTSCH_RULE_STYP_CDE")
    @Enumerated(value = EnumType.STRING)
    private InterestSlidingType cat1SlidingType;
	 
	/**
	 * cat2SlidingType
	 */
    @Column(name="CAT2_INTSCH_RULE_STYP_CDE")
    @Enumerated(value = EnumType.STRING)
    private InterestSlidingType cat2SlidingType;
	 
	/**
	 * cat3SlidingType
	 */
    @Column(name="CAT3_INTSCH_RULE_STYP_CDE")
    @Enumerated(value = EnumType.STRING)
    private InterestSlidingType cat3SlidingType;
	 
	/**
	 * cat1SecuritiesGroupId
	 */
    @Column(name="CAT1_SEC_GRP_ID")
    private Long cat1SecuritiesGroupId;
	 
	/**
	 * cat2SecuritiesGroupId
	 */
    @Column(name="CAT2_SEC_GRP_ID")
    private Long cat2SecuritiesGroupId;
	 
	/**
	 * cat3SecuritiesGroupId
	 */
    @Column(name="CAT3_SEC_GRP_ID")
    private Long cat3SecuritiesGroupId;
	 
	/**
	 * lastCompanyInputDate
	 */
    @Column(name="LAST_CMPNY_INPT_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastCompanyInputDate;
	 
	/**
	 * interestSchemeRule list
	 */
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="INTSCH_ID")
	private List<InterestSchemeRule> interestSchemeRules = new ArrayList<InterestSchemeRule>();
	 
	/**
	 * interestSchemeMarginCallChargeRule list
	 */
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="INTSCH_ID")
    private List<InterestSchemeMarginCallChargeRule> interestSchemeMarginCallChargeRules = new ArrayList<InterestSchemeMarginCallChargeRule>();

    /**
     * Get the id
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the companyCode
     * 
     * @return companyCode
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * Set the companyCode
     * 
     * @param companyCode
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * Get the interestSchemeCode
     * 
     * @return interestSchemeCode
     */
    public String getInterestSchemeCode() {
        return interestSchemeCode;
    }

    /**
     * Set the interestSchemeCode
     * 
     * @param interestSchemeCode
     */
    public void setInterestSchemeCode(String interestSchemeCode) {
        this.interestSchemeCode = interestSchemeCode;
    }

    /**
     * Get the interestSchemeType
     * 
     * @return interestSchemeType
     */
    public InterestSchemeType getInterestSchemeType() {
        return interestSchemeType;
    }

    /**
     * Set the interestSchemeType
     * 
     * @param interestSchemeType
     */
    public void setInterestSchemeType(InterestSchemeType interestSchemeType) {
        this.interestSchemeType = interestSchemeType;
    }

    /**
     * Get the interestSchemeDescription
     * 
     * @return interestSchemeDescription
     */
    public String getInterestSchemeDescription() {
        return interestSchemeDescription;
    }

    /**
     * Set the interestSchemeDescription
     * 
     * @param interestSchemeDescription
     */
    public void setInterestSchemeDescription(String interestSchemeDescription) {
        this.interestSchemeDescription = interestSchemeDescription;
    }

    /**
     * Get the minimumCreditInterestRate
     * 
     * @return minimumCreditInterestRate
     */
    public BigDecimal getMinimumCreditInterestRate() {
        return minimumCreditInterestRate;
    }

    /**
     * Set the minimumCreditInterestRate
     * 
     * @param minimumCreditInterestRate
     */
    public void setMinimumCreditInterestRate(BigDecimal minimumCreditInterestRate) {
        this.minimumCreditInterestRate = minimumCreditInterestRate;
    }

    /**
     * Get the normalSlidingType
     * 
     * @return normalSlidingType
     */
    public InterestSlidingType getNormalSlidingType() {
        return normalSlidingType;
    }

    /**
     * Set the normalSlidingType
     * 
     * @param normalSlidingType
     */
    public void setNormalSlidingType(InterestSlidingType normalSlidingType) {
        this.normalSlidingType = normalSlidingType;
    }

    /**
     * Get the minimumDebitCcyCode
     * 
     * @return minimumDebitCcyCode
     */
    public String getMinimumDebitCcyCode() {
        return minimumDebitCcyCode;
    }

    /**
     * Set the minimumDebitCcyCode
     * 
     * @param minimumDebitCcyCode
     */
    public void setMinimumDebitCcyCode(String minimumDebitCcyCode) {
        this.minimumDebitCcyCode = minimumDebitCcyCode;
    }

    /**
     * Get the minimumDebitAmount
     * 
     * @return minimumDebitAmount
     */
    public BigDecimal getMinimumDebitAmount() {
        return minimumDebitAmount;
    }

    /**
     * Set the minimumDebitAmount
     * 
     * @param minimumDebitAmount
     */
    public void setMinimumDebitAmount(BigDecimal minimumDebitAmount) {
        this.minimumDebitAmount = minimumDebitAmount;
    }

    /**
     * Get the cat1SlidingType
     * 
     * @return cat1SlidingType
     */
    public InterestSlidingType getCat1SlidingType() {
        return cat1SlidingType;
    }

    /**
     * Set the cat1SlidingType
     * 
     * @param cat1SlidingType
     */
    public void setCat1SlidingType(InterestSlidingType cat1SlidingType) {
        this.cat1SlidingType = cat1SlidingType;
    }

    /**
     * Get the cat2SlidingType
     * 
     * @return cat2SlidingType
     */
    public InterestSlidingType getCat2SlidingType() {
        return cat2SlidingType;
    }

    /**
     * Set the cat2SlidingType
     * 
     * @param cat2SlidingType
     */
    public void setCat2SlidingType(InterestSlidingType cat2SlidingType) {
        this.cat2SlidingType = cat2SlidingType;
    }

    /**
     * Get the cat3SlidingType
     * 
     * @return cat3SlidingType
     */
    public InterestSlidingType getCat3SlidingType() {
        return cat3SlidingType;
    }

    /**
     * Set the cat3SlidingType
     * 
     * @param cat3SlidingType
     */
    public void setCat3SlidingType(InterestSlidingType cat3SlidingType) {
        this.cat3SlidingType = cat3SlidingType;
    }

    /**
     * Get the cat1SecuritiesGroupId
     * 
     * @return cat1SecuritiesGroupId
     */
    public Long getCat1SecuritiesGroupId() {
        return cat1SecuritiesGroupId;
    }

    /**
     * Set the cat1SecuritiesGroupId
     * 
     * @param cat1SecuritiesGroupId
     */
    public void setCat1SecuritiesGroupId(Long cat1SecuritiesGroupId) {
        this.cat1SecuritiesGroupId = cat1SecuritiesGroupId;
    }

    /**
     * Get the cat2SecuritiesGroupId
     * 
     * @return cat2SecuritiesGroupId
     */
    public Long getCat2SecuritiesGroupId() {
        return cat2SecuritiesGroupId;
    }

    /**
     * Set the cat2SecuritiesGroupId
     * 
     * @param cat2SecuritiesGroupId
     */
    public void setCat2SecuritiesGroupId(Long cat2SecuritiesGroupId) {
        this.cat2SecuritiesGroupId = cat2SecuritiesGroupId;
    }

    /**
     * Get the cat3SecuritiesGroupId
     * 
     * @return cat3SecuritiesGroupId
     */
    public Long getCat3SecuritiesGroupId() {
        return cat3SecuritiesGroupId;
    }

    /**
     * Set the cat3SecuritiesGroupId
     * 
     * @param cat3SecuritiesGroupId
     */
    public void setCat3SecuritiesGroupId(Long cat3SecuritiesGroupId) {
        this.cat3SecuritiesGroupId = cat3SecuritiesGroupId;
    }

    /**
     * Get the lastCompanyInputDate
     * 
     * @return lastCompanyInputDate
     */
    public Date getLastCompanyInputDate() {
        return lastCompanyInputDate;
    }

    /**
     * Set the lastCompanyInputDate
     * 
     * @param lastCompanyInputDate
     */
    public void setLastCompanyInputDate(Date lastCompanyInputDate) {
        this.lastCompanyInputDate = lastCompanyInputDate;
    }

    /**
     * Get the interestSchemeRules
     * 
     * @return interestSchemeRules
     */
    public List<InterestSchemeRule> getInterestSchemeRules() {
        return interestSchemeRules;
    }

    /**
     * Set the interestSchemeRules
     * 
     * @param interestSchemeRules
     */
    public void setInterestSchemeRules(List<InterestSchemeRule> interestSchemeRules) {
        this.interestSchemeRules = interestSchemeRules;
    }

    /**
     * Get the interestSchemeMarginCallChargeRules
     * 
     * @return interestSchemeMarginCallChargeRules
     */
    public List<InterestSchemeMarginCallChargeRule> getInterestSchemeMarginCallChargeRules() {
        return interestSchemeMarginCallChargeRules;
    }

    /**
     * Set the interestSchemeMarginCallChargeRules
     * 
     * @param interestSchemeMarginCallChargeRules
     */
    public void setInterestSchemeMarginCallChargeRules(
            List<InterestSchemeMarginCallChargeRule> interestSchemeMarginCallChargeRules) {
        this.interestSchemeMarginCallChargeRules = interestSchemeMarginCallChargeRules;
    }

    @Override
    public Date getVersionDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeChild() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void copy(InterestSchemeVersion arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public InterestSchemeVersion createVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long getPk() {
        // TODO Auto-generated method stub
        return null;
    }
	 
}
 
