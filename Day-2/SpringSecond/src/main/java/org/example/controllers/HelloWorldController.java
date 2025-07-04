package org.example.controllers;

import org.example.models.Employee;
import org.example.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }
    @PostMapping("/")
    public List<Employee> postMethod(@RequestBody Employee employee) {
        return hws.postMethod(employee);
    }

    @PutMapping("/{empId}")
    public String putMethod(@PathVariable int empId, @RequestBody Employee employee) {
        return hws.putMethod(empId, employee);
    }


    @DeleteMapping("/{empId}")
    public List<Employee> deleteMethod(@PathVariable int empId) {
        return hws.deleteMethod(empId);
    }


}


