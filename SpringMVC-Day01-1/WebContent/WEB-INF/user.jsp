<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addUser.action" method="post">
    <table width="80%" height="200px" border="1px" align="center">
      <tr align="center">
        <td colspan="2">
          <h3>用户注册</h3>
        </td>
      </tr>

      <tr align="center">
        <td>用户名:</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr align="center">
        <td>密码：</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr align="center">
        <td>真实姓名：</td>
        <td><input type="text" name="name"></td>
      </tr>
       <tr align="center">
        <td>电话：</td>
        <td><input type="tel" name="tel"></td>
      </tr>
      <tr align="center">
        <td>家庭地址：</td>
        <td><input type="text" name="userInfo.addr"></td>
      </tr>
      <tr align="center">
        <td>年龄：</td>
        <td><input type="text" name="userInfo.Age"></td>
      </tr>
      <tr align="center">
        <td>生日：</td>
        <td><input type="text" name="userInfo.birthday"></td>
      </tr>
      <tr align="center">
        <td>爱好：</td>
        <td><input type="checkbox" name="hobby" value="羽毛球">羽毛球
        <input type="checkbox" name="hobby" value="吃鸡">吃鸡
        <input type="checkbox" name="hobby" value="骑马">骑马
        <input type="checkbox" name="hobby" value="唱歌">唱歌
        <input type="checkbox" name="hobby" value="听音乐">听音乐</td>
      </tr>
      
      <tr align="center">
        <td>状态：</td>
        <td><input type="radio" name="state" value="成年人">成年人
        	<input type="radio" name="state" value="未成年人">未成年人
        </td>
      </tr>
      <tr align="center">
        <td></td>
        <td><input type="submit" name="注册"></td>
      </tr>
    </table>
  </form>
</body>
</html>
