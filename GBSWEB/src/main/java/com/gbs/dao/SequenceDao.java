package com.gbs.dao;

/**
 * 序列号DAO 实现接口
 * @author Chester
 * @param <T>
 *
 */
public interface SequenceDao {
	
	public final static String ECM_BARCODE_SEQ = "GU_ECM_BARCODE_SEQ";
	
	public Long getSeqNoByName(String seqName);
	
	public String getSeqNoByName(String seqName, int length);
 
	
}
