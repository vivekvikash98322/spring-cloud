package com.eshopping.authrizationserver.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {

    private String message;

    public UserNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }
}
