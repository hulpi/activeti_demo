package me.kafeitu.demo.activiti.entity.customer;

import me.kafeitu.demo.activiti.entity.IdEntity;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Entity
 *
 */
@Entity
@Table(name = "CUSTOMER_APPLICATION")
public class Application extends IdEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String processInstanceId;
    private String userId;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String name;

    private String sex;
    
    private String idType;
    
    private String idNo;

    private String reason;
    
    private Date applyTime;

    //-- 临时属性 --//

    // 流程任务
    private Task task;

    private Map<String, Object> variables;

    // 运行中的流程实例
    private ProcessInstance processInstance;

    // 历史的流程实例
    private HistoricProcessInstance historicProcessInstance;

    // 流程定义
    private ProcessDefinition processDefinition;

    @Column
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Column
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Column
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Transient
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Transient
    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    @Transient
    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    @Transient
    public HistoricProcessInstance getHistoricProcessInstance() {
        return historicProcessInstance;
    }

    public void setHistoricProcessInstance(HistoricProcessInstance historicProcessInstance) {
        this.historicProcessInstance = historicProcessInstance;
    }

    @Transient
    public ProcessDefinition getProcessDefinition() {
        return processDefinition;
    }

    public void setProcessDefinition(ProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }

    @Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "ID_TYPE")
	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	@Column(name = "ID_NO")
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

}
