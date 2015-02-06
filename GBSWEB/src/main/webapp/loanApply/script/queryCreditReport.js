
/**
 * 代查征信报告按钮，点击后触发函数；主要完成密码校验，文件上传，发送代查接口
 * @param apply_code
 * @returns
 */
function queryReport(apply_code){
	if(''==apply_code||apply_code==null||apply_code=='null'){
		return Ext.Msg.alert('温馨提示','请先保存后，再查询！');
	}
	buildAddFileForm(apply_code);
//	PasswordConfirmation('lwq');
}
function buildAddFileForm(apply_code){
	var PassPanel= new Ext.form.FormPanel({
		buttonAlign:'center',
		closable:true,
		id:'user_modify_panel',
		labelWidth: 70,
		autoWidth: true,
		frame:true,
		defaultType: 'textfield',
		bodyStyle:'padding:8px 0 0 9px;',	
		fileUpload: true,  
		items:[{
			fieldLabel:'申请编号',
			 xtype:'textfield',
			disabled:true,
			value : apply_code,
			width:230,
			maxLength: 20,
			allowBlank:false
		}
		, {
            xtype:'textfield',
            allowBlank:false,
            fieldLabel:'选择文件',
            inputType:'file',
            enctype : 'multipart/form-data',
            name:'fileName'
            
        },{
			fieldLabel:'工号',
			id : 'USER_ID',
			xtype:'textfield',
			disabled:false,
			width:230,
			maxLength: 20,
			allowBlank:false
		},
		{
			fieldLabel:'密码',
			id : 'PASSWORD',
		    xtype:'textfield',
			inputType:'password',
			disabled:false,
			width:230,
			maxLength: 20,
			allowBlank:false
		}]
	});
	var win_userquery = new Ext.Window({
		layout:'fit',
		title : '',
		width: 370,
		resizable : false,
		//height:280,
		autoHeight: true,
		plain: true,
		closable:true,
		buttonAlign: 'center',
		modal: true,
		collapsible:false,
			maximizable:false,
		items:[PassPanel],
		buttons:[{
			text:'确定',
			handler:function() {
				var saveResult;
				if (PassPanel.form.isValid()) {
					Ext.MessageBox.show({
					title : '请稍等',
					msg : '正在保存信息...',
					width : 300,
					progress : true,
					closable : false,
					animEl : 'loading'
					});
					// 控制进度速度
					function f(v) {
						return function() {
							var i = v / 11;
							Ext.MessageBox.updateProgress(i, '');
						};
					}
					for(var i = 1; i < 13; i++){setTimeout(f(i), i * 150);}		
					var USER_ID=PassPanel.getComponent('USER_ID').getValue();	
					var PASSWORD=PassPanel.getComponent('PASSWORD').getValue();
					if(USER_ID==''||PASSWORD==''){
						Ext.MessageBox.hide();
						return Ext.Msg.alert('温馨提示','用户名密码不能为空');
					}
					Ext.Ajax.request({
						   params: {
							   userid:USER_ID,
							   password:PASSWORD,
							   branchNeed:'need'  //校验是否为分行主管
						   },
						   method : 'POST',
						   url:web_base_path+'param/ParameterAction.action?flag=32',
						   callback:function(options,success,response){
							   var data=response.responseText;	
							   if(data=='false'){
									return Ext.MessageBox.alert('温馨提示','密码输入有误，请重新输入!');									
								}else{
									PassPanel.form.doAction('submit', {
										url : web_base_path + 'mainApply/CreditReportFile.jsp?apply_code='+apply_code,						
										success : function(form, action) {
											 Ext.MessageBox.hide();
											Ext.Msg.alert('提示',action.result.msg);		
											win_userquery.close();
										},
										failure : function(){ Ext.MessageBox.hide();Ext.Msg.alert('错误', '服务器出现错误,请稍后再试！');}
									});
								}
						   }
						});					
			}
			}
		}, {
			text:'关闭',
			handler:function(){win_userquery.close(); }
		}
			]
	});
	win_userquery.setTitle('代查征信报告');
	win_userquery.show();
}

/**
 * 打开附件功能，点击影像按钮触发函数
 * @param apply_code
 */
function operFile(apply_code){
	window.open( web_base_path + 'fct/queryFile.jsp?apply_code='+apply_code);
}

/**
 * 打印申请表
 * @return
 */
function printSqb(){
	window.open(web_base_path+'print/dbd_sqb.jsp?apply_code='+apply_code+'&only_id='+only_id,'','width=790px,height=690px,status=no,scrollbars=yes');
}
/**
 * 打印审批表
 * @return
 */
function printSpb(){
	window.open(web_base_path+'print/dbd_spb.jsp?apply_code='+apply_code,'','width=790px,height=690px,status=no,scrollbars=yes');
}
	