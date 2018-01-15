package com.upc.database.controller;

import com.upc.database.service.Auth;
import com.upc.database.serviceImpl.AuthImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class xiaoServlet extends HttpServlet {

    private Auth auth = new AuthImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("utf-8");
            int id = Integer.parseInt(req.getParameter("id"));
            auth.updateLeave(id);
            resp.sendRedirect("/qingjia/xiaoSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                resp.sendRedirect("/qingjia/exception.jsp");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req,resp);
    }
}
