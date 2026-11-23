package com.college.collegeErp.user.controller;

import com.college.collegeErp.user.entity.User;
import com.college.collegeErp.user.service.userService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class userController {
    private final userService userService;

    public userController(userService userService){
        this.userService=userService;
    }
    @PostMapping()
    public User createUser(@RequestBody User user){
        User newuser=userService.createUser(user);
        return newuser;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable Long id,@RequestBody User user){
        return userService.updateUserById(id,user);
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return "User deleted successfully";
    }
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role){
        return userService.getUsersByRole(role);
    }
    @PatchMapping("/{id}/status")
    public User changeUserStatus(@PathVariable Long id,@RequestBody boolean enabled){
        return userService.changeUserStatus(id,enabled);
    }

}
