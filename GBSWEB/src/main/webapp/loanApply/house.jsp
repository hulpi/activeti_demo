<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<input type="hidden" id="BUY_PARTERN_VAL"	value="${house.BUY_PARTERN}" />
<input type="hidden" id="ESTATE_PURPOSES_VAL"	value="${house.ESTATE_PURPOSES}" />
<input type="hidden" id="PROPERTY_TYPE_VAL"	value="${house.PROPERTY_TYPE}" />
<input type="hidden" id="HOUSE_PROPERTY_TYPE_VAL"	value="${house.HOUSE_PROPERTY_TYPE}" />
<input type="hidden" id="IS_SEARCHED_VAL"	value="${house.IS_SEARCHED}" />

<!--房产资料-->
<div id="divHouse" class="divStyle">
    	<input type="button" id="houseButton" value="添加房产资料" onclick="addHouseData()"/>
<fieldset id="hs">
	<legend>房产资料</legend>
	<table>
		<tr>
			<td><input type="button" id="clearHsButton" value="清除"
				onclick="ResetControl('HS_','');"></td>
		</tr>
		<tr>
			<td>住宅详细地址：</td>
			<td colspan=6><textarea rows="2" cols="50"
					id="HS_ADDRESS_DETAIL" name="hostInfo[0].HS_ADDRESS_DETAIL">${house.HS_ADDRESS_DETAIL}</textarea>
			</td>
		</tr>
		<tr>
			<td>购买方式：</td>
			<td><select id="BUY_PARTERN" name="hostInfo[0].BUY_PARTERN">
					<option value="M">按揭</option>
					<option value="O">一次性</option>
			</select></td>
			<td>房地产证号：</td>
			<td><input type="text" id="ESTATE_CERTIFICATE_NO"
				name="hostInfo[0].ESTATE_CERTIFICATE_NO"
				value="${house.ESTATE_CERTIFICATE_NO}" /></td>
		</tr>
		<tr>
			<td>购买日期：</td>
			<td><input type="text" id="BUY_TIME" name="hostInfo[0].BUY_TIME"
				value="${house.BUY_TIME }" class="Wdate"
				onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
				readonly="readonly" style="width: 100px;" readonly="readonly" /></td>
			<td>房产查询资料：</td>
			<td><input type="radio" id="IS_SEARCHED_Y" name="hostInfo[0].IS_SEARCHED"
				value="Y" />有 <input type="radio" id="IS_SEARCHED_N"
				name="hostInfo[0].IS_SEARCHED" value="N" onclick=""  />无</td>
		</tr>
		<tr>
			<td>购买价格：</td>
			<td><input type="text" id="BUY_PRICE"
				name="hostInfo[0].BUY_PRICE" value="${house.BUY_PRICE}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
			<td>查询日期：</td>
			<td><input type="text" id="SEARCH_DATE"
				name="hostInfo[0].SEARCH_DATE" class="Wdate"
				value="${house.SEARCH_DATE }"
				onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
				readonly="readonly" style="width: 100px;" /></td>
		</tr>
		<tr>
			<td>建筑年份：</td>
			<td><input type="text" id="BUILT_YEAR"
				name="hostInfo[0].BUILT_YEAR" value="${house.BUILT_YEAR}"
				maxlength="4" style="width: 100px; ime-mode: Disabled;"
				maxlength="4"
				onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
			<td>建筑面积：</td>
			<td><input type="text" id="FLOOR_AREA"
				name="hostInfo[0].FLOOR_AREA}" value="${house.FLOOR_AREA}"
				onkeyup="countHsTotalPrice('HS_SEARCH_UNIT_PRICE','HS_FLOOR_AREA','HS_SEARCH_TOTAL_PRICE')"
				maxlength="13" style="width: 100px; ime-mode: Disabled;"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" />平方米</td>
			<td>查询单价：</td>
			<td><input type="text" id="SEARCH_UNIT_PRICE"
				name="hostInfo[0].SEARCH_UNIT_PRICE"
				value="${house.SEARCH_UNIT_PRICE}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeyup="countHsTotalPrice('HS_SEARCH_UNIT_PRICE','HS_FLOOR_AREA','HS_SEARCH_TOTAL_PRICE')"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
		</tr>
		<tr>
			<td>按揭银行：</td>
			<td><input type="text" id="MORTGAGE_BANK"
				name="hostInfo[0].MORTGAGE_BANK"
				value="${house.MORTGAGE_BANK}" style="width: 100px;" /></td>
			<td>贷款年限：</td>
			<td><input type="text" id="LOAN_LIMIT_YEAR"
				name="hostInfo[0].LOAN_LIMIT_YEAR"
				value="${house.LOAN_LIMIT_YEAR}" maxlength="3"
				style="width: 100px; ime-mode: Disabled;"
				onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
			<td>查询总价：</td>
			<td><input type="text" id="SEARCH_TOTAL_PRICE"
				name="hostInfo[0].SEARCH_TOTAL_PRICE"
				value="${house.SEARCH_TOTAL_PRICE}" maxlength="22"
				style="width: 100px; ime-mode: Disabled;"
				onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
		</tr>
		<tr>
			<td>贷款总额：</td>
			<td><input type="text" id="LOAN_TOTAL_AMOUNT"
				name="hostInfo[0].LOAN_TOTAL_AMOUNT"
				value="${house.LOAN_TOTAL_AMOUNT}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
			<td>尚欠余额：</td>
			<td><input type="text" id="BALANCE_DUE"
				name="hostInfo[0].BALANCE_DUE" value="${house.BALANCE_DUE}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
			<td>每月供款：</td>
			<td><input type="text" id="MONTHLY_CONTRIBUTION"
				name="hostInfo[0].MONTHLY_CONTRIBUTION"
				value="${house.MONTHLY_CONTRIBUTION}"
				style="width: 100px; ime-mode: Disabled;" maxlength="13"
				onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
				onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
				ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
		</tr>
		<tr>
			<td>房产用途：</td>
			<td><select id="ESTATE_PURPOSES"
				name="hostInfo[0].ESTATE_PURPOSES">
					<option value="01">自住</option>
					<option value="02">自己办公</option>
					<option value="03">出租</option>
					<option value="04">空置</option>
			</select></td>
			<td>物业类型：</td>
			<td><select id="PROPERTY_TYPE" name="hostInfo[0].PROPERTY_TYPE">
					<option value="01">商铺</option>
					<option value="02">住宅</option>
					<option value="03">商住两用</option>
					<option value="04">厂房</option>

			</select></td>
			<td>房屋产权类型：</td>
			<td><select id="HOUSE_PROPERTY_TYPE"
				name="hostInfo[0].HOUSE_PROPERTY_TYPE">
					<option value="01">商品房</option>
					<option value="02">小产权</option>
					<option value="03">自建房</option>
					<option value="04">集资房</option>
					<option value="05">房改房</option>
					<option value="06">经济适用房</option>
			</select></td>
		</tr>
	</table>
</fieldset>
</div>
