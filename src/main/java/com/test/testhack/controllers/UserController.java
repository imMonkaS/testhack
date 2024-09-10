package com.test.testhack.controllers;

import com.test.testhack.models.UserModel;
import com.test.testhack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserModel user){
        userService.addUser(user);
        return "Success";
    }

    @GetMapping("/id")
    public UserModel getUserById(@RequestParam(required = true) Long user_id){
        return userService.getUserById(user_id);
    }

}
