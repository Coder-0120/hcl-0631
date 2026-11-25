package com.college.collegeErp.semester.service;

import com.college.collegeErp.course.entity.Course;
import com.college.collegeErp.course.repository.CourseRepository;
import com.college.collegeErp.semester.entity.Semester;
import com.college.collegeErp.semester.repository.SemesterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;
    private final CourseRepository courseRepository;
    SemesterService(SemesterRepository semesterRepository,CourseRepository courseRepository) {
        this.semesterRepository = semesterRepository;
        this.courseRepository = courseRepository;
    }
    public Semester createSemester(Semester semester){
//        Check whether course exists
        Long courseId=semester.getCourse().getCourseId();
        Course existingCourse =courseRepository.findById(courseId)
                .orElseThrow(()->
                        new RuntimeException("Course not found with id : "+ courseId));

        // check semesterNUmber
        if (semester.getSemesterNumber()==null || semester.getSemesterNumber()<1 || semester.getSemesterNumber()>existingCourse.getTotalSemesters()){
            throw new RuntimeException("Invalid semester number. It should be between 1 and " + existingCourse.getTotalSemesters() + ".");
        }
        // check duplicate semester
        boolean exists=semesterRepository.existsByCourse_CourseIdAndSemesterNumberAndAcademicYear(
                courseId,
                semester.getSemesterNumber(),
                semester.getAcademicYear()
        );
        if (exists) {
            throw new RuntimeException("Semester already exists for the given course and academic year.");
        }
        //  Validate dates
        if (semester.getStartDate() != null &&
                semester.getEndDate() != null &&
                !semester.getStartDate().isBefore(semester.getEndDate())) {

            throw new RuntimeException("Start date must be before end date");
        }
        semester.setCourse(existingCourse);
        return semesterRepository.save(semester);

    }
    public List<Semester> getAllSemesters(){
        return semesterRepository.findAll();
    }
    public Semester getSemesterById(Long id){
        return semesterRepository.findById(id).orElse(null);
    }
    public Semester updateSemesterById(Long id,Semester semester){
        Semester existingSemester=getSemesterById(id);
        if (existingSemester != null) {
            existingSemester.setSemesterName(semester.getSemesterName());
            existingSemester.setEndDate(semester.getEndDate());
            existingSemester.setSemesterNumber(semester.getSemesterNumber());
            existingSemester.setStartDate(semester.getStartDate());
            return semesterRepository.save(existingSemester);
        }
        return null;
    }
    public String deleteSemesterById(Long id){
        Semester existingSemester=getSemesterById(id);
        if (existingSemester != null) {
            semesterRepository.delete(existingSemester);
            return "Semester deleted successfully";
        }
        return "Semester not found";
    }
    public List<Semester> getSemestersByCourseId(Long courseId){
        return semesterRepository.findByCourse_CourseId(courseId);
    }
    public Semester getSemesterByCourseIdAndSemesterNumber(Long courseId, Integer semesterNumber){
        return semesterRepository.findByCourse_CourseIdAndSemesterNumber(courseId, semesterNumber);
    }
    public String changeSemesterStatus(Long semesterId,Boolean status){
        Semester existingSemester=getSemesterById(semesterId);
        if (existingSemester != null) {
            existingSemester.setActive(status);
            semesterRepository.save(existingSemester);
            return "Semester status changed successfully";
        }
        return "Semester not found";
    }
}
