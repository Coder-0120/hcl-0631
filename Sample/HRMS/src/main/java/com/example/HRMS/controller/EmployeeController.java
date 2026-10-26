package com.example.HRMS.controller;

import com.example.HRMS.model.Employee;
import com.example.HRMS.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to HCL HRMS";
    }
    @GetMapping("/addEmp")
    public String addNewEmployee(){
        return employeeService.addEmp();
    }

    @GetMapping("/getEmployee")
    public ArrayList<Employee> getEmployee(){
        return employeeService.getEmp();
    }

    @GetMapping("/getById")
    public Employee getEmployeeById(){
        return employeeService.getEmployeeById(1);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(){
        return employeeService.deleteById(1);
    }
    @GetMapping("/addInBulk")
    public ArrayList<Employee> addInBulk(){
        return employeeService.addInBulk();
    }
    @PutMapping("/updateById")
    public String updateById(){
        return employeeService.updateById();
    }

}