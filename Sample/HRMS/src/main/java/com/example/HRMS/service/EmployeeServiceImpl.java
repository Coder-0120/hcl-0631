package com.example.HRMS.service;

import com.example.HRMS.model.Employee;
import com.example.HRMS.repository.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeImpl impl;
    public String addEmp(){
        Employee emp1=new Employee(1,"Anshul","FSD","java","av@gmail.com");
        return  impl.addEmp(emp1);
    }
    public ArrayList<Employee> getEmp(){
        return impl.getEmp();
    }
    public Employee getEmployeeById(long id){
        return impl.getEmpById(id);
    }
    public String deleteById(long id){
        id=4;
        return impl.deleteById(id);
    }
    public String updateById(){
        long id=2;
        Employee Updemp=new Employee(id,"Aman","DataAnalyst","Python","aman@gmail.com");
        return impl.updateById(id,Updemp);
    }
    public ArrayList<Employee> addInBulk(){
        ArrayList<Employee>emp=new ArrayList<>();
        emp.add(new Employee(2,"rkas","Frontend","React","d"));
        emp.add(new Employee(3,"Voikas","Backend","React","d"));
        emp.add(new Employee(4,"gikas","Aspx","HTMl","d"));
        emp.add(new Employee(5,"dkas","Ai","Python","d"));
        return impl.addInBulk(emp);
    }
}