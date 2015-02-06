/**
 * 下拉框必填校验
 * @param id
 * @param msg
 * @return
 */
function selectJudge(id,msg){
	 if($(id)!=null){
		 var str=$(id).value;
			if(str==""){
				parent.Ext.Msg.alert('温馨提示',msg,function(e){
					if(e=='ok'){
						try{
					 		$(id).focus();
					 	}catch(e){
					 		
					 	}
					}
				});
				$(id).style.backgroundColor="FF0000";
				return false;
			}else{
				$(id).style.backgroundColor="";
				return true;
			} 
	 }
	return true;
}
/**
 * 输入框不能为空
 * @param id
 * @param msg
 * @return
 */
function notnull(id,msg){
	if($(id)!=null){
		var str=$(id).value;
		if(str==""){
			parent.Ext.Msg.alert('温馨提示',msg,function(e){
				if(e=='ok'){
					try{
				 		$(id).focus();
				 	}catch(e){
				 		
				 	}
				}
			});
			$(id).style.borderColor="red";
			return false;
		}else{
			$(id).style.borderColor="";
		}
	}
	return true;
}
	//radio
	function checkSpanRadio(id,id2,msg){
		if(checkRadioCheck(id)==false){
			parent.Ext.Msg.alert('温馨提示',msg);
			$(id2).style.backgroundColor="FF0000";
			return false;
		}else{
			$(id2).style.backgroundColor="";
			return true;
		}
		return true;
	}
	//判断Radio是否被选中
	function checkRadioCheck(name){
			var myObj=document.getElementsByName(name);
			for(var j=0;j<myObj.length;j++){
				if(myObj[j].checked){
					return true;
				}
			}
			return false;
		}
	/**
	 * 检查数字
	 * @param id
	 * @param msg
	 * @param v
	 * @return
	 */
	function checkNumber(id,msg,msg2,v){
		var str = $(id).value ;
	 	if(str!=''){
	 		if(str<=v){
	 			parent.Ext.Msg.alert('温馨提示',msg,function(e){
					if(e=='ok'){try{$(id).focus();}catch(e){}
					}
				});
	 		$(id).style.borderColor="red";
			$(id).focus();
			return false;
	 	}else {
	 		$(id).style.borderColor="";
	 	}
		}else{
			parent.Ext.Msg.alert('温馨提示',msg2,function(e){
				if(e=='ok'){try{$(id).focus();}catch(e){}
				}
			 });
			 $(id).style.borderColor="red";
			 $(id).focus();
			 return false;
		 }
	 	return true;
	}
	//申请单页面校验
	function verifySqd(){
		if(!verifyLoan()){
			parent.checkFlag=true;
			return false;
		}
		parent.checkFlag=false;
		return true;
	}
	//客户资料和批核信息页面校验
	function verifyApply(){
		if(!verifyCustBasic()){
			parent.checkFlag=true;
			return false;
		}
		if(!verifyRe()){
			parent.checkFlag=true;
			return false;
		}
		if(!verifyAllBs()){
			parent.checkFlag=true;
			return false;
		}
		
		if(!verifyAllLm()){
			parent.checkFlag=true;
			return false;
		}
		parent.checkFlag=false;
		return true;
	}
	
	//校验批核信息
	function verifyAllPhxx(){
		if(!verifyPhxx()){
			parent.checkFlag=true;
			return false;
		}
		if(parent.pastation=='A4'){
			if(!verifyLoanInfo()){
				parent.checkFlag=true;
				return false;
			}
		}
		parent.checkFlag=false;
		return true;
	}
	
	//校验商业资料
	function verifyAllBs(){
		if(!verifyBs()){
			parent.checkFlag=true;
			return false;
		} 
		if(!verifyBsName()){
			parent.checkFlag=true;
			return false;
		} 
		if(!verifyBsCode()){
			parent.checkFlag=true;
			return false;
		} 
		if(!verifyBsDz()) {
			parent.checkFlag=true;
			return false;
		}
		if(!verifyBsDzT()) {
			parent.checkFlag=true;
			return false;
		}
		if(!verifyBsOrg()){
			parent.checkFlag=true;
			return false;
		}
		if(!verifyBsZf()){
			parent.checkFlag=true;
			return false;
		}
		parent.checkFlag=false;
		return true;
	}
	
	/**客户贷款信息校验*/
	function verifyLoan(){
		if(!checkSpanRadio("GR_IS_MAINLOANER","SPAN_MAIN_LOANER","主贷人不能留空")) return false;
		if(!checkNumber("SQD_APPLY_LOAN_AMOUNT","申请金额必须大于0","申请金额不能为空","0")) return false;
		if(!checkNumber("SQD_PAY_PERIOD","付款期数必须大于0","付款期数不能为空","0")) return false;
		if(!selectJudge("SQD_APPLY_LOAN_PRODUCT","贷款产品不能为空")) return false;
		if(!selectJudge("SQD_APPLY_CHANNAL","渠道不能为空")) return false;
		if($('SQD_SALE_GROUP')!=null && $('SQD_SALE_GROUP').value!=''){//如果销售组不为空，则代理人号码必填
			if(!selectJudge("SQD_AGENT_NUMBER","代理人号码不能为空")) return false; //媒体 来源 贷款用途 渠道
		}
		if(!selectJudge("SQD_MEDIUM","媒体不能为空")) return false; //媒体 来源 贷款用途 渠道
		if(!selectJudge("SQD_SOURCE","来源不能为空")) return false;
		if(!selectJudge("SQD_LOAN_PURPOSE","贷款用途不能为空")) return false;
		if(!selectJudge("SQD_BORROWER_TYPE","借款人类型不能为空")) return false;
		return true;
	}
	/**客户基本资料*/
	function verifyCustBasic(){
		//姓，名，出生日期，户口所在地省，户口所在地市，籍贯，性别，婚姻状况，身份证有效期起，止，年，中国身份证地址，省，市，区
		if(!selectJudge("GR_CERT_TYPE","证件类型不能为空")) return false;
		if(!notnull("GR_CERT_NO","身份证号码不能为空")) return false;		
		if(!notnull("GR_SURNAME","姓不能为空")) return false;
		if(!notnull("GR_GIVENNAME","名不能为空")) return false;
		if(!notnull("GR_BIRTHDAY","出生日期不能为空")) return false;
		if(!notnull("GR_RPR_PROVINCE","省不能为空")) return false;
		if(!notnull("GR_RPR_CITY","市不能为空")) return false;
		if(!notnull("GR_NATIVE_PLACE","籍贯不能为空")) return false;
		if(!notnull("GR_CERT_NO","身份证号码不能为空")) return false;
		if(!checkSpanRadio("GR_SEX","SPAN_SEX","性别不能留空")) return false; 
 		if(!selectJudge("GR_MARITAL_STATUS","婚姻状况不能留空")) return false;
 		if(!selectJudge("GR_EDUCATION_LEVEL","教育程度不能留空")) return false;
 		if(!notnull("GR_ID_CARD_VALIDITY_FROM","身份证有效期起不能为空")) return false;
 		if(!notnull("GR_ID_CARD_VALIDITY_TO","身份证有效期止不能为空")) return false;
 		if(!notnull("GR_ID_CARD_VALIDITY_PERIOD","身份证有效期不能为空")) return false;
 		if(!selectJudge("GR_ID_CARD_ADDRESS_PROVINCE","中国身份证上的地址省不能留空")) return false;
 		if(!selectJudge("GR_ID_CARD_ADDRESS_CITY","中国身份证上的地址市不能留空")) return false;
 		if(!selectJudge("GR_ID_CARD_ADDRESS_AREA","中国身份证上的地址区不能留空")) return false;
 		if(!notnull("GR_ID_CARD_ADDRESS_DETAIL","中国身份证上的地址不能留空")) return false;
 		if($('GR_EMAIL')!=null && $('GR_EMAIL').value!=''){
 			return isValidMail('GR_EMAIL','电子邮件格式有误！');
 		}
 		if(!verifyAppBirSex()) return false;
 		return true;
	}
	/*校验电邮地址*/
	function isValidMail(id,msg) {                      
		var Regex = /^(?:\w+\.?)*\w+@(?:\w+\.)*\w+$/; 
		var str=$(id).value;
		if (Regex.test(str)){                
			return true;          
		}else{
			parent.Ext.Msg.alert('温馨提示',msg,function(e){
				if(e=='ok'){
					try{
				 		$(id).focus();
				 	}catch(e){
				 		
				 	}
				}
			return false;
			});
			}                
	} 
	//校验申请人基本信息出生日期和性别
	function verifyAppBirSex(){
		var certtype=$("GR_CERT_TYPE").value;
		var certno=$("GR_CERT_NO").value;
		if(certtype=='CN' && certno.length==18){
			var str = certno.substring(6,14);
			var str2 = certno.substring(16,17);
			var birth=str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6,8);
			if(birth!=$("GR_BIRTHDAY").value){
				parent.Ext.Msg.alert('温馨提示','出生日期选择不正确!');
				$("GR_BIRTHDAY").style.borderColor="red";
				return false;
			}
			if(str2%2!=0){
				if(!$("SQR_MAN").checked){
					parent.Ext.Msg.alert('温馨提示','性别选择不正确!');
					$("SPAN_SEX").style.backgroundColor="FF0000";
					return false;
				}else{
					$("SPAN_SEX").style.backgroundColor="";
					return true;
				}
			}else{
				if(!$("SQR_WOMAN").checked){
					parent.Ext.Msg.alert('温馨提示','性别选择不正确!');
					$("SPAN_SEX").style.backgroundColor="FF0000";
					return false
				}else{
					$("SPAN_SEX").style.backgroundColor="";
					return true;
				}
			}
			
		}else{
			return true;
		}
		return true;
	}
	//校验住宅 省，市，区，地址,住宅性质，总人数，居住时间起，止，年限，
	function verifyRe(){
		for(var i=1;i<=re;i++){
			if(!selectJudge("RE_ADDRESS_PROVINCE_"+i+"","住宅资料-省不能留空")) return false;
			if(!selectJudge("RE_ADDRESS_CITY_"+i+"","住宅资料-市不能留空")) return false;
			if(!selectJudge("RE_ADDRESS_AREA_"+i+"","住宅资料-区不能留空")) return false;
			if(!selectJudge("RE_ADDRESS_DETAIL_"+i+"","住宅资料-地址不能留空")) return false;
			if($("RE_ADDRESS_DETAIL_"+i+"")!=null && $("RE_ADDRESS_DETAIL_"+i+"").value!=''){
				if(!notnull("RE_POST_CODE_"+i+"","住宅资料-地址不为空,邮政编码不能留空")) return false;
			}
			if(!notnull("RE_DWELL_TIME_FROM_"+i+"","住宅资料-起始居住时间不能留空")) return false;
			if(!selectJudge("RE_DWELLING_TYPE_"+i+"","住宅资料-住宅类别不能留空")) return false;
			if(!notnull("RE_CONT_OR_RENT_AMOUNT_"+i+"","住宅资料-按揭供款租金不能留空")) return false;
			if(!notnull("RE_DWELL_TIME_LIMIT_"+i+"","住宅资料-居住年限不能留空")) return false;
			if(!checkSpanOtherRadio("RE_LIVEALONE_"+i+"","SPAN_DWELL_WITH_WHO_"+i+"","RE_OTHER_"+i+"","住宅资料-与谁居住不能留空"))return false; //与谁居住
			if(!notnull("RE_DWELL_NUMBER_"+i+"","住宅资料-总人数不能留空")) return false;
			if(!dwellWithWho("RE_DWELL_WITH_WHO_"+i+"","RE_DWELL_NUMBER_"+i+"")) return false;
		}
		return true ;
	}
	//居住人数
	function dwellWithWho(id,id2){
		var count=0;
		if($(id)!=null && $(id).value!='' || ($(id2)!=null && $(id2).value!='')){
			var indexRe = $(id).value;
			var v = indexRe.substring(0,1);
			if(v.indexOf('Y')>=0){ //与谁居住选择独居时 总人数只能为1
				if($(id2).value!=1){
					parent.Ext.Msg.alert('温馨提示','与谁居住为独居时,总人数只能为1');
					count++;
					return false;
				}
			}else if(v.indexOf('Y')<0){ //选择非独居时,总人数需大于1
				if($(id2).value<=1){
					parent.Ext.Msg.alert('温馨提示','与谁居住不是独居时,总人数必须大于1');
					count++;
					return false;
				}
			}
		}
		if(count!=0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 校验-住宅资料-与谁居住
	 * @param id
	 * @param id2
	 * @param id3
	 * @param msg
	 * @return
	 */
	function checkSpanOtherRadio(id,id2,id3,msg){
		var other="";
		if($(id3)!=null && $(id3).value!=''){
			other=$(id3).value;
		}
		if($(id)!=null && $(id2)!=null && $(id3)!=null){
			if(checkRadioCheck(id)==false && other==""){
				$(id2).style.backgroundColor="FF0000";
				$(id3).style.borderColor="red";
				return false;
			}else{
				$(id2).style.backgroundColor="";
				$(id3).style.borderColor="";
				return true;
			}
		}
		return true;
	}
	//商业资料 基本信息
	function verifyBs(){
		for(var i=1;i<=bs;i++){
			if(!selectJudge("BS_UNIT_KIND_"+i+"","商业资料-单位性质不能留空")) return false;
			if(!selectJudge("BS_INDUSTRY_"+i+"","商业资料-所属行业不能留空")) return false;
			if(!selectJudge("BS_WORK_LEVEL_"+i+"","商业资料-工作级别不能留空")) return false;
			if(!checkSpanRadio("BS_IS_SELF_EMPLOYED_"+i+"","SPAN_IS_SELF_EMPLOYED_"+i+"","商业资料-是否自雇人士不能留空")) return false; 
			if(!notnull("BS_BASE_SALARY_"+i+"","商业资料-基本薪金不能留空")) return false;
			if($('BS_BASE_SALARY_'+i+'')!=null && $('BS_BASE_SALARY_'+i+'').value!=''){
				if(!notnull("BS_PAY_PATTERN_"+i+"","商业信息-支付方式不能留空")) return false;
			}
			if($("BS_TEL_AREA_"+i+"")!=null && $("BS_TEL_AREA_"+i+"").value!=""){
			 	if(!notnull("BS_TEL_NUMBER_"+i+"","商业资料-区号填写,商业资料-号码不能留空")) return false;
			}
			if($("BS_TEL_NUMBER_"+i+"")!=null && $("BS_TEL_NUMBER_"+i+"").value!=""){
			 	if(!notnull("BS_TEL_AREA_"+i+"","商业资料-号码填写,商业资料-区号不能留空")) return false;
			}
		}
		return true ;
	}
	//商业资料 公司地址不为空时 地址、省、市、区、邮政编码、公司电话、服务年数、职务、是否公司东主不能留空
	function verifyBsName(){
		for(var i=1;i<=bs;i++){
			if($("BS_COMPANY_NAME_"+i+"")!=null && $("BS_COMPANY_NAME_"+i+"").value!=''){
				if(!notnull("BS_SHOP_NAME_"+i+"","公司名称不为空时,字号不能留空")) return false;
				if(!selectJudge("BS_PROVINCE_"+i+"","公司名称不为空时,省不能留空")) return false;
				if(!selectJudge("BS_ADDRESS_CITY_"+i+"","公司名称不为空时,市不能留空")) return false;
				if(!selectJudge("BS_ADDRESS_AREA_"+i+"","公司名称不为空时,区不能留空")) return false;
				if(!notnull("BS_ADDRESS_DETAIL_"+i+"","公司名称不为空时,地址不能留空")) return false;
				if(!notnull("BS_POST_CODE_"+i+"","公司名称不为空时,邮政编码不能留空")) return false;
				//if(!notnull("BS_TEL_AREA_"+i+"","公司名称不为空时,公司电话-区号不能留空")) return false;
				//if(!notnull("BS_TEL_NUMBER_"+i+"","公司名称不为空时,公司电话-主机号不能留空")) return false;
				if(!notnull("BS_SERVICE_YEARS_"+i+"","公司名称不为空时,服务年数年不能留空")) return false;
				if(!notnull("BS_SERVICE_MONTHS_"+i+"","公司名称不为空时,服务年数月不能留空")) return false;
				if(!notnull("BS_POSITION_"+i+"","公司名称不为空时,职务不能留空")) return false;
				if(!checkSpanRadio("BS_IS_OWNER_"+i+"","SPAN_IS_OWNER_"+i+"","公司名称不为空时,是否公司东主不能留空")) return false;
			}
		}
		return true;
	}
	//邮编
	function verifyBsCode(){
		for(var i=1;i<=bs;i++){
			if($("BS_ADDRESS_AREA_"+i+"")!=null && $("BS_ADDRESS_AREA_"+i+"").value!=''){
				if(!notnull("BS_POST_CODE_"+i+"","商业资料-地址不为空,邮编不能留空")) return false;
			}
		}
		return true ;
	}
	
	//商业资料-是否公司东主
	function verifyBsDz(){
		for(var i=1;i<=bs;i++){
			if($("BS_IS_OWNER_"+i+"")!=null && $("BS_IS_OWNER_"+i+"").value!=''){
				if(getRadioValue("BS_IS_OWNER_"+i+"")=='Y'){
					if(getRadioValue("BS_IS_SELF_EMPLOYED_"+i+"")!='N'){
					parent.Ext.Msg.alert("温馨提示","商业资料-是否公司东主选为是时,是否自雇人士只能选否",function(e){
						if(e=='ok'){try{$("BS_IS_SELF_EMPLOYED_"+i+"").focus();}catch(e){}
						}
					});
					return false;
					}
				}
			}
		}
		return true ;
	}
	//校验数字区间
	function checkNumberTo(id1,id2,id3,msg){
		if(id1/1>id3/1 || id1/1<id2/1){
			parent.Ext.Msg.alert("温馨提示",msg);
			return false;
		}
		return true ;
	}
	//商业资料- "是否公司东主"选为"是"时，补充资料（营业执照注册号,成立日期、每年盈利/亏损、雇员人数、经营场所为必填   mod 按揭供款/租金必填
	function verifyBsDzT(){
		for(var i=1;i<=bs;i++){
			if($("BS_IS_OWNER_"+i+"")!=null && $("BS_IS_OWNER_"+i+"").value!=''){
				if((getRadioValue("BS_IS_OWNER_"+i+"")=='Y')){
					if(!notnull("BS_BUSINESS_LICENCE_NO_"+i+"","商业资料-当是否公司东主选为是时,营业执照注册号为必填项")) return false;
					if(!notnull("BS_ESTABLISH_DATE_"+i+"","商业资料-当是否公司东主选为是时,成立日期为必填项")) return false;
					if(!notnull("BS_YEARLY_PROFIT_OR_LOSS_"+i+"","商业资料-当是否公司东主选为是时,每年盈利/亏损为必填项")) return false;
					if(!notnull("BS_EMPLOYEE_AMOUNT_"+i+"","商业资料-当是否公司东主选为是时,雇员人数为必填项")) return false;
					if(!selectJudge("BS_BUSINESS_PLACE_"+i+"","商业资料-当是否公司东主选为是时,经营场所为必填项")) return false;
					//if(!selectJudge("BS_CONT_OR_RENT_AMOUNT_"+i+"","商业资料-当是否公司东主选为是时,按揭供款/租金必填项")) return false;
				}
			}
			
			/*当经营场所为按揭或租用时,按揭供款/租金必填项*/
			if($("BS_BUSINESS_PLACE_"+i+"")!=null && (($("BS_BUSINESS_PLACE_"+i+"").value=='02')||$("BS_BUSINESS_PLACE_"+i+"").value=='03')){
				if(!notnull("BS_CONT_OR_RENT_AMOUNT_"+i+"","商业资料-当经营场所为按揭或租用时,按揭供款/租金必填项")) return false;
			}
			
		}
		return true;
	}
	//商业资料-组织机构代码校验
	function verifyBsOrg(){
		for(var i=1;i<=bs;i++){
			if($("BS_ORGANIZATION_CODE_"+i+"")!=null && $("BS_ORGANIZATION_CODE_"+i+"").value!=''){
				if(!verifyOrgFor($("BS_ORGANIZATION_CODE_"+i+"").value)) return false;
			}
		}
		return true;
	}
	
	//商业资料-支付日
	function verifyBsZf(){
		for(var i=1;i<=bs;i++){
			if($("BS_PAY_TIME_ONE_"+i+"")!=null && $("BS_PAY_TIME_ONE_"+i+"").value!=''){
				if(!checkNumberTo($("BS_PAY_TIME_ONE_"+i+"").value,"1","31","商业资料-支付日1必须在1到31之间")) return false;
			}
			if($("BS_PAY_TIME_TWO_"+i+"")!=null && $("BS_PAY_TIME_TWO_"+i+"").value!=''){
				if(!checkNumberTo($("BS_PAY_TIME_TWO_"+i+"").value,"1","31","商业资料-支付日2必须在1到31之间")) return false;
			}
		}
		return true ;
	}
	
	
	
	//联系人资料 性别,省，市，区
	function verifyAllLm(){
		if(!verifyLm()) return false ;
		return true;
	}
	function verifyLm(){
		for(var i=1;i<=lm;i++){
			if($("LM_NAME_"+i+"")!=null && $("LM_NAME_"+i+"").value!=''){
				if(!notnull("LM_AGE_"+i+"","联系人姓名不为空时,年龄为必填项")) return false; //年龄 //性别 //关系 //省 市 区 
				if(!checkSpanRadio("LM_SEX_"+i+"","SPAN_LMSEX_"+i+"","联系人姓名不为空时,性别为必填项")) return false;
				if(!notnull("LM_RELATION_TO_LOANER_"+i+"","联系人姓名不为空时,关系为必填项")) return false;
				if(!notnull("LM_RELATION_TO_LOANER_DESC_"+i+"","联系人姓名不为空时,关系描述为必填项")) return false;
				if(!notnull("LM_DWELL_ADDRESS_PROVINCE_"+i+"","联系人姓名不为空时,省为必填项")) return false;
				if(!notnull("LM_DWELL_ADDRESS_CITY_"+i+"","联系人姓名不为空时,市为必填项")) return false;
				if(!notnull("LM_DWELL_ADDRESS_AREA_"+i+"","联系人姓名不为空时,区为必填项")) return false;
			}
		}
		return true;
	}
	//校验批核信息
	function verifyPhxx(){
		var loanApp = $('APPR_APPROVAL_IS_APPROVAL').value;
		if(!selectJudge("APPR_APPROVAL_IS_APPROVAL","批核必填")) return false;
		if(loanApp=='01'){
			if(!notnull("APPR_APPROVAL_SUGGEST_AMOUNT","批核选择是时,建议批核金额为必填项")) return false;
			if(!notnull("APPR_APPROVAL_SUGGEST_PERIOD","批核选择是时,建议付还期数必填项")) return false;
			if(!notnull("APPR_APPROVAL_LOAN_PERIOD","批核选择是时,建议每月还款额(我司)为必填项")) return false;
			if(!notnull("APPR_APPROVAL_PH_LOAN_AMOUNT","批核选择是时,批核金额为必填项")) return false;
			if(!notnull("APPR_APPROVAL_PH_LOAN_PERIOD","批核选择是时,付还期数为必填项")) return false;
			if(!notnull("APPR_APPROVAL_PH_MONTH_PAY","批核选择是时,每月还款额(我司)为必填项")) return false;
			if(!notnull("APPR_APPROVAL_AGREEMENT_RATE","批核选择是时,协议担保费率为必填项")) return false;
			if(!notnull("APPR_APPROVAL_AGREEMENT_COST","批核选择是时,协议中介服务费率为必填项")) return false;
		}else if(loanApp=='02'){
			if(!selectJudge("APPR_APPROVAL_FOLLOW_STATUS","批核选择否时,跟进状况为必填项")) return false;
			if(!selectJudge("APPR_APPROVAL_FOLLOW_TYPE","批核选择否时,类型为必填项")) return false;
			//if(!selectJudge("APPR_APPROVAL_FOLLOW_REASON","批核选择否时,原因为必填项")) return false;
		}
		return true;
	}
	//校验放款信息
	function verifyLoanInfo(){
		if(!selectJudge("GRANT_LOAN_BANK_TYPE","放款账户信息-放款银行为必填项")) return false;
		if(!notnull("T_BANK_NO","放款账户信息-放款银行账户号码为必填项")) return false;
		if(!notnull("LOAN_BANK_ACCOUNT_NOTTWO","放款账户信息-放款银行账户号码为必填项")) return false;
		if(!notnull("GRANT_LOAN_BANK_ACCOUNT_HOLDER","放款账户信息-开户人为必填项")) return false;
		if(!notnull("GRANT_LOAN_BANK_ACCOUNT_PROVINCE","放款账户信息-银行账户省为必填项")) return false;
		if(!notnull("GRANT_LOAN_BANK_ACCOUNT_CITY","放款账户信息-银行账户市为必填项")) return false;
		if(!selectJudge("GRANT_REPAYMENT_DELAY_PAY_PARTERN","还款账户信息-放款方法为必填项")) return false;
		if(!selectJudge("GRANT_PAY_BANK_TYPE","还款账户信息-自动转账银行账户为必填项")) return false;
		if(!notnull("O_BANK_NO","还款账户信息-还款银行账户号码为必填项")) return false;
		if(!notnull("REPAYMENT_AUTO_BANK_ACCOUNTTWO","还款账户信息-还款银行账户号码为必填项")) return false;
		if(!notnull("GRANT_REPAYMENT_AUTO_BANK_HOLDER","还款账户信息-开户人为必填项")) return false;
		if(!notnull("GRANT_REPAYMENT_AUTO_BANK_PROVINCE","还款账户信息-银行账户省为必填项")) return false;
		if(!notnull("GRANT_REPAYMENT_AUTO_BANK_CITY","还款账户信息-银行账户市为必填项")) return false;
		if($('GRANT_LOAN_BANK_ACCOUNT_NO').value!=$('LOAN_BANK_ACCOUNT_NOTTWO').value){
			parent.Ext.Msg.alert('温馨提示','放款银行账号不相等');
			return false;
		}
		if($('GRANT_REPAYMENT_AUTO_BANK_ACCOUNT').value!=$('REPAYMENT_AUTO_BANK_ACCOUNTTWO').value){
			parent.Ext.Msg.alert('温馨提示','还款银行账号不相等');
			return false;
		}
		return true;
	}
	
	//校验组织机构代码
	function verifyOrgFor(data){
		if(!isValidOrgCode(data)){
			parent.Ext.Msg.alert("温馨提示","组织机构代码有误");
			return false;
		}
		return true;
	}
	//组织机构代码
	function isValidOrgCode(code) {  
	    var ws = [3, 7, 9, 10, 5, 8, 4, 2];  
	    var str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';  
	    var reg = /^([0-9A-Z]){8}[0-9|X]$/;   
	    if (!reg.test(code)) {  
	        return false;  
	    }  
	    var sum = 0;  
	    for (var i = 0; i < 8; i++) {  
	        sum += str.indexOf(code .charAt(i)) * ws[i];  
	    }  
	    var C9 = 11 - (sum % 11);  
	    if (C9 == 11) {  
	        C9= '0';  
	    } else if (C9 == 10) {  
	        C9= 'X'  
	    } 
	    return  C9==code.charAt(8);
	}
	
	/**
	 *  str :要校验的数字串
	 *	intNum：	整数位;
	 *	floatNum	小数位(如果只要求为数，则为0);
	 *  inputName:	提示框要显示的名字;
	 *	nullFlag:	是否可以为空,N是不可以为空，Y为可以空
	 */
	function checkIntegerLength(str,num){
		if(str.indexOf(".")!=-1){
			str=str.substring(0,str.indexOf("."));
		}
		if(str.length>num)return false;
		return true;
	}
	//数字小数位不能超过num位
	function checkFloatLength(str,num){
		if(str.indexOf(".")!=-1){
			str = str.substring(str.indexOf(".")+1,str.length);
			if(str.length>num){
				return false;
			}else{
				return true;
			}			
		}else{
			return true;
		}
	}
	//字符长度校验
	function checkCharLen(id,size,msg){
		if($(id)!=null){
			var obj=$(id).value;
			var n=0;
			if(obj==''){
				$(id).style.borderColor="";	
				return true;
			}else{
				var len=obj.length;
				for ( var i = 0; i < len; i++) {
					if (obj.charCodeAt(i) < 0 || obj.charCodeAt(i) > 255) {
						n = n + 2;
					} else {
						n = n + 1;
					}
				}
				if (n > size) {
					parent.Ext.Msg.alert("温馨提示",""+msg+"字段键入长度为:["+n+"],最大长度为:["+size+"]",function(e){
					if(e=='ok'){
						try{
					 		$(id).focus();
					 	}catch(e){
					 		
					 	}
					}
				});
				$(id).style.borderColor="red";
				return false;
				} else{
					$(id).style.borderColor="";
				}
			}
		}
		return true;
	}
	/**数字校验*/
	function checkNumberLen(id,intNum,floatNum,inputName){
	if($(id)!=null){
		var str=$(id).value;
		if(str==''){
			$(id).style.borderColor="";
			return true
		}else{
			if(!checkIntegerLength(str,intNum)){
			parent.Ext.Msg.alert("温馨提示",inputName+"的整数部分不能超过"+intNum+"位,请修改!",function(e){
				if(e=='ok'){
					try{
				 		$(id).focus();
				 	}catch(e){
				 		
				 	}
				}
			});
			$(id).style.borderColor="red";
			return false;
		}
		if(!checkFloatLength(str,floatNum)){
			if(floatNum==0){
				parent.Ext.Msg.alert("温馨提示",inputName+"只能输入整数,请修改!",function(e){
				if(e=='ok'){
					try{
				 		$(id).focus();
				 	}catch(e){
				 		
				 	}
				}
			});
			}else{
				parent.Ext.Msg.alert("温馨提示",inputName+"的小数部分不能超过"+floatNum+"位,请修改!",function(e){
				if(e=='ok'){
					try{
				 		$(id).focus();
				 	}catch(e){
				 	}
				}
			});
			}
			$(id).style.borderColor="red";		
			return false;
		}
		$(id).style.borderColor="";
		}
	}
	return true;
}
	/*************************字段长度校验************************************/
	function checkCustLen(){
		if(!checkCustBasicLen()){
			parent.checkLenFlag=true;
			return false;
		}
		if(!checkCustReLen()){
			parent.checkLenFlag=true;
			return false;
		}
		if(!checkCustHsLen()){
			parent.checkLenFlag=true;
			return false;
		}
		if(!checkCustBsLen()){
			parent.checkLenFlag=true;
			return false;
		}
		if(!checkCustSpLen()){
			parent.checkLenFlag=true;
			return false;
		}
		if(!checkCustLmLen()){
			parent.checkLenFlag=true;
			return false;
		}
		if(!checkCustDked()){
			parent.checkLenFlag=true;
			return false;
		}
		parent.checkLenFlag=false;
		return true;
	}
	/**申请人页面-基本信息*/
	function checkCustBasicLen(){
		if(!checkCharLen("GR_SURNAME","35","贷款人资料-姓")) return false;
		if(!checkCharLen("GR_GIVENNAME","70","贷款人资料-名")) return false;
		if(!checkCharLen("GR_USED_NAME","20","贷款人资料-曾用名")) return false;
		if(!checkCharLen("GR_NATIVE_PLACE","16","贷款人资料-籍贯")) return false;
		if(!checkCharLen("GR_SOCIAL_SECURITY_COMPUTER","12","贷款人资料-社会保险卡电脑号")) return false;
		if(!checkCharLen("GR_LABOR_ENSURE_CARD","12","贷款人资料-劳动保障卡号")) return false;
		if(!checkCharLen("GR_ID_CARD_ADDRESS_DETAIL","180","贷款人资料-中国身份证上的地址")) return false;
		if(!checkCharLen("GR_EMAIL","50","贷款人资料-电邮地址")) return false;
		return true;
	}
	
	/**申请人页面-住宅信息*/
	function checkCustReLen(){
		for(var i=1;i<=re;i++){
			if(!checkCharLen("RE_ADDRESS_DETAIL_"+i+"","180","住宅信息-地址")) return false;
			if(!checkCharLen("RE_OWNER_"+i+"","50","住宅信息-业主")) return false;
			if(!checkCharLen("RE_RELATION_TO_OWNER_"+i+"","20","住宅信息-关系")) return false;
			if(!checkCharLen("RE_OTHER_"+i+"","20","住宅信息-其它")) return false;
			if(!checkNumberLen("RE_CONT_OR_RENT_AMOUNT_"+i+"",8,2,"住宅信息-按揭供款/租金")) return false;
		}
		return true;
	}
	/**页面-房产信息*/
	function checkCustHsLen(){
		for(var i=1;i<=hs;i++){
			if(!checkCharLen("HS_ADDRESS_DETAIL_"+i+"","180","房产信息-地址")) return false;
			if(!checkCharLen("HS_ESTATE_CERTIFICATE_NO_"+i+"","40","申请人房产信息-房产证号")) return false;
			if(!checkCharLen("HS_MORTGAGE_BANK_"+i+"","30","房产信息-按揭银行")) return false;
			if(!checkNumberLen("HS_BUY_PRICE_"+i+"",10,2,"房产信息-购买价格")) return false;
			if(!checkNumberLen("HS_FLOOR_AREA_"+i+"",10,2,"房产信息-建筑面积")) return false;
			if(!checkNumberLen("HS_SEARCH_UNIT_PRICE_"+i+"",10,2,"房产信息-查询单价")) return false;
			if(!checkNumberLen("HS_LOAN_TOTAL_AMOUNT_"+i+"",10,2,"房产信息-贷款总额")) return false;
			if(!checkNumberLen("HS_BALANCE_DUE_"+i+"",10,2,"房产信息-尚欠余额")) return false;
			if(!checkNumberLen("HS_MONTHLY_CONTRIBUTION_"+i+"",10,2,"房产信息-每月供款")) return false;
		}
		return true;
	}
	/**申请人页面-商业信息*/
	function checkCustBsLen(){
		for(var i=1;i<=bs;i++){
			if(!checkCharLen("BS_COMPANY_NAME_"+i+"","50","商业信息-公司名称")) return false;
			if(!checkCharLen("BS_SHOP_NAME_"+i+"","50","商业信息-字号")) return false;
			if(!checkCharLen("BS_WEB_ADDRESS_"+i+"","30","商业信息-网站")) return false;
			if(!checkCharLen("BS_ADDRESS_DETAIL_"+i+"","180","商业信息-地址")) return false;
			if(!checkCharLen("BS_DEPARTMENT_"+i+"","30","商业信息-部门")) return false;
			if(!checkCharLen("BS_POSITION_"+i+"","35","商业信息-职务")) return false;
			if(!checkCharLen("BS_BUSINESS_LICENCE_NO_"+i+"","20","商业信息-营业执照注册号")) return false;
			if(!checkNumberLen("BS_YEARLY_PROFIT_OR_LOSS_"+i+"",10,2,"商业信息-每年盈利/亏损")) return false;
			if(!checkNumberLen("BS_CONT_OR_RENT_AMOUNT_"+i+"",10,2,"商业信息-按揭供款/租金")) return false;
			if(!checkNumberLen("BS_BASE_SALARY_"+i+"",10,2,"商业信息-基本薪金")) return false;
			if(!checkNumberLen("BS_OTHER_INCOME_"+i+"",10,2,"商业信息-其它收入")) return false;
			
		}
		return true;
	}
	
	/**申请人页面-配偶信息*/
	function checkCustSpLen(){
		if(!checkCharLen("GR_SPOUSE_NAME","40","配偶信息-姓名")) return false;
		if(!checkCharLen("GR_SPOUSE_COMPANY_NAME","50","配偶信息-公司名称")) return false;
		if(!checkCharLen("GR_SPOUSE_POSITION","35","配偶信息-职位")) return false;
		if(!checkCharLen("GR_SPOUSE_COMPANY_ADDRESS","180","配偶信息-公司地址")) return false;
		if(!checkCharLen("GR_SPOUSE_COMPANY_NAME","50","配偶信息-公司名称")) return false;
		if(!checkNumberLen("GR_SPOUSE_MONTHLY_INCOME",10,2,"配偶信息-每月收入")) return false;
		return true;
	}
	
	/**申请人页面-联系人信息*/
	function checkCustLmLen(){
		for(var i=1;i<=lm;i++){
			if(!checkCharLen("LM_NAME_"+i+"","40","联系人信息-姓名")) return false;
			if(!checkCharLen("LM_DWELL_ADDRESS_DETAIL_"+i+"","180","联系人信息-地址")) return false;
			if(!checkCharLen("LM_UNIT_NAME_"+i+"","50","联系人信息-单位名称")) return false;
			if(!checkCharLen("LM_POSITION_"+i+"","35","联系人信息-职位")) return false;
		}
		return true;
	}
	/***额度*/
	function checkCustDked(){
		if(!checkNumberLen("GR_SELF_HOUSE_LOAN_AMOUNT",8,2,"信用资料-自有房产总贷款额度")) return false;
		if(!checkNumberLen("GR_SELF_HOUSE_MONTH_CONT",8,2,"信用资料-自有房产总每月供款")) return false;
		if(!checkNumberLen("GR_SELF_HOUSE_LOAN_BALANCE",8,2,"信用资料-自有房产总贷款余额")) return false;
		if(!checkNumberLen("GR_SELF_CAR_LOAN_AMOUNT",8,2,"信用资料-自有汽车总贷款额度")) return false;
		if(!checkNumberLen("GR_SELF_CAR_MONTH_CONT",8,2,"信用资料-自有汽车总每月供款")) return false;
		if(!checkNumberLen("GR_SELF_CAR_LOAN_BALANCE",8,2,"信用资料-自有汽车总贷款余额")) return false;
		if(!checkNumberLen("GR_OTHER_LOAN_AMOUNT",8,2,"信用资料-其他总贷款额度")) return false;
		if(!checkNumberLen("GR_OTHER_MONTH_CONT",8,2,"信用资料-其他总每月供款")) return false;
		if(!checkNumberLen("GR_OTHER_LOAN_BALANCE",8,2,"信用资料-其他总贷款余额")) return false;
		if(!checkNumberLen("GR_UNSECURED_LOAN_AMOUNT",8,2,"信用资料-无抵押贷款总贷款额度")) return false;
		if(!checkNumberLen("GR_UNSECURED_MONTH_CONT",8,2,"信用资料-无抵押贷款总每月供款")) return false;
		if(!checkNumberLen("GR_UNSECURED_LOAN_BALANCE",8,2,"信用资料-无抵押贷款总贷款余额")) return false;
		if(!checkNumberLen("GR_CREDITCARD_LOAN_AMOUNT",8,2,"信用资料-信用卡总贷款额度")) return false;
		if(!checkNumberLen("GR_CREDITCARD_MONTH_CONT",8,2,"信用资料-信用卡总每月供款")) return false;
		if(!checkNumberLen("GR_CREDITCARD_LOAN_BALANCE",8,2,"信用资料-信用卡总贷款余额")) return false;
		return true ;
	}

	
	
