package com.kharkiv.zagnoyko.departments.dao;


import com.kharkiv.zagnoyko.departments.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Frederick on 19.03.2015.
 */
public interface EmployeeDAO  {
    List<Employee> getAllEmployees(Connection connection) throws SQLException;

    List<Employee> getEmployeesByDepartmentId(int departmentId, Connection connection) throws SQLException;

    Employee getEmployeebyId(int EmployeeId, Connection connection) throws  SQLException;

    boolean deleteEmployee(int EmployeeId, Connection connection) throws SQLException;

    boolean insertEmployee(Employee employee, Connection connection) throws SQLException;

    boolean updateEmployeeById(Employee employee, Connection connection) throws SQLException;


}
