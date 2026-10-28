package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import com.abes.hrmsdatabase.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendenceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public String markAttendence(Attendance attendance) {

        // Check whether employee details are provided
        if (attendance == null ||
                attendance.getEmployee() == null ||
                attendance.getEmployee().getEmpId() == null) {
            return "Employee ID is required";
        }

        // Get employee ID
        Long empId = attendance.getEmployee().getEmpId();

        // Check whether employee exists
        if (!employeeRepository.existsById(empId)) {
            return "Employee does not exist";
        }

        // Get today's date
        LocalDate today = LocalDate.now();

        // Check whether attendance is already marked today
        if (attendanceRepository
                .existsByEmployee_EmpIdAndAttendancedate(empId, today)) {
            return "Attendance already marked for today";
        }

        // Set today's date
        attendance.setAttendancedate(today);

        // Set current check-in time
        attendance.setInTime(LocalDateTime.now());

        // Find the existing employee
        Employee employee = employeeRepository.findById(empId).orElse(null);

        if (employee == null) {
            return "Employee does not exist";
        }

        // Attach the existing employee to attendance
        attendance.setEmployee(employee);

        // Save attendance
        attendanceRepository.save(attendance);

        return "Attendance marked successfully";
    }

    public List<Attendance> getAttendance(Long empId) {

        return attendanceRepository
                .findByEmployee_EmpIdOrderByAttendanceIdDesc(empId);
    }
}