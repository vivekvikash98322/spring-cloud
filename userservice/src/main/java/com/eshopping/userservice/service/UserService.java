package com.eshopping.userservice.service;

import com.eshopping.userservice.dao.UserRepository;
import com.eshopping.userservice.model.User;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> createUser(List<User> users) {
        List<User> userSaved = this.userRepository.saveAll(users);
        return userSaved;
    }


    public Optional<User> getById(ObjectId id) {
        Optional<User> user =  userRepository.findById(id);
        return user;
    }
}
