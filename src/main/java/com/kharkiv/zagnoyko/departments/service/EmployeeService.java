package com.kharkiv.zagnoyko.departments.service;

import com.kharkiv.zagnoyko.departments.dao.ConnectionFactory;
import com.kharkiv.zagnoyko.departments.dao.ConnectionUtils;
import com.kharkiv.zagnoyko.departments.dao.EmployeeDAO;
import com.kharkiv.zagnoyko.departments.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Frederick on 22.03.2015.
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            employees = employeeDAO.getAllEmployees(connection);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return employees;
    }

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        List<Employee> employees = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            employees = employeeDAO.getEmployeesByDepartmentId(departmentId, connection);
            connection.commit();
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
            e.printStackTrace();
        } finally {
            ConnectionUtils.close(connection);
        }
        return employees;
    }

    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            employee = employeeDAO.getEmployeebyId(employeeId, connection);
            connection.commit();
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return employee;
    }

    public boolean deleteEmployee(int employeeId) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            result = employeeDAO.deleteEmployee(employeeId, connection);
            connection.commit();
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return result;
    }

    public boolean insertEmployee(Employee employee) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            result = employeeDAO.insertEmployee(employee, connection);
            connection.commit();
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return result;
    }

    public boolean updateEmployeeById(Employee employee) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            result = employeeDAO.updateEmployeeById(employee, connection);
            connection.commit();
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
            e.printStackTrace();
        } finally {
            ConnectionUtils.close(connection);
        }
        return result;
    }

}
