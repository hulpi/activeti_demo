package com.gbs.service;

import com.gbs.entity.GU_APPLY_INFO;


/**
 * 影像管理操作 服务层
 * 
 * @author wb00002
 * 
 */
/**
 * @author Chester
 *
 */
public interface ECMInfoService {
	
	/**
	 * 获取新增 ECM BarCode
	 * @throws Exception
	 */
	public String generateBarCodeForECM() throws Exception;
	
	/**
	 * 查询 ECM BarCode
	 * @throws Exception
	 */
	public GU_APPLY_INFO queryApplyInfoByGuarantId(String guarant_id) throws Exception;
	
	/**
	 * 保存影像管理信息
	 * @param dto
	 * @throws Exception
	 */
	public void saveECMscanInfo(String guarant_id, String ecm_barcode) throws Exception;
}
