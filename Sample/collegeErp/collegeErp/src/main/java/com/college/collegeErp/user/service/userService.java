package com.college.collegeErp.user.service;

import com.college.collegeErp.user.entity.User;
import com.college.collegeErp.user.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final userRepository userRepository;
    public userService(userRepository userRepository){
        this.userRepository=userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User updateUserById(Long id,User user){
        User existuser=getUserById(id);
        if (existuser==null){
            return null;
        }
        existuser.setFirstName(user.getFirstName());
        existuser.setLastName(user.getLastName());
        existuser.setEmail(user.getEmail());
        existuser.setPhone(user.getPhone());
        return userRepository.save(existuser);
    }
    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public String deleteUserById(Long id){
        User existUser=getUserById(id);
        if (existUser==null){
            return "User not found";
        }
        userRepository.delete(existUser);
        return "User deleted successfully";
    }
    public List<User> getUsersByRole(String role){
        return userRepository.getUsersByRole(role);
    }
    public User changeUserStatus(Long id,boolean enabled){
        User user=getUserById(id);
        if (user==null){
            return null;
        }
        user.setEnabled(enabled);
        return userRepository.save(user);
    }
}
