package com.opussoftware.simpleapp.service;

import com.opussoftware.simpleapp.domain.User;
import com.opussoftware.simpleapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById(Integer id){
        Optional<User> object = repository.findById(id);
        return object.orElse(null);
    }
}