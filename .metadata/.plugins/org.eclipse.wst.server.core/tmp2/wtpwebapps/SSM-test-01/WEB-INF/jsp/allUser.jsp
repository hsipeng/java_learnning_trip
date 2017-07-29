<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="border: #333 1px solid; text-align: center;">
  <tr style="border: #333 1px solid; text-align: center;">
    <td style="border: #333 1px solid; text-align: center;">id</td>
    <td style="border: #333 1px solid; text-align: center;">name</td>
    <td style="border: #333 1px solid; text-align: center;">age</td>
    <td style="border: #333 1px solid; text-align: center;">password</td>
  </tr>

<c:forEach items="${uList}" var="user" >
  <tr style="border: #333 1px solid; text-align: center;">
    <td style="border: #333 1px solid; text-align: center;">${user.id}</td>
    <td style="border: #333 1px solid; text-align: center;">${user.user_name}</td>
    <td style="border: #333 1px solid; text-align: center;">${user.age}</td>
    <td style="border: #333 1px solid; text-align: center;">${user.password}</td>
    <td style="border: #333 1px solid; text-align: center;"><a href="${pageContext.request.contextPath}/user/modifyUser?userid=${user.id}">修改</a></td>
    <td style="border: #333 1px solid; text-align: center;"><a href="${pageContext.request.contextPath}/user/delUser?userid=${user.id}">删除</a></td>
  </tr>
</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/user/toAdd" style="text-decoration: none;">添加用户</a>
</body>
</html>
