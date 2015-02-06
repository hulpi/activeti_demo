<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//String scanType=(String)request.getParameter("scanType");
//String barCode=(String)request.getParameter("barCode");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><title>影像管理</title>
    <script type="text/javascript" src="<%=path%>/ECMoperate/js/prototype.js"></script>
	<script type="text/javascript" src="<%=path%>/ECMoperate/js/ext-base.js"></script>
	<script type="text/javascript" src="<%=path%>/ECMoperate/js/ext-all.js"></script>
	<script type="text/javascript" src="<%=path%>/ECMoperate/js/scan_query.js"></script>


	<link rel="stylesheet" type="text/css"href="<%=path%>/ECMoperate/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/ECMoperate/css/entry.css" />
   
  	<script type="text/javascript">
	
		var imgTypeString = 'T-001:APPLY_PAPER:申请表/身份证|'
							+'T-002:CUSTOMER:客户资料|'
							+'T-003:INSPECT:考察报告|'
							+'T-004:ZXREPORT:征信报告|'
							+'T-005:OTHERS:其他附件|'
							+'000000000:RECYCLE:回收站|';
		
		
		var imgTypeArr = imgTypeString.split("|");
		var retpairFlag = 'REPAIR_';
		
		
		function getLeftDynamicTree(){
			var template = {
		            	nodeKey: 'BARCODE', // 存储、查询关键字
		            	nodeName: '影像_', // 界面显示名
		            	includeImg: '1', // 是否可直接下挂影像1=N,2=Y
		            	nodeBarcode: 'D-001', // 影像资料类别识别条码，对于根节点无效
		            	nodeType: '0',
		            	children:new Array()
		     };
			
			var typeArr=imgTypeArr;
			var childre=new Array();
		
			for(var i=0;i<typeArr.length-1;i++){
					var imgtype=typeArr[i].split(':');
					var temp={nodeKey:'',nodeName:'',includeImg:'',nodeBarcode:''};
					temp.nodeKey=imgtype[1];
					temp.nodeName=imgtype[2];
					temp.includeImg='2';
					temp.nodeBarcode=imgtype[0];
					childre.push(temp);	
					
			}
			template.children=childre;

			return template;
		}
		
	
		function inti_scan_img(){
			
			var scanType = $('scanType').value;
			var barCode =  $('barCode').value;
			var guarantId =  $('guarantId').value;
			
			if(scanType!=0 && scanType!=1 && scanType!=2){
				alert("无效scanType值：[0-新增，1-修改。2-只读查询].");
				$('confirmBtn').hide();
				return;
			}
			
			if(barCode==null || barCode==""){
				alert("无效barCode值：[barCode不能为空].");
				$('confirmBtn').hide();
				return;
			}
			
			if(guarantId==null || guarantId==""){
				alert("无效guarantId值：[guarantId不能为空].");
				$('confirmBtn').hide();
				return;
			}

			var docType = getDefaultDocType(); //默认为 "LOAN"
			//barCode = "GRT2025012601010000099";
			
			initSunScan(getLeftDynamicTree());
			
			var keyList = [{key: "BARCODE", val: barCode}]; // 仅给出条码号，和补件类型过滤条件
			
			var ret = newBatchs(scanType, docType, keyList); //新增批次
			if(ret.respcode=="-1"){
				 newBatchs(0, docType, keyList);
			}
			//newBatchs(0, docType, keyList); //新增批次
			//newBatchs(1, docType,keyList); //修改批次
			//newBatchs(2, docType,keyList); //查看批次
			 
			displayScan('11111111111111111111010');  //隐藏提交按钮
			
		}
		
		function submitFormT(){

			//提交 
			var allData = $('formT').serialize();
			var web_base_path = "<%=path%>";
			
			new Ajax.Request(web_base_path+'/saveECMscanInfo.do',{
				parameters:allData,
				onComplete:function(xml){
					
				var data=xml.responseJSON;

				if(data.rs==true){
					 /*保存影像到 ECM */
					submitToECM();
					window.location.reload(); 

				}else{
					
					alert("提交失败: message = " + data.error);
				}
			}						
			});	
			 
		}
		
		function submitToECM(){
			 /*保存数据到 ECM */
			var barCode =  $('barCode').value;
			 
			updateBatchInfo(1,'BARCODE',barCode);				 			
			var ret = commitBatch(); //返回 true 或  false, 表示提交结果
			//alert(ret);
			
		}
		
		/**
		 * 提交新增批次和修改的批次。
		 * @return
		 */
		function commitBatch() {
			var result = upload();
			if(result.respcode == 0){
				return true ;
			}else{
				return false;
			}
		}

		 
	</script>
  </head>
  
  <body onload="inti_scan_img()"> 
  <form name="formT" id="formT" method="post">
  <div id="scanInputBtnDiv" style="padding: 10; background:#deecfd;">
	<span style="padding-bottom: 20; text-align:center; font-size: 14px;">影像编号: </span>
 	
  		<input id="barCode" name="barCode" value="${barCode}" style="vertical-align:middle; width:200px; height: 20px; padding: 0px" readOnly="true" />
  		<input type="hidden" id="scanType" name="scanType" value="${scanType}" />
  		<input type="hidden" id="guarantId" name="guarantId" value="${guarantId}" />
  		
        <input name="button"  style="vertical-align:middle;" type="button" id="confirmBtn" onClick="submitFormT()" value="提 交" />
 	 
  </div>
 </form>
   <div id="scanInputImgDiv">
   		<OBJECT ID="SunScan" WIDTH="100%" wmode="transparent"  HEIGHT="100%" CLASSID="CLSID:da9a1a4f-435c-4bcf-836a-f354af7dfb36"></OBJECT>
   </div>
   
  </body>
</html>
