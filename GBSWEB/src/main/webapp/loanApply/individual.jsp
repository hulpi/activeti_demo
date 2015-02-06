<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<input type="hidden" id="SEX_VAL" value="${individual.SEX }" />
<input type="hidden" id="EDUCATION_LEVEL_VAL"
	value="${individual.EDUCATION_LEVEL }" />
<input type="hidden"  id="INDIVIDUAL_OID" name="GU_INDIVIDUAL_INFO_OID" value="${individual.GU_INDIVIDUAL_INFO_OID}"/>
<fieldset>
	<legend>贷款人资料</legend>
	<table>
		<tr>
			<td><font color="red">*</font>证件类型：</td>
			<td><select id="CERT_TYPE" name="CERT_TYPE">
					<option value="">中国身份证</option>
			</select></td>
			<td><font color="red">*</font>身份证号码：</td>
			<td><input type="text" id="CERT_NO" name="CERT_NO"
				maxlength="18" value="${individual.CERT_NO }"></td>
		</tr>
		<tr>
			<td><font color="red">*</font>姓名：</td>
			<td><input type="text" id="CUST_NAME" name="CUST_NAME"
				style="width: 100px;" maxlength="35" value="${individual.CUST_NAME }"></td>
			<td><font color="red">*</font>出生日期：</td>
			<td><input type="text" id="BIRTHDAY" name="BIRTHDAY"
				value="${individual.BIRTHDAY }" class="Wdate"
				onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
				readonly="readonly" style="width: 100px;" readonly="readonly" /></td>
		</tr>

		<tr>
			<td><font color="red">*</font>性别：</td>
			<td><select id="SEX" name="SEX">
					<option value="M">男</option>
					<option value="F">女</option>
			</select>
			<td><font color="red">*</font>教育程度：</td>
			<td><select id="EDUCATION_LEVEL" name="EDUCATION_LEVEL">
					<option value="I">初中</option>
					<option value="II">高中</option>
					<option value="III">本科</option>
					<option value="IIII">硕士</option>
					<option value="IIIII">博士</option>
			</select></td>
		<tr>
			<td><font color="red">*</font>籍贯：</td>
			<td><input type="text" id="NATIVE_PLACE" name="NATIVE_PLACE"
				value="${individual.NATIVE_PLACE }" style="width: 100px;" maxlength="35"></td>
			<td><font color="red">*</font>户口所在地：</td>
			<td><input type="text" name="HUKOU_ADD" value="${individual.HUKOU_ADD }">
			</td>
		</tr>
		<tr>
			<td><font color="red">*</font>身份证详细地址：</td>
			<td colspan=6><textarea rows="2" cols="50"
					id="ID_CARD_ADDRESS_DETAIL" name="ID_CARD_ADDRESS_DETAIL"
					onblur="">${individual.ID_CARD_ADDRESS_DETAIL}</textarea></td>
		</tr>
		<tr>
			<td><font color="red">*</font>身份证有效期有效期起：</td>
			<td><input type="text" id="ID_CARD_VALIDITY_FROM"
				name="ID_CARD_VALIDITY_FROM" value="${individual.ID_CARD_VALIDITY_FROM}"
				class="Wdate"
				onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
				readonly="readonly" style="width: 100px;" readonly="readonly" /></td>
			<td><font color="red">*</font>身份证有效期有效期止：</td>
			<td><input type="text" id="ID_CARD_VALIDITY_TO"
				name="ID_CARD_VALIDITY_TO" value="${individual.ID_CARD_VALIDITY_TO}"
				class="Wdate"
				onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy-MM-dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});"
				readonly="readonly" style="width: 100px;" readonly="readonly" /></td>
			<td><font color="red">*</font>身份证有效期</td>
			<td><input type="text" id="ID_CARD_VALIDITY_PERIOD"
				name="ID_CARD_VALIDITY_PERIOD" value="${individual.ID_CARD_VALIDITY_PERIOD}"></td>
		</tr>
		<tr>
			<td><font color="red">*</font>住宅详细地址：</td>
			<td colspan=6><textarea rows="2" cols="50" id="ADDRESS_DETAIL"
					name="ADDRESS_DETAIL" onblur="">${individual.ADDRESS_DETAIL }</textarea>
			</td>
		</tr>
		<tr>
	</table>
</fieldset>

<script type="text/javascript">
	$("select").each(function() {
		var obj = this.id;
		var val = $("#" + obj + "_VAL").val();
		$(this).children("option").each(function() {
			var v = $(this).val();
			if (val == v) {
				$(this).attr("selected", true);
			}
		});
	});
</script>
