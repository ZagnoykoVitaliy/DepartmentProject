package com.kharkiv.zagnoyko.departments.dao;

import com.kharkiv.zagnoyko.departments.entity.Employee;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;


/**
 * Created by Frederick on 22.03.2015.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new LinkedList<Employee>();
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALL_EMPLOYEES);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployeeFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployeebyId(int employeeId) {
        Employee employee = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.SELECT_EMPLOYEE_BY_ID);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                employee = getEmployeeFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        int result = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.DELETE_EMPLOYEE_BY_ID);
            statement.setInt(1, employeeId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        int result = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.INSERT_EMPLOYEE);
            setEmployeeToStatement(employee, statement);
            result = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                employee.setEmployeeId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }

    @Override
    public boolean updateEmployeeById(Employee employee) {
        int result = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_EMPLOYEE_BY_ID);
            setEmployeeToStatement(employee,statement);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }

    private void setEmployeeToStatement(Employee employee, PreparedStatement statement) throws SQLException {
        statement.setInt(1, employee.getDepartmentId());
        statement.setString(2, employee.getName());
        statement.setDate(3, new Date(employee.getBirthDate().getTimeInMillis()));
        statement.setString(4, employee.getAddress());
        statement.setString(5, employee.getPhone());
        statement.setDate(6, new Date(employee.getHireDate().getTimeInMillis()));
        statement.setString(7,employee.getEmail());
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
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(resultSet.getDate(7));
        employee.setHireDate(calendar);
        employee.setEmail(resultSet.getString(8));
        return employee;
    }
}
