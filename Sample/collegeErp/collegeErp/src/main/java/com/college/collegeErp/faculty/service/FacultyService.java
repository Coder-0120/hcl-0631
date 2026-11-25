package com.college.collegeErp.faculty.service;

import com.college.collegeErp.faculty.entity.Faculty;
import com.college.collegeErp.faculty.entity.FacultyStatus;
import com.college.collegeErp.faculty.repository.FacultyRepository;

import com.college.collegeErp.department.entity.Department;
import com.college.collegeErp.department.repository.DepartmentRepository;

import com.college.collegeErp.student.repository.StudentRepository;
import com.college.collegeErp.user.entity.User;
import com.college.collegeErp.user.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;


    public FacultyService(
            FacultyRepository facultyRepository,
            DepartmentRepository departmentRepository,
            UserRepository userRepository,
            StudentRepository studentRepository) {

        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    // 1. Create Faculty
    public Faculty createFaculty(Faculty faculty) {

        if (facultyRepository.existsByEmployeeCode(faculty.getEmployeeCode())) {
            throw new RuntimeException("Employee code already exists");
        }

        if (faculty.getDepartment() != null) {
            Department department = departmentRepository
                    .findById(faculty.getDepartment().getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            faculty.setDepartment(department);
        }

        if (faculty.getUser() != null) {

            Long userId = faculty.getUser().getUserId();

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (studentRepository.existsByUserUserId(userId)) {
                throw new RuntimeException(
                        "This user is already registered as a Student"
                );
            }

            if (facultyRepository.existsByUserUserId(userId)) {
                throw new RuntimeException(
                        "This user is already registered as Faculty"
                );
            }

            faculty.setUser(user);
        }
        if (faculty.getStatus() == null) {
            faculty.setStatus(FacultyStatus.ACTIVE);
        }

        return facultyRepository.save(faculty);
    }

    // 2. Get All Faculty
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    // 3. Get Faculty By ID
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    // 4. Update Faculty
    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {

        Faculty faculty = getFacultyById(id);

        faculty.setEmployeeCode(updatedFaculty.getEmployeeCode());
        faculty.setQualification(updatedFaculty.getQualification());
        faculty.setSpecialization(updatedFaculty.getSpecialization());
        faculty.setExperience(updatedFaculty.getExperience());
        faculty.setJoiningDate(updatedFaculty.getJoiningDate());
        faculty.setDesignation(updatedFaculty.getDesignation());
        faculty.setPhone(updatedFaculty.getPhone());
        faculty.setAddress(updatedFaculty.getAddress());
        faculty.setStatus(updatedFaculty.getStatus());

        if (updatedFaculty.getDepartment() != null) {
            Department department = departmentRepository
                    .findById(updatedFaculty.getDepartment().getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            faculty.setDepartment(department);
        }

        if (updatedFaculty.getUser() != null) {
            User user = userRepository
                    .findById(updatedFaculty.getUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            faculty.setUser(user);
        }

        return facultyRepository.save(faculty);
    }

    // 5. Delete Faculty
    public void deleteFaculty(Long id) {

        Faculty faculty = getFacultyById(id);

        facultyRepository.delete(faculty);
    }

    // 6. Search By Employee Code
    public Faculty getByEmployeeCode(String employeeCode) {
        return facultyRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    // 7. Get Faculty By Department
    public List<Faculty> getByDepartment(Long departmentId) {
        return facultyRepository.findByDepartmentDepartmentId(departmentId);
    }

    // 8. Search By Designation
    public List<Faculty> getByDesignation(String designation) {
        return facultyRepository.findByDesignation(designation);
    }

    // 9. Search By Status
    public List<Faculty> getByStatus(FacultyStatus status) {
        return facultyRepository.findByStatus(status);
    }

    // 10. Search By Specialization
    public List<Faculty> getBySpecialization(String specialization) {
        return facultyRepository.findBySpecializationContainingIgnoreCase(specialization);
    }
}
