 var d = new Date().getFullYear();//当前年份
 	//当前日期
	function TodayTime(){
		var myDate = new Date();
		var str="";
		var year=myDate.getFullYear();
		var month = myDate.getMonth()+1;
		var day = myDate.getDate(); 
		if(month<10){
			month="0"+month;
		}if(day<10){
			day="0"+day;
		}
		str = year+"-"+month+"-"+day;
		return str;
	}
	//获取下拉框的值
	function getRadioValue(elementName,formName){
		var ele=null;
		if(arguments.length==1)
			ele=document.forms[0].elements[elementName];
		else if(arguments.length==2)
			ele=document.forms[formName].elements[elementName];

		if(!ele)return;
		if('length' in ele){
			if(ele[0].type.toUpperCase()=='RADIO'){
				ele.elementValue=-1;
				for(var i=0;i<ele.length;i++){
					if(ele[i].checked)
						ele.elementValue=ele[i].value;
				}
				return ele.elementValue;
			}
		}
	}
 //校验不能为空
 function checknull(id){
 	var str=$(id).value.length;
	if(str==0){
		$(id).style.borderColor="red";
	}else{
		$(id).style.borderColor="";
	}
 }
 	//以字符开头
 	String.prototype.startWith = function(str) {
		if (str == null || str == "" || this.length == 0
				|| str.length > this.length)
			return false;
		if (this.substr(0, str.length) == str)
			return true;
		else
			return false;
		return true;
	}
	//以字符结尾
	String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  	return false;
	if(this.substring(this.length-str.length)==str)
	  	return true;
	else
	  	return false;
	return true;
	}
	
//校验下拉框不能为空
function checknull2(id){
		var str=$(id).value;
		var tmp = str.length;
		if(tmp==0){
			$(id).style.backgroundColor="red";
		}else{
			$(id).style.backgroundColor="";
		}
	}
	//申请人信息 计算身份证有效期
	function countIDCard(id1,id2,id3){
		var startTime=document.getElementById(id1).value.trim();
		var endTime=document.getElementById(id2).value.trim();
		if(startTime=="" || endTime==""){
			$(id3).value="";
		}else{
		 var startYear = startTime.substring(0,4);
		 var startMonth = startTime.substring(5,7);
		 var startDay = startTime.substring(8,10);
		 var endYear = endTime.substr(0,4);
		 var endMonth = endTime.substr(5,7);
		 var endDay = endTime.substr(8,10);
		 var nowYear = endYear-startYear;
		 var month=endMonth-startMonth;
		 var day=endDay-startDay;
		 if(endYear/1-startYear/1>=1 && startTime!="" && endTime!=""){
			if(day<0){
				month=month-1;
			}
			if(month<0){
				nowYear=nowYear-1;
			}
		 	$(id3).value=nowYear;
		 }else {
		 	$(id3).value=1;
		 }
		}
	}
	
	function regInput(obj, reg, inputStr){
		var docSel= document.selection.createRange();
		if (docSel.parentElement().tagName != "INPUT")	return false;
			oSel = docSel.duplicate();
			oSel.text = "";
			var srcRange= obj.createTextRange();
			oSel.setEndPoint("StartToStart", srcRange);
			var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length);
			return reg.test(str);
	}
	function regInput1(obj, reg){
		var inputStr=String.fromCharCode(event.keyCode);
		var docSel= document.selection.createRange();
		if (docSel.parentElement().tagName != "INPUT")	return false;
			oSel = docSel.duplicate();
			oSel.text = "";
			var srcRange= obj.createTextRange();
			oSel.setEndPoint("StartToStart", srcRange);
			var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length);
			return reg.test(str);
	}
	
	function regInput2(obj, reg){
		var inputStr=window.clipboardData.getData('Text');
		var docSel= document.selection.createRange();
		if (docSel.parentElement().tagName != "INPUT")	return false;
			oSel = docSel.duplicate();
			oSel.text = "";
			var srcRange= obj.createTextRange();
			oSel.setEndPoint("StartToStart", srcRange);
			var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length);
			return reg.test(str);
	}
	function regInput3(obj, reg){
		var inputStr=event.dataTransfer.getData('Text');
		var docSel= document.selection.createRange();
		if (docSel.parentElement().tagName != "INPUT")	return false;
			oSel = docSel.duplicate();
			oSel.text = "";
			var srcRange= obj.createTextRange();
			oSel.setEndPoint("StartToStart", srcRange);
			var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length);
			return reg.test(str);
	}
	function countmyHsYear(id1,year){
		var startTime=document.getElementById(id1).value;
		var start = startTime.substr(0,4);
		if(d-start/1>=1 && startTime!=''){
			$(year).value=d-start/1;
		}else{
			 $(year).value=1;
		}
	}
/**
 * 与谁居住 数据处理
 * @param {Object} id  复选框Name 如果选择独居时 其他则不能选 否则其它与谁居住可多选
 * @param {Object} setId 与谁居住ID
 */
	function dWELL_WITH_WHO(id,setId){
		var r = document.getElementsByName(id);
		var arr=[];
    	for(var i = 0; i < r.length; i++){
        	if(r[i].checked){
        		if(r[i].id=='RE_LIVEALONE'+splitStr(r[i].id)){//选独居时,其它为不可勾选
        			document.getElementById('RE_LIVEPARENT'+splitStr(r[i].id)).checked=false;
					document.getElementById('RE_LIVEBROTHER'+splitStr(r[i].id)).checked=false;
					document.getElementById('RE_LIVESPOUSE'+splitStr(r[i].id)).checked=false;
					document.getElementById('RE_LIVECHILDREN'+splitStr(r[i].id)).checked=false;
					document.getElementById('RE_LIVEWORK'+splitStr(r[i].id)).checked=false;
					arr.push('Y');
        		}else{
        			document.getElementById('RE_LIVEALONE'+splitStr(r[i].id)).checked=false;
        			arr.push('Y');
        		}
        	}else{
        		arr.push('N');
        	}
        	}
    	document.getElementById(setId).value=arr;
	}
	
	//分割字符串
	function splitStr(id){
		var strs= new Array(); //定义数组
		strs=id.split("_");
		var spstr="_"+strs[2];
		return spstr;
	}

	function countHsTotalPrice(price,area,totalPrice){
		var price=document.getElementById(price).value;
		var area=document.getElementById(area).value;
		var total=price*area;
		if(total.toFixed(2)=='0.00'){
			document.getElementById(totalPrice).value="";
		}else{
			var sumValue=total.toFixed(2);
			sumValue=parseFloat(sumValue);
			document.getElementById(totalPrice).value=sumValue;
		}
	}
	//商业资料 公司名称，字号
	function clearCom(id1,id2,id3,id4){
		var value1 = $(id1).value;
		var value2 = $(id2).value;
		if(id4!=''){
			var value4 = $(id4).value;
		}
		if(value1!=value2 && id3!=''){
			$(id3).value='';
		}else if(value1==value2 && id4!=''){
			$(id3).value=$(id4).value;
		}
	}
	
	function notnullOne(id){
		var str=$(id).value;
		if(str==""){
			alert('必录项未录，请输入');
			$(id).style.borderColor="red";
			$(id).focus();
			return false;
		}else{
			$(id).style.borderColor="";
		}
		return true;
	}
	/**
	 * 验证身份证号码
	 * @param {} id 证件号
	 * @param {} id2 证件类型
	 * @return {Boolean}
	 */
	function IDCheck(id, id2) {
		if (!notnullOne(id))
		return false;
		var idcard = $(id).value;
		idcard=idcard.toLocaleUpperCase();
		$(id).value=idcard;
		var len = idcard.length;
		var str1 = $(id2).value;
		if (str1 == 'CN' && idcard != '') {
			var i = checkIdcard(idcard);
			var Errors = new Array("验证通过!", "身份证号码位数不对,请输入15位或者18位身份证号码",
					"身份证号码出生日期验证错误", "身份证号码错误,请输入正确的身份证号码", "身份证地区非法!");
			var result = checkIdcard(idcard);
			if (result != 0) {
				parent.Ext.Msg.alert('温馨提示',Errors[result],function(e){
				if(e=='ok'){
					try{
						$(id).focus();
					}catch(e){
				
					}
				}
				});
				return false;
			}
			if (len == 18) {
				var sex = idcard.charAt(16);
			}
		}
		return true;
	}
	
	function checkIdcard(idcard){
		var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江", 31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北", 43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏", 61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"} 
		var Y,JYM;
		var S,M;
		var idcard_array = new Array();
		idcard_array = idcard.split("");
		//地区检验
		if(area[parseInt(idcard.substr(0,2))]==null) return 4;
	    //身份号码位数及格式检验
		switch(idcard.length){
			case 15:
				if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
				ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/; //测试出生日期的合法性
				} else {
				ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性
				}
				if(ereg.test(idcard)) return 0;
				else return 2;
				break;
			case 18:
				//18位身份号码检测
				//出生日期的合法性检查 
				//闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
				//平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
				if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
					ereg=/^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式
				} else {
					ereg=/^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式
				}
				if(ereg.test(idcard)){//测试出生日期的合法性
						//计算校验位
						S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
						+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
						+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
						+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
						+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
						+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
						+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
						+ parseInt(idcard_array[7]) * 1 
						+ parseInt(idcard_array[8]) * 6
						+ parseInt(idcard_array[9]) * 3 ;
						Y = S % 11;
						M = "F";
						JYM = "10X98765432";
						M = JYM.substr(Y,1);//判断校验位
						
					if(M == idcard_array[17]) return 0; //检测ID的校验位
					else return 3;
				}else return 2;
				break;
			default:
				return 1;
			break;
		}
	}
	/**
	 * 通过证件类型和证件号码带出年龄，性别，出生日期
	 * @param id1 证件类型
	 * @param id2 证件号
	 * @param id3 出生日期
	 * @param id4 年龄
	 * @return
	 */
	function queryInfoForCert(id1,id2,id3,id4){
		var city=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_APPLY_CITY").value;
	 	var type = $(id1).value;
	 	var no = $(id2).value;
	 	if(type=='CN'){
	 		if(no.length==18){//证件号为18位
	 			if(!IDCheck(id2,id1)) return false;
	 			var str = no.substring(6,14);
	 			$(id3).value=str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6,8);
	 			var str2 = no.substring(16,17);
	 			countAge(id4,no.substring(6,14));
	 			if(str2%2!=0){
	 				$('SQR_MAN').checked=true;
	 			}else{
	 				$('SQR_WOMAN').checked=true;
	 			}
	 			isAllApply(type,no,city);
	 		}else{
	 			parent.Ext.Msg.alert('温馨提示','身份证号码位数错误,请输入18位证件号码');
	 		}
	 	}else{
	 		$(id3).value='';
	 		$(id4).value='';
	 	}
	}
	/**
	 * 验证担保系统中是否存在申请中记录
	 * @param type 证件类型
	 * @param no 证件号
	 * @return
	 */
	function isAllApply(type,no,city){
		Ext.Ajax.request({
			params: {
			   	cert_type:type,
			   	cert_no:no,
			   	city:city
			},
			url: web_base_path+'apply/applyExtend.action?isC=5',
			callback:function(options,success,response){
			   var obj = Ext.util.JSON.decode(response.responseText);
			   if(obj.success){
			   	parent.Ext.Msg.alert('温馨提示','此证件号在系统中存在申请,不能重复申请');
			   	if(document.getElementById('GR_CERT_NO')!=null)document.getElementById('GR_CERT_NO').value='';
			   	if(document.getElementById('GR_BIRTHDAY')!=null)document.getElementById('GR_BIRTHDAY').value='';
			   	if(document.getElementById('GR_AGE')!=null)document.getElementById('GR_AGE').value='';
			   	if(document.getElementById('SQR_MAN')!=null)$('SQR_MAN').checked=false;
			   	if(document.getElementById('SQR_WOMAN')!=null)$('SQR_WOMAN').checked=false;
			  }
			}
		});
	}
	 /**
	  * 通过证件号计算年龄
	  * @param id
	  * @param bir
	  * @return
	  */
	 function countAge(id,bir){
		 bir=bir.replaceAll('/','');
		var today = TodayTime();//今天
		var today_year = today.substring(0,4);
		var today_month = today.substring(5,7);
		var today_day  = today.substring(8,10);
		var start_year = bir.substring(0,4);
		var start_month =bir.substring(4,6);
		var start_day = bir.substring(6,8);
		var nowYear = today_year-start_year;
		var day = today_day-start_day;
		var month = today_month-start_month;
		if(day<0){
			month=month-1;
		}
		if(month<0){
			nowYear=nowYear-1;
		}
		document.getElementById(id).value=nowYear;
	 }
	 
	 //总贷款额度
	function totalLoan(id){
		var sumValue
		var hs=$('GR_SELF_HOUSE_LOAN_AMOUNT').value;
		var bs=$('GR_SELF_CAR_LOAN_AMOUNT').value;
		var qt=$('GR_OTHER_LOAN_AMOUNT').value;
		var loan=$('GR_UNSECURED_LOAN_AMOUNT').value;
		var card=$('GR_CREDITCARD_LOAN_AMOUNT').value;
		if (isNaN(hs)){hs=0}
		if (isNaN(bs)){bs=0}
		if (isNaN(qt)){qt=0}
		if (isNaN(loan)){loan=0}
		if (isNaN(card)){card=0}
		sumValue=hs/1+bs/1+qt/1+loan/1+card/1;
		sumValue=sumValue.toFixed(2);
		sumValue=parseFloat(sumValue);
		$(id).value=sumValue;
	}
	//总每月供款
	function totalMonthLoan(id){
		var sumValue
		var hs=$('GR_SELF_HOUSE_MONTH_CONT').value;
		var bs=$('GR_SELF_CAR_MONTH_CONT').value;
		var qt=$('GR_OTHER_MONTH_CONT').value;
		var loan=$('GR_UNSECURED_MONTH_CONT').value;
		var card=$('GR_CREDITCARD_MONTH_CONT').value;
		if (isNaN(hs)){hs=0}
		if (isNaN(bs)){bs=0}
		if (isNaN(qt)){qt=0}
		if (isNaN(loan)){loan=0}
		if (isNaN(card)){card=0}
		sumValue=hs/1+bs/1+qt/1+loan/1+card/1;
		sumValue=sumValue.toFixed(2);
		sumValue=parseFloat(sumValue);
		$(id).value=sumValue;
	}
	//总贷款余额
	function totalMoneyLoan(id){
		var sumValue
		var hs=$('GR_SELF_HOUSE_LOAN_BALANCE').value;
		var bs=$('GR_SELF_CAR_LOAN_BALANCE').value;
		var qt=$('GR_OTHER_LOAN_BALANCE').value;
		var loan=$('GR_UNSECURED_LOAN_BALANCE').value;
		var card=$('GR_CREDITCARD_LOAN_BALANCE').value;
		if (isNaN(hs)){hs=0}
		if (isNaN(bs)){bs=0}
		if (isNaN(qt)){qt=0}
		if (isNaN(loan)){loan=0}
		if (isNaN(card)){card=0}
		sumValue=hs/1+bs/1+qt/1+loan/1+card/1;
		sumValue=sumValue.toFixed(2);
		sumValue=parseFloat(sumValue);
		$(id).value=sumValue;
	}
	
	function checkLoanApp(id,flag){
 		var str = $(id).value;
 		if((str.trim()==01  || str.trim()=='') && (flag=='1' || flag=='2')){
 			$("YLoanApp").style.display="block";
 			$("NLoanApp").style.display="none";
 			$(id).value='01';
 			checkLoanIsNo('APPR_APPROVAL_IS_APPROVAL');
 			//是
 		}else if((str.trim()==02 && str.trim()!='') && flag=='2'){
 			$("YLoanApp").style.display="none";
 			$("NLoanApp").style.display="block";
 			//否
 		}else if(str.trim()==''){
 			$("YLoanApp").style.display="none";
 			$("NLoanApp").style.display="none";
 		}
 	}
 	
	/**
	 * 房产查询资料
	 * @param id
	 * @param id2
	 * @param id3
	 * @param id4
	 * @return
	 */
	function hsSelectData(id,id2,id3,id4){
		var val1 = getRadioValue(id);
		if(val1=='Y'){
			$(id2).disabled=false;
			$(id3).disabled=false;
			$(id4).disabled=false;
			$(id2).value='';
			$(id3).value='';
			$(id4).value='';
		}else{
			$(id2).disabled=true;
			$(id3).disabled=true;
			$(id4).disabled=true;
		}
	}
	/**
	 * 清除客户资料录入的数据
	 * @param id
	 * @param id2
	 * @return
	 */
	function ResetControl(id,id2) {
		var v = document.forms[0].elements;
		for ( var i = 0; i < v.length; i++) {
			if (v[i].type == "text") {
				if(v[i].id.startWith(id)==true && id=='GR_SPOUSE_'){
					document.getElementById(v[i].id).value="";
				}else{
					if (v[i].id.startWith(id) == true && v[i].id.endWith(id2) == true) {
						document.getElementById(v[i].id).value="";
					}
				}
				
			} else if (v[i].type == "radio") {
				if(id=='HS_'){
					if (v[i].id.startWith('HS_') == true && v[i].id.endWith(id2) == true) {
						document.getElementById(v[i].id).checked=false;
					}
				}else if(id=='BS_'){
					if (v[i].id.startWith('BS_') == true && v[i].id.endWith(id2) == true) {
						document.getElementById(v[i].id).checked=false;
					}
				}else if(id=='RE_'){
					if (v[i].id.startWith('GR_SPOUSE') == true && v[i].id.endWith(id2) == true) {
						document.getElementById(v[i].id).checked=false;
					}
				}else if(id=='LM_'){
					if (v[i].id.startWith('LM_') == true && v[i].id.endWith(id2) == true) {
						document.getElementById(v[i].id).checked=false;
					}
				}else if(id=='GR_SPOUSE_'){
					if(v[i].id.startWith('GR_SPOUSE_') == true){
						document.getElementById(v[i].id).checked=false;
					}
				}
			} else if (v[i].type == "checkbox") {
				if(id=='RE_'){
					if (v[i].id.startWith("RE_") == true && v[i].id.endWith(id2) == true) {
						document.getElementById(v[i].id).checked=false;
						document.getElementById('RE_DWELL_WITH_WHO'+splitStr(v[i].id)).value='';
				}
			} 
			}else if (v[i].type == "select-one") {
				if (v[i].id.startWith(id) == true && v[i].id.endWith(id2) == true) {
					 if(v[i].id.startWith("RE_ADDRESS_CITY") || v[i].id.startWith("RE_ADDRESS_AREA") ||
					 v[i].id.startWith("HS_ADDRESS_CITY") || v[i].id.startWith("HS_ADDRESS_AREA") ||
					 v[i].id.startWith("BS_ADDRESS_CITY") ||
					 v[i].id.startWith("BS_ADDRESS_AREA") ||
					 v[i].id.startWith("BS_INDUSTRY") ||
					 v[i].id.startWith("BS_WORK_LEVEL") ||
					 v[i].id.startWith("LM_DWELL_ADDRESS_CITY") ||
					 v[i].id.startWith("LM_DWELL_ADDRESS_AREA")){
					optionsClear(document.getElementById(v[i].id));
					}else{
						v[i].options[0].selected = true;
					}
				}
			}else if(v[i].type=="textarea" && v[i].id.endWith(id2) == true && v[i].id.startWith(id)){
				document.getElementById(v[i].id).value="";
			}
		}
	}
	/**
	 * 添加fieldset 初始化下拉框的值
	 * @param id
	 * @param name
	 * @return
	 */
	function initSelectParams(id,name){
		new Ajax.Request(web_base_path+'param/ParameterAction.action',{
			parameters:{flag:'14',mapName:name},
			onComplete:function(response, options){
				var arr = Ext.util.JSON.decode(response.responseText);
				var obj = document.getElementById(id);
				for(var i=0;i<arr.length;i++){
					var Option=document.createElement("OPTION"); 
					Option.value=arr[i]["value"]; 
					Option.text=arr[i]["value"]+"┋"+arr[i]["name"];
					obj.options.add(Option); 
				}
			}
		});
	}
	/**
	 * 新增客户资料 初始化省
	 * @param id
	 * @return
	 */
	function initProvinceParams(id){
		var select = document.getElementById(id);
		new Ajax.Request(web_base_path+'param/ParameterAction.action',{
			parameters:{flag:'15'},
			onComplete:function(response, options){
				var arr = Ext.util.JSON.decode(response.responseText);
				for(var i=0;i<arr.length;i++){
					var Option=document.createElement("OPTION"); 
					Option.value=arr[i]["value"]; 
					Option.text=arr[i]["value"]+"┋"+arr[i]["name"];
					select.options.add(Option); 
				}
			}
		});
	}
	/**
	 * 页面字段是否可编辑
	 * @param mess
	 * @return
	 */
	function pageDisable(mess){
		var domSels = document.getElementsByTagName("select");
		var domInputs = document.getElementsByTagName("input");
		var domTextareas = document.getElementsByTagName("textarea");
		//下拉框
		if (domSels && domSels.length > 0) {
			for ( var i = 0; i < domSels.length; i++) {
				if(domSels[i].type=="select-one" || domSels[i].type=="select-multiple"){
					domSels[i].disabled=mess;
				}
			}
		}
		//input
		if (domInputs && domInputs.length > 0) {
			for ( var i = 0; i < domInputs.length; i++) {
				if(domInputs[i].type=="text" || domInputs[i].type=="radio" || domInputs[i].type=="checkbox" || domInputs[i].type=="password"){
					domInputs[i].disabled=mess;
				}
			}
		}
		//textarea
		if (domTextareas && domTextareas.length > 0) {
			for ( var i = 0; i < domTextareas.length; i++) {
				if(domTextareas[i].type=="textarea"){
					domTextareas[i].disabled=mess;
				}
			}
		}
	}
	//商业资料 计算每月总收入
	function totalBusIncome(id1,id2,id3){
		var sumValue=$(id1).value/1+$(id2).value/1;
		sumValue=sumValue.toFixed(2);
		sumValue=parseFloat(sumValue);
		$(id3).value=sumValue;
	}
	String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
	    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
	        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
	    } else {  
	        return this.replace(reallyDo, replaceWith);  
	    }  
	} 
	//页面不可编辑
	function colorBlue(mess){
		var domSels = document.getElementsByTagName("select");
		var domInputs = document.getElementsByTagName("input");
		var domTextareas = document.getElementsByTagName("textarea");
		//下拉框
		if (domSels && domSels.length > 0) {
			for ( var i = 0; i < domSels.length; i++) {
				if(domSels[i].type=="select-one" || domSels[i].type=="select-multiple"){
					domSels[i].disabled=mess;
				}
			}
		}
		//input
		if (domInputs && domInputs.length > 0) {
			for ( var i = 0; i < domInputs.length; i++) {
				if(domInputs[i].type=="text" || domInputs[i].type=="radio" || domInputs[i].type=="checkbox" || domInputs[i].type=="password"){
					domInputs[i].disabled=mess;
				}
			}
		}
		//textarea
		if (domTextareas && domTextareas.length > 0) {
			for ( var i = 0; i < domTextareas.length; i++) {
				if(domTextareas[i].type=="textarea"){
					if(domTextareas[i].id=='APPR_APPROVAL_NOTE'){
						domTextareas[i].disabled=false;
					}else{
						domTextareas[i].disabled=mess;
					}
				}
			}
		}
	}

	/*计算每月还款额
	【综合费率/12*贷款金额*（1+综合费率/12））^期数】/【（（1+综合费率/12））^期数-1】+每期担保费+每期利息
	*/
	function countMyhke(zhfl,dkje,qs,dbfl,zjfwfl,monthPay){
		zhfl=zhfl*0.01;
		var v1=zhfl/12*dkje;
		var v2=1+zhfl/12;
		v2=Math.pow(v2,qs);
		var v3=parseFloat(v1*v2);
		v4=Math.pow(parseFloat(1+zhfl/12),qs)-1;
		var vv = parseFloat(v3/v4).toFixed(2);
		var vtotal=zjfwfl*0.01*dkje+dbfl*0.01*dkje;
		vtotal=parseFloat(vtotal).toFixed(2);
		vv=vv/1+vtotal/1;
		vv=vv.toFixed(2);
		if(vv=='NaN') vv='';
		document.getElementById(monthPay).value=vv;
	}
	
	/**获取旧数据*/
	function queryHisCustomer(cert_type,cert_no){
		var flag=1;
		var c1=document.getElementById(cert_type).value;
		var c2=document.getElementById(cert_no).value;
		var c3=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_APPLY_CITY").value;
		var c4=parent.document.getElementById('sqdId').contentWindow.document.getElementById("SQD_APPLY_CODE").value;
		Ext.Ajax.request({
			url: web_base_path + '/history/hisdata.action',
			method: 'post',
			params: {'cert_type':c1,'cert_no':c2,'city':c3,flag:'2'},
			success:function(response, request){
				var mes = Ext.util.JSON.decode(response.responseText);
				if(mes.flag=='-1'){
					alert("系统中不存在此人申请记录！");
				}else if(mes.flag=='1'){
					alert("系统中有此人历史数据!");
					window.location=web_base_path+"history/hisdata.action?flag="+flag+'&cert_type='+c1+'&cert_no='+c2+'&city='+c3+'&apply_code='+c4;
				}
			},
			failure:function(){
				 Ext.Msg.alert("温馨提示","查询历史数据异常！");
			}
		});
	}
