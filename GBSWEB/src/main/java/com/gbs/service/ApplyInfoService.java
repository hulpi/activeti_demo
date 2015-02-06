package com.gbs.service;

import java.util.List;

import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.INDIVIDUAL_INFO_DTO;
import com.gbs.dto.UserInfoDto;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.entity.GU_ENTERPRISE_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;

/**
 * 申请单操作 服务层
 * 
 * @author wb00002
 * 
 */
public interface ApplyInfoService {
	
	public void addIndividualApplyInfo(APPLY_INFO_DTO dto,GU_INDIVIDUAL_INFO individual,UserInfoDto userDto)throws Exception;
	
	public void addEnterpriseApplyInfo(APPLY_INFO_DTO dto,GU_ENTERPRISE_INFO enterprise,UserInfoDto userDto)throws Exception;
	
	/**
	 * 通过担保编号查询得到客户
	 * @param guarant_id
	 * @return
	 */
	public INDIVIDUAL_INFO_DTO getIndival(String guarant_id);
	
	public List<GU_APPLY_INFO> queryApplyInfoByUser(String username);
	
	/**
	 * 查询申请单
	 * @param guarantId
	 * @return
	 */
	public APPLY_INFO_DTO getApplyInfoByGuarantId(String guarantId);
	
	/**
	 * 修改申请单
	 * @param APPLY_INFO_DTO
	 */
	public void updateApplyInfo(APPLY_INFO_DTO apply_info_dto);
	
}
