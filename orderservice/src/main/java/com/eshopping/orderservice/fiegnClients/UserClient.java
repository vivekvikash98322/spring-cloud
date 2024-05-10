package com.eshopping.orderservice.fiegnClients;

import com.eshopping.orderservice.config.FeignConfig;
import com.eshopping.orderservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient(value = "userservice", configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping(path = "/user/getbyid/{id}")
    Optional<User> getUserById(@PathVariable(name = "id") ObjectId userId);

}
