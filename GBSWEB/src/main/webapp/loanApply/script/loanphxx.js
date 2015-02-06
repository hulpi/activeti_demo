Ext.BLANK_IMAGE_URL = web_base_path + '/extlib/resources/images/default/s.gif';
if(phxxStation=='A3' || phxxStation=='A4'){
	Ext.onReady(function(){
		//批核轨迹列表
		var cm = new Ext.grid.ColumnModel([
				{header:'额度(元)',dataIndex:'APPROVAL_PH_LOAN_AMOUNT',sortable:true,width:100},
				{header:'期数(月)',dataIndex:'APPROVAL_PH_LOAN_PERIOD',sortable:true,width:90},
				{header:'担保利率(%)',dataIndex:'APPROVAL_AGREEMENT_RATE',sortable:true,width:90},
				{header:'中介服务费率(%)',dataIndex:'APPROVAL_AGREEMENT_COST',sortable:true,width:100},
				{header:'批核人+ID',dataIndex:'OPER_ID',sortable:true,width:120},
				{header:'岗位',dataIndex:'OPER_STATION',sortable:true,width:120,
					renderer:function(value){
						if (value=='A1') {
							return "贷款申请";
						}else if (value=='A2') {
							return "贷款审核";
						}else if(value=='A3'){
							return "贷款审批";
						}else if(value=='A4'){
							return "贷款发放";
						}
					 }},
				{header:'批核时间',dataIndex:'OPER_TIME',sortable:true,width:150}
			]);
			
			var ds = new Ext.data.Store({
				proxy: new Ext.data.HttpProxy({url:web_base_path+'loan/loanExtend.action?&isC=3&apply_code='+parent.apply_code}),
					reader: new Ext.data.JsonReader({
						totalProperty:'totalProperty',root:'root'
						}, [
						{name: 'APPROVAL_PH_LOAN_AMOUNT'},
						{name: 'APPROVAL_PH_LOAN_PERIOD'},
						{name: 'APPROVAL_AGREEMENT_RATE'},
						{name: 'APPROVAL_AGREEMENT_COST'},
						{name: 'OPER_ID'},
						{name: 'OPER_STATION'},
						{name: 'OPER_TIME'}
					])
			});
			
			var grid = new Ext.grid.GridPanel({
				el:'APPROVE_PATH',
				ds: ds,
				cm: cm,
				title:'批核轨迹',
				autoScroll:false,
				stripeRows:true,
				height:300,
				anchor:'100%',
				width:1024,
				defaults:{
					autoHeight:true
				},
				bbar:new Ext.PagingToolbar({
					pageSize:10,
					store:ds,
					displayInfo:true,
					displayMsg:'当前显示第 {0} 到 {1} 条记录,共{2}条记录',
					emptyMsg:'当前没有任务',
					lastText :'尾页',
			        nextText :'下一页',
			        prevText :'上一页',
			        firstText : '首页',
			        refreshText: '刷新……'
				})
			
			});
			grid.render();
			ds.load({params:{start : 0,limit : 10}});
		});
}
	/**
	 * 计算每月还款额 贷款金额*（"客户要求担保费"+"客户要求中介服务费")
	 * @param loanMoney
	 * @return
	 */
	function countMonthPay(loanMoney,loanQs,monthPay,flag){
		if(document.getElementById(loanMoney).value!=''){
			var q_city=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_APPLY_CITY").value;//申请城市
			var q_product=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_APPLY_LOAN_PRODUCT").value;//产品
			var q_qs=document.getElementById(loanQs).value;//期数
			var q_date=TodayTime();
			var dkje=document.getElementById(loanMoney).value;
			var xydbfl=document.getElementById('APPR_APPROVAL_AGREEMENT_RATE').value;//协议担保费率
			var xyzjfwfl=document.getElementById('APPR_APPROVAL_AGREEMENT_COST').value;//协议中介服务费率
			Ext.Ajax.request({
				url: web_base_path + 'fct/fct.action?flag=17',
				method: 'post',
				params: {city:q_city,product:q_product,date:q_date,qs:q_qs},
				success:function(response, request){
				   var mes=response.responseText;
				   //担保费率,中介服务费率,综合费率,提前清还罚息
				   var dbfl=mes.split("|")[0];
				   var zjfwfl=mes.split("|")[1];
				   var zhfl=mes.split("|")[2];
				   var tqqhfx=mes.split("|")[3];
				   if(dbfl==null || dbfl=='null')dbfl='';
				   if(zjfwfl==null || zjfwfl=='null')zjfwfl='';
				   if(flag!='2' && flag!='3'){
					   $('APPR_APPROVAL_NORMAL_RATE').value=dbfl;
					   $('APPR_APPROVAL_NORMAL_COST').value=zjfwfl;
				   }
				   if(dbfl!='' && zjfwfl!='' && (flag=='1' || flag=='2')){
					   	if(xydbfl!='' && xyzjfwfl!=''){
					   		dbfl=xydbfl;
					   		zjfwfl=xyzjfwfl;
					   	}
					   	countMyhke(zhfl,dkje,q_qs,dbfl,zjfwfl,monthPay);
				   }else if((xydbfl!='' || xyzjfwfl!='') && (flag=='3')){
					   countMyhke(zhfl,dkje,q_qs,xydbfl,xyzjfwfl,monthPay);
				   }else{
				   		document.getElementById(monthPay).value='';
				   }
				},
				failure:function(){
					parent.Ext.Msg.alert('温馨提示','操作失败');
				}
			});
		}else{
			document.getElementById(monthPay).value='';
		}
	}
	
	/**
	 * 文件打印
	 * @param id
	 * @return
	 */
	function printFile(id){
		var guarant_id="";  //担保编号
		var loan_name=parent.document.getElementById('sqrId').contentWindow.document.getElementById("GR_SURNAME").value+parent.document.getElementById('sqrId').contentWindow.document.getElementById("GR_GIVENNAME").value;    //贷款人名称
		var cert_no=parent.document.getElementById('sqrId').contentWindow.document.getElementById("GR_CERT_NO").value;        //贷款人证件号码
		var home_address=parent.document.getElementById('sqrId').contentWindow.document.getElementById("RE_ADDRESS_DETAIL_1").value;//住宅资料1地址
		var db_amt=document.getElementById('APPR_APPROVAL_PH_LOAN_AMOUNT').value;//批核金额           
		var db_period= document.getElementById('APPR_APPROVAL_PH_LOAN_PERIOD').value; //批核期数  
		var guarant_fee=document.getElementById('APPR_APPROVAL_NORMAL_RATE').value; //担保费
		var guarant_service_fee=document.getElementById('APPR_APPROVAL_NORMAL_COST').value;; //担保服务费 
		var apply_amount=document.getElementById('APPR_APPROVAL_LOAN_AMOUNT').value; //申请金额
		var db_date=document.getElementById('APPR_GUAR_GRANT_DATE').value;//发放日期
		
		var GRANT_REPAYMENT_AUTO_BANK_HOLDER="";//还款开户人
		var GRANT_REPAYMENT_AUTO_BANK_ACCOUNT=document.getElementById('GRANT_REPAYMENT_AUTO_BANK_ACCOUNT').value;//还款银行帐号
		var GR_MOBILE=parent.document.getElementById('sqrId').contentWindow.document.getElementById("GR_MOBILE").value;//申请人手机号
		var AGREEMENT_RATE=document.getElementById('APPR_APPROVAL_AGREEMENT_RATE').value;//协议担保费率
		var AGREEMENT_COST=document.getElementById('APPR_APPROVAL_AGREEMENT_COST').value;//协议中介服务费率
		var GRANT_PAY_BANK_TYPE="";//还款银行
		var selectHOLDER = document.getElementById("GRANT_REPAYMENT_AUTO_BANK_HOLDER").selectedIndex;
		var kfr = document.getElementById("GRANT_REPAYMENT_AUTO_BANK_HOLDER").options[selectHOLDER].text;
		if(kfr!=""&&kfr!=null&&kfr.indexOf("┋")>-1){
			GRANT_REPAYMENT_AUTO_BANK_HOLDER=kfr.split("┋")[0];
		}
		var selectACCOUNT = document.getElementById("GRANT_PAY_BANK_TYPE").selectedIndex;
		var hkrh = document.getElementById("GRANT_PAY_BANK_TYPE").options[selectACCOUNT].text;
		if(hkrh!=""&&hkrh!=null&&hkrh.indexOf("┋")>-1){
			GRANT_PAY_BANK_TYPE=hkrh.split("┋")[1];
		}
		
		if(apply_amount!='' && apply_amount!=null){
			guarant_fee=parseFloat(apply_amount*1.1*0.01);
			guarant_service_fee=parseFloat(apply_amount*0.9*0.01);
		}
		var obj = document.getElementById(id);
		var intvalue="";   
		for(var i=0;i<obj.length;i++){
			 if(obj.options[i].selected){   
	            intvalue+=obj.options[i].value+","; 
	        }   
		}
		intvalue=intvalue.substr(0, intvalue.length-1); 
		var arr = intvalue.split(",");//分割字符串
		var paramOne='guarant_id='+guarant_id+'&loan_name='+loan_name+'&cert_no='+cert_no+'&home_address='+home_address+'&db_amt='+db_amt+'&db_period='+db_period+'&guarant_fee='+guarant_fee+'&guarant_service_fee='+guarant_service_fee;
		var paramTwo='guarant_id='+guarant_id+'&loan_name='+loan_name+'&cert_no='+cert_no+'&db_amt='+db_amt+'&db_period='+db_period+'&db_date='+db_date;
		var param6='guarant_id='+guarant_id+'&loan_name='+loan_name+'&cert_no='+cert_no+'&db_amt='+db_amt;
		var param7='guarant_id='+guarant_id+'&loan_name='+loan_name+'&cert_no='+cert_no+'&db_amt='+db_amt+'&home_address='+home_address+'&db_period='+db_period+'&AGREEMENT_RATE='+AGREEMENT_RATE+'&AGREEMENT_COST='+AGREEMENT_COST+'&GRANT_REPAYMENT_AUTO_BANK_ACCOUNT='+GRANT_REPAYMENT_AUTO_BANK_ACCOUNT;
		var param8='guarant_id='+guarant_id;
		
		var param5='guarant_id='+guarant_id+'&GRANT_REPAYMENT_AUTO_BANK_HOLDER='+GRANT_REPAYMENT_AUTO_BANK_HOLDER+'&GRANT_REPAYMENT_AUTO_BANK_ACCOUNT='+GRANT_REPAYMENT_AUTO_BANK_ACCOUNT+'&GRANT_PAY_BANK_TYPE='+GRANT_PAY_BANK_TYPE+'&cert_no='+cert_no+'&GR_MOBILE='+GR_MOBILE;
		for(var k=0;k<arr.length;k++){
			if(arr[k]=='5'){
				window.open(web_base_path+'print/wthkxy.jsp','','width=790px,height=690px,status=no,scrollbars=yes'); //委托划款协议
			}else if(arr[k]=='3'){
				window.open(web_base_path+'print/sqwts.jsp','','width=790px,height=690px,status=no,scrollbars=yes'); //授权委托书
			}else if(arr[k]=='4'){
				window.open(web_base_path+'print/xhjdbcnh.jsp','','width=790px,height=690px,status=no,scrollbars=yes'); //担保承诺函
			}
			else if(arr[k]=='2'){
				window.open(web_base_path+'print/qzy.jsp','','width=790px,height=690px,status=no,scrollbars=yes'); //签字页
			}else if(arr[k]=='1'){
				window.open(web_base_path+'print/zxfwxy.jsp','','width=790px,height=690px,status=no,scrollbars=yes'); //授权委托书
			}
		}
	}
	//贷款批核选择是或否时
	function checkLoanIsNo(id){
		if($(id).value=='02'){
			$('APPR_APPROVAL_LOAN_AMOUNT').value='';//申请金额
			$('APPR_APPROVAL_LOAN_PERIOD').value='';//付还期数
			$('APPR_APPROVAL_MONTH_PAY').value='';//每月还款额（我司）
			$('APPR_APPROVAL_SUGGEST_AMOUNT').value='';//建议批核金额
			$('APPR_APPROVAL_SUGGEST_PERIOD').value='';//建议付还期数
			$('APPR_APPROVAL_SUGGEST_MONTH_PAY').value='';//每月还款额（我司）
			if($('APPR_APPROVAL_PH_LOAN_AMOUNT')!=null){//批核金额
				$('APPR_APPROVAL_PH_LOAN_AMOUNT').value='';
			}
			if($('APPR_APPROVAL_PH_LOAN_PERIOD')!=null){//批核期数
				$('APPR_APPROVAL_PH_LOAN_PERIOD').value='';
			}
			if($('APPR_APPROVAL_PH_MONTH_PAY')!=null){//批核 每月还款额
				$('APPR_APPROVAL_PH_MONTH_PAY').value='';
			}
			$('APPR_APPROVAL_NORMAL_RATE').value='';//正常担保费率
			$('APPR_APPROVAL_NORMAL_COST').value='';//正常中介服务费率
			$('APPR_APPROVAL_AGREEMENT_RATE').value='';//协议担保费率
			$('APPR_APPROVAL_AGREEMENT_COST').value='';//协议中介服务费率
			
		}else if($(id).value=='01'){
			//$('APPR_APPROVAL_NORMAL_RATE').value="1.1";
			//$('APPR_APPROVAL_NORMAL_COST').value="0.9";
			var money=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_APPLY_LOAN_AMOUNT").value;
			var period=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_PAY_PERIOD").value;
			var fl=(1.1+0.9)*0.01;
			if (isNaN(money)){money=0};
			$('APPR_APPROVAL_LOAN_AMOUNT').value=money;
			$('APPR_APPROVAL_LOAN_PERIOD').value=period;
			countMonthPay('APPR_APPROVAL_LOAN_AMOUNT','APPR_APPROVAL_LOAN_PERIOD','APPR_APPROVAL_MONTH_PAY','2');
			//$('APPR_APPROVAL_MONTH_PAY').value=parseFloat(money*fl);	
			$('APPR_APPROVAL_FOLLOW_STATUS').value='';//跟进状况
			$('APPR_APPROVAL_FOLLOW_TYPE').value='';//跟进类型
			$('APPR_APPROVAL_FOLLOW_REASON').value='';//跟进原因
			$('APPR_APPROVAL_FOLLOW_NOTE').value='';//跟进备注
		}
	}
	/***
	 * 赋值
	 * @param id1
	 * @param id2
	 * @return
	 */
 	function getValueSwitch(id1,id2){
 		document.getElementById(id2).value=document.getElementById(id1).value;
 	}
 	//豁免处理
 	var id1="EXEM_EXITEM_TYPE";//豁免类型
 	var id2="EXEM_EXITEM_CODE";//豁免代码 
 	var id3="EXEM_EXITEM_AUTO"; //自动或手动
 	var id4="EXEM_EXITEM_HIGH_TYPE";
 	function custAgeExem(id){
 		var age=parent.document.getElementById('sqrId').contentWindow.document.getElementById('GR_AGE').value;//客户资料-年龄
 		var period=$(id).value/12;
 		var ageExem=age/1+period;
 		var v = document.forms[0].elements;
 		var type,auto,product;
 		for ( var i = 0; i < v.length; i++) {
 			if (v[i].type == "hidden") {
 				if (v[i].id.startWith(id1) == true) {
 					type=$(v[i].id).value;
 				}if(v[i].id.startWith(id3)==true){
 					auto=$(v[i].id).value;
 				}if(v[i].id.startWith(id4)==true){
 					product=$(v[i].id).value;
 				}
 			}if (v[i].type == "checkbox") {
 				if (v[i].id.startWith(id2) && type=='C' && auto=='Y' && $(v[i].id).value=='E01') {
 					if(ageExem>60){
 						$(v[i].id).checked=true;
 					}else{
 						if($(v[i].id).value=='E01'){
 							$(v[i].id).checked=false;
 						}
 					}
 				}
 			}
 	}
 }
 	//将银行账号转*
 	function forBank_noHidden(va,id3,id4,id5){
 	   var bank_c=document.getElementById(id3).value;//要修改的账号
 	   var bank_s=document.getElementById(id4).value;
 	   if(va==1){//账号onblur事件
 	      if(bank_s==""){
 	         //document.getElementById(id5).value="";
 	         document.getElementById(id3).value="";
 	      }else{
 	        if(bank_s!=bank_c){//账号被修改时
 	           //document.getElementById(id5).value="";//清空账号确认
 	           document.getElementById(id3).value=bank_s;
 	        }
 	        var le=bank_s.length;
 	        document.getElementById(id4).value="";
 	        for (var i = 0; i < le; i++) {
 	            document.getElementById(id4).value += "*";
 	         }
 	      }
 	   }else if(va==2){//退款账号确认onblur事件
 	      if(bank_c!=document.getElementById(id5).value){
 	         parent.Ext.Msg.alert('温馨提示','账号输入不一致!',function(e){
 				if(e=='ok'){
 					try{
 				 		document.getElementById(id4).focus();
 				 	}catch(e){
 				 		
 				 	}
 				}
 			});
 	         document.getElementById(id4).value=document.getElementById(id3).value;
 	      }
 	   }
 	}	
 	//用于银行账号*转数字(id1:输入框的账号id，id2：隐藏的真实账号)
 	function forBank_noShow(id1,id2){
 	       if(document.getElementById(id1).value.indexOf("*")>-1){
 	          document.getElementById(id1).value=document.getElementById(id2).value;
 	       }
 	}
 	
 	//省改变时,文本框置红
	function changeApproveProvince(va1,va2,flag){
		var value = $(va1).value;
		if(value!='' && value!=null){
			if(flag!=''){
				var value2 = $(va2).value;
				if(value!=value2){
					$(va1).style.backgroundColor="FF0000";
				}else{
					$(va1).style.backgroundColor="";
				}
			}
			if(value!=provinceLoan && value!='' && provinceLoan!=''){
				$(va1).style.backgroundColor="FF0000";
			}else{
				$(va1).style.backgroundColor="";
			}
		}
		
	}
	//市改变时,文本框置红
	function changeApproveCity(va1,va2,flag){
		var value = $(va1).value;
		if(value!='' && value!=null){
			if(flag!=''){
				var value2 = $(va2).value;
				if(value!=value2){
					$(va1).style.backgroundColor="FF0000";
				}else{
					$(va1).style.backgroundColor="";
				}
			}
			if(value!=cityLoan && value!='' && cityLoan!=''){
				$(va1).style.backgroundColor="FF0000";
			}else{
				$(va1).style.backgroundColor="";
			}
		}
	}
	/**批核信息不可编辑*/
	function DisabledForPhxx(id,mess){
		var v = document.forms[0].elements;
		for ( var i = 0; i < v.length; i++) {
			if (v[i].type == "text") {
				if (v[i].id.startWith(id) == true) {
					$(v[i].id).disabled=mess;
				}
			}  else if (v[i].type == "select-one") {
				if (v[i].id.startWith(id) == true) {
					$(v[i].id).disabled=mess;
				}
			} else if (v[i].type == "textarea") {
				if (v[i].id.startWith(id) == true) {
					$(v[i].id).disabled=mess;
				}
			} else if (v[i].type == "checkbox") {
				if (v[i].id.startWith(id) == true) {
					$(v[i].id).disabled=mess;
				}
			}
		}
	}
