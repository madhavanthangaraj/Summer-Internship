package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private RegisterDetailsRepository repo;

    public List<RegisterDetails> getAllEmployees() {
        return repo.findAll();
    }

    public RegisterDetails getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String addEmployee(RegisterDetails emp) {
        repo.save(emp);
        return "Employee added";
    }

    public String updateEmployee(int id, RegisterDetails emp) {
        emp.setId(id); // assuming your model has setId()
        repo.save(emp);
        return "Employee updated";
    }

    public String deleteEmployees() {
        repo.deleteAll();
        return "All employees deleted";
    }

    public String deleteEmployeeById(int id) {
        repo.deleteById(id);
        return "Employee deleted";
    }
}
