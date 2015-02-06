
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for guINDIVIDUALHOUSE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guINDIVIDUALHOUSE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BALANCE_DUE" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BUILT_YEAR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUY_PARTERN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUY_PRICE" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BUY_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CITY_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ESTATE_CERTIFICATE_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ESTATE_PURPOSES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FLOOR_AREA" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="GU_INDIVIDUAL_HOUSE_OID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="HOUSE_PROPERTY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HS_ADDRESS_DETAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IS_SEARCHED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individual" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALINFO" minOccurs="0"/>
 *         &lt;element name="LOAN_LIMIT_YEAR" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LOAN_TOTAL_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="MODIFY_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MODIFY_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTHLY_CONTRIBUTION" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MORTGAGE_BANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OPER_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROPERTY_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEARCH_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SEARCH_TOTAL_PRICE" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SEARCH_UNIT_PRICE" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guINDIVIDUALHOUSE", propOrder = {
    "balancedue",
    "builtyear",
    "buypartern",
    "buyprice",
    "buytime",
    "citycode",
    "estatecertificateno",
    "estatepurposes",
    "floorarea",
    "guindividualhouseoid",
    "housepropertytype",
    "hsaddressdetail",
    "issearched",
    "individual",
    "loanlimityear",
    "loantotalamount",
    "modifydate",
    "modifyid",
    "monthlycontribution",
    "mortgagebank",
    "operdate",
    "operid",
    "propertytype",
    "searchdate",
    "searchtotalprice",
    "searchunitprice"
})
public class GuINDIVIDUALHOUSE {

    @XmlElement(name = "BALANCE_DUE")
    protected Double balancedue;
    @XmlElement(name = "BUILT_YEAR")
    protected String builtyear;
    @XmlElement(name = "BUY_PARTERN")
    protected String buypartern;
    @XmlElement(name = "BUY_PRICE")
    protected Double buyprice;
    @XmlElement(name = "BUY_TIME")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar buytime;
    @XmlElement(name = "CITY_CODE")
    protected String citycode;
    @XmlElement(name = "ESTATE_CERTIFICATE_NO")
    protected String estatecertificateno;
    @XmlElement(name = "ESTATE_PURPOSES")
    protected String estatepurposes;
    @XmlElement(name = "FLOOR_AREA")
    protected Double floorarea;
    @XmlElement(name = "GU_INDIVIDUAL_HOUSE_OID")
    protected Long guindividualhouseoid;
    @XmlElement(name = "HOUSE_PROPERTY_TYPE")
    protected String housepropertytype;
    @XmlElement(name = "HS_ADDRESS_DETAIL")
    protected String hsaddressdetail;
    @XmlElement(name = "IS_SEARCHED")
    protected String issearched;
    protected GuINDIVIDUALINFO individual;
    @XmlElement(name = "LOAN_LIMIT_YEAR")
    protected Integer loanlimityear;
    @XmlElement(name = "LOAN_TOTAL_AMOUNT")
    protected Double loantotalamount;
    @XmlElement(name = "MODIFY_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifydate;
    @XmlElement(name = "MODIFY_ID")
    protected String modifyid;
    @XmlElement(name = "MONTHLY_CONTRIBUTION")
    protected Integer monthlycontribution;
    @XmlElement(name = "MORTGAGE_BANK")
    protected String mortgagebank;
    @XmlElement(name = "OPER_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operdate;
    @XmlElement(name = "OPER_ID")
    protected String operid;
    @XmlElement(name = "PROPERTY_TYPE")
    protected String propertytype;
    @XmlElement(name = "SEARCH_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar searchdate;
    @XmlElement(name = "SEARCH_TOTAL_PRICE")
    protected Long searchtotalprice;
    @XmlElement(name = "SEARCH_UNIT_PRICE")
    protected Double searchunitprice;

    /**
     * Gets the value of the balancedue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBALANCEDUE() {
        return balancedue;
    }

    /**
     * Sets the value of the balancedue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBALANCEDUE(Double value) {
        this.balancedue = value;
    }

    /**
     * Gets the value of the builtyear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUILTYEAR() {
        return builtyear;
    }

    /**
     * Sets the value of the builtyear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUILTYEAR(String value) {
        this.builtyear = value;
    }

    /**
     * Gets the value of the buypartern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUYPARTERN() {
        return buypartern;
    }

    /**
     * Sets the value of the buypartern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUYPARTERN(String value) {
        this.buypartern = value;
    }

    /**
     * Gets the value of the buyprice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBUYPRICE() {
        return buyprice;
    }

    /**
     * Sets the value of the buyprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBUYPRICE(Double value) {
        this.buyprice = value;
    }

    /**
     * Gets the value of the buytime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBUYTIME() {
        return buytime;
    }

    /**
     * Sets the value of the buytime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBUYTIME(XMLGregorianCalendar value) {
        this.buytime = value;
    }

    /**
     * Gets the value of the citycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCITYCODE() {
        return citycode;
    }

    /**
     * Sets the value of the citycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCITYCODE(String value) {
        this.citycode = value;
    }

    /**
     * Gets the value of the estatecertificateno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESTATECERTIFICATENO() {
        return estatecertificateno;
    }

    /**
     * Sets the value of the estatecertificateno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESTATECERTIFICATENO(String value) {
        this.estatecertificateno = value;
    }

    /**
     * Gets the value of the estatepurposes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESTATEPURPOSES() {
        return estatepurposes;
    }

    /**
     * Sets the value of the estatepurposes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESTATEPURPOSES(String value) {
        this.estatepurposes = value;
    }

    /**
     * Gets the value of the floorarea property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFLOORAREA() {
        return floorarea;
    }

    /**
     * Sets the value of the floorarea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFLOORAREA(Double value) {
        this.floorarea = value;
    }

    /**
     * Gets the value of the guindividualhouseoid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGUINDIVIDUALHOUSEOID() {
        return guindividualhouseoid;
    }

    /**
     * Sets the value of the guindividualhouseoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGUINDIVIDUALHOUSEOID(Long value) {
        this.guindividualhouseoid = value;
    }

    /**
     * Gets the value of the housepropertytype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOUSEPROPERTYTYPE() {
        return housepropertytype;
    }

    /**
     * Sets the value of the housepropertytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOUSEPROPERTYTYPE(String value) {
        this.housepropertytype = value;
    }

    /**
     * Gets the value of the hsaddressdetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHSADDRESSDETAIL() {
        return hsaddressdetail;
    }

    /**
     * Sets the value of the hsaddressdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHSADDRESSDETAIL(String value) {
        this.hsaddressdetail = value;
    }

    /**
     * Gets the value of the issearched property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSEARCHED() {
        return issearched;
    }

    /**
     * Sets the value of the issearched property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSEARCHED(String value) {
        this.issearched = value;
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
     * Gets the value of the loanlimityear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLOANLIMITYEAR() {
        return loanlimityear;
    }

    /**
     * Sets the value of the loanlimityear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLOANLIMITYEAR(Integer value) {
        this.loanlimityear = value;
    }

    /**
     * Gets the value of the loantotalamount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLOANTOTALAMOUNT() {
        return loantotalamount;
    }

    /**
     * Sets the value of the loantotalamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLOANTOTALAMOUNT(Double value) {
        this.loantotalamount = value;
    }

    /**
     * Gets the value of the modifydate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMODIFYDATE() {
        return modifydate;
    }

    /**
     * Sets the value of the modifydate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMODIFYDATE(XMLGregorianCalendar value) {
        this.modifydate = value;
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
     * Gets the value of the monthlycontribution property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMONTHLYCONTRIBUTION() {
        return monthlycontribution;
    }

    /**
     * Sets the value of the monthlycontribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMONTHLYCONTRIBUTION(Integer value) {
        this.monthlycontribution = value;
    }

    /**
     * Gets the value of the mortgagebank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMORTGAGEBANK() {
        return mortgagebank;
    }

    /**
     * Sets the value of the mortgagebank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMORTGAGEBANK(String value) {
        this.mortgagebank = value;
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
     * Gets the value of the propertytype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROPERTYTYPE() {
        return propertytype;
    }

    /**
     * Sets the value of the propertytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROPERTYTYPE(String value) {
        this.propertytype = value;
    }

    /**
     * Gets the value of the searchdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSEARCHDATE() {
        return searchdate;
    }

    /**
     * Sets the value of the searchdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSEARCHDATE(XMLGregorianCalendar value) {
        this.searchdate = value;
    }

    /**
     * Gets the value of the searchtotalprice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSEARCHTOTALPRICE() {
        return searchtotalprice;
    }

    /**
     * Sets the value of the searchtotalprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSEARCHTOTALPRICE(Long value) {
        this.searchtotalprice = value;
    }

    /**
     * Gets the value of the searchunitprice property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSEARCHUNITPRICE() {
        return searchunitprice;
    }

    /**
     * Sets the value of the searchunitprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSEARCHUNITPRICE(Double value) {
        this.searchunitprice = value;
    }

}
