package org.example;


import org.springframework.stereotype.Controller;

@Controller
@ResponseBody
public class HelloWorld {
    @GetMapping("/")
    public String hello(){
        System.out.println("Hello World");
        return "hello folks, Welcome to SpringBoot Rollercoater";
    }
}
