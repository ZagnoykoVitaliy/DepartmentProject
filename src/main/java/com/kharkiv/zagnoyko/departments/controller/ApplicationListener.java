package com.kharkiv.zagnoyko.departments.controller;

import com.kharkiv.zagnoyko.departments.dao.DepartmentDAOImpl;
import com.kharkiv.zagnoyko.departments.dao.EmployeeDAOImpl;
import com.kharkiv.zagnoyko.departments.service.DepartmentService;
import com.kharkiv.zagnoyko.departments.service.EmployeeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Frederick on 23.03.2015.
 */
public class ApplicationListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        DepartmentService departmentService=  new DepartmentService(new DepartmentDAOImpl());
        EmployeeService employeeService = new EmployeeService(new EmployeeDAOImpl());
        servletContext.setAttribute(Constants.DEPARTMENT_SERVICE, departmentService);
        servletContext.setAttribute(Constants.EMPLOYEE_SERVICE, employeeService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Constants.DEPARTMENT_SERVICE);
        servletContext.removeAttribute(Constants.EMPLOYEE_SERVICE);
    }
}
