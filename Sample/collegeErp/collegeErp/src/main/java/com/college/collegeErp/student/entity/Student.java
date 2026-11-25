package com.college.collegeErp.student.entity;
import com.college.collegeErp.user.entity.User;
import com.college.collegeErp.course.entity.Course;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(unique = true, nullable = false)
    private String enrollmentNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private LocalDate admissionDate;
    private String address;
    private String guardianName;
    private String guardianPhone;

    @Enumerated(EnumType.STRING)
    private StudentStatus status = StudentStatus.ACTIVE;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Student(){

    }
    public Student(Long studentId, String enrollmentNumber, LocalDate dateOfBirth, String gender, LocalDate admissionDate, String address, String guardianName, String guardianPhone, StudentStatus status, User user, Course course) {
        this.studentId = studentId;
        this.enrollmentNumber = enrollmentNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.admissionDate = admissionDate;
        this.address = address;
        this.guardianName = guardianName;
        this.guardianPhone = guardianPhone;
        this.status = status;
        this.user = user;
        this.course = course;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}