package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee save(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee newData) {
        return service.updateEmployee(employeeId, newData);
    }

    @GetMapping("/role/{employeeRole}")
    public List<Employee> getByRole(@PathVariable String employeeRole) {
        return service.getByRole(employeeRole);
    }

    @GetMapping("/todo/{employeeId}")
    public String getToDo(@PathVariable Long employeeId) {
        return service.getToDo(employeeId);
    }
}
