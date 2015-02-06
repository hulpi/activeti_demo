//初始化弹出框的按钮名称
 $(function () { 
        $.messager.defaults = { ok: "确定", cancel: "取消" }; 
	 });
	 var titles="系统提示";
	 //普通提示框
function jqalertly(c,t, url) {
	var type="error";
	if(t==1)
	type="warning";
	$.messager.alert(titles,c,type,function(){
		if(url!=null){
			  window.location = url;
		}
	});
}
//普通提示框2  有返回值  
function jqalertCb(t, callback) {
	$.messager.alert(titles,t,"error",function(){
			callback()
	});
}
	 //确认框
	 function confirms(callback, msg){
		  var msgs = "您确定要执行操作吗";
    if (msg != null)
        msgs = msg;
	$.messager.confirm(titles, msgs, function(r){
				if (r){
					callback();
				}
			});
		}
		
		//弹出一个页面窗口
function jqopenly(tit, url) {
	window.parent.opens(url,tit);
}