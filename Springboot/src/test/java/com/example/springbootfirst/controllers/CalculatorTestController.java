package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    @Mock
    RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMethod() {
        RegisterDetails employee1 = new RegisterDetails();
        RegisterDetails employee2 = new RegisterDetails();

        List<RegisterDetails> mockEmployeeList = Arrays.asList(employee1, employee2);
        when(registerDetailsRepository.findAll()).thenReturn(mockEmployeeList);

        List<RegisterDetails> actualEmployeeList = employeeService.getAllEmployees();
        System.out.println(actualEmployeeList);

        assertEquals(2, actualEmployeeList.size());
    }
}
