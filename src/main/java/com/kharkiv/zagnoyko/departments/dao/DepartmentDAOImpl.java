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
    public List<Department> getAllDepartmants() {
        List<Department> departments = new LinkedList<Department>();
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALL_DEPARTMENTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt(1));
                department.setName(resultSet.getString(2));
                departments.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        Department department = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.SELECT_DEPARTMENT_BY_ID);
            statement.setInt(1, departmentId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                department = new Department();
                department.setDepartmentId(resultSet.getInt(1));
                department.setName(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }

    @Override
    public boolean deleteDepartment(int departmentId) {
        int result = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.DELETE_DEPARTMENT_BY_ID);
            statement.setInt(1, departmentId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
    public boolean insertDepartment(Department department) {
        int result = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.INSERT_DEPARTMENT);
            statement.setString(1, department.getName());
            result = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                department.setDepartmentId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result>0;
    }

    @Override
    public boolean updateDepartment(Department department) {
        int result = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_DEPARTMENT);
            statement.setString(1,department.getName());
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }


}
