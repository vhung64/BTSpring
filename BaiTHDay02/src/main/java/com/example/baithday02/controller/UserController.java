package com.example.baithday02.controller;

import com.example.baithday02.model.User;
import com.example.baithday02.request.UserRequest;
import com.example.baithday02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("login")
    // Trả về thông tin của user bao gồm username, email, avatar
    public String getUser(@RequestBody UserRequest userRequest){
        return userService.getUser(userRequest);
    }
}
