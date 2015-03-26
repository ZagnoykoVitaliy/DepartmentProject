package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.service.DepartmentService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Frederick on 25.03.2015.
 */
@WebServlet("/deleteDepartment")
public class DepartmentDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        ServletContext servletContext = req.getServletContext();
        DepartmentService departmentService = (DepartmentService) servletContext.getAttribute(Constants.DEPARTMENT_SERVICE);
        departmentService.deleteDepartment(departmentId);
        resp.sendRedirect("index.jsp");

    }
}
