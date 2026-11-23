package com.college.collegeErp.course.entity;

import com.college.collegeErp.department.entity.Department;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String courseCode;
    private Integer duration;
    private Integer totalSemesters;
    private String description;
    private Boolean active=true;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    public Course(){

    }

    public Course(Long courseId, String courseName, String courseCode, Integer duration, Integer totalSemesters, String description, Boolean active, Department department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.duration = duration;
        this.totalSemesters = totalSemesters;
        this.description = description;
        this.active = active;
        this.department = department;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTotalSemesters() {
        return totalSemesters;
    }

    public void setTotalSemesters(Integer totalSemesters) {
        this.totalSemesters = totalSemesters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
