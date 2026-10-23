package com.example.HRMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping
    public String Welcome(){
        return "<h5>Welcome Guys</h5>";
    }
    @GetMapping("/add")
    public int Sum(){
        int a=20;
        int b=30;
        return a+b;
    }
}
