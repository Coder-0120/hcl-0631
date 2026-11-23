package com.college.collegeErp.course.controller;

import com.college.collegeErp.course.entity.Course;
import com.college.collegeErp.course.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public Course createCourse(@RequestBody Course course){
        Course newcourse=courseService.createCourse(course);
        return newcourse;
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }
    @GetMapping("/code/{code}")
    public Course getCourseByCode(@PathVariable String code){
        return courseService.getCourseByCode(code);
    }
    @GetMapping("/department/{departmentId}")
    public List<Course> getCoursesByDepartmentId(@PathVariable Long departmentId){
        return courseService.getCoursesByDepartmentId(departmentId);
    }
    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable Long id,@RequestBody Course course){
        return courseService.updateCourseById(id,course);
    }
    @DeleteMapping("/{id}")
    public String deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return "Course deleted successfully";
    }
}
