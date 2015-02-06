package com.uaf.grtwf.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uaf.grtwf.dto.TaskDto;


/**
 * 工作流Service
 *
 * @author HuangLiPing
 */
@Component
@Transactional
public class ApprovalWorkflowService {

    private static Logger logger = LoggerFactory.getLogger(ApprovalWorkflowService.class);


    private RuntimeService runtimeService;

    protected TaskService taskService;

    protected HistoryService historyService;

    protected RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    /**
     * 启动流程
     *
     * @param entity
     */
    public String startWorkflow(String businessKey, String userId, Map<String, Object> variables) {
        logger.debug("startWorkflow", businessKey);

        ProcessInstance processInstance = null;
        try {

            identityService.setAuthenticatedUserId(userId);
            //repositoryService.createProcessDefinitionQuery().list();
            
            if(variables == null) {
            	variables = new HashMap<String, Object>();
            }
            variables.put("hasPass", false);
            processInstance = runtimeService.startProcessInstanceByKey("approvalProcess", businessKey, variables);
            String processInstanceId = processInstance.getId();

            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"approvalProcess", businessKey, processInstanceId, variables});
            
            
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        
        return processInstance.getProcessInstanceId();
    }
    
    public String gotoNextTask(String processInstanceId, String userId, Map<String, Object> variables) throws Exception {
    	TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(processInstanceId)
    			.taskCandidateOrAssigned(userId);
        List<Task> tasks = taskQuery.list();
        String taskId = null;
        if(tasks != null && !tasks.isEmpty()) {
        	taskId = tasks.get(0).getId();
        }
        logger.debug("taskId = " + taskId);
        
        complete(taskId, variables);
        
        return taskId;
    }

    /**
     * 查询待办任务
     *
     * @param userId 用户ID
     * @return
     */
    @Transactional(readOnly = true)
    public List<TaskDto> findTodoTasks(String userId, String definitionKey) {
    	logger.debug("userId = " + userId);
    	logger.debug("definitionKey = " + definitionKey);
    	
    	if(userId == null) {
    		return Collections.EMPTY_LIST;
    	}
    	
        List<TaskDto> results = new ArrayList<TaskDto>();

        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
        if(definitionKey != null) {
        	taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId).taskDefinitionKey(definitionKey);
        }
        List<Task> tasks = taskQuery.list();
        
        if(tasks==null) {
        	return null;
        }
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getId());
            taskDto.setProcessInstanceId(processInstanceId);
            taskDto.setBusinessKey(businessKey);
            taskDto.setAssignee(task.getAssignee());
            taskDto.setProcessDefinitionId(task.getProcessDefinitionId());
            taskDto.setName(task.getName());
            taskDto.setOwner(task.getOwner());
            taskDto.setTaskDefinitionKey(task.getTaskDefinitionKey());
            results.add(taskDto);
        }

        return results;
        
    }

    /**
     * 读取运行中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<String> findRunningProcessInstaces(String processKey, int[] pageParams) {
        List<String> results = new ArrayList<String>();
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey(processKey).active().orderByProcessInstanceId().desc();
        List<ProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

        // 关联业务实体
        for (ProcessInstance processInstance : list) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            results.add(businessKey);
//            Application application = applyManager.getApplication(new Long(businessKey));
//            application.setProcessInstance(processInstance);
//            application.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
//            results.add(application);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().listPage(0, 1);
            //application.setTask(tasks.get(0));
        }

        return results;
    }

    /**
     * 读取已结束中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<String> findFinishedProcessInstaces(String processKey, int[] pageParams) {
        List<String> results = new ArrayList<String>();
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey(processKey).finished().orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

        // 关联业务实体
        for (HistoricProcessInstance historicProcessInstance : list) {
            String businessKey = historicProcessInstance.getBusinessKey();
//            Application application = applyManager.getApplication(new Long(businessKey));
//            application.setProcessDefinition(getProcessDefinition(historicProcessInstance.getProcessDefinitionId()));
//            application.setHistoricProcessInstance(historicProcessInstance);
            results.add(businessKey);
        }
        
        return results;
    }

    /**
     * 查询流程定义对象
     *
     * @param processDefinitionId 流程定义ID
     * @return
     */
    protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        return processDefinition;
    }
    
    /**
     * 读取参数
     *
     * @param id
     * @return
     */
    public Map<String, Object> getTaskVars(String taskId) {

        Map<String, Object> variables = taskService.getVariables(taskId);
        
        return variables;
    }
    
    /**
     * 完成任务
     *
     * @param id
     * @return
     * @throws Exception 
     */
    public void complete(String taskId,  Map<String, Object> variables) throws Exception {
        try {
        	if(variables != null) {
        		
                taskService.complete(taskId, variables);
                
        	} else {
        		taskService.complete(taskId);
        	}
            
        } catch (Exception e) {
            logger.error("error on complete task {}, variables={}", new Object[]{taskId, variables, e});
            throw e;
        }
    }
    
    /**
     * 签收任务
     */
    public void claim(String userId, String taskId) {

        taskService.claim(taskId, userId);
        logger.info("任务已签收:" + taskId + "," +userId);
        
    }
    
    public Map<String, Object> findVariables(String taskId) {
    	return taskService.getVariables(taskId);
    }
    
    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

	@Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

}
