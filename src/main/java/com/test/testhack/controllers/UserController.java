package com.test.testhack.controllers;

import com.test.testhack.models.OrgModel;
import com.test.testhack.models.UserModel;
import com.test.testhack.schemas.user.GetUsersSchema;
import com.test.testhack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/get")
    public List<UserModel> getUsers(GetUsersSchema userData){
        return userService.getUsers(userData);
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @GetMapping("/{id}/orgs_own")
    public List<OrgModel> getAllOwnedOrgs(@PathVariable Long id){
        return userService.getUserOrgs(id);
    }

}
