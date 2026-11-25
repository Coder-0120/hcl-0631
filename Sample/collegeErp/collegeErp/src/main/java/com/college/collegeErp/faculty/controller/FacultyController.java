package com.college.collegeErp.faculty.controller;

import com.college.collegeErp.faculty.entity.Faculty;
import com.college.collegeErp.faculty.entity.FacultyStatus;
import com.college.collegeErp.faculty.service.FacultyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // 1. Create Faculty
    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    // 2. Get All Faculty
    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    // 3. Get Faculty By ID
    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    // 4. Update Faculty
    @PutMapping("/{id}")
    public Faculty updateFaculty(
            @PathVariable Long id,
            @RequestBody Faculty faculty) {

        return facultyService.updateFaculty(id, faculty);
    }

    // 5. Delete Faculty
    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return "Faculty deleted successfully";
    }

    // 6. Search By Employee Code
    @GetMapping("/employee-code/{employeeCode}")
    public Faculty getByEmployeeCode(@PathVariable String employeeCode) {
        return facultyService.getByEmployeeCode(employeeCode);
    }

    // 7. Get Faculty By Department
    @GetMapping("/department/{departmentId}")
    public List<Faculty> getByDepartment(@PathVariable Long departmentId) {
        return facultyService.getByDepartment(departmentId);
    }

    // 8. Search By Designation
    @GetMapping("/designation")
    public List<Faculty> getByDesignation(@RequestParam String designation) {
        return facultyService.getByDesignation(designation);
    }

    // 9. Search By Status
    @GetMapping("/status")
    public List<Faculty> getByStatus(@RequestParam FacultyStatus status) {
        return facultyService.getByStatus(status);
    }

    // 10. Search By Specialization
    @GetMapping("/specialization")
    public List<Faculty> getBySpecialization(@RequestParam String specialization) {
        return facultyService.getBySpecialization(specialization);
    }
}