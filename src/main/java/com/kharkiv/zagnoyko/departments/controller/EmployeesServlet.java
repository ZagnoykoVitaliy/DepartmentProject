package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.entity.Employee;
import com.kharkiv.zagnoyko.departments.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Frederick on 26.03.2015.
 */
@WebServlet("/getemployees")
public class EmployeesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        EmployeeService employeeService = (EmployeeService) servletContext.getAttribute(Constants.EMPLOYEE_SERVICE);
        List<Employee> allEmployees = employeeService.getAllEmployees();
        req.setAttribute(Constants.ALL_EMPLOYEES_ATTRIBUTE_NAME, allEmployees);
        req.getRequestDispatcher("/employees.jsp").forward(req, resp);
    }

}
