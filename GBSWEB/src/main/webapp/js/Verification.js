
$(function () {
    $("[reg]").blur(function () {
        validate($(this));
    });
});
//获取页面的REG的正则表达式
function validate(obj) {
    var reg = new RegExp(obj.attr("reg"));
    var objValue = obj.attr("value");
    if (!reg.test(objValue)) {
        obj.removeClass();
        obj.addClass("inputerr");
        return false;
    } else {
        obj.removeClass("inputerr");
        return true;
    }
}

//身份证验证
function Idcards(obj) {
    obj = $(obj);
    var objValue = obj.attr("value");
    var checkFlag = new clsIDCard(objValue);
    if (!checkFlag.IsValid()) {
        obj.removeClass();
        obj.addClass("inputerr");
        return false;
    } else {
        obj.removeClass();
        obj.addClass("inputsuc");
        return true;
    }
}

// 计算两个日期的间隔天数  
function Computation(sDate1, sDate2) {   //sDate1和sDate2是2008-12-13格式    
    var aDate, oDate1, oDate2, iDays
    aDate = sDate1.split("/");
    if (aDate.length < 2)
        aDate = sDate1.split("-");
    oDate1 = new Date(aDate[1] + '/' + aDate[2] + '/' + aDate[0])   //转换为12-13-2008格式    
    aDate = sDate2.split("/")
    if (aDate.length < 2)
        aDate = sDate2.split("-");
    oDate2 = new Date(aDate[1] + '/' + aDate[2] + '/' + aDate[0])
    iDays = ((oDate1 - oDate2) / 1000 / 60 / 60 / 24)  //把相差的毫秒数转换为天数    
    return iDays
}

//验证合同编号
function AcctNoValidate(obj) {
    var objs = $(obj);
    var val = objs.val();
    if (val.length < 11 || val.length > 13) {
        objs.removeClass();
        objs.addClass("inputerr");
        return false;
    }
    else {
        objs.removeClass();
        objs.addClass("inputsuc");
        return true;
    }
}
//检查合同编号子号码
function acctNo(obj) {
    var objs = $(obj);
    var ac = parseInt(objs.val(), 10);
    if (ac > 0) {
        objs.removeClass();
        objs.addClass("inputsuc");
        return true;
    } else {
        objs.removeClass();
        objs.addClass("inputerr");
        return false;
    }
}
//验证电话号码
function ValidatePhone(obj) {
    var tx = /^\d{3}-\d{8}$|^\d{4}-\d{7}$/;
    var obj = $(obj);
    if (!tx.test(obj.val())) {
        obj.removeClass();
        obj.addClass("inputerr");
        return false;
    } else {
        obj.removeClass();
        obj.addClass("inputsuc");
        return true;
    }
}

//回车事件转换TAB事件
function GetkeyCode(formID) {
    $(formID).keydown(function () {
        if (window.event.keyCode == 13) {
            window.event.keyCode = 9;
        }
    });
    GetInputReadOnly();
}

//获取ReadOnly控件
function GetInputReadOnly() {
    $(document).find("[readonly='readonly']").each(function () {
        $(this).focus(function () { $(this).blur(); })
    });
}

//回车提交
function keyCodeSubmit(formID, callblack) {
    $(formID).keydown(function () {
        if (window.event.keyCode == 13) {
            callblack();
        }
    });
}

//select selected选中
function selected(id, v) {
    $(id + " option").each(function () {
        if ($(this).val() == v)
            $(this).attr("selected", true);
        else
            $(this).attr("selected", false);
    });
}


//让输入框只能输入数字
function Num(obj, seed) {
    var txt = $(obj).val();
    if (isNaN(txt))
        $(obj).val(txt.replace(/[^\d]/g, ''));
    txt = $(obj).val();
    if (seed == 's' && txt != '') {
        var ac = parseInt(txt, 10);
        if (ac > 0) {
            if (ac < 10) {
                ac = "0" + ac;
            } else
                ac;
        }
        $(obj).val(ac);
    }
    if ($.browser.msie) {
        var keys = window.event.keyCode;
        if (keys == 37 || keys == 38 || keys == 39 || keys == 10|| keys == 189) {
            return true;
        } else if ((keys <= 105 && keys >= 96) || (keys <= 57 && keys >= 48) || keys == 13 || keys == 8 || keys == 86 || keys == 88 || keys == 67 || keys == 9)
            return true;
        else
            return false;
    }
}
//让输入框只能输入数字
function Num_(obj, seed) {
    var txt = $(obj).val();
    if (isNaN(txt))
        $(obj).val(txt.replace(/[^\d-]/g, ''));
    txt = $(obj).val();
    if (seed == 's' && txt != '') {
        var ac = parseInt(txt, 10);
        if (ac > 0) {
            if (ac < 10) {
                ac = "0" + ac;
            } else
                ac;
        }
        $(obj).val(ac);
    }
    if ($.browser.msie) {
        var keys = window.event.keyCode;
        if (keys == 37 || keys == 38 || keys == 39 || keys == 10|| keys == 189) {
            return true;
        } else if ((keys <= 105 && keys >= 96) || (keys <= 57 && keys >= 48) || keys == 13 || keys == 8 || keys == 86 || keys == 88 || keys == 67 || keys == 9)
            return true;
        else
            return false;
    }
}
//让输入框只能输入数字和字母
function NumE(obj) {
    var reg = /[^a-zA-Z0-9]/g;
    var val = $(obj).val();
    if (reg.test(val)) {
        $(obj).val(val.replace(/[^a-zA-Z0-9]/g, ''));
    }
    if ($.browser.msie) {
        var keys = window.event.keyCode;
        if (keys == 37 || keys == 38 || keys == 39 || keys == 10) {
            return true;
        } else if ((keys <= 105 && keys >= 96) || (keys <= 57 && keys >= 48) || (keys <= 90 && keys >= 65) || keys == 13 || keys == 8 || keys == 86 || keys == 88 || keys == 67 || keys == 9)
            return true;
        else
            return false;
    }
}

// 通过正则表达式验证
function regInput(obj, reg, inputStr) {
    var docSel = document.selection.createRange();
    if (docSel.parentElement().tagName != "INPUT") {
        return false;
    }
    oSel = docSel.duplicate();
    oSel.text = "";
    var srcRange = obj.createTextRange();
    oSel.setEndPoint("StartToStart", srcRange);
    var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length);
    return reg.test(str);
}