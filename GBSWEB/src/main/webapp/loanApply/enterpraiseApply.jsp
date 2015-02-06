<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>企业个人信息</title>
<script type="text/javascript"
	src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/entry.css">
<base href="<%=basePath%>">
<input type="hidden" id="ENTERPRISE_TYPE_VAL"	value="${e.ENTERPRISE_TYPE}" />

</head>
<body style="background: #d5e4f5">
	<form id="appForm1" method="post" action="saveEnterpraise.do">
	<jsp:include page="edit_apply_info.jsp"></jsp:include>
		<fieldset>
			<legend>企业信息资料</legend>
			<table>
				<tr>
					<td><font color="red">*</font>企业名称：</td>
					<td><input type="text" id="ENTERPRISE_NAME"
						name="ENTERPRISE_NAME" value="${e.ENTERPRISE_NAME}"></td>
					<td><font color="red">*</font>法定代表人：</td>
					<td><input type="text" id="LEGAL_PERSON" name="LEGAL_PERSON"
						maxlength="18" value="${e.LEGAL_PERSON} "></td>
					<td><font color="red">*</font>企业登记注册号：</td>
					<td><input type="text" id="REGISER_NO" name="REGISER_NO"
						maxlength="30" value="${e.REGISER_NO}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>企业地址：</td>
					<td colspan=6><textarea rows="2" cols="50"
							id="ENTERPRISE_ADDRESS" name="ENTERPRISE_ADDRESS"
							onblur="checknull(this);" > ${e.ENTERPRISE_ADDRESS}</textarea>
					</td>
				</tr>

				<tr>
					<td><font color="red">*</font>联系电话：</td>
					<td><input type="text" id="TEL_PHONE" name="TEL_PHONE"
						value="${e.TEL_PHONE}"></td>
					<td><font color="red">*</font>企业登记注册类型：</td>
					<td><select id="ENTERPRISE_TYPE" name=ENTERPRISE_TYPE>
							<option value="GQ">国企</option>
							<option value="SQ">私企</option>
					</select></td>
				<tr>
					<td><font color="red">*</font>职工人数：</td>
					<td><input type="text" id="EMPLOYEE_NUMBER"
						name="EMPLOYEE_NUMBER" value="${e.EMPLOYEE_NUMBER}"
						style="width: 100px;" maxlength="35"></td>
					<td><font color="red">*</font>技术人员人数：</td>
					<td><input type="text" name="TECHNICAL_NUMBER"
						id="TECHNICAL_NUMBER" value="${e.TECHNICAL_NUMBER}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>隶属关系：</td>
					<td><input type="text" id="RELATIONSHIP" name="RELATIONSHIP"
						value="${e.RELATIONSHIP}" style="width: 100px;" maxlength="35"></td>
					<td><font color="red">*</font>银行信用等级：</td>
					<td><select id="BANK_CREDIT_LEVEL" name=BANK_CREDIT_LEVEL>
							<option value="I">I</option>
							<option value="II">II</option>
					</select></td>
				</tr>
				<tr>
					<td><font color="red">*</font>有无国家认定的技术中心：</td>
					<td><select id="IS_TECH_CENTER" name=IS_TECH_CENTER>
							<option value="Y">有</option>
							<option value="N">无</option>
					</select></td>
					<td><font color="red">*</font>企业总资产：</td>
					<td><input type="text" id="TOTAL_ASSETS" name="TOTAL_ASSETS"
						value="${e.TOTAL_ASSETS}" /></td>
				</tr>
				<tr>
					<td><font color="red">*</font>固定资产原值：</td>
					<td><input type="text" id="FIXED_ASSETS" name="FIXED_ASSETS"
						value="${e.FIXED_ASSETS}"></td>
					<td><font color="red">*</font>固定资产净值：</td>
					<td><input type="text" id="NET_FIXED_ASSETS"
						name="NET_FIXED_ASSETS" value="${e.NET_FIXED_ASSETS}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>资产负债率：</td>
					<td><input type="text" id="ASSETS_LIAB_RATIO"
						name="ASSETS_LIAB_RATIO" value="${e.ASSETS_LIAB_RATIO}"></td>
					<td><font color="red">*</font>企业贷款余额</td>
					<td><input type="text" id="ENTERPRISE_LOAN_AMT"
						name="ENTERPRISE_LOAN_AMT" value="${e.ENTERPRISE_LOAN_AMT}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>中长期贷款余额：</td>
					<td><input type="text" id="MEDIUM_LOAN_AMT"
						name="MEDIUM_LOAN_AMT" value="${e.MEDIUM_LOAN_AMT}"></td>
					<td><font color="red">*</font>短期贷款余额</td>
					<td><input type="text" id="SHORT_LOAN_AMT"
						name="SHORT_LOAN_AMT" value="${e.SHORT_LOAN_AMT}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>企业描述：</td>
					<td colspan=6><textarea rows="2" cols="50"
							id="ENTERPRISE_DESC" name="ENTERPRISE_DESC"
							onblur="checknull(this);" > ${e.ENTERPRISE_DESC}</textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>企业经营信息</legend>
			<table>
				<tr>
					<td><font color="red">*</font>年份：</td>
					<td><input type="text" id="YEAR"
						name="enterpraiseBusinessInfo[0].YEAR"
						value="${b.enterpraiseBusinessInfo[0].YEAR}"></td>
					<td><font color="red">*</font>销售收入：</td>
					<td><input type="text" id="SALES_INCOME"
						name="enterpraiseBusinessInfo[0].SALES_INCOME"
						value="${b.enterpraiseBusinessInfo[0].SALES_INCOME}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>利润：</td>
					<td><input type="text" id="PROFIT"
						name="enterpraiseBusinessInfo[0].PROFIT"
						value="${b.enterpraiseBusinessInfo[0].PROFIT}"></td>
					<td><font color="red">*</font>税金：</td>
					<td><input type="text" id="TAX_AMT"
						name="enterpraiseBusinessInfo[0].TAX_AMT"
						value="${b.enterpraiseBusinessInfo[0].TAX_AMT}"></td>
				</tr>
				<tr>
					<td><font color="red">*</font>备注：</td>
					<td colspan=6><textarea rows="2" cols="50"
							id="ENTERPRISE_DESC"
							name="enterpraiseBusinessInfo[0].REMARK"
							onblur="checknull(this);">${b.enterpraiseBusinessInfo[0].REMARK }</textarea></td>
				<tr>
			</table>
		</fieldset>
		<input type="submit" value="提交">
	</form>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loadingdivs", parent.document).hide();
	});
	
	$("select").each(function() {
		var obj = this.id;
		var val = $("#" + obj + "_VAL").val();
		$(this).children("option").each(function() {
			var v = $(this).val();
			if (val == v) {
				$(this).attr("selected", true);
			}
		});
	});
	$("input[type='radio']").each(function() {
		var obj = this.name;
		var arrs = $("input[name='" + obj + "'][type='radio']");
		var val = $("#" + obj.split(".")[1] + "_VAL").val();
		if ($("input[name='" + obj + "'][type='radio']:checked").length == 0) {
			arrs.each(function() {
				var v = $(this).val();
				if (val == v) {
					$(this).attr("checked", true);
				}
			});
		}
	});

</script>