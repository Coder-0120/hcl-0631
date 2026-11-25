package com.college.collegeErp.student.controller;

import com.college.collegeErp.student.entity.Student;
import com.college.collegeErp.student.entity.StudentStatus;
import com.college.collegeErp.student.service.StudentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Register student
    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    // 2. Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 3. Get student by ID
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    // 4. Get student by enrollment number
    @GetMapping("/enrollment/{enrollmentNumber}")
    public Student getStudentByEnrollmentNumber(
            @PathVariable String enrollmentNumber) {
        return studentService.getStudentByEnrollmentNumber(enrollmentNumber);
    }

    // 5. Update student details
    @PutMapping("/{studentId}")
    public Student updateStudent(
            @PathVariable Long studentId,
            @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    // 6. Delete student
    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    // 7. Get students by course
    @GetMapping("/course/{courseId}")
    public List<Student> getStudentsByCourse(@PathVariable Long courseId) {
        return studentService.getStudentsByCourse(courseId);
    }

    // 8. Get students by department
    @GetMapping("/department/{departmentId}")
    public List<Student> getStudentsByDepartment(
            @PathVariable Long departmentId) {
        return studentService.getStudentsByDepartment(departmentId);
    }

//     9. Search students by name
    @GetMapping("/search")
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }

    // 10. Change student status
    @PatchMapping("/{studentId}/status")
    public Student changeStudentStatus(
            @PathVariable Long studentId,
            @RequestBody StudentStatus status) {
        return studentService.changeStudentStatus(studentId, status);
    }

    // 11. View student profile
    @GetMapping("/{studentId}/profile")
    public Student viewStudentProfile(@PathVariable Long studentId) {
        return studentService.viewStudentProfile(studentId);
    }
}

