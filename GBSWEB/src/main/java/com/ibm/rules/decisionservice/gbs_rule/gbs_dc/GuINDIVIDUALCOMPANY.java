
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for guINDIVIDUALCOMPANY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guINDIVIDUALCOMPANY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BASE_SALARY" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BUSINESS_LICENCE_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUSINESS_PLACE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPANY_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COM_ADDRESS_DETAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COM_TEL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONT_OR_RENT_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DEPARTMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMPLOYEE_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ESTABLISH_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FAX_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GU_INDIVIDUAL_COMPANY_OID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="INDUSTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IS_OWNER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IS_SELF_EMPLOYED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="individual" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALINFO" minOccurs="0"/>
 *         &lt;element name="individual_info" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALINFO" minOccurs="0"/>
 *         &lt;element name="MODIFY_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MODIFY_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTHLY_TOTAL_INCOME" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="OPER_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORGANIZATION_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHER_INCOME" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="PAY_PATTERN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAY_TIME_ONE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="POSITION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICE_YEARS" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="UNIT_KIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YEARLY_PROFIT_OR_LOSS" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guINDIVIDUALCOMPANY", propOrder = {
    "basesalary",
    "businesslicenceno",
    "businessplace",
    "citycode",
    "companyname",
    "comaddressdetail",
    "comtelnumber",
    "contorrentamount",
    "department",
    "employeeamount",
    "establishdate",
    "faxnumber",
    "guindividualcompanyoid",
    "industry",
    "isowner",
    "isselfemployed",
    "individual",
    "individualInfo",
    "modifydate",
    "modifyid",
    "monthlytotalincome",
    "operdate",
    "operid",
    "organizationcode",
    "otherincome",
    "paypattern",
    "paytimeone",
    "position",
    "serviceyears",
    "unitkind",
    "yearlyprofitorloss"
})
public class GuINDIVIDUALCOMPANY {

    @XmlElement(name = "BASE_SALARY")
    protected Double basesalary;
    @XmlElement(name = "BUSINESS_LICENCE_NO")
    protected String businesslicenceno;
    @XmlElement(name = "BUSINESS_PLACE")
    protected String businessplace;
    @XmlElement(name = "CITY_CODE")
    protected String citycode;
    @XmlElement(name = "COMPANY_NAME")
    protected String companyname;
    @XmlElement(name = "COM_ADDRESS_DETAIL")
    protected String comaddressdetail;
    @XmlElement(name = "COM_TEL_NUMBER")
    protected String comtelnumber;
    @XmlElement(name = "CONT_OR_RENT_AMOUNT")
    protected Double contorrentamount;
    @XmlElement(name = "DEPARTMENT")
    protected String department;
    @XmlElement(name = "EMPLOYEE_AMOUNT")
    protected Integer employeeamount;
    @XmlElement(name = "ESTABLISH_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar establishdate;
    @XmlElement(name = "FAX_NUMBER")
    protected String faxnumber;
    @XmlElement(name = "GU_INDIVIDUAL_COMPANY_OID")
    protected Long guindividualcompanyoid;
    @XmlElement(name = "INDUSTRY")
    protected String industry;
    @XmlElement(name = "IS_OWNER")
    protected String isowner;
    @XmlElement(name = "IS_SELF_EMPLOYED")
    protected String isselfemployed;
    protected GuINDIVIDUALINFO individual;
    @XmlElement(name = "individual_info")
    protected GuINDIVIDUALINFO individualInfo;
    @XmlElement(name = "MODIFY_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifydate;
    @XmlElement(name = "MODIFY_ID")
    protected String modifyid;
    @XmlElement(name = "MONTHLY_TOTAL_INCOME")
    protected Double monthlytotalincome;
    @XmlElement(name = "OPER_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operdate;
    @XmlElement(name = "OPER_ID")
    protected String operid;
    @XmlElement(name = "ORGANIZATION_CODE")
    protected String organizationcode;
    @XmlElement(name = "OTHER_INCOME")
    protected Double otherincome;
    @XmlElement(name = "PAY_PATTERN")
    protected String paypattern;
    @XmlElement(name = "PAY_TIME_ONE")
    protected Integer paytimeone;
    @XmlElement(name = "POSITION")
    protected String position;
    @XmlElement(name = "SERVICE_YEARS")
    protected Double serviceyears;
    @XmlElement(name = "UNIT_KIND")
    protected String unitkind;
    @XmlElement(name = "YEARLY_PROFIT_OR_LOSS")
    protected Double yearlyprofitorloss;

    /**
     * Gets the value of the basesalary property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBASESALARY() {
        return basesalary;
    }

    /**
     * Sets the value of the basesalary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBASESALARY(Double value) {
        this.basesalary = value;
    }

    /**
     * Gets the value of the businesslicenceno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSLICENCENO() {
        return businesslicenceno;
    }

    /**
     * Sets the value of the businesslicenceno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSLICENCENO(String value) {
        this.businesslicenceno = value;
    }

    /**
     * Gets the value of the businessplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSPLACE() {
        return businessplace;
    }

    /**
     * Sets the value of the businessplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSPLACE(String value) {
        this.businessplace = value;
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
     * Gets the value of the companyname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPANYNAME() {
        return companyname;
    }

    /**
     * Sets the value of the companyname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPANYNAME(String value) {
        this.companyname = value;
    }

    /**
     * Gets the value of the comaddressdetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMADDRESSDETAIL() {
        return comaddressdetail;
    }

    /**
     * Sets the value of the comaddressdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMADDRESSDETAIL(String value) {
        this.comaddressdetail = value;
    }

    /**
     * Gets the value of the comtelnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMTELNUMBER() {
        return comtelnumber;
    }

    /**
     * Sets the value of the comtelnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMTELNUMBER(String value) {
        this.comtelnumber = value;
    }

    /**
     * Gets the value of the contorrentamount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCONTORRENTAMOUNT() {
        return contorrentamount;
    }

    /**
     * Sets the value of the contorrentamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCONTORRENTAMOUNT(Double value) {
        this.contorrentamount = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPARTMENT() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPARTMENT(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the employeeamount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEMPLOYEEAMOUNT() {
        return employeeamount;
    }

    /**
     * Sets the value of the employeeamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEMPLOYEEAMOUNT(Integer value) {
        this.employeeamount = value;
    }

    /**
     * Gets the value of the establishdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getESTABLISHDATE() {
        return establishdate;
    }

    /**
     * Sets the value of the establishdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setESTABLISHDATE(XMLGregorianCalendar value) {
        this.establishdate = value;
    }

    /**
     * Gets the value of the faxnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAXNUMBER() {
        return faxnumber;
    }

    /**
     * Sets the value of the faxnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAXNUMBER(String value) {
        this.faxnumber = value;
    }

    /**
     * Gets the value of the guindividualcompanyoid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGUINDIVIDUALCOMPANYOID() {
        return guindividualcompanyoid;
    }

    /**
     * Sets the value of the guindividualcompanyoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGUINDIVIDUALCOMPANYOID(Long value) {
        this.guindividualcompanyoid = value;
    }

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINDUSTRY() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINDUSTRY(String value) {
        this.industry = value;
    }

    /**
     * Gets the value of the isowner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOWNER() {
        return isowner;
    }

    /**
     * Sets the value of the isowner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOWNER(String value) {
        this.isowner = value;
    }

    /**
     * Gets the value of the isselfemployed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSELFEMPLOYED() {
        return isselfemployed;
    }

    /**
     * Sets the value of the isselfemployed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSELFEMPLOYED(String value) {
        this.isselfemployed = value;
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
     * Gets the value of the individualInfo property.
     * 
     * @return
     *     possible object is
     *     {@link GuINDIVIDUALINFO }
     *     
     */
    public GuINDIVIDUALINFO getIndividualInfo() {
        return individualInfo;
    }

    /**
     * Sets the value of the individualInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuINDIVIDUALINFO }
     *     
     */
    public void setIndividualInfo(GuINDIVIDUALINFO value) {
        this.individualInfo = value;
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
     * Gets the value of the monthlytotalincome property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMONTHLYTOTALINCOME() {
        return monthlytotalincome;
    }

    /**
     * Sets the value of the monthlytotalincome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMONTHLYTOTALINCOME(Double value) {
        this.monthlytotalincome = value;
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
     * Gets the value of the organizationcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORGANIZATIONCODE() {
        return organizationcode;
    }

    /**
     * Sets the value of the organizationcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORGANIZATIONCODE(String value) {
        this.organizationcode = value;
    }

    /**
     * Gets the value of the otherincome property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOTHERINCOME() {
        return otherincome;
    }

    /**
     * Sets the value of the otherincome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOTHERINCOME(Double value) {
        this.otherincome = value;
    }

    /**
     * Gets the value of the paypattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYPATTERN() {
        return paypattern;
    }

    /**
     * Sets the value of the paypattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYPATTERN(String value) {
        this.paypattern = value;
    }

    /**
     * Gets the value of the paytimeone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPAYTIMEONE() {
        return paytimeone;
    }

    /**
     * Sets the value of the paytimeone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPAYTIMEONE(Integer value) {
        this.paytimeone = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSITION() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSITION(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the serviceyears property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSERVICEYEARS() {
        return serviceyears;
    }

    /**
     * Sets the value of the serviceyears property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSERVICEYEARS(Double value) {
        this.serviceyears = value;
    }

    /**
     * Gets the value of the unitkind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITKIND() {
        return unitkind;
    }

    /**
     * Sets the value of the unitkind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITKIND(String value) {
        this.unitkind = value;
    }

    /**
     * Gets the value of the yearlyprofitorloss property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getYEARLYPROFITORLOSS() {
        return yearlyprofitorloss;
    }

    /**
     * Sets the value of the yearlyprofitorloss property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setYEARLYPROFITORLOSS(Double value) {
        this.yearlyprofitorloss = value;
    }

}
