package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.entity.Department;
import com.kharkiv.zagnoyko.departments.service.DepartmentService;
import com.sun.net.httpserver.HttpServer;

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
@WebServlet("/updateDepartment")
public class DepartmentsUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        String departmentName = req.getParameter("departmentName");
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setName(departmentName);
        ServletContext servletContext = req.getServletContext();
        DepartmentService departmentService = (DepartmentService) servletContext.getAttribute(Constants.DEPARTMENT_SERVICE);
        departmentService.updateDepartment(department);
        resp.sendRedirect("index.jsp");
    }







}
