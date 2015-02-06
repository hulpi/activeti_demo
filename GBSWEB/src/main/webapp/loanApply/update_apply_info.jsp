<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改担保申请页面</title>
<%
	String path = request.getContextPath();
%>
<script src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/Popup.js"></script>
<script type="text/javascript" src="<%=path%>/js/Verification.js"></script>
</script>
<style type="text/css">
.radio{
	padding: 0px;
	border: 0px solid #BFBFBF;
	width: 17px;
	vertical-align: middle;
	background-image: url();
}
</style>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<base href="<%=basePath%>">
</head>
<body>
	<form action="updateApplyInfo.do" method="post">
		<input type="hidden" name="guarant_id" value="${applyInfo.guarant_id }"> 
		<input type="hidden" id="city_id_VAL" value="${applyInfo.city_id }"> 
		<input type="hidden" id="funder_id_VAL" value="${applyInfo.funder_id }"> 
		<input type="hidden" id="applyType_VAL" value="${applyInfo.product_type }"> 
		<input type="hidden" id="product_type_VAL" value="${applyInfo.product_type }"> 
		<input type="hidden" id="loan_purpose_VAL" value="${applyInfo.loan_purpose }"> 
		<input type="hidden" id="productSel_VAL" value="${applyInfo.productSel }"> 
		
		<table width="100%" border="0" align="center">
			<tr class="tits">
				<td width="10%">申请城市</td>
				<td> <div id="city" /> </td>
				
				<td width="10%">合作方:</td>
				<td>
					<div id="funder" name="funder"></div>
				</td>
				
				<td width="10%">担保类型:</td>
				<td>
					<div id="productType" name="productType"></div>
				</td>
				
				<td width="10%">贷款用途</td>
				<td>
					<div id="loanPurpose" name="loanPurpose"/>
				</td>
				
			</tr>

			<tr class="tits">
				<td width="10%">申请贷款金额:</td>
				<td>
				<input type="text" id="guarant_amt" name="guarant_amt" onkeyup="this.value=this.value.replace(/\D/g,'')" 
					onafterpaste="this.value=this.value.replace(/\D/g,'')"
					value="${ applyInfo.guarant_amt}">
				</td>
				<td width="10%">担保期限:</td>
				<td>
					<input type="text" id="guarant_time_limit" name="guarant_time_limit"  
					onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
					value="${ applyInfo.guarant_time_limit}"></td>
				<td width="10%">贷款产品:</td>
				<td>
					<div id="product" name="product" />
				</td>
				<td width="10%"></td>
				<td>  </td>
			</tr>
			
		</table>
		
		<table width="100%" border="0" align="left">
			<tr class="tits">
				<td width="20%"><input class="radio" type="radio" id="inType" name="applyType" value="IN">申请人身份证号码：</td>
				<td width="80%"><input type="text" id="in_id" name="in_id" value="${applyInfo.in_id }"
					disabled></td>
			</tr>
			<tr class="tits">
				<td width="20%"><input class="radio" type="radio" id="enType" name="applyType" value="EN">企业注册机构代码：</td>
				<td width="80%"><input type="text" id="en_id" name="en_id" style="width:200px;" value="${applyInfo.en_id }" disabled></td>
			</tr>
			<tr class="tits">
				<td colspan="2" align="right"><input type="submit" id="updateApplyInfo" value="确定" ></td>
			</tr>
		</table>
		
	</form>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loadingdivs", parent.document).hide();
		//贷款用途
		getLoanPurpose("#loanPurpose");
		//城市公司
		getCity("#city");
		//合作方
		getFunder("#funder");
		//产品类型
		getProductType("#productType");
		//贷款产品
		getAllProduct("#product",$('#productSel_VAL').val());
		setTimeout("setData()",150); 
		
	});
	
	$('#productType').change(function(){
		getProduct("#product", $('#city_id').val(),$('#product_type').val());
	});
	
	$('#updateApplyInfo').click(function(){
		var in_id = $('#in_id').val();
		var en_id = $('#en_id').val();
		if((in_id == null || in_id == '') && (en_id == null || en_id == '')){
			jqalertly('请输入申请人身份证号码 或者 企业注册机构代码！');			
			return false;
		}
		
		var productSel = $('#productSel').val();
		if(productSel == null || productSel == ''){
			jqalertly('请选择贷款产品！');			
			return false;
		}
		
		var guarant_time_limit = $('#guarant_time_limit').val();
		if(guarant_time_limit == null || guarant_time_limit == ''){
			jqalertly('请输入担保期限！');			
			return false;
		}
		
		var guarant_amt = $('#guarant_amt').val();
		if(guarant_amt == null || guarant_amt == ''){
			jqalertly('请输入贷款金额！');			
			return false;
		}
		var product_type = $('#product_type').val();
		
		if((product_type == "IN" && in_id =="") || (product_type == "EN" && en_id == "")){
			jqalertly('选择的贷款产品有误！');			
			return false;
		}
	});
	
	function setData(){
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
			var val = $("#" + obj+ "_VAL").val();
			if ($("input[name='" + obj + "'][type='radio']:checked").length == 0) {
				arrs.each(function() {
					var v = $(this).val();
					if (val == v) {
						$(this).attr("checked", true);
					}
				});
			}
		});
	}
</script>
