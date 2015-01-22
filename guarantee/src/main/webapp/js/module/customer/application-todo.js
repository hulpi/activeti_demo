/**
 * 申请流程任务办理
 */
$(function() {

    // 签收
    $('.claim').button({
        icons: {
            primary: 'ui-icon-person'
        }
    });
    
    // 办理
    $('.handle').button({
        icons: {
            primary: 'ui-icon-comment'
        }
    }).click(handle);
    
    // 跟踪
    $('.trace').click(graphTrace);
    
});


// 用于保存加载的详细信息
var detail = {};

/**
 * 加载详细信息
 * @param {Object} id
 */
function loadDetail(id, withVars, callback) {
    var dialog = this;
    $.getJSON(ctx + '/customer/apply/detail/' + id, function(data) {
        detail = data;
        $.each(data, function(k, v) {
			
			// 格式化日期
			if (k == 'applyTime') {
				$('.view-info td[name=' + k + ']', dialog).text(new Date(v).format('yyyy-MM-dd hh:mm'));
			} else {
	            $('.view-info td[name=' + k + ']', dialog).text(v);
			}
			
        });
		if ($.isFunction(callback)) {
			callback(data);
		}
    });
}

/**
 * 加载详细信息，同时读取流程任务变量
 * @param {Object} id
 */
function loadDetailWithTaskVars(id, taskId, callback) {
    var dialog = this;
    $.getJSON(ctx + '/customer/apply/detail-with-vars/' + id + "/" + taskId, function(data) {
        detail = data;
        $.each(data, function(k, v) {
            // 格式化日期
			if (k == 'applyTime') {
				$('.view-info td[name=' + k + ']', dialog).text(new Date(v).format('yyyy-MM-dd hh:mm'));
			} else {
	            $('.view-info td[name=' + k + ']', dialog).text(v);
			}
        });
		if ($.isFunction(callback)) {
			callback(data);
		}
    });
}

/**
 * 完成任务
 * @param {Object} taskId
 */
function complete(taskId, variables) {
    var dialog = this;
    
	// 转换JSON为字符串
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
    $.post(ctx + '/customer/apply/complete/' + taskId, {
        keys: keys,
        values: values,
        types: types
    }, function(resp) {
		$.unblockUI();
        if (resp == 'success') {
            alert('任务完成');
            location.reload();
        } else {
            alert('操作失败!');
        }
    });
}


/*
 * 使用json方式定义每个节点的按钮
 * 以及按钮的功能
 * 
 * open:打开对话框的时候需要处理的任务
 * btns:对话框显示的按钮
 */
var handleOpts = {
	//deptLeaderAudit: {
	usertask1: {
		width: 300,
		height: 300,
		open: function(id) {
			
			// 打开对话框的时候读取请假内容
			loadDetail.call(this, id);
		},
		btns: [{
			text: '同意',
			click: function() {
				var taskId = $(this).data('taskId');
				
				// 设置流程变量
				complete(taskId, [{
					key: 'isPass',
					value: true,
					type: 'B'
				}]);
			}
		}, {
			text: '驳回',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '填写驳回理由',
					html: "<textarea id='leaderBackReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					open: function() {
						
					},
					buttons: [{
						text: '驳回',
						click: function() {
							var leaderBackReason = $('#leaderBackReason').val();
							if (leaderBackReason == '') {
								alert('请输入驳回理由！');
								return;
							}
							
							// 设置流程变量
							complete(taskId, [{
								key: 'isPass',
								value: false,
								type: 'B'
							}, {
								key: 'leaderBackReason',
								value: leaderBackReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#usertask1').dialog('close');
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
	usertask2: {
		width: 300,
		height: 300,
		open: function(id) {
			// 打开对话框的时候读取请假内容
			loadDetail.call(this, id);
		},
		btns: [{
			text: '同意',
			click: function() {
				var taskId = $(this).data('taskId');
				
				// 设置流程变量
				complete(taskId, [{
					key: 'isPass',
					value: true,
					type: 'B'
				}]);
			}
		}, {
			text: '驳回',
			click: function() {
				var taskId = $(this).data('taskId');
				
				$('<div/>', {
					title: '填写驳回理由',
					html: "<textarea id='hrBackReason' style='width: 250px; height: 60px;'></textarea>"
				}).dialog({
					modal: true,
					buttons: [{
						text: '驳回',
						click: function() {
							var hrBackReason = $('#hrBackReason').val();
							if (hrBackReason == '') {
								alert('请输入驳回理由！');
								return;
							}
							
							// 设置流程变量
							complete(taskId, [{
								key: 'isPass',
								value: false,
								type: 'B'
							}, {
								key: 'hrBackReason',
								value: hrBackReason,
								type: 'S'
							}]);
						}
					}, {
						text: '取消',
						click: function() {
							$(this).dialog('close');
							$('#deptLeaderAudit').dialog('close');
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
	usertask3: {
		width: 500,
		height: 470,
		open: function(id, taskId) {
			var dialog = this;
			
			$('#startTime,#endTime', this).datetimepicker({
	            stepMinute: 5
	        });
			
			// 打开对话框的时候读取请假内容
			loadDetailWithTaskVars.call(this, id, taskId, function(data) {
				// 显示驳回理由
				$('.info').show().html("<b>领导：</b>" + (data.variables.leaderBackReason || "") + "<br/><b>HR：</b>" + (data.variables.hrBackReason || ""));
				
				// 读取原请假信息
				$('#applyContent #idType option[value=' + data.idType + ']').attr('selected', true);
				$('#applyContent #idNo').val(new Date(data.idNo));
				$('#applyContent #reason').val(data.reason);
			});
			
			// 切换状态
			$("#radio").buttonset().change(function(){
				var type = $(':radio[name=reApply]:checked').val();
				if (type == 'true') {
					$('#applyContent').show();
				} else {
					$('#modifyApplyContent').hide();
				}
			});
		},
		btns: [{
			text: '提交',
			click: function() {
				var taskId = $(this).data('taskId');
				var reApply = $(':radio[name=reApply]:checked').val();
				
				// 提交的时候把变量
				complete(taskId, [{
					key: 'reApply',
					value: reApply,
					type: 'B'
				}, {
					key: 'idType',
					value: $('#applyContent #idType').val(),
					type: 'S'
				}, {
					key: 'idNo',
					value: $('#applyContent #idNo').val(),
					type: 'D'
				}, {
					key: 'reason',
					value: $('#applyContent #reason').val(),
					type: 'S'
				}]);
			}
		},{
			text: '取消',
			click: function() {
				$(this).dialog('close');
			}
		}]
	},
	reportBack: {
		width: 400,
		height: 400,
		open: function(id, taskId) {
			// 打开对话框的时候读取请假内容
			loadDetail.call(this, id, taskId);
			$('#realityStartTime,#realityEndTime').datetimepicker({
	            stepMinute: 5
	        });
		},
		btns: [{
			text: '提交',
			click: function() {
				var realityStartTime = $('#realityStartTime').val();
				var realityEndTime = $('#realityEndTime').val();
				
				if (realityStartTime == '') {
					alert('请选择实际开始时间！');
					return;
				}
				
				if (realityEndTime == '') {
					alert('请选择实际结束时间！');
					return;
				}
				
				var taskId = $(this).data('taskId');
				complete(taskId, [{
					key: 'realityStartTime',
					value: realityStartTime,
					type: 'D'
				}, {
					key: 'realityEndTime',
					value: realityEndTime,
					type: 'D'
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
	
	// 请假记录ID
	var rowId = $(this).parents('tr').attr('id');
	
	// 任务ID
	var taskId = $(this).parents('tr').attr('tid');
	
	//alert(tkey + ' ' + taskId);
	var obj = $('#'+tkey);
	//alert(obj);
	if(obj != null) {
		obj.data({
			taskId: taskId
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
	} else {
		alert(obj);
		alert(tkey + ' ' + taskId);
	}
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