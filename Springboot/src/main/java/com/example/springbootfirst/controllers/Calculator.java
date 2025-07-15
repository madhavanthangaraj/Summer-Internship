package com.example.springbootfirst.controllers;

public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Cannot divide by zero");
            return 0; // Return a default value or consider throwing an exception
        }
        return numerator / denominator;
    }
}
