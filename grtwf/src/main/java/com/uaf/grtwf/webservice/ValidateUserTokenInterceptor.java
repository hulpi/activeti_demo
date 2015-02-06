/**
 * 
 */
package com.uaf.grtwf.webservice;

import java.util.Vector;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.ws.security.WSSecurityEngineResult;
import org.apache.ws.security.WSUsernameTokenPrincipal;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.apache.ws.security.handler.WSHandlerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HuangLiPing
 *
 */
public class ValidateUserTokenInterceptor extends AbstractPhaseInterceptor {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
    public ValidateUserTokenInterceptor(String s) {
        super(s);
    }

	@Override
	public void handleMessage(Message message) throws Fault {
		logger.debug("handleMessage() : Start...");
		
		boolean userTokenValidated = false;
        Vector result = (Vector) message.getContextualProperty(WSHandlerConstants.RECV_RESULTS);
        
        for (int i = 0; i < result.size(); i++) {
            WSHandlerResult res = (WSHandlerResult) result.get(i);
            for (int j = 0; j < res.getResults().size(); j++) {
                   WSSecurityEngineResult secRes = (WSSecurityEngineResult) res.getResults().get(j);
                    WSUsernameTokenPrincipal principal = (WSUsernameTokenPrincipal) secRes.get(secRes.TAG_PRINCIPAL);

                    if (!principal.isPasswordDigest() ||
                            principal.getNonce() == null ||
                            principal.getPassword() == null ||
                            principal.getCreatedTime() == null) {
                    	
                        throw new RuntimeException("Invalid Security Header");
                    } else {
                        userTokenValidated = true;
                    }
            }
        }
        if (!userTokenValidated) {
            throw new RuntimeException("Security processing failed");
        }
        
        logger.debug("handleMessage() : End...");
    }
}
