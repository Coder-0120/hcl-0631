package com.college.collegeErp.subject.repository;

import com.college.collegeErp.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectCode(String code);
    List<Subject> findByCourse_CourseId(Long courseId);
    List<Subject> findBySemesterNumber(Integer semesterNumber);
    List<Subject> findByCourse_CourseIdAndSemesterNumber(Long courseId, Integer semesterNumber);
}
