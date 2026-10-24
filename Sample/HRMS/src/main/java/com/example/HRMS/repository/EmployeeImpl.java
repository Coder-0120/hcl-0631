package com.example.HRMS.repository;

import com.example.HRMS.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeImpl implements EmployeeRepo{
    ArrayList<Employee>empList=new ArrayList<>();

    @Override
    public String addEmp(Employee emp) {
        empList.add(emp);
        return "Hey "+emp.getEmp_name()+" Employee Added Successfully!" +" with "+emp.toString();
    }

    @Override
    public ArrayList<Employee> getEmp() {
        return new ArrayList<>(empList);
    }

    @Override
    public Employee getEmpById(long empid) {
//        for(int i=0;i<empList.size();i++){
//            if(empList.get(i).getEmp_id()==empid){
//                return empList.get(i);
//            }
//        }
        return empList.stream().filter(e->e.getEmp_id()==empid).findFirst().orElse(null);
    }

    @Override
    public String deleteById(long empId) {
        boolean status=false;
        if(getEmpById((empId))!=null){
            status=empList.removeIf(e->e.getEmp_id()==empId);
        }
        if(status){
            return "Employee deleted successfully";
        }
        return "Employee is not registered with id "+empId;
    }

    @Override
    public String updateById(long empid, Employee updatedEmp) {
        Employee existingEmp=getEmpById(empid);
        if(existingEmp==null){
            return "Employee not exist with this id";
        }
        if(existingEmp!=null){
            existingEmp.setEmail(updatedEmp.getEmail());
            existingEmp.setDesignation(updatedEmp.getDesignation());
        }
        return "Employee updated successfully";

    }

    @Override
    public ArrayList<Employee> addInBulk(ArrayList<Employee>ls) {
        if(empList.addAll(ls))
            return new ArrayList<>(empList);
        return empList;
    }

}