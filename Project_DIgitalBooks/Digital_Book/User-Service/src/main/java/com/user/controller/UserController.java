package com.user.controller;

import com.user.entity.User;
import com.user.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping({"/registerNewAdmin"})
    public User registerNewAdmin(@RequestBody User user) {
        return userService.registerNewAdmin(user);
    }
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

}
