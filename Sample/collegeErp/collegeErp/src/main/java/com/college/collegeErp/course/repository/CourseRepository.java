package com.college.collegeErp.course.repository;

import com.college.collegeErp.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseCode(String courseCode);
    List<Course> findByDepartment_DepartmentId(Long departmentId);
}
