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
<table style="width:60%; border: #333 1px solid; text-align: center;" align="center">
  <tr style="border: #333 1px solid; text-align: center;" align="center">
    <td style="border: #333 1px solid; text-align: center;">id</td>
    <td style="border: #333 1px solid; text-align: center;">name</td>
    <td style="border: #333 1px solid; text-align: center;">age</td>
    <td style="border: #333 1px solid; text-align: center;">sex</td>
  </tr>

<c:forEach items="${uList}" var="user" >
  <tr style="border: #333 1px solid; text-align: center;" align="center">
    <td style="border: #333 1px solid; text-align: center;">${user.id}</td>
    <td style="border: #333 1px solid; text-align: center;">${user.name}</td>
    <td style="border: #333 1px solid; text-align: center;">${user.age}</td>
    <td style="border: #333 1px solid; text-align: center;">${user.sex}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>
