<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/14
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="/qingjia/login.do" method="post">
        学号（或教师编号）<input type="text" name="number" id="number">
        密码：<input type="password" name="password" id="password">
        登录：<input type="submit" name="submit">
    </form>
</body>
</html>
