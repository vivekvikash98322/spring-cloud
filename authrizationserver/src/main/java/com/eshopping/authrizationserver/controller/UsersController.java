package com.eshopping.authrizationserver.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
public class UsersController {

    @GetMapping("/info")
    public String getInfo(){
        return "This is my info";
    }
}
