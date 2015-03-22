package com.kharkiv.zagnoyko.departments.dao;

import com.kharkiv.zagnoyko.departments.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Frederick on 21.03.2015.
 */
public class DepartmentDAOImpl implements DeparmentDAO {
    @Override
    public List<Department> getAllDepartmants(Connection connection) throws SQLException {
        List<Department> departments = new LinkedList<Department>();
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALL_DEPARTMENTS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
            departments.add(department);
        }
        return departments;
    }

    @Override
    public Department getDepartmentById(int departmentId, Connection connection) throws SQLException {
        Department department = null;
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_DEPARTMENT_BY_ID);
        statement.setInt(1, departmentId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            department = new Department();
            department.setDepartmentId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
        }
        return department;
    }

    @Override
    public boolean deleteDepartment(int departmentId, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.DELETE_DEPARTMENT_BY_ID);
        statement.setInt(1, departmentId);
        int result = statement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean insertDepartment(Department department, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.INSERT_DEPARTMENT);
        statement.setString(1, department.getName());
        int result = statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            department.setDepartmentId(resultSet.getInt(1));
        }
        return result > 0;
    }

    @Override
    public boolean updateDepartment(Department department, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_DEPARTMENT);
        statement.setString(1, department.getName());
        int result = statement.executeUpdate();
        return result > 0;
    }


}
