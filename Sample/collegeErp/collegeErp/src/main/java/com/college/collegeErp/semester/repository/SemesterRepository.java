package com.college.collegeErp.semester.repository;

import com.college.collegeErp.semester.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
    List<Semester> findByCourse_CourseId(Long courseId);

    boolean existsByCourse_CourseIdAndSemesterNumberAndAcademicYear(
            Long courseId,
            Integer semesterNumber,
            String academicYear
    );
    Semester findByCourse_CourseIdAndSemesterNumber(Long courseId, Integer semesterNumber);
}
