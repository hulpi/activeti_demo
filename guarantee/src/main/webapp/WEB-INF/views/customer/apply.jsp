<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
	<%@ include file="/common/global.jsp"%>
	<title>担保申请</title>
	<%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <%@ include file="/common/include-jquery-ui-theme.jsp" %>
    <link href="${ctx }/js/common/plugins/jui/extends/timepicker/jquery-ui-timepicker-addon.css" type="text/css" rel="stylesheet" />

    <script src="${ctx }/js/common/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${ctx }/js/common/plugins/jui/jquery-ui-${themeVersion }.min.js" type="text/javascript"></script>
    <script src="${ctx }/js/common/plugins/jui/extends/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
	<script src="${ctx }/js/common/plugins/jui/extends/i18n/jquery-ui-date_time-picker-zh-CN.js" type="text/javascript"></script>
    <script type="text/javascript">

    </script>
</head>

<body>
	<div class="container showgrid">
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">${message}</div>
		<!-- 自动隐藏提示信息 -->
		<script type="text/javascript">
		setTimeout(function() {
			$('#message').hide('slow');
		}, 5000);
		</script>
	</c:if>
	<c:if test="${not empty error}">
		<div id="error" class="alert alert-error">${error}</div>
		<!-- 自动隐藏提示信息 -->
		<script type="text/javascript">
		setTimeout(function() {
			$('#error').hide('slow');
		}, 5000);
		</script>
	</c:if>
	<form:form id="inputForm" action="${ctx}/customer/apply/start" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>申请人信息</small></legend>
			<table border="1">
			<tr>
				<td>姓名：</td>
				<td><input type="text" id="name" name="name" /></td>
				<td>性别：</td>
				<td>
					<select id="sex" name="sex">
						<option>男</option>
						<option>女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>证件类型：</td>
				<td>
					<select id="idType" name="idType">
						<option>身份证</option>
						<option>护照</option>
					</select>
				</td>
				<td>证件号码：</td>
				<td><input type="text" id="idNo" name="idNo" /></td>
			</tr>
			
			<tr>
				<td>备注：</td>
				<td>
					<textarea name="reason"></textarea>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<button type="submmit">申请</button>
				</td>
			</tr>
		</table>
		</fieldset>
	</form:form>
	</div>
</body>
</html>
