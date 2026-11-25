package com.college.collegeErp.student.repository;

import com.college.collegeErp.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find student using enrollment number
    Optional<Student> findByEnrollmentNumber(String enrollmentNumber);

    // Check whether enrollment number already exists
    boolean existsByEnrollmentNumber(String enrollmentNumber);

    // Find students belonging to a particular course
    List<Student> findByCourse_CourseId(Long courseId);

    // Find students belonging to a particular department
    List<Student> findByCourse_Department_DepartmentId(Long departmentId);

    // Search student using first name or last name
    @Query("""
        SELECT s FROM Student s
        JOIN s.user u
        WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%'))
        OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :name, '%'))
        OR LOWER(CONCAT(u.firstName, ' ', u.lastName))
           LIKE LOWER(CONCAT('%', :name, '%'))
        """)
    List<Student> searchStudentsByName(@Param("name") String name);
}

