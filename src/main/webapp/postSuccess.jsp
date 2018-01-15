<%@ page import="com.upc.database.model.Leave" %>
<%@ page import="com.upc.database.dao.AuthDao" %>
<%@ page import="com.upc.database.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/15
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生请假详情页</title>
</head>
<body>
    <%

        AuthDao authDao = new AuthDao();
        Student loginUser = (Student)request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("/qingjia/index.jsp");
            return;
        }
        int studentId = loginUser.getId();
        List<Leave> leaves = authDao.getLeaveByStuId(studentId);
        for (Leave l : leaves) {
            String f = "否";
            if (l.getDestory() != 0) {
                f = "是";
            }
    %>
    学生姓名：<%=l.getStudent().getName()%>
    请假老师姓名:<%=l.getTeacher().getName()%>
    请假信息:<%=l.getMessage()%>
    是否销假：<%=f%>
    <br>
    <%}%>
<a href="student.jsp">返回</a>
</body>
</html>
