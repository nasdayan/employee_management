package com.github.dayannas.employee_management.dao;

import com.github.dayannas.employee_management.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
}
