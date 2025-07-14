package com.example.springbootfirst.Controllers;

import com.example.springbootfirst.Services.HelloWorldService;
import com.example.springbootfirst.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;

    @GetMapping
    public List<Employee> getMethod(){
        return hws.getmethod();
    }
    @GetMapping("id/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
        return hws.getEmployeeById(empId);
    }

    @GetMapping("job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }
    @GetMapping("name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return hws.getEmployeeByName(name);
    }
    @PostMapping
    public String postmethod(@RequestBody Employee employee){
        return hws.postmethod(employee);
    }
//
    @PutMapping()
    public String putmethod(@RequestBody Employee employee){
        return hws.putmethod(employee);
    }

    @DeleteMapping("id/{empId}")
    public String deletemethod(@PathVariable int empId){
        return hws.deletebyid(empId);
    }

    @DeleteMapping
    public String deletemethod(){
        return hws.deletemethod();
    }

}
