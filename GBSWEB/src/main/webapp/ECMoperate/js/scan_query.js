
var imgTypeArr = "";
var USERID = "";
var ecm_user = "sa";
var ecm_pwd= "uaf116ECM";

var account = {oper:USERID, uid:ecm_user, passwd:ecm_pwd}; // 操作员基本信息，oper:当前操作员id，uid:ecm上的用户id，passwd:ecm用户密码。
//
/**
 * 影像控件业务信息预定义模板，用于定义界面树节点可以显示的内容。<br>
 * 该信息模板，包含所有的业务类型信息，业务需求变更时需要维护该模板。<br>
 * 通常每一行四个元素顺序表示:影像类别英文名，影像类别中文名，可否直接包含影像1否2是，0目录节点1资料节点。<br>
 * ！注意：目录节点说明，四个元素数序含义为：条码号关键字，文档类别，不直接包含影像，目录节点。
 * <p>
 * 
 * 业务应用可从该模板中自选部分类别，目录节点的文档类别可替换为自定义文字。
 */
/*var imgOcx_docTemplate = [
                   ["BARCODE", "业务_", "1", "0", "D-001"],
                   ["APPLY_PAPER", "申请表", "2", "1", "T-002"],
                   ["ID_CARD", "身份证", "2", "1", "T-001"],
                   ["HOUSE", "房产关系证明", "2", "1", "T-003"],
                   ["OTHER", "其他", "2", "1", "T-004"],
                   ["CAR", "车产证明", "2", "1", "T-005"],
                   ["ZXREPORT", "征信报告", "2", "1", "T-006"],
                   ["REPAIR", "补件", "2", "1", "T-007"]
    			 ];*/
var imgOcx_docTemplate = {
		nodeKey: 'BARCODE', // 存储、查询关键字
    	nodeName: '业务_', // 界面显示名
    	includeImg: '1', // 是否可直接下挂影像1=N,2=Y
    	nodeBarcode: 'D-001', // 影像资料类别识别条码，对于根节点无效
    	nodeType: '0', // 根节点特殊固定为0，所有子节点固定为1
    	children: [
					{
						nodeKey: 'APPLY_PAPER',
						nodeName: '申请表',
						includeImg: '2',
						nodeBarcode: 'T-002'
					},
					{
						nodeKey: 'OTHER',
	            		nodeName: '其他',
	            		includeImg: '2',
	            		nodeBarcode: 'T-004'
					},
					{
						nodeKey: 'RECYCLE',
	            		nodeName: '回收站',
	            		includeImg: '2',
	            		nodeBarcode: '000000000'
					}
    	           ]
};

var imgOcx_defaultDoctype = "LOAN";

/**
 * 批量动态新增时，默认的第一个节点信息
 */
var imgOcx_defaultBatchKeylsit = [{key: "BARCODE", val: "10000"}];

var ecmOcx = null; // ECM控件对象

var SunScan = null; // 影像控件对象

var isOcxHideByMouseOut = false; // 当鼠标离开当前窗口时，控件自动隐藏，设置该变量为true

/**
 * 创建SunScan控件所需的XML文档的模板字符串。
 */
var xmlTemplate = "<?xml version='1.0' encoding='GB2312' ?>";

/**
 * 调用影像控件接口所需的参数报文模板。
 */
var paramTemplate = "<root><head><transcode></transcode></head><body></body></root>";

/**
 * 初始化页面控件。
 */
function initOcx(treeInfo) {
	ecmOcx = Ext.getDom("ecmOcx");
	
	try {
		var tmp = ecmOcx.object.length;
	} catch (e) {
		alert("[页面加载]：ECM传输控件加载失败！");
	}
	
	initSunScan(treeInfo);
}
/**
 * 定义树结构。
 * formal:正式影像是否可下挂影像，repair：不见资料节点下是否可下挂影像,oldfile：旧文件扫描节点是否可下挂影像
 *1：不可下挂，2可下挂影像
 * @return
 */
function getAllDocTemplate(formal,repair,oldfile) {
	var template = {
	            	nodeKey: 'BARCODE', // 存储、查询关键字
	            	nodeName: '影像管理', // 界面显示名
	            	includeImg: '1', // 是否可直接下挂影像1=N,2=Y
	            	nodeBarcode: 'D-001', // 影像资料类别识别条码，对于根节点无效
	            	nodeType: '0', // 根节点特殊固定为0，所有子节点固定为1
	            	children: [
			            	{
			            		nodeKey: 'APPLY_PAPER',
			            		nodeName: '申请表/身份证',
			            		includeImg: formal,
			            		nodeBarcode: 'T-001'
			            	},
			            	{
			            		nodeKey: 'CUSTOMER',
			            		nodeName: '客户资料',
			            		includeImg: formal,
			            		nodeBarcode: 'T-002'
			            	},
			            	{
			            		nodeKey: 'CONTRACT',
			            		nodeName: '合同',
			            		includeImg: formal,
			            		nodeBarcode: 'T-003'
			            	},
			            	{
			            		nodeKey: 'AGREE',
			            		nodeName: '委托划款协议',
			            		includeImg: formal,
			            		nodeBarcode: 'T-004'
			            	},
			            	{
			            		nodeKey: 'SETTLE',
			            		nodeName: '结清证明',
			            		includeImg: formal,
			            		nodeBarcode: 'T-005'
			            	},
			            	{
			            		nodeKey: 'ZXREPORT',
			            		nodeName: '征信报告',
			            		includeImg: formal,
			            		nodeBarcode: 'T-006'
			            	},
			            	{
			            		nodeKey: 'INSPECT',
			            		nodeName: '考察报告',
			            		includeImg: formal,
			            		nodeBarcode: 'T-007'
			            	}
			            	,
			            	{
	            		nodeKey: 'REPAIR',
	            		nodeName: '补件',
	            		includeImg: '1',
	            		nodeBarcode: 'T-002',
	            		children: [
			            		{
				            		nodeKey: 'REPAIR_APPLY_PAPER',
				            		nodeName: '申请表/身份证',
				            		includeImg: repair,
				            		nodeBarcode: 'T-010'
				            	},
				            	{
				            		nodeKey: 'REPAIR_CUSTOMER',
				            		nodeName: '客户资料',
				            		includeImg: repair,
				            		nodeBarcode: 'T-011'
				            	},
				            	{
				            		nodeKey: 'REPAIR_CONTRACT',
				            		nodeName: '合同',
				            		includeImg: repair,
				            		nodeBarcode: 'T-012'
				            	},
				            	{
				            		nodeKey: 'REPAIR_AGREE',
				            		nodeName: '委托划款协议',
				            		includeImg: repair,
				            		nodeBarcode: 'T-013'
				            	},
				            	{
				            		nodeKey: 'REPAIR_SETTLE',
				            		nodeName: '结清证明',
				            		includeImg: repair,
				            		nodeBarcode: 'T-014'
				            	},
				            	{
				            		nodeKey: 'REPAIR_ZXREPORT',
				            		nodeName: '征信报告',
				            		includeImg: repair,
				            		nodeBarcode: 'T-015'
				            	},
				            	{
				            		nodeKey: 'REPAIR_INSPECT',
				            		nodeName: '考察报告',
				            		includeImg: repair,
				            		nodeBarcode: 'T-016'
				            	}
	            		]
	            	},{
			            		nodeKey: 'UN_',
			            		nodeName: '旧文件扫描',
			            		includeImg: '1',
			            		nodeBarcode: 'T-008',
			            		children: [
					            		{
						            		nodeKey: 'UN_APPLY_PAPER',
						            		nodeName: '申请表/身份证',
						            		includeImg: oldfile,
						            		nodeBarcode: 'T-020'
						            	},
						            	{
						            		nodeKey: 'UN_CUSTOMER',
						            		nodeName: '客户资料',
						            		includeImg: oldfile,
						            		nodeBarcode: 'T-021'
						            	},
						            	{
						            		nodeKey: 'UN_CONTRACT',
						            		nodeName: '合同',
						            		includeImg: oldfile,
						            		nodeBarcode: 'T-022'
						            	},
						            	{
						            		nodeKey: 'UN_AGREE',
						            		nodeName: '委托划款协议',
						            		includeImg: oldfile,
						            		nodeBarcode: 'T-023'
						            	}
			            		]
			            	},
			            	{
			            		nodeKey: 'RECYCLE',
			            		nodeName: '回收站',
			            		includeImg: '2',
			            		nodeBarcode: '000000000'
			            	}
	            	]
	            }
	return template;
}
/**
 * 生成初始化信息报文。
 * 
 * @return
 */
function initSunScan(treeInfo) {
	SunScan = Ext.getDom("SunScan");
	
	try {
		var tmp = SunScan.object;
	} catch (e) {
		alert("[页面加载]：影像扫描控件加载失败！");
		return;
	}
	
	var ti = (treeInfo) ? treeInfo : getDefaultDocTemplate();
	var trdCode = "td0001";
	var paramList = [
	                 createTradeInfo(getDefaultDocType(), 0),
	                 createTree2(ti)
	                 ];
	var paramStr = wrapInfo(trdCode, paramList);
	
	try {
		SunScan.CommOcxFunction(paramStr);
		 
		/*
		 * 当鼠标离开当前窗口时自动隐藏控件区域
		 */
		/*document.body.onmouseenter = function(evt, tgt, obj) {
			if (isOcxHideByMouseOut == true) {
				Ext.getDom("SunScan").parentNode.style.visibility = 'inherit';
				isOcxHideByMouseOut = false;
			}
		}
		Ext.getDoc().addListener(
			'mouseout',
			function(evt, tgt, obj) {
				Ext.getDom("SunScan").parentNode.style.visibility = 'hidden';
				isOcxHideByMouseOut = true;
			}
		);*/
		/*Ext.getBody().addListener(
				'mouseenter',
				function(evt, tgt, obj) {
					if (isOcxHideByMouseOut == true) {
						Ext.getDom("SunScan").parentNode.style.visibility = 'inherit';
						isOcxHideByMouseOut = false;
					}
				}
			);*/
	} catch (e) {
		alert("影像控件初始化失败！");
	}
}

/**
 * 动态添加批次。
 * 
 * @param barcode 文档条码。
 * @param oldSize 当前控件上的批次数量。
 * @param focusOnType 默认焦点所在的影像类型英文名。
 * 
 * @return
 */
function appendBatch(barcode, oldSize, focusOnType) {
	var trdCode = "td0019";
	
	/*
	 * 获取当前焦点位置
	 */
	//var focusOnType = getDefaultDocTemplate().children[0].nodeKey;
	var pos = {batchIndex: (oldSize + 1), imgType: focusOnType};
	
	var xmlStr = "<node>";
	xmlStr += "<bsinf attr='BARCODE' disp='关键字' isquery='1'>" + barcode + "</bsinf>";
	xmlStr += "</node>";
	var nodeXml = createXML(xmlStr);
	
	SunScan.CommOcxFunction(wrapInfo(trdCode, nodeXml));
	
	// 设置新增批次为当前焦点
	setFocus(pos);
}

/**
 * 修改控件树结构。
 * 
 * @param mode 新增或修改模式参数。
 * @param docType 文档类型。
 * @param docTemplate 树结构模版。
 * @param keyList 保存或查询用的关键字信息。
 */
function modifyTreeInfo(mode, docType ,docTemplate, keyList) {
	if (Ext.isEmpty(docTemplate) || Ext.isEmpty(keyList)) {
		return;
	}
	
	var treeXmlStr = createTree2(docTemplate);
	var tradeXmlStr = createTradeInfo2(docType, mode, keyList);
	var paramList = [treeXmlStr, tradeXmlStr];
	SunScan.CommOcxFunction(wrapInfo("td0013", paramList));
	return parseReturnMesg(ret);
}


/**
 * 新批次。
 * @deprecated 建议使用newBatchs()接口。
 * 
 * @param docType 文档类型英文名。
 * @param keyList 需要与影像一起保存的业务关键字列表，格式为[["key", "value"]...]。
 * 	例如：["BARCODE", ""]。
 * 
 * @return
 */
function newBatch(docType, keyList) {
	/*if (Ext.isEmpty(docType) || Ext.isEmpty(keyList)) {
		return "调用失败，缺少参数！";
	}*/
	var dt = (docType) ? docType : getDefaultDocType();
	var kl = (keyList) ? keyList : getDefaultKeyList();
	
	var trdCode = "td0002";
	var param = createTradeInfo(dt, 0, kl);
	SunScan.CommOcxFunction(wrapInfo(trdCode, param));
}

/**
 * 新批量批次。也可用于单笔。
 * 
 * @param mode 模式参数：0新增，1修改。2只读查询可选，默认为0。
 * @param docType 业务类型英文名。可选，若不提供该参数，则须通过其他方式修改为所需业务类型。
 * @param keyList 需要与影像一起保存的业务关键字列表数组，格式为[{key: 'keyName', val: 'keyValue', filterType: 'type'}...]。
 * 	"filterType"为可选属性，仅允许添加在"BARCODE"以外的条件中，其含义为0查询(不返回字段),1查询条件(返回字段),2返回字段,4影像类别(屏蔽其他类型！)。
 * 	例：[{key: "BARCODE", val: "123"}, {key: "REPAIR", val: '', filterType: '4'}]。
 * 
 * 
 * @return
 */
function newBatchs(mode, docType, keyList) {
	var m = (mode) ? mode : 0;
	var dt = (docType) ? docType : getDefaultDocType();
	var kl = (keyList) ? keyList : getDefaultKeyList();
	
	var trdCode = "td0002";
	
	var param = createTradeInfo2(dt, m, kl);
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode, param));
	return parseReturnMesg(ret);
}

/**
 * 只读查询。
 * @deprecated 建议使用newBatchs()接口。
 * 
 * @param docType 文档类型英文名。
 * @param filter 查询过滤列表。格式为[["key|imgType", "value", "type"]...]，
 * 第一列元素表示业务关键字（或影像类别），第二列为值（影像类别值为空），
 * 第三列为查询方式（0查询(不返回字段),1查询条件(返回字段),2返回字段,4影像类别）。
 * 
 * @return
 */
function newQuery(docType, filter) {
	var dt = (docType) ? docType : getDefaultDocType();
	var fl = (filter) ? filter : getDefaultKeyList();
	
	var trdCode = "td0002";
	var param = createTradeInfo(dt, 2, fl);
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode, param));
	return parseReturnMesg(ret);
}

/**
 * 修改批次文档。
 * @deprecated 建议使用newBatchs()接口。
 * 
 * @param docType 文档类型英文名。
 * @param keyList 需要与影像一起保存的业务关键字列表，格式为[["key", "value"]...]。
 * @return
 */
function modifyBatch(docType, keyList) {
	var dt = (docType) ? docType : getDefaultDocType();
	var kl = (keyList) ? keyList : getDefaultKeyList();
	
	var trdCode = "td0002";
	var param = createTradeInfo(dt, 1, kl);
	SunScan.CommOcxFunction(wrapInfo(trdCode, param));
}

/**
 * 影像控件自动调用的回调函数。
 * 
 * @return
 */
function JScallbackProc(paramXml) {
	//alert(paramXml);
	
	var retInfos = parseReturnMesg(paramXml);
	
	switch (retInfos.transcode.toLowerCase()) {
	case "cb0001": // 扫描采集后
		afterScan(retInfos);
		break;
		
	case "cb0002": // 提交后
		afterCommit(retInfos);
		break;
	
	case "cb0003": // 提交后
		afterBatch(retInfos);
		break;
	case "cb0004": // 打印后
		afterPrint(retInfos);
		break;
		

	default:
		break;
	}
}
function setWmW(path){
	var wmwConfig = {
					WMWord: "复印无效",
					fontType: "黑体",
					fontSize: "500",
					fontColor: "100",
					xPos: "200",
					yPos: "2500",
					rAngle: "45",
					path:path
			};
			setWMWord(wmwConfig);
}
/**
 * 当点击打印时，触发
 */
function afterPrint(retInfos){
	var path=retInfos.items[0];
	setWmW(path);
}

/**
 * 扫描完一张影像后触发调用。
 * 应用可编写同名函数覆盖该接口。
 * @param OcxRetInfo 控件返回信息。
 */
function afterScan(OcxRetInfo) {
	if (OcxRetInfo.respcode != "0") {
		//alert("获取扫描数据失败！");
	} else {
		//alert(OcxRetInfo.respinfo);
	}
}

/**
 * 提交批次后触发调用。
 * 应用可编写同名函数覆盖该接口。
 * @param OcxRetInfo 控件返回信息。
 */
function afterCommit(OcxRetInfo) {
	//alert(OcxRetInfo.respinfo);
}

/**
 * 上传影像数据。
 * 
 * @return 返回上传结果，0为成功，小于0为失败。
 */
function upload() {
	var trdCode = "td0003";
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode));
	return parseReturnMesg(ret);
}

/**
 * 显示高亮区域。
 * 
 * @return
 * @exception 
 */
function setHighlight(x, y, width, height, imgOcx) {
	var paramXml = createParamXml("td0011"); // 创建XML基本结构
	
	var paramElm = paramXml.createElement("param");
	paramElm.text = x;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = y;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = width;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = height;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	if (imgOcx) {
		imgOcx.CommOcxFunction(paramXml.xml);
	} else {
		SunScan.CommOcxFunction(paramXml.xml);
	}
	
}
/**
 * 显示高亮区域。
 * 
 * @return
 * @exception 
 */
function setHighlightBatch(path,x, y, width, height, imgOcx) {
	var paramXml = createParamXml("td0111"); // 创建XML基本结构
	
	var paramElm = paramXml.createElement("param");
	paramElm.text = x;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = y;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = width;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = height;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	paramElm = paramXml.createElement("param");
	paramElm.text = path;
	Ext.query("body", paramXml)[0].appendChild(paramElm);
	
	if (imgOcx) {
		imgOcx.CommOcxFunction(paramXml.xml);
	} else {
		SunScan.CommOcxFunction(paramXml.xml);
	}
	
}

/**
 * 获取业务信息中的条码。
 * 若传入业务信息参数，则返回指定信息中的条码；
 * 若未传入参数，则返回当前控件树上所有批次条码信息。
 * 
 * @param tradeInfoXml 可选，需要解析的业务信息XML对象。
 * 
 * @return 返回条码信息数组。
 */
function getBatchBarcode(tradeInfoXml) {
	var ret = [];
	if (tradeInfoXml) {
		var barcode = Ext.query("bsinf[attr='BARCODE']", tradeInfoXml)[0].text;
		ret.push(barcode);
		
	} else {
		var batchInfo = getBatchInfo();
		/*for (var i = 0; i < batchInfo.items.length; i++) {
			var batchXml = CDATAToXml(batchInfo.items[i]);
			var barcode = Ext.query("bsinf[attr='BARCODE']", batchXml)[0].text;
			ret.push(barcode);
		}*/
		if (batchInfo.items.length > 0) {
			var batchXml = CDATAToXml(batchInfo.items[0]);
			var bcs = Ext.query("bsinf[attr='BARCODE']", batchXml);
			for (var i = 0; i < bcs.length; i++) {
				ret.push(bcs[i].text);
			}
		}
	}
	return ret;
}

/**
 * 获取当前控件树上的批次节点信息。
 * 
 * @return 返回JS对象：{transcode: string, respcode: string, respinfo: string, body: xml, items: array(string), params: array(string)}。
 */
function getBatchInfo() {
	var paramXml = createParamXml("td0021");
	var retInfo = SunScan.CommOcxFunction(paramXml.xml);
	return parseReturnMesg(retInfo);
}


/**
 * 获取影像界面定义的区域位置。
 * 
 * @return
 */
function getDefinedArea() {
	var paramXml = createParamXml("td0012"); // 创建XML基本结构
	var retOcx = SunScan.CommOcxFunction(paramXml.xml);
	var bodyXml = parseReturnMesg(retOcx).body;
	var items = Ext.query("item", bodyXml);
	var ret = [];
	var i = 0;
	for (; i < 4; i++) {
		ret[i] = items[i].text;
	}
	return ret;
}
/**
 * 获取高亮区域位置。
 * 
 * @return
 */
function getHightLightdArea() {
	var paramXml = createParamXml("td0112"); // 创建XML基本结构
	var retOcx = SunScan.CommOcxFunction(paramXml.xml);
	var bodyXml = parseReturnMesg(retOcx).body;
	
	var items = Ext.query("item", bodyXml);
	
	var ret = [];
	for (var i = 0; i < items.length; i++) {
		ret[i] = items[i].text;
	}
	return ret;
}

/**
 * 获取初始化控件时采用的业务类型信息模板，用于创建树结构模板。
 * 应用可自行实现并覆盖该函数。
 * 
 * @return
 */
function getDefaultDocTemplate() {
	return imgOcx_docTemplate;
}

/**
 * 获取初始化控件时采用的文档类型。
 * 
 * @return
 */
function getDefaultDocType() {
	return imgOcx_defaultDoctype;
}

/**
 * 获取初始化控件时的条码信息，用于初始化批量扫描界面。
 * 
 * @return
 */
function getDefaultKeyList() {
	return imgOcx_defaultBatchKeylsit;
}


/**
 * 获取当前焦点。
 * 
 * 
 * @return 返回焦点信息对象：{batchIndex: "批次序号", imgType: "影像类型" [, imgIndex: "影像序号"]}。
 */
function getFocus() {
	var paramXml = createParamXml("td0018"); // 创建XML基本结构
	var retOcx = SunScan.CommOcxFunction(paramXml.xml);
	var focusInfo = parseReturnMesg(retOcx);
	var ret = {batchIndex: focusInfo.items[0], imgType: focusInfo.items[1]};
	if (focusInfo.items.length == 3) {
		ret.imgIndex = focusInfo.items[2];
	}
	return ret;
}

/**
 * 获取选中的文件列表。
 * 
 * @return 返回文件路径数组。
 */
function getSelectedFiles() {
	var paramXml = createParamXml("td0007"); // 创建XML基本结构
	var retOcx = SunScan.CommOcxFunction(paramXml.xml);
	var bodyXml = parseReturnMesg(retOcx).body;
	var items = Ext.query("item", bodyXml);
	var ret = [];
	if (items.length > 0) {
		var cdata = CDATAToXml(items[0].text);
		if (cdata) {
			var imgNodes = Ext.query("Image", cdata);
			for (var i = 0; i < imgNodes.length; i++) {
				if (! Ext.isEmpty(imgNodes[i].text)) {
					ret.push(imgNodes[i].text);
				}
			}
		}
		
	}
	return ret;
}

/**
 * 返回包含文件的影像分类节点信息。
 * 结构为：{IMGTYPE1: [img1path, img2path], IMGTYPE2: [img3path],...}
 * 
 * @return
 */
function getImgTypes() {
	var ret = {};
	var filepaths = getSelectedFiles(); // 获取选中文件列表
	for (var i = 0; i < filepaths.length; i++) { // 获取每个文件属性，包含所在资料类型信息
		var paramXml = createParamXml("td0009");
		var bodyNodes = Ext.query("body", paramXml);
		var paramElm = paramXml.createElement("param");
		paramElm.text = filepaths[i];
		bodyNodes[0].appendChild(paramElm);
		paramElm = paramXml.createElement("param");
		paramElm.text = 4; // 查询条件，4为资料类型
		bodyNodes[0].appendChild(paramElm);
		var retOcx = SunScan.CommOcxFunction(paramXml.xml); 
		var bodyXml = parseReturnMesg(retOcx).body;
		var items = Ext.query("item", bodyXml);
		if (items.length > 0) {
			if (ret[items[0].text]) {
				ret[items[0].text].push(filepaths[i]);
			} else {
				ret[items[0].text] = [filepaths[i]];
			}
		}
		
	}
	
	ret.getSize = function() {
		var count = 0;
		for (var j in ret) {
			if ((typeof ret[j]) != "function") {
				count++;
			}
		}
		return count;
	}
	
	return ret;
}
/**
 * 采集完成一个批次后触发调用。
 * 应用可编写同名函数覆盖该接口。
 * @param OcxRetInfo 控件返回信息。
 */
function afterBatch(OcxRetInfo){
	//alert(OcxRetInfo);
	
}
/**
 * 在影像上打钩
 * 
 * @param cfg 移动信息对象。结构为：{batchIndex: idx, imgType: 'imgType', imgNum: 'imgNum',是否打钩[0-不打钩，1-打钩]}
 * @return
 */
function checked(idx,imgType,imgNum){
	var trdCode = "td0040";
	var paramList=[idx,imgType,imgNum,'1'];
	paramList.cdataFlags = [0,0,0,0];
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode,paramList));
	return parseReturnMesg(ret);
	
}
/**
 * 选定指定批次的所有影像
 * 
 * @param cfg 移动信息对象。结构为：{batchIndex: idx, imgType: 'imgType', imgNum: 'imgNum',是否打钩[0-不打钩，1-打钩]}
 * @return
 */
 function checkAll(index,imgType){
 	var countImg=getImgNum(index,imgType).items[0];
 	for(var i =1;i<=countImg;i++){
 		checked(index,imgType,i);
 	}
 }
 /**
 * 判断ECM是否有影像
 * 
 * @param 判断ecm是否有影像
 * @return
 */
 function ECMhasImg(barcode){
	var dt =getDefaultDocType();
	var keyList = [{key: "BARCODE", val: barcode}];
	var trdCode = "td0053";
	var param = createTradeInfo2(dt, 2, keyList);
	var ret =SunScan.CommOcxFunction(wrapInfo(trdCode, param));
	return parseReturnMesg(ret);
	
}
/**
 * 隐藏导入及扫描按钮
 * 
 * @param cfg 移动信息对象。结构为：{batchIndex: idx, imgType: 'imgType', imgNum: 'imgNum',是否打钩[0-不打钩，1-打钩]}
 * @return
 */
function displayScan(config){
	var trdCode = "td0037";
	var paramList=[config];
	paramList.cdataFlags = [0];
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode,paramList));
	return parseReturnMesg(ret);
	
}
/**
 * 获取控件树上含有影像张数
 * 
 * @param targetIndex目标批次
 * @return
 */
function getTreeImgNum(targetIndex){
	var bIdx = (targetIndex) ? targetIndex : 1;
	var trdCode = "td0042";
	var paramList=[bIdx];
	paramList.cdataFlags = [0];
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode,paramList));
	return parseReturnMesg(ret);
	
}
/**
 * 在剔除空白页
 * 
 * @param cfg 移动信息对象。结构为：{batchIndex: idx, imgType: 'imgType', imgNum: 'imgNum'}
 * @return
 */
function move4Blank(targetIndex,imgType){
	var bIdx = (targetIndex) ? targetIndex : 1;
	var moveConfig = {batchIndex: bIdx};
	moveConfig.oldNode=imgType;
	moveConfig.newNode='RECYCLE';
	moveTo(moveConfig);
	
}
/**
 * 按照指定参数移动影像
 * 
 * @param  批次号
 * @param  移动前节点
 * @param  移动后节点
 * @return
 */
function moveByComfig(targetIndex,formImgType,toImgType){
	var bIdx = (targetIndex) ? targetIndex : 1;
	var moveConfig = {batchIndex: bIdx};
	moveConfig.oldNode=formImgType;
	moveConfig.newNode=toImgType;
	moveTo(moveConfig);
	
}
  /**
 * 获取资料下影像数量
 * 
 * @return
 */
 function getImgNum(batIndx,imgType){
 	var trdCode = "td0041";
 	var paramList = [batIndx, imgType];
 	paramList.cdataFlags = [0, 0];
 	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode, paramList));
 	return parseReturnMesg(ret);
 }
  /**
 * 保存选定的影像
 * 
 * @return
 */
  function saveCheckImg(){
 	var trdCode = "td0043";
 	var paramList = [];
 	paramList.cdataFlags = [];
 	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode, paramList));
 	return parseReturnMesg(ret);
 }
/**
 * 在目标批次中移动影像。
 * 
 * @param cfg 移动信息对象。结构为：{batchIndex: idx, oldNode: 'nodeKey', newNode: 'nodeKey'}
 * @return
 */
function moveTo(cfg) {
	var trdCode = "td0022";
	var paramList = [cfg.batchIndex, cfg.oldNode, cfg.newNode];
	paramList.cdataFlags = [0, 0, 0];
	var ret = SunScan.CommOcxFunction(wrapInfo(trdCode, paramList));
	return parseReturnMesg(ret);
}

/**
 * 将某批次补件节点下选中的影像移动到对应的二级节点下。
 * 补件节点下的子节点的key格式为"补件KEY_类型KEY"，例如："REPAIR_ID_CARD"。
 * 
 * @param targetIndex 可选，指定操作第几个批次，批次索引值从1开始。
 * 
 * @return
 */
function move4Repair(targetIndex) {
	var bIdx = (targetIndex) ? targetIndex : 1;
	var moveConfig = {batchIndex: bIdx};
	
	//var files = getSelectedFiles();
	var imgTypes = getImgTypes(); // 获取所有含有选中文件的影像类型
	//Ext.getDom('testBox').value = imgTypes;
	
	for (var i in imgTypes) {
		if (imgTypes[i] instanceof Array) {
			var oldKeyName = i.toString();
			var spliterIdx = oldKeyName.indexOf("_");
			var keyName = oldKeyName.substr(spliterIdx + 1);
			moveConfig.oldNode = oldKeyName;
			moveConfig.newNode = keyName;
			moveTo(moveConfig);
		}
	}
	
	// 提交
	var ret=upload();
	if(ret.respcode == 0){
		return true ;
	}else{
		return false;
	}
}


/**
 * 统计选中的文件信息。
 * 
 * @return 返回文件总数和大小总和。
 */
function statFilesInfo() {
	var fileList = getSelectedFiles();
	var i = 0;
	var totalSize = 0;
	for (; i < fileList.length; i++) {
		totalSize += ecmOcx.FileSize(fileList[i]);
	}
	var info = [fileList.length, totalSize];
	return info;
}

/**
 * 解析控件返回信息，返回JS对象：{transcode: string, respcode: string, respinfo: string, body: xml, items: array(string), params: array(string)}。
 * 
 * @param xmlInfo
 * @return
 */
function parseReturnMesg(xmlInfo) {
	var ret = new Object();
	var retXml = createXML(xmlInfo);
	ret.transcode = Ext.query("transcode", retXml)[0].text;
	ret.respcode = Ext.query("respcode", retXml)[0].text;
	ret.respinfo = Ext.query("respinfo", retXml)[0].text;
	ret.body = Ext.query("body", retXml)[0];
	
	var itemXmls = Ext.query("item", ret.body);
	var paramXmls = Ext.query("param", ret.body);
	
	ret.items = [];
	ret.params = [];
	
	for (var i = 0; i < itemXmls.length; i++) {
		ret.items.push(itemXmls[i].text);
	}
	
	for (var i = 0; i < paramXmls.length; i++) {
		ret.params.push(paramXmls[i].text);
	}
	
	return ret;
}

/**
 * 设置焦点。
 * 
 * @param pos 目标信息对象，结构为：{batchIndex: "批次序号", imgType: "影像类型" [, imgIndex: "影像序号"]}。
 * 例：{batchIndex: 1, imgType: "ID_CARD"}。
 * 
 * @return
 */
function setFocus(pos) {
	var paramList = [pos.batchIndex, pos.imgType];
	paramList.cdataFlags = [0, 0];
	
	if (pos.imgIndex) {
		paramList.push(pos.imgIndex);
		
	} else {
		paramList.push("");
	}
	paramList.cdataFlags.push(0);
	
	var ret = SunScan.CommOcxFunction(wrapInfo("td0017", paramList));
	return ret;
}

/**
 * 设置扫描分辨率。
 * 
 * @param dpi 扫描仪支持的分辨率值，例如"200".
 * 
 * @return
 */
function switchDPI(dpi) {
	setConfigParam("scandpi", dpi);
}

/**
 * 设置单面或双面扫描。
 * 
 * @param flag 0单面，1双面。
 * @return
 */
function switchDuplex(flag) {
	setConfigParam("scanduplex", flag);
}

/**
 * 设置扫描色彩数。
 * 
 * @param flag 0黑白，1灰度，2彩色。
 * @return
 */
function switchColor(flag) {
	setConfigParam("scancolor", flag);
}


/**
 * 设置扫描时的单双面、分辨率、颜色位数参数。
 * 
 * @param name 参数名或参数对列表。若传入参数对数组，则格式为param[][2]，每一对参数第一个元素为名称，第二个元素为值。
 * @param value 参数值，可选，若第一个参数为参数对数组则忽略该参数。
 * @return
 */
function setConfigParam(name, value) {
	var paramXml = createParamXml("td0010"); // 创建XML基本结构
	var bodyNodes = Ext.query("body", paramXml);
	
	if (name instanceof Array) {
		var i = 0;
		for (; i < name.length; i++) {
			var paramElm = paramXml.createElement("param");
			paramElm.setAttribute("name", name[i][0]);
			paramElm.text = name[i][1];
			bodyNodes[0].appendChild(paramElm);
		}
	} else {
		var paramElm = paramXml.createElement("param");
		paramElm.setAttribute("name", name);
		paramElm.text = value;
		bodyNodes[0].appendChild(paramElm);
	}
	
	SunScan.CommOcxFunction(paramXml.xml);
}

/**
 * 设置水印。
 * 
 * @param content 文字内容。
 * @param config 水印配置信息。结构为：{WMWord: "内容", fontType: "字体", fontSize: "字体大小", fontColor: "字体颜色", xPos: "x坐标", yPos: "y坐标", rAngle: "角度"}。
 * @return
 */
function setWMWord(config) {
	var paramList = [config.WMWord, config.fontType, config.fontSize, config.fontColor, config.xPos, config.yPos, config.rAngle,config.path];
	paramList.cdataFlags = [0, 0, 0, 0, 0, 0, 0, 0];
	var ret=SunScan.CommOcxFunction(wrapInfo("td0014", paramList));
	return parseReturnMesg(ret);;
}

/**
 * 更新批次信息。
 * 
 * @param batchIndex 批次索引，从1开始。
 * @param busikey 节点关键字。
 * @param val 将要改为的值。
 * @return
 */
function updateBatchInfo(batchIndex, busikey, val) {
	var batchInfo = getBatchInfo();
	if (batchInfo.items.length > 0) {
		var tradeInfoXml = CDATAToXml(batchInfo.items[0]);
		var nodeXml = Ext.query("node", tradeInfoXml)[batchIndex - 1];
		var bsinfXml = Ext.query("bsinf[attr='"+ busikey +"']", nodeXml)[0];
		bsinfXml.text = val;
		
		var paramList = [batchIndex, nodeXml];
		paramList.cdataFlags = [0, 1];
		var updateParamXml = wrapInfo("td0020", paramList);
		
		SunScan.CommOcxFunction(updateParamXml);
	}
}

/**
 * 将参数信息封装成标准接口报文，返回封装后的XML字符串。
 * 
 * @param trdCode 交易代码。
 * @param paramInfoList 参数信息列表，若仅有一个参数则可直接传入无需构建数组，若无参数信息则可忽略该参数。
 * 	该参数对象可附加"cdataFlags"属性，其结构为[[0|1], [0|1],...]，按顺序描述对应的参数是否被封装进CDATA中，0表示不封装，1表示封装，默认自动封装。
 * @param retXml 可选。是否返回XML对象，异或是字符串。默认为false，返回字符串。
 * 
 * @return
 */
function wrapInfo(trdCode, paramInfoList, retXml) {
	var paramXml = createParamXml(trdCode); // 创建XML基本结构
	
	if (Ext.isEmpty(paramInfoList)) {
		return paramXml.xml; // 参数体为空，直接返回
	}
	
	var hasDesc = ! Ext.isEmpty(paramInfoList.cdataFlags);
	
	/*
	 * 设置参数信息
	 */
	var bodyNodes = Ext.query("body", paramXml);
	if (paramInfoList instanceof Array) {
		for (var i = 0; i < paramInfoList.length; i++) {
			var paramElm = paramXml.createElement("param");
			try {
				var paramStr = (paramInfoList[i].xml) ? paramInfoList[i].xml : paramInfoList[i]; 
				
				if (hasDesc && paramInfoList.cdataFlags[i] == 0) {
					paramElm.text = paramStr;
				} else {
					var paramdData = paramXml.createCDATASection(paramStr); // 用CDATA包装XML参数信息
					paramElm.appendChild(paramdData);
				}
			} catch (e) {
				// ignore
			}
			
			bodyNodes[0].appendChild(paramElm);
		}
	} else {
		var paramElm = paramXml.createElement("param");
		try {
			var paramStr = (paramInfoList.xml) ? paramInfoList.xml : paramInfoList; 
			
			if (hasDesc && paramInfoList.cdataFlags[0] == 0) {
				paramElm.text = paramStr;
			} else {
				var paramdData = paramXml.createCDATASection(paramStr); // 用CDATA包装XML参数信息
				paramElm.appendChild(paramdData);
			}
		} catch (e) {
			// ignore
		}
		
		bodyNodes[0].appendChild(paramElm);
	}
	
	var isReturnXmlObj = false;
	
	if (arguments.length == 3 && (typeof arguments[2] == "boolean")) {
		isReturnXmlObj = arguments[2];
	}
	
	return isReturnXmlObj ? paramXml : paramXml.xml;
}


/**
 * 创建业务信息。
 * 
 * @param docType 文档类型英文名。
 * @param operType 操作类型分为0[新增]，1[修改],2[只读查询]。
 * @param filter 上传或查询的关键字列表。
 * 
 * @return
 */
function createTradeInfo(docType, operType, filter) {
	var now = new Date();
	var xmlStr = xmlTemplate;
	xmlStr += "<root>" + "<business appid='Y002' appname='贷款资料' tradecode='JKDS' tradename='贷款资料' optiontype='" + operType + "' tradedate='" + now.format("yyyyMMdd") + "' tradeuser='" + account.oper + "' objname='" + docType + "' user='" + account.uid + "' pwd='" + account.passwd + "' isenc='0'>";
	xmlStr += "<node>";
	
	try {
		if (! Ext.isEmpty(filter)) {
			var i = 0;
			for (; i < filter.length; i++) {
				xmlStr += "<bsinf attr='" + filter[i][0] + "' disp='关键字' isquery='" + ((filter[i][2]) ? filter[i][2] : 0) + "'>" + filter[i][1] + "</bsinf>";
			}
		}
	} catch (e) {
		alert("传入影像控件的参数有误！");
	}
	
	xmlStr += "</node></business></root>";
	
	return xmlStr;
}

/**
 * 创建业务信息(多批次)。
 * 
 * @param docType 文档类型英文名。
 * @param mode 操作类型分为0[新增]，1[修改]。
 * @param keylist 创建批次所需的自定义信息列表。
 * 
 * @return 业务信息的Xml字符串。
 */
function createTradeInfo2(docType, mode, keylist) {
	var now = new Date();
	var xmlStr = xmlTemplate;
	var kl = (keylist) ? keylist : getDefaultKeyList();
	xmlStr += "<root>" + "<business appid='Y002' appname='贷款资料' tradecode='JKDS' tradename='贷款资料' optiontype='" + mode + "' tradedate='" + now.format("yyyyMMdd") + "' tradeuser='" + account.oper + "' objname='" + docType + "' user='" + account.uid + "' pwd='" + account.passwd + "' isenc='0'>";
	
	try {
		xmlStr += "<node>";
		for (var i = 0; i < kl.length; i++) {
			var isquery = (kl[i].filterType) ? kl[i].filterType : '1';
			xmlStr += "<bsinf attr='" + kl[i].key + "' disp='关键字' isquery='" + isquery + "'>" + kl[i].val + "</bsinf>";
		}
		xmlStr += "</node>";
	} catch (e) {
		alert("传入影像控件的参数有误！");
	}
	
	xmlStr += "</business></root>";
	
	return xmlStr;
}


/**
 * 创建树结构信息。
 * 
 * @param treeInfo 自定义的文档类型结构信息，须从预定义模板docTemplate中选取。若忽略该参数，则会使用预定义模板。
 * 
 * @return 树结构的Xml字符串。
 */
function createTree2(treeInfo) {
	var xmlStr = xmlTemplate;
	xmlStr += "<root><tree appid='Y002' appname='贷款资料' tradecode='JKDS' tradename='薪易贷'>";
	
	var template = (Ext.isEmpty(treeInfo)) ? getDefaultDocTemplate() : treeInfo;
	
	/**
	 * 递归处理子节点。
	 * 
	 * @param nodeObj 节点信息对象。
	 * @param str 待拼装的字符串。
	 * @return
	 */
	var treatNodes = function(nodeObj) {
		var nodeType = (nodeObj.nodeType) ? nodeObj.nodeType : '1'; // 仅根节点可用'0'，其他子节点都须用'1'
		
		var str = "<node name='" + nodeObj.nodeKey + "' desc='" + nodeObj.nodeName + "' isimage='" + nodeObj.includeImg + "' barcode='" + nodeObj.nodeBarcode + "' forms='2343;3434;55;' attri='" + nodeType + "'";
		
		if (nodeObj.children && nodeObj.children.length) {
			str += ">";
			for (var i = 0; i < nodeObj.children.length; i++) {
				str += treatNodes(nodeObj.children[i]);
			}
			str += "</node>";
		} else {
			str += "/>";
		}
		return str;
	}
	
	xmlStr += treatNodes(template);
	
	xmlStr += "</tree></root>";
	
	return xmlStr;
}

/**
 * 设置操作账户信息。
 * 
 * @param acc 对象结构为{oper:"", uid:"", passwd:""}，oper:当前操作员，uid:ecm上的用户，passwd:ecm用户密码。
 * @return
 */
function setAccount(acc) {
	account.oper = acc.oper;
	account.uid = acc.uid;
	account.passwd = acc.passwd;
}



/**
 * 创建参数XML对象。
 * 
 * @param trdCode 交易代码。
 * 
 * @return
 */
function createParamXml(trdCode) {
	var paramXml = createXML(paramTemplate); // 创建XML基本结构
	
	/*
	 * 设置交易代码
	 */
	var trdNodes = Ext.query("transcode", paramXml);
	trdNodes[0].text = trdCode;
	return paramXml;
}

/**
 * 以XML字符串创建XML对象。
 * 
 * @param xmlStr
 * @return
 */
function createXML(xmlStr) {
	var xmlDoc = null;  
	if (window.DOMParser){// Mozilla Explorer  
		var parser = new DOMParser();  
		xmlDoc = parser.parseFromString(xmlStr, "text/xml");  
	} else {// Internet Explorer  
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");  
		xmlDoc.async = "false";  
		xmlDoc.loadXML(xmlStr);  
	}
	return xmlDoc;
}

/**
 * 将CDATA包裹的字符串转换为XML数据。
 * 
 * @param cdata 起始为"<![CDATA["，结束为"]]>"的字符串。
 * @return 返回由XML对象。
 */
function CDATAToXml(cdata) {
	var ret = null;
	if (cdata) {
		try {
			var content = cdata.substring(9, cdata.length - 3);
			ret = createXML(content);
		} catch (e) {
			// TODO: handle exception
		}
	}
	
	return ret;
}

/**
 * 时间对象的格式化
 */
Date.prototype.format = function(format) {
	/*
	 * format="yyyy-MM-dd hh:mm:ss";
	 */
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"H+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	};

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}
/**
 * 查询影像。
 *@para barCode流程编号 certNo证件号码 contractId合同编号 mode 控件模式（0：新增 1：修改 2：只读查询 3：部分修改 4:历史影像）  前三者至少输入一个，最后一个参数不输的话，默认为2，建议审核审批岗需要进行修改的传3   
 * 注：只查询进入录入岗
 * @return
 */
function queryImgInfo(barCode,certNo,contractId,mode){
	var m = (mode) ? mode : 2;
	if(barCode===''&&certNo==''&&contractId===''){
		return alert('至少输入一个查询条件');
	}
	window.open(web_base_path+"fctModules/commSunImg.jsp?barCode="+barCode+"&certNo="+certNo+"&contractId="+contractId+"&mode="+m+"");
}
/**
 * Ext.Msg.alert之前，将空间隐藏。
 * 
 * @return
 */
 function alertbefore(div){
 	//$(div).style.display = "none";
 }
 /**
 * Ext.Msg.alert之后，将空间显示。
 * 
 * @return
 */
 function alertAfter(div){
 	//$(div).style.display = "inline";
 }
 /**
 * 获取树信息对象
 * 
 * @return
 */
 function getDocTreeInfo(disp){
 	var template = {
	            	nodeKey: 'BARCODE', // 存储、查询关键字
	            	nodeName: disp+'_', // 界面显示名
	            	includeImg: '1', // 是否可直接下挂影像1=N,2=Y
	            	nodeBarcode: 'D-001', // 影像资料类别识别条码，对于根节点无效
	            	nodeType: '0', // 根节点特殊固定为0，所有子节点固定为1
	            	children: [
			            	{
			            		nodeKey: 'OTHER',
			            		nodeName: '其他',
			            		includeImg: '2',
			            		nodeBarcode: 'T-001'
			            	},
			            	{
			            		nodeKey: 'RECYCLE',
			            		nodeName: '回收站',
			            		includeImg: '2',
			            		nodeBarcode: '000000000'
			            	}
	            	]
	            }
	         template.addChild = function (key,name,img,bar){
	         	var child={
	         		nodeKey: key,
            		nodeName: name,
            		includeImg: img,
            		nodeBarcode: bar
	         	}
	         	template.children.unshift(child);
	         	
	         } 
	         return template;
 }
 /**
  *加载影像控件
  */
function initObject(divName){
	var sun=document.getElementById('SunScan');
	var obje='<OBJECT ID="SunScan" WIDTH="100%" HEIGHT="450" CLASSID="CLSID:da9a1a4f-435c-4bcf-836a-f354af7dfb36"> </OBJECT> ';
	if(sun==null){
		$(divName).insertAdjacentHTML("afterEnd",obje);
	}else{
		$('SunScan').replace(obje);
	}
}
/**
  *动态生成树结构
  *flag 0:正式件 1：补件 2：补件复核  使用此方法，必须在jsp页面引用<%@ include file ="../imgbusi/imgParameter.jsp" %>
*/
function getDynamicTreeInfo(flag,hasRec){
		var template = {
	            	nodeKey: 'BARCODE', // 存储、查询关键字
	            	nodeName: '影像_', // 界面显示名
	            	includeImg: '1', // 是否可直接下挂影像1=N,2=Y
	            	nodeBarcode: 'D-001', // 影像资料类别识别条码，对于根节点无效
	            	nodeType: '0',
	            	children:new Array()
	     };
		
	
		var typeArr=imgTypeArr;
		var childre=new Array();
	
		for(var i=0;i<typeArr.length-1;i++){
				var imgtype=typeArr[i].split(':');
				var temp={nodeKey:'',nodeName:'',includeImg:'',nodeBarcode:''};
				temp.nodeKey=imgtype[1];
				temp.nodeName=imgtype[2];
				temp.includeImg='2';
				temp.nodeBarcode=imgtype[0];
				childre.push(temp);	
				
		}
		template.children=childre;

	return template;
	
}

/**
 *动态生成树结构
 *flag 0:正式件 1：补件 2：补件复核  使用此方法，必须在jsp页面引用<%@ include file ="../imgbusi/imgParameter.jsp" %>
*/
function getDynamicTreeInfoUaf(flag,hasRec){

		var template = {
	            	nodeKey: 'BARCODE', // 存储、查询关键字
	            	nodeName: '补件复核_', // 界面显示名
	            	includeImg: '1', // 是否可直接下挂影像1=N,2=Y
	            	nodeBarcode: 'D-001', // 影像资料类别识别条码，对于根节点无效
	            	nodeType: '0',
	            	children:new Array()
	     };
		if(flag==1){
			template.nodeName='补件_';
		}else if(flag==2){
			template.nodeName='补件复核_';
		}else{
			template.nodeName='影像_';
		}
		var typeArr=imgTypeArr;
		var childre=new Array();
		var children1=new Array();
		if(flag!=1){
			for(var i=0;i<typeArr.length-1;i++){
					var imgtype=typeArr[i].split(':');
					if(imgtype[0]=="T-002"){
						var temp={nodeKey:'',nodeName:'',includeImg:'',nodeBarcode:''};
						temp.nodeKey=imgtype[1];
						temp.nodeName=imgtype[2];
						temp.includeImg='2';
						temp.nodeBarcode=imgtype[0];
						childre.push(temp);	
						break;
						}
				
				
			}
			template.children=childre;
		}
		if(flag!=0){
			template.children.push({
				nodeKey: 'REPAIR',
	       		nodeName: '补件',
	       		includeImg: '1',
	       		nodeBarcode: 'REPAIR'
			});
			for(var j=0;j<typeArr.length-1;j++){
				var imgtype=typeArr[j].split(':');
					var temp={nodeKey:'',nodeName:'',includeImg:'',nodeBarcode:''};
					temp.nodeKey=retpairFlag+imgtype[1]
					temp.nodeName=imgtype[2];
					temp.includeImg='2';
					temp.nodeBarcode=imgtype[0];
					children1.push(temp);	
				
			}
			template.children[template.children.length-1].children=children1;
		}
		if(hasRec==0){
			template.children.push({
				nodeKey: 'RECYCLE',
	        	nodeName: '回收站',
	        	includeImg: '2',
	        	nodeBarcode: '000000000'
			});
		}
	return template;
	
}






/**
  *剔除空白页
  *flag 0:正式件 1：补件 2：补件复核  使用此方法，必须在jsp页面引用<%@ include file ="../imgbusi/imgParameter.jsp" %>
*/
function move4balnks(flag){
	var typeArr=imgTypeArr;
	if(flag==0){
		for(var i=0;i<typeArr.length-1;i++){
			var imgtype=typeArr[i].split(':');
			move4Blank(1,imgtype[1]);
		}
	}else{
		for(var i=0;i<typeArr.length-1;i++){
			var imgtype=typeArr[i].split(':');
			move4Blank(1,retpairFlag+imgtype[1]);
		}
	}
	
	
}
