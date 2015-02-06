package com.gbs.dao;

import java.util.List;

import com.gbs.entity.GU_FUNDER_INFO;

/**
 * 合作方操作DAO
 * @author wb00002
 *
 */
public interface FunderDao {
	
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
	
	/**
	 * 修改合作方
	 * @param funder
	 */
	public void updateFunder(GU_FUNDER_INFO funder);
	
	/**
	 * 批量修改合作方
	 * @param funder
	 */
	public void updateFunder(List<GU_FUNDER_INFO> funderList);
	
	/**
	 * 删除合作方
	 * @param funder
	 */
	public void deleteFunder(GU_FUNDER_INFO funder);
	
	

}
