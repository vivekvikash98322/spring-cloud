package com.eshopping.orderservice.model;
import com.eshopping.orderservice.config.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.bson.types.ObjectId;

public class CartItem {

    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId productId;

    private Integer quantity;
}
