<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<input type="hidden" id="RELATION_TO_LOANER_VAL"
	value="${linkMan.RELATION_TO_LOANER}" />
<input type="hidden" id="LINKMAN_SEX_VAL"
	value="${linkMan.LINKMAN_SEX}" />
<div id="divLinkData" class="divStyle">
	<input type="button" id="linkmanButton" value="添加联系人资料"
		onclick="addLinkmanData()" />
	<fieldset id="hs">
		<legend>联系人资料</legend>
		<table>
			<tr>
				<td><input type="button" id="clearHsButton" value="清除"
					onclick="ResetControl('HS_','');"></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" id="LINKMAN_NAME"
					name="linkManInfo[0].LINKMAN_NAME" style="width: 100px;"
					maxlength="40" value="${linkMan.LINKMAN_NAME}" /></td>
				<td>年龄：</td>
				<td><input type="text" id="LINKMAN_AGE"
					name="linkManInfo[0].LINKMAN_AGE"
					value="${linkMan.LINKMAN_AGE}" maxlength="3"
					style="width: 60px; ime-mode: Disabled;" maxlength="3"
					onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
					onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
					ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><span id="SPAN_LMSEX_"> <label for="LINKMAN_SEX"><input
							type="radio" id="LINKMAN_SEX" name="linkManInfo[0].LINKMAN_SEX"
							value="M" />男</label> <label for="LINKMAN_SEX"><input
							type="radio" id="LINKMAN_SEX" name="linkManInfo[0].LINKMAN_SEX"
							value="F" />女</label>
				</span></td>
				<td>关系：</td>
				<td><select id="RELATION_TO_LOANER"
					name="linkManInfo[0].RELATION_TO_LOANER">
						<option value="01">母女</option>
						<option value="02">朋友</option>
						<option value="03">父子</option>
						<option value="04">叔侄</option>
				</select></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>住宅详细地址：</td>
				<td colspan=6><textarea rows="2" cols="50"
						id="DWELL_ADDRESS_DETAIL"
						name="linkManInfo[0].DWELL_ADDRESS_DETAIL">${linkMan.DWELL_ADDRESS_DETAIL}</textarea>
				</td>
			</tr>
			<tr>
				<td>住宅电话：</td>
				<td><input type="text" id="DWELL_TEL_NUMBER"
					name="linkManInfo[0].DWELL_TEL_NUMBER"
					value="${linkMan.DWELL_TEL_NUMBER}" maxlength="15"
					style="width: 120px; ime-mode: Disabled;" /></td>
				<td>手机号码：</td>
				<td><input type="text" id="LINK_MAN_MOBILE_NUMBER"
					name="linkManInfo[0].LINK_MAN_MOBILE_NUMBER"
					value="${linkMan.LINK_MAN_MOBILE_NUMBER}" maxlength="15"
					style="ime-mode: Disabled;"
					onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
					onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
					ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
			</tr>
			<tr>
				<td>单位名称：</td>
				<td><input type="text" id="LINK_MAN_UNIT_NAME"
					name="linkManInfo[0].LINK_MAN_UNIT_NAME"
					value="${linkMan.LINK_MAN_UNIT_NAME}" style="width: 300px" /></td>
				<td>职位：</td>
				<td><input type="text" id="LINK_MAN_POSITION"
					name="linkManInfo[0].LINK_MAN_POSITION"
					value="${linkMan.LINK_MAN_POSITION}" /></td>
			</tr>
			<tr>
				<td>单位电话：</td>
				<td><input type="text" id="LINK_MAN_UINT_TEL_NUMBER"
					name="linkManInfo[0].LINK_MAN_UINT_TEL_NUMBER"
					value="${linkMan.LINK_MAN_UINT_TEL_NUMBER}"
					style="width: 140px; ime-mode: Disabled;"
					onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))"
					onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))"
					ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
			</tr>
		</table>
	</fieldset>
</div>
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
	$("input[type='radio']").each(function() {
		var obj = this.name;
		var arrs = $("input[name='" + obj + "'][type='radio']");
		var val = $("#" + obj.split(".")[1] + "_VAL").val();
		if ($("input[name='" + obj + "'][type='radio']:checked").length == 0) {
			arrs.each(function() {
				var v = $(this).val();
				if (val == v) {
					$(this).attr("checked", true);
				}
			});
		}
	});
</script>
