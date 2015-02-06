<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ILOG 规则检查结果页面</title>
<%
	String path = request.getContextPath();
%>
<script src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" type="text/css"	href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/Popup.js"></script>
<script type="text/javascript" src="<%=path%>/js/Verification.js"></script>
</script>
</head>
<body>
	<div class="easyui-panel titles">
		<div class="titleb">
			<div class="divLeft">${res.resultName }</div>
			<div class="divRight">${res.resultDescription }	</div>
		</div>
	</div>
</body>
</html>