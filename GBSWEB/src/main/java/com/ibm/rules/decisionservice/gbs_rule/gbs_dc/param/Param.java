
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc.param;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GuAPPLYINFO;


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
 *         &lt;element name="param" type="{http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC}guAPPLYINFO"/>
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
    "param"
})
@XmlRootElement(name = "param")
public class Param {

    @XmlElement(required = true)
    protected GuAPPLYINFO param;

    /**
     * Gets the value of the param property.
     * 
     * @return
     *     possible object is
     *     {@link GuAPPLYINFO }
     *     
     */
    public GuAPPLYINFO getParam() {
        return param;
    }

    /**
     * Sets the value of the param property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuAPPLYINFO }
     *     
     */
    public void setParam(GuAPPLYINFO value) {
        this.param = value;
    }

}
