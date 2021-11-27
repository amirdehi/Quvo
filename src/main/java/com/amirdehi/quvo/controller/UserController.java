package com.amirdehi.quvo.controller;

import com.amirdehi.quvo.dto.request.UserRequest;
import com.amirdehi.quvo.dto.response.UserResponse;
import com.amirdehi.quvo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public boolean createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("/showUser/{userId}")
    public UserResponse showUser(@PathVariable int userId){
        return userService.readUser(userId);
    }

    @GetMapping("/showUserByUserName/{username}")
    public UserResponse showUser(@PathVariable String username){
        return userService.readUser(username);
    }

    @PutMapping("/updateUser")
    public boolean updateUser(@RequestBody UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public boolean deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }

    @DeleteMapping("/deleteUserByUserName/{username}")
    public boolean deleteUser(@PathVariable String username){
        return userService.deleteUser(username);
    }
}
