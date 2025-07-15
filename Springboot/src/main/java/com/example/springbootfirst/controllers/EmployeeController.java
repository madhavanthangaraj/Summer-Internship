package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/welcome")
    public String route() {
        return "Welcome to spring boot route";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<RegisterDetails> getEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get by employee Id
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/id/{id}")
    public RegisterDetails getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // Add new employee
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String addEmployee(@RequestBody RegisterDetails employee) {
        return employeeService.addEmployee(employee);
    }

    // Update employee
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // Delete all employees
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public String deleteAllEmployees() {
        return employeeService.deleteEmployees();
    }

    // Delete by ID
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("/id/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
