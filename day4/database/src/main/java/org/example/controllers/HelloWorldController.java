package org.example.controllers;

import org.example.models.Students;
import org.example.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldService hws;

    @GetMapping("/")
    public List<Students> getMethod() {
        return hws.getMethod();
    }

    @PostMapping("/")
    public List<Students> postMethod(@RequestBody Students todo) {
        return hws.postMethod(todo);
    }

    @PutMapping("/{id}")
    public String putMethod(@PathVariable int id, @RequestBody Students updatedTodo) {
        return hws.putMethod(id, updatedTodo);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id) {
        return hws.deleteMethod(id);
    }
}
