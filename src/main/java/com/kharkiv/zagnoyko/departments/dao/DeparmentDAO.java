package com.kharkiv.zagnoyko.departments.dao;

import com.kharkiv.zagnoyko.departments.entity.Department;

import java.util.List;

/**
 * Created by Frederick on 19.03.2015.
 */
public interface DeparmentDAO {
    List<Department> getAllDepartmants();

    Department getDepartmentById(int departmentId);

    boolean deleteDepartment(int departmentId);

    boolean insertDepartment(Department department);

    boolean updateDepartment(Department department);

}
