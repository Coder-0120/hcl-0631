package com.college.collegeErp.student.service;

import com.college.collegeErp.course.entity.Course;
import com.college.collegeErp.course.repository.CourseRepository;
import com.college.collegeErp.student.entity.Student;
import com.college.collegeErp.student.entity.StudentStatus;
import com.college.collegeErp.student.repository.StudentRepository;
import com.college.collegeErp.user.entity.User;
import com.college.collegeErp.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository,
                          UserRepository userRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }
    // 1. Register student
    public Student registerStudent(Student student) {

        if (studentRepository.existsByEnrollmentNumber(
                student.getEnrollmentNumber())) {
            throw new RuntimeException("Enrollment number already exists");
        }

        if (student.getUser() == null ||
                student.getUser().getUserId() == null) {
            throw new RuntimeException("User ID is required");
        }

        if (student.getCourse() == null ||
                student.getCourse().getCourseId() == null) {
            throw new RuntimeException("Course ID is required");
        }

        Long userId = student.getUser().getUserId();
        Long courseId = student.getCourse().getCourseId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.setUser(user);
        student.setCourse(course);

        return studentRepository.save(student);
    }

    // 2. Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 3. Get student by ID
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // 4. Get student by enrollment number
    public Student getStudentByEnrollmentNumber(String enrollmentNumber) {
        return studentRepository.findByEnrollmentNumber(enrollmentNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // 5. Update student details
    public Student updateStudent(Long studentId, Student updatedStudent) {

        Student existingStudent = getStudentById(studentId);

        // Update basic details
        existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
        existingStudent.setGender(updatedStudent.getGender());
        existingStudent.setAdmissionDate(updatedStudent.getAdmissionDate());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setGuardianName(updatedStudent.getGuardianName());
        existingStudent.setGuardianPhone(updatedStudent.getGuardianPhone());

        // Update course if provided
        if (updatedStudent.getCourse() != null &&
                updatedStudent.getCourse().getCourseId() != null) {

            Long courseId = updatedStudent.getCourse().getCourseId();

            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            existingStudent.setCourse(course);
        }

        return studentRepository.save(existingStudent);
    }

    // 6. Delete student
    public String deleteStudent(Long studentId) {

        Student student = getStudentById(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.delete(student);
        return "Student deleted successfully";
    }

    // 7. Get students by course
    public List<Student> getStudentsByCourse(Long courseId) {

        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }

        return studentRepository.findByCourse_CourseId(courseId);
    }

    // 8. Get students by department
    public List<Student> getStudentsByDepartment(Long departmentId) {

        return studentRepository.findByCourse_Department_DepartmentId(departmentId);
    }

//     9. Search students by name
    public List<Student> searchStudentsByName(String name) {

        if (name == null || name.isBlank()) {
            throw new RuntimeException("Name cannot be empty");
        }

        return studentRepository.searchStudentsByName(name.trim());
    }

    // 10. Change student status
    public Student changeStudentStatus(Long studentId, StudentStatus status) {
        Student student = getStudentById(studentId);
        student.setStatus(status);
        return studentRepository.save(student);
    }

    // 11. View student profile
    public Student viewStudentProfile(Long studentId) {
        return getStudentById(studentId);
    }

}
