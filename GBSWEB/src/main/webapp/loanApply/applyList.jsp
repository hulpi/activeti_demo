<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   %>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<title>申请列表</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<link href="<%=path%>/css/style.css" rel="stylesheet"type="text/css" />
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<style type="text/css">
   input{
        height: 20px;
        width:70px;
        background-color: #DDF8FF;
   }  
</style>
</head>
<body>
  <div class="tits" >
	<span style="height: 40px">申请列表</span>
   </div>
  	<div class="Lr_right_0222">
			<table cellspacing="1">
			   <tr class="tits">
	              <td>申请人姓名</td>
	              <td>申请类型</td>
	              <td>申请时间</td>
	              <td>操作</td>	              
	              <td>影像</td>
	              <td>确认</td>
	             </tr>
	          <c:forEach var="item" items="${p}" varStatus="vs">
	              <tr class="tits" >
	                <td id="guarant_${vs.index}">${item.guarant_id}</td>
	                <td>${item.guarant_id}</td>
	                <td>2015/2/5</td>
	                <td><input type="button" value="资料修改" id="update_Record" onclick='updateRecord("guarant_${vs.index}")'></td>
	                <td><input type="button" value="影像管理" id="ECM_Manage" onclick='gotoECM("guarant_${vs.index}")'></td>
	                <td><input type="button" value="确认申请" id="confirm_apply" onclick='confirmApply("guarant_${vs.index}")'></td>
	              </tr>
	          </c:forEach>
			</table>
  </div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loadingdivs", parent.document).hide();
	});
	//点击影像管理按钮
	function gotoECM(guarant_id){
		var guarant_id=$('#'+guarant_id).html();
		
		self.location.href="/GBSWEB/forwardECM.do?guarant_id="+guarant_id;
	}
	//点击资料修改按钮
	function updateRecord(guarant_id){
		var guarant_id=$('#'+guarant_id).html();
		self.location.href="/GBSWEB/getRecord.do?guarant_id="+guarant_id;
	}
	//点击确认按钮
	function confirmApply(){
		
	}
	
</script>