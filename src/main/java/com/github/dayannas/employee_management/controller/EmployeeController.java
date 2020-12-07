package com.github.dayannas.employee_management.controller;

import com.github.dayannas.employee_management.dao.EmployeeDao;
import com.github.dayannas.employee_management.entity.Employee;
import com.github.dayannas.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployee(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/add-new-employee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/save-employee")
    public String saveEmployee(@ModelAttribute(name = "Employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
