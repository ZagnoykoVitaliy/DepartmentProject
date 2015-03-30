package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.entity.Employee;
import com.kharkiv.zagnoyko.departments.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Frederick on 26.03.2015.
 */
@WebServlet("/updateEmployee")
public class EmployeeUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int departmentId= Integer.parseInt(req.getParameter("departmentId"));
        int employeeId= Integer.parseInt(req.getParameter("employeeId"));
        String employeeName = req.getParameter("employeeName");
        String employeePhone= req.getParameter("employeePhone");
        String employeeAddress=req.getParameter("employeeAddress");
        String employeeEmail=req.getParameter("employeeEmail");

        String employeeBirthDate=req.getParameter("employeeBirthDate");
        String employeeHireDate= req.getParameter("employeeHireDate");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD - hh:dd:mm");


        Employee employee = new Employee();
        employee.setDepartmentId(departmentId);
        employee.setEmployeeId(employeeId);
        employee.setName(employeeName);
        employee.setPhone(employeePhone);
        employee.setAddress(employeeAddress);
        employee.setEmail(employeeEmail);

        try {
            Date date = sdf.parse(employeeBirthDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            employee.setBirthDate(calendar);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date date = sdf.parse(employeeHireDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            employee.setHireDate(calendar);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ServletContext servletContext = req.getServletContext();
        EmployeeService employeeService = (EmployeeService) servletContext.getAttribute(Constants.EMPLOYEE_SERVICE);
        employeeService.updateEmployeeById(employee);
        resp.sendRedirect("employees.jsp");
    }
}
