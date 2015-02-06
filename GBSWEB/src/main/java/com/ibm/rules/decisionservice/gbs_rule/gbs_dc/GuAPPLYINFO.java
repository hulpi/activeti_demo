
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for guAPPLYINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guAPPLYINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apply_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="apply_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approve_amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guCITYINFO" minOccurs="0"/>
 *         &lt;element name="ecm_barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enterprise" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guENTERPRISEINFO" minOccurs="0"/>
 *         &lt;element name="gu_apply_info_oid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="guarant_amt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="guarant_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarant_time_limit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="guarant_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individual" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALINFO" minOccurs="0"/>
 *         &lt;element name="loan_purpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="process_instance_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guPRODUCTINFO" minOccurs="0"/>
 *         &lt;element name="responseInfo" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}responseInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guAPPLYINFO", propOrder = {
    "applicant",
    "applyDate",
    "applyStatus",
    "approveAmt",
    "city",
    "ecmBarcode",
    "enterprise",
    "guApplyInfoOid",
    "guarantAmt",
    "guarantId",
    "guarantTimeLimit",
    "guarantType",
    "individual",
    "loanPurpose",
    "processInstanceId",
    "product",
    "responseInfo"
})
public class GuAPPLYINFO {

    protected String applicant;
    @XmlElement(name = "apply_date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applyDate;
    @XmlElement(name = "apply_status")
    protected String applyStatus;
    @XmlElement(name = "approve_amt")
    protected BigDecimal approveAmt;
    protected GuCITYINFO city;
    @XmlElement(name = "ecm_barcode")
    protected String ecmBarcode;
    protected GuENTERPRISEINFO enterprise;
    @XmlElement(name = "gu_apply_info_oid")
    protected Long guApplyInfoOid;
    @XmlElement(name = "guarant_amt")
    protected BigDecimal guarantAmt;
    @XmlElement(name = "guarant_id")
    protected String guarantId;
    @XmlElement(name = "guarant_time_limit")
    protected Long guarantTimeLimit;
    @XmlElement(name = "guarant_type")
    protected String guarantType;
    protected GuINDIVIDUALINFO individual;
    @XmlElement(name = "loan_purpose")
    protected String loanPurpose;
    @XmlElement(name = "process_instance_id")
    protected String processInstanceId;
    protected GuPRODUCTINFO product;
    protected ResponseInfo responseInfo;

    /**
     * Gets the value of the applicant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicant() {
        return applicant;
    }

    /**
     * Sets the value of the applicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicant(String value) {
        this.applicant = value;
    }

    /**
     * Gets the value of the applyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplyDate() {
        return applyDate;
    }

    /**
     * Sets the value of the applyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplyDate(XMLGregorianCalendar value) {
        this.applyDate = value;
    }

    /**
     * Gets the value of the applyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /**
     * Sets the value of the applyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyStatus(String value) {
        this.applyStatus = value;
    }

    /**
     * Gets the value of the approveAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getApproveAmt() {
        return approveAmt;
    }

    /**
     * Sets the value of the approveAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setApproveAmt(BigDecimal value) {
        this.approveAmt = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link GuCITYINFO }
     *     
     */
    public GuCITYINFO getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuCITYINFO }
     *     
     */
    public void setCity(GuCITYINFO value) {
        this.city = value;
    }

    /**
     * Gets the value of the ecmBarcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcmBarcode() {
        return ecmBarcode;
    }

    /**
     * Sets the value of the ecmBarcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcmBarcode(String value) {
        this.ecmBarcode = value;
    }

    /**
     * Gets the value of the enterprise property.
     * 
     * @return
     *     possible object is
     *     {@link GuENTERPRISEINFO }
     *     
     */
    public GuENTERPRISEINFO getEnterprise() {
        return enterprise;
    }

    /**
     * Sets the value of the enterprise property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuENTERPRISEINFO }
     *     
     */
    public void setEnterprise(GuENTERPRISEINFO value) {
        this.enterprise = value;
    }

    /**
     * Gets the value of the guApplyInfoOid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGuApplyInfoOid() {
        return guApplyInfoOid;
    }

    /**
     * Sets the value of the guApplyInfoOid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGuApplyInfoOid(Long value) {
        this.guApplyInfoOid = value;
    }

    /**
     * Gets the value of the guarantAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGuarantAmt() {
        return guarantAmt;
    }

    /**
     * Sets the value of the guarantAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGuarantAmt(BigDecimal value) {
        this.guarantAmt = value;
    }

    /**
     * Gets the value of the guarantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuarantId() {
        return guarantId;
    }

    /**
     * Sets the value of the guarantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuarantId(String value) {
        this.guarantId = value;
    }

    /**
     * Gets the value of the guarantTimeLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGuarantTimeLimit() {
        return guarantTimeLimit;
    }

    /**
     * Sets the value of the guarantTimeLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGuarantTimeLimit(Long value) {
        this.guarantTimeLimit = value;
    }

    /**
     * Gets the value of the guarantType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuarantType() {
        return guarantType;
    }

    /**
     * Sets the value of the guarantType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuarantType(String value) {
        this.guarantType = value;
    }

    /**
     * Gets the value of the individual property.
     * 
     * @return
     *     possible object is
     *     {@link GuINDIVIDUALINFO }
     *     
     */
    public GuINDIVIDUALINFO getIndividual() {
        return individual;
    }

    /**
     * Sets the value of the individual property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuINDIVIDUALINFO }
     *     
     */
    public void setIndividual(GuINDIVIDUALINFO value) {
        this.individual = value;
    }

    /**
     * Gets the value of the loanPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanPurpose() {
        return loanPurpose;
    }

    /**
     * Sets the value of the loanPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanPurpose(String value) {
        this.loanPurpose = value;
    }

    /**
     * Gets the value of the processInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * Sets the value of the processInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstanceId(String value) {
        this.processInstanceId = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link GuPRODUCTINFO }
     *     
     */
    public GuPRODUCTINFO getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuPRODUCTINFO }
     *     
     */
    public void setProduct(GuPRODUCTINFO value) {
        this.product = value;
    }

    /**
     * Gets the value of the responseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseInfo }
     *     
     */
    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    /**
     * Sets the value of the responseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseInfo }
     *     
     */
    public void setResponseInfo(ResponseInfo value) {
        this.responseInfo = value;
    }

}
