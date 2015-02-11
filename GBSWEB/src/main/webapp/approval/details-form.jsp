<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class='view-info' id="infoTable">
    <caption>基本信息</caption>
			<tr>
				<td width="100" class="label">贷款产品:</td> <td name="productSel"></td>
				<td class="label">担保金额:</td> <td name="guarant_amt"></td>
			</tr>
				<td class="label">担保期限:</td> <td name="guarant_time_limit"></td>
				<td class="label">贷款用途:</td> <td name="loan_purpose"></td>
			    <input name="taskId" type="hidden" value="" />
			</tr>
	</br>
</table>

<div id="rule" >
    <div class="label">规则检查</div>
	<div class="rule-info" style="display: none">
	</div>

</div>