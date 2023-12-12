package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ModelAndView getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("Number of employees: " + employees.size());
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
