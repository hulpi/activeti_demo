<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>贷款申请</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script  type="text/javascript" src="<%=path%>/js/add.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/entry.css">
</head>
<body style="background: #d5e4f5">
	<form id="appForm" method="post" action="saveIndividual.do" onsubmit="">
		<jsp:include page="edit_apply_info.jsp"></jsp:include>
		<jsp:include page="individual.jsp"></jsp:include>
		<c:if test="${empty individual}">
			<jsp:include page="house.jsp"></jsp:include>
			<jsp:include page="company.jsp"></jsp:include>
			<jsp:include page="linkman.jsp"></jsp:include>
		</c:if>
		<c:forEach items="${houstInfo}" var="house1" varStatus="idx">
			<c:set var="house" value="${house1}" scope="request"></c:set>
			<jsp:include page="house.jsp"></jsp:include>
		</c:forEach>
		<c:forEach items="${companyInfo}" var="company1" varStatus="idx">
			<c:set var="company" value="${company1}" scope="request"></c:set>
			<jsp:include page="company.jsp"></jsp:include>
		</c:forEach>
		<c:forEach items="${linkManInfo}" var="linkMan1" varStatus="idx">
			<c:set var="linkMan" value="${linkMan1}" scope="request"></c:set>
			<jsp:include page="linkman.jsp"></jsp:include>
		</c:forEach>
		<input type="submit" value="提交">
	</form>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loadingdivs", parent.document).hide();
	});
/* 
	function validate(){
   	 if(!verifyCustBasic()){
   		 return false;
   	 }
    } */
</script>

