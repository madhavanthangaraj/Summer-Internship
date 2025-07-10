package spring_boot_app.springboot_firstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to spring boot!";
    }
}
