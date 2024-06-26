package com.eshopping.orderservice.dao;

import com.eshopping.orderservice.model.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, ObjectId> {
}
