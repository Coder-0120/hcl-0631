package com.college.collegeErp.department.service;

import com.college.collegeErp.department.entity.Department;
import com.college.collegeErp.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }
    public Department getDepartmentByCode(String code){
        return departmentRepository.findByDepartmentCode(code);
    }
    public Department updateDepartmentById(Long id,Department department){
        Department existingdepartment=getDepartmentById(id);
        if (existingdepartment != null) {
            existingdepartment.setDepartmentName(department.getDepartmentName());
            existingdepartment.setDepartmentCode(department.getDepartmentCode());
            existingdepartment.setDescription(department.getDescription());
            return departmentRepository.save(existingdepartment);
        }
        return null;
    }
    public String deleteDepartmentById(Long id){
        Department existingdepartment=getDepartmentById(id);
        if (existingdepartment==null){
            return "User not exist by id";
        }
        departmentRepository.delete(existingdepartment);
        return "User Deleted Successfully";
    }
    public String changeDepartmentStatus(Long id,boolean active){
        Department existingDepartment=getDepartmentById(id);
        if (existingDepartment==null){
            return "Department not exist";
        }
        existingDepartment.setActive(active);
        departmentRepository.save(existingDepartment);
        return "Status updated ";
    }
}
