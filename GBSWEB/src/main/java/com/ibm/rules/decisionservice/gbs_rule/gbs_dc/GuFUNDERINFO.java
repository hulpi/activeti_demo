
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
 * <p>Java class for guFUNDERINFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guFUNDERINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="create_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="create_user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funder_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funder_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gu_funder_info_oid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="productSet" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guPRODUCTINFO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guFUNDERINFO", propOrder = {
    "createDate",
    "createUser",
    "funderCode",
    "funderDesc",
    "guFunderInfoOid",
    "productSet"
})
public class GuFUNDERINFO {

    @XmlElement(name = "create_date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "create_user")
    protected String createUser;
    @XmlElement(name = "funder_code")
    protected String funderCode;
    @XmlElement(name = "funder_desc")
    protected String funderDesc;
    @XmlElement(name = "gu_funder_info_oid")
    protected Long guFunderInfoOid;
    @XmlElement(nillable = true)
    protected List<GuPRODUCTINFO> productSet;

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the createUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * Sets the value of the createUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUser(String value) {
        this.createUser = value;
    }

    /**
     * Gets the value of the funderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunderCode() {
        return funderCode;
    }

    /**
     * Sets the value of the funderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunderCode(String value) {
        this.funderCode = value;
    }

    /**
     * Gets the value of the funderDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunderDesc() {
        return funderDesc;
    }

    /**
     * Sets the value of the funderDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunderDesc(String value) {
        this.funderDesc = value;
    }

    /**
     * Gets the value of the guFunderInfoOid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGuFunderInfoOid() {
        return guFunderInfoOid;
    }

    /**
     * Sets the value of the guFunderInfoOid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGuFunderInfoOid(Long value) {
        this.guFunderInfoOid = value;
    }

    /**
     * Gets the value of the productSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuPRODUCTINFO }
     * 
     * 
     */
    public List<GuPRODUCTINFO> getProductSet() {
        if (productSet == null) {
            productSet = new ArrayList<GuPRODUCTINFO>();
        }
        return this.productSet;
    }

}
