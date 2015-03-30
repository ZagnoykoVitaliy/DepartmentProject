package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Frederick on 26.03.2015.
 */
@WebServlet ("/deleteEmployee")
public class EmployeeDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        ServletContext servletContext = req.getServletContext();
        EmployeeService employeeService = (EmployeeService) servletContext.getAttribute(Constants.EMPLOYEE_SERVICE);
        employeeService.deleteEmployee(employeeId);
        resp.sendRedirect("employees.jsp");
    }
}
