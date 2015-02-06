/**
 * 贷款产品
 * @param obj
 * @param prodyctType 
 * @param cityCode
 * @param val
 */
function getProduct(obj,cityId,prodyctType,val){
	$.ajax({
		url : '/GBSWEB/param/getProduct.do',
		data : {
			cityId : cityId
		},
		type : 'post',
		success : function(data) {
			$(obj).html('');
			var pList = data.list;
			var productSel = "<select name='productSel' id='productSel'>";
			for (var i = 0; i < pList.length; i++) {
				var da = pList[i];
				if(prodyctType != null && prodyctType != '' && prodyctType != 'undefined'	){
					if(prodyctType != da.product_type){
						continue;
					}
				}
				
				if(da.product_code == val){
					productSel+="<option value='" + da.gu_product_info_oid + "' selected=selected>"
					+ da.product_desc
					+"</option>";
				}else{
					productSel += "<option value='" + da.gu_product_info_oid + "'>"
					+ da.product_desc
					+"</option>";
				}
				
			}
			productSel += "</select>";
			$(obj).html(productSel);
		},
		error : function() {
			alert("异常！");
		}
	});
}

function getAllProduct(obj,val){
	$.ajax({
		url : '/GBSWEB/param/getAllProduct.do',
		data : {},
		type : 'post',
		success : function(data) {
			$(obj).html('');
			var pList = data.list;
			var productSel = "<select name='productSel' id='productSel'>";
			for (var i = 0; i < pList.length; i++) {
				var da = pList[i];
				if(da.product_code == val){
					productSel+="<option value='" + da.gu_product_info_oid + "' selected=selected>"
					+ da.product_desc
					+"</option>";
				}else{
					productSel += "<option value='" + da.gu_product_info_oid + "'>"
					+ da.product_desc
					+"</option>";
				}
				
			}
			productSel += "</select>";
			$(obj).html(productSel);
		},
		error : function() {
			alert("异常！");
		}
	});
}

/**
 * 贷款用途
 * @param obj
 * @param cityCode
 * @param val
 */
function getLoanPurpose(obj,val){
	$.ajax({
		url : '/GBSWEB/param/getLoanPurpose.do',
		data : {},
		type : 'post',
		success : function(data) {
			$(obj).html('');
			var pList = data.list;
			var loan_purpose_sel = "<select name='loan_purpose' id='loan_purpose' >";
			for (var i = 0; i < pList.length; i++) {
				var da = pList[i];
				
				if(da.info_code == val){
					loan_purpose_sel+="<option value='" + da.info_code + "' selected=selected>"
					+ da.info_name
					+"</option>";
				}else{
					loan_purpose_sel += "<option value='" + da.info_code + "'>"
					+ da.info_name
					+"</option>";
				}
				
			}
			loan_purpose_sel += "</select>";
			$(obj).html(loan_purpose_sel);
		},
		error : function() {
			alert("异常！");
		}
	});
}


/**
 * 城市公司 
 * @param obj
 * @param cityCode
 * @param val
 */
function getCity(obj,val){
	$.ajax({
		url : '/GBSWEB/param/getCity.do',
		data : {},
		type : 'post',
		success : function(data) {
			$(obj).html('');
			var pList = data.list;
			var city_code_sel = "<select name='city_id' id='city_id'>";
			for (var i = 0; i < pList.length; i++) {
				var da = pList[i];
				if(da.city_code == val){
					city_code_sel+="<option value='" + da.gu_city_info_oid + "' selected=selected>"
					+ da.city_name
					+"</option>";
				}else{
					city_code_sel += "<option value='" + da.gu_city_info_oid + "'>"
					+ da.city_name
					+"</option>";
				}
				
			}
			
			city_code_sel += "</select>";
			$(obj).html(city_code_sel);
		},
		error : function() {
			alert("异常！");
		}
	});
}

/**
 * 合作方
 * @param obj
 * @param cityCode
 * @param val
 */
function getFunder(obj,val){
	$.ajax({
		url : '/GBSWEB/param/getFunder.do',
		data : {},
		type : 'post',
		success : function(data) {
			$(obj).html('');
			var pList = data.list;
			var funder_code_sel = "<select name='funder_id' id='funder_id' >";
			for (var i = 0; i < pList.length; i++) {
				var da = pList[i];
				
				if(da.funder_code == val){
					funder_code_sel+="<option value='" + da.gu_funder_info_oid + "' selected=selected>"
					+ da.funder_desc
					+"</option>";
				}else{
					funder_code_sel += "<option value='" + da.gu_funder_info_oid + "'>"
					+ da.funder_desc
					+"</option>";
				}
				
			}
			funder_code_sel += "</select>";
			$(obj).html(funder_code_sel);
		},
		error : function() {
			alert("异常！");
		}
	});
}

/**
 * 产品类型
 * @param obj
 * @param val
 */
function getProductType(obj,val){
	$.ajax({
		url : '/GBSWEB/param/getProductType.do',
		data : {},
		type : 'post',
		success : function(data) {
			$(obj).html('');
			var pList = data.list;
			var product_type_sel = "<select name='product_type' id='product_type' >";
			for (var i = 0; i < pList.length; i++) {
				var da = pList[i];
				
				if(da.info_code == val){
					product_type_sel+="<option value='" + da.info_code + "' selected=selected>"
					+ da.info_name
					+"</option>";
				}else{
					product_type_sel += "<option value='" + da.info_code + "'>"
					+ da.info_name
					+"</option>";
				}
				
			}
			product_type_sel += "</select>";
			$(obj).html(product_type_sel);
		},
		error : function() {
			alert("异常！");
		}
	});
}