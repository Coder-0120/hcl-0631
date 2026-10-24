package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public  String createNewEmployee(){
        Employee emp1=new Employee(200L,"Anshul Verma","Java FSD","developer");
        employeeRepository.save(emp1);
        return "Employee is added successfully";
    }
}
