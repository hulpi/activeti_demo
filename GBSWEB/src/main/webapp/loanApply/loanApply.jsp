<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>贷款申请</title>
	<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=path%>/mainApply/script/input.js"></script>
	<script type="text/javascript" src="<%=path%>/mainApply/script/custManage.js"></script>
	<script type="text/javascript" src="<%=path%>/mainApply/script/verifyPage.js"></script>
	<script type="text/javascript" src="<%=path%>/js/parameter.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/entry.css">
	<script type="text/javascript">
	</script>
  </head>
  <body style="background:#d5e4f5">
    <form id="appForm" name="appForm">
    	<fieldset>
    		<legend>贷款人资料</legend>
    		<table>
    		<tr>
    		<td><font color="red">*</font>证件类型：</td>
    		<td><select id="GR_CERT_TYPE" name="GR_CERT_TYPE" >
    		    	<option value="">--请选择--</option>
    		    	 <option value="">中国身份证</option>
    		    </select>
    		 </td>
    		<td><font color="red">*</font>身份证号码：</td>
    		<td><input type="text" id="GR_CERT_NO" name="GR_CERT_NO"  maxlength="18"></td>
    		</tr>
    		<tr>
    		<td><font color="red">*</font>姓：</td>
    		<td><input type="text"  id="GR_SURNAME" name="GR_SURNAME" value="" style="width: 100px;" maxlength="35"></td>
    		<td><font color="red">*</font>名：</td>
    		<td><input type="text"  id="GR_GIVENNAME" name="GR_GIVENNAME" value="" style="width: 100px;" maxlength="70"></td>
    		</tr>
    		 <tr>
    			<td>曾用名：</td>
    		    <td><input type="text" id="GR_USED_NAME" name="GR_USED_NAME" value="${gr_.USED_NAME}" style="width: 100px;" maxlength="20"/></td>
    		    <td><font color="red">*</font>出生日期：</td>
    		    <td><input type="text"  id="GR_BIRTHDAY" name="GR_BIRTHDAY"' type='date' pattern="yyyy/MM/dd"/>" style="width: 100px;"
    		    class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" readonly="readonly" /></td>
				<td><font color="red">*</font>年龄：</td>
    		    <td><input type="text"  name="GR_AGE" id="GR_AGE" onblur="checknull(this)" readonly="readonly" style="background-color: #E6E6E6;width: 50px"  /></td>
    		</tr>
    		<tr>
    			<td colspan="2" nowrap="nowrap" ><font color="red">*</font>户口所在地：省
    			<select name="GR_RPR_PROVINCE" id="GR_RPR_PROVINCE"> 
    				<option value="">--请选择--</option>
    			</select>
    			<font color="red">*</font>市
    		    <select name="GR_RPR_CITY" id="GR_RPR_CITY">
				
    		    </select>
    		    </td>
    		    <td><font color="red">*</font>籍贯：</td>
    		    <td><input type="text" name="GR_NATIVE_PLACE" id="GR_NATIVE_PLACE"  style="width: 100px;" ></td>
				<td><font color="red">*</font>性别：</td>
    		    <td>
				<span id="SPAN_SEX"> 
					<input type="radio" id="SQR_MAN" name="GR_SEX" value="M" />男 
    		    	<input type="radio" id="SQR_WOMAN" name="GR_SEX" value="F"/>女
				</span>
				</td>
    		</tr>
    		<tr>
				<td><font color="red">*</font>婚姻状况：</td>
				<td>
					<select id="GR_MARITAL_STATUS" name="GR_MARITAL_STATUS">
						<option value="">--请选择--</option>
				</select>
				</td>
				<td><font color="red">*</font>教育程度：</td>
				<td><select id="GR_EDUCATION_LEVEL" name="GR_EDUCATION_LEVEL" onblur="checknull2(this)" >
						<option value="">--请选择--</option>
					</select>
				</td>	
				</tr>		
					<tr>
						<td>社会保险卡电脑号：</td>
						<td><input type="text" id="GR_SOCIAL_SECURITY_COMPUTER" name="GR_SOCIAL_SECURITY_COMPUTER"/></td>
						<td>劳动保障卡号：</td>
						<td><input type="text" id="GR_LABOR_ENSURE_CARD" name="GR_LABOR_ENSURE_CARD"/></td>
						<!-- <td>当前社保供款记录：</td>
						<td>
						<input type="radio" id="GR_YESSOCIAL" name="GR_IS_OWN_SOCIAL_SECURITY" value="Y" <c:if test="${gr_.IS_OWN_SOCIAL_SECURITY eq 'Y'}">checked</c:if>/>有
						<input type="radio" id="GR_NOSOCIAL" name="GR_IS_OWN_SOCIAL_SECURITY" value="N" <c:if test="${gr_.IS_OWN_SOCIAL_SECURITY eq 'N'}">checked</c:if>/>无
						</td>-->
						</tr>
						<tr>
						<td>所在地居住证：</td>
						<td>
						<input type="radio" id="GR_RESIDENCE_PERMIT_NO" name="GR_RESIDENCE_PERMIT_NO" value="Y" >有
						<input type="radio" id="GR_RESIDENCE_PERMIT_NO" name="GR_RESIDENCE_PERMIT_NO" value="N">无
						</td>
						<td>已被更换身份证号码:</td>
						<td><input type="text" readonly="readonly" style="background-color: #E6E6E6;"></td>
						
						</tr>
						<tr>
						<td>手机号码：</td>
						<td><input type="text" id="GR_MOBILE" name="GR_MOBILE" style="ime-mode:Disabled;" maxlength="15" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>		
						<td>其他电话：</td>
						<td>
						<input type="text" id="GR_OTHER_TEL_AREA" name="GR_OTHER_TEL_AREA"  value="" maxlength="5" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
						<input type="text" id="GR_OTHER_TEL_NUMBER" name="GR_OTHER_TEL_NUMBER"  maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>
						</td>
						
						</tr>
						<tr>
						<td><font color="red">*</font>身份证有效期限起：</td>
						<td nowrap="nowrap"><input type="text" id="GR_ID_CARD_VALIDITY_FROM" name="GR_ID_CARD_VALIDITY_FROM"  type='date' pattern="yyyy/MM/dd"/>" style="width: 100px;" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',maxDate:'%y-%M-%d'})" readonly="readonly" onblur="checknull(this);countIDCard('GR_ID_CARD_VALIDITY_FROM','GR_ID_CARD_VALIDITY_TO','GR_ID_CARD_VALIDITY_PERIOD');" />至
						<input type="text" id="GR_ID_CARD_VALIDITY_TO" name="GR_ID_CARD_VALIDITY_TO" value="<fmt:formatDate value='${gr_.ID_CARD_VALIDITY_TO}' type='date' pattern="yyyy/MM/dd"/>" style="width: 100px;" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'%y-%M-%d'})" onblur="checknull(this);countIDCard('GR_ID_CARD_VALIDITY_FROM','GR_ID_CARD_VALIDITY_TO','GR_ID_CARD_VALIDITY_PERIOD');"  /></td>
						<td><font color="red">*</font>身份证有效期：</td>
						<td><input type="text" id="GR_ID_CARD_VALIDITY_PERIOD" name="GR_ID_CARD_VALIDITY_PERIOD" readonly="readonly"  value="${gr_.ID_CARD_VALIDITY_PERIOD}" maxlength="3" style="background-color: #E6E6E6;width: 90px;"  onblur="checknull(this);" />年</td>
						</tr>
						<tr>
						<td><font color="red">*</font>中国身份证上的地址：</td>
						<td colspan="3" nowrap="nowrap" ><font color="red">*</font>省：
    						<select id="GR_ID_CARD_ADDRESS_PROVINCE" name="GR_ID_CARD_ADDRESS_PROVINCE" onblur="checknull2(this)"
    						onchange="getPCA(this.id,'2','GR_ID_CARD_ADDRESS_CITY','GR_ID_CARD_ADDRESS_AREA','GR_ID_CARD_ADDRESS_DETAIL',this.id);" > 
    		    			<option value="">--请选择--</option>
    		    		
							<option value=""> 
						
							</option>
						
    		    			</select>
    		 			<font color="red">*</font>市：
    		    		<select id="GR_ID_CARD_ADDRESS_CITY" name="GR_ID_CARD_ADDRESS_CITY" onblur="checknull2(this)" > 
						
    		    		</select>
    		    		<font color="red">*</font>区：
    		    		<select id="GR_ID_CARD_ADDRESS_AREA" name="GR_ID_CARD_ADDRESS_AREA" onblur="checknull2(this)" onchange="setAddressArea(this.id,'GR_ID_CARD_ADDRESS_DETAIL','GR_ID_CARD_ADDRESS_PROVINCE','GR_ID_CARD_ADDRESS_CITY');" >
					
					
							<option value="" title="">--请选择--</option>
					
    		    		</select>
    		    	</td>
					</tr>
					<tr>
						<td></td>
						<td colspan=6>
						<textarea rows="2" cols="50" id="GR_ID_CARD_ADDRESS_DETAIL" name="GR_ID_CARD_ADDRESS_DETAIL" onblur="checknull(this);" >${gr_.ID_CARD_ADDRESS_DETAIL}</textarea>
						</td>
					</tr>
					<tr>
						<td>电邮地址：</td>
    					<td><input type="text" id="GR_EMAIL" name="GR_EMAIL"/></td>
    				</tr>
    				</table>    	
    	</fieldset>
    	<!-- 判断某个人下面拥有住宅，房产，商业，联系人 个数-->
	  	<c:forEach items="${customerid_num}" var="afi">
			<c:if test="${afi.key eq 'RE_Num'}">
				<c:forEach items="${afi.value}" var="afi2">
				<c:if test="${onlyid eq afi2.key}">
				<c:choose>
				<c:when test="${onlyid eq afi2.key}">
				<input type="hidden" value="${afi2.value}" id="sqrre" name="sqrre"/>
				</c:when>
				<c:otherwise>
				<input type="hidden" value="${afi2.value}" id="sqrre_2" name="sqrre_2"/>
				</c:otherwise>
				</c:choose>
				</c:if>
  				</c:forEach>
			</c:if>
		</c:forEach>
    	<c:forEach items="${customerid_num}" var="afi">
			<c:if test="${afi.key eq 'HS_Num'}">
				<c:forEach items="${afi.value}" var="afi2">
				<c:if test="${onlyid eq afi2.key}">
				<c:choose>
				<c:when test="${onlyid eq afi2.key}">
				<input type="hidden" value="${afi2.value}" id="sqrhs" name="sqrhs"/>
				</c:when>
				<c:otherwise>
				<input type="hidden" value="${afi2.value}" id="sqrhs_2" name="sqrhs_2"/>
				</c:otherwise>
				</c:choose>
				</c:if>
  				</c:forEach>
			</c:if>
		</c:forEach>
		<c:forEach items="${customerid_num}" var="afi">
			<c:if test="${afi.key eq 'BS_Num'}">
				<c:forEach items="${afi.value}" var="afi2">
				<c:if test="${onlyid eq afi2.key}">
				<c:choose>
				<c:when test="${onlyid eq afi2.key}">
				<input type="hidden" value="${afi2.value}" id="sqrbs" name="sqrbs"/>
				</c:when>
				<c:otherwise>
				<input type="hidden" value="${afi2.value}" id="sqrbs_2" name="sqrbs_2"/>
				</c:otherwise>
				</c:choose>
				</c:if>
  				</c:forEach>
			</c:if>
		</c:forEach>
		<c:forEach items="${customerid_num}" var="afi">
			<c:if test="${afi.key eq 'LM_Num'}">
				<c:forEach items="${afi.value}" var="afi2">
				<c:if test="${onlyid eq afi2.key}">
				<c:choose>
				<c:when test="${onlyid eq afi2.key}">
				<input type="hidden" value="${afi2.value}" id="sqrlm" name="sqrlm"/>
				</c:when>
				<c:otherwise>
				<input type="hidden" value="${afi2.value}" id="sqrlm_2" name="sqrlm_2"/>
				</c:otherwise>
				</c:choose>
				</c:if>
  				</c:forEach>
			</c:if>
		</c:forEach>
		
		
    	
    	<!-- 住宅资料 -->
		<div id="divResidence" class="divStyle">
		<table>
    	<input type="button" id="residenceButton" value="添加住宅资料" />
	  			<fieldset>
	    		<legend>住宅资料</legend>
	    		<table  border="0" align="left" id="mtable" height="100%">
    				<tr>
    				<td>
    				<input type="button" id="clearReButton" value="清除"/>
    				</td>
    				<input type="button"  value="删除住宅资料">
    				</tr>
    				<input type="hidden" id="RE_APPLY_CODE" name="RE_APPLY_CODE"/>
    				<input type="hidden" id="RE_CUSTOMER_ID" name="RE_CUSTOMER_ID"/>
    				<input type="hidden" id="RE_ONLY_ID" name="RE_ONLY_ID"  value="" />
    				<input type="hidden" id="RE_DWELL_ID" name="RE_DWELL_ID" >
    				<tr>
    				<td><font color="red">*</font>住宅地址：</td>
    				<td colspan="3" nowrap="nowrap" ><font color="red">*</font>省：
    					<select id="RE_ADDRESS_PROVINCE" name="RE_ADDRESS_PROVINCE"  / >
    		    			<option value="">--请选择--</option>
 
    		    			</select>
    		 			<font color="red">*</font>市：
    		    		<select id="RE_ADDRESS_CITY" name="RE_ADDRESS_CITY" onchange="getPCA(this.id,'3','RE_ADDRESS_AREA','RE_ADDRESS_AREA','RE_ADDRESS_DETAIL','RE_ADDRESS_PROVINCE');" onblur="checknull2(this)" >
    		    		<c:if test='${re_.ADDRESS_CITY ne null}'>
						<c:forEach items="${G_PA_CITY_TMP}" var="pa_city_tmp">
						<c:if test='${pa_city_tmp.key eq re_.ADDRESS_PROVINCE}'>
							<c:forEach items="${pa_city_tmp.value}" var="pa_city_tmp2">
								<option value="${pa_city_tmp2.PACODE}"  <c:if test="${pa_city_tmp2.PACODE eq re_.ADDRESS_CITY}">selected</c:if>>${pa_city_tmp2.PACODE}┋${pa_city_tmp2.PAVALUE}</option>
							</c:forEach>
						</c:if>
						</c:forEach>
						</c:if>
						<c:if test='${re.ADDRESS_CITY eq null}'>
						<option value="" title="">--请选择--</option>
						</c:if>
    		    		</select>
    		    		<font color="red">*</font>区：
    		    		<select id="RE_ADDRESS_AREA" name="RE_ADDRESS_AREA" onblur="checknull2(this)" onchange="setAddressArea(this.id,'RE_ADDRESS_DETAIL','RE_ADDRESS_PROVINCE','RE_ADDRESS_CITY');getPostCode('RE_ADDRESS_CITY',this,'RE_POST_CODE');" >
    		    			<c:if test='${re_.ADDRESS_AREA ne null}'>
						<c:forEach items="${G_PA_AREA_TMP}" var="pa_city_tmp">
							<c:if test='${pa_city_tmp.key eq re_.ADDRESS_CITY}'>
							<c:forEach items="${pa_city_tmp.value}" var="pa_city_tmp2">
								<option value="${pa_city_tmp2.PACODE}" <c:if test="${pa_city_tmp2.PACODE eq re_.ADDRESS_AREA}">selected</c:if>>${pa_city_tmp2.PACODE}┋${pa_city_tmp2.PAVALUE}</option>
							</c:forEach>
							</c:if>
						</c:forEach>
						</c:if>
						<c:if test='${re.ADDRESS_AREA eq null}'>
						<option value="">--请选择--</option>
						</c:if>
    		    		</select>
    		    	</td>
    			</tr>
				<tr>
					<td></td>
					<td colspan=3>
						<textarea rows="2" cols="50" id="RE_ADDRESS_DETAIL" name="RE_ADDRESS_DETAIL"></textarea>
					</td>
					<td nowrap="nowrap"><font color="red">*</font>邮政编码：
    				<input type="text" id="RE_POST_CODE" name="RE_POST_CODE"  maxlength="6" style="width: 100px;ime-mode:Disabled;background-color: #E6E6E6;"  readonly="readonly" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"  onblur="checknull(this);" <c:if test="${v.count eq '1'}">onblur="checknull(this)"</c:if> /></td>
				</tr>
    			<tr>
    				<td><font color="red">*</font>起始居住时间：</td>
    				<td><input type="text" id="RE_DWELL_TIME_FROM" name="RE_DWELL_TIME_FROM"  value="<fmt:formatDate value='${re_.DWELL_TIME_FROM}' type='date' pattern="yyyy/MM/dd"/>"style="width: 100px;" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" readonly="readonly" /></td>
    				<td><font color="red">*</font>居住年限：</td>
    				<td><input type="text" id="RE_DWELL_TIME_LIMIT" name="RE_DWELL_TIME_LIMIT" readonly="readonly" maxlength="3" style="background-color: #E6E6E6;width: 60px;" onblur="checknull(this)" /></td>
					<td>住宅电话：
						<input type="text" id="RE_TEL_AREA" name="RE_TEL_AREA" value="${re_.TEL_AREA}" maxlength="5" style="width:60px;ime-mode:Disabled;"  />-
    					<input type="text" id="RE_TEL_NUMBER" name="RE_TEL_NUMBER" value="${re_.TEL_NUMBER}" maxlength="15" style="width: 90px;ime-mode:Disabled;" /></td>
    			</tr>
    			<tr>
    				<td><font color="red">*</font>住宅类别：</td>
    				<td><select  id="RE_DWELLING_TYPE" name="RE_DWELLING_TYPE"  <c:if test="${v.count eq '1'}">onblur="checknull2(this)"</c:if> >
						<option value="">--请选择--</option>
						<c:forEach var="entry" items="${G_PA_RESIDENTIAL_PROPERTY}">
		          				<option value="${entry.key}"  <c:if test='${entry.key eq re_.DWELLING_TYPE}'>selected</c:if> >
		          				${entry.key}┋${entry.value}
			         			 </option>
          					</c:forEach>	
    		    		</select>
    		    	</td>
    				<td><font color="red">*</font>按揭供款/租金￥：</td>
    				<td><input type="text" id="RE_CONT_OR_RENT_AMOUNT" name="RE_CONT_OR_RENT_AMOUNT" value="${re_.CONT_OR_RENT_AMOUNT}" onblur="checknull(this);" maxlength="11" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"  onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>业主：</td>
    				<td><input type="text" id="RE_OWNER" name="RE_OWNER" value="${re_.OWNER}" style="width: 100px;"  /></td>
    				<td>关系：</td>
    				<td><input type="text"  id="RE_RELATION_TO_OWNER" name="RE_RELATION_TO_OWNER" style="width: 100px;" value="${re_.RELATION_TO_OWNER}" /></td>
    			</tr>
    			<tr>
					<td><font color="red">*</font>与谁居住：</td>
    				<td>
    				<!-- 处理与谁居住开始 -->
    				<input type="hidden" id="RE_DWELL_WITH_WHO" name="RE_DWELL_WITH_WHO" value="${re_.DWELL_WITH_WHO}"/>
					<span id="SPAN_DWELL_WITH_WHO"> 
				        	<input type="checkbox" id="RE_LIVEALONE" name="RE_LIVEALONE" value="Y" <c:if test="${dwell_with_who eq 'Y'}">checked</c:if>  onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>独居
				        	<input type='hidden' value='' />
				      		<input type="checkbox" id="RE_LIVEALONE" name="RE_LIVEALONE" value="N"  onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>独居
				 
				        	<input type="checkbox" id="RE_LIVEPARENT" name="RE_LIVEALONE" value="Y" <c:if test="${dwell_with_who eq 'Y'}">checked</c:if> onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>父母
				        	<input type='hidden' />

				      		<input type="checkbox" id="RE_LIVEPARENT" name="RE_LIVEALONE" value="N"  onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>父母
				     
				        	<input type="checkbox" id="RE_LIVEBROTHER" name="RE_LIVEALONE" value="Y" <c:if test="${dwell_with_who eq 'Y'}">checked</c:if> onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>兄弟/姐妹
				        	<input type='hidden' />
				    
				
				      		<input type="checkbox" id="RE_LIVEBROTHER" name="RE_LIVEALONE" value="N" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>兄弟/姐妹
				
		
		
				        	<input type="checkbox" id="RE_LIVESPOUSE" name="RE_LIVEALONE" value="Y" <c:if test="${dwell_with_who eq 'Y'}">checked</c:if> onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>配偶
				        	<input type='hidden' />
				    
					
				      		<input type="checkbox" id="RE_LIVESPOUSE" name="RE_LIVEALONE" value="N" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>配偶
				
							        	<input type="checkbox" id="RE_LIVECHILDREN" name="RE_LIVEALONE" value="Y" <c:if test="${dwell_with_who eq 'Y'}">checked</c:if> onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO')"/>子女
				        	<input type='hidden' value='' />
				   
				      		<input type="checkbox" id="RE_LIVECHILDREN" name="RE_LIVEALONE" value="N"  onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>子女
				   
				        	<input type="checkbox" id="RE_LIVEWORK" name="RE_LIVEALONE" value="Y" <c:if test="${dwell_with_who eq 'Y'}">checked</c:if> onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>同事
				        	<input type='hidden' />
				      
				  				      		<input type="checkbox" id="RE_LIVEWORK" name="RE_LIVEALONE" value="N"  onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO');"/>同事
				
					</span>
					<!-- 处理与谁居住结束 -->
					</td>
    				<td>其他：</td>
    				<td><input type="text" id="RE_OTHER" name="RE_OTHER" style="width: 100px;" /></td>
    				<td><font color="red">*</font>总人数：<input type="text" id="RE_DWELL_NUMBER" name="RE_DWELL_NUMBER" value="${re_.DWELL_NUMBER}" maxlength="2" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"  onblur="checknull(this);" /></td>
    			</tr>
    		</table>
    	</fieldset>

	  		<fieldset id="re1">
	    	<legend>住宅资料</legend>
	    	<input type="hidden" id="RE_DWELL_ID_1" name="RE_DWELL_ID_1" value="1">
	    	<input type="hidden" id="RE_CUSTOMER_ID_1" name="RE_CUSTOMER_ID_1" >
	    	<input type="hidden" id="RE_ONLY_ID_1" name="RE_ONLY_ID_1">
	    	<table  border="0" align="left" id="mtable" height="100%">
    			<tr>
    			<td>
    			<input type="button" id="clearReButton1" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('RE_','1');" >
    			</td>
    			</tr>
    		<tr>
    			<td><font color="red">*</font>住宅地址：</td>
    			<td colspan="3" nowrap="nowrap" ><font color="red">*</font>省
    					<select id="RE_ADDRESS_PROVINCE_1" name="RE_ADDRESS_PROVINCE_1" onchange="getPCA(this.id,'2','RE_ADDRESS_CITY_1','RE_ADDRESS_AREA_1','RE_ADDRESS_DETAIL_1',this.id);" onblur="checknull2(this);" > 
    		    			<option value="">--请选择--</option>
    		    			<c:forEach var="entry" items="${mapProvince}">
							<option value="${entry.pacode}" > 
							${entry.pacode}┋${entry.pavalue}
						</option>
						</c:forEach>	
    		    		</select>
    		 		<font color="red">*</font>市
    		    	<select id="RE_ADDRESS_CITY_1" name="RE_ADDRESS_CITY_1" onchange="getPCA(this.id,'3','RE_ADDRESS_AREA_1','RE_ADDRESS_AREA_1','RE_ADDRESS_DETAIL_1','RE_ADDRESS_PROVINCE_1');" onblur="checknull2(this);" >
    		    		<option value="">--请选择--</option>	
    		    	</select>
    		    	<font color="red">*</font>区
    		    	<select id="RE_ADDRESS_AREA_1" name="RE_ADDRESS_AREA_1" onblur="checknull2(this);" onchange="setAddressArea(this.id,'RE_ADDRESS_DETAIL_1','RE_ADDRESS_PROVINCE_1','RE_ADDRESS_CITY_1');getPostCode('RE_ADDRESS_CITY_1',this,'RE_POST_CODE_1');" >
    		    		<option value="">--请选择--</option>	
    		    	</select>
    		    </td>
    		    	
    		</tr>
			<tr>
				<td></td>
				<td colspan=3>
					<textarea rows="2" cols="50" id="RE_ADDRESS_DETAIL_1" name="RE_ADDRESS_DETAIL_1" onblur="checknull(this);" ></textarea>
				</td>
				<td><font color="red">*</font>邮政编码：</td>
    			<td><input type="text" id="RE_POST_CODE_1" name="RE_POST_CODE_1"   maxlength="6" style="width: 100px;ime-mode:Disabled;background-color: #E6E6E6;" readonly="readonly"  onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" onblur="checknull(this);" /></td>
			</tr>
    		<tr>
    			
    			<td><font color="red">*</font>起始居住时间：</td>
    			<td><input type="text" id="RE_DWELL_TIME_FROM_1" name="RE_DWELL_TIME_FROM_1" style="width: 100px;" onblur="checknull(this);countmyHsYear(this.id,'RE_DWELL_TIME_LIMIT_1');" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" readonly="readonly" /></td>
    			<td><font color="red">*</font>居住年限：</td>
    			<td><input type="text" id="RE_DWELL_TIME_LIMIT_1" name="RE_DWELL_TIME_LIMIT_1"  maxlength="3" readonly="readonly" style="background-color: #E6E6E6;width: 60px;"  onblur="checknull(this)" /></td>
				<td>住宅电话：</td>
    			<td><input type="text" id="RE_TEL_AREA_1" name="RE_TEL_AREA_1"  maxlength="5" style="width:60px;ime-mode:Disabled;" />-
    			<input type="text" id="RE_TEL_NUMBER_1" name="RE_TEL_NUMBER_1"  maxlength="15" style="width: 120px;ime-mode:Disabled;" /></td>
    		</tr>
    		<tr>
    			<td><font color="red">*</font>住宅类别：</td>
    			<td><select  id="RE_DWELLING_TYPE_1" name="RE_DWELLING_TYPE_1" onblur="checknull2(this);" >
						<option value="">--请选择--</option>	
						<c:forEach items="${G_PA_RESIDENTIAL_PROPERTY}" var="entry">
    		    				<option value="${entry.key}">
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    	</select>
    		    </td>
    			<td><font color="red">*</font>按揭供款/租金￥：</td>
    			<td><input type="text" id="RE_CONT_OR_RENT_AMOUNT_1" name="RE_CONT_OR_RENT_AMOUNT_1"  maxlength="11" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" onblur="checknull(this);" /></td>
    		</tr>
    		<tr>
    			<td>业主：</td>
    			<td><input type="text"  id="RE_OWNER_1" name="RE_OWNER_1" style="width: 100px;" /></td>
    			<td>关系：</td>
    			<td><input type="text"  id="RE_RELATION_TO_OWNER_1" name="RE_RELATION_TO_OWNER_1" style="width: 100px;" /></td>
    			</tr>
    			<tr>
				<td><font color="red">*</font>与谁居住：</td>
    			<td>
				<input type="hidden" id="RE_DWELL_WITH_WHO_1" name="RE_DWELL_WITH_WHO_1" />
					<span id="SPAN_DWELL_WITH_WHO_1"> 
					<input type="checkbox" id="RE_LIVEALONE_1" name="RE_LIVEALONE_1" value="0" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO_1');" />独居
					<input type="checkbox" id="RE_LIVEPARENT_1" name="RE_LIVEALONE_1" value="1" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO_1');" />父母
					<input type="checkbox" id="RE_LIVEBROTHER_1" name="RE_LIVEALONE_1" value="2" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO_1');" />兄弟/姐妹
					<input type="checkbox" id="RE_LIVESPOUSE_1" name="RE_LIVEALONE_1" value="3" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO_1');" />配偶
					<input type="checkbox" id="RE_LIVECHILDREN_1" name="RE_LIVEALONE_1" value="4" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO_1');" />子女
					<input type="checkbox" id="RE_LIVEWORK_1" name="RE_LIVEALONE_1" value="5" onclick="dWELL_WITH_WHO(this.name,'RE_DWELL_WITH_WHO_1');" />同事
				</span>	
				</td>	
    				<td>其他：</td>
    				<td><input type="text" id="RE_OTHER_1" name="RE_OTHER_1" style="width: 100px;"  /></td>
    				<td><font color="red">*</font>总人数：</td>
    				<td><input type="text" id="RE_DWELL_NUMBER_1" name="RE_DWELL_NUMBER_1"  maxlength="2" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" onblur="checknull(this)" /></td>
    			</tr>
    	</table>
    	</fieldset>
   	 	</div>		
	  	
	  	<!--房产资料-->
	  	<div id="divHouse" class="divStyle">
	  	<table>
    	<input type="button" id="houseButton" value="添加房产资料" />
    	</table>
	  	  	
    		<fieldset id="hs">
    		<legend>房产资料</legend>
    		<input type="hidden" id="HS_CUSTOMER_ID" name="HS_CUSTOMER_ID"  value="" />
    		<input type="hidden" id="HS_ONLY_ID" name="HS_ONLY_ID"  value="" />
    		<input type="hidden" id="HS_APPLY_CODE" name="HS_APPLY_CODE"  value="" />
    		<input type="hidden" id="HS_HOUSE_ID" name="HS_HOUSE_ID"}"/>
    		<table  border="0" align="left" id="mtable" height="100%">
    			<tr>
    				<td>
    				<input type="button" id="clearHsButton" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('HS_','');">
    				</td>
 
    				<input type="button"  id="" value="删除房产资料"/>
    				</td>
    		
    			</tr>
    			<tr>
    				<td>房产地址：</td>
    				<td colspan="3" >省：
    						<select id="HS_ADDRESS_PROVINCE" name="HS_ADDRESS_PROVINCE"
    						onchange="getPCA(this.id,'2','HS_ADDRESS_CITY','HS_ADDRESS_AREA','HS_ADDRESS_DETAIL',this.id);" >
    		    			<option value="">--请选择--</option>

						</option>
				
    		    			</select>
    		 			市：
    		    		<select id="HS_ADDRESS_CITY" name="HS_ADDRESS_CITY" >
    		   
						<option value="">--请选择--</option>
				
    		    		</select>
    		    		区：
    		    		<select id="HS_ADDRESS_AREA" name="HS_ADDRESS_AREA"  >
    		    			
						<option value="">--请选择--</option>
    		    		</select>
    		    	</td>
    			</tr>
				<tr>
					<td></td>	
					<td colspan=6>
						<textarea rows="2" cols="50" id="HS_ADDRESS_DETAIL" name="HS_ADDRESS_DETAIL" ></textarea>
					</td>
				</tr>
    			<tr>
    				<td></td>
    				<td></td>
    				<td>购买方式：</td>
    				<td>
						<select id="HS_BUY_PARTERN" name="HS_BUY_PARTERN" >
						<option value="">--请选择--</option>	
					
    		    		</select>
					</td>
					<td>房地产证号：</td>
    				<td><input type="text" id="HS_ESTATE_CERTIFICATE_NO" name="HS_ESTATE_CERTIFICATE_NO" value="" style="width: 100px;" /></td>
    			</tr>
				<tr>
					<td></td>
    				<td></td>
					<td>购买日期：</td>
    				<td><input type="text" id="HS_BUY_TIME" name="HS_BUY_TIME" value="<fmt:formatDate value='${hs_.BUY_TIME}' type='date' pattern="yyyy/MM/dd"/>" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" readonly="readonly" style="width: 100px;" readonly="readonly" /></td>
					<td>房产查询资料：</td>
    		    	<td><input type="radio" id="HS_YESSEARCHED" name="HS_IS_SEARCHED" value="Y" <c:if test="${hs_.IS_SEARCHED eq 'Y'}">checked</c:if> onclick="hsSelectData(this.name,'HS_SEARCH_DATE','HS_SEARCH_UNIT_PRICE','HS_SEARCH_TOTAL_PRICE');" />有
    		    		<input type="radio" id="HS_NOSEARCHED" name="HS_IS_SEARCHED" value="N" <c:if test="${hs_.IS_SEARCHED eq 'N'}">checked</c:if> onclick="hsSelectData(this.name,'HS_SEARCH_DATE','HS_SEARCH_UNIT_PRICE','HS_SEARCH_TOTAL_PRICE');" />无
    		    	</td>
				</tr>
    			<tr>
    				<td></td>
    				<td></td>
    				<td>购买价格：</td>
    				<td><input type="text" id="HS_BUY_PRICE" name="HS_BUY_PRICE" value="${hs_.BUY_PRICE}" style="width: 100px;ime-mode:Disabled;"   maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>查询日期：</td>
    				<td><input type="text" id="HS_SEARCH_DATE" name="HS_SEARCH_DATE"  <c:if test="${hs_.IS_SEARCHED eq 'N'}">disabled="disabled"</c:if> value="<fmt:formatDate value='${hs_.SEARCH_DATE}' type='date' pattern="yyyy/MM/dd"/>" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" readonly="readonly" style="width: 100px;" /></td>
    			</tr>
    			<tr>
    				<td>建筑年份：</td>
    				<td><input type="text" id="HS_BUILT_YEAR" name="HS_BUILT_YEAR" value="${hs_.BUILT_YEAR}"  maxlength="4" style="width: 100px;ime-mode:Disabled;"  maxlength="4" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>建筑面积：</td>
    				<td><input type="text" id="HS_FLOOR_AREA" name="HS_FLOOR_AREA" value="${hs_.FLOOR_AREA}" onkeyup="countHsTotalPrice('HS_SEARCH_UNIT_PRICE','HS_FLOOR_AREA','HS_SEARCH_TOTAL_PRICE')"   maxlength="13" style="width:100px;ime-mode:Disabled;"   onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" 
					onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" />平方米</td>
    				<td>查询单价：</td>
    				<td><input type="text" id="HS_SEARCH_UNIT_PRICE" name="HS_SEARCH_UNIT_PRICE" value="${hs_.SEARCH_UNIT_PRICE}" <c:if test="${hs_.IS_SEARCHED eq 'N'}">disabled="disabled"</c:if> style="width: 100px;ime-mode:Disabled;"  maxlength="13" onkeyup="countHsTotalPrice('HS_SEARCH_UNIT_PRICE','HS_FLOOR_AREA','HS_SEARCH_TOTAL_PRICE')"  onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" 
					onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>按揭银行：</td>
    				<td><input type="text" id="HS_MORTGAGE_BANK" name="HS_MORTGAGE_BANK" value="${hs_.MORTGAGE_BANK}" style="width: 100px;" /></td>
    				<td>贷款年限：</td>
    				<td><input type="text" id="HS_LOAN_LIMIT_YEAR" name="HS_LOAN_LIMIT_YEAR" value="${hs_.LOAN_LIMIT_YEAR}"  maxlength="3" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>查询总价：</td>
    				<td><input type="text" id="HS_SEARCH_TOTAL_PRICE" name="HS_SEARCH_TOTAL_PRICE" value="${hs_.SEARCH_TOTAL_PRICE}" <c:if test="${hs_.IS_SEARCHED eq 'N'}">disabled="disabled"</c:if>   maxlength="22" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>贷款总额：</td>
    				<td><input type="text" id="HS_LOAN_TOTAL_AMOUNT" name="HS_LOAN_TOTAL_AMOUNT" value="${hs_.LOAN_TOTAL_AMOUNT}" style="width: 100px;ime-mode:Disabled;"  maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))"/></td>
    				<td>尚欠余额：</td>
    				<td><input type="text" id="HS_BALANCE_DUE" name="HS_BALANCE_DUE" value="${hs_.BALANCE_DUE}" style="width: 100px;ime-mode:Disabled;"   maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>每月供款：</td>
    				<td><input type="text" id="HS_MONTHLY_CONTRIBUTION" name="HS_MONTHLY_CONTRIBUTION" value="${hs_.MONTHLY_CONTRIBUTION}" style="width: 100px;ime-mode:Disabled;" maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>房产用途：</td>
    				<td><select id="HS_ESTATE_PURPOSES" name="HS_ESTATE_PURPOSES" >
						<option value="">--请选择--</option>	
						<c:forEach var="entry" items="${G_PA_HOUSE_USAGEPROPERTY}">
		          				<option value="${entry.key}"  <c:if test='${entry.key eq hs_.ESTATE_PURPOSES}'>selected</c:if> >
		          				${entry.key}┋${entry.value}
			         			 </option>
          					</c:forEach>
    		    		</select>
    		    	</td>
    				<td>物业类型：</td>
    				<td><select id="HS_PROPERTY_TYPE" name="HS_PROPERTY_TYPE" >
						<option value="">--请选择--</option>	
						<c:forEach var="entry" items="${G_PA_HOUSE_PROPERTYTYPE}">
		          				<option value="${entry.key}"  <c:if test='${entry.key eq hs_.PROPERTY_TYPE}'>selected</c:if> >
		          				${entry.key}┋${entry.value}
			         			 </option>
          					</c:forEach>
    		    		</select>
    		    	</td>
    		    	<td>房屋产权类型：</td>
    				<td><select id="HS_HOUSE_PROPERTY_TYPE" name="HS_HOUSE_PROPERTY_TYPE" >
						<option value="">--请选择--</option>	
						<c:forEach var="entry" items="${G_PA_HOUSE_RESIDENTIAL_BUILDINGS}">
		          				<option value="${entry.key}"  <c:if test='${entry.key eq hs_.HOUSE_PROPERTY_TYPE}'>selected</c:if> >
		          				${entry.key}┋${entry.value}
			         			 </option>
          					</c:forEach>
    		    		</select>
    		    	</td>
    			</tr>
    		</table>
    	</fieldset>
	  	
    		<fieldset id="hs1">
    		<legend>房产资料</legend>
    		<input type="hidden" id="HS_HOUSE_ID_1" name="HS_HOUSE_ID_1" value="1">
    		<input type="hidden" id="HS_CUSTOMER_ID_1" name="HS_CUSTOMER_ID_1" value="">
    		<input type="hidden" id="HS_ONLY_ID_1" name="HS_ONLY_ID_1" value="">
    		<table border="0" align="left" id="mtable" height="100%">
    			<tr>
    				<td>
    				<input type="button" id="clearHsButton1" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('HS_','1');">
    				</td>
    			</tr>
    			<tr>
    				<td>房产地址：</td>
    				<td colspan="3" nowrap="nowrap" >省：
    						<select id="HS_ADDRESS_PROVINCE_1" name="HS_ADDRESS_PROVINCE_1"
    						onchange="getPCA(this.id,'2','HS_ADDRESS_CITY_1','HS_ADDRESS_AREA_1','HS_ADDRESS_DETAIL_1',this.id);" >
    		    			<option value="">--请选择--</option>
    		    				<c:forEach var="entry" items="${mapProvince}">
								<option value="${entry.pacode}" > 
								${entry.pacode}┋${entry.pavalue}
							</option>
							</c:forEach>
    		    		</select>
    		 			市：
    		    		<select id="HS_ADDRESS_CITY_1" name="HS_ADDRESS_CITY_1" onchange="getPCA(this.id,'3','HS_ADDRESS_AREA_1','HS_ADDRESS_AREA_1','HS_ADDRESS_DETAIL_1','HS_ADDRESS_PROVINCE_1');" >
    		    			<option value="">--请选择--</option>	
    		    		</select>
    		    		区：
    		    		<select id="HS_ADDRESS_AREA_1" name="HS_ADDRESS_AREA_1" onchange="setAddressArea(this.id,'HS_ADDRESS_DETAIL_1','HS_ADDRESS_PROVINCE_1','HS_ADDRESS_CITY_1');" >
    		    			<option value="">--请选择--</option>	
    		    		</select>
    		    	</td>
    		    	
    			</tr>
				<tr>
					<td></td>
					<td colspan=6>
						<textarea rows="2" cols="50" id="HS_ADDRESS_DETAIL_1" name="HS_ADDRESS_DETAIL_1" ></textarea>
					</td>	
				</tr>
    			<tr>
    				<td></td>
    				<td></td>
    				<td>购买方式：</td>
    				<td>
						<select  id="HS_BUY_PARTERN_1" name="HS_BUY_PARTERN_1" >
						<option value="">--请选择--</option>	
						<c:forEach items="${G_PA_HOUSE_PURCHASING_MODE}" var="entry" >
    		    				<option value="${entry.key}">
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    		</select>
					</td>
					<td>房地产证号：</td>
    				<td><input type="text" id="HS_ESTATE_CERTIFICATE_NO_1" name="HS_ESTATE_CERTIFICATE_NO_1" style="width: 100px;" /></td>
    				
    			</tr>
    			<tr>
    				<td></td>
    				<td></td>
					<td>购买日期：</td>
    				<td><input type="text" id="HS_BUY_TIME_1" name="HS_BUY_TIME_1" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" style="width: 100px;" readonly="readonly" /></td>
    				<td>房产查询资料：</td>
    		    	<td><input type="radio" id="HS_IS_SEARCHED_1" name="HS_IS_SEARCHED_1" value="Y" onclick="hsSelectData(this.name,'HS_SEARCH_DATE_1','HS_SEARCH_UNIT_PRICE_1','HS_SEARCH_TOTAL_PRICE_1');"  />有 
    		    		<input type="radio" id="HS_IS_SEARCHED_1" name="HS_IS_SEARCHED_1" value="N" onclick="hsSelectData(this.name,'HS_SEARCH_DATE_1','HS_SEARCH_UNIT_PRICE_1','HS_SEARCH_TOTAL_PRICE_1');" checked="checked" />无
    		    	</td>
    			</tr>
				<tr>
					<td></td>
    				<td></td>
					<td>购买价格：</td>
    				<td><input type="text" id="HS_BUY_PRICE_1" name="HS_BUY_PRICE_1" style="width: 100px;"  maxlength="13"  onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>查询日期：</td>
    				<td><input type="text" id="HS_SEARCH_DATE_1" name="HS_SEARCH_DATE_1" class="Wdate" disabled="disabled" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" style="width: 100px;" readonly="readonly" /></td>
				</tr>
    			<tr>
    				<td>建筑年份：</td>
    				<td><input type="text" id="HS_BUILT_YEAR_1" name="HS_BUILT_YEAR_1"  maxlength="4" style="width:100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>建筑面积：</td>
    				<td><input type="text" id="HS_FLOOR_AREA_1" name="HS_FLOOR_AREA_1" style="width:100px;ime-mode:Disabled;" onkeyup="countHsTotalPrice('HS_SEARCH_UNIT_PRICE_1','HS_FLOOR_AREA_1','HS_SEARCH_TOTAL_PRICE_1')"   maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" />平方米</td>
    				<td>查询单价：</td>
    				<td><input type="text" id="HS_SEARCH_UNIT_PRICE_1" name="HS_SEARCH_UNIT_PRICE_1" disabled="disabled" style="width: 100px;ime-mode:Disabled;" onkeyup="countHsTotalPrice('HS_SEARCH_UNIT_PRICE_1','HS_FLOOR_AREA_1','HS_SEARCH_TOTAL_PRICE_1')"  maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>按揭银行：</td>
    				<td><input type="text" id="HS_MORTGAGE_BANK_1" name="HS_MORTGAGE_BANK_1" style="width: 100px;" /></td>
    				<td>贷款年限：</td>
    				<td><input type="text" id="HS_LOAN_LIMIT_YEAR_1" name="HS_LOAN_LIMIT_YEAR_1"  maxlength="3" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>查询总价：</td>
    				<td><input type="text" id="HS_SEARCH_TOTAL_PRICE_1" name="HS_SEARCH_TOTAL_PRICE_1"  maxlength="22" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>贷款总额：</td>
    				<td><input type="text" id="HS_LOAN_TOTAL_AMOUNT_1" name="HS_LOAN_TOTAL_AMOUNT_1" style="width: 100px;ime-mode:Disabled;"   maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>尚欠余额：</td>
    				<td><input type="text" id="HS_BALANCE_DUE_1" name="HS_BALANCE_DUE_1" style="width: 100px;ime-mode:Disabled;"  maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>每月供款：</td>
    				<td><input type="text" id="HS_MONTHLY_CONTRIBUTION_1" name="HS_MONTHLY_CONTRIBUTION_1" style="width: 100px;ime-mode:Disabled;" maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    			<tr>
    				<td>房产用途：</td>
    				<td><select id="HS_ESTATE_PURPOSES_1" name="HS_ESTATE_PURPOSES_1" >
						<option value="">--请选择--</option>	
						<c:forEach items="${G_PA_HOUSE_USAGEPROPERTY}" var="entry">
    		    				<option value="${entry.key}">
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    		</select>
    		    	</td>
    				<td>物业类型：</td>
    				<td><select id="HS_PROPERTY_TYPE_1" name="HS_PROPERTY_TYPE_1" >
						<option value="">--请选择--</option>	
						<c:forEach items="${G_PA_HOUSE_PROPERTYTYPE}" var="entry">
    		    				<option value="${entry.key}">
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    		</select>
    		    	</td>
    		    	<td>房屋产权类型：</td>
    		    	<td><select id="HS_HOUSE_PROPERTY_TYPE_1" name="HS_HOUSE_PROPERTY_TYPE_1" >
						<option value="">--请选择--</option>	
						<c:forEach items="${G_PA_HOUSE_RESIDENTIAL_BUILDINGS}" var="entry" >
    		    				<option value="${entry.key}">
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    		</select>
    		    	</td>
    			</tr>
    		</table>
    	</fieldset>
    	</div>	
	  	
	  	<!--商业资料-->
	  	<div id="divBusiness" class="divStyle">
	  	<table>
    	<input type="button" id="businessButton" value="添加商业资料" />
    	</table>

	  	 
	  		<fieldset id="bs">
    		<legend>商业资料</legend>
			<table  border="0" id="mtable" height="100%">
				<tr>
					<td>
    				<input type="button" id="clearBsButton" value="清除"/>
    				</td>
    		
    				<input type="button"  id="" value="删除商业资料"/>
    				
    
    			</tr>
	    			<tr>
	    			<input type="hidden" id="BS_APPLY_CODE" name="BS_APPLY_CODE"  value="" />
	    			<input type="hidden" id="BS_CUSTOMER_ID" name="BS_CUSTOMER_ID"  value="" />
	    			<input type="hidden" id="BS_ONLY_ID" name="BS_ONLY_ID"  value="" />
	    			<input type="hidden" id="BS_BUSINESS_ID" name="BS_BUSINESS_ID" <c:if test="${bs_.BUSINESS_ID ne null}">value="${bs_.BUSINESS_ID}"</c:if> <c:if test="${bs_.BUSINESS_ID eq null}">value=""</c:if> >
    				<td>公司名称：</td>
    				<td><input type="text" id="BS_COMPANY_NAME" name="BS_COMPANY_NAME" style="width: 200px;" value="${bs_.COMPANY_NAME}" onkeyup="clearCom(this,'BSMY_COMPANYNAME','BS_SHOP_NAME','BSMY_SHOPNAME');" />
    					<input type="hidden" id="BSMY_COMPANYNAME" name="BSMY_COMPANYNAME" value="${bs_.COMPANY_NAME}">
    				<td>字号：</td>
    				<td><input type="text" id="BS_SHOP_NAME" name="BS_SHOP_NAME" style="width: 100px;"  value="${bs_.SHOP_NAME}" /></td>
    					<input type="hidden" id="BSMY_SHOPNAME" name="BSMY_SHOPNAME" value="${bs_.SHOP_NAME}" />
    				<td>网站：</td>
    				<td><input type="text" id="BS_WEB_ADDRESS" name="BS_WEB_ADDRESS"value="${bs_.WEB_ADDRESS}" /></td>
    			</tr>
    			<tr>
    				<td>地址：</td>
    				<td colspan="3" nowrap="nowrap" >省：
    						<select id="BS_ADDRESS_PROVINCE" name="BS_ADDRESS_PROVINCE"
    						onchange="getPCA(this.id,'2','BS_ADDRESS_CITY','BS_ADDRESS_AREA','BS_ADDRESS_DETAIL',this.id);">
    		    			<option value="">--请选择--</option>
    		    				<c:forEach var="entry" items="${mapProvince}">
								<option value="${entry.pacode}" <c:if test="${entry.pacode eq bs_.ADDRESS_PROVINCE}">selected</c:if>> 
									${entry.pacode}┋${entry.pavalue}
								</option>
							</c:forEach>
    		    		</select>
    		 			市：
    		    		<select id="BS_ADDRESS_CITY" name="BS_ADDRESS_CITY" 
    		    		onchange="getPCA(this.id,'3','BS_ADDRESS_AREA','BS_ADDRESS_AREA','BS_ADDRESS_DETAIL','BS_ADDRESS_PROVINCE');" >
    		    			<c:if test='${bs_.ADDRESS_CITY ne null}'>
						<c:forEach items="${G_PA_CITY_TMP}" var="pa_city_tmp">
							<c:if test='${pa_city_tmp.key eq bs_.ADDRESS_PROVINCE}'>
							<c:forEach items="${pa_city_tmp.value}" var="pa_city_tmp2">
								<option value="${pa_city_tmp2.PACODE}"  <c:if test="${pa_city_tmp2.PACODE eq bs_.ADDRESS_CITY}">selected</c:if>>${pa_city_tmp2.PACODE}┋${pa_city_tmp2.PAVALUE}</option>
							</c:forEach>
							</c:if>
						</c:forEach>
						</c:if>
						<c:if test='${bs_.ADDRESS_CITY eq null}'>
						<option value="">--请选择--</option>
						</c:if>
    		    		</select>
    		    		区：
    		    		<select id="BS_ADDRESS_AREA" name="BS_ADDRESS_AREA" onchange="setAddressArea(this.id,'BS_ADDRESS_DETAIL','BS_ADDRESS_PROVINCE','BS_ADDRESS_CITY');getPostCode('BS_ADDRESS_CITY',this,'BS_POST_CODE');" >
    		    			<c:if test='${bs_.ADDRESS_AREA ne null}'>
						<c:forEach items="${G_PA_AREA_TMP}" var="pa_city_tmp">
							<c:if test='${pa_city_tmp.key eq bs_.ADDRESS_CITY}'>
							<c:forEach items="${pa_city_tmp.value}" var="pa_city_tmp2">
								<option value="${pa_city_tmp2.PACODE}"  <c:if test="${pa_city_tmp2.PACODE eq bs_.ADDRESS_AREA}">selected</c:if>>${pa_city_tmp2.PACODE}┋${pa_city_tmp2.PAVALUE}</option>
							</c:forEach>
							</c:if>
						</c:forEach>
						</c:if>
						<c:if test='${bs_.ADDRESS_AREA eq null}'>
						<option value="">--请选择--</option>
						</c:if>
    		    		</select>
    		    	</td>
    			</tr>
				<tr>
					<td></td>
					<td colspan=3>
						<textarea rows="2" cols="50" id="BS_ADDRESS_DETAIL" name="BS_ADDRESS_DETAIL" >${bs_.ADDRESS_DETAIL}</textarea>
					</td>
					<td>邮政编码：</td>
    				<td><input type="text" id="BS_POST_CODE" name="BS_POST_CODE" value="${bs_.POST_CODE}"  readonly="readonly"  maxlength="6" style="width: 90px;ime-mode:Disabled;background-color: #E6E6E6;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
				</tr>
    			<tr>
    				
    				<td>公司电话：</td>
    				<td><input type="text" id="BS_TEL_AREA" name="BS_TEL_AREA" value="${bs_.TEL_AREA}" maxlength="5" style="width:50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" id="BS_TEL_NUMBER" name="BS_TEL_NUMBER" value="${bs_.TEL_NUMBER}" maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" id="BS_TEL_EXT" name="BS_TEL_EXT" value="${bs_.TEL_EXT}" maxlength="10" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
    				<td>公司传真：</td>
    				<td><input type="text" id="BS_FAX_AREA" name="BS_FAX_AREA" value="${bs_.FAX_AREA}"  maxlength="5" style="width:50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" id="BS_FAX_NUMBER" name="BS_FAX_NUMBER" value="${bs_.FAX_NUMBER}"  maxlength="15" style="width:100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>
    				</td>
    			</tr>
    			<tr>
    				<td>服务年数：</td>
    				<td><input type="text" id="BS_SERVICE_YEARS" name="BS_SERVICE_YEARS" value="${bs_.SERVICE_YEARS}"  maxlength="2" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />年
    					<input type="text" id="BS_SERVICE_MONTHS" name="BS_SERVICE_MONTHS"value="${bs_.SERVICE_MONTHS}"  maxlength="2"style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />月
    				</td>
    				
    			</tr>
				<tr>
					<td><font color="red">*</font>单位性质：</td>
    				<td><select id="BS_UNIT_KIND" name="BS_UNIT_KIND" onblur="checknull2(this)" onchange="getUnitPropertyMap(this.id,'BS_INDUSTRY');getOccupationMap(this.id,'BS_WORK_LEVEL');" >
						<option value="">--请选择--</option>
						<c:forEach items="${GETUNITPROPERTYMAP}" var="entry">
    		    				<option value="${entry.key}" <c:if test='${entry.key eq bs_.UNIT_KIND}'>selected</c:if>>
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    		</select>
    		    	</td>
    		    	<td><font color="red">*</font>所属行业：</td>
    		    	<c:set var="bsIndustry" value="${bs_.ONLY_ID}|${bs_.BUSINESS_ID}"></c:set>
    				<td><select id="BS_INDUSTRY" name="BS_INDUSTRY" onblur="checknull2(this)"  style="width:200px">
						<option value="">--请选择--</option>
						<c:forEach items="${BSBUSINESSMAP}" var="bsBusiness">
    		    			<c:if test='${bsBusiness.key eq bsIndustry}'>
							<c:forEach items="${bsBusiness.value}" var="entry">
							<option value="${entry.key}" <c:if test='${entry.key eq bs_.INDUSTRY}'>selected</c:if>>
								${entry.key}┋${entry.value}
							</option>
							</c:forEach>
							</c:if>
    		    			</c:forEach>
    		    		</select>
    		   		</td>
				</tr>
    			<tr>
    				<td>部门：</td>
    				<td><input type="text" id="BS_DEPARTMENT" name="BS_DEPARTMENT" value="${bs_.DEPARTMENT}" /></td>
    				<td><font color="red">*</font>工作级别：</td>
    				<c:set var="bsWorkLevel" value="${bs_.ONLY_ID}|${bs_.BUSINESS_ID}"></c:set>
    				<td><select id="BS_WORK_LEVEL" name="BS_WORK_LEVEL" onblur="checknull2(this)" >
						<option value="">--请选择--</option>
						<c:forEach items="${LEVELBUSINESSMAP}" var="levelBusiness">
    		    				<c:if test='${levelBusiness.key eq bsIndustry}'>
							<c:forEach items="${levelBusiness.value}" var="entry">
							<option value="${entry.key}" <c:if test='${entry.key eq bs_.WORK_LEVEL}'>selected</c:if>>
								${entry.key}┋${entry.value}
							</option>
							</c:forEach>
							</c:if>
    		    			</c:forEach>
    		    		</select>
    		    	<td>职务：</td>
    				<td><input type="text" id="BS_POSITION" name="BS_POSITION" style="width: 100px;" value="${bs_.POSITION}" /></td>
   				</tr> 				
    			<tr>
    				<td>是否公司东主：</td>
    				<td>
    					<span id="SPAN_IS_OWNER">
						<input type="radio" id="BS_YESOWNER" name="BS_IS_OWNER" value="Y" <c:if test="${bs_.IS_OWNER eq 'Y'}">checked</c:if> />是
						<input type="radio" id="BS_NOOWNER" name="BS_IS_OWNER" value="N" <c:if test="${bs_.IS_OWNER eq 'N'}">checked</c:if> />否
						</span>
					</td>
					<td><font color="red">*</font>是否自雇人士：</td>
    				<td>
						<span id="SPAN_IS_SELF_EMPLOYED"> 
						<input type="radio" id="BS_YESSELFEMPLOYED" name="BS_IS_SELF_EMPLOYED" value="Y" <c:if test="${bs_.IS_SELF_EMPLOYED eq 'Y'}">checked</c:if> />是
						<input type="radio" id="BS_NOSELFEMPLOYED" name="BS_IS_SELF_EMPLOYED" value="N" <c:if test="${bs_.IS_SELF_EMPLOYED eq 'N'}">checked</c:if> />否
					</span>	
					</td>
    			</tr>
    		</table>
    		<fieldset>
    			<legend>补充资料(适用于企业东主)</legend>
    			<table>
    				<tr>
    					<td>营业执照注册号：</td>
    					<td><input type="text" id="BS_BUSINESS_LICENCE_NO" name="BS_BUSINESS_LICENCE_NO"  maxlength="20" value="${bs_.BUSINESS_LICENCE_NO}" /></td>
    					<td>组织机构代码：</td>
    					<td><input type="text" id="BS_ORGANIZATION_CODE" name="BS_ORGANIZATION_CODE" maxlength="9" value="${bs_.ORGANIZATION_CODE}" /></td>
    					<td>成立日期：</td>
    					<td><input type="text" id="BS_ESTABLISH_DATE" name="BS_ESTABLISH_DATE" value="<fmt:formatDate value='${bs_.ESTABLISH_DATE}' type='date' pattern="yyyy/MM/dd"/>" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" style="width: 100px;" readonly="readonly" /></td>
    				</tr>
    				<tr>
						<td>每年盈利/亏损：</td>
    					<td><input type="text" id="BS_YEARLY_PROFIT_OR_LOSS" name="BS_YEARLY_PROFIT_OR_LOSS" value="${bs_.YEARLY_PROFIT_OR_LOSS}" style="ime-mode:Disabled;"  maxlength="13" onkeypress= "return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    					<td>雇员人数：</td>
    					<td><input type="text" id="BS_EMPLOYEE_AMOUNT" name="BS_EMPLOYEE_AMOUNT" style="ime-mode:Disabled;" maxlength="5" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"  value="${bs_.EMPLOYEE_AMOUNT}" /></td>
    				</tr>
					<tr>
						<td>经营场所：</td>
    					<td><select id="BS_BUSINESS_PLACE" name="BS_BUSINESS_PLACE" >
							<option value="">--请选择--</option>
								<c:forEach var="entry" items="${G_PA_BUILDINGS_TYPE}">
			          				<option value="${entry.key}" <c:if test='${entry.key eq bs_.BUSINESS_PLACE}'>selected</c:if> >
			          					${entry.key}┋${entry.value}
				         			</option>
          						</c:forEach>
    		    			</select>
    		    		</td>
    					<td>按揭供款/租金：</td>
    					<td><input type="text" id="BS_CONT_OR_RENT_AMOUNT" name="BS_CONT_OR_RENT_AMOUNT" value="${bs_.CONT_OR_RENT_AMOUNT}" style="ime-mode:Disabled;"  maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" />
						</td>
					</tr>
    			</table>
    		</fieldset>
    		<fieldset>
    			<legend>每月收入</legend>
    			<table>
    				<tr>
    					<td><font color="red">*</font>基本薪金：</td>
    					<td><input type="text" id="BS_BASE_SALARY" name="BS_BASE_SALARY" value="${bs_.BASE_SALARY}" style="width: 100px;ime-mode:Disabled;"   maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" onkeyup="totalBusIncome(this,'BS_OTHER_INCOME','BS_MONTHLY_TOTAL_INCOME')" /></td>
    					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其它收入：</td>
    					<td><input type="text" id="BS_OTHER_INCOME" name="BS_OTHER_INCOME" value="${bs_.OTHER_INCOME}" style="width: 100px;ime-mode:Disabled;"  maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" onkeyup="totalBusIncome('BS_BASE_SALARY',this,'BS_MONTHLY_TOTAL_INCOME')" /></td>
    					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每月总收入：</td>
    					<td><input type="text" id="BS_MONTHLY_TOTAL_INCOME" name="BS_MONTHLY_TOTAL_INCOME" value="${bs_.MONTHLY_TOTAL_INCOME}" style="background-color: #E6E6E6;width: 100px;"  maxlength="12" readonly="readonly" /></td>
    				</tr>
    				<tr>
    					<td><font color="red">*</font>支付方式：</td>
    					<td>
    						<select id="BS_PAY_PATTERN" name="BS_PAY_PATTERN" onblur="checknull2(this)" >
							<option value="">--请选择--</option>
							<c:forEach var="entry" items="${G_PA_PAY_MODE}">
					          		<option value="${entry.key}" <c:if test="${entry.key eq bs_.PAY_PATTERN}">selected</c:if> >
					          			${entry.key}┋${entry.value}
						         	</option>
          						</c:forEach>
						</select>
    					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;支付日：</td>
    					<td>(1)<input type="text" id="BS_PAY_TIME_ONE" name="BS_PAY_TIME_ONE" value="${bs_.PAY_TIME_ONE}" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>
    						(2)<input type="text" id="BS_PAY_TIME_TWO" name="BS_PAY_TIME_TWO" value="${bs_.PAY_TIME_TWO}" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>
    					</td>
    				</tr>
    			</table>
    		</fieldset>
    	</fieldset>	
	  
	  		<fieldset id="bs1">
    		<legend>商业资料</legend>
    		<input type="hidden" id="BS_BUSINESS_ID_1" name="BS_BUSINESS_ID_1" value="1">
			<input type="hidden" id="BS_CUSTOMER_ID_1" name="BS_CUSTOMER_ID_1" value="">
			<input type="hidden" id="BS_ONLY_ID_1" name="BS_ONLY_ID_1" value="">
			<table  border="0"  id="mtable" height="100%">
    			<tr>
    				<td>
    				<input type="button" id="clearBsButton" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('BS_','1');"/>
    				</td>
    			</tr>
    			<tr>
    				<td>公司名称：</td>
    				<td><input type="text" name="BS_COMPANY_NAME_1" id="BS_COMPANY_NAME_1" style="width: 200px;" onkeyup="clearCom('BS_COMPANY_NAME_1','BS_SHOP_NAME_1','','');" /></td>
    				<td>字号：</td>
    				<td><input type="text" name="BS_SHOP_NAME_1" id="BS_SHOP_NAME_1" style="width: 100px;" /></td>
    				<td>网站：<input type="text" name="BS_WEB_ADDRESS_1" id="BS_WEB_ADDRESS_1"  /></td>
    			</tr>
    			<tr>
    				<td>地址：</td>
    				<td colspan="3" nowrap="nowrap" >省：
    						<select name="BS_ADDRESS_PROVINCE_1" id="BS_ADDRESS_PROVINCE_1" onchange="getPCA(this.id,'2','BS_ADDRESS_CITY_1','BS_ADDRESS_AREA_1','BS_ADDRESS_DETAIL_1',this.id);" >
    		    			<option value="">--请选择--</option>
    		    				<c:forEach var="entry" items="${mapProvince}">
								<option value="${entry.pacode}"> 
									${entry.pacode}┋${entry.pavalue}
								</option>
							</c:forEach>
    		    		</select>
    		 			市：
    		    		<select name="BS_ADDRESS_CITY_1" id="BS_ADDRESS_CITY_1" onchange="getPCA(this.id,'3','BS_ADDRESS_AREA_1','BS_ADDRESS_AREA_1','BS_ADDRESS_DETAIL_1','BS_ADDRESS_PROVINCE_1');" >
    		    		<option value="">--请选择--</option>
    		    		</select>
    		    		区：
    		    		<select name="BS_ADDRESS_AREA_1"  id="BS_ADDRESS_AREA_1"  
						onchange="setAddressArea(this.id,'BS_ADDRESS_DETAIL_1','BS_ADDRESS_PROVINCE_1','BS_ADDRESS_CITY_1');getPostCode('BS_ADDRESS_CITY_1',this,'BS_POST_CODE_1');" >
    		    			<option value="">--请选择--</option>
    		    		</select>
    		    	</td>
    		    	
    			</tr>
				<tr>
					<td></td>
					<td colspan=3>
						<textarea rows="2" cols="50" id="BS_ADDRESS_DETAIL_1" name="BS_ADDRESS_DETAIL_1" ></textarea>
					</td>
					<td>邮政编码：
					<input type="text" name="BS_POST_CODE_1" id="BS_POST_CODE_1"  maxlength="6"  style="width: 90px;ime-mode:Disabled;background-color: #E6E6E6;" readonly="readonly" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
				</tr>
    			<tr>
    				
    				<td>公司电话：</td>
    				<td><input type="text" name="BS_TEL_AREA_1" id="BS_TEL_AREA_1"  maxlength="5" style="width:50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" name="BS_TEL_NUMBER_1" id="BS_TEL_NUMBER_1"  maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" name="BS_TEL_EXT_1" id="BS_TEL_EXT_1"  maxlength="10" style="width:90px;ime-mode:Disabled;"  onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
    				<td>公司传真：</td>
    				<td><input type="text" name="BS_FAX_AREA_1" id="BS_FAX_AREA_1"  maxlength="5" style="width:50px;ime-mode:Disabled;"  onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" name="BS_FAX_NUMBER_1" id="BS_FAX_NUMBER_1"  maxlength="15" style="width:100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>
    				</td>
    				
    			</tr>
    			<tr>
    				<td>服务年数：</td>
    				<td><input type="text" name="BS_SERVICE_YEARS_1" id="BS_SERVICE_YEARS_1"  maxlength="2" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />年
    					<input type="text" name="BS_SERVICE_MONTHS_1" id="BS_SERVICE_MONTHS_1"  maxlength="2" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />月
    				</td>
    				
    			</tr>
				<tr>
					<td><font color="red">*</font>单位性质：</td>
    				<td><select name="BS_UNIT_KIND_1" id="BS_UNIT_KIND_1" onblur="checknull2(this)" onchange="getUnitPropertyMap(this.id,'BS_INDUSTRY_1');getOccupationMap(this.id,'BS_WORK_LEVEL_1');" >
						<option value="">--请选择--</option>
						<c:forEach items="${GETUNITPROPERTYMAP}" var="entry">
    		    				<option value="${entry.key}">
								${entry.key}┋${entry.value}
							</option>
    		    			</c:forEach>
    		    		</select>
    		    	</td>
    		    	<td><font color="red">*</font>所属行业：</td>
    				<td><select name="BS_INDUSTRY_1" id="BS_INDUSTRY_1" onblur="checknull2(this)" >
						<option value="">--请选择--</option>
    		    		</select>
    		    	</td>
				</tr>
    			<tr>
    				<td>部门：</td>
    				<td><input type="text" name="BS_DEPARTMENT_1" id="BS_DEPARTMENT_1" /></td>
    				<td><font color="red">*</font>工作级别：</td>
    				<td><select name="BS_WORK_LEVEL_1" id="BS_WORK_LEVEL_1" onblur="checknull2(this)">
						<option value="">--请选择--</option>
    		    		</select>
    		    	</td>
    		    	<td>职务：<input type="text" name="BS_POSITION_1" id="BS_POSITION_1" style="width: 100px;" >
   					</td>
   					</tr> 				
    			<tr>
    				<td>是否公司东主：</td>
    				<td>
    					<span id="SPAN_IS_OWNER_1">
						<input type="radio" name="BS_IS_OWNER_1" id="BS_IS_OWNER_1" value="Y" />是
						<input type="radio" name="BS_IS_OWNER_1" id="BS_IS_OWNER_1" value="N" />否
						</span>
					</td>
					<td><font color="red">*</font>是否自雇人士：</td>
    				<td>
						<span id="SPAN_IS_SELF_EMPLOYED_1"> 
						<input type="radio" name="BS_IS_SELF_EMPLOYED_1" id="BS_IS_SELF_EMPLOYED_1" value="Y" />是
						<input type="radio" name="BS_IS_SELF_EMPLOYED_1" id="BS_IS_SELF_EMPLOYED_1" value="N" />否
					</span>	
					</td>
    			</tr>
    		</table>
    		<fieldset>
    			<legend>补充资料(适用于企业东主)</legend>
    			<table  >
    				<tr>
    					<td>营业执照注册号：</td>
    					<td><input type="text" name="BS_BUSINESS_LICENCE_NO_1" id="BS_BUSINESS_LICENCE_NO_1" style="width: 120px;"   /></td>
    					<td>组织机构代码：</td>
    					<td><input type="text" name="BS_ORGANIZATION_CODE_1" id="BS_ORGANIZATION_CODE_1" style="width: 120px;"  maxlength="9" /></td>
    					<td>成立日期：</td>
    					<td><input type="text" name="BS_ESTABLISH_DATE_1" id="BS_ESTABLISH_DATE_1" class="Wdate" onclick="WdatePicker({readOnly:true,skin:'ext',dateFmt:'yyyy/MM/dd',minDate:'1900/01/01',maxDate:'%y-%M-%d'});" style="width: 100px;" readonly="readonly" /></td>
    				</tr>
    				<tr>
    					<td>每年盈利/亏损：</td>
    					<td><input type="text" name="BS_YEARLY_PROFIT_OR_LOSS_1" id="BS_YEARLY_PROFIT_OR_LOSS_1" style="ime-mode:Disabled;" maxlength="13" onkeypress= "return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    					<td>雇员人数：</td>
    					<td><input type="text" name="BS_EMPLOYEE_AMOUNT_1" id="BS_EMPLOYEE_AMOUNT_1" style="width: 80px;ime-mode:Disabled;" maxlength="5" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				</tr>
    				<tr>
    					<td>经营场所：</td>
    					<td><select name="BS_BUSINESS_PLACE_1" id="BS_BUSINESS_PLACE_1" >
							<option value="">--请选择--</option>
								<c:forEach var="entry" items="${G_PA_BUILDINGS_TYPE}">
			          				<option value="${entry.key}">
			          					${entry.key}┋${entry.value}
				         			</option>
          						</c:forEach>
    		    			</select>
    		    		</td>
    					<td>按揭供款/租金：</td>
    					<td><input type="text" name="BS_CONT_OR_RENT_AMOUNT_1" id="BS_CONT_OR_RENT_AMOUNT_1" style="ime-mode:Disabled;" maxlength="13" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    				</tr>
    			</table>
    		</fieldset>
    		<fieldset>
    			<legend>每月收入</legend>
    			<table>
    				<tr>
    					<td><font color="red">*</font>基本薪金：</td>
    					<td><input type="text" name="BS_BASE_SALARY_1" id="BS_BASE_SALARY_1" style="width: 100px;ime-mode:Disabled;"  maxlength="13" onkeyup="totalBusIncome(this,'BS_OTHER_INCOME_1','BS_MONTHLY_TOTAL_INCOME_1')" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" onblur="checknull(this);" /></td>
    					<td>其它收入：</td>
    					<td><input type="text" name="BS_OTHER_INCOME_1" id="BS_OTHER_INCOME_1" style="width: 100px;ime-mode:Disabled;"  maxlength="13" onkeyup="totalBusIncome('BS_BASE_SALARY_1',this,'BS_MONTHLY_TOTAL_INCOME_1')" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    					<td>每月总收入：</td>
    					<td><input type="text" name="BS_MONTHLY_TOTAL_INCOME_1" id="BS_MONTHLY_TOTAL_INCOME_1" style="background-color: #E6E6E6;width: 100px;"  maxlength="12"  readonly="readonly" /></td>
    				</tr>
    				<tr>
    					<td><font color="red">*</font>支付方式：</td>
    					<td>
						<select name="BS_PAY_PATTERN_1" id="BS_PAY_PATTERN_1" style="width: 100px;" onblur="checknull2(this)" >
							<option value="">--请选择--</option>
							
						</select>
						</td>
    					<td>支付日：</td>
    					<td>(1)<input type="text" name="BS_PAY_TIME_ONE_1" id="BS_PAY_TIME_ONE_1" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />
    						(2)<input type="text" name="BS_PAY_TIME_TWO_1" id="BS_PAY_TIME_TWO_1" style="width: 50px;ime-mode:Disabled;"  maxlength="2" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" />
    					</td>
    				</tr>
    			</table>
    		</fieldset>
    	</fieldset>	
    	</div>
    	
		<div id="divSpousing" class="divStyle">
		<c:forEach items="${GR_}" var="gr_">
		<fieldset>	
    		<legend>配偶资料</legend>
    		<table border="0" align="left" id="mtable" height="100%">
    			<tr>
    			<td>
    			<input type="button" id="clearSpButton" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('GR_SPOUSE_','1');">
    			</td>
    			</tr>
    			<tr>
    				<td>姓名：</td>
    				<td><input type="text" name="GR_SPOUSE_NAME" id="GR_SPOUSE_NAME" value="${gr_.SPOUSE_NAME}" style="width: 100px;" maxlength="40"/></td>
    				<td>是否知悉贷款：</td>
    				<td>
						<input type="radio" value="Y" name="GR_SPOUSE_IS_KOWN_LOAN" id="GR_SPOUSE_YES_KOWN_LOAN" <c:if test="${gr_.SPOUSE_IS_KOWN_LOAN eq 'Y'}">checked="checked"</c:if>/>是
						<input type="radio" value="N" name="GR_SPOUSE_IS_KOWN_LOAN" id="GR_SPOUSE_NOT_KOWN_LOAN" <c:if test="${gr_.SPOUSE_IS_KOWN_LOAN eq 'N' or gr_.SPOUSE_IS_KOWN_LOAN eq null}">checked="checked"</c:if> />否
					</td>
    			</tr>
				<tr>
					<td>手机号码：</td>
    				<td><input type="text" name="GR_SPOUSE_MOBILE" id="GR_SPOUSE_MOBILE"  value="${gr_.SPOUSE_MOBILE}" maxlength="15" style="width: 100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
				</tr>
    			<tr>
    				<td>公司名称：</td>
    				<td><input type="text" name="GR_SPOUSE_COMPANY_NAME" id="GR_SPOUSE_COMPANY_NAME" value="${gr_.SPOUSE_COMPANY_NAME}" style="width: 300px;" /></td>
    				<td>职位：</td>
    				<td><input type="text" name="GR_SPOUSE_POSITION" id="GR_SPOUSE_POSITION" value="${gr_.SPOUSE_POSITION}" style="width: 100px;"  /></td>
    			</tr>
				<tr>
					<td>公司地址：</td>
    				<td><input type="text" name="GR_SPOUSE_COMPANY_ADDRESS" id="GR_SPOUSE_COMPANY_ADDRESS" value="${gr_.SPOUSE_COMPANY_ADDRESS}" style="width:300px;"/></td>
					<td>年龄：</td>
    				<td><input type="text" name="GR_SPOUSE_AGE" id="GR_SPOUSE_AGE"  value="${gr_.SPOUSE_AGE}" maxlength="3" style="width: 60px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
				</tr>
    			<tr>
    				
    				<td>电话：</td>
    				<td><input type="text" name="GR_SPOUSE_TEL_AREA" id="GR_SPOUSE_TEL_AREA"  value="${gr_.SPOUSE_TEL_AREA}" maxlength="5" style="width:50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" name="GR_SPOUSE_TEL_NUMBER" id="GR_SPOUSE_TEL_NUMBER" value="${gr_.SPOUSE_TEL_NUMBER}" maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" name="GR_SPOUSE_TEL_EXT" id="GR_SPOUSE_TEL_EXT" value="${gr_.SPOUSE_TEL_EXT}" maxlength="10" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>
    				</td>
    				<td>每月收入：</td>
    				<td><input type="text" name="GR_SPOUSE_MONTHLY_INCOME" id="GR_SPOUSE_MONTHLY_INCOME" value="${gr_.SPOUSE_MONTHLY_INCOME}" maxlength="13" style="width:100px;ime-mode:Disabled;" onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))" onpaste= "return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))" /></td>
    			</tr>
    		</table>
    	</fieldset>
    	</c:forEach>
    	</div>
	  	  
	  	<div id="divLinkData" class="divStyle">
	  	<table>
    	<input type="button" id="linkmanButton" value="添加联系人资料"/>
    	</table>
	  			<fieldset id="lm">
    			<legend>联系人资料</legend>
    			<table border="0" align="left">
    			<tr>
				<td>
				<input type="button" id="clearLmButton" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('LM_','');"/>
    			</td>
    			<td>
    			<c:if test="${lm_.LINKMAN_ID ne '1'}">
    	
    			<input type="button"  id="" value="删除联系人资料" >
    			</td>
    	
    			</c:if>
    			</tr>
    			<tr>
    				<input type="hidden" id="LM_CUSTOMER_ID_" name="LM_CUSTOMER_ID_" value="${lm_.CUSTOMER_ID}" />
    				<input type="hidden" id="LM_ONLY_ID_" name="LM_ONLY_ID_" value="${lm_.ONLY_ID}" />
    				<input type="hidden" id="LM_APPLY_CODE_" name="LM_APPLY_CODE_"  value="" />
    				<input type="hidden" id="LM_LINKMAN_ID_" name="LM_LINKMAN_ID_" <c:if test="${lm_.LINKMAN_ID ne null}">value="${lm_.LINKMAN_ID}"</c:if> <c:if test="${lm_.LINKMAN_ID eq null}">value=""</c:if> />
    				<td>姓名：</td>
    				<td><input type="text" id="LM_NAME_" name="LM_NAME_" style="width: 100px;"  maxlength="40" value="${lm_.NAME}" /></td>
    				<td>年龄：</td>
    				<td><input type="text" id="LM_AGE_" name="LM_AGE_" value="${lm_.AGE}"  maxlength="3" style="width: 60px;ime-mode:Disabled;"  maxlength="3" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"  /></td>
    				<td>性别：</td>
    				<td>
					<span id="SPAN_LMSEX_">
						<label for="LM_SEXW"><input type="radio" id="LM_SEXW_" name="LM_SEX_" value="M" <c:if test="${lm_.SEX eq 'M'}">checked</c:if> />男</label>
						<label for="LM_SEXM"><input type="radio" id="LM_SEXM_" name="LM_SEX_" value="F" <c:if test="${lm_.SEX eq 'F'}">checked</c:if> />女</label>
					</span>	
					</td>
    			</tr>
    			<tr>
    				<td>关系：</td>
    				<td><select id="LM_RELATION_TO_LOANER_" name="LM_RELATION_TO_LOANER_"  onchange="getContactRelationMapByContactType(this.id,'LM_RELATION_TO_LOANER_DESC_')" />
						<option value="">--请选择--</option>
						<c:forEach var="entry" items="${GETCONTACTTYPEMAP}">
			          			<option value="${entry.key}" <c:if test="${entry.key eq lm_.RELATION_TO_LOANER}">selected</c:if>>
			          			${entry.key}┋${entry.value}
				         		</option>
          					</c:forEach>
						</select>
    		    	<c:set var="lmLoanerDesc" value="${lm_.ONLY_ID}|${lm_.LINKMAN_ID}"></c:set>
    		    	<select id="LM_RELATION_TO_LOANER_DESC_" name="LM_RELATION_TO_LOANER_DESC_" >
						<option value="">--请选择--</option>
						<c:forEach items="${LMLINKMANMAP}" var="lmLinkman">
    		    			<c:if test='${lmLinkman.key eq lmLoanerDesc}'>
							<c:forEach items="${lmLinkman.value}" var="entry">
							<option value="${entry.key}" <c:if test='${entry.key eq lm_.RELATION_TO_LOANER_DESC}'>selected</c:if>>
									${entry.key}┋${entry.value}
							</option>
							</c:forEach>
							</c:if>
    		    		</c:forEach>
						</select>
    		    	</td>
    		    	<td></td>
    		    	<td></td>
    		    	<td>是否知悉贷款：</td>
    				<td>
						<label for="LM_YES_KOWN_LOAN"><input type="radio" id="LM_YES_KOWN_LOAN_" name="LM_IS_KOWN_LOAN_" value="Y" <c:if test="${lm_.IS_KOWN_LOAN eq 'Y'}">checked</c:if> />是</label>
						<label for="LM_NO_KOWN_LOAN"><input type="radio" id="LM_NO_KOWN_LOAN_" name="LM_IS_KOWN_LOAN_" value="N" <c:if test="${lm_.IS_KOWN_LOAN eq 'N' or lm_.IS_KOWN_LOAN eq null}"> checked="checked"</c:if> />否</label>
					</td>
    			</tr>
    			<tr>
    				<td>住宅地址：</td>
    				<td colspan="3" nowrap="nowrap" >省：
    						<select id="LM_DWELL_ADDRESS_PROVINCE_" name="LM_DWELL_ADDRESS_PROVINCE_"
    						onchange="getPCA(this.id,'2','LM_DWELL_ADDRESS_CITY_','LM_DWELL_ADDRESS_AREA_','LM_DWELL_ADDRESS_DETAIL_',this.id);" >
    		    				<option value="">--请选择--</option>
    		    				<c:forEach var="entry" items="${mapProvince}">
								<option value="${entry.pacode}" <c:if test="${entry.pacode eq lm_.DWELL_ADDRESS_PROVINCE}">selected</c:if> > 
									${entry.pacode}┋${entry.pavalue}
								</option>
							</c:forEach>
    		    			</select>
    		 			市：
    		    		<select id="LM_DWELL_ADDRESS_CITY_" name="LM_DWELL_ADDRESS_CITY_" onchange="getPCA(this.id,'3','LM_DWELL_ADDRESS_AREA_','LM_DWELL_ADDRESS_AREA_','LM_DWELL_ADDRESS_DETAIL_','LM_DWELL_ADDRESS_PROVINCE_');" >
    		    			<c:if test='${lm_.DWELL_ADDRESS_CITY ne null}'>
						<c:forEach items="${G_PA_CITY_TMP}" var="pa_city_tmp">
							<c:if test='${pa_city_tmp.key eq lm_.DWELL_ADDRESS_PROVINCE}'>
							<c:forEach items="${pa_city_tmp.value}" var="pa_city_tmp2">
								<option value="${pa_city_tmp2.PACODE}"  <c:if test="${pa_city_tmp2.PACODE eq lm_.DWELL_ADDRESS_CITY}">selected</c:if>>${pa_city_tmp2.PACODE}┋${pa_city_tmp2.PAVALUE}</option>
							</c:forEach>
							</c:if>
						</c:forEach>
						</c:if>
						<c:if test='${lm_.DWELL_ADDRESS_CITY eq null}'>
						<option value="">--请选择--</option>
						</c:if>
    		    		</select>
    		    		区：
    		    		<select id="LM_DWELL_ADDRESS_AREA_" name="LM_DWELL_ADDRESS_AREA_"  onchange="setAddressArea(this.id,'LM_DWELL_ADDRESS_DETAIL_','LM_DWELL_ADDRESS_PROVINCE_','LM_DWELL_ADDRESS_CITY_');" >
    		    			<c:if test='${lm_.DWELL_ADDRESS_AREA ne null}'>
						<c:forEach items="${G_PA_AREA_TMP}" var="pa_city_tmp">
							<c:if test='${pa_city_tmp.key eq lm_.DWELL_ADDRESS_CITY}'>
							<c:forEach items="${pa_city_tmp.value}" var="pa_city_tmp2">
								<option value="${pa_city_tmp2.PACODE}"  <c:if test="${pa_city_tmp2.PACODE eq lm_.DWELL_ADDRESS_AREA}">selected</c:if>>${pa_city_tmp2.PACODE}┋${pa_city_tmp2.PAVALUE}</option>
							</c:forEach>
							</c:if>
						</c:forEach>
						</c:if>
						<c:if test='${lm_.DWELL_ADDRESS_AREA eq null}'>
						<option value="">--请选择--</option>
						</c:if>
    		    		</select>
    		    	</td>
    			</tr>
				<tr>
					<td></td>
					<td colspan=6>
						<textarea rows="2" cols="50" id="LM_DWELL_ADDRESS_DETAIL_" name="LM_DWELL_ADDRESS_DETAIL_" >${lm_.DWELL_ADDRESS_DETAIL}</textarea>
					</td>
				</tr>
    			<tr>
    				<td>住宅电话：</td>
    				<td><input type="text" id="LM_DWELL_TEL_AREA_" name="LM_DWELL_TEL_AREA_" value="${lm_.DWELL_TEL_AREA}"  maxlength="5" style="width: 50px;ime-mode:Disabled;" />-
    					<input type="text" id="LM_DWELL_TEL_NUMBER_" name="LM_DWELL_TEL_NUMBER_" value="${lm_.DWELL_TEL_NUMBER}" maxlength="15" style="width:90px;ime-mode:Disabled;" /></td>
    				<td>手机号码：</td>
    				<td><input type="text" id="LM_MOBILE_" name="LM_MOBILE_"  maxlength="15" style="ime-mode:Disabled;" value="${lm_.MOBILE}" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
    			</tr>
				<tr>
					<td>单位名称：</td>
    				<td><input type="text" id="LM_UNIT_NAME_" name="LM_UNIT_NAME_" value="${lm_.UNIT_NAME}" style="width:300px" /></td>
					<td>职位：</td>
    				<td><input type="text" id="LM_POSITION_" name="LM_POSITION_" value="${lm_.POSITION}" /></td>
				</tr>
    			<tr>
    				<td>公司电话：</td>
    				<td><input type="text" id="LM_COMPANY_TEL_AREA_" name="LM_COMPANY_TEL_AREA_" value="${lm_.COMPANY_TEL_AREA}"  maxlength="5" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    				<input type="text" id="LM_COMPANY_TEL_NUMBER_" name="LM_COMPANY_TEL_NUMBER_" value="${lm_.COMPANY_TEL_NUMBER}"  maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    				<input type="text" id="LM_COMPANY_TEL_EXT_" name="LM_COMPANY_TEL_EXT_" value="${lm_.COMPANY_TEL_EXT}"  maxlength="10" style="width: 90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
    			</tr>
    		</table>
    	</fieldset>
	 		 <fieldset id="lm">
    			<legend>联系人资料</legend>
    			<input type="button" id="clearLmButton" value="清除" <c:if test="${station eq 'A2' or station eq 'A3' or station eq 'A4'}">disabled="disabled"</c:if> onclick="ResetControl('LM_','');" />
    			<table border="0" align="left">
    			<input type="hidden" id="LM_LINKMAN_ID" name="LM_LINKMAN_ID" value="" />
    			<input type="hidden" id="LM_CUSTOMER_ID" name="LM_CUSTOMER_ID" /> 
    			<input type="hidden" id="LM_ONLY_ID" name="LM_ONLY_ID"  /> 
    			<tr>
    				<td>姓名：</td>
    				<td><input type="text" id="LM_NAME" name="LM_NAME" style="width: 100px;"  maxlength="40" /></td>
    				<td>年龄：</td>
    				<td><input type="text" id="LM_AGE" name="LM_AGE" style="width: 60px;ime-mode:Disabled;  maxlength="3" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				<td>性别：</td>
    				<td>
					<span id="SPAN_LMSEX">
						<label for="LM_SEXW"><input type="radio" id="LM_SEXW" name="LM_SEX" value="M" />男</label>
						<label for="LM_SEXM"><input type="radio" id="LM_SEXM" name="LM_SEX" value="F" />女</label>
					</span>	
					</td>
    			</tr>
    			<tr>
    				<td>关系：</td>
    				<td><select id="LM_RELATION_TO_LOANER" name="LM_RELATION_TO_LOANER" onchange="getContactRelationMapByContactType(this.id,'LM_RELATION_TO_LOANER_DESC')" >
						<option value="">--请选择--</option>
						<c:forEach var="entry" items="${GETCONTACTTYPEMAP}">
			          		<option value="${entry.key}" >
			          			${entry.key}┋${entry.value}
				         	</option>
          				</c:forEach>
						</select>
    		    		<select id="LM_RELATION_TO_LOANER_DESC" name="LM_RELATION_TO_LOANER_DESC" >
						<option value="">--请选择--</option>
						</select>
    		    	</td>
    		    	<td></td>
    		    	<td></td>
    		    	<td>是否知悉贷款：</td>
    				<td>
						<label for="LM_YES_KOWN_LOAN"><input type="radio" id="LM_YES_KOWN_LOAN" name="LM_IS_KOWN_LOAN" value="Y" />是</label>
						<label for="LM_YES_KOWN_LOAN"><input type="radio" id="LM_NO_KOWN_LOAN" name="LM_IS_KOWN_LOAN" value="N" checked="checked" />否</label>
					</td>
    			</tr>
    			<tr>
    				<td>住宅地址：</td>
    				<td colspan="3" nowrap="nowrap" >省：
    						<select id="LM_DWELL_ADDRESS_PROVINCE" name="LM_DWELL_ADDRESS_PROVINCE" onchange="getPCA(this.id,'2','LM_DWELL_ADDRESS_CITY','LM_DWELL_ADDRESS_AREA','LM_DWELL_ADDRESS_DETAIL',this.id);" >
    		    			<option value="">--请选择--</option>
    		    				<c:forEach var="entry" items="${mapProvince}">
								<option value="${entry.pacode}" > 
									${entry.pacode}┋${entry.pavalue}
								</option>
							</c:forEach>
    		    		</select>
    		 			市：
    		    		<select id="LM_DWELL_ADDRESS_CITY" name="LM_DWELL_ADDRESS_CITY" onchange="getPCA(this.id,'3','LM_DWELL_ADDRESS_AREA','LM_DWELL_ADDRESS_AREA','LM_DWELL_ADDRESS_DETAIL','LM_DWELL_ADDRESS_PROVINCE');" >
    		    			<option value="">--请选择--</option>
    		    		</select>
    		    		区：
    		    		<select id="LM_DWELL_ADDRESS_AREA" name="LM_DWELL_ADDRESS_AREA" style="width: 100px;"  onchange="setAddressArea(this.id,'LM_DWELL_ADDRESS_DETAIL','LM_DWELL_ADDRESS_PROVINCE','LM_DWELL_ADDRESS_CITY');" >
    		    			<option value="">--请选择--</option>
    		    		</select>
    		    	</td>
    			</tr>
				<tr>
					<td></td>
					<td colspan=6>
						<textarea rows="2" cols="50" id="LM_DWELL_ADDRESS_DETAIL" name="LM_DWELL_ADDRESS_DETAIL"  ></textarea>
					</td>
				</tr>
    			<tr>
    				<td>住宅电话：</td>
    				<td><input type="text" id="LM_DWELL_TEL_AREA" name="LM_DWELL_TEL_AREA"  maxlength="5" style="width: 50px;ime-mode:Disabled;" />-
    					<input type="text" id="LM_DWELL_TEL_NUMBER" name="LM_DWELL_TEL_NUMBER"  maxlength="15" style="width:90px;ime-mode:Disabled;" /></td>
    				<td>手机号码：</td>
    				<td><input type="text" id="LM_MOBILE" name="LM_MOBILE"  maxlength="15" style="ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))" /></td>
    				
    			</tr>
    			<tr>
					<td>单位名称：</td>
    				<td><input type="text" id="LM_UNIT_NAME" name="LM_UNIT_NAME" /></td>
    				<td>职位：</td>
    				<td><input type="text" id="LM_POSITION" name="LM_POSITION" /></td>
    			</tr>
				<tr>
					<td>公司电话：</td>
    				<td><input type="text" id="LM_COMPANY_TEL_AREA" name="LM_COMPANY_TEL_AREA"  maxlength="5" style="width: 50px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" id="LM_COMPANY_TEL_NUMBER" name="LM_COMPANY_TEL_NUMBER"  maxlength="15" style="width:90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/>-
    					<input type="text" id="LM_COMPANY_TEL_EXT" name="LM_COMPANY_TEL_EXT"  maxlength="10" style="width: 90px;ime-mode:Disabled;" onkeypress="return regInput(this,/^[0-9]*$/,String.fromCharCode(event.keyCode))" onpaste="return regInput(this,/^[0-9]*$/,window.clipboardData.getData('Text'))" ondrop="return regInput(this,/^[0-9]*$/,event.dataTransfer.getData('Text'))"/></td>
				</tr>
    		</table>
    	</fieldset>
	</div>	  		
	</form>
  </body>
  <script type="text/javascript">
  	var re,hs,bs,lm;
  	if(document.getElementById('sqrre')==null){
		re = 1;
	}else{
		re=document.getElementById('sqrre').value;
	}
	if(document.getElementById('sqrhs')==null){
		hs = 1;
	}else{
		hs=document.getElementById('sqrhs').value;
	}
	if(document.getElementById('sqrbs')==null){
		bs = 1;
	}else{
		bs=document.getElementById('sqrbs').value;
	}
	if(document.getElementById('sqrlm')==null){
		lm = 3;
	}else{
		lm=document.getElementById('sqrlm').value;
	}
  </script>
</html>
