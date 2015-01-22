package me.kafeitu.demo.activiti.service.apply;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.kafeitu.demo.activiti.entity.customer.Application;
import me.kafeitu.demo.activiti.util.Page;

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

/**
 * 申请流程Service
 *
 * @author HuangLiPing
 */
@Component
@Transactional
public class ApplyWorkflowService {

    private static Logger logger = LoggerFactory.getLogger(ApplyWorkflowService.class);

    private ApplicationManager applyManager;

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
    public ProcessInstance startWorkflow(Application entity, Map<String, Object> variables) {
    	applyManager.saveApplication(entity);
        logger.debug("save entity: {}", entity);
        String businessKey = entity.getId().toString();

        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getUserId());
            //repositoryService.createProcessDefinitionQuery().list();

            processInstance = runtimeService.startProcessInstanceByKey("myProcess", businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity.setProcessInstanceId(processInstanceId);
            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"myProcess", businessKey, processInstanceId, variables});
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }

    /**
     * 查询待办任务
     *
     * @param userId 用户ID
     * @return
     */
    @Transactional(readOnly = true)
    public List<Application> findTodoTasks(String userId, Page<Application> page, int[] pageParams) {
    	logger.debug("userId = " + userId);
    	
        List<Application> results = new ArrayList<Application>();

        // 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
        List<Task> tasks = taskQuery.list();

        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            Application application = applyManager.getApplication(new Long(businessKey));
            if(application != null) {
	            application.setTask(task);
	            application.setProcessInstance(processInstance);
	            application.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
	            results.add(application);
            }
        }

        page.setTotalCount(taskQuery.count());
        page.setResult(results);
        return results;
    }

    /**
     * 读取运行中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Application> findRunningProcessInstaces(Page<Application> page, int[] pageParams) {
        List<Application> results = new ArrayList<Application>();
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey("myProcess").active().orderByProcessInstanceId().desc();
        List<ProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

        // 关联业务实体
        for (ProcessInstance processInstance : list) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            Application application = applyManager.getApplication(new Long(businessKey));
            application.setProcessInstance(processInstance);
            application.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
            results.add(application);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().listPage(0, 1);
            application.setTask(tasks.get(0));
        }

        page.setTotalCount(query.count());
        page.setResult(results);
        return results;
    }

    /**
     * 读取已结束中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Application> findFinishedProcessInstaces(Page<Application> page, int[] pageParams) {
        List<Application> results = new ArrayList<Application>();
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("myProcess").finished().orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

        // 关联业务实体
        for (HistoricProcessInstance historicProcessInstance : list) {
            String businessKey = historicProcessInstance.getBusinessKey();
            Application application = applyManager.getApplication(new Long(businessKey));
            application.setProcessDefinition(getProcessDefinition(historicProcessInstance.getProcessDefinitionId()));
            application.setHistoricProcessInstance(historicProcessInstance);
            results.add(application);
        }
        page.setTotalCount(query.count());
        page.setResult(results);
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

    @Autowired
    public void setApplyManager(ApplicationManager applyManager) {
		this.applyManager = applyManager;
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
