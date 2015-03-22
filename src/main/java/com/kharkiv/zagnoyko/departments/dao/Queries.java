package com.kharkiv.zagnoyko.departments.dao;

/**
 * Created by Frederick on 21.03.2015.
 */
public final class Queries {
    public static final String SELECT_ALL_DEPARTMENTS = "select * from department";
    public static final String SELECT_DEPARTMENT_BY_ID = "select * from department where DepartmentId =?";
    public static final String DELETE_DEPARTMENT_BY_ID = "delete from department where DepartmentId = ?";
    public static final String INSERT_DEPARTMENT = "insert into department values (?)";
    public static final String UPDATE_DEPARTMENT = "update department set name = ? where DepartmentId= ?";
    public static final String SELECT_ALL_EMPLOYEES = "select * from employee";
    public static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employeeId = ?";
    public static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where employeeId = ?";
    public static final String SELECT_EMPLOYEES_FROM_DEPARTMENT="select * from employee where DepartmentId = ?";
    public static final String INSERT_EMPLOYEE = "insert into employee (DepartmentId, Name, BirthDate,Address, Phone, HireDate, email) values (?,?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE_BY_ID = "update employee set DepartmentId = ?, Name = ?, birthDate = ?, address= ?, phone= ?, HireDate= ?, email=?, where EmployeeId = ?";
}
