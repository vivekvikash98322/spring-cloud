package com.eshopping.userservice.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.eshopping.userservice.config.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document
@Data
public class User {

    @MongoId(FieldType.OBJECT_ID)
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;

    private String name;

    private String phoneNumber;

    private String email;

}
