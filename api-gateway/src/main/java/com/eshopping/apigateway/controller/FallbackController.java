package com.eshopping.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @PostMapping("/exception/order")
    public ResponseEntity<String> orderException(){
        return ResponseEntity.internalServerError()
                .body("Unknow error occured");
    }
}
