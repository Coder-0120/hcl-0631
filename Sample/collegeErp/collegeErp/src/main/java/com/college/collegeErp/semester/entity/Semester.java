package com.college.collegeErp.semester.entity;

import com.college.collegeErp.course.entity.Course;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semesterId;
    private Integer semesterNumber;
    private String semesterName;
    private String academicYear;
    private Boolean active=true;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Semester(){

    }
    public Semester(Long semesterId, Integer semesterNumber, String semesterName, String academicYear, Boolean active, LocalDateTime startDate, LocalDateTime endDate, Course course) {
        this.semesterId = semesterId;
        this.semesterNumber = semesterNumber;
        this.semesterName = semesterName;
        this.academicYear = academicYear;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
