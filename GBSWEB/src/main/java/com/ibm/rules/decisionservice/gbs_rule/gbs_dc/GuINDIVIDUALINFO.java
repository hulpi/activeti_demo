
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
 * <p>Java class for guINDIVIDUALINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guINDIVIDUALINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ADDRESS_DETAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BIRTHDAY" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CERT_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CERT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDUCATION_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GU_INDIVIDUAL_INFO_OID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="HUKOU_ADD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_CARD_ADDRESS_DETAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_CARD_VALIDITY_FROM" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ID_CARD_VALIDITY_PERIOD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_CARD_VALIDITY_TO" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="individualCompanySet" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALCOMPANY" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="individualHouseSet" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALHOUSE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="individualLinkmanSet" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALLINKMAN" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="individual_company" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guINDIVIDUALCOMPANY" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MODIFY_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MODIFY_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NATIVE_PLACE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OPER_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OPER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guINDIVIDUALINFO", propOrder = {
    "addressdetail",
    "birthday",
    "certno",
    "certtype",
    "custname",
    "educationlevel",
    "guindividualinfooid",
    "hukouadd",
    "idcardaddressdetail",
    "idcardvalidityfrom",
    "idcardvalidityperiod",
    "idcardvalidityto",
    "individualCompanySet",
    "individualHouseSet",
    "individualLinkmanSet",
    "individualCompany",
    "modifydate",
    "modifyid",
    "nativeplace",
    "operdate",
    "operid",
    "sex"
})
public class GuINDIVIDUALINFO {

    @XmlElement(name = "ADDRESS_DETAIL")
    protected String addressdetail;
    @XmlElement(name = "BIRTHDAY")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthday;
    @XmlElement(name = "CERT_NO")
    protected String certno;
    @XmlElement(name = "CERT_TYPE")
    protected String certtype;
    @XmlElement(name = "CUST_NAME")
    protected String custname;
    @XmlElement(name = "EDUCATION_LEVEL")
    protected String educationlevel;
    @XmlElement(name = "GU_INDIVIDUAL_INFO_OID")
    protected Long guindividualinfooid;
    @XmlElement(name = "HUKOU_ADD")
    protected String hukouadd;
    @XmlElement(name = "ID_CARD_ADDRESS_DETAIL")
    protected String idcardaddressdetail;
    @XmlElement(name = "ID_CARD_VALIDITY_FROM")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar idcardvalidityfrom;
    @XmlElement(name = "ID_CARD_VALIDITY_PERIOD")
    protected Integer idcardvalidityperiod;
    @XmlElement(name = "ID_CARD_VALIDITY_TO")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar idcardvalidityto;
    @XmlElement(nillable = true)
    protected List<GuINDIVIDUALCOMPANY> individualCompanySet;
    @XmlElement(nillable = true)
    protected List<GuINDIVIDUALHOUSE> individualHouseSet;
    @XmlElement(nillable = true)
    protected List<GuINDIVIDUALLINKMAN> individualLinkmanSet;
    @XmlElement(name = "individual_company", nillable = true)
    protected List<GuINDIVIDUALCOMPANY> individualCompany;
    @XmlElement(name = "MODIFY_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifydate;
    @XmlElement(name = "MODIFY_ID")
    protected String modifyid;
    @XmlElement(name = "NATIVE_PLACE")
    protected String nativeplace;
    @XmlElement(name = "OPER_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operdate;
    @XmlElement(name = "OPER_ID")
    protected String operid;
    @XmlElement(name = "SEX")
    protected String sex;

    /**
     * Gets the value of the addressdetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESSDETAIL() {
        return addressdetail;
    }

    /**
     * Sets the value of the addressdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESSDETAIL(String value) {
        this.addressdetail = value;
    }

    /**
     * Gets the value of the birthday property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBIRTHDAY() {
        return birthday;
    }

    /**
     * Sets the value of the birthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBIRTHDAY(XMLGregorianCalendar value) {
        this.birthday = value;
    }

    /**
     * Gets the value of the certno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCERTNO() {
        return certno;
    }

    /**
     * Sets the value of the certno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCERTNO(String value) {
        this.certno = value;
    }

    /**
     * Gets the value of the certtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCERTTYPE() {
        return certtype;
    }

    /**
     * Sets the value of the certtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCERTTYPE(String value) {
        this.certtype = value;
    }

    /**
     * Gets the value of the custname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTNAME() {
        return custname;
    }

    /**
     * Sets the value of the custname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTNAME(String value) {
        this.custname = value;
    }

    /**
     * Gets the value of the educationlevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEDUCATIONLEVEL() {
        return educationlevel;
    }

    /**
     * Sets the value of the educationlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEDUCATIONLEVEL(String value) {
        this.educationlevel = value;
    }

    /**
     * Gets the value of the guindividualinfooid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGUINDIVIDUALINFOOID() {
        return guindividualinfooid;
    }

    /**
     * Sets the value of the guindividualinfooid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGUINDIVIDUALINFOOID(Long value) {
        this.guindividualinfooid = value;
    }

    /**
     * Gets the value of the hukouadd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHUKOUADD() {
        return hukouadd;
    }

    /**
     * Sets the value of the hukouadd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHUKOUADD(String value) {
        this.hukouadd = value;
    }

    /**
     * Gets the value of the idcardaddressdetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDCARDADDRESSDETAIL() {
        return idcardaddressdetail;
    }

    /**
     * Sets the value of the idcardaddressdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDCARDADDRESSDETAIL(String value) {
        this.idcardaddressdetail = value;
    }

    /**
     * Gets the value of the idcardvalidityfrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIDCARDVALIDITYFROM() {
        return idcardvalidityfrom;
    }

    /**
     * Sets the value of the idcardvalidityfrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIDCARDVALIDITYFROM(XMLGregorianCalendar value) {
        this.idcardvalidityfrom = value;
    }

    /**
     * Gets the value of the idcardvalidityperiod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDCARDVALIDITYPERIOD() {
        return idcardvalidityperiod;
    }

    /**
     * Sets the value of the idcardvalidityperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDCARDVALIDITYPERIOD(Integer value) {
        this.idcardvalidityperiod = value;
    }

    /**
     * Gets the value of the idcardvalidityto property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIDCARDVALIDITYTO() {
        return idcardvalidityto;
    }

    /**
     * Sets the value of the idcardvalidityto property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIDCARDVALIDITYTO(XMLGregorianCalendar value) {
        this.idcardvalidityto = value;
    }

    /**
     * Gets the value of the individualCompanySet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualCompanySet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualCompanySet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuINDIVIDUALCOMPANY }
     * 
     * 
     */
    public List<GuINDIVIDUALCOMPANY> getIndividualCompanySet() {
        if (individualCompanySet == null) {
            individualCompanySet = new ArrayList<GuINDIVIDUALCOMPANY>();
        }
        return this.individualCompanySet;
    }

    /**
     * Gets the value of the individualHouseSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualHouseSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualHouseSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuINDIVIDUALHOUSE }
     * 
     * 
     */
    public List<GuINDIVIDUALHOUSE> getIndividualHouseSet() {
        if (individualHouseSet == null) {
            individualHouseSet = new ArrayList<GuINDIVIDUALHOUSE>();
        }
        return this.individualHouseSet;
    }

    /**
     * Gets the value of the individualLinkmanSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualLinkmanSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualLinkmanSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuINDIVIDUALLINKMAN }
     * 
     * 
     */
    public List<GuINDIVIDUALLINKMAN> getIndividualLinkmanSet() {
        if (individualLinkmanSet == null) {
            individualLinkmanSet = new ArrayList<GuINDIVIDUALLINKMAN>();
        }
        return this.individualLinkmanSet;
    }

    /**
     * Gets the value of the individualCompany property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualCompany property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualCompany().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuINDIVIDUALCOMPANY }
     * 
     * 
     */
    public List<GuINDIVIDUALCOMPANY> getIndividualCompany() {
        if (individualCompany == null) {
            individualCompany = new ArrayList<GuINDIVIDUALCOMPANY>();
        }
        return this.individualCompany;
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
     * Gets the value of the nativeplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNATIVEPLACE() {
        return nativeplace;
    }

    /**
     * Sets the value of the nativeplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNATIVEPLACE(String value) {
        this.nativeplace = value;
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
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEX() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEX(String value) {
        this.sex = value;
    }

}
