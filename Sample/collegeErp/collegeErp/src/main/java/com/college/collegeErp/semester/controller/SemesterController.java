package com.college.collegeErp.semester.controller;

import com.college.collegeErp.semester.entity.Semester;
import com.college.collegeErp.semester.service.SemesterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {
    private final SemesterService semesterService;
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }
    @PostMapping
    public Semester createSemester(@RequestBody Semester semester){
        Semester newSemester =semesterService.createSemester(semester);
        return newSemester;
    }
    @GetMapping
    public List<Semester> getAllSemester(){
        return semesterService.getAllSemesters();
    }
    @GetMapping("/{id}")
    public Semester getSemesterById(@PathVariable Long id){
        return semesterService.getSemesterById(id);
    }
    @PutMapping("/{id}")
    public Semester updateSemesterById(@PathVariable Long id,@RequestBody Semester semester){
        return semesterService.updateSemesterById(id,semester);
    }
    @DeleteMapping("/{id}")
    public String  deleteSemesterById(@PathVariable Long id){
        semesterService.deleteSemesterById(id);
        return "Semester deleted successfully";
    }
    @GetMapping("/course/{courseId}")
    public List<Semester> getSemestersByCourseId(@PathVariable Long courseId){
        return semesterService.getSemestersByCourseId(courseId);
    }
    @GetMapping("/course/{courseId}/semesterNumber/{semesterNumber}")
    public Semester getSemesterByCourseIdAndSemesterNumber(@PathVariable Long courseId, @PathVariable Integer semesterNumber){
        return semesterService.getSemesterByCourseIdAndSemesterNumber(courseId, semesterNumber);
    }
    @PatchMapping("/status/{semesterId}")
    public String changeSemesterStatus(@PathVariable Long semesterId,@RequestBody Boolean status){
        semesterService.changeSemesterStatus(semesterId,status);
        return "Semester status changed successfully";
    }
}
