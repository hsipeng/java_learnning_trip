<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<h2>欢迎登陆</h2>

<form action="ActionServlet" method="POST">
    <input style="display:none" name ="type" value="login">
            用户名：<input type="text" value="" name="username"><br/>
            密    码：<input type="password" value="" name="password"><br/>
            验证码：<input name="inputCode" value=""/>
    <img src="VerifyCodeServlet" align="middle" title="看不清，请点我"  onclick="javascript:refresh(this);" onmouseover="mouseover(this)"/><br/>
    <input type="submit">
</form>
</body>

<script>  
    function refresh(obj){  
         obj.src = "VerifyCodeServlet?" + Math.random();  
    }  
      
    function mouseover(obj){  
        obj.style.cursor = "pointer";  
    }  
</script> 
</html>
