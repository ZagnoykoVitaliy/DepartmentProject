package com.kharkiv.zagnoyko.departments.dao;

import com.kharkiv.zagnoyko.departments.entity.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Frederick on 19.03.2015.
 */
public interface DepartmentDAO {
    List<Department> getAllDepartmants(Connection connection) throws SQLException;

    Department getDepartmentById(int departmentId, Connection connection) throws SQLException;

    boolean deleteDepartment(int departmentId, Connection connection) throws SQLException;

    boolean insertDepartment(Department department, Connection connection) throws SQLException;

    boolean updateDepartment(Department department, Connection connection) throws SQLException;


}
