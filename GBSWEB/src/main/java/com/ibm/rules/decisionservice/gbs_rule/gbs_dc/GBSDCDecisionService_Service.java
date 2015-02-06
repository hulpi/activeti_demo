
package com.ibm.rules.decisionservice.gbs_rule.gbs_dc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "GBS_DCDecisionService", targetNamespace = "http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC", wsdlLocation = "http://10.168.96.37:9080/DecisionService/ws/GBS_RULE/1.0/GBS_DC/1.0?WSDL")
public class GBSDCDecisionService_Service
    extends Service
{

    private final static URL GBSDCDECISIONSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCDecisionService_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.ibm.rules.decisionservice.gbs_rule.gbs_dc.GBSDCDecisionService_Service.class.getResource(".");
            url = new URL(baseUrl, "http://10.168.96.37:9080/DecisionService/ws/GBS_RULE/1.0/GBS_DC/1.0?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://10.168.96.37:9080/DecisionService/ws/GBS_RULE/1.0/GBS_DC/1.0?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        GBSDCDECISIONSERVICE_WSDL_LOCATION = url;
    }

    public GBSDCDecisionService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GBSDCDecisionService_Service() {
        super(GBSDCDECISIONSERVICE_WSDL_LOCATION, new QName("http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC", "GBS_DCDecisionService"));
    }

    /**
     * 
     * @return
     *     returns GBSDCDecisionService
     */
    @WebEndpoint(name = "GBS_RULEGBS_DCPort")
    public GBSDCDecisionService getGBSRULEGBSDCPort() {
        return super.getPort(new QName("http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC", "GBS_RULEGBS_DCPort"), GBSDCDecisionService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GBSDCDecisionService
     */
    @WebEndpoint(name = "GBS_RULEGBS_DCPort")
    public GBSDCDecisionService getGBSRULEGBSDCPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.ibm.com/rules/decisionservice/GBS_RULE/GBS_DC", "GBS_RULEGBS_DCPort"), GBSDCDecisionService.class, features);
    }

}