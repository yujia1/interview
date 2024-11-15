package com.example.demointerview.controller;

import com.example.demointerview.entity.Product;
import com.example.demointerview.entity.User;
import com.example.demointerview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    MessageService messageService;

    //http://localhost:8080/api/test/jj
    @GetMapping("/public/{name}")
    public String test(@PathVariable String name) {
        return "hello " + name;
    }
    //http://localhost:8080/api/test?name=yy
    @GetMapping("/user/test")
    public String test1(@RequestParam(defaultValue = "GG") String name) {
        return "Bye " + name;
    }
    //http://localhost:8080/api/user
//    @GetMapping("/user")
//    public User getUser() {
//        return new User("YJ", 32);
//    }

    @PostMapping("/admin/product")
    public String addProduct(@RequestBody Product product) {
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return "Product " + product1.getName() + " with price $" + product1.getPrice() + " added successfully!";
    }


    @GetMapping("/message")
    public String message() {
        return messageService.getMessage();
    }

}
