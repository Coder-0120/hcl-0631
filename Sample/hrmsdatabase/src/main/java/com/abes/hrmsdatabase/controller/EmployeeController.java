package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String Welcome(){

        return "<h1 >Welcome to Project</h1>";
    }
    @GetMapping("/addemp")
    public String addNewEmp(){

        return  employeeService.createNewEmployee();
    }
    @GetMapping("/findById/{empId}")
    public Employee getEmployeeById(@PathVariable long empId){
        System.out.println("Employe id is "+empId);
        return employeeService.getEmployeeById(empId);
    }
}
