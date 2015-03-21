package com.kharkiv.zagnoyko.departments.entity;

/**
 * Created by Frederick on 19.03.2015.
 */
public class Department {

    private static final long serialVersionUID = 1L;

    private int departmentId;

    private String name;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
