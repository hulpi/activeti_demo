/**
 * 任务办理
 */
$(function() {
	
    $('.claim').button({
        icons: {
            primary: 'ui-icon-person'
        }
    });
    
    $('.handle').button({
        icons: {
            primary: 'ui-icon-comment'
        }
    }).click(handle);
    
    //$('.trace').click(graphTrace);
    
});


// 用于保存加载的详细信息
var detail = {};

/**
 * 加载详细信息
 * @param {Object} id
 */
function loadDetail(id, taskId, callback) {

    var dialog = this;
    $.getJSON(ctx + '/approval/detail/' + id, function(data) {
        detail = data;
        $.each(data, function(k, v) {
			if (k == 'applyTime') {
				$('.view-info td[name=' + k + ']', dialog).text(new Date(v).format('yyyy-MM-dd hh:mm'));
			} else {
	            $('.view-info td[name=' + k + ']', dialog).text(v);
			}
			
        });
        var ruleInfo = data.ruleInfo;
        //alert(ruleInfo.resultName);
        $('.rule-info').show().html(ruleInfo.code + " " + ruleInfo.resultName + " " + ruleInfo.resultDescription + "<br/>");
        
		if ($.isFunction(callback)) {
			callback(data,taskId,id);
		}
    });
}

/**
 * 加载详细信息，同时读取流程任务变量
 * @param {Object} id
 */
function loadDetailWithTaskVars(id, taskId, callback) {
    var dialog = this;
    if(id == null || id == '') {
    	return;
    }
    $.getJSON(ctx + '/approval/detailWithVars/' + id + "/" + taskId, function(data) {
        detail = data;
        /*
        $.each(data, function(k, v) {

			if (k == 'applyTime') {
				$('.view-info td[name=' + k + ']', dialog).text(new Date(v).format('yyyy-MM-dd hh:mm'));
			} else {
	            $('.view-info td[name=' + k + ']', dialog).text(v);
			}
			
        });
        */
		if ($.isFunction(callback)) {
			callback(data);
		}
    });
}

/**
 * 分析
 * @param {Object} businessKey
 */
function analyze(businessKey, variables) {
    var dialog = this;
    alert("财务分析 " + businessKey);
    var keys = "", values = "", types = "";
	if (variables) {
		$.each(variables, function() {
			if (keys != "") {
				keys += ",";
				values += ",";
				types += ",";
			}
			keys += this.key;
			values += this.value;
			types += this.type;
		});
	}
	
}

/**
 * 分析
 * @param {Object} businessKey
 */
function judge(businessKey, variables) {
    var dialog = this;
    alert("资信评级 " + businessKey);
    var keys = "", values = "", types = "";
	if (variables) {
		$.each(variables, function() {
			if (keys != "") {
				keys += ",";
				values += ",";
				types += ",";
			}
			keys += this.key;
			values += this.value;
			types += this.type;
		});
	}
	
}

/**
 * 完成任务
 * @param {Object} taskId
 */
function complete(taskId, variables) {
    var dialog = this;
    
    var keys = "", values = "", types = "";
	if (variables) {
		$.each(variables, function() {
			if (keys != "") {
				keys += ",";
				values += ",";
				types += ",";
			}
			keys += this.key;
			values += this.value;
			types += this.type;
		});
	}
	
	$.blockUI({
        message: '<h2><img src="' + ctx + '/images/ajax/loading.gif" align="absmiddle"/>正在提交请求……</h2>'
    });
	
	// 发送任务完成请求
    $.post(ctx + '/approval/complete/' + taskId, {
        keys: keys,
        values: values,
        types: types
    }, function(resp) {
		$.unblockUI();
        if (resp == 'success') {
            //alert('任务完成');
            location.reload();
        } else {
            alert('操作失败!');
        }
    });
}

function gotoModifyPage(businessKey) {
	//location.replace("../loanApply/apply_info.jsp?id="+businessKey);
	location.replace("../getApplyInfoByGuarantId?guarantId="+businessKey);
}

function print(businessKey) {
	alert("开始打印： " + businessKey);
}


/*
 * 使用json方式定义每个节点的按钮
 * 以及按钮的功能
 * 
 * open:打开对话框的时候需要处理的任务
 * btns:对话框显示的按钮
 */
var handleOpts = {
	check: {
		width: 800,
		height: 600,
		open: function(id,taskId) {
			loadDetail.call(this, id, taskId);
		},
		btns: [{
			text: '财务分析',
			click: function() {
				var businessKey = $(this).data('id');

				analyze(businessKey, [{
					key: 'hasPass',
					value: true,
					type: 'B'
				}]);
			}
		}, {
			text: '资信评级',
			click: function() {
				var businessKey = $(this).data('id');
				judge(businessKey, [{
					key: 'hasPass',
					value: true,
					type: 'B'
				}]);
			}
		}, {
			text: '通过',
			click: function() {
				var taskId = $(this).data('taskId');
				$('<div/>', {
					title: '初审意见',
					html: "<textarea id='checkerPassReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					open: function() {
						
					},
					buttons: [{
						text: '同意',
						click: function() {
							var checkerPassReason = $('#checkerPassReason').val();
							if (checkerPassReason == '') {
								alert('请输入初审意见！');
								return;
							}
							
							complete(taskId, [{
								key: 'hasPass',
								value: true,
								type: 'B'
							}, {
								key: 'checkerPassReason',
								value: checkerPassReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#check').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '驳回',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '驳回理由',
					html: "<textarea id='checkerBackReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					open: function() {
						
					},
					buttons: [{
						text: '驳回',
						click: function() {
							var checkerBackReason = $('#checkerBackReason').val();
							if (checkerBackReason == '') {
								alert('请输入驳回理由！');
								return;
							}
							
							complete(taskId, [{
								key: 'hasPass',
								value: false,
								type: 'B'
							}, {
								key: 'checkerBackReason',
								value: checkerBackReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#check').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	},
	audit: {
		width: 800,
		height: 600,
		open: function(id) {
			loadDetail.call(this, id);
		},
		btns: [{
			text: '通过',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '审核意见',
					html: "<textarea id='auditorPassReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '同意',
						click: function() {
							var auditorPassReason = $('#auditorPassReason').val();
							if (auditorPassReason == '') {
								alert('请输入审核意见！');
								return;
							}
							complete(taskId, [{
								key: 'hasPass',
								value: true,
								type: 'B'
							}, {
								key: 'auditorPassReason',
								value: auditorPassReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '驳回',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '驳回理由',
					html: "<textarea id='auditorBackReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '驳回',
						click: function() {
							var auditorBackReason = $('#auditorBackReason').val();
							if (auditorBackReason == '') {
								alert('请输入驳回理由！');
								return;
							}
							complete(taskId, [{
								key: 'hasPass',
								value: false,
								type: 'B'
							}, {
								key: 'auditorBackReason',
								value: auditorBackReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	},
	approve: {
		width: 800,
		height: 600,
		open: function(id) {
			loadDetail.call(this, id);
		},
		btns: [{
			text: '通过',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '审批意见',
					html: "<textarea id='approverPassReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '同意',
						click: function() {
							var approverPassReason = $('#approverPassReason').val();
							if (approverPassReason == '') {
								alert('请输入审批意见！');
								return;
							}
							complete(taskId, [{
								key: 'action',
								value: 'pass',
								type: 'S'
							}, {
								key: 'approverPassReason',
								value: approverPassReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		},{
			text: '上报高级',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '上报意见',
					html: "<textarea id='approverUpReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '提交',
						click: function() {
							var approverUpReason = $('#approverUpReason').val();
							if (approverUpReason == '') {
								alert('请输入上报意见！');
								return;
							}
							complete(taskId, [{
								key: 'action',
								value: 'advance',
								type: 'S'
							}, {
								key: 'approverUpReason',
								value: approverUpReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '驳回',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '驳回理由',
					html: "<textarea id='approverBackReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '驳回',
						click: function() {
							var approverBackReason = $('#approverBackReason').val();
							if (approverBackReason == '') {
								alert('请输入驳回理由！');
								return;
							}
							complete(taskId, [{
								key: 'action',
								value: 'reject',
								type: 'S'
							}, {
								key: 'approverBackReason',
								value: approverBackReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	},
	advanceApprove: {
		width: 800,
		height: 600,
		open: function(id) {
			loadDetail.call(this, id);
		},
		btns: [{
			text: '通过',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '审批意见',
					html: "<textarea id='advanceApproverPassReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '同意',
						click: function() {
							var advanceApproverPassReason = $('#advanceApproverPassReason').val();
							if (advanceApproverPassReason == '') {
								alert('请输入审批意见！');
								return;
							}
							complete(taskId, [{
								key: 'hasPass',
								value: true,
								type: 'B'
							}, {
								key: 'advanceApproverPassReason',
								value: advanceApproverPassReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '驳回',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '驳回理由',
					html: "<textarea id='advanceApproverBackReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '驳回',
						click: function() {
							var advanceApproverBackReason = $('#advanceApproverBackReason').val();
							if (advanceApproverBackReason == '') {
								alert('请输入驳回理由！');
								return;
							}
							complete(taskId, [{
								key: 'hasPass',
								value: false,
								type: 'B'
							}, {
								key: 'advanceApproverBackReason',
								value: advanceApproverBackReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#audit').dialog('close');
						}
					}]
				});
			}
		}, {
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	},
	back: {
		width: 800,
		height: 600,
		open: function(id, taskId) {
			var dialog = this;
			$('.back-info').show().html("");
			
			loadDetailWithTaskVars.call(this, id, taskId, function(data) {
				$('.back-info').show().html("<b>初审意见：</b><br/>" + (data.variables.checkerBackReason || "") + "<br/>");
				$('#modifyApplyContent #guaranId').val(data.guarant_id);
			});
			/*
			$("#radio").buttonset().change(function(){
				var type = $(':radio[name=reApply]:checked').val();
				if (type == 'true') {
					$('#modifyApplyContent').show();
				} else {
					$('#modifyApplyContent').hide();
				}
			});*/
		},
		btns: [{
			text: '调整申请',
			click: function() {
				var businessKey = $(this).data('id');
				gotoModifyPage(businessKey);
			}
		},{
			text: '放弃申请',
			click: function() {
				var taskId = $(this).data('taskId');
				
				complete(taskId, [{
					key: 'hasPass',
					value: false,
					type: 'B'
				}]);
			}
		},{
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	},
	print: {
		width: 800,
		height: 600,
		open: function(id, taskId) {
			loadDetail.call(this, id, taskId);
			
		},
		btns: [{
			text: '打印担保合同',
			click: function() {
				var businessKey = $(this).data('id');
				print(businessKey);
				
			}
		},{
			text: '结束审批流程',
			click: function() {
				var taskId = $(this).data('taskId');
				
				print(taskId, [{
					key: 'hasPass',
					value: true,
					type: 'B'
				}]);
			}
		},{
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	}
};

/**
 * 办理流程
 */
function handle() {
	// 当前节点的英文名称
	var tkey = $(this).attr('tkey');
	
	// 当前节点的中文名称
	var tname = $(this).attr('tname');
	
	//ID
	var rowId = $(this).parents('tr').attr('id');
	
	// 任务ID
	var taskId = $(this).parents('tr').attr('tid');
	
	// 使用对应的模板
	$('#' + tkey).data({
		taskId: taskId,
		id: rowId
	}).dialog({
		title: '流程办理[' + tname + ']',
		modal: true,
		width: handleOpts[tkey].width,
		height: handleOpts[tkey].height,
		open: function() {
			handleOpts[tkey].open.call(this, rowId, taskId);
		},
		buttons: handleOpts[tkey].btns
	});
}

Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1, //month 
        "d+": this.getDate(), //day 
        "h+": this.getHours(), //hour 
        "m+": this.getMinutes(), //minute 
        "s+": this.getSeconds(), //second 
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter 
        "S": this.getMilliseconds() //millisecond 
    }
    if (/(y+)/.test(format)) 
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) 
        if (new RegExp("(" + k + ")").test(format)) 
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}