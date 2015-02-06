
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for guENTERPRISEINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guENTERPRISEINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ASSETS_LIAB_RATIO" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BANK_CREDIT_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMPLOYEE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ENTERPRISE_ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENTERPRISE_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENTERPRISE_LOAN_AMT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ENTERPRISE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENTERPRISE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enterpriseSet" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guENTERPRISEBUSINESS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FIXED_ASSETS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="GU_ENTERPRISE_INFO_OID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IS_TECH_CENTER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LEGAL_PERSON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MEDIUM_LOAN_AMT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MODIFY_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODIFY_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="NET_FIXED_ASSETS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="OPER_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REGISER_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RELATIONSHIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHORT_LOAN_AMT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TECHNICAL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TEL_PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTAL_ASSETS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guENTERPRISEINFO", propOrder = {
    "assetsliabratio",
    "bankcreditlevel",
    "employeenumber",
    "enterpriseaddress",
    "enterprisedesc",
    "enterpriseloanamt",
    "enterprisename",
    "enterprisetype",
    "enterpriseSet",
    "fixedassets",
    "guenterpriseinfooid",
    "istechcenter",
    "legalperson",
    "mediumloanamt",
    "modifyid",
    "modifytime",
    "netfixedassets",
    "operdate",
    "operid",
    "regiserno",
    "relationship",
    "shortloanamt",
    "technicalnumber",
    "telphone",
    "totalassets"
})
public class GuENTERPRISEINFO {

    @XmlElement(name = "ASSETS_LIAB_RATIO")
    protected double assetsliabratio;
    @XmlElement(name = "BANK_CREDIT_LEVEL")
    protected String bankcreditlevel;
    @XmlElement(name = "EMPLOYEE_NUMBER")
    protected int employeenumber;
    @XmlElement(name = "ENTERPRISE_ADDRESS")
    protected String enterpriseaddress;
    @XmlElement(name = "ENTERPRISE_DESC")
    protected String enterprisedesc;
    @XmlElement(name = "ENTERPRISE_LOAN_AMT")
    protected double enterpriseloanamt;
    @XmlElement(name = "ENTERPRISE_NAME")
    protected String enterprisename;
    @XmlElement(name = "ENTERPRISE_TYPE")
    protected String enterprisetype;
    @XmlElement(nillable = true)
    protected List<GuENTERPRISEBUSINESS> enterpriseSet;
    @XmlElement(name = "FIXED_ASSETS")
    protected double fixedassets;
    @XmlElement(name = "GU_ENTERPRISE_INFO_OID")
    protected Long guenterpriseinfooid;
    @XmlElement(name = "IS_TECH_CENTER")
    protected String istechcenter;
    @XmlElement(name = "LEGAL_PERSON")
    protected String legalperson;
    @XmlElement(name = "MEDIUM_LOAN_AMT")
    protected double mediumloanamt;
    @XmlElement(name = "MODIFY_ID")
    protected String modifyid;
    @XmlElement(name = "MODIFY_TIME")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifytime;
    @XmlElement(name = "NET_FIXED_ASSETS")
    protected double netfixedassets;
    @XmlElement(name = "OPER_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operdate;
    @XmlElement(name = "OPER_ID")
    protected String operid;
    @XmlElement(name = "REGISER_NO")
    protected String regiserno;
    @XmlElement(name = "RELATIONSHIP")
    protected String relationship;
    @XmlElement(name = "SHORT_LOAN_AMT")
    protected double shortloanamt;
    @XmlElement(name = "TECHNICAL_NUMBER")
    protected int technicalnumber;
    @XmlElement(name = "TEL_PHONE")
    protected String telphone;
    @XmlElement(name = "TOTAL_ASSETS")
    protected double totalassets;

    /**
     * Gets the value of the assetsliabratio property.
     * 
     */
    public double getASSETSLIABRATIO() {
        return assetsliabratio;
    }

    /**
     * Sets the value of the assetsliabratio property.
     * 
     */
    public void setASSETSLIABRATIO(double value) {
        this.assetsliabratio = value;
    }

    /**
     * Gets the value of the bankcreditlevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANKCREDITLEVEL() {
        return bankcreditlevel;
    }

    /**
     * Sets the value of the bankcreditlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANKCREDITLEVEL(String value) {
        this.bankcreditlevel = value;
    }

    /**
     * Gets the value of the employeenumber property.
     * 
     */
    public int getEMPLOYEENUMBER() {
        return employeenumber;
    }

    /**
     * Sets the value of the employeenumber property.
     * 
     */
    public void setEMPLOYEENUMBER(int value) {
        this.employeenumber = value;
    }

    /**
     * Gets the value of the enterpriseaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTERPRISEADDRESS() {
        return enterpriseaddress;
    }

    /**
     * Sets the value of the enterpriseaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTERPRISEADDRESS(String value) {
        this.enterpriseaddress = value;
    }

    /**
     * Gets the value of the enterprisedesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTERPRISEDESC() {
        return enterprisedesc;
    }

    /**
     * Sets the value of the enterprisedesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTERPRISEDESC(String value) {
        this.enterprisedesc = value;
    }

    /**
     * Gets the value of the enterpriseloanamt property.
     * 
     */
    public double getENTERPRISELOANAMT() {
        return enterpriseloanamt;
    }

    /**
     * Sets the value of the enterpriseloanamt property.
     * 
     */
    public void setENTERPRISELOANAMT(double value) {
        this.enterpriseloanamt = value;
    }

    /**
     * Gets the value of the enterprisename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTERPRISENAME() {
        return enterprisename;
    }

    /**
     * Sets the value of the enterprisename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTERPRISENAME(String value) {
        this.enterprisename = value;
    }

    /**
     * Gets the value of the enterprisetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTERPRISETYPE() {
        return enterprisetype;
    }

    /**
     * Sets the value of the enterprisetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTERPRISETYPE(String value) {
        this.enterprisetype = value;
    }

    /**
     * Gets the value of the enterpriseSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enterpriseSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnterpriseSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuENTERPRISEBUSINESS }
     * 
     * 
     */
    public List<GuENTERPRISEBUSINESS> getEnterpriseSet() {
        if (enterpriseSet == null) {
            enterpriseSet = new ArrayList<GuENTERPRISEBUSINESS>();
        }
        return this.enterpriseSet;
    }

    /**
     * Gets the value of the fixedassets property.
     * 
     */
    public double getFIXEDASSETS() {
        return fixedassets;
    }

    /**
     * Sets the value of the fixedassets property.
     * 
     */
    public void setFIXEDASSETS(double value) {
        this.fixedassets = value;
    }

    /**
     * Gets the value of the guenterpriseinfooid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGUENTERPRISEINFOOID() {
        return guenterpriseinfooid;
    }

    /**
     * Sets the value of the guenterpriseinfooid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGUENTERPRISEINFOOID(Long value) {
        this.guenterpriseinfooid = value;
    }

    /**
     * Gets the value of the istechcenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISTECHCENTER() {
        return istechcenter;
    }

    /**
     * Sets the value of the istechcenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISTECHCENTER(String value) {
        this.istechcenter = value;
    }

    /**
     * Gets the value of the legalperson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEGALPERSON() {
        return legalperson;
    }

    /**
     * Sets the value of the legalperson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEGALPERSON(String value) {
        this.legalperson = value;
    }

    /**
     * Gets the value of the mediumloanamt property.
     * 
     */
    public double getMEDIUMLOANAMT() {
        return mediumloanamt;
    }

    /**
     * Sets the value of the mediumloanamt property.
     * 
     */
    public void setMEDIUMLOANAMT(double value) {
        this.mediumloanamt = value;
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
     * Gets the value of the netfixedassets property.
     * 
     */
    public double getNETFIXEDASSETS() {
        return netfixedassets;
    }

    /**
     * Sets the value of the netfixedassets property.
     * 
     */
    public void setNETFIXEDASSETS(double value) {
        this.netfixedassets = value;
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
     * Gets the value of the regiserno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGISERNO() {
        return regiserno;
    }

    /**
     * Sets the value of the regiserno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGISERNO(String value) {
        this.regiserno = value;
    }

    /**
     * Gets the value of the relationship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELATIONSHIP() {
        return relationship;
    }

    /**
     * Sets the value of the relationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELATIONSHIP(String value) {
        this.relationship = value;
    }

    /**
     * Gets the value of the shortloanamt property.
     * 
     */
    public double getSHORTLOANAMT() {
        return shortloanamt;
    }

    /**
     * Sets the value of the shortloanamt property.
     * 
     */
    public void setSHORTLOANAMT(double value) {
        this.shortloanamt = value;
    }

    /**
     * Gets the value of the technicalnumber property.
     * 
     */
    public int getTECHNICALNUMBER() {
        return technicalnumber;
    }

    /**
     * Sets the value of the technicalnumber property.
     * 
     */
    public void setTECHNICALNUMBER(int value) {
        this.technicalnumber = value;
    }

    /**
     * Gets the value of the telphone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTELPHONE() {
        return telphone;
    }

    /**
     * Sets the value of the telphone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTELPHONE(String value) {
        this.telphone = value;
    }

    /**
     * Gets the value of the totalassets property.
     * 
     */
    public double getTOTALASSETS() {
        return totalassets;
    }

    /**
     * Sets the value of the totalassets property.
     * 
     */
    public void setTOTALASSETS(double value) {
        this.totalassets = value;
    }

}
