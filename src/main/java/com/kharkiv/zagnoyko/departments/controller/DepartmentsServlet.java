package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.entity.Department;
import com.kharkiv.zagnoyko.departments.service.DepartmentService;
import com.kharkiv.zagnoyko.departments.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Frederick on 19.03.2015.
 */
public class DepartmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        DepartmentService departmentService = (DepartmentService) servletContext.getAttribute(Constants.DEPARTMENT_SERVICE);
        List<Department> allDepartments = departmentService.getAllDepartments();
        req.setAttribute(Constants.ALL_DEPARTMENTS_ATTRIBUTE_NAME, allDepartments);
    }
}
