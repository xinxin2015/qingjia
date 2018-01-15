package com.upc.database.controller;

import com.upc.database.model.Student;
import com.upc.database.model.Teacher;
import com.upc.database.service.Auth;
import com.upc.database.serviceImpl.AuthImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private Auth auth = new AuthImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Integer number = Integer.parseInt(req.getParameter("number"));
            String password = (String) req.getParameter("password");
            System.out.println("number = " + number + " password = " + password);
            Student student = auth.studentLogin(number,password);
            Teacher teacher = auth.teacherLogin(number,password);
            if (student != null) {
                req.getSession().setAttribute("loginUser",student);
                resp.sendRedirect("/qingjia/student.jsp");
            } else if (teacher != null){
                req.getSession().setAttribute("loginUser",teacher);
                resp.sendRedirect("/qingjia/teacher.jsp");
            } else {
                resp.sendRedirect("/qingjia/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
