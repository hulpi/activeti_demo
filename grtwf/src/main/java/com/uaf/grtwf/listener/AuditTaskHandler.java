/**
 * 
 */
package com.uaf.grtwf.listener;

import java.util.Arrays;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HuangLiPing
 *
 */
@Component
@Transactional
public class AuditTaskHandler implements TaskListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(AuditTaskHandler.class);
	
	@Autowired
    protected Environment environment;
	
	@Autowired
    private RuntimeService runtimeService;

	@Override
	public void notify(DelegateTask paramDelegateTask) {
		logger.info("start...");
		try {
			String processInstanceId = paramDelegateTask.getProcessInstanceId();
			logger.debug("processInstanceId = " + processInstanceId);
			String taskId =paramDelegateTask.getId();
	        logger.debug("taskId = " + taskId);
	        logger.debug("task name = " + paramDelegateTask.getName());
			
			String auditorGroupId = environment.getProperty("auditor.group", "auditor");
			String[] groupIds = auditorGroupId.split(",");
			
			if(groupIds != null && groupIds.length>0) {
				logger.debug("groupId length = " + groupIds.length);
				
			    paramDelegateTask.addCandidateGroups(Arrays.asList(groupIds));
			}
			
			String auditorUser = environment.getProperty("auditor.user", "");
			logger.debug("auditorUser = " + auditorUser);
			String[] userIds = auditorUser.split(",");
			if(userIds != null && userIds.length>0) {
				paramDelegateTask.addCandidateUsers(Arrays.asList(userIds));
			}
			
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
        logger.info("End...");
		
	}

}
