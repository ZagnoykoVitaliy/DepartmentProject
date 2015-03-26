package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.entity.Department;
import com.kharkiv.zagnoyko.departments.service.DepartmentService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Frederick on 26.03.2015.
 */
@WebServlet("/createDepartment")
public class DepartmentsCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String departmentName =req.getParameter("departmentName");
        Department department = new Department();
        department.setName(departmentName);
        ServletContext servletContext = req.getServletContext();
        DepartmentService departmentService = (DepartmentService) servletContext.getAttribute(Constants.DEPARTMENT_SERVICE);
        departmentService.insertDepartment(department);
        resp.sendRedirect("index.jsp");
    }
}
