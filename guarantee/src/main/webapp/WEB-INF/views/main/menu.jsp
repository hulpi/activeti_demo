<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="css3menu">
	<li class="topfirst"><a rel="main/welcome">首页</a></li>
	<!-- <li>
		<a rel="#">请假（普通表单）</a>
		<ul>
			<li><a rel="oa/leave/apply">请假申请(普通)</a></li>
			<li><a rel="oa/leave/list/task">请假办理(普通)</a></li>
			<li><a rel="oa/leave/list/running">运行中流程(普通)</a></li>
			<li><a rel="oa/leave/list/finished">已结束流程(普通)</a></li>
		</ul>
	</li>-->
	<li>
		<a rel="#">担保受理</a>
		<ul>
		    <li><a rel="#">客户建档</a></li>
			<li><a rel="customer/apply/initialize">担保申请</a></li>
			 <li><a rel="customer/apply/list/task">客户初审</a></li>
			 <li><a rel="customer/apply/list/running">运行中流程(普通)</a></li>
			<li><a rel="customer/apply/finished">已结束流程(普通)</a></li>
		</ul>
	</li>
	
	<li>
		<a rel="#">业务管理</a>
		<ul>
			<li><a rel="form/dynamic/process-list">项目调查</a></li>
			<li><a rel="form/dynamic/task/list">项目复核</a></li>
			<li><a rel="form/dynamic/process-instance/running/list">项目终审</a></li>
			<li><a rel="form/dynamic/process-instance/finished/list">合同生成</a></li>
		</ul>
	</li>
	<!--  
	<li>
		<a rel="#">财务管理</a>
		<ul>
			<li><a rel="form/formkey/process-list">担保费缴费</a></li>
			<li><a rel="form/formkey/task/list">保证金缴费</a></li>
			<li><a rel="form/formkey/process-instance/running/list">通知放款</a></li>
			<li><a rel="form/formkey/process-instance/finished/list">放款复核</a></li>
			<li><a rel="form/formkey/task/list">代偿费缴费</a></li>
			<li><a rel="form/formkey/task/list">追偿费用登记</a></li>
		</ul>
	</li>
	<li>
		<a rel="#">保后监管</a>
		<ul>
			<li><a rel="form/formkey/process-list">监管调查</a></li>
			<li><a rel="form/formkey/task/list">逾期处理</a></li>
			<li><a rel="form/formkey/process-instance/running/list">代偿处理</a></li>
			<li><a rel="form/formkey/process-instance/finished/list">追偿处理</a></li>
			<li><a rel="form/formkey/process-instance/finished/list">撤保处理</a></li>
		</ul>
	</li>
    <li>
        <a rel='#' >业务统计</a>
        <ul>
           
        </ul>
    </li>
    -->
	<li>
		<a rel='#'>基础资料</a>
		<ul>
		    <li><a rel="#">系统角色</a></li>
		    <li><a rel="#">用户管理</a></li>
			<li><a rel='workflow/process-list'>流程定义及部署管理</a></li>
			<li><a rel='workflow/processinstance/running'>运行中流程</a></li>
			<li><a rel='workflow/model/list'>模型工作区</a></li>
			 <li><a rel="form/dynamic/process-list?processType=all">流程列表</a></li>
            <li><a rel="form/dynamic/task/list?processType=all">任务列表(综合)</a></li>
            <li><a rel="form/dynamic/process-instance/running/list?processType=all">运行中流程表(综合)</a></li>
            <li><a rel="form/dynamic/process-instance/finished/list?processType=all">已结束流程(综合)</a></li>
		</ul>
	</li>
	
</ul>