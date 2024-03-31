package com.eshopping.authrizationserver.service;

import com.eshopping.authrizationserver.dao.UserRepository;
import com.eshopping.authrizationserver.entity.Roles;
import com.eshopping.authrizationserver.entity.User;
import com.eshopping.authrizationserver.model.request.AuthenticationRequest;
import com.eshopping.authrizationserver.model.request.RegisterUserRequest;
import com.eshopping.authrizationserver.model.response.AuthenticationResponse;
import com.eshopping.authrizationserver.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public Boolean register(RegisterUserRequest registerUserRequest) {
        User user = User
                .builder()
                .email(registerUserRequest.getEmail())
                .password(passwordEncoder.encode(registerUserRequest.getPassword()))
                .roles(Roles.valueOf(Optional.of(registerUserRequest.getRole()).orElseGet(() -> "ADMIN")))
                .phoneNumber(registerUserRequest.getPhoneNumber())
                .name(registerUserRequest.getName())
                .build();

        this.userRepository.save(user);

        return Boolean.TRUE;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {

       Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),
                authenticationRequest.getPassword()
        ));

       User user = (User) authentication.getPrincipal();

       if (!user.getUsername().equals(authenticationRequest.getEmail())){
           throw new UsernameNotFoundException("No such user found");
       }

        return AuthenticationResponse
                .builder()
                .accessToken(jwtService.generateToken((UserDetails) authentication.getPrincipal()))
                .refreshToken(jwtService.generateRefreshToken((UserDetails)authentication.getPrincipal()))
                .build();
    }
}
