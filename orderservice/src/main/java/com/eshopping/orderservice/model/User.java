package com.eshopping.orderservice.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class User {
    private ObjectId id;

    private String name;

    private String phoneNumber;

    private String email;
}
