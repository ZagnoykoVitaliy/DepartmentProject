package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.entity.Employee;
import com.kharkiv.zagnoyko.departments.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Frederick on 26.03.2015.
 */
public class EmployeeCreateServlet extends HttpServlet {
    @Override

    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        String employeeName=req.getParameter("employeeName");
        String employeePhone= req.getParameter("employeePhone");
        String employeeAddress=req.getParameter("employeeAddress");
        String employeeEmail=req.getParameter("employeeEmail");

//        String employeeBirthDate=req.getParameter("employeeBirthDate");
//        String employeeHireDate= req.getParameter("employeeHireDate");
        Employee employee = new Employee();
        employee.setDepartmentId(departmentId);
        employee.setName(employeeName);
        employee.setPhone(employeePhone);
        employee.setAddress(employeeAddress);
        employee.setEmail(employeeEmail);
//        employee.setBirthDate(employeeBirthDate);
//        employee.setHireDate(employeeHireDate);
        ServletContext servletContext = req.getServletContext();
        EmployeeService employeeService= (EmployeeService) servletContext.getAttribute(Constants.EMPLOYEE_SERVICE);
        employeeService.insertEmployee(employee);
        resp.sendRedirect("employees.jsp");

    }
}
