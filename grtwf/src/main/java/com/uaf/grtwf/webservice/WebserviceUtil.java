package com.uaf.grtwf.webservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Webservice工具
 * @author: Huang LiPing
 */
public class WebserviceUtil {

    public static final String WEBSERVICE_URL = "http://localhost:8088/leave";
    public static final String WEBSERVICE_WSDL_URL = WEBSERVICE_URL + "?wsdl";
    public static final String WEBSERVICE_URI = "http://webservice.kafeitu.me/";

    private static Server server = null;

    /**
     * 发布Webservice
     */
    public static void startServer() {
        if (server != null) {
            System.out.println("WebService服务正在运行。。。");
            return;
        }
        ApprovalWebService approvalWebService = new ApprovalWebServiceImpl();
        JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
        svrFactory.setServiceClass(ApprovalWebService.class);
        svrFactory.setAddress(WEBSERVICE_URL);
        svrFactory.setServiceBean(approvalWebService);
        svrFactory.getInInterceptors().add(new LoggingInInterceptor());
        svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
        server = svrFactory.create();
        server.start();
        
        //Endpoint.publish(WEBSERVICE_URL, leaveWebService);
        System.out.println("Webservice已发布：" + WEBSERVICE_URL + "?wsdl");
    }

    /**
     * 停止Webservice服务
     */
    public static void stopServer() {
        if (server != null) {
            server.destroy();
        }
    }

    public static void main(String[] args) {
        startServer();
    }

}
