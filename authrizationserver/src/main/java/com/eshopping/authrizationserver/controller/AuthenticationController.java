package com.eshopping.authrizationserver.controller;

import com.eshopping.authrizationserver.model.request.AuthenticationRequest;
import com.eshopping.authrizationserver.model.request.RegisterUserRequest;
import com.eshopping.authrizationserver.model.response.AuthenticationResponse;
import com.eshopping.authrizationserver.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping(value = "/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterUserRequest registerUserRequest){
        return ResponseEntity.ok(authenticationService.register(registerUserRequest));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

}
