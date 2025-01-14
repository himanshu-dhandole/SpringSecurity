package com.JWT.demo.controller;


import com.JWT.demo.model.Users;
import com.JWT.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user) ;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user) ;
    }
}
