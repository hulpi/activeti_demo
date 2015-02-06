
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for guENTERPRISEBUSINESS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guENTERPRISEBUSINESS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enterprise" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guENTERPRISEINFO" minOccurs="0"/>
 *         &lt;element name="GU_ENTERPRISE_BUSINESS_OID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MODIFY_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODIFY_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROFIT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="REMARK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SALES_INCOME" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TAX_AMT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="YEAR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guENTERPRISEBUSINESS", propOrder = {
    "enterprise",
    "guenterprisebusinessoid",
    "modifyid",
    "modifytime",
    "operdate",
    "operid",
    "profit",
    "remark",
    "salesincome",
    "taxamt",
    "year"
})
public class GuENTERPRISEBUSINESS {

    protected GuENTERPRISEINFO enterprise;
    @XmlElement(name = "GU_ENTERPRISE_BUSINESS_OID")
    protected Long guenterprisebusinessoid;
    @XmlElement(name = "MODIFY_ID")
    protected String modifyid;
    @XmlElement(name = "MODIFY_TIME")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifytime;
    @XmlElement(name = "OPER_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operdate;
    @XmlElement(name = "OPER_ID")
    protected String operid;
    @XmlElement(name = "PROFIT")
    protected double profit;
    @XmlElement(name = "REMARK")
    protected String remark;
    @XmlElement(name = "SALES_INCOME")
    protected double salesincome;
    @XmlElement(name = "TAX_AMT")
    protected double taxamt;
    @XmlElement(name = "YEAR")
    protected int year;

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
     * Gets the value of the guenterprisebusinessoid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGUENTERPRISEBUSINESSOID() {
        return guenterprisebusinessoid;
    }

    /**
     * Sets the value of the guenterprisebusinessoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGUENTERPRISEBUSINESSOID(Long value) {
        this.guenterprisebusinessoid = value;
    }

    /**
     * Gets the value of the modifyid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODIFYID() {
        return modifyid;
    }

    /**
     * Sets the value of the modifyid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODIFYID(String value) {
        this.modifyid = value;
    }

    /**
     * Gets the value of the modifytime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMODIFYTIME() {
        return modifytime;
    }

    /**
     * Sets the value of the modifytime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMODIFYTIME(XMLGregorianCalendar value) {
        this.modifytime = value;
    }

    /**
     * Gets the value of the operdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOPERDATE() {
        return operdate;
    }

    /**
     * Sets the value of the operdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOPERDATE(XMLGregorianCalendar value) {
        this.operdate = value;
    }

    /**
     * Gets the value of the operid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERID() {
        return operid;
    }

    /**
     * Sets the value of the operid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERID(String value) {
        this.operid = value;
    }

    /**
     * Gets the value of the profit property.
     * 
     */
    public double getPROFIT() {
        return profit;
    }

    /**
     * Sets the value of the profit property.
     * 
     */
    public void setPROFIT(double value) {
        this.profit = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMARK() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMARK(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the salesincome property.
     * 
     */
    public double getSALESINCOME() {
        return salesincome;
    }

    /**
     * Sets the value of the salesincome property.
     * 
     */
    public void setSALESINCOME(double value) {
        this.salesincome = value;
    }

    /**
     * Gets the value of the taxamt property.
     * 
     */
    public double getTAXAMT() {
        return taxamt;
    }

    /**
     * Sets the value of the taxamt property.
     * 
     */
    public void setTAXAMT(double value) {
        this.taxamt = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYEAR() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYEAR(int value) {
        this.year = value;
    }

}
