package com.college.collegeErp.subject.entity;

import com.college.collegeErp.course.entity.Course;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String description;
    private Integer credits;
    private Integer semesterNumber;
    private Boolean active=true;
    @Enumerated(EnumType.STRING)
    private SubjectType  subjectType;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)

    private Course course;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Subject(){

    }
    public Subject(Long subjectId, String subjectName, String subjectCode, String description, Integer credits, Integer semesterNumber, Boolean active, SubjectType subjectType, Course course, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.description = description;
        this.credits = credits;
        this.semesterNumber = semesterNumber;
        this.active = active;
        this.subjectType = subjectType;
        this.course = course;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(Integer semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // Automatically update updatedAt before updating
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
