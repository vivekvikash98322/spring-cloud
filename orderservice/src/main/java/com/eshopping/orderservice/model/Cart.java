package com.eshopping.orderservice.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import com.eshopping.orderservice.config.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@Document("cart")
@Data
public class Cart {

    @MongoId(value = FieldType.OBJECT_ID)
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId cartId;


    private ObjectId userId;

    private List<CartItem> cartItems;
}
