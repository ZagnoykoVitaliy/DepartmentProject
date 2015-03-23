package com.kharkiv.zagnoyko.departments.dao;

import com.kharkiv.zagnoyko.departments.entity.Employee;

import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Frederick on 22.03.2015.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployees(Connection connection) throws SQLException {
        List<Employee> employees = new LinkedList<Employee>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALL_EMPLOYEES);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            employees.add(getEmployeeFromResultSet(resultSet));
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId,Connection connection) throws SQLException {
        List<Employee> employees = new LinkedList<Employee>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_EMPLOYEES_FROM_DEPARTMENT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            employees.add(getEmployeeFromResultSet(resultSet));
        }
        return employees;
    }

    @Override
    public Employee getEmployeebyId(int employeeId, Connection connection) throws SQLException {
        Employee employee = null;
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_EMPLOYEE_BY_ID);
        statement.setInt(1, employeeId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            employee = getEmployeeFromResultSet(resultSet);
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int employeeId, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.DELETE_EMPLOYEE_BY_ID);
        statement.setInt(1, employeeId);
        int result = statement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean insertEmployee(Employee employee, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.INSERT_EMPLOYEE);
        setEmployeeToStatement(employee, statement);
        int result = statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            employee.setEmployeeId(resultSet.getInt(1));
        }
        return result > 0;
    }

    @Override
    public boolean updateEmployeeById(Employee employee, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_EMPLOYEE_BY_ID);
        setEmployeeToStatement(employee, statement);
        int result = statement.executeUpdate();
        return result > 0;
    }

    private void setEmployeeToStatement(Employee employee, PreparedStatement statement) throws SQLException {
        statement.setInt(1, employee.getDepartmentId());
        statement.setString(2, employee.getName());
        statement.setDate(3, new Date(employee.getBirthDate().getTimeInMillis()));
        statement.setString(4, employee.getAddress());
        statement.setString(5, employee.getPhone());
        statement.setDate(6, new Date(employee.getHireDate().getTimeInMillis()));
        statement.setString(7, employee.getEmail());
    }

    private Employee getEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setDepartmentId(resultSet.getInt(1));
        employee.setEmployeeId(resultSet.getInt(2));
        employee.setName(resultSet.getString(3));
        Calendar cal = Calendar.getInstance();
        cal.setTime(resultSet.getDate(4));
        employee.setBirthDate(cal);
        employee.setAddress(resultSet.getString(5));
        employee.setPhone(resultSet.getString(6));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(resultSet.getDate(7));
        employee.setHireDate(calendar);
        employee.setEmail(resultSet.getString(8));
        return employee;
    }
}
