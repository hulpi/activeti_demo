
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for guINDIVIDUALLINKMAN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guINDIVIDUALLINKMAN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APPLY_CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DWELL_ADDRESS_DETAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DWELL_TEL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GU_INDIVIDUAL_LINKMAN_OID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="individual" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALINFO" minOccurs="0"/>
 *         &lt;element name="LINKMAN_AGE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LINKMAN_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINKMAN_SEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINK_MAN_MOBILE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINK_MAN_POSITION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINK_MAN_UINT_TEL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINK_MAN_UNIT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODIFY_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODIFY_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RELATION_TO_LOANER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guINDIVIDUALLINKMAN", propOrder = {
    "applycity",
    "dwelladdressdetail",
    "dwelltelnumber",
    "guindividuallinkmanoid",
    "individual",
    "linkmanage",
    "linkmanname",
    "linkmansex",
    "linkmanmobilenumber",
    "linkmanposition",
    "linkmanuinttelnumber",
    "linkmanunitname",
    "modifyid",
    "modifytime",
    "operdate",
    "operid",
    "relationtoloaner"
})
public class GuINDIVIDUALLINKMAN {

    @XmlElement(name = "APPLY_CITY")
    protected String applycity;
    @XmlElement(name = "DWELL_ADDRESS_DETAIL")
    protected String dwelladdressdetail;
    @XmlElement(name = "DWELL_TEL_NUMBER")
    protected String dwelltelnumber;
    @XmlElement(name = "GU_INDIVIDUAL_LINKMAN_OID")
    protected Long guindividuallinkmanoid;
    protected GuINDIVIDUALINFO individual;
    @XmlElement(name = "LINKMAN_AGE")
    protected Integer linkmanage;
    @XmlElement(name = "LINKMAN_NAME")
    protected String linkmanname;
    @XmlElement(name = "LINKMAN_SEX")
    protected String linkmansex;
    @XmlElement(name = "LINK_MAN_MOBILE_NUMBER")
    protected String linkmanmobilenumber;
    @XmlElement(name = "LINK_MAN_POSITION")
    protected String linkmanposition;
    @XmlElement(name = "LINK_MAN_UINT_TEL_NUMBER")
    protected String linkmanuinttelnumber;
    @XmlElement(name = "LINK_MAN_UNIT_NAME")
    protected String linkmanunitname;
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
    @XmlElement(name = "RELATION_TO_LOANER")
    protected String relationtoloaner;

    /**
     * Gets the value of the applycity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPLYCITY() {
        return applycity;
    }

    /**
     * Sets the value of the applycity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPLYCITY(String value) {
        this.applycity = value;
    }

    /**
     * Gets the value of the dwelladdressdetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWELLADDRESSDETAIL() {
        return dwelladdressdetail;
    }

    /**
     * Sets the value of the dwelladdressdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWELLADDRESSDETAIL(String value) {
        this.dwelladdressdetail = value;
    }

    /**
     * Gets the value of the dwelltelnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWELLTELNUMBER() {
        return dwelltelnumber;
    }

    /**
     * Sets the value of the dwelltelnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWELLTELNUMBER(String value) {
        this.dwelltelnumber = value;
    }

    /**
     * Gets the value of the guindividuallinkmanoid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGUINDIVIDUALLINKMANOID() {
        return guindividuallinkmanoid;
    }

    /**
     * Sets the value of the guindividuallinkmanoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGUINDIVIDUALLINKMANOID(Long value) {
        this.guindividuallinkmanoid = value;
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
     * Gets the value of the linkmanage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLINKMANAGE() {
        return linkmanage;
    }

    /**
     * Sets the value of the linkmanage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLINKMANAGE(Integer value) {
        this.linkmanage = value;
    }

    /**
     * Gets the value of the linkmanname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKMANNAME() {
        return linkmanname;
    }

    /**
     * Sets the value of the linkmanname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKMANNAME(String value) {
        this.linkmanname = value;
    }

    /**
     * Gets the value of the linkmansex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKMANSEX() {
        return linkmansex;
    }

    /**
     * Sets the value of the linkmansex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKMANSEX(String value) {
        this.linkmansex = value;
    }

    /**
     * Gets the value of the linkmanmobilenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKMANMOBILENUMBER() {
        return linkmanmobilenumber;
    }

    /**
     * Sets the value of the linkmanmobilenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKMANMOBILENUMBER(String value) {
        this.linkmanmobilenumber = value;
    }

    /**
     * Gets the value of the linkmanposition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKMANPOSITION() {
        return linkmanposition;
    }

    /**
     * Sets the value of the linkmanposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKMANPOSITION(String value) {
        this.linkmanposition = value;
    }

    /**
     * Gets the value of the linkmanuinttelnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKMANUINTTELNUMBER() {
        return linkmanuinttelnumber;
    }

    /**
     * Sets the value of the linkmanuinttelnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKMANUINTTELNUMBER(String value) {
        this.linkmanuinttelnumber = value;
    }

    /**
     * Gets the value of the linkmanunitname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKMANUNITNAME() {
        return linkmanunitname;
    }

    /**
     * Sets the value of the linkmanunitname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKMANUNITNAME(String value) {
        this.linkmanunitname = value;
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
     * Gets the value of the relationtoloaner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELATIONTOLOANER() {
        return relationtoloaner;
    }

    /**
     * Sets the value of the relationtoloaner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELATIONTOLOANER(String value) {
        this.relationtoloaner = value;
    }

}
