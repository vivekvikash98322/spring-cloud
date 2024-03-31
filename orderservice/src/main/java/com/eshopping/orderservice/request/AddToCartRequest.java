package com.eshopping.orderservice.request;

import com.eshopping.orderservice.model.CartItem;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AddToCartRequest {

    private List<CartItem> cartItemList;

    private ObjectId cartId;

    private ObjectId userId;
}
