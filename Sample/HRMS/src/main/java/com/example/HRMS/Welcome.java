package com.example.HRMS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping
    public String Greet(){
        return "<h2>Welcome Anshul</h2>";
    }
}
