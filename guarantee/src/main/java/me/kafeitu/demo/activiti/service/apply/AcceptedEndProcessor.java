package me.kafeitu.demo.activiti.service.apply;

import me.kafeitu.demo.activiti.entity.oa.Leave;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AcceptedEndProcessor implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(AcceptedEndProcessor.class);
	
	@Autowired
    RuntimeService runtimeService;
	
	
	@Override
	public void notify(DelegateTask paramDelegateTask) {
		logger.info("Start...");
		 String processInstanceId = paramDelegateTask.getProcessInstanceId();
	        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

	        Object realityStartTime = paramDelegateTask.getVariable("realityStartTime");
	        
	        logger.info("The apply is passed all approval!");
		
	}

}
