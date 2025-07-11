package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Long employeeId, Employee newData) {
        Optional<Employee> empOpt = repository.findById(employeeId);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setEmployeeName(newData.getEmployeeName());
            emp.setEmployeeRole(newData.getEmployeeRole());
            emp.setToDo(newData.getToDo());
            return repository.save(emp);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    public List<Employee> getByRole(String employeeRole) {
        return repository.findByEmployeeRole(employeeRole);
    }

    public String getToDo(Long employeeId) {
        return repository.findById(employeeId)
                .map(emp -> "To-Do for " + emp.getEmployeeName() + ": " + emp.getToDo())
                .orElse("Employee not found");
    }
}
