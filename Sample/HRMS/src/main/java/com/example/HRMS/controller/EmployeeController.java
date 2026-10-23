package com.example.HRMS.controller;

import com.example.HRMS.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private Employee emp;
    @GetMapping("/")
    public String Welcome(){
        return "<h1 style='color:red'>Welcome to SpringBoot Application <h1/>";
    }

    @GetMapping("/add")
    public int Sum(){
        System.out.println("Add method");
        return emp.add();
    }

    @GetMapping("/root")
    public double squareRoot(){
        return emp.squareRoot(123);
    }

    @GetMapping("/greater")
    public int greater(){
        return emp.greater(20,40);
    }
}
