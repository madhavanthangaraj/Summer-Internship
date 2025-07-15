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
    EmployeeService hws;

    @GetMapping("/")
    public String route() {
        return "Welcome to spring boot route";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/employees")
    public List<RegisterDetails> getEmployees() {
        return hws.getAllEmployees(); // 🔁 Fix 1
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/id/{id}")
    public RegisterDetails getEmployeeById(@PathVariable int id) {
        return hws.getEmployeeById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employees")
    public String addEmployee(@RequestBody RegisterDetails emp) {
        return hws.addEmployee(emp); // 🔁 Fix 2
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails emp) {
        return hws.updateEmployee(id, emp); // 🔁 Fix 3
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employees")
    public String deleteEmployees() {
        return hws.deleteEmployees(); // 🔁 Fix 4
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("/id/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        return hws.deleteEmployeeById(id);
    }
}
