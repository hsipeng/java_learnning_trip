<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册</title>
</head>
<body>

<div class="div.reg-form">
    <form id="reg-form" action="/ActionServlet" method="POST">
        <input style="display:none" name ="type" value="reg">
        用户名：<input id="userName" type="text" value="" name="username"><br/>
        邮  箱：<input id="email" type="email" value="" name="email"><br/>
        昵  称：<input id="nickName" type="text" value="" name="nickname"><br/>
        密    码：<input id="password" type="password" value="" name="password"><br/>
        确认密码：<input id="rePassword" type="password" value="" name="repassword"><br/>
        验证码：<input id="inputCode" name="inputCode" value=""/>
        <img src="VerifyCodeServlet" align="middle" title="看不清，请点我"  onclick="javascript:refresh(this);" onmouseover="mouseover(this)"/><br/>
        <
        <input  type="submit" value="注册"><input type="reset" value="重置"> <input id="btn-login" type="button" value="登录"></input>
    </form>
</div>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>
<script type="text/javascript">

    function refresh(obj){
        obj.src = "VerifyCodeServlet?" + Math.random();
    }

    function mouseover(obj){
        obj.style.cursor = "pointer";
    }
</script>
<script type="text/javascript">
    $('#rePassword').on('change',function () {
        var  password = $('#password').val();
        var  rePassword = $('#rePassword').val();
        if(password!==rePassword){
            alert("两次密码必须一致");
        }
    });
</script>
</body>
</html>
