	//点击确认发放
	function buildSureForm(){
		var branch = document.getElementById('sqdId').contentWindow.document.getElementById('SQD_LOAN_BRANCH').value;
		if(branch==''){
			branch=curBranch;
		}
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
				fieldLabel:'工号',
				id : 'USER_ID',
				xtype:'textfield',
				disabled:false,
				width:230,
				maxLength: 20,
				allowBlank:false
			},{
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
								   branch:branch
							   },
							   method : 'POST',
							   url:web_base_path+'param/ParameterAction.action?flag=39',
							   callback:function(options,success,response){
								   var data=response.responseText;	
								   if(data=='false'){
										return Ext.MessageBox.alert('温馨提示','密码输入有误，请重新输入!');									
									}else{
										submitData('1');
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
		win_userquery.setTitle('确认发放');
		win_userquery.show();
	}
	
	/**所有页面必填项校验*/
	function allCustVerify(station){
		var tabs = Ext.getCmp("tabs0");
		var panels = tabs.items.items;
		if(station=="A1"){//录入岗校验申请单资料和申请人资料
			for (var i = 0, len = panels.length; i < len; ++i) { 
				if(panels[i].title.indexOf('申请单资料')!=-1){
					tabs.setActiveTab(panels[i].id);
					var frameWin = panels[i].body.dom.getElementsByTagName('iframe')[0].contentWindow;
					var btn=frameWin.document.getElementById('sqdLoanButton').click();
					if(checkFlag){
						return;
					}
				}
			}
			for (var i = 0, len = panels.length; i < len; ++i) { 
				if(panels[i].title.indexOf('申请人资料')!=-1){
					tabs.setActiveTab(panels[i].id);
					var frameWin = panels[i].body.dom.getElementsByTagName('iframe')[0].contentWindow;
					var btn=frameWin.document.getElementById('appLoanButton').click();
					var chen=frameWin.document.getElementById('appLenButton').click();
					if(checkFlag){
						return;
					}
				}
			}
		}
		if(station!="A1"){//审核,审批,放款岗校验批核信息
			for (var i = 0, len = panels.length; i < len; ++i) {
				if(panels[i].title.indexOf('批核信息')!=-1){
					tabs.setActiveTab(panels[i].id);
					var frameWin = panels[i].body.dom.getElementsByTagName('iframe')[0].contentWindow;
					var btn=frameWin.document.getElementById('loanApproveButton').click();
					if(checkFlag){
						return;
					}
				}
			}
		}
	tabs.setActiveTab(0);
	return true;
}
	//长度校验
	function allPageVerifyLen(station){
		var tabs = Ext.getCmp("tabs0");
		var panels = tabs.items.items;
		if(station=="A1"){
			for (var i = 0, len = panels.length; i < len; ++i) { 
				if(panels[i].title.indexOf('申请人资料')!=-1){
					tabs.setActiveTab(panels[i].id);
					var frameWin = panels[i].body.dom.getElementsByTagName('iframe')[0].contentWindow;
					var chen=frameWin.document.getElementById('appLenButton').click();
					if(checkLenFlag){
						return;
					}
				}
			}
		}
		/*if(station!="A1"){
			for (var i = 0, len = panels.length; i < len; ++i) {
				if(panels[i].title.indexOf('批核信息')!=-1){
					tabs.setActiveTab(panels[i].id);
					var frameWin = panels[i].body.dom.getElementsByTagName('iframe')[0].contentWindow;
					var btn=frameWin.document.getElementById('loanApproveButton').click();
					if(checkLenFlag){
						return;
					}
				}
			}
		}*/
	tabs.setActiveTab(0);
	return true;
}