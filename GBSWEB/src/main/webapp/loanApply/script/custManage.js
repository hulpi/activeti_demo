
//增加房产资料
function addHouseData(customer_id,only_id,apply_code,but){
	if(Ext.query('fieldset[id^="hs"]').length<2){
		hs++ ;
		hs_size++;
		var data = [
  			'<input type="hidden" id="HS_CUSTOMER_ID_'+hs+'" name="HS_CUSTOMER_ID_'+hs+'" value="'+customer_id+'"/>'+
  			'<input type="hidden" id="HS_ONLY_ID_'+hs+'" name="HS_ONLY_ID_'+hs+'" value="'+only_id+'"/>'+
  			'<input type="hidden" id="HS_APPLY_CODE_'+hs+'" name="HS_APPLY_CODE_'+hs+'" value="'+apply_code+'"/>'+
			'<input type="hidden" id="HS_HOUSE_ID_'+hs+'" name="HS_HOUSE_ID_'+hs+'" value="'+hs+'"/>'+
   		 	'<fieldset id="hs'+hs+'"><legend>房产资料</legend>'+
    		'<table  border="0" align="left" id="mtable" height="100%">'+
    			'<tr>'+
    				'<td ><input type="button" value="清除" onclick=\'ResetControl("HS_","'+hs+'");\'></td>'+
    				'<td ><input type="button" value="删除房产资料" onclick=\'deleteAllCustomer("'+customer_id+'","'+only_id+'","'+apply_code+'","hs","'+hs+'","HS_",this,"HS_HOUSE_ID_'+hs+'");\' id="'+hs+'"></td>'+
    			'</tr><tr>'+
    				'<td>房产地址：</td>'+
    				'<td colspan="3" >省：'+
    						'<select id="HS_ADDRESS_PROVINCE_'+hs+'" name="HS_ADDRESS_PROVINCE_'+hs+'" onchange=\'getPCA(this.id,"2","HS_ADDRESS_CITY_'+hs+'","HS_ADDRESS_AREA_'+hs+'","HS_ADDRESS_DETAIL_'+hs+'",this.id);\'>'+
    		    			'<option value="">--请选择--</option>'+
    						'</select>'+
    		 			'市：' +
    		 			'<select id="HS_ADDRESS_CITY_'+hs+'" name="HS_ADDRESS_CITY_'+hs+'" onchange=\'getPCA(this.id,"3","HS_ADDRESS_AREA_'+hs+'","HS_ADDRESS_AREA_'+hs+'","HS_ADDRESS_DETAIL_'+hs+'","HS_ADDRESS_PROVINCE_'+hs+'");\'>'+
    		    			'<option value="">--请选择--</option>'+
    		 				'</select>'+
    		    		'区：' +
    		    		'<select id="HS_ADDRESS_AREA_'+hs+'" name="HS_ADDRESS_AREA_'+hs+'" onchange=\'setAddressArea(this.id,"HS_ADDRESS_DETAIL_'+hs+'","HS_ADDRESS_PROVINCE_'+hs+'","HS_ADDRESS_CITY_'+hs+'");\'>'+
    		    			'<option value="">--请选择--</option>'+	
    		    			'</select>'+
    		    	'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td></td>'+
    				'<td colspan=6><textarea rows="2" cols="50" id="HS_ADDRESS_DETAIL_'+hs+'" name="HS_ADDRESS_DETAIL_'+hs+'" ></textarea></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td></td>'+
    				'<td></td>'+
    				'<td>购买方式：</td>'+
    				'<td>'+
						'<select  id="HS_BUY_PARTERN_'+hs+'" name="HS_BUY_PARTERN_'+hs+'">'+
							'<option value="">--请选择--</option>'+
    		    		'</select>'+
					'</td>'+
					'<td>房地产证号：</td>'+
    				'<td><input type="text" id="HS_ESTATE_CERTIFICATE_NO_'+hs+'" name="HS_ESTATE_CERTIFICATE_NO_'+hs+'" style="width: 100px;"  /></td>'+
    			'</tr><tr>'+
    				'<td></td>'+
    				'<td></td>'+
    				'<td>购买日期：</td>'+
    				'<td><input type="text" id="HS_BUY_TIME_'+hs+'" name="HS_BUY_TIME_'+hs+'" class="Wdate" onclick=\'WdatePicker({readOnly:true,skin:"ext",dateFmt:"yyyy/MM/dd",minDate:"1900/01/01",maxDate:"%y-%M-%d"});\' style="width: 100px;" readonly="readonly"/></td>'+
    				'<td>房产查询资料：</td>'+
    		    	'<td><label for="HS_YESSEARCHED_'+hs+'"><input type="radio" id="HS_YESSEARCHED_'+hs+'" name="HS_IS_SEARCHED_'+hs+'" value="Y" onclick=\'hsSelectData(this.name,"HS_SEARCH_DATE_'+hs+'","HS_SEARCH_UNIT_PRICE_'+hs+'","HS_SEARCH_TOTAL_PRICE_'+hs+'");\' />有</label>'+
    		    		'<label for="HS_NOSEARCHED_'+hs+'"><input type="radio" id="HS_NOSEARCHED_'+hs+'" name="HS_IS_SEARCHED_'+hs+'" value="N" onclick=\'hsSelectData(this.name,"HS_SEARCH_DATE_'+hs+'","HS_SEARCH_UNIT_PRICE_'+hs+'","HS_SEARCH_TOTAL_PRICE_'+hs+'");\' checked/>无</label>'+
    		    	'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td></td>'+
    				'<td></td>'+
    				'<td>购买价格：</td>'+
    				'<td><input type="text" id="HS_BUY_PRICE_'+hs+'" name="HS_BUY_PRICE_'+hs+'" maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'<td>查询日期：</td>'+
    				'<td><input type="text" id="HS_SEARCH_DATE_'+hs+'" name="HS_SEARCH_DATE_'+hs+'" disabled="disabled" class="Wdate" onclick=\'WdatePicker({readOnly:true,skin:"ext",dateFmt:"yyyy/MM/dd",minDate:"1900/01/01",maxDate:"%y-%M-%d"});\' style="width: 100px;" readonly="readonly"/></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>建筑年份：</td>'+
    				'<td><input type="text" id="HS_BUILT_YEAR_'+hs+'" name="HS_BUILT_YEAR_'+hs+'"  maxlength="4" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop= "return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>建筑面积：</td>'+
    				'<td><input type="text" id="HS_FLOOR_AREA_'+hs+'" name="HS_FLOOR_AREA_'+hs+'"  maxlength="13" onkeyup=\'countHsTotalPrice("HS_SEARCH_UNIT_PRICE_'+hs+'","HS_FLOOR_AREA_'+hs+'","HS_SEARCH_TOTAL_PRICE_'+hs+'")\' style="width:100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/>平方米</td>'+
    				'<td>查询单价：</td>'+
    				'<td><input type="text" id="HS_SEARCH_UNIT_PRICE_'+hs+'" name="HS_SEARCH_UNIT_PRICE_'+hs+'"  maxlength="13" onkeyup=\'countHsTotalPrice("HS_SEARCH_UNIT_PRICE_'+hs+'","HS_FLOOR_AREA_'+hs+'","HS_SEARCH_TOTAL_PRICE_'+hs+'")\' disabled="disabled" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    			'</tr><tr>'+
    				'<td>按揭银行：</td>'+
    				'<td><input type="text" id="HS_MORTGAGE_BANK_'+hs+'" name="HS_MORTGAGE_BANK_'+hs+'" style="width: 100px;"/></td>'+
    				'<td>贷款年限：</td>'+
    				'<td><input type="text" id="HS_LOAN_LIMIT_YEAR_'+hs+'" name="HS_LOAN_LIMIT_YEAR_'+hs+'"  maxlength="3" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)"onpaste="return regInput2(this,/^[0-9]*$/)"ondrop= "return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>查询总价：</td>'+
    				'<td><input type="text" id="HS_SEARCH_TOTAL_PRICE_'+hs+'" name="HS_SEARCH_TOTAL_PRICE_'+hs+'" disabled="disabled" maxlength="22" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\.?\\d{0,2}$/)"/></td>'+
    			'</tr><tr>'+
    				'<td>贷款总额：</td>'+
    				'<td><input type="text" id="HS_LOAN_TOTAL_AMOUNT_'+hs+'" name="HS_LOAN_TOTAL_AMOUNT_'+hs+'"  maxlength="13"  style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'<td>尚欠余额：</td>'+
    				'<td><input type="text" id="HS_BALANCE_DUE_'+hs+'" name="HS_BALANCE_DUE_'+hs+'"  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'<td>每月供款：</td>'+
    				'<td><input type="text" id="HS_MONTHLY_CONTRIBUTION_'+hs+'" name="HS_MONTHLY_CONTRIBUTION_'+hs+'"  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    			'</tr><tr>'+
    				'<td>房产用途：</td>'+
    				'<td><select id="HS_ESTATE_PURPOSES_'+hs+'" name="HS_ESTATE_PURPOSES_'+hs+'">'+
    		    		'<option value="">--请选择--</option>'+
    					'</select>'+
    		    	'</td>'+
    				'<td>物业类型：</td>'+
    				'<td><select id="HS_PROPERTY_TYPE_'+hs+'" name="HS_PROPERTY_TYPE_'+hs+'">'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    		    	'<td>房屋产权类型：</td>'+
    				'<td><select id="HS_HOUSE_PROPERTY_TYPE_'+hs+'" name="HS_HOUSE_PROPERTY_TYPE_'+hs+'">'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    			'</tr></table></fieldset>'].join('');
	}else{
		//parent.Ext.MessageBox.alert('温馨提示','房产资料不能超过2个!');
		//document.getElementById(but).disabled=true;
		return ;
	}
		divHouse.innerHTML=divHouse.innerHTML + data ;
    	initProvinceParams('HS_ADDRESS_PROVINCE_'+hs+'');//省
		initSelectParams('HS_BUY_PARTERN_'+hs+'','G_PA_HOUSE_PURCHASING_MODE');//购买方式
		initSelectParams('HS_ESTATE_PURPOSES_'+hs+'','G_PA_HOUSE_USAGEPROPERTY');//房产用途 
		initSelectParams('HS_PROPERTY_TYPE_'+hs+'','G_PA_HOUSE_PROPERTYTYPE');//物业类型
		initSelectParams('HS_HOUSE_PROPERTY_TYPE_'+hs+'','G_PA_HOUSE_RESIDENTIAL_BUILDINGS');//房屋产权类型
		
}
//添加商业资料
function addBusinessData(customer_id,only_id,apply_code,but){
	if(Ext.query('fieldset[id^="bs"]').length<2){
		bs++ ;
		bs_size++;
		var data = [
		    '<input type="hidden" id="BS_CUSTOMER_ID_'+bs+'" name="BS_CUSTOMER_ID_'+bs+'" value="'+customer_id+'"/>'+
  			'<input type="hidden" id="BS_ONLY_ID_'+bs+'" name="BS_ONLY_ID_'+bs+'" value="'+only_id+'"/>'+
  			'<input type="hidden" id="BS_APPLY_CODE_'+bs+'" name="BS_APPLY_CODE_'+bs+'" value="'+apply_code+'"/>'+
			'<input type="hidden" id="BS_BUSINESS_ID_'+bs+'" name="BS_BUSINESS_ID_'+bs+'" value="'+bs+'"/>'+
   			'<fieldset id="bs'+bs+'"><legend>商业资料</legend>'+
			'<table  border="0"  id="mtable" height="100%">'+
    			'<tr>'+
    				'<td ><input type="button" value="清除" onclick=\'ResetControl("BS_","'+bs+'");\'/></td>'+
    				'<td ><input type="button" value="删除商业资料" onclick=\'deleteAllCustomer("'+customer_id+'","'+only_id+'","'+apply_code+'","bs","'+bs+'","BS_",this,"BS_BUSINESS_ID_'+bs+'");\' id="'+bs+'"></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>公司名称：</td>'+
    				'<td><input type="text" id="BS_COMPANY_NAME_'+bs+'" name="BS_COMPANY_NAME_'+bs+'" onkeyup=\'clearCom(this,"BSCOMPANYNAME_'+bs+'","BS_SHOP_NAME_'+bs+'","");\' style="width: 200px;"/></td>'+
    				'<input type="hidden" id="BSCOMPANYNAME_'+bs+'" name="BSCOMPANYNAME_'+bs+'" value=""/>'+
    				'<td>字号：</td>'+
    				'<td><input type="text" id="BS_SHOP_NAME_'+bs+'" name="BS_SHOP_NAME_'+bs+'" style="width: 100px;" /></td>'+
    				'<td>网站：'+
    				'<input type="text" id="BS_WEB_ADDRESS_'+bs+'" name="BS_WEB_ADDRESS_'+bs+'" /></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>地址：</td>'+
    				'<td colspan="3" nowrap="nowrap" >省：'+
    						'<select id="BS_ADDRESS_PROVINCE_'+bs+'" name="BS_ADDRESS_PROVINCE_'+bs+'" onchange=\'getPCA(this.id,"2","BS_ADDRESS_CITY_'+bs+'","BS_ADDRESS_AREA_'+bs+'","BS_ADDRESS_DETAIL_'+bs+'",this.id);\'>'+
    		    			'<option value="">--请选择--</option>'+
    						'</select>'+
    		 			'市：'+
    		    			'<select id="BS_ADDRESS_CITY_'+bs+'" name="BS_ADDRESS_CITY_'+bs+'" onchange=\'getPCA(this.id,"3","BS_ADDRESS_AREA_'+bs+'","BS_ADDRESS_AREA_'+bs+'","BS_ADDRESS_DETAIL_'+bs+'","BS_ADDRESS_PROVINCE_'+bs+'");\'>'+
    		    			'<option value="">--请选择--</option>'+
    		    			'</select>'+
    		    		'区：'+
    		    			'<select id="BS_ADDRESS_AREA_'+bs+'" name="BS_ADDRESS_AREA_'+bs+'" onchange=\'setAddressArea(this.id,"BS_ADDRESS_DETAIL_'+bs+'","BS_ADDRESS_PROVINCE_'+bs+'","BS_ADDRESS_CITY_'+bs+'"); getPostCode("BS_ADDRESS_CITY_'+bs+'",this,"BS_POST_CODE_'+bs+'");\'>'+
    		    			'<option value="">--请选择--</option>'+
    		    			'</select>'+
    		    	'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td></td>'+
    				'<td colspan=3><textarea rows="2" cols="50" id="BS_ADDRESS_DETAIL_'+bs+'" name="BS_ADDRESS_DETAIL_'+bs+'" ></textarea></td>'+    				
					'<td>邮政编码：'+
    				'<input type="text" id="BS_POST_CODE_'+bs+'" name="BS_POST_CODE_'+bs+'"  maxlength="6" readonly="readonly"  style="width: 90px;ime-mode:Disabled;background-color: #E6E6E6;" onkeypress= "return regInput1(this,/^[0-9]*$/)"onpaste= "return regInput2(this,/^[0-9]*$/)" ondrop= "return regInput3(this,/^[0-9]*$/)"/></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>公司电话：</td>'+
    				'<td><input type="text" id="BS_TEL_AREA_'+bs+'" name="BS_TEL_AREA_'+bs+'"  maxlength="5" style="width:50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'<input type="text" id="BS_TEL_NUMBER_'+bs+'" name="BS_TEL_NUMBER_'+bs+'"  maxlength="15" style="width:90px;ime-mode:Disabled;"  onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'<input type="text" id="BS_TEL_EXT_'+bs+'" name="BS_TEL_EXT_'+bs+'"  maxlength="10" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>公司传真：</td>'+
    				'<td><input type="text" id="BS_FAX_AREA_'+bs+'" name="BS_FAX_AREA_'+bs+'"  maxlength="5" style="width:50px;ime-mode:Disabled;"  onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    					'<input type="text" id="BS_FAX_NUMBER_'+bs+'" name="BS_FAX_NUMBER_'+bs+'"  maxlength="15" style="width:120px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>'+
    				'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>服务年数：</td>'+
    				'<td><input type="text" id="BS_SERVICE_YEARS_'+bs+'" name="BS_SERVICE_YEARS_'+bs+'"  maxlength="2" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>年'+
    					'<input type="text" id="BS_SERVICE_MONTHS_'+bs+'" name="BS_SERVICE_MONTHS_'+bs+'"  maxlength="2" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>月'+
    				'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td><font color="red">*</font>单位性质：</td>'+
    				'<td><select id="BS_UNIT_KIND_'+bs+'" name="BS_UNIT_KIND_'+bs+'" onblur="checknull2(this);" onchange=\'getUnitPropertyMap(this.id,"BS_INDUSTRY_'+bs+'");getOccupationMap(this.id,"BS_WORK_LEVEL_'+bs+'");\'>'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    		    	'<td><font color="red">*</font>所属行业：</td>'+
    				'<td><select id="BS_INDUSTRY_'+bs+'" name="BS_INDUSTRY_'+bs+'" onblur="checknull2(this);">'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>部门：</td>'+
    				'<td><input type="text" id="BS_DEPARTMENT_'+bs+'" id="BS_DEPARTMENT_'+bs+'" /></td>'+
    				'<td><font color="red">*</font>工作级别：</td>'+
    				'<td><select id="BS_WORK_LEVEL_'+bs+'" name="BS_WORK_LEVEL_'+bs+'" onblur="checknull2(this);">'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    		    	'<td>职务：'+
    				'<input type="text" id="BS_POSITION_'+bs+'" name="BS_POSITION_'+bs+'" style="width: 100px;" >'+
   					'</td>'+
   					'</tr>'+ 			
    			'<tr>'+
    				'<td>是否公司东主：</td>'+
    				'<td>'+
    					'<span id="SPAN_IS_OWNER_'+bs+'">'+
						'<label for="BS_YESOWNER_'+bs+'"><input type="radio" id="BS_YESOWNER_'+bs+'" name="BS_IS_OWNER_'+bs+'" value="Y"/>是</label>'+
						'<label for="BS_NOOWNER_'+bs+'"><input type="radio" id="BS_NOOWNER_'+bs+'" name="BS_IS_OWNER_'+bs+'" value="N"/>否</label>'+
						'</span>'+
					'</td>'+
					'<td><font color="red">*</font>是否自雇人士：</td>'+
    				'<td>'+
						'<span id="SPAN_IS_SELF_EMPLOYED_'+bs+'"><label for="BS_YESSELFEMPLOYED_'+bs+'"><input type="radio" id="BS_YESSELFEMPLOYED_'+bs+'" name="BS_IS_SELF_EMPLOYED_'+bs+'" value="Y" />是</label>'+
						'<label for="BS_NOSELFEMPLOYED_'+bs+'"><input type="radio" id="BS_NOSELFEMPLOYED_'+bs+'" name="BS_IS_SELF_EMPLOYED_'+bs+'" value="N"/>否</label></span>'+
					'</td>'+
    			'</tr>'+
    		'</table>'+
    		'<fieldset>'+
    			'<legend>补充资料(适用于企业东主)</legend>'+
    			'<table>'+
    				'<tr>'+
    					'<td>营业执照注册号：</td>'+
    					'<td><input type="text" id="BS_BUSINESS_LICENCE_NO_'+bs+'" name="BS_BUSINESS_LICENCE_NO_'+bs+'"/></td>'+
    					'<td>组织机构代码：</td>'+
    					'<td><input type="text" id="BS_ORGANIZATION_CODE_'+bs+'" name="BS_ORGANIZATION_CODE_'+bs+'" maxlength="9"/></td>'+
    					'<td>成立日期：</td>'+
    					'<td><input type="text" id="BS_ESTABLISH_DATE_'+bs+'" name="BS_ESTABLISH_DATE_'+bs+'" class="Wdate" onclick=\'WdatePicker({readOnly:true,skin:"ext",dateFmt:"yyyy/MM/dd",minDate:"1900/01/01",maxDate:"%y-%M-%d"});\' readonly="readonly" style="width: 100px;"/></td>'+
    				'</tr>'+
    				'<tr>'+
    					'<td>每年盈利/亏损：</td>'+
    					'<td><input type="text" id="BS_YEARLY_PROFIT_OR_LOSS_'+bs+'" name="BS_YEARLY_PROFIT_OR_LOSS_'+bs+'" style="ime-mode:Disabled;" maxlength="13" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)" /></td>'+
    					'<td>雇员人数：</td>'+
    					'<td><input type="text" id="BS_EMPLOYEE_AMOUNT_'+bs+'" name="BS_EMPLOYEE_AMOUNT_'+bs+'" style="ime-mode:Disabled;" maxlength="5" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'</tr>'+
    				'<tr>'+
    				'<td>经营场所：</td>'+
    					'<td><select id="BS_BUSINESS_PLACE_'+bs+'" name="BS_BUSINESS_PLACE_'+bs+'">'+
							'<option value="">--请选择--</option>'+
    		    			'</select>'+
    		    		'</td>'+
    					'<td>按揭供款/租金：</td>'+
    					'<td><input type="text" id="BS_CONT_OR_RENT_AMOUNT_'+bs+'" name="BS_CONT_OR_RENT_AMOUNT_'+bs+'" style="ime-mode:Disabled;"  maxlength="13"  onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'</tr>'+
    			'</table>'+
    		'</fieldset>'+
    		'<fieldset>'+
    			'<legend>每月收入</legend>'+
    			'<table>'+
    				'<tr>'+
    					'<td><font color="red">*</font>基本薪金：</td>'+
    					'<td><input type="text" id="BS_BASE_SALARY_'+bs+'" name="BS_BASE_SALARY_'+bs+'"  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeyup=\'totalBusIncome(this,"BS_OTHER_INCOME_'+bs+'","BS_MONTHLY_TOTAL_INCOME_'+bs+'");\' maxlength="9" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)" onblur="checknull(this);"/></td>'+
    					'<td>其它收入：</td>'+
    					'<td><input type="text" id="BS_OTHER_INCOME_'+bs+'" name="BS_OTHER_INCOME_'+bs+'"  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeyup=\'totalBusIncome("BS_BASE_SALARY_'+bs+'",this,"BS_MONTHLY_TOTAL_INCOME_'+bs+'");\' onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    					'<td>每月总收入：</td>'+
    					'<td><input type="text" id="BS_MONTHLY_TOTAL_INCOME_'+bs+'" name="BS_MONTHLY_TOTAL_INCOME_'+bs+'" maxlength="12" style="background-color: #E6E6E6;width: 100px;ime-mode:Disabled;" maxlength="12" readonly="readonly"/></td>'+
    				'</tr>'+
    				'<tr>'+
    					'<td><font color="red">*</font>支付方式：</td>'+
    					'<td><select id="BS_PAY_PATTERN_'+bs+'" name="BS_PAY_PATTERN_'+bs+'" style="width: 100px;" onblur="checknull2(this)"> <option value="">--请选择--</option></select></td>'+
    					'<td>支付日：</td>'+
    					'<td>(1)<input type="text" id="BS_PAY_TIME_ONE_'+bs+'" name="BS_PAY_TIME_ONE_'+bs+'"  maxlength="2" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>'+
    						'(2)<input type="text" id="BS_PAY_TIME_TWO_'+bs+'" name="BS_PAY_TIME_TWO_'+bs+'"  maxlength="2" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>'+
    					'</td>'+
    				'</tr>'+
    			'</table>'+
    		'</fieldset>'+
    	'</fieldset>'].join('');
	}else{
		parent.Ext.MessageBox.alert('温馨提示','商业资料不能超过2个!');
		//document.getElementById(but).disabled=true;
		return ;
	}
	divBusiness.innerHTML=divBusiness.innerHTML + data ;
	initProvinceParams('BS_ADDRESS_PROVINCE_'+bs+'');//省
	initSelectParams('BS_UNIT_KIND_'+bs+'','G_PA_INDUSTRY_SECTOR_TMP');//单位性质
	initSelectParams('BS_BUSINESS_PLACE_'+bs+'','G_PA_BUILDINGS_TYPE');//经营场所
	initSelectParams('BS_PAY_PATTERN_'+bs+'','G_PA_PAY_MODE')//支付方式
	
}	
//添加联系人信息
function addLinkmanData(customer_id,only_id,apply_code,but){
	if(Ext.query('fieldset[id^="lm"]').length<5){
		lm++;
		lm_size++;
		var data = [
		    '<input type="hidden" id="LM_CUSTOMER_ID_'+lm+'" name="LM_CUSTOMER_ID_'+lm+'" value="'+customer_id+'"/>'+
  			'<input type="hidden" id="LM_ONLY_ID_'+lm+'" name="LM_ONLY_ID_'+lm+'" value="'+only_id+'"/>'+
  			'<input type="hidden" id="LM_APPLY_CODE_'+lm+'" name="LM_APPLY_CODE_'+lm+'" value="'+apply_code+'"/>'+
			'<input type="hidden" id="LM_LINKMAN_ID_'+lm+'" name="LM_LINKMAN_ID_'+lm+'" value="'+lm+'"/>'+
   		 	'<fieldset id="lm'+lm+'">'+
    		'<legend>联系人资料</legend>'+
    		'<table border="0" align="left">'+
    			'<tr>'+
    			'<td ><input type="button" value="清除" onclick=\'ResetControl("LM_","'+lm+'");\'/></td>'+
    			'<td ><input type="button" value="删除联系人资料" onclick=\'deleteAllCustomer("'+customer_id+'","'+only_id+'","'+apply_code+'","lm","'+lm+'","LM_",this,"LM_LINKMAN_ID_'+lm+'");\' id="'+lm+'"></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>姓名：</td>'+
    				'<td><input type="text" id="LM_NAME_'+lm+'" name="LM_NAME_'+lm+'"  maxlength="40" style="width: 100px;"/></td>'+
    				'<td>年龄：</td>'+
    				'<td><input type="text" id="LM_AGE_'+lm+'" name="LM_AGE_'+lm+'"  maxlength="3" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>性别：</td>'+
    				'<td><span id="SPAN_LMSEX_'+lm+'"><label for="LM_SEXW_'+lm+'"><input type="radio" id="LM_SEXW_'+lm+'" name="LM_SEX_'+lm+'" value="M"/>男</label>'+
						'<label for="LM_SEXM_'+lm+'"><input type="radio" id="LM_SEXM_'+lm+'" name="LM_SEX_'+lm+'" value="F"/>女</label></span>'+
					'</td>'+
    			'</tr>'+
    			'<tr>'+
    				
    				'<td>关系：</td>'+
    				'<td><select id="LM_RELATION_TO_LOANER_'+lm+'" name="LM_RELATION_TO_LOANER_'+lm+'" onchange=\'getContactRelationMapByContactType(this.id,"LM_RELATION_TO_LOANER_DESC_'+lm+'");\'>'+
							'<option value="">--请选择--</option>'+
    		    		'</select>'+
    		    	'<select id="LM_RELATION_TO_LOANER_DESC_'+lm+'" name="LM_RELATION_TO_LOANER_DESC_'+lm+'">'+
						'<option value="">--请选择--</option>'+
						'</select>'+
    		    	'</td>'+
    		    	'<td></td>'+
    		    	'<td></td>'+
					'<td>是否知悉贷款：</td>'+
    				'<td>'+
						'<label for="LM_YES_KOWN_LOAN_'+lm+'"><input type="radio" id="LM_YES_KOWN_LOAN_'+lm+'" name="LM_IS_KOWN_LOAN_'+lm+'" value="Y"/>是</label>'+
						'<label for="LM_NO_KOWN_LOAN_'+lm+'"><input type="radio" id="LM_NO_KOWN_LOAN_'+lm+'" name="LM_IS_KOWN_LOAN_'+lm+'" value="N" checked="checked"/>否</label>'+
					'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>住宅地址：</td>'+
    				'<td colspan="3" nowrap="nowrap" >省：'+
    						'<select id="LM_DWELL_ADDRESS_PROVINCE_'+lm+'" name="LM_DWELL_ADDRESS_PROVINCE_'+lm+'" onchange=\'getPCA(this.id,"2","LM_DWELL_ADDRESS_CITY_'+lm+'","LM_DWELL_ADDRESS_AREA_'+lm+'","LM_DWELL_ADDRESS_DETAIL_'+lm+'",this.id);\'>'+
    		    			'<option value="">--请选择--</option>'+
    						'</select>'+
    		 			'市：'+
    		    			'<select id="LM_DWELL_ADDRESS_CITY_'+lm+'" name="LM_DWELL_ADDRESS_CITY_'+lm+'" onchange=\'getPCA(this.id,"3","LM_DWELL_ADDRESS_AREA_'+lm+'","LM_DWELL_ADDRESS_AREA_'+lm+'","LM_DWELL_ADDRESS_DETAIL_'+lm+'","LM_DWELL_ADDRESS_PROVINCE_'+lm+'");\'>'+
    		    			'<option value="">--请选择--</option>'+
    		    			'</select>'+
    		    		'区：'+
    		    			'<select id="LM_DWELL_ADDRESS_AREA_'+lm+'" name="LM_DWELL_ADDRESS_AREA_'+lm+'" onchange=\'setAddressArea(this.id,"LM_DWELL_ADDRESS_DETAIL_'+lm+'","LM_DWELL_ADDRESS_PROVINCE_'+lm+'","LM_DWELL_ADDRESS_CITY_'+lm+'");\'>'+
    		    			'<option value="">--请选择--</option>'+
    		    			'</select>'+
    		    	'</td>'+
    		    	'<td></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td></td>'+
    				'<td colspan=6><textarea rows="2" cols="50" id="LM_DWELL_ADDRESS_DETAIL_'+lm+'" name="LM_DWELL_ADDRESS_DETAIL_'+lm+'" ></textarea></td>'+    				
    			'</tr>'+
    			'<tr>'+
    				'<td>住宅电话：</td>'+
    				'<td><input type="text" id="LM_DWELL_TEL_AREA_'+lm+'" name="LM_DWELL_TEL_AREA_'+lm+'"  maxlength="5" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'<input type="text" id="LM_DWELL_TEL_NUMBER_'+lm+'" name="LM_DWELL_TEL_NUMBER_'+lm+'"  maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>手机号码：</td>'+
    				'<td><input type="text" id="LM_MOBILE_'+lm+'" name="LM_MOBILE_'+lm+'" style="ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>单位名称：</td>'+
    				'<td><input type="text" id="LM_UNIT_NAME_'+lm+'" name="LM_UNIT_NAME_'+lm+'" style="width:300px"/></td>'+
    				'<td>职位：</td>'+
    				'<td><input type="text" id="LM_POSITION_'+lm+'" name="LM_POSITION_'+lm+'" /></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>公司电话：</td>'+
    				'<td><input type="text" id="LM_COMPANY_TEL_AREA_'+lm+'" name="LM_COMPANY_TEL_AREA_'+lm+'" maxlength="5" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'<input type="text" id="LM_COMPANY_TEL_NUMBER_'+lm+'" name="LM_COMPANY_TEL_NUMBER_'+lm+'" maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'<input type="text" id="LM_COMPANY_TEL_EXT_'+lm+'" name="LM_COMPANY_TEL_EXT_'+lm+'" maxlength="10" style="width: 90px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    			'</tr>'+
    		'</table>'+
    	'</fieldset>']
	}else{
		parent.Ext.MessageBox.alert('温馨提示','联系人资料不能超过5个!');
		//document.getElementById(but).disabled=true;
		return ;
	}
	divLinkData.innerHTML=divLinkData.innerHTML + data ;
	initProvinceParams('LM_DWELL_ADDRESS_PROVINCE_'+lm+'');//省
	initSelectParams('LM_RELATION_TO_LOANER_'+lm+'','G_PA_CONTACTS_RELATION'); 
}



//删除 住宅资料 ,房产资料,商业资料,联系人资料
function deleteAllCustomer(customerid,onlyid,applycode,id1,id2,id3,id4,id5){
	if(!checkDelete(id3,id5)){
		return;
	}
	parent.Ext.MessageBox.confirm('温馨提示', '请确认是否删除[删除后数据不可恢复]?',function(btn,action){
	if (btn == 'yes') {
		sureDelete(customerid,onlyid,applycode,id1,id2,id3,id4,id5); //确认是否删除
	}else{
		return ;
		}
	});
}
//住宅资料 ,房产资料,商业资料,联系人资料 只能从最后一个开始删除
function checkDelete(id,keyId){
	if(keyId!=""){
		var len=keyId.split("_").length;
		var n=keyId.split("_");
		var maxNum=0;
		if("RE_"==id) maxNum=re;
		else if("HS_"==id) maxNum=hs;
		else if("BS_"==id) maxNum=bs;
		else if("LM_"==id) maxNum=lm;
		//alert(len+"======="+n+"-=-=-=-="+n[len-1]+"==="+maxNum);
		if((n[len-1])!=maxNum){
			parent.Ext.Msg.alert('温馨提示','无法删除,请依次从最后一个开始删除！');
			return false;
		}
		return true;
	}
	return true;
}

function sureDelete(customerid,onlyid,applycode,id1,id2,id3,id4,id5){
	var my = document.getElementById(id1+id2);
	var url='';
	if(parent.station=='A1'){
		url='apply/applyExtend.action';
	}else if(parent.station=='A4'){
		url='loan/loanExtend.action' ;
	}
	var v=document.getElementById(id5).value;
	new Ajax.Request(web_base_path+url,{
		parameters:{isC:'4','customerid':customerid,'onlyid':onlyid,'trendsId':v,'startVar':id3,'station':parent.station},
		onComplete:function(response, options){
		var arr = Ext.util.JSON.decode(response.responseText);
		if(arr.success){
			if(null!=my){
			my.removeNode('1');
			resetUnionId(id1,id4);
			}	
		}else {
			parent.Ext.Msg.alert('温馨提示',arr.msg);
		}				
		}
	});
}
function resetUnionId(id1,id2){
	if(id1=='re'){
		//deleteRe(id2);
	}else if(id1=='hs'){
		//deleteHs(id2);
	}else if(id1=='bs'){
		//deleteBs(id2);
	}else if(id1=='lm'){
		lm_size--;
		deleteLm(id2);
	}
}

//删除住宅资料 删除的份数
/*function deleteRe(id2){
	var unionIds=id2.id;
	for(var k = unionIds ; k < re ; k++){ 
		var newK = k-0+1 ; 
		document.getElementById("RE_CUSTOMER_ID_"+newK+"").id ="RE_CUSTOMER_ID_"+k+"" ;
		document.getElementById("RE_APPLY_CODE_"+newK+"").id ="RE_APPLY_CODE_"+k+"" ;
		document.getElementById("RE_DWELL_ID_"+newK+"").id ="RE_DWELL_ID_"+k+"" ;
		document.getElementById("RE_ADDRESS_PROVINCE_"+newK+"").id ="RE_ADDRESS_PROVINCE_"+k+"" ;
		document.getElementById("RE_ADDRESS_CITY_"+newK+"").id ="RE_ADDRESS_CITY_"+k+"" ;
		document.getElementById("RE_ADDRESS_AREA_"+newK+"").id ="RE_ADDRESS_AREA_"+k+"" ;
		document.getElementById("RE_ADDRESS_DETAIL_"+newK+"").id ="RE_ADDRESS_DETAIL_"+k+"" ;
		document.getElementById("RE_POST_CODE_"+newK+"").id ="RE_POST_CODE_"+k+"" ;
		document.getElementById("RE_DWELL_TIME_FROM_"+newK+"").id ="RE_DWELL_TIME_FROM_"+k+"" ;
		document.getElementById("RE_DWELL_TIME_LIMIT_"+newK+"").id ="RE_DWELL_TIME_LIMIT_"+k+"" ;
		document.getElementById("RE_TEL_AREA_"+newK+"").id ="RE_TEL_AREA_"+k+"" ;
		document.getElementById("RE_DWELLING_TYPE_"+newK+"").id ="RE_DWELLING_TYPE_"+k+"" ;
		document.getElementById("RE_CONT_OR_RENT_AMOUNT_"+newK+"").id ="RE_CONT_OR_RENT_AMOUNT_"+k+"" ;
		document.getElementById("RE_OWNER_"+newK+"").id ="RE_OWNER_"+k+"" ;
		document.getElementById("RE_RELATION_TO_OWNER_"+newK+"").id ="RE_RELATION_TO_OWNER_"+k+"" ;
		document.getElementById("RE_DWELL_WITH_WHO_"+newK+"").id ="RE_DWELL_WITH_WHO_"+k+"" ;
		document.getElementById("RE_LIVEALONE_"+newK+"").id ="RE_LIVEALONE_"+k+"" ;
		document.getElementById("RE_LIVEPARENT_"+newK+"").id ="RE_LIVEPARENT_"+k+"" ;
		document.getElementById("RE_LIVEBROTHER_"+newK+"").id ="RE_LIVEBROTHER_"+k+"" ;
		document.getElementById("RE_LIVESPOUSE_"+newK+"").id ="RE_LIVESPOUSE_"+k+"" ;
		document.getElementById("RE_LIVECHILDREN_"+newK+"").id ="RE_LIVECHILDREN_"+k+"" ;
		document.getElementById("RE_LIVEWORK_"+newK+"").id ="RE_LIVEWORK_"+k+"" ;
		document.getElementById("RE_OTHER_"+newK+"").id ="RE_OTHER_"+k+"" ;
		document.getElementById("RE_DWELL_NUMBER_"+newK+"").id ="RE_DWELL_NUMBER_"+k+"" ;
	}
}

//删除房产资料
function deleteHs(id2){
	var unionIds=id2.id;
	for(var k = unionIds ; k < hs ; k++){ 
		var newK = k-0+1 ; 
		document.getElementById("HS_CUSTOMER_ID_"+newK+"").id ="HS_CUSTOMER_ID_"+k+"" ;
		document.getElementById("HS_APPLY_CODE_"+newK+"").id ="HS_APPLY_CODE_"+k+"" ;
		document.getElementById("HS_HOUSE_ID_"+newK+"").id ="HS_HOUSE_ID_"+k+"" ;
		document.getElementById("HS_ADDRESS_PROVINCE_"+newK+"").id ="HS_ADDRESS_PROVINCE_"+k+"" ;
		document.getElementById("HS_ADDRESS_CITY_"+newK+"").id ="HS_ADDRESS_CITY_"+k+"" ;
		document.getElementById("HS_ADDRESS_AREA_"+newK+"").id ="HS_ADDRESS_AREA_"+k+"" ;
		document.getElementById("HS_ADDRESS_DETAIL_"+newK+"").id ="HS_ADDRESS_DETAIL_"+k+"" ;
		document.getElementById("HS_BUY_PARTERN_"+newK+"").id ="HS_BUY_PARTERN_"+k+"" ;
		document.getElementById("HS_ESTATE_CERTIFICATE_NO_"+newK+"").id ="HS_ESTATE_CERTIFICATE_NO_"+k+"" ;
		document.getElementById("HS_BUY_TIME_"+newK+"").id ="HS_BUY_TIME_"+k+"" ;
		document.getElementById("HS_YESSEARCHED_"+newK+"").id ="HS_YESSEARCHED_"+k+"" ;
		document.getElementById("HS_NOSEARCHED_"+newK+"").id ="HS_NOSEARCHED_"+k+"" ;
		document.getElementById("HS_BUY_PRICE_"+newK+"").id ="HS_BUY_PRICE_"+k+"" ;
		document.getElementById("HS_SEARCH_DATE_"+newK+"").id ="HS_SEARCH_DATE_"+k+"" ;
		document.getElementById("HS_BUILT_YEAR_"+newK+"").id ="HS_BUILT_YEAR_"+k+"" ;
		document.getElementById("HS_FLOOR_AREA_"+newK+"").id ="HS_FLOOR_AREA_"+k+"" ;
		document.getElementById("HS_SEARCH_UNIT_PRICE_"+newK+"").id ="HS_SEARCH_UNIT_PRICE_"+k+"" ;
		document.getElementById("HS_MORTGAGE_BANK_"+newK+"").id ="HS_MORTGAGE_BANK_"+k+"" ;
		document.getElementById("HS_LOAN_LIMIT_YEAR_"+newK+"").id ="HS_LOAN_LIMIT_YEAR_"+k+"" ;
		document.getElementById("HS_SEARCH_TOTAL_PRICE_"+newK+"").id ="HS_SEARCH_TOTAL_PRICE_"+k+"" ;
		document.getElementById("HS_LOAN_TOTAL_AMOUNT_"+newK+"").id ="HS_LOAN_TOTAL_AMOUNT_"+k+"" ;
		document.getElementById("HS_BALANCE_DUE_"+newK+"").id ="HS_BALANCE_DUE_"+k+"" ;
		document.getElementById("HS_MONTHLY_CONTRIBUTION_"+newK+"").id ="HS_MONTHLY_CONTRIBUTION_"+k+"" ;
		document.getElementById("HS_ESTATE_PURPOSES_"+newK+"").id ="HS_ESTATE_PURPOSES_"+k+"" ;
		document.getElementById("HS_PROPERTY_TYPE_"+newK+"").id ="HS_PROPERTY_TYPE_"+k+"" ;
		document.getElementById("HS_HOUSE_PROPERTY_TYPE_"+newK+"").id ="HS_HOUSE_PROPERTY_TYPE_"+k+"" ;
	}
}

//删除商业资料
function deleteBs(id2){
	var unionIds=id2.id;
	for(var k = unionIds ; k < bs ; k++){ 
		var newK = k-0+1 ; 
		document.getElementById("BS_CUSTOMER_ID_"+newK+"").id ="BS_CUSTOMER_ID_"+k+"" ;
		document.getElementById("BS_APPLY_CODE_"+newK+"").id ="BS_APPLY_CODE_"+k+"" ;
		document.getElementById("BS_BUSINESS_ID_"+newK+"").id ="BS_BUSINESS_ID_"+k+"" ;
		document.getElementById("BS_COMPANY_NAME_"+newK+"").id ="BS_COMPANY_NAME_"+k+"" ;
		document.getElementById("BS_SHOP_NAME_"+newK+"").id ="BS_SHOP_NAME_"+k+"" ;
		document.getElementById("BS_WEB_ADDRESS_"+newK+"").id ="BS_WEB_ADDRESS_"+k+"" ;
		document.getElementById("BS_ADDRESS_PROVINCE_"+newK+"").id ="BS_ADDRESS_PROVINCE_"+k+"" ;
		document.getElementById("BS_ADDRESS_CITY_"+newK+"").id ="BS_ADDRESS_CITY_"+k+"" ;
		document.getElementById("BS_ADDRESS_AREA_"+newK+"").id ="BS_ADDRESS_AREA_"+k+"" ;
		document.getElementById("BS_ADDRESS_DETAIL_"+newK+"").id ="BS_ADDRESS_DETAIL_"+k+"" ;
		document.getElementById("BS_POST_CODE_"+newK+"").id ="BS_POST_CODE_"+k+"" ;
		document.getElementById("BS_TEL_AREA_"+newK+"").id ="BS_TEL_AREA_"+k+"" ;
		document.getElementById("BS_TEL_NUMBERE_"+newK+"").id ="BS_TEL_NUMBER_"+k+"" ;
		document.getElementById("BS_TEL_EXT_"+newK+"").id ="BS_TEL_EXT_"+k+"" ;
		document.getElementById("BS_FAX_AREA_"+newK+"").id ="BS_FAX_AREA_"+k+"" ;
		document.getElementById("BS_FAX_NUMBER_"+newK+"").id ="BS_FAX_NUMBER_"+k+"" ;
		document.getElementById("BS_SERVICE_YEARS_"+newK+"").id ="BS_SERVICE_YEARS_"+k+"" ;
		document.getElementById("BS_SERVICE_MONTHS_"+newK+"").id ="BS_SERVICE_MONTHS_"+k+"" ;
		document.getElementById("BS_UNIT_KIND_"+newK+"").id ="BS_UNIT_KIND_"+k+"" ;
		document.getElementById("BS_INDUSTRY_"+newK+"").id ="BS_INDUSTRY_"+k+"" ;
		document.getElementById("BS_DEPARTMENT_"+newK+"").id ="BS_DEPARTMENT_"+k+"" ;
		document.getElementById("BS_WORK_LEVEL_"+newK+"").id ="BS_WORK_LEVEL_"+k+"" ;
		document.getElementById("BS_POSITION_"+newK+"").id ="BS_POSITION_"+k+"" ;
		document.getElementById("BS_YESOWNER_"+newK+"").id ="BS_YESOWNER_"+k+"" ;
		document.getElementById("BS_NOOWNER_"+newK+"").id ="BS_NOOWNER_"+k+"" ;
		document.getElementById("BS_IS_SELF_EMPLOYED_"+newK+"").name ="BS_IS_SELF_EMPLOYED_"+k+"" ;
		document.getElementById("BS_IS_OWNER_"+newK+"").name ="BS_IS_OWNER_"+k+"" ;
		document.getElementById("BS_YESSELFEMPLOYED_"+newK+"").id ="BS_YESSELFEMPLOYED_"+k+"" ;
		document.getElementById("BS_NOSELFEMPLOYED_"+newK+"").id ="BS_NOSELFEMPLOYED_"+k+"" ;
		document.getElementById("BS_BUSINESS_LICENCE_NO_"+newK+"").id ="BS_BUSINESS_LICENCE_NO_"+k+"" ;
		document.getElementById("BS_ORGANIZATION_CODE_"+newK+"").id ="BS_ORGANIZATION_CODE_"+k+"" ;
		document.getElementById("BS_ESTABLISH_DATE_"+newK+"").id ="BS_ESTABLISH_DATE_"+k+"" ;
		document.getElementById("BS_YEARLY_PROFIT_OR_LOSS_"+newK+"").id ="BS_YEARLY_PROFIT_OR_LOSS_"+k+"" ;
		document.getElementById("BS_EMPLOYEE_AMOUNT_"+newK+"").id ="BS_EMPLOYEE_AMOUNT_"+k+"" ;
		document.getElementById("BS_BUSINESS_PLACE_"+newK+"").id ="BS_BUSINESS_PLACE_"+k+"" ;
		document.getElementById("BS_CONT_OR_RENT_AMOUNT_"+newK+"").id ="BS_CONT_OR_RENT_AMOUNT_"+k+"" ;
		document.getElementById("BS_BASE_SALARY_"+newK+"").id ="BS_BASE_SALARY_"+k+"" ;
		document.getElementById("BS_OTHER_INCOME_"+newK+"").id ="BS_OTHER_INCOME_"+k+"" ;
		document.getElementById("BS_MONTHLY_TOTAL_INCOME_"+newK+"").id ="BS_MONTHLY_TOTAL_INCOME_"+k+"" ;
		document.getElementById("BS_PAY_PATTERN_"+newK+"").id ="BS_PAY_PATTERN_"+k+"" ;
		document.getElementById("BS_PAY_TIME_ONE_"+newK+"").id ="BS_PAY_TIME_ONE_"+k+"" ;
		document.getElementById("BS_PAY_TIME_TWO_"+newK+"").id ="BS_PAY_TIME_TWO_"+k+"" ;
	}
}
*/
//删除联系人资料
function deleteLm(id2){
	var unionIds=id2.id;
	for(var k = unionIds ; k < lm ; k++){
		var newK = k-0+1 ; 
		document.getElementById("LM_CUSTOMER_ID_"+newK+"").id ="LM_CUSTOMER_ID_"+k+"" ;
		document.getElementById("LM_ONLY_ID_"+newK+"").id ="LM_ONLY_ID_"+k+"" ;
		document.getElementById("LM_APPLY_CODE_"+newK+"").id ="LM_APPLY_CODE_"+k+"" ;
		document.getElementById("LM_LINKMAN_ID_"+newK+"").id ="LM_LINKMAN_ID_"+k+"" ;
		document.getElementById("LM_NAME_"+newK+"").id ="LM_NAME_"+k+"" ;
		document.getElementById("LM_AGE_"+newK+"").id ="LM_AGE_"+k+"" ;
		document.getElementById("SPAN_LMSEX_"+newK+"").id="SPAN_LMSEX_"+k+"";
		document.getElementById("LM_SEX_"+newK+"").id ="LM_SEXW_"+k+"" ;
		document.getElementById("LM_SEXM_"+newK+"").id ="LM_SEXM_"+k+"" ;
		document.getElementById("LM_SEXA_"+newK+"").name="LM_SEX_"+k+"" ;
		document.getElementById("LM_YES_KOWN_LOAN_"+newK+"").id ="LM_YES_KOWN_LOAN_"+k+"" ;
		document.getElementById("LM_NO_KOWN_LOAN_"+newK+"").id ="LM_NO_KOWN_LOAN_"+k+"" ;
		document.getElementById("LM_RELATION_TO_LOANER_"+newK+"").id ="LM_RELATION_TO_LOANER_"+k+"" ;
		document.getElementById("LM_RELATION_TO_LOANER_DESC_"+newK+"").id ="LM_RELATION_TO_LOANER_DESC_"+k+"" ;
		document.getElementById("LM_DWELL_ADDRESS_PROVINCE_"+newK+"").id ="LM_DWELL_ADDRESS_PROVINCE_"+k+"" ;
		document.getElementById("LM_DWELL_ADDRESS_CITY_"+newK+"").id ="LM_DWELL_ADDRESS_CITY_"+k+"" ;
		document.getElementById("LM_DWELL_ADDRESS_AREA_"+newK+"").id ="LM_DWELL_ADDRESS_AREA_"+k+"" ;
		document.getElementById("LM_DWELL_ADDRESS_DETAIL_"+newK+"").id ="LM_DWELL_ADDRESS_DETAIL_"+k+"" ;
		document.getElementById("LM_DWELL_TEL_AREA_"+newK+"").id ="LM_DWELL_TEL_AREA_"+k+"" ;
		document.getElementById("LM_DWELL_TEL_NUMBER_"+newK+"").id ="LM_DWELL_TEL_NUMBER_"+k+"" ;
		document.getElementById("LM_MOBILE_"+newK+"").id ="LM_MOBILE_"+k+"" ;
		document.getElementById("LM_UNIT_NAME_"+newK+"").id ="LM_UNIT_NAME_"+k+"" ;
		document.getElementById("LM_POSITION_"+newK+"").id ="LM_POSITION_"+k+"" ;
		document.getElementById("LM_COMPANY_TEL_AREA_"+newK+"").id ="LM_COMPANY_TEL_AREA_"+k+"" ;
		document.getElementById("LM_COMPANY_TEL_NUMBER_"+newK+"").id ="LM_COMPANY_TEL_NUMBER_"+k+"" ;
		document.getElementById("LM_COMPANY_TEL_EXT_"+newK+"").id ="LM_COMPANY_TEL_EXT_"+k+"" ;
	}
}
