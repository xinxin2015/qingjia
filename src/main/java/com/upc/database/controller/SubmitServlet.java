package com.upc.database.controller;

import com.upc.database.model.Leave;
import com.upc.database.service.Auth;
import com.upc.database.serviceImpl.AuthImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitServlet extends HttpServlet {

    private Auth auth = new AuthImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            req.setCharacterEncoding("UTF-8");
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            int teacherId = Integer.parseInt(req.getParameter("teacherId"));
            String message = req.getParameter("message");
            System.out.println(message);

            boolean result = auth.addLeave(studentId, teacherId, message);

            resp.sendRedirect("/qingjia/postSuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                resp.sendRedirect("/qingjia/exception.jsp");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
