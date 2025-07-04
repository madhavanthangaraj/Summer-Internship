package org.example.services;

import org.example.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp = new ArrayList<>(
            Arrays.asList(
                    new Employee(1,"prasanth","Trainner"),
                    new Employee(2,"Yuvaraj","Faculty"))
    );


    public List<Employee> getMethod() {
        return emp;
    }
    public String HelloWorld(){
        return "Hello Wordld";
    }
    public List<Employee> postMethod(Employee newEmployee) {
        emp.add(newEmployee);
        return emp;
    }

    public String putMethod(int empId, Employee updatedEmployee) {
        for (Employee empObj : emp) {
            if (empObj.getEmpId() == empId) {
                empObj.setName(updatedEmployee.getName());
                empObj.setJob(updatedEmployee.getJob());
                return "Employee updated successfully";
            }
        }
        return "Employee not found";
    }


    public List<Employee> deleteMethod(int empId) {
        emp.removeIf(e -> e.getEmpId() == empId);
        return emp;
    }


}
