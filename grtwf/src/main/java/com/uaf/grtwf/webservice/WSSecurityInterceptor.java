/**
 * 
 */
package com.uaf.grtwf.webservice;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HuangLiPing
 *
 */
public class WSSecurityInterceptor extends AbstractPhaseInterceptor {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public WSSecurityInterceptor() {
        super(Phase.PRE_PROTOCOL);
    }
    public WSSecurityInterceptor(String s) {
        super(Phase.PRE_PROTOCOL);
    }
    
	@Override
	public void handleMessage(Message message) throws Fault {
		 Map props = new HashMap();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.PW_CALLBACK_REF, new PasswordHandler());

        WSS4JInInterceptor wss4jInHandler = new WSS4JInInterceptor(props);
        ValidateUserTokenInterceptor userTokenInterceptor = new ValidateUserTokenInterceptor(Phase.POST_PROTOCOL);

        message.getInterceptorChain().add(wss4jInHandler);
        message.getInterceptorChain().add(new SAAJInInterceptor());
        message.getInterceptorChain().add(userTokenInterceptor);
		
	}

}
