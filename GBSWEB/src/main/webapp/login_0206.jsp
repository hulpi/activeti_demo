<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录-担保系统</title>
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jqAjax.js"></script>
<script type="text/javascript" src="<%=path%>/js/Popup.js"></script>
<script type="text/javascript">
var web_Path='<%=path%>';
</script>
</head>
<body>

	<div
		style="margin-left: auto; margin-right: auto; width: 600px; padding-top: 10%">
		<div class="easyui-panel" title="登录-担保系统"
			style="width: 500px; height: 290px; padding: 30px 70px 20px 150px">
			<br>
            ${SPRING_SECURITY_LAST_EXCEPTION.message}

            <form action="j_spring_security_check" method="post">  
		        USERNAME:<input type="text" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" />
		        <br/>  
		        PASSWORD:<input type="password" name="j_password" value="" /><br/>  
		        <!-- <input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆<br/>  -->
		        <br/>
		        <input type="submit">  
            </form>
        <!-- 
			<div style="margin-bottom: 30px;">
				<input id="User" class="easyui-textbox"
					style="width:200px; height: 40px; padding: 12px"
					data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom: 30px;">
				<input id="Password" class="easyui-textbox" type="password"
					style="width: 200px; height: 40px; padding: 12px"
					data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
			</div>
			<div style="margin-bottom: 30px;">
				<a href="#" id="LoginClick" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'"
					style="padding: 5px 0px; width: 200px;"><span
					style="font-size: 14px;">登录</span> </a>
			</div>
			-->
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$('#LoginClick').click(function() {

	window.location = 'index.jsp';
				
	});
</script>
