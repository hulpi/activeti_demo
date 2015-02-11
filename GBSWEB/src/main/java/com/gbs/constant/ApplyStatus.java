package com.gbs.constant;

import java.util.HashMap;
import java.util.Map;

public class ApplyStatus {
	public static final String APPLICATIONS = "0";
	
	public static Map<String, String> statusMap = new HashMap<String, String> ();
	public static Map<String, String> statusDesMap = new HashMap<String, String> ();
	
	static {
		statusMap.put("check", "2");//初审中
		statusMap.put("audit", "3");//审核中
		statusMap.put("approve", "4");//审批中
		statusMap.put("advanceApprove", "6");//高级审批中
		statusMap.put("back", "5");//调整申请中
		statusMap.put("print", "7");//放款中
		
		
		statusDesMap.put("0", "申请提交");
		statusDesMap.put("1", "确认提交");
		statusDesMap.put("2", "初审中");
		statusDesMap.put("3", "审核中");
		statusDesMap.put("4", "审批中");
		statusDesMap.put("5", "调整申请");
		statusDesMap.put("6", "高级审批中");
		statusDesMap.put("7", "放款中");
		statusDesMap.put("8", "等待审核");
		statusDesMap.put("9", "等待审批");
		statusDesMap.put("10", "等待放款");
		statusDesMap.put("11", "等待高级审批");
		statusDesMap.put("12", "等待重新初审");
		statusDesMap.put("13", "审核不通过");
		statusDesMap.put("14", "审批不通过");
		statusDesMap.put("15", "高级审批不通过");
		statusDesMap.put("16", "放弃申请");
		
	}
	
	public static String getApplyStatusDes(String status){
		return statusDesMap.get(status);
	}
	
	public static final String CONFIRM_APPLY = "1";//确认申请
	
	public static final String PASS_CHECK = "8";//等待审核
	public static final String PASS_AUDIT = "9";//等待审批
	public static final String PASS_APPROVE = "10";//等待放款
	public static final String PASS_PART_APPROVE = "11";//等待高级审批
	public static final String PASS_ADVANCE_APPROVE = "10";//
	public static final String PASS_REAPPLY = "12";//等待重新初审
	
	public static final String REJECT_CHECK = "5";//调整申请
	public static final String REJECT_AUDIT = "13";//审核不通过
	public static final String REJECT_APPROVE = "14";//审批不通过
	public static final String REJECT_ADVANCE_APPROVE = "15";//高级审批不通过
	public static final String REJECT_REAPPLY = "16";//放弃申请
	
}
