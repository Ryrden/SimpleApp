package com.opussoftware.simpleapp;

import com.opussoftware.simpleapp.domain.User;
import com.opussoftware.simpleapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SimpleAppApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(SimpleAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User userOne = new User(null, "Ryan Souza", "Ryan", "123");
        User userTwo = new User(null, "Lourenço Henrique", "Lourenço", "123");

        userRepository.saveAll(Arrays.asList(userOne,userTwo));
    }
}
