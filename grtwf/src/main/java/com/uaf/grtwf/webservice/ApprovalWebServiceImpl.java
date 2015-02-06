package com.uaf.grtwf.webservice;


import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.uaf.grtwf.dto.TaskDto;
import com.uaf.grtwf.service.ApprovalWorkflowService;

/**
 * 
 */
@WebService(
	    serviceName="ApprovalWebService",
	    endpointInterface="com.uaf.grtwf.webservice.ApprovalWebService",portName="ApprovalServicePort")
//@InInterceptors(interceptors={
//        "com.uaf.grtwf.webservice.WSSecurityInterceptor"
//})
public class ApprovalWebServiceImpl implements ApprovalWebService {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private ApprovalWorkflowService approvalWorkflowService;

    @Override
    public String startProcess(String userId, String businessKey, Map<String, Object> variables) throws Exception {
    	logger.info("startProcess()...");
    	logger.info("userId=" + userId);
    	logger.info("businessKey=" + businessKey);
    	String result = null;
    	try {
    	    result = approvalWorkflowService.startWorkflow(businessKey, userId, variables);
        	
           approvalWorkflowService.gotoNextTask(result, userId, variables);
           
    	} catch(Exception e) {
    		logger.error(e.getMessage());
    		e.printStackTrace();
    		throw e;
    	}
    	
    	return result;
    }
    
    public void claimTask(String userId, String taskId) throws Exception {
    	logger.info("Start claimTask()...");
    	try {
    	    approvalWorkflowService.claim(userId, taskId);
           
    	} catch(Exception e) {
    		logger.error(e.getMessage());
    		e.printStackTrace();
    		throw e;
    	}
    	logger.info("End claimTask()...");
    }
    
    public void completeTask(String userId, String taskId,  Map<String, Object> variables) throws Exception {
    	logger.info("Start completeTask()...");
    	try {
    	    approvalWorkflowService.complete(taskId, variables);
           
    	} catch(Exception e) {
    		logger.error(e.getMessage());
    		e.printStackTrace();
    		throw e;
    	}
    	
    	logger.info("End completeTask()...");
    }
    
    public List<TaskDto> findTodoTasks(String userId, String definitionKey) throws Exception {
    	
    	logger.info("Start findTodoTasks()...");
    	try {
    	    return approvalWorkflowService.findTodoTasks(userId, definitionKey);
           
    	} catch(Exception e) {
    		logger.error(e.getMessage());
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    public Map<String, Object> getVariables(String taskId) throws Exception {
    	return approvalWorkflowService.findVariables(taskId);
    	
    }
    
}