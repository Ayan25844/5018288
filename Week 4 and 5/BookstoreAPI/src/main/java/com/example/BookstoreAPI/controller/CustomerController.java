package com.example.BookstoreAPI.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name,
            @RequestParam String email) {
        return "Registered customer with name " + name;
    }
}
