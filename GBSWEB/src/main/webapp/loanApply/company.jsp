<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<input type="hidden" id="UNIT_KIND_VAL"	value="${company.UNIT_KIND}" />
<input type="hidden" id="INDUSTRY_VAL" value="${company.INDUSTRY}" />
<input type="hidden" id="IS_OWNER_VAL" value="${company.IS_OWNER}" />
<input type="hidden" id="IS_SELF_EMPLOYED_VAL" value="${company.IS_SELF_EMPLOYED}" />
<!--商业资料-->
<div id="divBusiness" class="divStyle">  	
    	   <input type="button" id="businessButton" value="添加商业资料" onclick="addBusinessData()"/>   	
<fieldset id="hs">
	<legend>商业资料</legend>
	<table>
		<tr>
			<td><input type="button" id="clearHsButton" value="清除"
				onclick="ResetControl('HS_','');"></td>
		</tr>
		<tr>
			<td>公司名称：</td>
			<td><input type="text" id="COMPANY_NAME"
				name="companyInfo[0].COMPANY_NAME" style="width: 200px;"
				value="${company.COMPANY_NAME}"
				onkeyup="clearCom(this,'BSMY_COMPANYNAME','BS_SHOP_NAME','BSMY_SHOPNAME');" /></td>
			<td>公司电话：</td>
			<td><input type="text" id="COM_TEL_NUMBER"
				name="companyInfo[0].COM_TEL_NUMBER" style="width: 200px;"
				value="${company.COM_TEL_NUMBER}"
				onkeyup="clearCom(this,'BSMY_COMPANYNAME','BS_SHOP_NAME','BSMY_SHOPNAME');" /></td>
		</tr>
		<tr>
			<td>公司详细地址：</td>
			<td colspan=6><textarea rows="2" cols="50"
					id="COM_ADDRESS_DETAIL" name="companyInfo[0].COM_ADDRESS_DETAIL">${company.COM_ADDRESS_DETAIL}</textarea>
			</td>
		</tr>
		<tr>
			<td>公司传真：</td>
			<td><input type="text" id="FAX_NUMBER"
				name="companyInfo[0].FAX_NUMBER" style="width: 200px;"
				value="${company.FAX_NUMBER}"
				onkeyup="clearCom(this,'BSMY_COMPANYNAME','BS_SHOP_NAME','BSMY_SHOPNAME');" /></td>
			<td>服务年数：</td>
			<td><input type="text" id="SERVICE_YEARS"
				name="companyInfo[0].SERVICE_YEARS"
				value="${company.SERVICE_YEARS}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
		</tr>
		<tr>
			<td><font color="red">*</font>单位性质：</td>
			<td><select id="UNIT_KIND" name="companyInfo[0].UNIT_KIND"
				onblur="checknull2(this)"
				onchange="getUnitPropertyMap(this.id,'BS_INDUSTRY');getOccupationMap(this.id,'BS_WORK_LEVEL');">
					<option value="01">国有企业</option>
					<option value="02">私营</option>
					<option value="03">个体</option>
					<option value="04">政府机构</option>
					<option value="05">机关事业</option>
			</select></td>
			<td><font color="red">*</font>所属行业：</td>
			<td><select id="INDUSTRY" name="companyInfo[0].INDUSTRY"
				onblur="checknull2(this)" style="width: 200px">
					<option value="01">科技</option>
					<option value="02">金融</option>
					<option value="03">服务</option>
			</select></td>
		</tr>
		<tr>
			<td>部门：</td>
			<td><input type="text" id="DEPARTMENT"
				name="companyInfo[0].DEPARTMENT"
				value="${company.DEPARTMENT}" /></td>
			<td>职务：</td>
			<td><input type="text" id="POSITION"
				name="companyInfo[0].POSITION" style="width: 100px;"
				value="${company.POSITION}" /></td>
		</tr>
		<tr>
			<td>是否公司东主：</td>
			<td><span id="SPAN_IS_OWNER"> <input type="radio"
					id="IS_OWNER_Y" name="companyInfo[0].IS_OWNER" value="Y" />是 <input
					type="radio" id="IS_OWNER_N" name="companyInfo[0].IS_OWNER"
					value="N" />否
			</span></td>
			<td><font color="red">*</font>是否自雇人士：</td>
			<td><span id="SPAN_IS_SELF_EMPLOYED"> <input type="radio"
					id="IS_SELF_EMPLOYED_Y" name="companyInfo[0].IS_SELF_EMPLOYED"
					value="Y" />是 <input type="radio" id="IS_SELF_EMPLOYED_N"
					name="companyInfo[0].IS_SELF_EMPLOYED" value="N" />否
			</span></td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>补充资料(适用于企业东主)</legend>
	<table>
		<tr>
			<td>营业执照注册号：</td>
			<td><input type="text" id="BUSINESS_LICENCE_NO"
				name="companyInfo[0].BUSINESS_LICENCE_NO" maxlength="20"
				value="${company.BUSINESS_LICENCE_NO}" " /></td>
			<td>组织机构代码：</td>
			<td><input type="text" id="ORGANIZATION_CODE"
				name="companyInfo[0].ORGANIZATION_CODE" maxlength="9"
				value="${company.ORGANIZATION_CODE}" /></td>
			<td>成立日期：</td>
			<td><input type="text" id="ESTABLISH_DATE" name="companyInfo[0].ESTABLISH_DATE"
				value="${company.ESTABLISH_DATE}" class="Wdate"
				onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
				style="width: 100px;" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>每年盈利/亏损：</td>
			<td><input type="text" id="YEARLY_PROFIT_OR_LOSS"
				name="companyInfo[0].YEARLY_PROFIT_OR_LOSS"
				value="${company.YEARLY_PROFIT_OR_LOSS}"
				style="ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
			<td>雇员人数：</td>
			<td><input type="text" id="EMPLOYEE_AMOUNT"
				name="companyInfo[0].EMPLOYEE_AMOUNT" style="ime-mode: Disabled;"
				maxlength="5"
				onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"
				value="${company.EMPLOYEE_AMOUNT}" /></td>
		</tr>
		<tr>
			<td>经营场所：</td>
			<td><select id="BUSINESS_PLACE" name="companyInfo[0].BUSINESS_PLACE">
					<option value="01">自有</option>
					<option value="02">租用</option>
					<option value="03">按揭</option>
			</select></td>
			<td>按揭供款/租金：</td>
			<td><input type="text" id="CONT_OR_RENT_AMOUNT"
				name="companyInfo[0].CONT_OR_RENT_AMOUNT"
				value="${company.CONT_OR_RENT_AMOUNT}"
				style="ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" />
			</td>
		</tr>
	</table>
</fieldset>
<fieldset>
	<legend>每月收入</legend>
	<table>
		<tr>
			<td><font color="red">*</font>基本薪金：</td>
			<td><input type="text" id="BASE_SALARY"
				name="companyInfo[0].BASE_SALARY"
				value="${company.BASE_SALARY}"
				" style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))"
				onkeyup="totalBusIncome(this,'BS_OTHER_INCOME','BS_MONTHLY_TOTAL_INCOME')" /></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其它收入：</td>
			<td><input type="text" id="OTHER_INCOME"
				name="companyInfo[0].OTHER_INCOME}"
				value="${company.OTHER_INCOME}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))"
				onkeyup="totalBusIncome('BS_BASE_SALARY',this,'BS_MONTHLY_TOTAL_INCOME')" /></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每月总收入：</td>
			<td><input type="text" id="MONTHLY_TOTAL_INCOME"
				name="companyInfo[0].MONTHLY_TOTAL_INCOME"
				value="${company.MONTHLY_TOTAL_INCOME}"
				style="background-color: #E6E6E6; width: 100px;" maxlength="12"
				readonly="readonly" /></td>
		</tr>
		<tr>
			<td><font color="red">*</font>支付方式：</td>
			<td><select id="PAY_PATTERN" name="companyInfo[0].PAY_PATTERN"
				onblur="checknull2(this)">
					<option value="AP">自动转账</option>
					<option value="CA">现金</option>
					<option value="CQ">支票</option>
			</select>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;支付日：</td>
			<td>(1)<input type="text" id="PAY_TIME_ONE"
				name="companyInfo[0].PAY_TIME_ONE"
				value="${company.PAY_TIME_ONE}"
				style="width: 50px; ime-mode: Disabled;" maxlength="2"
				onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />
			</td>
		</tr>
	</table>
</fieldset>
</div>
