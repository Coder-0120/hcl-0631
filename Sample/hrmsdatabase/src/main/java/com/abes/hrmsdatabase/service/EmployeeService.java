package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public  String createNewEmployee(){
        Employee emp1=new Employee(200L,"Anshul Verma","Java FSD","developer");
        employeeRepository.save(emp1);
        return "Employee is added successfully";
    }
    public Employee getEmployeeById (long empId){
        return employeeRepository.findById(empId).orElse(null);
    }
    public String deleteEmployeeById(long empId){
         if(employeeRepository.findById(empId).isEmpty())
             return "not found";
        employeeRepository.deleteById(empId);
        return "deleted successfully";
    }
    public Employee updateEmployeeById(long empId, Employee updatedEmp) {
        System.out.println("nbdjsujdskkd");

        Optional<Employee> existing = employeeRepository.findById(empId);

        if (existing.isEmpty()) {
            return null;
        }

        Employee existingEmp = existing.get();

        existingEmp.setEmp_name(updatedEmp.getEmp_name());
        existingEmp.setStack(updatedEmp.getStack());
        existingEmp.setDesignation(updatedEmp.getDesignation());

        return employeeRepository.save(existingEmp);
    }

}
