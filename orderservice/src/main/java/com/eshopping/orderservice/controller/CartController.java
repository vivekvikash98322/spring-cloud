package com.eshopping.orderservice.controller;

import com.eshopping.orderservice.model.Cart;
import com.eshopping.orderservice.request.AddToCartRequest;
import com.eshopping.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/add")
    public Cart addToCart(@RequestBody AddToCartRequest addToCartRequest) throws Exception {
       return this.cartService.addToCart(addToCartRequest);
    }
}
