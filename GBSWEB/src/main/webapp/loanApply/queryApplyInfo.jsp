<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请进度查询页面</title>
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
<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>


<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
</head>
<body>
	<form action="getApplyInfoList.do" method="post" name="myform" >
		<table width="100%">
			<tr class="tits">
				<td width="10%">申请城市</td>
				<td>
					<div id="city" />
				</td>

				<td width="10%">贷款产品:</td>
				<td>
					<div id="product" name="product" />
				</td>

				<td width="10%">担保编号:</td>
				<td><input type="text"  class="easyui-textbox" name="guarant_id" id="guarant_id">
				</td>


				<td width="10%">个人身份证:</td>
				<td><input type="text"   class="easyui-textbox" class="easyui-textbox" name="in_id" id="in_id"></td>
			</tr>
			<tr class="tits">
				<td width="10%">企业注册号:</td>
				<td><input type="text"  class="easyui-textbox" name="en_id" id="en_id"></td>

				<td width="10%">申请日期(起):</td>
				<td><input type="text" name="from_apply_date"
					id="from_apply_date" class="Wdate"
					onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
					readonly="readonly" style="width: 100px;" readonly="readonly"></td>

				<td width="10%">申请日期(止):</td>
				<td><input type="text" name="to_apply_date"
					id="to_apply_date" class="Wdate"
					onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
					readonly="readonly" style="width: 100px;" readonly="readonly"></td>
					
				<td width="10%">申请人:</td>
				<td><input type="text" class="easyui-textbox" name="userId" id="userId"></td>

			</tr>

			<tr class="tits">
				<td colspan="7"></td>
				<td align="center">
				<a id="search" class="easyui-linkbutton" iconCls="icon-ok" onclick="doSearch()">查询</a></td>
			</tr>
		</table>
	</form>

	<table id="list_data" class="easyui-datagrid" style="width:auto;height:auto;" >
		<thead>
			<tr class="tits">
				<th field="guarant_id" width="12%">担保编号</>
				<th field="apply_date" width="8%">申请日期</th>
				<th field="custName" width="7%">客户名称</th>
				<th field="productName" width="7%">贷款产品</th>
				<th field="cityName" width="10%">城市公司</th>
				<th field="apply_status" width="8%">申请状态</th>
				<th field="guarant_amt" width="9%">担保金额</th>
				<th field="approve_amt" width="9%">审批金额</th>
				<th field="guarant_type" width="6%">担保类型</th>
				<th field="guarant_time_limit" width="6%">担保期限</th>
				<th field="loan_purpose" width="10%">贷款用途</th>
				<th field="applicant" width="8%">申请人</th>
			</tr>
		</thead>
		
	</table>
</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loadingdivs", parent.document).hide();
		//城市公司
		getCity("#city");
		//贷款产品
		getAllProduct("#product");
		
		
	});
	
	$('#search').click(function(){
		initDataGrid();
	});
	function doSearch(){
		$('#list_data').datagrid('load',{
			city_id: $('#city_id').val(),
			productSel: $('#productSel').val(),
			guarant_id: $('#guarant_id').val(),
			in_id: $('#in_id').val(),
			en_id: $('#en_id').val(),
			from_apply_date: $('#from_apply_date').val(),
			to_apply_date: $('#to_apply_date').val(),
			userId: $('#userId').val()
		});
	}
	function initDataGrid(){
	 $('#list_data').datagrid({ 
	        title:'', 
	        iconCls:'icon-edit',//图标 
	        width: 'auto', 
	        height: 'auto', 
	        nowrap: false, 
	        striped: true, 
	        border: true, 
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        fitColumns : true,
	        url:'getApplyInfoList.do', 
	        //sortName: 'guarant_id', 
	        //sortOrder: 'asc', 
	        remoteSort:false,  
	        idField:'fldId', 
	        singleSelect:false,//是否单选 
	        pagination:true,//分页控件 
	        pagePosition:'top',
	        rownumbers:true,//行号 
	        frozenColumns:[[ 
	           
	        ]], 
	    }); 
	 
	 
	 var p = $('#list_data').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [5,10,15],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	        onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    }); 
	}
</script>
