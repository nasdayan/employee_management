package com.github.dayannas.employee_management.service;

import com.github.dayannas.employee_management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
}
