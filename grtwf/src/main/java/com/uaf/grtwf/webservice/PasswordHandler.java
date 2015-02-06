/**
 * 
 */
package com.uaf.grtwf.webservice;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HuangLiPing
 *
 */
public class PasswordHandler implements CallbackHandler {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		
		logger.debug("PasswordHandler Start...");
		
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		
		if (pc.getIdentifier().equals("admin")) {
			pc.setPassword("admin");
		}
		
		logger.debug("PasswordHandler End...");
		
	}

}
