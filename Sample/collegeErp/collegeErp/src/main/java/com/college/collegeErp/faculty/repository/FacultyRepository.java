package com.college.collegeErp.faculty.repository;

import com.college.collegeErp.faculty.entity.Faculty;
import com.college.collegeErp.faculty.entity.FacultyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByEmployeeCode(String employeeCode);

    boolean existsByEmployeeCode(String employeeCode);

    List<Faculty> findByDepartmentDepartmentId(Long departmentId);

    List<Faculty> findByDesignation(String designation);

    List<Faculty> findByStatus(FacultyStatus status);

    List<Faculty> findBySpecializationContainingIgnoreCase(String specialization);
    boolean existsByUserUserId(Long userId);
}