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
	/**
	 * 查询待办事项
	 */
	public List<ApprovalInfoDto> findTodoTasks(String userId, String action) throws Exception; 
	
	/**
	 * 启动工作流流程
	 * @param userId
	 * @param businessKey
	 * @return
	 * @throws Exception
	 */
	public String startApprovalProcess(String userId, String businessKey) throws Exception;
	
	/**
	 * 签收任务
	 * @param userId
	 * @param taskId
	 * @param action
	 * @param guaranId
	 * @throws Exception
	 */
	 public void claimTask(String userId, String taskId, String action, String guaranId) throws Exception;
	 
	 /**
	  * 完成任务
	  * @param userId
	  * @param taskId
	  * @param guaranId
	  * @param status
	  * @param variables
	  * @throws Exception
	  */
	 public void completeTask(String userId, String taskId, String guaranId, String status, Map<String, Object> variables) throws Exception;
	 
	 /**
	  * 查询申请信息
	  * @param guaranId
	  * @return
	  * @throws Exception
	  */
	 public APPLY_INFO_DTO findApplyInfo(String guaranId) throws Exception;
	 
	 /**
	  * 通过任务ID查询申请信息
	  * @param guaranId
	  * @param taskId
	  * @return
	  * @throws Exception
	  */
	 public APPLY_INFO_DTO findApplyInfoWithVar(String guaranId, String taskId) throws Exception;

}
