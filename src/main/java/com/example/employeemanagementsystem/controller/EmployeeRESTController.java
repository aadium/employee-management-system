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

    @GetMapping("/")
    public ModelAndView getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        ModelAndView modelAndView = new ModelAndView("employeeById");
        modelAndView.addObject("employeeById", employee);
        return modelAndView;
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
