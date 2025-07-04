package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");
        Student s = (Student) context.getBean("st");
        s.internshipProgram();
        System.out.println("Hello World");
        SpringBoot f =(SpringBoot) context.getBean("fun");
        f.hello("hello");
        method1 me1 =(method1) context.getBean("me1");
        method2 me2 =(method2) context.getBean("me2");
        method3 me3 =(method3) context.getBean("me3");
        me1.m1("method1");
        me2.m2("method2");
        me3.m3("method3");

    }
}































