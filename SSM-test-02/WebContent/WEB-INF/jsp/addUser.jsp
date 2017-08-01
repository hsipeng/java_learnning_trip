<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/user/addUser">
    <table style="border: #333 1px solid; text-align: center;">
    <tr style="border: #333 1px solid; text-align: center;">
    <td style="border: #333 1px solid; text-align: center;"></td>
    <td style="border: #333 1px solid; text-align: center;">name</td>
    <td style="border: #333 1px solid; text-align: center;">password</td>
    <td style="border: #333 1px solid; text-align: center;">age</td>
  </tr>
      <tr>
      <td style="border: #333 1px solid; text-align: center;"><input type="text" name="id" value="-1" hidden="hidden"></td>
      <td style="border: #333 1px solid; text-align: center;"><input type="text" name="username" value=""></td>
      <td style="border: #333 1px solid; text-align: center;"><input type="text" name="password" value=""></td>
      <td style="border: #333 1px solid; text-align: center;"><input type="text" name="age" value=""></td>
      </tr>
      <tr colspan="3" style="border: #333 1px solid; text-align: center;">
        <td style="border: #333 1px solid; text-align: center;"><input type="submit" value="添加"></td>
      </tr>
    </table>
  </form>
</body>
</html>
