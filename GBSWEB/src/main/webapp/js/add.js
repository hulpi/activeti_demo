//增加房产资料
var i=0,j=0,k=0;
function addHouseData(){
	i++;
	if(i<2){
		var data = [
   		 	'<fieldset id="hs_id'+i+'"><legend>房产资料</legend>'+
    		'<table  border="0" align="left" id="mtable" height="100%">'+
    			'<tr>'+
    				'<td ><input type="button" value="清除" onclick=\'ResetControl("");\'></td>'+
    				'<td ><input type="button" value="删除房产资料" onclick=\'deleteHs("hs_id'+i+'");\' id=""></td>'+
    			'</tr><tr>'+
    				'<td>房产地址详细地址：</td>'+
    				'<td colspan=6><textarea rows="2" cols="50" id="HS_ADDRESS_DETAIL'+i+'" name=\'hostInfo['+i+'].HS_ADDRESS_DETAIL\' ></textarea></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>购买方式：</td>'+
    				'<td>'+
    				       '<select id="BUY_PARTERN'+i+'" name=\'hostInfo['+i+'].BUY_PARTERN.BUY_PARTERN\'>'+
					        '<option value="M">按揭</option>'+
				            '<option value="O">一次性</option>'+	   
		    		        '</select>'+
					'</td>'+
					'<td>房地产证号：</td>'+
    				'<td><input type="text" id="ESTATE_CERTIFICATE_NO'+i+'" name=\'hostInfo['+i+'].ESTATE_CERTIFICATE_NO\' style="width: 100px;"  /></td>'+
    			'</tr><tr>'+
    				'<td>购买日期：</td>'+
    				'<td><input type="text" id="BUY_TIME'+i+'" name=\'hostInfo['+i+'].BUY_TIME\' class="Wdate" onclick=\'WdatePicker({readOnly:true,skin:"ext",dateFmt:"yyyy-MM-dd",minDate:"1900/01/01",maxDate:"%y-%M-%d"});\' style="width: 100px;" readonly="readonly"/></td>'+
    				'<td>房产查询资料：</td>'+
    		    	'<td><label for="HS_YESSEARCHED"><input type="radio" id="IS_SEARCHED_Y'+i+'" name=\'hostInfo['+i+'].IS_SEARCHED\' value="Y" onclick=\'hsSelectData(this.name,"HS_SEARCH_DATE","HS_SEARCH_UNIT_PRICE","HS_SEARCH_TOTAL_PRICE");\' />有</label>'+
    		    		'<label for="HS_NOSEARCHED"><input type="radio" id="IS_SEARCHED_N'+i+'" name=\'hostInfo['+i+'].IS_SEARCHED\' value="N" onclick=\'hsSelectData(this.name,"HS_SEARCH_DATE","HS_SEARCH_UNIT_PRICE","HS_SEARCH_TOTAL_PRICE");\' checked/>无</label>'+
    		    	'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>购买价格：</td>'+
    				'<td><input type="text" id="BUY_PRICE'+i+'" name=\'hostInfo['+i+'].BUY_PRICE\' maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'<td>查询日期：</td>'+
    				'<td><input type="text" id="SEARCH_DATE'+i+'" name=\'hostInfo['+i+'].SEARCH_DATE\'  class="Wdate" onclick=\'WdatePicker({readOnly:true,skin:"ext",dateFmt:"yyyy-MM-dd",minDate:"1900/01/01",maxDate:"%y-%M-%d"});\' style="width: 100px;" readonly="readonly"/></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>建筑年份：</td>'+
    				'<td><input type="text" id="BUILT_YEAR'+i+'" name=\'hostInfo['+i+'].BUILT_YEAR\'  maxlength="4" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop= "return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>建筑面积：</td>'+
    				'<td><input type="text" id="FLOOR_AREA'+i+'" name=\'hostInfo['+i+'].FLOOR_AREA\'  maxlength="13" onkeyup=\'countHsTotalPrice("HS_SEARCH_UNIT_PRICE","HS_FLOOR_AREA","HS_SEARCH_TOTAL_PRICE")\' style="width:100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/>平方米</td>'+
    				'<td>查询单价：</td>'+
    				'<td><input type="text" id="SEARCH_UNIT_PRICE'+i+'" name=\'hostInfo['+i+'].SEARCH_UNIT_PRICE\'  maxlength="13" onkeyup=\'countHsTotalPrice("HS_SEARCH_UNIT_PRICE","HS_FLOOR_AREA","HS_SEARCH_TOTAL_PRICE")\' disabled="disabled" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    			'</tr><tr>'+
    				'<td>按揭银行：</td>'+
    				'<td><input type="text" id="MORTGAGE_BANK'+i+'" name=\'hostInfo['+i+'].MORTGAGE_BANK\' style="width: 100px;"/></td>'+
    				'<td>贷款年限：</td>'+
    				'<td><input type="text" id="LOAN_LIMIT_YEAR'+i+'" name=\'hostInfo['+i+'].LOAN_LIMIT_YEAR\'  maxlength="3" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)"onpaste="return regInput2(this,/^[0-9]*$/)"ondrop= "return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>查询总价：</td>'+
    				'<td><input type="text" id="SEARCH_TOTAL_PRICE'+i+'" name=\'hostInfo['+i+'].SEARCH_TOTAL_PRICE\' disabled="disabled" maxlength="22" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\.?\\d{0,2}$/)"/></td>'+
    			'</tr><tr>'+
    				'<td>贷款总额：</td>'+
    				'<td><input type="text" id="LOAN_TOTAL_AMOUNT'+i+'" name=\'hostInfo['+i+'].LOAN_TOTAL_AMOUNT\'  maxlength="13"  style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'<td>尚欠余额：</td>'+
    				'<td><input type="text" id="BALANCE_DUE'+i+'" name=\'hostInfo['+i+'].BALANCE_DUE\' maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'<td>每月供款：</td>'+
    				'<td><input type="text" id="MONTHLY_CONTRIBUTION'+i+'" name=\'hostInfo['+i+'].MONTHLY_CONTRIBUTION\'  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    			'</tr><tr>'+
    				'<td>房产用途：</td>'+
    				'<td><select id="ESTATE_PURPOSES'+i+'" name=\'hostInfo['+i+'].ESTATE_PURPOSES\'>'+
    		    		'<option value="">--请选择--</option>'+
    					'</select>'+
    		    	'</td>'+
    				'<td>物业类型：</td>'+
    				'<td><select id="PROPERTY_TYPE'+i+'" name=\'hostInfo['+i+'].PROPERTY_TYPE\'>'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    		    	'<td>房屋产权类型：</td>'+
    				'<td><select id="HOUSE_PROPERTY_TYPE'+i+'" name=\'hostInfo['+i+'].HOUSE_PROPERTY_TYPE\'>'+
    		    		'<option value="">--请选择--</option>'+	
    					'</select>'+
    		    	'</td>'+
    			'</tr></table></fieldset>'].join('');
		  var divHouse= document.getElementById('divHouse')
		  divHouse.innerHTML=divHouse.innerHTML + data ;		
	} else{
		alert("房产资料不能超过俩个");
	}
}
//增加公司资料
//添加商业资料
function addBusinessData(){
	    j++;
	    if(j<2){    
		var data = [
   			'<fieldset id="bs_id'+i+'"><legend>商业资料</legend>'+
			'<table  border="0"  id="mtable" height="100%">'+
    			'<tr>'+
    				'<td ><input type="button" value="清除"></td>'+
    				'<td ><input type="button" value="删除商业资料" onclick=\'deleteHs("bs_id'+i+'");\'/></td>'+
    			'<tr>'+
    				'<td>公司名称：</td>'+
    				'<td><input type="text" id="COMPANY_NAME'+j+'" name=\'companyInfo['+j+'].COMPANY_NAME\' onkeyup=\'clearCom(this,"BSCOMPANYNAME","BS_SHOP_NAME","");\' style="width: 200px;"/></td>'+
    				'<td>公司电话：</td>'+
    				'<td><input type="text" id="COM_TEL_NUMBER'+j+'" name=\'companyInfo['+j+'].COM_TEL_NUMBER\' style="width: 100px;" /></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>公司详细地址：</td>'+
    				'<td colspan=6>'+
    				  '<textarea rows="2" cols="50" id="COM_ADDRESS_DETAIL'+j+'" name=\'companyInfo[1].COM_ADDRESS_DETAIL\' ></textarea>'+
					'</td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>公司传真：</td>'+
    				'<td><input type="text" id="FAX_NUMBER'+j+'" name=\'companyInfo['+j+'].FAX_NUMBER\'  maxlength="5" style="width:50px;ime-mode:Disabled;"  onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'</td>'+
    				'<td>服务年数：</td>'+
    				'<td><input type="text" id="SERVICE_YEARS'+j+'" name=\'companyInfo['+j+'].SERVICE_YEARS\'  maxlength="2" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>年'+
    				'</td>'+
    			'</tr>'+
    			 '</tr>'+
    			   '<td><font color="red">*</font>单位性质：</td>'+
    			   '<td>'+'<select id="UNIT_KIND'+j+'" name=\'companyInfo['+j+'].UNIT_KIND\'onblur="checknull2(this)" >'+
    			    '<option value="01">国有企业</option>'+
					'<option value="02">私营</option>'+
					'<option value="03">个体</option>'+
					'<option value="04">政府机构</option>'+
					'<option value="05">机关事业</option>'+
		    		'</select>'+
		    		'<td><font color="red">*</font>所属行业：</td>'+
		    		'<td><select id="INDUSTRY'+j+'" name=\'companyInfo['+j+'].INDUSTRY\' onblur="checknull2(this)"  style="width:200px">'+
		    		'<option value="01">科技</option><option value="02">金融</option><option value="03">服务</option>'+
		    		'</select>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>部门：</td>'+
    				'<td><input type="text" id="DEPARTMENT'+j+'" name=\'companyInfo['+j+'].DEPARTMENT\' /></td>'+
    		    	'<td>职务：'+
    				'<input type="text" id="POSITION'+j+'" name=\'companyInfo['+j+'].POSITION\' style="width: 100px;" >'+
   					'</td>'+
   					'</tr>'+ 			
    			'<tr>'+
    				'<td>是否公司东主：</td>'+
    				'<td>'+
    					'<span id="SPAN_IS_OWNER'+j+'">'+
						'<label for="IS_OWNER_Y'+j+'"><input type="radio" id="IS_OWNER_Y'+j+'" name=\'companyInfo['+j+'].IS_OWNER\' value="Y"/>是</label>'+
						'<label for="IS_OWNER_N'+j+'"><input type="radio" id="IS_OWNER_N'+j+'" name=\'companyInfo['+j+'].IS_OWNER\' value="N"/>否</label>'+
						'</span>'+
					'</td>'+
					'<td><font color="red">*</font>是否自雇人士：</td>'+
    				'<td>'+
						'<span id="SPAN_IS_SELF_EMPLOYED'+j+'"><label for="IS_SELF_EMPLOYED'+j+'"><input type="radio" id="IS_SELF_EMPLOYED'+j+'" name=\'companyInfo['+j+'].IS_SELF_EMPLOYED\' value="Y" />是</label>'+
						'<label for="NOSELFEMPLOYED'+j+'"><input type="radio" id="NOSELFEMPLOYED'+j+'" name=\'companyInfo['+j+'].IS_SELF_EMPLOYED\' value="N"/>否</label></span>'+
					'</td>'+
    			'</tr>'+
    		'</table>'+
    		'<fieldset>'+
    			'<legend>补充资料(适用于企业东主)</legend>'+
    			'<table>'+
    				'<tr>'+
    					'<td>营业执照注册号：</td>'+
    					'<td><input type="text" id="BUSINESS_LICENCE_NO'+j+'" name=\'companyInfo['+j+'].BUSINESS_LICENCE_NO\'/></td>'+
    					'<td>组织机构代码：</td>'+
    					'<td><input type="text" id="ORGANIZATION_CODE'+j+'" name=\'companyInfo['+j+'].ORGANIZATION_CODE\' maxlength="9"/></td>'+
    					'<td>成立日期：</td>'+
    					'<td><input type="text" id="ESTABLISH_DATE'+j+'" name=\'companyInfo['+j+'].ESTABLISH_DATE\' class="Wdate" onclick=\'WdatePicker({readOnly:true,skin:"ext",dateFmt:"yyyy/MM/dd",minDate:"1900/01/01",maxDate:"%y-%M-%d"});\' readonly="readonly" style="width: 100px;"/></td>'+
    				'</tr>'+
    				'<tr>'+
    					'<td>每年盈利/亏损：</td>'+
    					'<td><input type="text" id="YEARLY_PROFIT_OR_LOSS'+j+'" name=\'companyInfo['+j+'].YEARLY_PROFIT_OR_LOSS\' style="ime-mode:Disabled;" maxlength="13" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)" /></td>'+
    					'<td>雇员人数：</td>'+
    					'<td><input type="text" id="EMPLOYEE_AMOUNT'+j+'" name=\'companyInfo['+j+'].EMPLOYEE_AMOUNT\' style="ime-mode:Disabled;" maxlength="5" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'</tr>'+
    				'<tr>'+
    				'<td>经营场所：</td>'+
    					'<td><select id="BUSINESS_PLACE'+j+'" name=\'companyInfo['+j+'].BUSINESS_PLACE\'>'+
							'<option value="">--请选择--</option>'+
    		    			'</select>'+
    		    		'</td>'+
    					'<td>按揭供款/租金：</td>'+
    					'<td><input type="text" id="CONT_OR_RENT_AMOUNT'+j+'" name=\'companyInfo['+j+'].CONT_OR_RENT_AMOUNT\' style="ime-mode:Disabled;"  maxlength="13"  onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    				'</tr>'+
    			'</table>'+
    		'</fieldset>'+
    		'<fieldset>'+
    			'<legend>每月收入</legend>'+
    			'<table>'+
    				'<tr>'+
    					'<td><font color="red">*</font>基本薪金：</td>'+
    					'<td><input type="text" id="BASE_SALARY'+j+'" name=\'companyInfo['+j+'].BASE_SALARY\'  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeyup=\'totalBusIncome(this,"BS_OTHER_INCOME","BS_MONTHLY_TOTAL_INCOME");\' maxlength="9" onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)" onblur="checknull(this);"/></td>'+
    					'<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其它收入：</td>'+
    					'<td><input type="text" id="OTHER_INCOME'+j+'" name=\'companyInfo['+j+'].OTHER_INCOME\'  maxlength="13" style="width: 100px;ime-mode:Disabled;" onkeyup=\'totalBusIncome("BS_BASE_SALARY",this,"BS_MONTHLY_TOTAL_INCOME");\' onkeypress="return regInput1(this,/^\\d*\\.?\\d{0,2}$/)" onpaste="return regInput2(this,/^\\d*\\.?\\d{0,2}$/)" ondrop="return regInput3(this,/^\\d*\\.?\\d{0,2}$/)"/></td>'+
    					'<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每月总收入：'+
    					'<td><input type="text" id="MONTHLY_TOTAL_INCOME'+j+'" name=\'companyInfo['+j+'].MONTHLY_TOTAL_INCOME\' maxlength="12" style="background-color: #E6E6E6;width: 100px;ime-mode:Disabled;" maxlength="12" readonly="readonly"/></td>'+
    				'</tr>'+
    				'<tr>'+
    					'<td><font color="red">*</font>支付方式：</td>'+
    					'<td><select id="PAY_PATTERN'+j+'" name=\'companyInfo['+j+'].PAY_PATTERN\' style="width: 100px;" onblur="checknull2(this)"> <option value="">--请选择--</option></select></td>'+
    					'<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;支付日：</td>'+
    					'<td>(1)<input type="text" id="PAY_TIME_ONE'+j+'" name=\'companyInfo['+j+'].PAY_TIME_ONE\'  maxlength="2" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>'+
    					'</td>'+
    				'</tr>'+
    			'</table>'+
    		'</fieldset>'+
    	'</fieldset>'].join('');
		  var divBusiness= document.getElementById('divBusiness')
		  divBusiness.innerHTML=divBusiness.innerHTML + data ;
		  //alert($('#COMPANY_NAME'+j).attr("name"));
	    }else{
	    	alert("商业资料不能超过俩个");
	    }
}	
//添加联系人信息
function addLinkmanData(){
	 k++;
	 if(k<5){
		var data = [
   		 	'<fieldset id="lk_id'+k+'">'+
    		'<legend>联系人资料</legend>'+
    		'<table border="0" align="left">'+
    			'<tr>'+
    			'<td ><input type="button" value="清除"/></td>'+
    			'<td ><input type="button" value="删除联系人资料" onclick=\'deleteLinkman("lk_id'+k+'","'+k+'");\'></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>姓名：</td>'+
    				'<td><input type="text" id="LINKMAN_NAME'+k+'" name="linkManInfo[0].LINKMAN_NAME"  maxlength="40" style="width: 100px;"/></td>'+
    				'<td>年龄：</td>'+
    				'<td><input type="text" id="LM_AGE" name="LM_AGE"  maxlength="3" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+				
    			'</tr>'+
    			'<tr>'+
    			  '<td>性别：</td>'+
				   '<td><span id="SPAN_LMSEX"><label for="LM_SEXW"><input type="radio" id="LM_SEXW" name="LM_SEX" value="M"/>男</label>'+
					'<label for="LM_SEXM"><input type="radio" id="LM_SEXM" name="LM_SEX" value="F"/>女</label></span>'+
				   '</td>'+
    				'<td>关系：</td>'+
    				'<td> <select id="RELATION_TO_LOANER" name="RELATION_TO_LOANER">'+
    				'<option value="01">母女</option> <option value="02">朋友</option> <option value="03">父子</option> <option value="04">叔侄</option>'+
    				'</select>'+
    				'</td>'+
    		    	'<td></td>'+
    		    	'<td></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>住宅详细地址：</td>'+
    			     '<td colspan=6> <textarea rows="2" cols="50" id="DWELL_ADDRESS_DETAIL" name="linkManInfo[1].DWELL_ADDRESS_DETAIL" value="${l.linkManInfo[1].DWELL_ADDRESS_DETAIL}"></textarea></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>住宅电话：</td>'+
    				'<td><input type="text" id="LM_DWELL_TEL_AREA" name="LM_DWELL_TEL_AREA"  maxlength="5" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/>-'+
    				'<input type="text" id="LM_DWELL_TEL_NUMBER" name="LM_DWELL_TEL_NUMBER"  maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    				'<td>手机号码：</td>'+
    				'<td><input type="text" id="LM_MOBILE" name="LM_MOBILE" style="ime-mode:Disabled;" onkeypress="return regInput1(this,/^[0-9]*$/)" onpaste="return regInput2(this,/^[0-9]*$/)" ondrop="return regInput3(this,/^[0-9]*$/)"/></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>单位名称：</td>'+
    				'<td><input type="text" id="LM_UNIT_NAME" name="LM_UNIT_NAME" style="width:300px"/></td>'+
    				'<td>职位：</td>'+
    				'<td><input type="text" id="LM_POSITION" name="LM_POSITION" /></td>'+
    			'</tr>'+
    			'<tr>'+
    				'<td>单位电话：</td>'+
    				'<td><input type="text" id="M_UINT_TEL_NUMBER" name="linkManInfo[1].M_UINT_TEL_NUMBER" value="${l.linkManInfo[1].M_UINT_TEL_NUMBER}" style="width: 140px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"/>'+
    				 '</td>'+
    			'</tr>'+
    		'</table>'+
    	'</fieldset>']
	var divLinkData=document.getElementById('divLinkData')
	divLinkData.innerHTML=divLinkData.innerHTML + data ;
	 }else{
		 alert("联系人资料不能超过五个");
	 }
}
//删除房产资料,商业资料
function deleteHs(id){
	i--;
	j--;
	$("#"+id).remove();
}
//删除联系人
function deleteLinkman(id,h){
	if(h<k){
	   alert("无法删除，请依次从最后一个删除");
	}else{
		k--;
		$("#"+id).remove();
	}	
}



