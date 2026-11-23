package com.college.collegeErp.course.service;

import com.college.collegeErp.course.entity.Course;
import com.college.collegeErp.course.repository.CourseRepository;
import com.college.collegeErp.department.entity.Department;
import com.college.collegeErp.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }
    public Course createCourse(Course course) {
        if (course.getDepartment() == null ||
                course.getDepartment().getDepartmentId() == null) {
            throw new RuntimeException("Department ID is required");
        }
        Long departmentId=course.getDepartment().getDepartmentId();
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        course.setDepartment(department);
        return courseRepository.save(course);
    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
    public Course getCourseByCode(String code){
        return courseRepository.findByCourseCode(code);
    }
    public List<Course> getCoursesByDepartmentId(Long id){
        return courseRepository.findByDepartment_DepartmentId(id);
    }
    public Course updateCourseById(Long id,Course course){
        Course existing=getCourseById(id);
        if(existing==null){
            return null;
        }
        existing.setCourseName(course.getCourseName());
        existing.setCourseCode(course.getCourseCode());
        existing.setDuration(course.getDuration());
        existing.setDescription(course.getDescription());
        existing.setTotalSemesters(course.getTotalSemesters());
        existing.setDepartment(course.getDepartment());
        return courseRepository.save(existing);
    }
    public String deleteCourseById(Long id){
        Course existing =getCourseById(id);
        if (existing != null) {
            courseRepository.delete(existing);
            return "Course deleted successfully";
        }
        return "Course not found";
    }
}
