package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute() {
        String response = employeeController.route();
        assertEquals("Welcome to spring boot route", response);
    }

    @Test
    void testGetMethod() {
        RegisterDetails employee1 = new RegisterDetails();
        RegisterDetails employee2 = new RegisterDetails();

        List<RegisterDetails> mockEmployeeList = Arrays.asList(employee1, employee2);
        when(employeeService.getAllEmployees()).thenReturn(mockEmployeeList);

        List<RegisterDetails> actualEmployeeList = employeeController.getEmployees();
        assertEquals(2, actualEmployeeList.size());
    }
}
