package com.eshopping.userservice.controller;

import com.eshopping.userservice.model.User;
import com.eshopping.userservice.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/getbyid/{id}")
    public Optional<User> getUser(@PathVariable ObjectId id){
        return this.userService.getById(id);
    }

    @PostMapping(path = "/create")
    public List<User> createUser(@RequestBody List<User> users){
        return this.userService.createUser(users);
    }

}
