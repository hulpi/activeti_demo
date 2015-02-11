package com.gbs.dao;


import java.util.List;

import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.util.Page;

/**
 * 申请单操作DAO
 * @author wb00002
 *
 */
public interface ApplyInfoDao {
	
	/**
	 * 根据担保编号查询申请单信息
	 * @param guarant_id
	 * @return
	 */
	public GU_APPLY_INFO queryApplyInfo(String guarant_id);
	
	/**
	 * 查询个人申请信息（正在担保的保单信息）
	 * @param individual
	 * @return
	 */
	public GU_APPLY_INFO queryApplyInfoForIndividual(String cert_no);
	/**
	 * 查询企业申请信息
	 * @param enterprise
	 * @return
	 */
	public GU_APPLY_INFO queryApplyInfoForEnterprise(String enterprise);
	
	/**
	 * 新增申请单
	 * @param applyInfo
	 */
	public void addApplyInfo(GU_APPLY_INFO applyInfo);
	
	/**
	 * 修改申请单信息
	 * @param applyInfo
	 */
	public void updateApplyInfo(GU_APPLY_INFO applyInfo);
	
	/**
	 * 申请表的担保编号 序号
	 * @return
	 */
	public String getGuGuarantIdSeq();
	
	/**
	 * 查询申请单信息
	 * @param processInstanceIds
	 * @return
	 */
	public List<GU_APPLY_INFO> queryApplyInfoByProcessInstanceIds(List<String> processInstanceIds);
	/**
	 * 查询登录当前用户的所创建的申请单
	 * @return
	 */
	public List<GU_APPLY_INFO> queryApplyInfoByUser(String username);
	
	
	/**
	 * 查询申请单
	 * @param guarantId
	 * @return
	 */
	public GU_APPLY_INFO getApplyInfoByGuarantId(String guarantId);
	
	/**
	 * 查询申请单的信息
	 * @param dto
	 * @return
	 */
	public List<GU_APPLY_INFO> getApplyInfoList(APPLY_INFO_DTO dto,Page page);
	
	/**
	 * 更新状态
	 * @param guaranId
	 * @param status
	 */
	public void updateStatus(final String guaranId, final String status);
	
	/**
	 * 查询申请单的总数
	 * @param dto
	 * @return
	 */
	public int getApplyInfoCount(APPLY_INFO_DTO dto);
	
	
}
