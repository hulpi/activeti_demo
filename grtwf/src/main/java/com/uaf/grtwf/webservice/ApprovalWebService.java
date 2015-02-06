package com.uaf.grtwf.webservice;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.uaf.grtwf.dto.TaskDto;
import com.uaf.grtwf.util.MapAdapter;

/**
 * Approval WebService接口
 * @author: Huang LiPing
 */
@WebService
public interface ApprovalWebService {

    public String startProcess(String userId, String businessKey, @XmlJavaTypeAdapter(MapAdapter.class)Map<String, Object> variables) throws Exception;
    
    public void claimTask(String userId, String taskId) throws Exception;
    
    public void completeTask(String userId, String taskId,  @XmlJavaTypeAdapter(MapAdapter.class)Map<String, Object> variables) throws Exception;
    
    public List<TaskDto> findTodoTasks(String userId,  String definitionKey) throws Exception;
    
    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<String, Object> getVariables(String taskId) throws Exception;

}
