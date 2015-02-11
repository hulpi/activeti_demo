<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/common/global.jsp"%>
	<title>待办任务列表</title>
	<link href="../js/plugins/jui/themes/redmond/jquery-ui-1.9.2.custom.css" type="text/css" rel="stylesheet" />
    <link href="../js/plugins/qtip/jquery.qtip.min.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="../css/blueprint/screen.css" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="../css/blueprint/print.css" type="text/css" media="print"> 
    <style type="text/css">
    /* block ui */
	.blockOverlay {
		z-index: 1004 !important;
	}
	.blockMsg {
		z-index: 1005 !important;
	}
    </style>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script src="../js/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
    <script src="../js/plugins/jui/extends/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
	<script src="../js/plugins/jui/extends/i18n/jquery-ui-date_time-picker-zh-CN.js" type="text/javascript"></script>
    <script src="../js/plugins/qtip/jquery.qtip.pack.js" type="text/javascript"></script>
	<script src="../js/plugins/html/jquery.outerhtml.js" type="text/javascript"></script>
	<script src="../js/plugins/blockui/jquery.blockUI.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/task-todo.js"></script>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success">${message}</div>
	</c:if>
	<table width="100%" class="need-border">
		<thead>
			<tr>
				<th>担保编号</th>
				<th>客户名称</th>
				<th>贷款金额</th>
				<th>还款期数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${approvalInfos}" var="approvalInfo">
			    <c:set var="action" value="${action}" />
				<c:set var="task" value="${approvalInfo.taskDto }" />
				<c:set var="applyInfo" value="${approvalInfo.applyInfo }" />
				<tr id="${applyInfo.guarant_id}" tid="${task.taskId }">
					<%-- <td><input type="radio" id="${task.taskId }" name="task" /></td>--%>
					<td>${applyInfo.guarant_id}</td>
					<td>${applyInfo.custName}</td>
					<td>${applyInfo.guarant_amt }</td>
					<td>6</td>
					<td>
						<c:if test="${empty task.assignee }">
							<a class="claim" href="${ctx }/approval/task/claim/${task.taskId}/${action}/${applyInfo.guarant_id}">签收</a>
						</c:if>
						<c:if test="${not empty task.assignee }">
							<a class="handle" tkey='${action}' tname='${task.name }' href="#" >办理</a>
						</c:if>
					</td>
					<%-- <td>
						<a class="trace" href='#' pid="${task.taskId }" pdid="${task.processDefinitionId}" title="点击查看流程">${task.name }</a>
					</td>
					--%>
				</tr>
			</c:forEach>
		</tbody>
		
		
	</table>
	
	<table>
	    <tr>
	    
	    </tr>
	</table>
	
	
	
	<!-- 下面是每个节点的模板，用来定义每个节点显示的内容 -->
	<!-- 使用DIV包裹，每个DIV的ID以节点名称命名，如果不同的流程版本需要使用同一个可以自己扩展（例如：在DIV添加属性，标记支持的版本） -->

	<!-- 初审 -->
	<div id="check" style="display: none">
		<%@include file="view-form.jsp" %>
	</div>

	<!-- 审核 -->
	<div id="audit" style="display: none">
		<%@include file="view-form.jsp" %>
	</div>
	
	<!-- 审批 -->
	<div id="approve" style="display: none">
		<%@include file="view-form.jsp" %>
	</div>
	
	<!-- 高级审批 -->
	<div id="advanceApprove" style="display: none">
		<%@include file="view-form.jsp" %>
	</div>

	<div id="back" style="display: none">
		<div class="back-info" style="display: none"></div>
		<!-- <div id="radio">
			<input type="radio" id="radio1" name="reApply" value="true" /><label for="radio1">调整申请</label>
			<input type="radio" id="radio2" name="reApply" checked="checked" value="false" /><label for="radio2">取消申请</label>
		</div>
		<hr />-->
		<table id="modifyApplyContent" style="display: none">
			<caption>申请内容</caption>
			<input type="hidden" id="guaranId" name="guaranId" />
            <!-- <a href="#" >修改</a>-->
		</table>
	</div>

	<div id="printing" style="display: none">
		<!-- table用来显示信息 -->
		<%@include file="view-form.jsp" %>
		<hr/>

	</div>

</body>
</html>