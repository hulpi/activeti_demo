
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.param.Param;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DecisionID" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element ref="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC/param}param"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "decisionID",
    "param"
})
@XmlRootElement(name = "GBS_DCResponse")
public class GBSDCResponse {

    @XmlElement(name = "DecisionID", namespace = "http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC", required = true)
    protected String decisionID;
    @XmlElement(namespace = "http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC/param", required = true)
    protected Param param;

    /**
     * Gets the value of the decisionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecisionID() {
        return decisionID;
    }

    /**
     * Sets the value of the decisionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecisionID(String value) {
        this.decisionID = value;
    }

    /**
     * Gets the value of the param property.
     * 
     * @return
     *     possible object is
     *     {@link Param }
     *     
     */
    public Param getParam() {
        return param;
    }

    /**
     * Sets the value of the param property.
     * 
     * @param value
     *     allowed object is
     *     {@link Param }
     *     
     */
    public void setParam(Param value) {
        this.param = value;
    }

}
