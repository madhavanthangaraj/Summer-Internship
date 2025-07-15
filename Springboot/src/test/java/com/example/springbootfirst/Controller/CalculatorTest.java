package com.example.springbootfirst.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        int sum = calculator.add(15, 13);
        System.out.println("Addition Result: " + sum);
        assertEquals(28, sum);
    }

    @Test
    public void testSubtraction() {
        int difference = calculator.subtract(30, 20);
        System.out.println("Subtraction Result: " + difference);
        assertEquals(10, difference);
    }

    @Test
    public void testMultiplication() {
        int product = calculator.multiply(7, 8);
        System.out.println("Multiplication Result: " + product);
        assertEquals(56, product);
    }

    @Test
    public void testDivision() {
        int quotient = calculator.divide(20, 5);
        System.out.println("Division Result: " + quotient);
        assertEquals(4, quotient);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
