package com.kharkiv.zagnoyko.departments.service;

import com.kharkiv.zagnoyko.departments.dao.ConnectionFactory;
import com.kharkiv.zagnoyko.departments.dao.ConnectionUtils;
import com.kharkiv.zagnoyko.departments.dao.DeparmentDAO;
import com.kharkiv.zagnoyko.departments.entity.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Frederick on 22.03.2015.
 */
public class DepartmentService {
    private DeparmentDAO deparmentDAO;

    public DepartmentService(DeparmentDAO deparmentDAO) {
        this.deparmentDAO = deparmentDAO;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            departments = deparmentDAO.getAllDepartmants(connection);
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return departments;
    }

    public Department getDepartmentById(int departmentId) {
        Department department = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            department = deparmentDAO.getDepartmentById(departmentId, connection);

        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return department;
    }

    public boolean deleteDepartment(int departmentId) {
        Connection connection = null;
        boolean result = false;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            result = deparmentDAO.deleteDepartment(departmentId, connection);
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);

        } finally {
            ConnectionUtils.close(connection);
        }
        return result;
    }

    public boolean insertDepartment(Department department) {
        Connection connection = null;
        boolean result = false;
        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            result = deparmentDAO.insertDepartment(department, connection);
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        } finally {
            ConnectionUtils.close(connection);
        }
        return result;
    }

    public boolean updateDepartment(Department department){
        Connection connection =null;
        boolean result = false;

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            result = deparmentDAO.updateDepartment(department , connection);
        } catch (SQLException e) {
            ConnectionUtils.rollback(connection);
        }finally {
            ConnectionUtils.close(connection);
        }
        return result;
    }

}
