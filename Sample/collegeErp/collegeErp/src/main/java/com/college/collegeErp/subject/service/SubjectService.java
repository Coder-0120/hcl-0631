package com.college.collegeErp.subject.service;

import com.college.collegeErp.course.entity.Course;
import com.college.collegeErp.course.repository.CourseRepository;
import com.college.collegeErp.subject.entity.Subject;
import com.college.collegeErp.subject.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final CourseRepository courseRepository;

    public SubjectService(SubjectRepository subjectRepository, CourseRepository courseRepository) {
        this.subjectRepository = subjectRepository;
        this.courseRepository = courseRepository;
    }
    public Subject createSubject(Subject subject){
        if (subject.getCourse()==null || subject.getCourse().getCourseId()==null){
            throw new RuntimeException("Course is required for creating a subject");
        }
        Long courseId=subject.getCourse().getCourseId();
        Course course=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course not found with id: "+courseId));
        subject.setCourse(course);
        return subjectRepository.save(subject);
    }
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
    public Subject getSubjectById(Long id){
        return subjectRepository.findById(id).orElseThrow(()->new RuntimeException("Subject not found with id: "+id));
    }
    public Subject updateSubjectById(Long id,Subject subject){
        Subject existingSubject=getSubjectById(id);
        if (existingSubject != null) {
            existingSubject.setSubjectName(subject.getSubjectName());
            existingSubject.setDescription(subject.getDescription());
            existingSubject.setSubjectType(subject.getSubjectType());
            existingSubject.setCredits(subject.getCredits());
            existingSubject.setSemesterNumber(subject.getSemesterNumber());
            return subjectRepository.save(existingSubject);
        }
        throw new RuntimeException("Subject not found with id: " + id);
    }
    public String deleteSubjectById(Long id){
        Subject existingSubj=getSubjectById(id);
        if (existingSubj != null) {
            subjectRepository.delete(existingSubj);
            return "Subject deleted successfully";
        }
        throw new RuntimeException("Subject not found with id: " + id);
    }
    public Subject getSubjectByCode(String code){
        return subjectRepository.findBySubjectCode(code);
    }
    public List<Subject> getSubjectByCourseId(Long courseId){
        return subjectRepository.findByCourse_CourseId(courseId);
    }
    public List<Subject> getSubjectBySemesterNumber(Integer semesterNumber){
        return subjectRepository.findBySemesterNumber(semesterNumber);
    }
    public String changeSubjectStatus(Long id, Boolean status){
        Subject existingSubject=getSubjectById(id);
        if (existingSubject != null) {
            existingSubject.setActive(status);
            subjectRepository.save(existingSubject);
            return "Subject status updated successfully";
        }
        throw new RuntimeException("Subject not found with id: " + id);
    }
    public List<Subject> getSubjectByCourseAndSemester(Long courseId, Integer semesterNumber){
        return subjectRepository.findByCourse_CourseIdAndSemesterNumber(courseId, semesterNumber);
    }
}
