package com.eshopping.authrizationserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @GetMapping("/info")
    public String getInfo(){
        return "This is my info";
    }
}
