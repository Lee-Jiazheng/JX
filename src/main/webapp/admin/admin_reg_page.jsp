<%--
  Created by IntelliJ IDEA.
  User: Bruce Lee
  Date: 2017/7/18
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/admin/admin_register.do">
    <h1>用户名：</h1><input type="text" name="adminName"/><br>
    <h1>密码：</h1><input type="password" name="adminPassword"/><br>
    <h1>手机号码：</h1><input type="text" name="phoneNum"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
