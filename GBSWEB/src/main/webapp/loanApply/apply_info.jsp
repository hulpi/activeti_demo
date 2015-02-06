<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>担保申请页面</title>
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
	<form action="guarantApply.do" method="post">
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
				<input type="text" id="guarant_amt" name="guarant_amt" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
				</td>
				<td width="10%">担保期限:</td>
				<td><input type="text" id="guarant_time_limit" name="guarant_time_limit"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
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
				<td width="80%"><input type="text" id="in_id" name="in_id" style="width:200px" 
					onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" 
					disabled="disabled"></td>
			</tr>
			<tr class="tits">
				<td width="20%"><input class="radio" type="radio" id="enType" name="applyType" value="EN">企业注册机构代码：</td>
				<td width="80%"><input type="text" id="en_id" name="en_id" style="width:200px;" disabled="disabled"></td>
			</tr>
			<tr class="tits">
				<td colspan="2" align="right"><input type="submit" id="nextButton" value="下一步" ></td>
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
	setTimeout("getProductLazy()",100); 
	
});

function getProductLazy(){
	getProduct("#product", $('#city_id').val(),$('#product_type').val());
}

//改变产品类型 
$('#productType').change(function(){
	getProduct("#product", $('#city_id').val(),$('#product_type').val());
	var productType = $('#product_type').val();
	
	if(productType == "IN"){
		$("input[name=applyType][value=IN]").attr("checked",true);
		changeIn();
	}
	if(productType == "EN"){
		$("input[name=applyType][value=EN]").attr("checked",true);
		changeEn();
	}
});

$('#inType').click(function(){
	changeIn();
});
function changeIn(){
	$('#en_id').attr("disabled","disabled");
	$('#in_id').removeAttr("disabled");
	$('#en_id').val('');
}
$('#enType').click(function(){
	changeEn();
});
function changeEn(){
	$('#in_id').attr("disabled","disabled");
	$('#en_id').removeAttr("disabled");
	$('#in_id').val('');
}

$('#nextButton').click(function(){
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
</script>
