<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/14
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生申请界面</title>
</head>
<body>
    <form action="/qingjia/submit.do" method="post">
        <input type="hidden" name="studentId" value="${loginUser.id}">
        <input type="hidden" name="teacherId" value="${loginUser.daoyuan.id}">
        请假信息：<input type="text" name="message"><br>
        选择老师：<input type="checkbox">${loginUser.daoyuan.name}<br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
