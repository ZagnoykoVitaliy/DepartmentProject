package com.kharkiv.zagnoyko.departments.dao;


import com.kharkiv.zagnoyko.departments.entity.Employee;

import java.util.List;

/**
 * Created by Frederick on 19.03.2015.
 */
public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployeebyId(int EmployeeId);

    boolean deleteEmployee(int EmployeeId);

    boolean insertEmployee(Employee employee);

    boolean updateEmployeeById(Employee employee);


}
