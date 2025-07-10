package com.example.springbootfirst.Services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1,"prasanth","trainer"),new Employee(2,"yuvaraj","faculty"))
    );

    @Autowired
    EmployeeRepository empRepo;
    public List<Employee> getmethod(){
        return empRepo.findAll();
    }

    public String postmethod(Employee employee){
        empRepo.save(employee);
        return "employee added successfully";
    }

    public Employee getEmployeeById(int empId) {
        return empRepo.findById(empId).orElse(new Employee());
    }



    public String putmethod(Employee employee) {
        empRepo.save(employee);
        return "employee updated successfully";
    }

    public String deletebyid(int empId) {
        empRepo.deleteById(empId);
        return "deleted successfully";
    }

    public List<Employee> getEmployeeByJob(String job) {
        return empRepo.findByJob(job);
    }

    public List<Employee> getEmployeeByName(String name) {
        return empRepo.findByName(name);
    }

    public String deletemethod() {
        empRepo.deleteAll();
        return "deleted all records successfully";
    }
}
