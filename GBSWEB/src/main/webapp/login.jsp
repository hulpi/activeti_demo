<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>担保系统</title>
    <link href="./css/style.css" rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $(function(){
            $("#password").focus(function(){
                $("#left_hand").animate({
                    left: "150",
                    top: " -38"
                },{step: function(){
                    if(parseInt($("#left_hand").css("left"))>140){
                        $("#left_hand").attr("class","left_hand");
                    }
                }}, 2000);
                $("#right_hand").animate({
                    right: "-64",
                    top: "-38px"
                },{step: function(){
                    if(parseInt($("#right_hand").css("right"))> -70){
                        $("#right_hand").attr("class","right_hand");
                    }
                }}, 2000);
            });
            
            $("#password").blur(function(){
                $("#left_hand").attr("class","initial_left_hand");
                $("#left_hand").attr("style","left:100px;top:-12px;");
                $("#right_hand").attr("class","initial_right_hand");
                $("#right_hand").attr("style","right:-112px;top:-12px");
            });
            
            $("#login").click(function() {
        		  $("#loginForm").submit();
        		});
        });
    	
    </script>
</head>
<body>
<div class="top_div"></div>
<div class="main_div">
    <div class="wrap">
        <div class="tou"></div>
        <div id="left_hand" class="initial_left_hand"></div>
        <div id="right_hand" class="initial_right_hand"></div>
    </div>
<form id="loginForm" action="j_spring_security_check" method="post">
    <p class="userN">
        <span class="u_logo"></span>
        <input class="ipt" type="text" placeholder="请输入用户名" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}">
    </p>
    <p class="passW">
        <span class="p_logo"></span>
        <input id="password" class="ipt" type="password"  placeholder="请输入密码" name="j_password" value="" >
    </p>
</form>
    <div class="submit">
        <p class="submitBox">
           <span style="float: right">
           	   <a href="#" class="login" id="login">登陆</a>
           	   <!-- <input type="submit" class="login" name = "登陆">-->
               <a href="#" class="reset">重置</a>
               
           </span>
        </p>
    </div>

</div>

<div class="foot">
    Copyright ©2015 <a href="#">担保系统</a>
</div>
</body>
</html>
