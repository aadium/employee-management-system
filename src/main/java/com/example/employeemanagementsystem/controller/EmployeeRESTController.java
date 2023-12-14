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

    @GetMapping("/addEmployee")
    public ModelAndView showAddEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return "redirect:/addEmployee/success/" + savedEmployee.getId();
    }

    @GetMapping("/addEmployee/success/{employeeId}")
    public ModelAndView showSuccessPage(@PathVariable Long employeeId) {
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("employeeId", employeeId);
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
