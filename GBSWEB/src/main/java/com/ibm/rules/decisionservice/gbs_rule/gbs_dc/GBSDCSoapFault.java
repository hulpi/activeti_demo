
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "GBS_DCException", targetNamespace = "http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC")
public class GBSDCSoapFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GBSDCException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public GBSDCSoapFault(String message, GBSDCException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public GBSDCSoapFault(String message, GBSDCException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCException
     */
    public GBSDCException getFaultInfo() {
        return faultInfo;
    }

}