package com.github.dayannas.employee_management.controller;

import com.github.dayannas.employee_management.entity.Employee;
import com.github.dayannas.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployee(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/add-new-employee")
    public String addNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-info";
    }

    @RequestMapping("/save-employee")
    public String saveEmployee(@ModelAttribute(name = "employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/update-employee")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute(employee);
        return "employee-info";
    }

    @RequestMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
