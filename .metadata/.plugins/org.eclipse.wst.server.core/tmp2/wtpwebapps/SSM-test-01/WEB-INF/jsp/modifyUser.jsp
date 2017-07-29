<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/user/updateUser">
    <table>
      <tr>
        <td><input type="text" name="id" value="${user.id}"></td>
      <td><input type="text" name="user_name" value="${user.user_name}"></td>
      <td><input type="text" name="password" value="${user.password}"></td>
      <td><input type="text" name="age" value="${user.age}"></td>
      </tr>
      <tr colspan="3">
        <td><input type="submit" name="提交"></td>
      </tr>
    </table>
  </form>
</body>
</html>
