package com.gbs.service;

import java.util.List;

import com.gbs.dto.FUNDER_INFO_DTO;
import com.gbs.entity.GU_FUNDER_INFO;
/**
 * 合作方服务层
 * @author wb00002
 *
 */
public interface FunderService {
	/**
	 * 新增合作方
	 * @param funder
	 */
	public void addFunder(GU_FUNDER_INFO funder);
	
	/**
	 * 查询合作方
	 * @return
	 */
	public List<GU_FUNDER_INFO> queryFunder();
	
	public List<FUNDER_INFO_DTO> getFunder();
	
	/**
	 * 修改合作方
	 * @param funder
	 */
	public void updateFunder(GU_FUNDER_INFO funder);
	
	/**
	 * 批量修改合作方
	 * @param funder
	 */
	public void updateFunder(List<GU_FUNDER_INFO> funderList)throws Exception;
	
	/**
	 * 删除合作方
	 * @param funder
	 */
	public void deleteFunder(GU_FUNDER_INFO funder);
	
	/**
	 * 初始化数据
	 */
	public void initData();
}
