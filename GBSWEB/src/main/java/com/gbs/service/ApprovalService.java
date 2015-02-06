/**
 * 
 */
package com.gbs.service;

import java.util.List;
import java.util.Map;

import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.ApprovalInfoDto;

/**
 * @author HuangLiPing
 *
 */
public interface ApprovalService {
	
	public List<ApprovalInfoDto> findTodoTasks(String userId, String action) throws Exception; 
	
	public String startApprovalProcess(String userId, String businessKey) throws Exception;
	
	 public void claimTask(String userId, String taskId) throws Exception;
	 
	 public void completeTask(String userId, String taskId, Map<String, Object> variables) throws Exception;
	 
	 public APPLY_INFO_DTO findApplyInfo(String guaranId) throws Exception;
	 
	 public APPLY_INFO_DTO findApplyInfoWithVar(String guaranId, String taskId) throws Exception;

}
