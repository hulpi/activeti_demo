/**
 * 
 */
package com.gbs.dto;

import com.uaf.grtwf.webservice.TaskDto;

/**
 * @author HuangLiPing
 *
 */
public class ApprovalInfoDto {
	
	private APPLY_INFO_DTO applyInfo;
	
	private TaskDto taskDto;

	public APPLY_INFO_DTO getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(APPLY_INFO_DTO applyInfo) {
		this.applyInfo = applyInfo;
	}

	public TaskDto getTaskDto() {
		return taskDto;
	}

	public void setTaskDto(TaskDto taskDto) {
		this.taskDto = taskDto;
	}

}
