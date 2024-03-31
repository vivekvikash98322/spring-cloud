package com.eshopping.authrizationserver.model.request;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private String role;
}
