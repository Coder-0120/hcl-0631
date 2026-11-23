package com.college.collegeErp.department.controller;

import com.college.collegeErp.department.entity.Department;
import com.college.collegeErp.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }
    @GetMapping("/code/{code}")
    public Department getDepartmentByCode(@PathVariable String code){
        return departmentService.getDepartmentByCode(code);
    }
    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartmentById(id,department);
    }
    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        return departmentService.deleteDepartmentById(id);
    }
    @PatchMapping("/{id}/status")
    public String changeDepartmentStatus(@PathVariable Long id,@RequestBody boolean active){
     departmentService.changeDepartmentStatus(id,active);
     return "Department Status updated";
    }

}
