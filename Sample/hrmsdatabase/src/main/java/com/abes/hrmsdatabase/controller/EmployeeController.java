package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return employeeService.getEmployeeById(empId);
    }
    @DeleteMapping ("/deleteById/{empId}")
    public String deleteEmployeeById(@PathVariable long empId){
        return employeeService.deleteEmployeeById(empId);
    }
    @PutMapping("/updateById/{empId}")
    public Employee updateEmployeeById(
            @PathVariable long empId,
            @RequestBody Employee updatedEmp) {

        return employeeService.updateEmployeeById(empId, updatedEmp);
    }
}
