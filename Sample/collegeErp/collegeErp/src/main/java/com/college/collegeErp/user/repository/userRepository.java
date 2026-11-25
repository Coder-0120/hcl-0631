package com.college.collegeErp.user.repository;

import com.college.collegeErp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    List<User> getUsersByRole(String role);
}
