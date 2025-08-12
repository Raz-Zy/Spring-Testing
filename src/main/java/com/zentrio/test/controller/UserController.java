package com.zentrio.test.controller;


import com.zentrio.test.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/test")
@RestController
public class UserController {
    private UserRepository userRepository;
    @GetMapping
    public String test(){
        return userRepository.getUserName();
    }
}
