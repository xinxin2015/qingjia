<%@ page import="com.upc.database.model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="com.upc.database.model.Leave" %>
<%@ page import="com.upc.database.dao.AuthDao" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/14
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>教师浏览界面</title>
</head>
<body>
    <%
        Teacher loginUser = (Teacher)request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("/qingjia/index.jsp");
            return;
        }
        AuthDao authDao = new AuthDao();
        List<Leave> leaves = authDao.getLeaveByTId(loginUser.getId());
        for (Leave l : leaves) {
            String f = "否";
            if (l.getDestory() != 0) {
                f = "是";
            }
    %>
    <form action="/qingjia/xiao.do" method="post">
        <input type="hidden" value="<%=l.getId()%>" name="id">
        是否销假：<%=f%>
        请假信息:<%=l.getMessage()%>
        <%
            if (l.getDestory() == 0) {
        %>
        <input type="submit" value="销假">
        <%}%>
    </form>
    <%}%>
</body>
</html>
