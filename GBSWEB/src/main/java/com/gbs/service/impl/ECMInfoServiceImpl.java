package com.gbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gbs.constant.CommonConstant;
import com.gbs.dao.ApplyInfoDao;
import com.gbs.dao.SequenceDao;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.service.ECMInfoService;
/**
 * 影像管理信息服务层实现类
 * @author wb00002
 *
 */
public class ECMInfoServiceImpl implements ECMInfoService {

	@Autowired
	private ApplyInfoDao applyInfoDao;
	
	@Autowired
	private SequenceDao sequenceDao;
	
	 
	@Override
	public String generateBarCodeForECM() throws Exception {
		  
		String barCodeSeq = sequenceDao.getSeqNoByName(SequenceDao.ECM_BARCODE_SEQ, CommonConstant.ECM_BARCODE_SEQ_LENGTH);
		String barCode = CommonConstant.ECM_BARCODE_PREFIX + barCodeSeq;
		
		return barCode;
		
	}
	
	@Override
	public GU_APPLY_INFO queryApplyInfoByGuarantId(String guarant_id) throws Exception {
		
		GU_APPLY_INFO applyInfoDb = applyInfoDao.queryApplyInfo(guarant_id);
		 
		return applyInfoDb;
	}

	@Override
	public void saveECMscanInfo(String guarant_id, String ecm_barcode) throws Exception {
		 
		GU_APPLY_INFO applyInfoDb = applyInfoDao.queryApplyInfo(guarant_id);
		if (applyInfoDb == null) {
			throw new Exception(" 找不到该担保申请信息!");
		}
		
		applyInfoDb.setEcm_barcode(ecm_barcode);
		applyInfoDao.updateApplyInfo(applyInfoDb);
		
	}

	
}
