package com.uaf.grtwf.listener;


import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uaf.grtwf.service.ApprovalWorkflowService;

@Component
@Transactional
public class InitiaTaskHandler implements TaskListener {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(InitiaTaskHandler.class);
	
	@Autowired
    private RuntimeService runtimeService;
	
	@Autowired
    private ApprovalWorkflowService approvalWorkflowService;
	
	
	@Override
	public void notify(DelegateTask paramDelegateTask) {
		logger.info("Start...");
		try {
			String processInstanceId = paramDelegateTask.getProcessInstanceId();
			logger.debug("processInstanceId = " + processInstanceId);

			String userId = paramDelegateTask.getVariable("applyUserId").toString();
			logger.debug("userId = " + userId);
			
			paramDelegateTask.addCandidateUser(userId);
	        String taskId =paramDelegateTask.getId();
	        logger.debug("taskId = " + taskId);
	        logger.debug("task name = " + paramDelegateTask.getName());
	        
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
        logger.info("End...");
        
		
	}

}
