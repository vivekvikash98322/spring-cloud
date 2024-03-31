package com.eshopping.orderservice.service;

import com.eshopping.orderservice.dao.CartRepository;
import com.eshopping.orderservice.fiegnClients.UserClient;
import com.eshopping.orderservice.model.Cart;
import com.eshopping.orderservice.model.User;
import com.eshopping.orderservice.request.AddToCartRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final UserClient userClient;

    private final CartRepository cartRepository;


    public CartService(UserClient userClient, CartRepository cartRepository) {
        this.userClient = userClient;
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(AddToCartRequest addToCartRequest) throws Exception {
        Optional<User> userOptional = this.userClient.getUserById(addToCartRequest.getUserId());

        if(userOptional.isEmpty()){
            throw new Exception("User not found exception");
        }

        Cart cart = new Cart();
        cart.setCartItems(addToCartRequest.getCartItemList());
        cart.setUserId(userOptional.get().getId());

        return this.cartRepository.save(cart);
    }
}
