package com.college.collegeErp.subject.controller;

import com.college.collegeErp.subject.entity.Subject;
import com.college.collegeErp.subject.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        Subject newsubject=subjectService.createSubject(subject);
        return newsubject;
    }
    @GetMapping
    public List<Subject>getAllSubjects(){
        return subjectService.getAllSubjects();
    }
    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }
    @PutMapping("/{id}")
    public Subject updateSubjectById(@PathVariable Long id,@RequestBody Subject subject){
        return subjectService.updateSubjectById(id,subject);
    }
    @DeleteMapping("/{id}")
    public String deleteSubjectById(@PathVariable Long id){
        return subjectService.deleteSubjectById(id);
    }
    @GetMapping("/code/{code}")
    public Subject getSubjectByCode(@PathVariable String code){
        return subjectService.getSubjectByCode(code);
    }
    @GetMapping("/course/{courseId}")
    public List<Subject> getSubjectByCourseId(@PathVariable Long courseId){
        return subjectService.getSubjectByCourseId(courseId);
    }
    @GetMapping("/semester/{semesterNumber}")
    public List<Subject> getSubjectBySemesterNumber(@PathVariable Integer semesterNumber){
        return subjectService.getSubjectBySemesterNumber(semesterNumber);
    }
    @PatchMapping("/status/{id}")
    public String changeSubjectStatus(@PathVariable Long id, @RequestBody Boolean status){
        return subjectService.changeSubjectStatus(id, status);
    }
    @GetMapping("/course/{courseId}/semester/{semesterNumber}")
    public List<Subject> getSubjectByCourseAndSemester(@PathVariable Long courseId, @PathVariable Integer semesterNumber){
        return subjectService.getSubjectByCourseAndSemester(courseId, semesterNumber);
    }
}
