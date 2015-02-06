	function queryInfoForCertNo(id1,id2,id3,id4){
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
	 		}else{
	 			parent.Ext.Msg.alert('温馨提示','身份证号码位数错误,请输入18位证件号码');
	 		}
	 	}else{
	 		$(id3).value='';
	 		$(id4).value='';
	 	}
	}
	//客户资料页面校验
	function verifyApplyCust(){
		if(!verifyCustBasicCust()){
			checkCust=true;
			return false;
		}
		if(!verifyReCust()){
			checkCust=true;
			return false;
		}
		if(!verifyAllBs()){
			checkCust=true;
			return false;
		}
		
		if(!verifyAllLmCust()){
			checkCust=true;
			return false;
		}
		checkCust=false;
		return true;
	}
	
	//校验商业资料
	function verifyAllBs(){
		if(!verifyBs()){
			checkCust=true;
			return false;
		} 
		if(!verifyBsNameCust()){
			checkCust=true;
			return false;
		} 
		if(!verifyBsCode()){
			checkCust=true;
			return false;
		} 
		if(!verifyBsDz()) {
			checkCust=true;
			return false;
		}
		if(!verifyBsDzT()) {
			checkCust=true;
			return false;
		}
		if(!verifyBsOrg()){
			checkCust=true;
			return false;
		}
		if(!verifyBsZf()){
			checkCust=true;
			return false;
		}
		checkCust=false;
		return true;
	}
	/**客户基本资料*/
	function verifyCustBasicCust(){
		//姓，名，出生日期，户口所在地省，户口所在地市，籍贯，性别，婚姻状况，身份证有效期起，止，年，中国身份证地址，省，市，区
		if(!selectJudge("CB_CERT_TYPE","证件类型不能为空")) return false;
		if(!notnull("CB_CERT_NO","身份证号码不能为空")) return false;		
		if(!notnull("CB_SURNAME_CN","姓不能为空")) return false;
		if(!notnull("CB_GIVENNAME_CN","名不能为空")) return false;
		if(!notnull("CB_BIRTHDAY","出生日期不能为空")) return false;
		if(!notnull("CB_RPR_PROVINCE","省不能为空")) return false;
		if(!notnull("CB_RPR_CITY","市不能为空")) return false;
		if(!notnull("CB_NATIVE_PLACE","籍贯不能为空")) return false;
		if(!notnull("CB_CERT_NO","身份证号码不能为空")) return false;
		if(!checkSpanRadio("CB_SEX","SPAN_SEX","性别不能留空")) return false; 
 		if(!selectJudge("CB_MARITAL_STATUS","婚姻状况不能留空")) return false;
 		if(!selectJudge("CB_EDUCATION_LEVEL","教育程度不能留空")) return false;
 		if(!notnull("CB_ID_CARD_VALIDITY_FROM","身份证有效期起不能为空")) return false;
 		if(!notnull("CB_ID_CARD_VALIDITY_TO","身份证有效期止不能为空")) return false;
 		if(!notnull("CB_ID_CARD_VALIDITY_PERIOD","身份证有效期不能为空")) return false;
 		if(!selectJudge("CB_ID_CARD_ADDRESS_PROVINCE","中国身份证上的地址省不能留空")) return false;
 		if(!selectJudge("CB_ID_CARD_ADDRESS_CITY","中国身份证上的地址市不能留空")) return false;
 		if(!selectJudge("CB_ID_CARD_ADDRESS_AREA","中国身份证上的地址区不能留空")) return false;
 		if(!notnull("CB_ID_CARD_ADDRESS_DETAIL","中国身份证上的地址不能留空")) return false;
 		if(!verifyAppBirSexCust()) return false;
 		return true;
	}
	//选择性别
	function verifyAppBirSexCust(){
		var certtype=$("CB_CERT_TYPE").value;
		var certno=$("CB_CERT_NO").value;
		if(certtype=='CN' && certno.length==18){
			var str = certno.substring(6,14);
			var str2 = certno.substring(16,17);
			var birth=str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6,8);
			if(birth!=$("CB_BIRTHDAY").value){
				parent.Ext.Msg.alert('温馨提示','出生日期选择不正确!');
				$("CB_BIRTHDAY").style.borderColor="red";
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
	function verifyReCust(){
		for(var i=1;i<=re;i++){
			if(!selectJudge("RE_PROVINCE_"+i+"","住宅资料-省不能留空")) return false;
			if(!selectJudge("RE_CITY_"+i+"","住宅资料-市不能留空")) return false;
			if(!selectJudge("RE_AREA_"+i+"","住宅资料-区不能留空")) return false;
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
	
	//商业资料 公司地址不为空时 地址、省、市、区、邮政编码、公司电话、服务年数、职务、是否公司东主不能留空
	function verifyBsNameCust(){
		for(var i=1;i<=bs;i++){
			if($("BS_COMPANY_NAME_"+i+"")!=null && $("BS_COMPANY_NAME_"+i+"").value!=''){
				if(!notnull("BS_SHOP_NAME_"+i+"","公司名称不为空时,字号不能留空")) return false;
				if(!selectJudge("BS_PROVINCE_"+i+"","公司名称不为空时,省不能留空")) return false;
				if(!selectJudge("BS_CITY_"+i+"","公司名称不为空时,市不能留空")) return false;
				if(!selectJudge("BS_AREA_"+i+"","公司名称不为空时,区不能留空")) return false;
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
	
	//联系人资料 性别,省，市，区
	function verifyAllLmCust(){
		if(!verifyLmCust()) return false ;
		return true;
	}
	function verifyLmCust(){
		for(var i=1;i<=lm;i++){
			if($("LM_NAME_"+i+"")!=null && $("LM_NAME_"+i+"").value!=''){
				if(!notnull("LM_AGE_"+i+"","联系人姓名不为空时,年龄为必填项")) return false; //年龄 //性别 //关系 //省 市 区 
				if(!checkSpanRadio("LM_SEX_"+i+"","SPAN_LMSEX_"+i+"","联系人姓名不为空时,性别为必填项")) return false;
				if(!notnull("LM_RELATION_TO_LOANER_"+i+"","联系人姓名不为空时,关系为必填项")) return false;
				if(!notnull("LM_RELATION_TO_LOANER_DESC_"+i+"","联系人姓名不为空时,关系描述为必填项")) return false;
				if(!notnull("LM_PROVINCE_"+i+"","联系人姓名不为空时,省为必填项")) return false;
				if(!notnull("LM_CITY_"+i+"","联系人姓名不为空时,市为必填项")) return false;
				if(!notnull("LM_AREA_"+i+"","联系人姓名不为空时,区为必填项")) return false;
			}
		}
		return true;
	}
	/*************************字段长度校验************************************/
	function checkCustBasicLenFor(){
		if(!checkCharLen("CB_SURNAME_CN","35","贷款人资料-姓")) return false;
		if(!checkCharLen("CB_GIVENNAME_CN","70","贷款人资料-名")) return false;
		if(!checkCharLen("CB_USED_NAME","20","贷款人资料-曾用名")) return false;
		if(!checkCharLen("CB_NATIVE_PLACE","16","贷款人资料-籍贯")) return false;
		if(!checkCharLen("GR_SOCIAL_SECURITY_COMPUTER","12","贷款人资料-社会保险卡电脑号")) return false;
		if(!checkCharLen("GR_LABOR_ENSURE_CARD","12","贷款人资料-劳动保障卡号")) return false;
		if(!checkCharLen("CB_ID_CARD_ADDRESS_DETAIL","180","贷款人资料-中国身份证上的地址")) return false;
		if(!checkCharLen("CB_EMAIL","50","贷款人资料-电邮地址")) return false;
		return true;
	}
	//客户资料修改字段校验长度
	function checkCustLenCust(){
		if(!checkCustBasicLenFor()){
			checkCustLen=true;
			return false;
		}
		if(!checkCustReLen()){
			checkCustLen=true;
			return false;
		}
		if(!checkCustHsLen()){
			checkCustLen=true;
			return false;
		}
		if(!checkCustBsLen()){
			checkCustLen=true;
			return false;
		}
		if(!checkCustSpLen()){
			checkCustLen=true;
			return false;
		}
		if(!checkCustLmLen()){
			checkCustLen=true;
			return false;
		}
		if(!checkCustDked()){
			checkCustLen=true;
			return false;
		}
		checkCustLen=false;
		return true;
	}
	