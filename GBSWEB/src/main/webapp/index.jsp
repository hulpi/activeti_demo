<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GRTBS 担保业务框架</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
var web_Path='<%=path%>';
var Permissions="";
</script>
</head>
<body id="bodys" class="easyui-layout" style="overflow-y: hidden;"
	scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">抱歉，请开启脚本支持！</div>
	</noscript>
	<div id="frm1" region="north" split="true"
		style="display: none; overflow: hidden; height: 37px; background-image: url(images/55.png); background-repeat: repeat-x; background-position: left bottom; line-height: 25px; font-family: Verdana;">
		<b style="font-size: 16px; padding-left: 20px;">系统管理平台</b> <span
			style="padding-left: 69%;">欢迎您 <b></b> <a
			onclick="return confirm('确定要退出系统？');" href="j_spring_security_logout">退出</a></span>
	</div>
	<div id="frm2" region="south"
		style="line-height: 20px; overflow: hidden; text-align: center; display: none;">
		系统管理平台</div>
	<div region="west" split="true" title="导航菜单"
		style="width: 230px; overflow: hidden;" icon="icon-redo">
		<div id="menu" class="easyui-accordion" fit="true" border="false"
			style="display: none;"></div>
	</div>
	<div region="center" id="mainPanle"
		style="background: #eee; overflow: hidden;">
		<div id="tabs" style="display: none;" class="easyui-tabs" fit="true">
			<div title="欢迎页面"
				style="padding: 20px; text-align: center; vertical-align: bottom;"
				id="home">
				<h2>
					<img src="images/welcome.png" alt="welcome..."
						style="vertical-align: middle;" />
				</h2>
			</div>
			<span id="loadingdivs" class="loadings"><img
				src="images/loadingdiv.gif" alt="数据加载中..."
				style="vertical-align: middle;" /> &nbsp; 加载中，请稍后...</span>
		</div>
	</div>
	<div id="loadingdiv" class="loadings" style="display: block;">
		<img src="images/loadingdiv.gif" alt="数据加载中..."
			style="vertical-align: middle;" /> &nbsp; 加载中，请稍后...
	</div>
</body>
</html>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
